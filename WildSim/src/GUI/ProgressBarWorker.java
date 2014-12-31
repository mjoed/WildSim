package GUI;

import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import classes.stalker.StalkerLogPanel;
import combat.Combat;

public class ProgressBarWorker extends SwingWorker<Object, Object> {
	
	Combat testCombat;
	JProgressBar progress;
	StalkerLogPanel logPanel;
	
	public ProgressBarWorker(Combat testCombat, JProgressBar progress, StalkerLogPanel logPanel) {
		this.testCombat = testCombat;
		this.progress = progress;
		this.logPanel = logPanel;
	}

	@Override
	protected Object doInBackground() throws Exception {
		try {
			Thread.sleep(50);
		} catch (InterruptedException f) {}
		            		
    	while (testCombat.getCurrTime() < testCombat.getMaxtime() && testCombat.getCurrTime() != 0) {
    		SwingUtilities.invokeLater(new Runnable() {
    			public void run() {
            		progress.setValue(testCombat.getCurrTime());
            	
    			}
    		});

    		try {
    			Thread.sleep(100);
    		} catch (InterruptedException f) {}
    	}
    	progress.setValue(0);    	
    	
		return null;
	}
	
}
