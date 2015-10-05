package GUI;


import inout.In;
import inout.Out;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;






import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import classes.stalker.StalkerLogPanel;
import classes.stalker.StalkerOptionPanel;
import combat.Combat;

public class WildSimGUI {

	private JButton startButton;
	private JButton startStatWeightButton;
	private JPanel generalPanel;
	private StatPanel statPanel;
	private TargetPanel targetPanel;
	private StalkerOptionPanel classPanel;
	private RaidBuffPanel raidbuffPanel;
	private RuneSetPanel runesetPanel;
	private JTabbedPane leftTabPane;
	private StalkerLogPanel logPanel;
	private JPanel centerPanel;
	private JFrame mainFrame;
	private JLabel statWeightProgress;
		
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
		mainFrame.addWindowListener(new java.awt.event.WindowAdapter() {
	        public void windowClosing(WindowEvent winEvt) {
	            saveFile(true);
	            System.exit(0);
	        }
	    });
		
		
		mainFrame.setTitle("WildSim");		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		progress = new JProgressBar(0, testCombat.getMaxtime());
		progress.setStringPainted(true);
		//main menu bar
		JMenuBar menu = new JMenuBar();
		mainFrame.setJMenuBar(menu);
		
		JMenu generalMenu = new JMenu("WildSim");
		menu.add(generalMenu);
		JMenuItem importMenu = new JMenuItem("Import Stats");
		generalMenu.add(importMenu);
		importMenu.addActionListener(e -> {
			loadFile(false);
		});
		
		JMenuItem exportMenu = new JMenuItem("Export Stats");
		generalMenu.add(exportMenu);
		exportMenu.addActionListener(e -> {
			saveFile(false);
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
		
		logPanel = new StalkerLogPanel(testCombat, testCombat.getCombatLog());
		statWeightProgress = new JLabel("");
		
		startButton = new JButton("Start");
		startButton.addActionListener(new StartCombatActionListener(testCombat, progress, logPanel, mainFrame));
		
		startStatWeightButton = new JButton("StatWeight Calc");
		startStatWeightButton.addActionListener(new StartStatWeightActionListener(testCombat, progress, logPanel, statWeightProgress, mainFrame));
		
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
		
		JCheckBox resregbox = new JCheckBox();
		resregbox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (resregbox.isSelected()) {
					testCombat.getPlayer().setResourceCombatLog(1);
				} else {
					testCombat.getPlayer().setResourceCombatLog(0);
				}
			}
		});
		if (testCombat.getPlayer().getResourceCombatLog() > 0) {
			resregbox.setSelected(true);
		} else {
			resregbox.setSelected(false);
		}
		JLabel resreg = new JLabel("Include Resource");
		resregbox.setVisible(testCombat.getCombatlogactive());
		resreg.setVisible(testCombat.getCombatlogactive());
		
		
		
		JCheckBox buffbox = new JCheckBox();
		buffbox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (buffbox.isSelected()) {
					testCombat.getCombatLog().setBufflog(true);
				} else {
					testCombat.getCombatLog().setBufflog(false);
				}
			}
		});
		buffbox.setSelected(testCombat.getCombatLog().getBufflog());
		JLabel buff = new JLabel("Include Buffs");
		buffbox.setVisible(testCombat.getCombatlogactive());
		buff.setVisible(testCombat.getCombatlogactive());
		
		
		
		
		JCheckBox combatlogBox = new JCheckBox();
		combatlogBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (combatlogBox.isSelected()) {
					testCombat.setCombatlogactive(true);
					resregbox.setVisible(true);
					resreg.setVisible(true);
					buffbox.setVisible(true);
					buff.setVisible(true);
					
				} else {
					testCombat.setCombatlogactive(false);
					resregbox.setVisible(false);
					resreg.setVisible(false);
					buffbox.setVisible(false);
					buff.setVisible(false);
					testCombat.getCombatLog().setBufflog(false);
					testCombat.getPlayer().setResourceCombatLog(0);
					buffbox.setSelected(false);
					resregbox.setSelected(false);
				}
			}
		});
		combatlogBox.setSelected(testCombat.getCombatlogactive());
		JLabel createCombatlog = new JLabel("Create Combatlog");
		
		toolBar.add(startButton);
		toolBar.add(maxTime);
		toolBar.add(maxTimeinsert);
		toolBar.add(progress);
		toolBar.add(startStatWeightButton);
		toolBar.add(statWeightProgress);
		toolBar.add(combatlogBox);
		toolBar.add(createCombatlog);
		toolBar.add(buffbox);
		toolBar.add(buff);
		toolBar.add(resregbox);
		toolBar.add(resreg);
		
		mainFrame.add(toolBar, BorderLayout.NORTH);
				
		generalPanel = new JPanel(new GridLayout(1, 3));
		
		
		statPanel = new StatPanel(testCombat.getPlayer());
		targetPanel = new TargetPanel(testCombat.getTarget());
		classPanel = new StalkerOptionPanel(testCombat.getPlayer());
		raidbuffPanel = new RaidBuffPanel(testCombat);
		runesetPanel = new RuneSetPanel(testCombat);
				
		generalPanel.add(statPanel);
		generalPanel.add(targetPanel);
		
		
		leftTabPane = new JTabbedPane();
		leftTabPane.addTab("RaidBuffs/Debuffs", raidbuffPanel);
		leftTabPane.addTab("Player/Target Stats", generalPanel);
		leftTabPane.addTab("Ability/AMP", classPanel);
		leftTabPane.addTab("Rune Sets/Fusion", runesetPanel);
		
		
		JPanel rightPanel = new JPanel(new GridLayout(1, 1));
		rightPanel.add(logPanel);
		
		centerPanel = new JPanel(new GridLayout(1, 2));
		centerPanel.add(leftTabPane);
		centerPanel.add(rightPanel);
		
		
		
		mainFrame.add(centerPanel, BorderLayout.CENTER);
		
		loadFile(true);
	}
	
	public void run() {
		mainFrame.setLocation(400, 200);
		mainFrame.pack();
		mainFrame.setVisible(true);
		mainFrame.setResizable(false);
	}
		
	public static void main(String[] args) {
		WildSimGUI app = new WildSimGUI();
		app.run();
	}
	
	private void saveFile(boolean shutdown) {
		if (shutdown) {
			File file;
			file = new File(System.getProperty("user.dir") + "\\lastUsed.wildsim");
			
			if (file.exists()) {
				file.delete();
			}

			Out.open(file.getAbsolutePath());
			Out.print(raidbuffPanel.getCurrentValues());
			Out.print(statPanel.getCurrentValues());
			Out.print(targetPanel.getCurrentValues());
			Out.print(classPanel.getCurrentValues());
			Out.print(runesetPanel.getCurrentValues());
			
			Out.close();
		} else {
			JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));
			chooser.setFileFilter(new FileNameExtensionFilter("*.wildsim", "wildsim"));
			if (chooser.showSaveDialog(mainFrame) == JFileChooser.APPROVE_OPTION) {
				File file;
				if (chooser.getSelectedFile().getAbsolutePath().contains(".")) {
					String exttest = chooser.getSelectedFile().getName().substring(chooser.getSelectedFile().getName().lastIndexOf("."));
					if (!exttest.equals(".wildsim")) {
						file = new File(chooser.getSelectedFile().getAbsolutePath() + ".wildsim");
						} else {
							file = chooser.getSelectedFile();
						}
				} else {
					file = new File(chooser.getSelectedFile().getAbsolutePath() + ".wildsim");
				}
				if (file.exists()) {
					if (JOptionPane.showConfirmDialog(mainFrame, "overwrite existing file?", "file already exists", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						file.delete();
					} else {
						return;
					}
				}

				Out.open(file.getAbsolutePath());
				Out.print(raidbuffPanel.getCurrentValues());
				Out.print(statPanel.getCurrentValues());
				Out.print(targetPanel.getCurrentValues());
				Out.print(classPanel.getCurrentValues());
				Out.print(runesetPanel.getCurrentValues());
				
				Out.close();
			}
		
		}
	}
	
	private void loadFile(boolean startup) {
		if (startup) {
			File file;
			file = new File(System.getProperty("user.dir") + "\\lastUsed.wildsim");
			if (!file.exists()) {
				return;
			} else {
				
				In.open(file.getAbsolutePath());
				raidbuffPanel.setCurrentValues(In.readLine());
				statPanel.setCurrentValues(In.readLine());
				targetPanel.setCurrentValues(In.readLine());
				classPanel.setCurrentValues(In.readLine());
				runesetPanel.setCurrentValues(In.readLine());
				
				In.close();
				
			}
			
			
			
		} else {
			String file;
			JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));
			chooser.setFileFilter(new FileNameExtensionFilter("*.wildsim", "wildsim"));

			if (chooser.showOpenDialog(mainFrame) == JFileChooser.APPROVE_OPTION) {
				file = chooser.getSelectedFile().getAbsolutePath();
				In.open(file);
				raidbuffPanel.setCurrentValues(In.readLine());
				statPanel.setCurrentValues(In.readLine());
				targetPanel.setCurrentValues(In.readLine());
				classPanel.setCurrentValues(In.readLine());
				runesetPanel.setCurrentValues(In.readLine());
				
				In.close();
			}
		}
	}
}
