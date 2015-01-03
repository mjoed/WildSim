package helpers;

import javax.swing.JTextField;

import classes.Ability;

public class helpers {

	
	public static String msToString(int ms) {
		
		long millis = ms % 1000;
		long second = (ms / 1000) % 60;
		long minute = (ms / (1000 * 60)) % 60;
		long hour = (ms / (1000 * 60 * 60));

		String time = String.format("%04d:%02d:%02d:%03d", hour, minute, second, millis);
		
		return time;
	}
	
	public static float getCritSevRating(float critsev) {
		return -((14126 * critsev) / (7 * critsev - 5));
	}
	
	public static float getCritSevPercentage(float critsevrating) {
		return (critsevrating/(1.4f*critsevrating+2825f));
	}
	
	/**
	 * sets new priorities
	 * @param shredprio
	 * @param impaleprio
	 * @param ckprio
	 * @param ruinprio
	 * @param shred
	 * @param impale
	 * @param ck
	 * @param ruin
	 * @param newAbility (1 -> shred, 2 -> impale, 3 -> ck, 4 -> ruin)
	 */
	public static void setPriorities(JTextField shredprio, JTextField impaleprio, JTextField ckprio, JTextField ruinprio, Ability shred, Ability impale, Ability ck, Ability ruin, int newAbility) {
		Ability[] sortedpriolist = new Ability[4];
		Ability[] priofilltemp = new Ability[4];
		
		int currPos = 0;
		int newPos = 0;
		
		priofilltemp[0] = shred;
		priofilltemp[1] = ruin;
		priofilltemp[2] = impale;
		priofilltemp[3] = ck;
		
		for (int i = 0; i<priofilltemp.length; i++) {
			sortedpriolist[priofilltemp[i].getPrio()-1] = priofilltemp[i];
		}
		
		if (newAbility == 1) {
			newPos = Integer.parseInt(shredprio.getText())-1;
			for (int i = 0; i < sortedpriolist.length; i++) {
				if (sortedpriolist[i].getName() == "Shred") {
					currPos = i;
				}
			}
		} else if (newAbility == 2) {
			newPos = Integer.parseInt(impaleprio.getText())-1;
			for (int i = 0; i < sortedpriolist.length; i++) {
				if (sortedpriolist[i].getName() == "Impale") {
					currPos = i;
				}
			}
		} else if (newAbility == 3) {
			newPos = Integer.parseInt(ckprio.getText())-1;
			for (int i = 0; i < sortedpriolist.length; i++) {
				if (sortedpriolist[i].getName() == "CK") {
					currPos = i;
				}
			}
		} else if (newAbility == 4) {
			newPos = Integer.parseInt(ruinprio.getText())-1;
			for (int i = 0; i < sortedpriolist.length; i++) {
				if (sortedpriolist[i].getName() == "Ruin") {
					currPos = i;
				}
			}
		} else {
			return;
		}
		
		while (currPos != newPos) {
			if (currPos < newPos) {
				switchPriority(sortedpriolist[currPos], sortedpriolist[currPos+1]);
				currPos++;
			} else {
				switchPriority(sortedpriolist[currPos], sortedpriolist[currPos-1]);
				currPos--;
			}
			
			for (int i = 0; i<priofilltemp.length; i++) {
				sortedpriolist[priofilltemp[i].getPrio()-1] = priofilltemp[i];
			}
			
			
		}
		
		shredprio.setText(Integer.toString(shred.getPrio()));	
		impaleprio.setText(Integer.toString(impale.getPrio()));	
		ckprio.setText(Integer.toString(ck.getPrio()));	
		ruinprio.setText(Integer.toString(ruin.getPrio()));	
		
	}
	
	public static void switchPriority(Ability ability1, Ability ability2) {
		int newPrio1 = ability2.getPrio();
		int newPrio2 = ability1.getPrio();
		ability1.setPrio(newPrio1);
		ability2.setPrio(newPrio2);
	}
	
	

}
