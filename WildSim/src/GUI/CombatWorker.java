package GUI;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

import classes.stalker.StalkerLogPanel;
import combat.Combat;

public class CombatWorker extends SwingWorker<Object, Object> {
	
	KeyEventDispatcher blockingDispatcher;
	
	Combat testCombat;
	JProgressBar progress;
	StalkerLogPanel logPanel;
	StartStatWeightActionListener statweightlistener;
	JFrame mainFrame;
	
	public CombatWorker(Combat testCombat, StalkerLogPanel logPanel, JFrame mainFrame) {
		this.testCombat = testCombat;
		this.logPanel = logPanel;
		this.mainFrame = mainFrame;
		
		blockingDispatcher = new KeyEventDispatcher() {
			@Override
			public boolean dispatchKeyEvent(KeyEvent arg0) {
				return true;
			}
        };
        
	}
	
	public CombatWorker(Combat testCombat, StartStatWeightActionListener statweightlistener, StalkerLogPanel logPanel, JFrame mainFrame) {
		this.testCombat = testCombat;
		this.statweightlistener = statweightlistener;
		this.mainFrame = mainFrame;
		this.logPanel = logPanel;
	}

	@Override
	protected Object doInBackground() throws Exception {
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(blockingDispatcher);
		mainFrame.getGlassPane().addMouseListener(new MouseAdapter() {});
		mainFrame.getGlassPane().setVisible(true);
		mainFrame.getGlassPane().requestFocus();
		testCombat.run();
    	
		return null;
	}
	
	@Override
	protected void done() {
		KeyboardFocusManager.getCurrentKeyboardFocusManager().removeKeyEventDispatcher(blockingDispatcher);
		mainFrame.getGlassPane().setVisible(false);
		logPanel.requestFocus();
		
		
		if (statweightlistener != null) {
			statweightlistener.performNext();
		} else {
			logPanel.setValues();
		}
		
	}

}