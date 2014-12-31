package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	
	int step = 0;
	int internalstep = 0;
	
	public StartStatWeightActionListener(Combat testCombat, JProgressBar progress, StalkerLogPanel logPanel, JLabel statWeightProgress) {
		this.testCombat = testCombat;
		this.progress = progress;
		this.logPanel = logPanel;
		this.statWeightProgress = statWeightProgress;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		logPanel.setStatWeight(true);
		testCombat.setMaxtime(108000000);
//		testCombat.setMaxtime(36000000);
		
		
		statWeightProgress.setText("Baseline DPS Calc (1/3)");
		combatThread = new CombatWorker(testCombat, this);
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
				testCombat.getPlayer().setAP(testCombat.getPlayer().getAP() + 100);
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
				testCombat.getPlayer().setAP(testCombat.getPlayer().getAP() - 100);
				testCombat.getPlayer().setCrit(testCombat.getPlayer().getCrit() + ((100 * 0.0153846f) / 100));
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
				statWeightProgress.setText("");
				critdps3 = testCombat.getDmgOverall()/(testCombat.getMaxtime()/1000);
				testCombat.getPlayer().lastCheck();
				testCombat.getPlayer().setCrit(testCombat.getPlayer().getCrit() - ((100 * 0.0153846f) / 100));
				
				baselinedps = (baselinedps1+baselinedps2+baselinedps3) / 3;
				apdps = (apdps1+apdps2+apdps3) / 3;
				critdps = (critdps1+critdps2+critdps3) / 3;
				
				logPanel.setStatWeightValues(baselinedps, apdps, critdps);
				logPanel.setValues();
				step = 0;
				internalstep = 0;
				return;
			}
			
			
			
		} else if (step == 3) {
			return;
		} else {
			return;
		}
		
		combatThread = new CombatWorker(testCombat, this);
		progThread = new ProgressBarWorker(testCombat, progress, logPanel);
		
		progress.setMaximum(testCombat.getMaxtime());
		combatThread.execute();
		progThread.execute();
		
		
	}

}
