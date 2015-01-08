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
import javax.swing.InputVerifier;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import classes.WildstarClass;
import helpers.*;

@SuppressWarnings("serial")
public class StalkerOptionPanel extends JPanel {

	JCheckBox shredbox;
	JTextField shredinsert;
	JTextField shredprioinsert;

	JCheckBox impalebox;
	JTextField impaleinsert;
	JTextField impaleprioinsert;

	JCheckBox ckbox;
	JTextField ckinsert;
	JTextField ckprioinsert;

	JCheckBox ruinbox;
	JTextField ruininsert;
	JTextField ruinprioinsert;

	JCheckBox punishbox;
	JTextField punishinsert;

	JCheckBox AWbox;
	JTextField AWinsert;

	JCheckBox collapsebox;
	JTextField collapseinsert;

	JCheckBox staggerbox;
	JTextField staggerinsert;

	JCheckBox prepbox;
	JTextField prepinsert;

	JCheckBox tretreatbox;
	JCheckBox innatebox;

	JTextField ckatpunishcdinsert;
	JCheckBox CKafterPunishbox;
	JCheckBox prepchannelbox;
	JCheckBox preponcdbox;
	JCheckBox waitforruindotbox;

	JCheckBox cutthroatbox;
	JCheckBox enablerbox;
	JCheckBox devastatebox;
	JCheckBox stealthmasterbox;
	JCheckBox unfairadvantagebox;
	JCheckBox ripostebox;
	JCheckBox fatalwoundsbox;
	JCheckBox onslaughtbox;
	JCheckBox battlemastbox;
	JCheckBox killerinstbox;
	JCheckBox critsevbox;
	JTextField critsevinsert;

	Stalker stalker;

	public StalkerOptionPanel(WildstarClass player) {
		stalker = (Stalker) player;
		// input verifier
		InputVerifier tierintverifier = new TierVerifier(this);
		InputVerifier intverifier = new IntVerifier(this);

		// ########
		// Abilities

		JPanel abilities = new JPanel(new FlowLayout());
		abilities.setPreferredSize(new Dimension(225, 150));

		JLabel abilities1 = new JLabel("Active");
		abilities1.setPreferredSize(new Dimension(35, 15));
		JLabel abilities2 = new JLabel("Ability");
		abilities2.setPreferredSize(new Dimension(95, 15));
		JLabel abilities3 = new JLabel("Tier");
		abilities3.setPreferredSize(new Dimension(47, 15));
		JLabel abilities4 = new JLabel("Prio");
		abilities4.setPreferredSize(new Dimension(47, 15));

		// #
		shredbox = new JCheckBox();
		shredbox.setPreferredSize(new Dimension(35, 15));
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
		shred.setPreferredSize(new Dimension(95, 15));
		shredinsert = new JTextField(Integer.toString(stalker.getShred()
				.getTier()));
		shredinsert.setPreferredSize(new Dimension(47, 15));
		shredinsert.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				stalker.getShred().setTier(
						Integer.parseInt(shredinsert.getText()));
				stalker.getShredAdd().setTier(
						Integer.parseInt(shredinsert.getText()));

			}
		});
		shredinsert.setInputVerifier(tierintverifier);
		shredprioinsert = new JTextField(Integer.toString(stalker.getShred()
				.getPrio()));
		shredprioinsert.setPreferredSize(new Dimension(47, 15));

		// #
		impalebox = new JCheckBox();
		impalebox.setPreferredSize(new Dimension(35, 15));
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
		impale.setPreferredSize(new Dimension(95, 15));
		impaleinsert = new JTextField(Integer.toString(stalker.getImpale()
				.getTier()));
		impaleinsert.setPreferredSize(new Dimension(47, 15));
		impaleinsert.setInputVerifier(tierintverifier);
		impaleinsert.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				stalker.getImpale().setTier(
						Integer.parseInt(impaleinsert.getText()));
			}
		});
		impaleprioinsert = new JTextField(Integer.toString(stalker.getImpale()
				.getPrio()));
		impaleprioinsert.setPreferredSize(new Dimension(47, 15));

		// #
		punishbox = new JCheckBox();
		punishbox.setPreferredSize(new Dimension(35, 15));
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
		punish.setPreferredSize(new Dimension(95, 15));
		punishinsert = new JTextField(Integer.toString(stalker.getPunish()
				.getTier()));
		punishinsert.setPreferredSize(new Dimension(95, 15));
		punishinsert.setInputVerifier(tierintverifier);
		punishinsert.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				stalker.getPunish().setTier(
						Integer.parseInt(punishinsert.getText()));
			}
		});

		// #
		ckbox = new JCheckBox();
		ckbox.setPreferredSize(new Dimension(35, 15));
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
		ck.setPreferredSize(new Dimension(95, 15));
		ckinsert = new JTextField(Integer.toString(stalker.getCK().getTier()));
		ckinsert.setPreferredSize(new Dimension(47, 15));
		ckinsert.setInputVerifier(tierintverifier);
		ckinsert.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				stalker.getCK().setTier(Integer.parseInt(ckinsert.getText()));
				stalker.getCKadd()
						.setTier(Integer.parseInt(ckinsert.getText()));
				stalker.getCKFirst().setTier(
						Integer.parseInt(ckinsert.getText()));
			}

		});
		ckprioinsert = new JTextField(Integer.toString(stalker.getCK()
				.getPrio()));
		ckprioinsert.setPreferredSize(new Dimension(47, 15));

		// #
		AWbox = new JCheckBox();
		AWbox.setPreferredSize(new Dimension(35, 15));
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
		AW.setPreferredSize(new Dimension(95, 15));
		AWinsert = new JTextField(Integer.toString(stalker.getAW().getTier()));
		AWinsert.setPreferredSize(new Dimension(95, 15));
		AWinsert.setInputVerifier(tierintverifier);
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

		// #
		prepbox = new JCheckBox();
		prepbox.setPreferredSize(new Dimension(35, 15));
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
		prep.setPreferredSize(new Dimension(95, 15));
		prepinsert = new JTextField(Integer.toString(stalker.getPreparation()
				.getTier()));
		prepinsert.setPreferredSize(new Dimension(95, 15));
		prepinsert.setInputVerifier(tierintverifier);
		prepinsert.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				stalker.getPreparation().setTier(
						Integer.parseInt(prepinsert.getText()));
			}
		});

		// #
		collapsebox = new JCheckBox();
		collapsebox.setPreferredSize(new Dimension(35, 15));
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
		collapse.setPreferredSize(new Dimension(95, 15));
		collapseinsert = new JTextField(Integer.toString(stalker.getCollapse()
				.getTier()));
		collapseinsert.setPreferredSize(new Dimension(95, 15));
		collapseinsert.setInputVerifier(tierintverifier);
		collapseinsert.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				stalker.getCollapse().setTier(
						Integer.parseInt(collapseinsert.getText()));
			}
		});

		// #
		staggerbox = new JCheckBox();
		staggerbox.setPreferredSize(new Dimension(35, 15));
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
		stagger.setPreferredSize(new Dimension(95, 15));
		staggerinsert = new JTextField(Integer.toString(stalker.getStagger()
				.getTier()));
		staggerinsert.setPreferredSize(new Dimension(95, 15));
		staggerinsert.setInputVerifier(tierintverifier);
		staggerinsert.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				stalker.getStagger().setTier(
						Integer.parseInt(staggerinsert.getText()));
			}
		});

		// #
		tretreatbox = new JCheckBox();
		tretreatbox.setPreferredSize(new Dimension(35, 15));
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
		tretreat.setPreferredSize(new Dimension(95, 15));
		JTextField tretreatinsert = new JTextField();
		tretreatinsert.setPreferredSize(new Dimension(95, 15));
		tretreatinsert.setEditable(false);

		// #
		ruinbox = new JCheckBox();
		ruinbox.setPreferredSize(new Dimension(35, 15));
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
		ruin.setPreferredSize(new Dimension(95, 15));
		ruininsert = new JTextField(Integer.toString(stalker.getRuin()
				.getTier()));
		ruininsert.setPreferredSize(new Dimension(47, 15));
		ruininsert.setInputVerifier(tierintverifier);
		ruininsert.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				stalker.getRuin().setTier(
						Integer.parseInt(ruininsert.getText()));
				stalker.getRuinDot().setTier(
						Integer.parseInt(ruininsert.getText()));

			}
		});
		ruinprioinsert = new JTextField(Integer.toString(stalker.getRuin()
				.getPrio()));
		ruinprioinsert.setPreferredSize(new Dimension(47, 15));

		// #
		innatebox = new JCheckBox();
		innatebox.setPreferredSize(new Dimension(35, 15));
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
		innate.setPreferredSize(new Dimension(95, 15));
		JTextField innateinsert = new JTextField();
		innateinsert.setPreferredSize(new Dimension(95, 15));
		innateinsert.setEditable(false);

		JLabel nongcd = new JLabel("GCD Independent Abilities");
		nongcd.setPreferredSize(new Dimension(225, 15));

		shredprioinsert.setInputVerifier(new PrioVerifier(this,
				shredprioinsert, impaleprioinsert, ckprioinsert,
				ruinprioinsert, stalker.getShred(), stalker.getImpale(),
				stalker.getCK(), stalker.getRuin(), 1));
		impaleprioinsert.setInputVerifier(new PrioVerifier(this,
				shredprioinsert, impaleprioinsert, ckprioinsert,
				ruinprioinsert, stalker.getShred(), stalker.getImpale(),
				stalker.getCK(), stalker.getRuin(), 2));
		ckprioinsert.setInputVerifier(new PrioVerifier(this, shredprioinsert,
				impaleprioinsert, ckprioinsert, ruinprioinsert, stalker
						.getShred(), stalker.getImpale(), stalker.getCK(),
				stalker.getRuin(), 3));
		ruinprioinsert.setInputVerifier(new PrioVerifier(this, shredprioinsert,
				impaleprioinsert, ckprioinsert, ruinprioinsert, stalker
						.getShred(), stalker.getImpale(), stalker.getCK(),
				stalker.getRuin(), 4));

		abilities.add(abilities1);
		abilities.add(abilities2);
		abilities.add(abilities3);
		abilities.add(abilities4);
		abilities.add(shredbox);
		abilities.add(shred);
		abilities.add(shredinsert);
		abilities.add(shredprioinsert);
		abilities.add(impalebox);
		abilities.add(impale);
		abilities.add(impaleinsert);
		abilities.add(impaleprioinsert);
		abilities.add(ckbox);
		abilities.add(ck);
		abilities.add(ckinsert);
		abilities.add(ckprioinsert);
		abilities.add(ruinbox);
		abilities.add(ruin);
		abilities.add(ruininsert);
		abilities.add(ruinprioinsert);
		abilities.add(nongcd);
		abilities.add(punishbox);
		abilities.add(punish);
		abilities.add(punishinsert);
		abilities.add(AWbox);
		abilities.add(AW);
		abilities.add(AWinsert);
		abilities.add(collapsebox);
		abilities.add(collapse);
		abilities.add(collapseinsert);
		abilities.add(staggerbox);
		abilities.add(stagger);
		abilities.add(staggerinsert);
		abilities.add(prepbox);
		abilities.add(prep);
		abilities.add(prepinsert);
		abilities.add(tretreatbox);
		abilities.add(tretreat);
		abilities.add(tretreatinsert);
		abilities.add(innatebox);
		abilities.add(innate);
		abilities.add(innateinsert);

		// additional options
		JLabel additionaloptions = new JLabel("Additional Options");
		additionaloptions.setPreferredSize(new Dimension(225, 30));

		abilities.add(additionaloptions);

		prepchannelbox = new JCheckBox();
		prepchannelbox.setPreferredSize(new Dimension(35, 15));
		prepchannelbox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (prepchannelbox.isSelected()) {
					stalker.getPreparation().setCompleteChannel(true);
				} else {
					stalker.getPreparation().setCompleteChannel(false);
				}
			}
		});
		prepchannelbox.setSelected(stalker.getPreparation().completeChannel());
		JLabel prepchannel = new JLabel("Fully Channel Prep");
		prepchannel.setPreferredSize(new Dimension(190, 15));

		preponcdbox = new JCheckBox();
		preponcdbox.setPreferredSize(new Dimension(35, 15));
		preponcdbox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (preponcdbox.isSelected()) {
					stalker.getPreparation().setChannelOnCD(true);
				} else {
					stalker.getPreparation().setChannelOnCD(false);
				}
			}
		});
		preponcdbox.setSelected(stalker.getPreparation().channelOnCD());
		JLabel preponcd = new JLabel("Channel Prep instantly");
		preponcd.setPreferredSize(new Dimension(190, 15));

		CKafterPunishbox = new JCheckBox();
		CKafterPunishbox.setPreferredSize(new Dimension(35, 15));
		CKafterPunishbox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (CKafterPunishbox.isSelected()) {
					stalker.getCK().setUseAfterPunish(true);
					stalker.getCKFirst().setUseAfterPunish(true);
				} else {
					stalker.getCK().setUseAfterPunish(false);
					stalker.getCKFirst().setUseAfterPunish(false);
				}
			}
		});
		CKafterPunishbox.setSelected(stalker.getCK().getUseAfterPunish());
		JLabel CKafterPunish = new JLabel("Always use 2xCKt8 after Punish");
		CKafterPunish.setPreferredSize(new Dimension(190, 15));

		JLabel ckatpunishcd = new JLabel("CKt8 at PunishCD:");
		ckatpunishcd.setPreferredSize(new Dimension(130, 15));
		ckatpunishcdinsert = new JTextField(Integer.toString(stalker.getCK().getCastAtPunishCD()));
		ckatpunishcdinsert.setPreferredSize(new Dimension(95, 15));
		ckatpunishcdinsert.setInputVerifier(intverifier);
		ckatpunishcdinsert.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				stalker.getCK().setCastAtPunishCD(
						Integer.parseInt(ckatpunishcdinsert.getText()));
				stalker.getCKFirst().setCastAtPunishCD(
						Integer.parseInt(ckatpunishcdinsert.getText()));
			}
		});
		
		

		waitforruindotbox = new JCheckBox();
		waitforruindotbox.setPreferredSize(new Dimension(35, 15));
		waitforruindotbox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (waitforruindotbox.isSelected()) {
					stalker.getRuin().setWaitForDot(false);
				} else {
					stalker.getRuin().setWaitForDot(true);
				}
			}
		});
		waitforruindotbox.setSelected(!stalker.getRuin().getWaitForDot());
		JLabel waitforruindot = new JLabel("Cast Ruin on CD");
		waitforruindot.setPreferredSize(new Dimension(190, 15));

		abilities.add(ckatpunishcd);
		abilities.add(ckatpunishcdinsert);
		abilities.add(CKafterPunishbox);
		abilities.add(CKafterPunish);
		abilities.add(prepchannelbox);
		abilities.add(prepchannel);
		abilities.add(preponcdbox);
		abilities.add(preponcd);
		abilities.add(waitforruindotbox);
		abilities.add(waitforruindot);

		// ########
		// AMPs

		JPanel amps = new JPanel(new FlowLayout());
		amps.setPreferredSize(new Dimension(225, 150));

		JLabel amps1 = new JLabel("Active");
		amps1.setPreferredSize(new Dimension(35, 15));
		JLabel amps2 = new JLabel("AMPs");
		amps2.setPreferredSize(new Dimension(190, 15));

		cutthroatbox = new JCheckBox();
		cutthroatbox.setPreferredSize(new Dimension(35, 15));
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
		cutthroat.setPreferredSize(new Dimension(190, 15));

		// #
		enablerbox = new JCheckBox();
		enablerbox.setPreferredSize(new Dimension(35, 15));
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
		enabler.setPreferredSize(new Dimension(190, 15));

		// #
		devastatebox = new JCheckBox();
		devastatebox.setPreferredSize(new Dimension(35, 15));
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
		devastate.setPreferredSize(new Dimension(190, 15));

		// #
		stealthmasterbox = new JCheckBox();
		stealthmasterbox.setPreferredSize(new Dimension(35, 15));
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
		stealthmastery.setPreferredSize(new Dimension(190, 15));

		// #
		unfairadvantagebox = new JCheckBox();
		unfairadvantagebox.setPreferredSize(new Dimension(35, 15));
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
		unfairadvantage.setPreferredSize(new Dimension(190, 15));

		// #
		ripostebox = new JCheckBox();
		ripostebox.setPreferredSize(new Dimension(35, 15));
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
		riposte.setPreferredSize(new Dimension(190, 15));

		// #
		fatalwoundsbox = new JCheckBox();
		fatalwoundsbox.setPreferredSize(new Dimension(35, 15));
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
		fatalwounds.setPreferredSize(new Dimension(190, 15));

		// #
		onslaughtbox = new JCheckBox();
		onslaughtbox.setPreferredSize(new Dimension(35, 15));
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
		onslaught.setPreferredSize(new Dimension(190, 15));

		// #
		battlemastbox = new JCheckBox();
		battlemastbox.setPreferredSize(new Dimension(35, 15));
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
		battlemast.setPreferredSize(new Dimension(190, 15));

		// #
		killerinstbox = new JCheckBox();
		killerinstbox.setPreferredSize(new Dimension(35, 15));
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
		killerinst.setPreferredSize(new Dimension(190, 15));

		critsevbox = new JCheckBox();
		critsevbox.setPreferredSize(new Dimension(35, 15));
		critsevbox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (critsevbox.isSelected()) {
					stalker.getCritSevAMP().setActive(true);
				} else {
					stalker.getCritSevAMP().setActive(false);
				}
			}
		});
		critsevbox.setSelected(stalker.getCritSevAMP().isActive());
		JLabel critsev = new JLabel("Crit Sev: ");
		critsev.setPreferredSize(new Dimension(95, 15));
		critsevinsert = new JTextField(Float.toString(stalker.getCritSevAMP()
				.getAmount()));
		critsevinsert.setPreferredSize(new Dimension(95, 15));
		critsevinsert.setInputVerifier(new InputVerifier() {
			@Override
			public boolean verify(JComponent input) {
				String text = critsevinsert.getText();
				float n = 0;
				try {
					n = Float.parseFloat(text);
				} catch (NumberFormatException e) {
					Runnable runnable = new Runnable() {
						public void run() {
							JOptionPane.showMessageDialog(amps,
									"Not a Number!", "Error",
									JOptionPane.ERROR_MESSAGE);
						}
					};
					SwingUtilities.invokeLater(runnable);
					return false;
				}

				if (n == 0.12f || n == 0.08f || n == 0.04f) {

					return true;
				} else {
					Runnable runnable = new Runnable() {
						public void run() {
							JOptionPane.showMessageDialog(amps,
									"Must be either 0.12, 0.08 or 0.04!",
									"Error", JOptionPane.ERROR_MESSAGE);
						}
					};
					SwingUtilities.invokeLater(runnable);
					return false;
				}
			}
		});
		critsevinsert.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				stalker.getCritSevAMP().setAmount(
						Float.parseFloat(critsevinsert.getText()));
			}
		});

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
		amps.add(critsevbox);
		amps.add(critsev);
		amps.add(critsevinsert);

		this.setLayout(new GridLayout(1, 3));
		abilities.setBorder(BorderFactory.createLineBorder(Color.black));
		amps.setBorder(BorderFactory.createLineBorder(Color.black));
		this.add(abilities);
		this.add(amps);

	}

	public String getCurrentValues() {
		StringBuilder valuestring = new StringBuilder();
		valuestring.append(shredbox.isSelected() + ";" + shredinsert.getText()
				+ ";" + shredprioinsert.getText() + ";");
		valuestring.append(impalebox.isSelected() + ";"
				+ impaleinsert.getText() + ";" + impaleprioinsert.getText()
				+ ";");
		valuestring.append(ckbox.isSelected() + ";" + ckinsert.getText() + ";"
				+ ckprioinsert.getText() + ";");
		valuestring.append(ruinbox.isSelected() + ";" + ruininsert.getText()
				+ ";" + ruinprioinsert.getText() + ";");
		valuestring.append(punishbox.isSelected() + ";"
				+ punishinsert.getText() + ";");
		valuestring.append(AWbox.isSelected() + ";" + AWinsert.getText() + ";");
		valuestring.append(collapsebox.isSelected() + ";"
				+ collapseinsert.getText() + ";");
		valuestring.append(staggerbox.isSelected() + ";"
				+ staggerinsert.getText() + ";");
		valuestring.append(prepbox.isSelected() + ";" + prepinsert.getText()
				+ ";");
		valuestring.append(tretreatbox.isSelected() + ";");
		valuestring.append(innatebox.isSelected() + ";");

		valuestring.append(ckatpunishcdinsert.getText() + ";");
		valuestring.append(CKafterPunishbox.isSelected() + ";");
		valuestring.append(prepchannelbox.isSelected() + ";");
		valuestring.append(preponcdbox.isSelected() + ";");
		valuestring.append(waitforruindotbox.isSelected() + ";");

		valuestring.append(cutthroatbox.isSelected() + ";");
		valuestring.append(enablerbox.isSelected() + ";");
		valuestring.append(devastatebox.isSelected() + ";");
		valuestring.append(stealthmasterbox.isSelected() + ";");
		valuestring.append(unfairadvantagebox.isSelected() + ";");
		valuestring.append(ripostebox.isSelected() + ";");
		valuestring.append(fatalwoundsbox.isSelected() + ";");
		valuestring.append(onslaughtbox.isSelected() + ";");
		valuestring.append(battlemastbox.isSelected() + ";");
		valuestring.append(killerinstbox.isSelected() + ";");
		valuestring.append(critsevbox.isSelected() + ";");
		valuestring.append(critsevinsert.getText() + ";");

		valuestring.append(System.lineSeparator());
		return valuestring.toString();
	}

	public void setCurrentValues(String currVal) {
		String[] values = currVal.split(";");

		
		stalker.getShred().setActive(Boolean.parseBoolean(values[0]));
		stalker.getShredAdd().setActive(Boolean.parseBoolean(values[0]));
		stalker.getShred().setTier(Integer.parseInt(values[1]));
		stalker.getShredAdd().setTier(Integer.parseInt(values[1]));
		stalker.getShred().setPrio(Integer.parseInt(values[2]));
		shredbox.setSelected(Boolean.parseBoolean(values[0]));
		shredinsert.setText(values[1]);
		shredprioinsert.setText(values[2]);

		stalker.getImpale().setActive(Boolean.parseBoolean(values[3]));
		stalker.getImpale().setTier(Integer.parseInt(values[4]));
		stalker.getImpale().setPrio(Integer.parseInt(values[5]));
		impalebox.setSelected(Boolean.parseBoolean(values[3]));
		impaleinsert.setText(values[4]);
		impaleprioinsert.setText(values[5]);

		stalker.getCK().setActive(Boolean.parseBoolean(values[6]));
		stalker.getCKadd().setActive(Boolean.parseBoolean(values[6]));
		stalker.getCKFirst().setActive(Boolean.parseBoolean(values[6]));
		stalker.getCKadd().setTier(Integer.parseInt(values[7]));
		stalker.getCKFirst().setTier(Integer.parseInt(values[7]));
		stalker.getCK().setTier(Integer.parseInt(values[7]));
		stalker.getCK().setPrio(Integer.parseInt(values[8]));
		ckbox.setSelected(Boolean.parseBoolean(values[6]));
		ckinsert.setText(values[7]);
		ckprioinsert.setText(values[8]);

		stalker.getRuin().setActive(Boolean.parseBoolean(values[9]));
		stalker.getRuinDot().setActive(Boolean.parseBoolean(values[9]));
		stalker.getRuin().setTier(Integer.parseInt(values[10]));
		stalker.getRuinDot().setTier(Integer.parseInt(values[10]));
		stalker.getRuin().setPrio(Integer.parseInt(values[11]));
		ruinbox.setSelected(Boolean.parseBoolean(values[9]));
		ruininsert.setText(values[10]);
		ruinprioinsert.setText(values[11]);

		stalker.getPunish().setActive(Boolean.parseBoolean(values[12]));
		stalker.getPunish().setTier(Integer.parseInt(values[13]));
		punishbox.setSelected(Boolean.parseBoolean(values[12]));
		punishinsert.setText(values[13]);

		stalker.getAW().setActive(Boolean.parseBoolean(values[14]));
		stalker.getAW().setTier(Integer.parseInt(values[15]));
		AWbox.setSelected(Boolean.parseBoolean(values[14]));
		AWinsert.setText(values[15]);

		stalker.getCollapse().setActive(Boolean.parseBoolean(values[16]));
		stalker.getCollapse().setTier(Integer.parseInt(values[17]));
		collapsebox.setSelected(Boolean.parseBoolean(values[16]));
		collapseinsert.setText(values[17]);

		stalker.getStagger().setActive(Boolean.parseBoolean(values[18]));
		stalker.getStagger().setTier(Integer.parseInt(values[19]));
		staggerbox.setSelected(Boolean.parseBoolean(values[18]));
		staggerinsert.setText(values[19]);

		stalker.getPreparation().setActive(Boolean.parseBoolean(values[20]));
		stalker.getPreparation().setTier(Integer.parseInt(values[21]));
		prepbox.setSelected(Boolean.parseBoolean(values[20]));
		prepinsert.setText(values[21]);

		stalker.getTacticalRetreat().setActive(Boolean.parseBoolean(values[22]));
		tretreatbox.setSelected(Boolean.parseBoolean(values[22]));

		stalker.getInnate().setActive(Boolean.parseBoolean(values[23]));
		innatebox.setSelected(Boolean.parseBoolean(values[23]));

		stalker.getCK().setCastAtPunishCD(Integer.parseInt(values[24]));
		stalker.getCKFirst().setCastAtPunishCD(Integer.parseInt(values[24]));
		ckatpunishcdinsert.setText(values[24]);
		stalker.getCK().setUseAfterPunish(Boolean.parseBoolean(values[25]));
		stalker.getCKFirst().setUseAfterPunish(Boolean.parseBoolean(values[25]));
		CKafterPunishbox.setSelected(Boolean.parseBoolean(values[25]));
		stalker.getPreparation().setCompleteChannel(Boolean.parseBoolean(values[26]));
		prepchannelbox.setSelected(Boolean.parseBoolean(values[26]));
		stalker.getPreparation().setChannelOnCD(Boolean.parseBoolean(values[27]));
		preponcdbox.setSelected(Boolean.parseBoolean(values[27]));
		stalker.getRuin().setWaitForDot(Boolean.parseBoolean(values[28]));
		waitforruindotbox.setSelected(Boolean.parseBoolean(values[28]));

		stalker.getCutthroat().setActive(Boolean.parseBoolean(values[29]));
		cutthroatbox.setSelected(Boolean.parseBoolean(values[29]));
		stalker.getEnabler().setActive(Boolean.parseBoolean(values[30]));
		enablerbox.setSelected(Boolean.parseBoolean(values[30]));
		stalker.getDevastate().setActive(Boolean.parseBoolean(values[31]));
		devastatebox.setSelected(Boolean.parseBoolean(values[31]));
		stalker.getStealthMastery().setActive(Boolean.parseBoolean(values[32]));
		stealthmasterbox.setSelected(Boolean.parseBoolean(values[32]));
		stalker.getUnfairAdvantage().setActive(Boolean.parseBoolean(values[33]));
		unfairadvantagebox.setSelected(Boolean.parseBoolean(values[33]));
		stalker.getRiposte().setActive(Boolean.parseBoolean(values[34]));
		ripostebox.setSelected(Boolean.parseBoolean(values[34]));
		stalker.getFatalWounds().setActive(Boolean.parseBoolean(values[35]));
		fatalwoundsbox.setSelected(Boolean.parseBoolean(values[35]));
		stalker.getOnslaught().setActive(Boolean.parseBoolean(values[36]));
		onslaughtbox.setSelected(Boolean.parseBoolean(values[36]));
		stalker.getBattleMastery().setActive(Boolean.parseBoolean(values[37]));
		battlemastbox.setSelected(Boolean.parseBoolean(values[37]));
		stalker.getKillerInstinct().setActive(Boolean.parseBoolean(values[38]));
		killerinstbox.setSelected(Boolean.parseBoolean(values[38]));
		stalker.getCritSevAMP().setActive(Boolean.parseBoolean(values[39]));
		critsevbox.setSelected(Boolean.parseBoolean(values[39]));
		stalker.getCritSevAMP().setAmount(Float.parseFloat(values[40]));
		critsevinsert.setText(values[40]);
	
	}

}
