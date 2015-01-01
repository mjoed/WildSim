package classes.stalker;

import java.awt.GridLayout;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import combat.Combat;
import classes.AMP;
import classes.Ability;
import classes.RaidBuff;
import classes.RaidDebuff;
import classes.RuneSet;
import classes.stalker.amps.CritSevAMP;

@SuppressWarnings("serial")
public class StalkerLogPanel extends JPanel {
	
	JTextArea log = new JTextArea();
	StringBuilder logstring;
	Combat combat;
	int maxtime;
	boolean statWeight;
	
	float baselinedps;
	float apdps;
	float critdps;
	float critsevdps;
	float strikethroughdps;
	
	
	public void setValues() {
		Ability[] abilities = combat.getPlayer().getAbilities();
		if (!statWeight) {
			
			//COMBAT PANEL
			logstring = new StringBuilder();
			maxtime = combat.getMaxtime();	
			logstring.append("Ability\tDPS\tHit%\tCrit%\tDeflect%\tSwings(2min)\n");
			Arrays.sort(abilities, Collections.reverseOrder());
			float totalAbilityHits;
			float overalltotalHits = 0;
			float overallHits = 0;
			float overallCrits = 0;
			float overallDeflects = 0;
			
			float dps;
			float twomindiff = maxtime / 120000;
			
			for (int i=0; i<abilities.length; i++) {
				dps = (abilities[i].amountCritDamage() + abilities[i].amountHitDamage())/(maxtime/1000);
				if (abilities[i] != null && dps != 0) {
					
					overalltotalHits += abilities[i].amountCrits() + abilities[i].amountHits() + abilities[i].amountDeflects();
					overallHits += abilities[i].amountHits();
					overallCrits += abilities[i].amountCrits();
					overallDeflects += abilities[i].amountDeflects();
					totalAbilityHits = abilities[i].amountCrits() + abilities[i].amountHits() + abilities[i].amountDeflects();
					
					dps = (abilities[i].amountCritDamage() + abilities[i].amountHitDamage())/(maxtime/1000);
					
					logstring.append(abilities[i].getName() + "\t" + String.format("%.2f", dps) + "\t" + String.format("%.2f", (float)((float)abilities[i].amountHits() * 100 / totalAbilityHits)) + "\t" + String.format("%.2f", (float)((float)abilities[i].amountCrits() * 100 / totalAbilityHits)) + "\t" + String.format("%.2f", (float)((float)abilities[i].amountDeflects() * 100 / totalAbilityHits)) + "\t" + String.format("%.0f", (float)(totalAbilityHits / twomindiff)) + "\n");
					
				}
			}
			
			logstring.append("\nOverall\t" + String.format("%.2f", combat.getDmgOverall()/(maxtime/1000)) + "\t" + String.format("%.2f", (float)((float)overallHits * 100 / overalltotalHits)) + "\t" + String.format("%.2f", (float)((float)overallCrits * 100 / overalltotalHits)) + "\t" + String.format("%.2f", (float)((float)overallDeflects * 100 / overalltotalHits)));

		} else {
			
			//STATWEIGHTPANEL
			logstring = new StringBuilder();
			maxtime = combat.getMaxtime();	
			logstring.append("Baseline: \t\t" + String.format("%.2f", baselinedps) + "\n+200*1.075 ap: \t\t" + String.format("%.2f", apdps) + "\n+200 crit: \t\t" + String.format("%.2f", critdps) + "\n+200 critsev: \t\t" + String.format("%.2f", critsevdps) + "\n+200 strikethrough: \t" + String.format("%.2f", strikethroughdps));
			logstring.append("\n\n");
			
			float apdiff = apdps - baselinedps;
			float critdiff = critdps - baselinedps;
			float critsevdiff = critsevdps - baselinedps;
			float strikethroughdiff = strikethroughdps - baselinedps;
			
			float critweight = critdiff * 10 / apdiff;
			float critsevweight = critsevdiff * 10 / apdiff;
			float strikethroughweight = strikethroughdiff * 10 / apdiff;
			
			logstring.append("AP Weight:\t\t10" + "\nCritRating Weight: \t" + String.format("%.3f", critweight) + "\nCritSevRating Weight: \t" + String.format("%.3f", critsevweight) + "\nStrikethroughRating Weight: \t" + String.format("%.3f", strikethroughweight));
			
			logstring.append("\n\n");
			
			float brutweight = 0.61f * 10;
			float moxieweight = (0.5f * critweight) + (0.5f * critsevweight);
			float finweight;
			if (strikethroughweight > 0) {
				finweight = (0.5f * strikethroughweight) + (0.5f * critsevweight);
			} else {
				finweight = (0.5f * critsevweight);
			}
			
			
			
			logstring.append("Brut Weight (with +15%): \t" + String.format("%.3f", brutweight) + " (" + String.format("%.3f", brutweight * 1.15) + ")");
			logstring.append("\nMoxie Weight: \t\t" + String.format("%.3f", moxieweight));
			logstring.append("\nFinesse Weight: \t" + String.format("%.3f", finweight));
			
			
			
		}
		
		
		//INPUT
		logstring.append("\n\nSTATS: ");
		combat.getPlayer().lastCheck();
		logstring.append("AP: " + combat.getPlayer().getAP() + ", Crit: " + combat.getPlayer().getCrit() + ", CritSev: " + combat.getPlayer().getCritSev() + ", Strikethrough: " + combat.getPlayer().getStrikethrough());
		logstring.append("\n\nACTIVE ABILITIES: ");
		int count = 0;
		for (int i = 0; i < abilities.length; i++) {
			if (abilities[i].isActive() && abilities[i].getName() != "FatalWounds" && abilities[i].getName() != "Devastate"&& abilities[i].getName() != "CutthroatHit" && abilities[i].getName() != "CK(first)" && abilities[i].getName() != "CK(add)" && abilities[i].getName() != "Shred(add)" && abilities[i].getName() != "RuinDot" && abilities[i].getName() != "SuckerHit" && abilities[i].getName() != "AssassinHit") {
				if (count%5 == 0 && count != 0) {
					logstring.append("\n");
				}
				logstring.append(abilities[i].getName() + " (T: " + abilities[i].getTier() + "), ");
				count++;
			}
		}
		logstring.append("\nACTIVE AMPS: ");
		AMP[] amps = combat.getPlayer().getAMPs();
		count = 0;
		for (int i = 0; i < amps.length; i++) {
			if (amps[i].isActive()) {
				if (count%5 == 0 && count != 0) {
					logstring.append("\n");
				}
				if (amps[i].getName() == "CritSevAMP") {
					CritSevAMP critsev = (CritSevAMP)amps[i];
					logstring.append(amps[i].getName() + " (" + critsev.getAmount() + "), ");
				} else {
					logstring.append(amps[i].getName() + ", ");
				}
				count++;
			}
		}
		logstring.append("\nACTIVE RUNESETS: ");
		RuneSet[] runesets = combat.getRuneSets();
		count = 0;
		for (int i = 0; i < runesets.length; i++) {
			if (runesets[i].isActive()) {
				if (count%5 == 0 && count != 0) {
					logstring.append("\n");
				}
				logstring.append(runesets[i].getName() + " " + runesets[i].getAmount() +  ", ");
				count++;
			}
		}
		logstring.append("\nACTIVE RAIDDEBUFFS: ");
		RaidDebuff[] raiddebuffs = combat.getRaidDebuffs();
		count = 0;
		for (int i = 0; i < raiddebuffs.length; i++) {
			if (raiddebuffs[i].isActive()) {
				if (count%5 == 0 && count != 0) {
					logstring.append("\n");
				}
				logstring.append(raiddebuffs[i].getName() + ", ");
				count++;
			}
		}
		logstring.append("\nACTIVE RAIDBUFFS: ");
		RaidBuff[] raidbuff = combat.getRaidBuffs();
		count = 0;
		for (int i = 0; i < raidbuff.length; i++) {
			if (raidbuff[i].isActive()) {
				if (count%5 == 0 && count != 0) {
					logstring.append("\n");
				}
				logstring.append(raidbuff[i].getName() + ", ");
				count++;
			}
		}
		
		log.setText(logstring.toString());
		
		this.add(log);
	}

	public StalkerLogPanel(Combat combat) {
		this.combat = combat;
		
		maxtime = combat.getMaxtime();
		this.setLayout(new GridLayout(1, 1));
		
		log.setEditable(false);
		this.add(log);
		
	}
	
	public void setStatWeight(boolean statWeight) {
		this.statWeight = statWeight;
	}
	
	public void setStatWeightValues(float baselinedps, float apdps, float critdps, float critsevdps, float strikethroughdps) {
		this.baselinedps = baselinedps;
		this.apdps = apdps;
		this.critdps = critdps;
		this.critsevdps = critsevdps;
		this.strikethroughdps = strikethroughdps;
	}

}
