package classes.stalker;

import java.awt.GridLayout;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import combat.Combat;
import classes.Ability;

@SuppressWarnings("serial")
public class StalkerLogPanel extends JPanel {
	
	JTextArea log = new JTextArea();
	StringBuilder logstring;
	Combat combat;
	int maxtime;
	
	public void setValues() {
		logstring = new StringBuilder();
		maxtime = combat.getMaxtime();	
		logstring.append("Ability\tDPS\tHit%\tCrit%\tDeflect%\tSwings(2min)\n");
		
		Ability[] abilities = combat.getPlayer().getAbilities();
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
		
		logstring.append("\n");
		
		
		
		
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

}
