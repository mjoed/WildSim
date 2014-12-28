package classes.stalker;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import classes.WildstarClass;

@SuppressWarnings("serial")
public class StalkerOptionPanel extends JPanel {

	public StalkerOptionPanel(WildstarClass player) {
		Stalker stalker = (Stalker)player;
		
		//########
		//Abilities
		
		JPanel abilities = new JPanel(new GridLayout(12, 3));
		
		JLabel abilities1 = new JLabel("Active");
		JLabel abilities2 = new JLabel("Abilities");
		JLabel abilities3 = new JLabel("Tier");
		
		//#
		JCheckBox shredbox = new JCheckBox();
		shredbox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (shredbox.isSelected()) {
					stalker.getShred().setActive(true);
					stalker.getShredAdd().setActive(true);
				} else {
					stalker.getShred().setActive(false);
					stalker.getShredAdd().setActive(false);
				}
			}
		});
		shredbox.setSelected(stalker.getShred().isActive());
		JLabel shred = new JLabel("Shred: ");
		JTextField shredinsert = new JTextField(Integer.toString(stalker.getShred().getTier()));
		shredinsert.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				stalker.getShred().setTier(Integer.parseInt(shredinsert.getText()));
			}
		});
		
		//#
		JCheckBox impalebox = new JCheckBox();
		impalebox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (impalebox.isSelected()) {
					stalker.getImpale().setActive(true);
				} else {
					stalker.getImpale().setActive(false);
				}
			}
		});
		impalebox.setSelected(stalker.getImpale().isActive());
		JLabel impale = new JLabel("Impale: ");
		JTextField impaleinsert = new JTextField(Integer.toString(stalker.getImpale().getTier()));
		impaleinsert.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				stalker.getImpale().setTier(Integer.parseInt(impaleinsert.getText()));
			}
		});
		
		//#
		JCheckBox punishbox = new JCheckBox();
		punishbox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (punishbox.isSelected()) {
					stalker.getPunish().setActive(true);
				} else {
					stalker.getPunish().setActive(false);
				}
			}
		});
		punishbox.setSelected(stalker.getPunish().isActive());
		JLabel punish = new JLabel("Punish: ");
		JTextField punishinsert = new JTextField(Integer.toString(stalker.getPunish().getTier()));
		punishinsert.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				stalker.getPunish().setTier(Integer.parseInt(punishinsert.getText()));
			}
		});
		
		//#
		JCheckBox ckbox = new JCheckBox();
		ckbox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (ckbox.isSelected()) {
					stalker.getCK().setActive(true);
					stalker.getCKadd().setActive(true);
					stalker.getCKFirst().setActive(true);
				} else {
					stalker.getCK().setActive(false);
					stalker.getCKadd().setActive(false);
					stalker.getCKFirst().setActive(false);
				}
			}
		});
		ckbox.setSelected(stalker.getCK().isActive());
		JLabel ck = new JLabel("CK: ");
		JTextField ckinsert = new JTextField(Integer.toString(stalker.getCK().getTier()));
		ckinsert.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				stalker.getCK().setTier(Integer.parseInt(ckinsert.getText()));
			}
		});
		
		//#
		JCheckBox AWbox = new JCheckBox();
		AWbox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (AWbox.isSelected()) {
					stalker.getAW().setActive(true);
				} else {
					stalker.getAW().setActive(false);
				}
			}
		});
		AWbox.setSelected(stalker.getAW().isActive());
		JLabel AW = new JLabel("AW: ");
		JTextField AWinsert = new JTextField(Integer.toString(stalker.getAW().getTier()));
		AWinsert.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				stalker.getAW().setTier(Integer.parseInt(AWinsert.getText()));
			}
		});
		
		//#
		JCheckBox prepbox = new JCheckBox();
		prepbox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (prepbox.isSelected()) {
					stalker.getPreparation().setActive(true);
				} else {
					stalker.getPreparation().setActive(false);
				}
			}
		});
		prepbox.setSelected(stalker.getPreparation().isActive());
		JLabel prep = new JLabel("Prep.: ");
		JTextField prepinsert = new JTextField(Integer.toString(stalker.getPreparation().getTier()));
		prepinsert.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				stalker.getPreparation().setTier(Integer.parseInt(prepinsert.getText()));
			}
		});
		
		//#
		JCheckBox collapsebox = new JCheckBox();
		collapsebox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (collapsebox.isSelected()) {
					stalker.getCollapse().setActive(true);
				} else {
					stalker.getCollapse().setActive(false);
				}
			}
		});
		collapsebox.setSelected(stalker.getCollapse().isActive());
		JLabel collapse = new JLabel("Collapse: ");
		JTextField collapseinsert = new JTextField(Integer.toString(stalker.getCollapse().getTier()));
		collapseinsert.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				stalker.getCollapse().setTier(Integer.parseInt(collapseinsert.getText()));
			}
		});
		
		//#
		JCheckBox staggerbox = new JCheckBox();
		staggerbox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (staggerbox.isSelected()) {
					stalker.getStagger().setActive(true);
				} else {
					stalker.getStagger().setActive(false);
				}
			}
		});
		staggerbox.setSelected(stalker.getStagger().isActive());
		JLabel stagger = new JLabel("Stagger: ");
		JTextField staggerinsert = new JTextField(Integer.toString(stalker.getStagger().getTier()));
		staggerinsert.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				stalker.getStagger().setTier(Integer.parseInt(staggerinsert.getText()));
			}
		});
		
		//#
		JCheckBox tretreatbox = new JCheckBox();
		tretreatbox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (tretreatbox.isSelected()) {
					stalker.getTacticalRetreat().setActive(true);
				} else {
					stalker.getTacticalRetreat().setActive(false);
				}
			}
		});
		tretreatbox.setSelected(stalker.getTacticalRetreat().isActive());
		JLabel tretreat = new JLabel("Use T. Retreat");
		JTextField tretreatinsert = new JTextField();
		tretreatinsert.setEditable(false);
		
		//#
		JCheckBox ruinbox = new JCheckBox();
		ruinbox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (ruinbox.isSelected()) {
					stalker.getRuin().setActive(true);
					stalker.getRuinDot().setActive(true);
				} else {
					stalker.getRuin().setActive(false);
					stalker.getRuinDot().setActive(false);
				}
			}
		});
		ruinbox.setSelected(stalker.getRuin().isActive());
		JLabel ruin = new JLabel("Ruin: ");
		JTextField ruininsert = new JTextField(Integer.toString(stalker.getRuin().getTier()));
		ruininsert.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				stalker.getRuin().setTier(Integer.parseInt(ruininsert.getText()));
			}
		});
		
		//#
		JCheckBox innatebox = new JCheckBox();
		innatebox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (innatebox.isSelected()) {
					stalker.getInnate().setActive(true);
				} else {
					stalker.getInnate().setActive(false);
				}
			}
		});
		innatebox.setSelected(stalker.getInnate().isActive());
		JLabel innate = new JLabel("Use Innate");
		JTextField innateinsert = new JTextField();
		innateinsert.setEditable(false);
				
		abilities.add(abilities1);
		abilities.add(abilities2);
		abilities.add(abilities3);
		abilities.add(shredbox);
		abilities.add(shred);
		abilities.add(shredinsert);
		abilities.add(impalebox);
		abilities.add(impale);
		abilities.add(impaleinsert);
		abilities.add(punishbox);
		abilities.add(punish);
		abilities.add(punishinsert);
		abilities.add(ckbox);
		abilities.add(ck);
		abilities.add(ckinsert);
		abilities.add(AWbox);
		abilities.add(AW);
		abilities.add(AWinsert);
		abilities.add(prepbox);
		abilities.add(prep);
		abilities.add(prepinsert);
		abilities.add(collapsebox);
		abilities.add(collapse);
		abilities.add(collapseinsert);
		abilities.add(staggerbox);
		abilities.add(stagger);
		abilities.add(staggerinsert);
		abilities.add(ruinbox);
		abilities.add(ruin);
		abilities.add(ruininsert);
		abilities.add(tretreatbox);
		abilities.add(tretreat);
		abilities.add(tretreatinsert);
		abilities.add(innatebox);
		abilities.add(innate);
		abilities.add(innateinsert);
		
		
		//########
		//AMPs
		
		JPanel ampboxes = new JPanel(new GridLayout(11, 1));
		JPanel amps = new JPanel(new GridLayout(11, 1));
		
		JLabel amps1 = new JLabel("Active");
		JLabel amps2 = new JLabel("AMPs");
		
		JCheckBox cutthroatbox = new JCheckBox();
		cutthroatbox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (cutthroatbox.isSelected()) {
					stalker.getCutthroat().setActive(true);
				} else {
					stalker.getCutthroat().setActive(false);
				}
			}
		});
		cutthroatbox.setSelected(stalker.getCutthroat().isActive());
		JLabel cutthroat = new JLabel("Cutthroat");
		
		//#
		JCheckBox enablerbox = new JCheckBox();
		enablerbox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (enablerbox.isSelected()) {
					stalker.getEnabler().setActive(true);
				} else {
					stalker.getEnabler().setActive(false);
				}
			}
		});
		enablerbox.setSelected(stalker.getEnabler().isActive());
		JLabel enabler = new JLabel("Enabler");
		
		//#
		JCheckBox devastatebox = new JCheckBox();
		devastatebox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (devastatebox.isSelected()) {
					stalker.getDevastate().setActive(true);
				} else {
					stalker.getDevastate().setActive(false);
				}
			}
		});
		devastatebox.setSelected(stalker.getDevastate().isActive());
		JLabel devastate = new JLabel("Devastate");
		
		//#
		JCheckBox stealthmasterbox = new JCheckBox();
		stealthmasterbox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (stealthmasterbox.isSelected()) {
					stalker.getStealthMastery().setActive(true);
				} else {
					stalker.getStealthMastery().setActive(false);
				}
			}
		});
		stealthmasterbox.setSelected(stalker.getStealthMastery().isActive());
		JLabel stealthmastery = new JLabel("Stealth Mastery");
		
		//#
		JCheckBox unfairadvantagebox = new JCheckBox();
		unfairadvantagebox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (unfairadvantagebox.isSelected()) {
					stalker.getUnfairAdvantage().setActive(true);
				} else {
					stalker.getUnfairAdvantage().setActive(false);
				}
			}
		});
		unfairadvantagebox.setSelected(stalker.getUnfairAdvantage().isActive());
		JLabel unfairadvantage = new JLabel("Unfair Advantage");
		
		//#
		JCheckBox ripostebox = new JCheckBox();
		ripostebox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (ripostebox.isSelected()) {
					stalker.getRiposte().setActive(true);
				} else {
					stalker.getRiposte().setActive(false);
				}
			}
		});
		ripostebox.setSelected(stalker.getRiposte().isActive());
		JLabel riposte = new JLabel("Riposte");
		
		//#
		JCheckBox fatalwoundsbox = new JCheckBox();
		fatalwoundsbox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (fatalwoundsbox.isSelected()) {
					stalker.getFatalWounds().setActive(true);
				} else {
					stalker.getFatalWounds().setActive(false);
				}
			}
		});
		fatalwoundsbox.setSelected(stalker.getFatalWounds().isActive());
		JLabel fatalwounds = new JLabel("Fatal Wounds");
		
		//#
		JCheckBox onslaughtbox = new JCheckBox();
		onslaughtbox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (onslaughtbox.isSelected()) {
					stalker.getOnslaught().setActive(true);
				} else {
					stalker.getOnslaught().setActive(false);
				}
			}
		});
		onslaughtbox.setSelected(stalker.getOnslaught().isActive());
		JLabel onslaught = new JLabel("Onslaught");
		
		//#
		JCheckBox battlemastbox = new JCheckBox();
		battlemastbox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (battlemastbox.isSelected()) {
					stalker.getBattleMastery().setActive(true);
				} else {
					stalker.getBattleMastery().setActive(false);
				}
			}
		});
		battlemastbox.setSelected(stalker.getBattleMastery().isActive());
		JLabel battlemast = new JLabel("Battle Mastery");
		
		//#
		JCheckBox killerinstbox = new JCheckBox();
		killerinstbox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (killerinstbox.isSelected()) {
					stalker.getKillerInstinct().setActive(true);
				} else {
					stalker.getKillerInstinct().setActive(false);
				}
			}
		});
		killerinstbox.setSelected(stalker.getKillerInstinct().isActive());
		JLabel killerinst = new JLabel("Killer Instinct");
		
		ampboxes.add(amps1);
		amps.add(amps2);
		ampboxes.add(cutthroatbox);
		amps.add(cutthroat);
		ampboxes.add(enablerbox);
		amps.add(enabler);
		ampboxes.add(devastatebox);
		amps.add(devastate);
		ampboxes.add(stealthmasterbox);
		amps.add(stealthmastery);
		ampboxes.add(unfairadvantagebox);
		amps.add(unfairadvantage);
		ampboxes.add(ripostebox);
		amps.add(riposte);
		ampboxes.add(fatalwoundsbox);
		amps.add(fatalwounds);
		ampboxes.add(onslaughtbox);
		amps.add(onslaught);
		ampboxes.add(battlemastbox);
		amps.add(battlemast);
		ampboxes.add(killerinstbox);
		amps.add(killerinst);
		
		JPanel amppanel = new JPanel(new GridLayout(1, 2));
		ampboxes.setPreferredSize(new Dimension(100, 100));
		amppanel.add(ampboxes);
		amppanel.add(amps);
		
		
		
		this.setLayout(new GridLayout(1, 3));
		abilities.setBorder(BorderFactory.createLineBorder(Color.black));
		amppanel.setBorder(BorderFactory.createLineBorder(Color.black));
		this.add(abilities);
		this.add(amppanel);
	}
	
		
}
