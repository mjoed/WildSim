package GUI;

import helpers.helpers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import classes.stalker.StalkerLogPanel;
import combat.Combat;

public class StartStatWeightActionListener implements ActionListener {

	Combat testCombat;
	JProgressBar progress;
	StalkerLogPanel logPanel;
	CombatWorker combatThread;
	ProgressBarWorker progThread;
	JLabel statWeightProgress;
	JFrame mainFrame;
	
	int oldMaxTime;
	
	float baselinedps;
	float baselinedps1;
	float baselinedps2;
	float baselinedps3;
	float apdps;
	float apdps1;
	float apdps2;
	float apdps3;
	float critdps;
	float critdps1;
	float critdps2;
	float critdps3;
	float critsevdps;
	float critsevdps1;
	float critsevdps2;
	float critsevdps3;
	float strikethroughdps;
	float strikethroughdps1;
	float strikethroughdps2;
	float strikethroughdps3;
	
	float critsevrating;
	float critsevampamount = 0.12f;
	
	int step = 0;
	int internalstep = 0;
	int statIncrease = 200;
	
	public StartStatWeightActionListener(Combat testCombat, JProgressBar progress, StalkerLogPanel logPanel, JLabel statWeightProgress, JFrame mainFrame) {
		this.testCombat = testCombat;
		this.progress = progress;
		this.logPanel = logPanel;
		this.statWeightProgress = statWeightProgress;
		this.mainFrame = mainFrame;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		//start
		logPanel.setStatWeight(true);
		oldMaxTime = testCombat.getMaxtime();
//		testCombat.setMaxtime(360000000);
		testCombat.setMaxtime(3600000);
		critsevampamount = testCombat.getPlayer().getCritSevAMP().getAmount();
		
		
		statWeightProgress.setText("Baseline DPS Calc (1/3)");
		combatThread = new CombatWorker(testCombat, this, logPanel, mainFrame);
		progThread = new ProgressBarWorker(testCombat, progress, logPanel);
		
		progress.setMaximum(testCombat.getMaxtime());
		combatThread.execute();
		progThread.execute();
		internalstep++;
	}
	
	
	public void performNext() {
		if (step == 0) {
			if (internalstep < 3) {
				statWeightProgress.setText("Baseline DPS Calc (" + (internalstep+1) + "/3)");
				if (internalstep == 1) baselinedps1 = testCombat.getDmgOverall()/(testCombat.getMaxtime()/1000);
				if (internalstep == 2) baselinedps2 = testCombat.getDmgOverall()/(testCombat.getMaxtime()/1000);
				internalstep++;
			} else {
				baselinedps3 = testCombat.getDmgOverall()/(testCombat.getMaxtime()/1000);
				statWeightProgress.setText("AP DPS Calc (1/3)");
				testCombat.getPlayer().lastCheck();
				testCombat.getPlayer().setAP(testCombat.getPlayer().getAP() + statIncrease*1.075f);
				internalstep = 1;
				step++;
			}
		} else if (step == 1) {
			if (internalstep < 3) {
				if (internalstep == 1) apdps1 = testCombat.getDmgOverall()/(testCombat.getMaxtime()/1000);
				if (internalstep == 2) apdps2 = testCombat.getDmgOverall()/(testCombat.getMaxtime()/1000);
				statWeightProgress.setText("AP DPS Calc (" + (internalstep+1) + "/3)");
				internalstep++;
			} else {
				apdps3 = testCombat.getDmgOverall()/(testCombat.getMaxtime()/1000);
				statWeightProgress.setText("Crit DPS Calc (1/3)");
				testCombat.getPlayer().lastCheck();
				testCombat.getPlayer().setAP(testCombat.getPlayer().getAP() - statIncrease*1.075f);
				testCombat.getPlayer().setCrit(testCombat.getPlayer().getCrit() + ((statIncrease * 0.0153846f) / 100));
				internalstep = 1;
				step++;
			}
			
			
		} else if (step == 2) {
			if (internalstep < 3) {
				if (internalstep == 1) critdps1 = testCombat.getDmgOverall()/(testCombat.getMaxtime()/1000);
				if (internalstep == 2) critdps2 = testCombat.getDmgOverall()/(testCombat.getMaxtime()/1000);
				statWeightProgress.setText("Crit DPS Calc (" + (internalstep+1) + "/3)");
				internalstep++;
			} else {
				critdps3 = testCombat.getDmgOverall()/(testCombat.getMaxtime()/1000);
				statWeightProgress.setText("Crit Sev DPS Calc (1/3)");
				testCombat.getPlayer().lastCheck();
				testCombat.getPlayer().setCrit(testCombat.getPlayer().getCrit() - ((statIncrease * 0.0153846f) / 100));
				//add critsev rating
				critsevrating = helpers.getCritSevRating(testCombat.getPlayer().getCritSev() - 1.5f - critsevampamount);
				critsevrating += statIncrease;
				testCombat.getPlayer().setCritSev(1.5f + critsevampamount + helpers.getCritSevPercentage(critsevrating));
				internalstep = 1;
				step++;
			}
			
			
			
		} else if (step == 3) {
			if (internalstep < 3) {
				if (internalstep == 1) critsevdps1 = testCombat.getDmgOverall()/(testCombat.getMaxtime()/1000);
				if (internalstep == 2) critsevdps2 = testCombat.getDmgOverall()/(testCombat.getMaxtime()/1000);
				statWeightProgress.setText("Crit Sev DPS Calc (" + (internalstep+1) + "/3)");
				internalstep++;
			} else {
				critsevdps3 = testCombat.getDmgOverall()/(testCombat.getMaxtime()/1000);
				statWeightProgress.setText("Strikethrough DPS Calc (1/3)");
				testCombat.getPlayer().lastCheck();
				critsevrating -= statIncrease;
				testCombat.getPlayer().setCritSev(1.5f + critsevampamount + helpers.getCritSevPercentage(critsevrating));
				testCombat.getPlayer().setStrikethrough(testCombat.getPlayer().getStrikethrough() + ((statIncrease * 0.0076957f) / 100));
				internalstep = 1;
				step++;
			}
			
			
		} else if (step == 4) {
			if (internalstep < 3) {
				if (internalstep == 1) strikethroughdps1 = testCombat.getDmgOverall()/(testCombat.getMaxtime()/1000);
				if (internalstep == 2) strikethroughdps2 = testCombat.getDmgOverall()/(testCombat.getMaxtime()/1000);
				statWeightProgress.setText("Strikethrough DPS Calc (" + (internalstep+1) + "/3)");
				internalstep++;
			} else {
				statWeightProgress.setText("");
				strikethroughdps3 = testCombat.getDmgOverall()/(testCombat.getMaxtime()/1000);
				testCombat.getPlayer().lastCheck();
				testCombat.getPlayer().setStrikethrough(testCombat.getPlayer().getStrikethrough() - ((statIncrease * 0.0076957f) / 100));
				
				baselinedps = (baselinedps1+baselinedps2+baselinedps3) / 3;
				apdps = (apdps1+apdps2+apdps3) / 3;
				critdps = (critdps1+critdps2+critdps3) / 3;
				critsevdps = (critsevdps1+critsevdps2+critsevdps3) / 3;
				strikethroughdps = (strikethroughdps1+strikethroughdps2+strikethroughdps3) / 3;
				
				logPanel.setStatWeightValues(baselinedps, apdps, critdps, critsevdps, strikethroughdps);
				logPanel.setValues();
				step = 0;
				internalstep = 0;
				testCombat.setMaxtime(oldMaxTime);
				
				return;
			}
		}
		
		
		//strikethrough * 0.0076957f;
		
		combatThread = new CombatWorker(testCombat, this, logPanel, mainFrame);
		progThread = new ProgressBarWorker(testCombat, progress, logPanel);
		
		progress.setMaximum(testCombat.getMaxtime());
		combatThread.execute();
		progThread.execute();
		
		
	}

}
