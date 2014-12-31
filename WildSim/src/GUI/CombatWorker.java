package GUI;

import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

import classes.stalker.StalkerLogPanel;
import combat.Combat;

public class CombatWorker extends SwingWorker<Object, Object> {
	
	Combat testCombat;
	JProgressBar progress;
	StalkerLogPanel logPanel;
	StartStatWeightActionListener statweightlistener;
	
	public CombatWorker(Combat testCombat, StalkerLogPanel logPanel) {
		this.testCombat = testCombat;
		this.logPanel = logPanel;
	}
	
	public CombatWorker(Combat testCombat, StartStatWeightActionListener statweightlistener) {
		this.testCombat = testCombat;
		this.statweightlistener = statweightlistener;
	}

	@Override
	protected Object doInBackground() throws Exception {
		testCombat.run();
    	
		return null;
	}
	
	@Override
	protected void done() {
		if (statweightlistener != null) {
			statweightlistener.performNext();
		} else {
			logPanel.setValues();
		}
	}

}