package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

import classes.stalker.StalkerLogPanel;
import combat.Combat;

public class StartCombatActionListener implements ActionListener {

	Combat testCombat;
	JProgressBar progress;
	StalkerLogPanel logPanel;
	CombatWorker combatThread;
	JFrame mainFrame;
	
	public StartCombatActionListener(Combat testCombat, JProgressBar progress, StalkerLogPanel logPanel, JFrame mainFrame) {
		this.testCombat = testCombat;
		this.progress = progress;
		this.logPanel = logPanel;
		this.mainFrame = mainFrame;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		logPanel.setStatWeight(false);
		combatThread = new CombatWorker(testCombat, logPanel, mainFrame);
		
		
		ProgressBarWorker progthread = new ProgressBarWorker(testCombat, progress, logPanel);
		
		progress.setMaximum(testCombat.getMaxtime());
		combatThread.execute();
		progthread.execute();
		
	}

}
