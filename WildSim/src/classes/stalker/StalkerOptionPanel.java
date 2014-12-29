package classes.stalker;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
		
		JPanel abilities = new JPanel(new FlowLayout());
		abilities.setPreferredSize(new Dimension(225, 100));
		
		JLabel abilities1 = new JLabel("Active");
		abilities1.setPreferredSize(new Dimension(35, 20));
		JLabel abilities2 = new JLabel("Ability");
		abilities2.setPreferredSize(new Dimension(95, 20));
		JLabel abilities3 = new JLabel("Tier");
		abilities3.setPreferredSize(new Dimension(95, 20));
		
		//#
		JCheckBox shredbox = new JCheckBox();
		shredbox.setPreferredSize(new Dimension(35, 20));
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
		shred.setPreferredSize(new Dimension(95, 20));
		JTextField shredinsert = new JTextField(Integer.toString(stalker.getShred().getTier()));
		shredinsert.setPreferredSize(new Dimension(95, 20));
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
		impalebox.setPreferredSize(new Dimension(35, 20));
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
		impale.setPreferredSize(new Dimension(95, 20));
		JTextField impaleinsert = new JTextField(Integer.toString(stalker.getImpale().getTier()));
		impaleinsert.setPreferredSize(new Dimension(95, 20));
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
		punishbox.setPreferredSize(new Dimension(35, 20));
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
		punish.setPreferredSize(new Dimension(95, 20));
		JTextField punishinsert = new JTextField(Integer.toString(stalker.getPunish().getTier()));
		punishinsert.setPreferredSize(new Dimension(95, 20));
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
		ckbox.setPreferredSize(new Dimension(35, 20));
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
		ck.setPreferredSize(new Dimension(95, 20));
		JTextField ckinsert = new JTextField(Integer.toString(stalker.getCK().getTier()));
		ckinsert.setPreferredSize(new Dimension(95, 20));
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
		AWbox.setPreferredSize(new Dimension(35, 20));
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
		AW.setPreferredSize(new Dimension(95, 20));
		JTextField AWinsert = new JTextField(Integer.toString(stalker.getAW().getTier()));
		AWinsert.setPreferredSize(new Dimension(95, 20));
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
		prepbox.setPreferredSize(new Dimension(35, 20));
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
		prep.setPreferredSize(new Dimension(95, 20));
		JTextField prepinsert = new JTextField(Integer.toString(stalker.getPreparation().getTier()));
		prepinsert.setPreferredSize(new Dimension(95, 20));
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
		collapsebox.setPreferredSize(new Dimension(35, 20));
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
		collapse.setPreferredSize(new Dimension(95, 20));
		JTextField collapseinsert = new JTextField(Integer.toString(stalker.getCollapse().getTier()));
		collapseinsert.setPreferredSize(new Dimension(95, 20));
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
		staggerbox.setPreferredSize(new Dimension(35, 20));
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
		stagger.setPreferredSize(new Dimension(95, 20));
		JTextField staggerinsert = new JTextField(Integer.toString(stalker.getStagger().getTier()));
		staggerinsert.setPreferredSize(new Dimension(95, 20));
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
		tretreatbox.setPreferredSize(new Dimension(35, 20));
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
		tretreat.setPreferredSize(new Dimension(95, 20));
		JTextField tretreatinsert = new JTextField();
		tretreatinsert.setPreferredSize(new Dimension(95, 20));
		tretreatinsert.setEditable(false);
		
		//#
		JCheckBox ruinbox = new JCheckBox();
		ruinbox.setPreferredSize(new Dimension(35, 20));
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
		ruin.setPreferredSize(new Dimension(95, 20));
		JTextField ruininsert = new JTextField(Integer.toString(stalker.getRuin().getTier()));
		ruininsert.setPreferredSize(new Dimension(95, 20));
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
		innatebox.setPreferredSize(new Dimension(35, 20));
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
		innate.setPreferredSize(new Dimension(95, 20));
		JTextField innateinsert = new JTextField();
		innateinsert.setPreferredSize(new Dimension(95, 20));
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
		
		JPanel amps = new JPanel(new FlowLayout());
		amps.setPreferredSize(new Dimension(225, 100));
		
		JLabel amps1 = new JLabel("Active");
		amps1.setPreferredSize(new Dimension(35, 20));
		JLabel amps2 = new JLabel("AMPs");
		amps2.setPreferredSize(new Dimension(190, 20));
		
		JCheckBox cutthroatbox = new JCheckBox();
		cutthroatbox.setPreferredSize(new Dimension(35, 20));
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
		cutthroat.setPreferredSize(new Dimension(190, 20));
		
		//#
		JCheckBox enablerbox = new JCheckBox();
		enablerbox.setPreferredSize(new Dimension(35, 20));
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
		enabler.setPreferredSize(new Dimension(190, 20));
		
		//#
		JCheckBox devastatebox = new JCheckBox();
		devastatebox.setPreferredSize(new Dimension(35, 20));
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
		devastate.setPreferredSize(new Dimension(190, 20));
		
		
		//#
		JCheckBox stealthmasterbox = new JCheckBox();
		stealthmasterbox.setPreferredSize(new Dimension(35, 20));
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
		stealthmastery.setPreferredSize(new Dimension(190, 20));
		
		//#
		JCheckBox unfairadvantagebox = new JCheckBox();
		unfairadvantagebox.setPreferredSize(new Dimension(35, 20));
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
		unfairadvantage.setPreferredSize(new Dimension(190, 20));
		
		
		//#
		JCheckBox ripostebox = new JCheckBox();
		ripostebox.setPreferredSize(new Dimension(35, 20));
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
		riposte.setPreferredSize(new Dimension(190, 20));
		
		
		
		//#
		JCheckBox fatalwoundsbox = new JCheckBox();
		fatalwoundsbox.setPreferredSize(new Dimension(35, 20));
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
		fatalwounds.setPreferredSize(new Dimension(190, 20));
		
		
		
		//#
		JCheckBox onslaughtbox = new JCheckBox();
		onslaughtbox.setPreferredSize(new Dimension(35, 20));
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
		onslaught.setPreferredSize(new Dimension(190, 20));
		
		
		
		//#
		JCheckBox battlemastbox = new JCheckBox();
		battlemastbox.setPreferredSize(new Dimension(35, 20));
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
		battlemast.setPreferredSize(new Dimension(190, 20));
		
		
		
		//#
		JCheckBox killerinstbox = new JCheckBox();
		killerinstbox.setPreferredSize(new Dimension(35, 20));
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
		killerinst.setPreferredSize(new Dimension(190, 20));
		
		
		
		amps.add(amps1);
		amps.add(amps2);
		amps.add(cutthroatbox);
		amps.add(cutthroat);
		amps.add(enablerbox);
		amps.add(enabler);
		amps.add(devastatebox);
		amps.add(devastate);
		amps.add(stealthmasterbox);
		amps.add(stealthmastery);
		amps.add(unfairadvantagebox);
		amps.add(unfairadvantage);
		amps.add(ripostebox);
		amps.add(riposte);
		amps.add(fatalwoundsbox);
		amps.add(fatalwounds);
		amps.add(onslaughtbox);
		amps.add(onslaught);
		amps.add(battlemastbox);
		amps.add(battlemast);
		amps.add(killerinstbox);
		amps.add(killerinst);
		
		
		
		
		this.setLayout(new GridLayout(1, 3));
		abilities.setBorder(BorderFactory.createLineBorder(Color.black));
		amps.setBorder(BorderFactory.createLineBorder(Color.black));
		this.add(abilities);
		this.add(amps);
	}
	
		
}
