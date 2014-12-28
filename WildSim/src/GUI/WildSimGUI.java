package GUI;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import classes.stalker.StalkerLogPanel;
import classes.stalker.StalkerOptionPanel;
import combat.Combat;

public class WildSimGUI {

	private JButton startButton;
	private JPanel generalPanel;
	private JPanel statPanel;
	private JPanel targetPanel;
	private JPanel classPanel;
	private JPanel raidbuffPanel;
	private StalkerLogPanel logPanel;
	private JPanel centerPanel;
	private JFrame mainFrame;
	
	private JProgressBar progress;
	
	Thread combatThread;
	Combat testCombat;
	
	public WildSimGUI() {
		super();		
		testCombat = new Combat();
		combatThread = new Thread(testCombat);
		mainFrame = new JFrame();
		setup();
	}
	
	private void setup() {
		mainFrame.setTitle("WildSim");		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		progress = new JProgressBar(0, testCombat.getMaxtime());
		progress.setStringPainted(true);
		//main menu bar
		JMenuBar menu = new JMenuBar();
		mainFrame.setJMenuBar(menu);
		
		JMenu generalMenu = new JMenu("WildSim");
		menu.add(generalMenu);
		JMenuItem importMenu = new JMenuItem("Import");
		generalMenu.add(importMenu);
		importMenu.addActionListener(e -> {
			
		});
		
		JMenuItem exitGame = new JMenuItem("Exit");
		generalMenu.add(exitGame);
		exitGame.addActionListener(e -> {
			mainFrame.dispose();
		});
		
		JMenu classSwitcher = new JMenu("Class");
		menu.add(classSwitcher);
		JMenuItem stalker = new JMenuItem("Stalker");
		classSwitcher.add(stalker);
		
		
		
		JPanel toolBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		startButton = new JButton("Start");
		startButton.addActionListener(e -> {
			
			Thread progthread = new Thread(){
				public void run() {
            		try {
            			Thread.sleep(50);
            		} catch (InterruptedException f) {}
            		            		
                	while (testCombat.getCurrTime() < testCombat.getMaxtime() && testCombat.getCurrTime() != 0) {
                		SwingUtilities.invokeLater(new Runnable() {
                			public void run() {
                				System.out.println(testCombat.getCurrTime());
	                    		progress.setValue(testCombat.getCurrTime());
	                    	
                			}
                		});

                		try {
                			Thread.sleep(100);
                		} catch (InterruptedException f) {}
                	}
                	progress.setValue(0);
                	logPanel.setValues();		
        			combatThread = new Thread(testCombat);
				}
			};
			
			progress.setMaximum(testCombat.getMaxtime());
			combatThread.start();
			progthread.start();
			
					
		});
		
		JLabel maxTime = new JLabel("RunTime (h): ");
		JTextField maxTimeinsert = new JTextField(Integer.toString(testCombat.getMaxtime() / 3600000));
		maxTimeinsert.setPreferredSize(new Dimension(50, 20));
		maxTimeinsert.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				testCombat.setMaxtime(Integer.parseInt(maxTimeinsert.getText()) * 3600000);
			}
		});
		
		

		toolBar.add(startButton);
		toolBar.add(maxTime);
		toolBar.add(maxTimeinsert);
		toolBar.add(progress);
		
		
		mainFrame.add(toolBar, BorderLayout.NORTH);
		
		generalPanel = new JPanel(new GridLayout(1, 3));
		
		
		statPanel = new StatPanel(testCombat.getPlayer());
		targetPanel = new TargetPanel(testCombat.getTarget());
		classPanel = new StalkerOptionPanel(testCombat.getPlayer());
		raidbuffPanel = new RaidBuffPanel(testCombat);
		logPanel = new StalkerLogPanel(testCombat);
				
		generalPanel.add(statPanel);
		generalPanel.add(targetPanel);
		
		
		JPanel leftPanel = new JPanel(new GridLayout(1, 1));
		leftPanel.add(raidbuffPanel);
		JPanel midPanel = new JPanel(new GridLayout(2, 1));
		midPanel.add(generalPanel);
		midPanel.add(classPanel);
		JPanel rightPanel = new JPanel(new GridLayout(1, 1));
		rightPanel.add(logPanel);
		
		centerPanel = new JPanel(new GridLayout(1, 3));
		centerPanel.add(leftPanel);
		centerPanel.add(midPanel);
		centerPanel.add(rightPanel);
		
		
		
		mainFrame.add(centerPanel, BorderLayout.CENTER);
	}
	
	public void run() {
		mainFrame.setLocation(400, 200);
		mainFrame.pack();
		mainFrame.setVisible(true);
		mainFrame.setResizable(true);
	}
		
	public static void main(String[] args) {
		WildSimGUI app = new WildSimGUI();
		app.run();
	}

}
