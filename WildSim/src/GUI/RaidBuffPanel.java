package GUI;

import helpers.FloatVerifier;
import helpers.PercentageVerifier;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.InputVerifier;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import combat.Combat;

@SuppressWarnings("serial")
public class RaidBuffPanel extends JPanel {
	
	public RaidBuffPanel(Combat combat) {
		JPanel raidbuff = new JPanel(new GridLayout(21, 4));
		
		
		InputVerifier percentverifier = new PercentageVerifier(this);
		InputVerifier floatverifier = new FloatVerifier(this);
				
		JLabel raidbuff1 = new JLabel("Active");
		JLabel raidbuff2 = new JLabel("RaidBuff");
		JLabel raidbuff3 = new JLabel("Amount");
		JLabel raidbuff4 = new JLabel("Uptime");
		raidbuff.add(raidbuff1);
		raidbuff.add(raidbuff2);
		raidbuff.add(raidbuff3);
		raidbuff.add(raidbuff4);
		
		
		
		
		
		JCheckBox armorredbox = new JCheckBox();
		armorredbox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (armorredbox.isSelected()) {
					combat.getArmorRed().setActive(true);
					
				} else {
					combat.getArmorRed().setActive(false);
				}
			}
		});
		armorredbox.setSelected(combat.getArmorRed().isActive());
		JLabel armorred = new JLabel("Armor Reduction");
		JTextField armorredamount = new JTextField(Float.toString(combat.getArmorRed().getAmount()));
		armorredamount.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				combat.getArmorRed().setAmount(Float.parseFloat(armorredamount.getText()));
			}
		});
		JTextField armorreduptime = new JTextField(Float.toString(combat.getArmorRed().getUptime()));
		armorreduptime.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				combat.getArmorRed().setUptime(Float.parseFloat(armorreduptime.getText()));
			}
		});
		raidbuff.add(armorredbox);
		raidbuff.add(armorred);
		raidbuff.add(armorredamount);
		raidbuff.add(armorreduptime);
		
		
		
		
		JCheckBox reduceallresbox = new JCheckBox();
		reduceallresbox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (reduceallresbox.isSelected()) {
					combat.getReduceAllRes().setActive(true);
				} else {
					combat.getReduceAllRes().setActive(false);
				}
			}
		});
		reduceallresbox.setSelected(combat.getReduceAllRes().isActive());
		JLabel reduceallres = new JLabel("Reduce All Resist");
		JTextField reduceallresamount = new JTextField(Float.toString(combat.getReduceAllRes().getAmount()));
		reduceallresamount.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				combat.getReduceAllRes().setAmount(Float.parseFloat(reduceallresamount.getText()));
			}
		});
		JTextField reduceallresuptime = new JTextField(Float.toString(combat.getReduceAllRes().getUptime()));
		reduceallresuptime.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				combat.getReduceAllRes().setUptime(Float.parseFloat(reduceallresuptime.getText()));
			}
		});
		raidbuff.add(reduceallresbox);
		raidbuff.add(reduceallres);
		raidbuff.add(reduceallresamount);
		raidbuff.add(reduceallresuptime);
		
		
		
		
		
		JCheckBox reducephysresbox = new JCheckBox();
		reducephysresbox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (reducephysresbox.isSelected()) {
					combat.getReducePhysRes().setActive(true);
				} else {
					combat.getReducePhysRes().setActive(false);
				}
			}
		});
		reducephysresbox.setSelected(combat.getReducePhysRes().isActive());
		JLabel reducephysres = new JLabel("Reduce Phys Resist");
		JTextField reducephysresamount = new JTextField(Float.toString(combat.getReducePhysRes().getAmount()));
		reducephysresamount.setEditable(false);
		JTextField reducephysresuptime = new JTextField(Float.toString(combat.getReducePhysRes().getUptime()));
		reducephysresuptime.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				combat.getReducePhysRes().setUptime(Float.parseFloat(reducephysresuptime.getText()));
			}
		});
		raidbuff.add(reducephysresbox);
		raidbuff.add(reducephysres);
		raidbuff.add(reducephysresamount);
		raidbuff.add(reducephysresuptime);
		
		
		
		
		
		JCheckBox reducemagresbox = new JCheckBox();
		reducemagresbox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (reducemagresbox.isSelected()) {
					combat.getReduceMagRes().setActive(true);
				} else {
					combat.getReduceMagRes().setActive(false);
				}
			}
		});
		reducemagresbox.setSelected(combat.getReduceMagRes().isActive());
		JLabel reducemagres = new JLabel("Reduce Mag Resist");
		JTextField reducemagresamount = new JTextField(Float.toString(combat.getReduceMagRes().getAmount()));
		reducemagresamount.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				combat.getReduceMagRes().setAmount(Float.parseFloat(reducemagresamount.getText()));
			}
		});
		JTextField reducemagresuptime = new JTextField(Float.toString(combat.getReduceMagRes().getUptime()));
		reducemagresuptime.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				combat.getReduceMagRes().setUptime(Float.parseFloat(reducemagresuptime.getText()));
			}
		});
		raidbuff.add(reducemagresbox);
		raidbuff.add(reducemagres);
		raidbuff.add(reducemagresamount);
		raidbuff.add(reducemagresuptime);
				
		
		
		
		
		JCheckBox reducetechresbox = new JCheckBox();
		reducetechresbox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (reducetechresbox.isSelected()) {
					combat.getReduceTechRes().setActive(true);
				} else {
					combat.getReduceTechRes().setActive(false);
				}
			}
		});
		reducetechresbox.setSelected(combat.getReduceTechRes().isActive());
		JLabel reducetechres = new JLabel("Reduce Tech Resist");
		JTextField reducetechresamount = new JTextField(Float.toString(combat.getReduceTechRes().getAmount()));
		reducetechresamount.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				combat.getReduceTechRes().setAmount(Float.parseFloat(reducetechresamount.getText()));
			}
		});
		JTextField reducetechresuptime = new JTextField(Float.toString(combat.getReduceTechRes().getUptime()));
		reducetechresuptime.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				combat.getReduceTechRes().setUptime(Float.parseFloat(reducetechresuptime.getText()));
			}
		});
		raidbuff.add(reducetechresbox);
		raidbuff.add(reducetechres);
		raidbuff.add(reducetechresamount);
		raidbuff.add(reducetechresuptime);
		
		
		
		
		
		JCheckBox reducedeflectbox = new JCheckBox();
		reducedeflectbox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (reducedeflectbox.isSelected()) {
					combat.getReduceDeflect().setActive(true);
				} else {
					combat.getReduceDeflect().setActive(false);
				}
			}
		});
		reducedeflectbox.setSelected(combat.getReduceDeflect().isActive());
		JLabel reducedeflect = new JLabel("Reduce Deflect");
		JTextField reducedeflectamount = new JTextField(Float.toString(combat.getReduceDeflect().getAmount()));
		reducedeflectamount.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				combat.getReduceDeflect().setAmount(Float.parseFloat(reducedeflectamount.getText()));
			}
		});
		JTextField reducedeflectuptime = new JTextField(Float.toString(combat.getReduceDeflect().getUptime()));
		reducedeflectuptime.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				combat.getReduceDeflect().setUptime(Float.parseFloat(reducedeflectuptime.getText()));
			}
		});
		raidbuff.add(reducedeflectbox);
		raidbuff.add(reducedeflect);
		raidbuff.add(reducedeflectamount);
		raidbuff.add(reducedeflectuptime);
				
		
		
		JCheckBox weaponspecdebuffbox = new JCheckBox();
		weaponspecdebuffbox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (weaponspecdebuffbox.isSelected()) {
					combat.getWeaponSpecDebuff().setActive(true);
				} else {
					combat.getWeaponSpecDebuff().setActive(false);
				}
			}
		});
		weaponspecdebuffbox.setSelected(combat.getWeaponSpecDebuff().isActive());
		JLabel weaponspecdebuff = new JLabel("Weapon Spec Debuff");
		JTextField weaponspecdebuffamount = new JTextField(Float.toString(combat.getWeaponSpecDebuff().getAmount()));
		weaponspecdebuffamount.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				combat.getWeaponSpecDebuff().setAmount(Float.parseFloat(weaponspecdebuffamount.getText()));
			}
		});
		JTextField weaponspecdebuffuptime = new JTextField(Float.toString(combat.getWeaponSpecDebuff().getUptime()));
		weaponspecdebuffuptime.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				combat.getWeaponSpecDebuff().setUptime(Float.parseFloat(weaponspecdebuffuptime.getText()));
			}
		});
		raidbuff.add(weaponspecdebuffbox);
		raidbuff.add(weaponspecdebuff);
		raidbuff.add(weaponspecdebuffamount);
		raidbuff.add(weaponspecdebuffuptime);
		
		
		
		
		
		JCheckBox technophiledebuffbox = new JCheckBox();
		technophiledebuffbox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (technophiledebuffbox.isSelected()) {
					combat.getTechnophileDebuff().setActive(true);
				} else {
					combat.getTechnophileDebuff().setActive(false);
				}
			}
		});
		technophiledebuffbox.setSelected(combat.getTechnophileDebuff().isActive());
		JLabel technophiledebuff = new JLabel("Technophile Debuff");
		JTextField technophiledebuffamount = new JTextField(Float.toString(combat.getTechnophileDebuff().getAmount()));
		technophiledebuffamount.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				combat.getTechnophileDebuff().setAmount(Float.parseFloat(technophiledebuffamount.getText()));
			}
		});
		JTextField technophiledebuffuptime = new JTextField(Float.toString(combat.getTechnophileDebuff().getUptime()));
		technophiledebuffuptime.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				combat.getTechnophileDebuff().setUptime(Float.parseFloat(technophiledebuffuptime.getText()));
			}
		});
		raidbuff.add(technophiledebuffbox);
		raidbuff.add(technophiledebuff);
		raidbuff.add(technophiledebuffamount);
		raidbuff.add(technophiledebuffuptime);
		
		
		
		
		
		JCheckBox spellweaverdebuffbox = new JCheckBox();
		spellweaverdebuffbox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (spellweaverdebuffbox.isSelected()) {
					combat.getSpellweaverDebuff().setActive(true);
				} else {
					combat.getSpellweaverDebuff().setActive(false);
				}
			}
		});
		spellweaverdebuffbox.setSelected(combat.getSpellweaverDebuff().isActive());
		JLabel spellweaverdebuff = new JLabel("Spellweaver Debuff");
		JTextField spellweaverdebuffamount = new JTextField(Float.toString(combat.getSpellweaverDebuff().getAmount()));
		spellweaverdebuffamount.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				combat.getSpellweaverDebuff().setAmount(Float.parseFloat(spellweaverdebuffamount.getText()));
			}
		});
		JTextField spellweaverdebuffuptime = new JTextField(Float.toString(combat.getSpellweaverDebuff().getUptime()));
		spellweaverdebuffuptime.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				combat.getSpellweaverDebuff().setUptime(Float.parseFloat(spellweaverdebuffuptime.getText()));
			}
		});
		raidbuff.add(spellweaverdebuffbox);
		raidbuff.add(spellweaverdebuff);
		raidbuff.add(spellweaverdebuffamount);
		raidbuff.add(spellweaverdebuffuptime);
		
		
		JCheckBox punishbox = new JCheckBox();
		punishbox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (punishbox.isSelected()) {
					combat.getPunish().setActive(true);
				} else {
					combat.getPunish().setActive(false);
				}
			}
		});
		punishbox.setSelected(combat.getPunish().isActive());
		JLabel punish = new JLabel("Punish");
		JTextField punishamount = new JTextField(Float.toString(combat.getPunish().getAmount()));
		punishamount.setEditable(false);
		JTextField punishuptime = new JTextField(Float.toString(combat.getPunish().getUptime()));
		punishuptime.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				combat.getPunish().setUptime(Float.parseFloat(punishuptime.getText()));
			}
		});
		raidbuff.add(punishbox);
		raidbuff.add(punish);
		raidbuff.add(punishamount);
		raidbuff.add(punishuptime);
		
		
		
		
		
		JCheckBox powerlinkbox = new JCheckBox();
		powerlinkbox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (powerlinkbox.isSelected()) {
					combat.getPowerLink().setActive(true);
				} else {
					combat.getPowerLink().setActive(false);
				}
			}
		});
		powerlinkbox.setSelected(combat.getPowerLink().isActive());
		JLabel powerlink = new JLabel("Powerlink");
		JTextField powerlinkamount = new JTextField(Float.toString(combat.getPowerLink().getAmount()));
		powerlinkamount.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				combat.getPowerLink().setAmount(Float.parseFloat(powerlinkamount.getText()));
			}
		});
		JTextField powerlinkuptime = new JTextField(Float.toString(combat.getPowerLink().getUptime()));
		powerlinkuptime.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				combat.getPowerLink().setUptime(Float.parseFloat(powerlinkuptime.getText()));
			}
		});
		raidbuff.add(powerlinkbox);
		raidbuff.add(powerlink);
		raidbuff.add(powerlinkamount);
		raidbuff.add(powerlinkuptime);
		
		
		
		
		
		JCheckBox powerlinkt4box = new JCheckBox();
		powerlinkt4box.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (powerlinkt4box.isSelected()) {
					combat.getPowerLinkT4().setActive(true);
				} else {
					combat.getPowerLinkT4().setActive(false);
				}
			}
		});
		powerlinkt4box.setSelected(combat.getPowerLinkT4().isActive());
		JLabel powerlinkt4 = new JLabel("PowerlinkT4");
		JTextField powerlinkt4amount = new JTextField(Float.toString(combat.getPowerLinkT4().getAmount()));
		powerlinkt4amount.setEditable(false);
		JTextField powerlinkt4uptime = new JTextField(Float.toString(combat.getPowerLinkT4().getUptime()));
		powerlinkt4uptime.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				combat.getPowerLinkT4().setUptime(Float.parseFloat(powerlinkt4uptime.getText()));
			}
		});
		raidbuff.add(powerlinkt4box);
		raidbuff.add(powerlinkt4);
		raidbuff.add(powerlinkt4amount);
		raidbuff.add(powerlinkt4uptime);
		
		
		
		
		
		JCheckBox empoweringbox = new JCheckBox();
		empoweringbox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (empoweringbox.isSelected()) {
					combat.getEmpowering().setActive(true);
				} else {
					combat.getEmpowering().setActive(false);
				}
			}
		});
		empoweringbox.setSelected(combat.getEmpowering().isActive());
		JLabel empowering = new JLabel("EmpoweringProbes");
		JTextField empoweringamount = new JTextField(Float.toString(combat.getEmpowering().getAmount()));
		empoweringamount.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				combat.getEmpowering().setAmount(Float.parseFloat(empoweringamount.getText()));
			}
		});
		JTextField empoweringuptime = new JTextField(Float.toString(combat.getEmpowering().getUptime()));
		empoweringuptime.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				combat.getEmpowering().setUptime(Float.parseFloat(empoweringuptime.getText()));
			}
		});
		raidbuff.add(empoweringbox);
		raidbuff.add(empowering);
		raidbuff.add(empoweringamount);
		raidbuff.add(empoweringuptime);
		
		
		
		
		
		JCheckBox empoweringt4box = new JCheckBox();
		empoweringt4box.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (empoweringt4box.isSelected()) {
					combat.getEmpoweringT4().setActive(true);
				} else {
					combat.getEmpoweringT4().setActive(false);
				}
			}
		});
		empoweringt4box.setSelected(combat.getEmpoweringT4().isActive());
		JLabel empoweringt4 = new JLabel("EmpoweringProbesT4");
		JTextField empoweringt4amount = new JTextField(Float.toString(combat.getEmpoweringT4().getAmount()));
		empoweringt4amount.setEditable(false);
		JTextField empoweringt4uptime = new JTextField(Float.toString(combat.getEmpoweringT4().getUptime()));
		empoweringt4uptime.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				combat.getEmpoweringT4().setUptime(Float.parseFloat(empoweringt4uptime.getText()));
			}
		});
		raidbuff.add(empoweringt4box);
		raidbuff.add(empoweringt4);
		raidbuff.add(empoweringt4amount);
		raidbuff.add(empoweringt4uptime);
		
		
		
		
		
		JCheckBox empoweringaurabox = new JCheckBox();
		empoweringaurabox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (empoweringaurabox.isSelected()) {
					combat.getEmpoweringAura().setActive(true);
				} else {
					combat.getEmpoweringAura().setActive(false);
				}
			}
		});
		empoweringaurabox.setSelected(combat.getEmpoweringAura().isActive());
		JLabel empoweringaura = new JLabel("EmpoweringAura");
		JTextField empoweringauraamount = new JTextField(Float.toString(combat.getEmpoweringAura().getAmount()));
		empoweringauraamount.setEditable(false);
		JTextField empoweringaurauptime = new JTextField(Float.toString(combat.getEmpoweringAura().getUptime()));
		empoweringaurauptime.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				combat.getEmpoweringAura().setUptime(Float.parseFloat(empoweringaurauptime.getText()));
			}
		});
		raidbuff.add(empoweringaurabox);
		raidbuff.add(empoweringaura);
		raidbuff.add(empoweringauraamount);
		raidbuff.add(empoweringaurauptime);
		
		
		
		
		
		JCheckBox voidpactbox = new JCheckBox();
		voidpactbox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (voidpactbox.isSelected()) {
					combat.getVoidPact().setActive(true);
				} else {
					combat.getVoidPact().setActive(false);
				}
			}
		});
		voidpactbox.setSelected(combat.getVoidPact().isActive());
		JLabel voidpact = new JLabel("VoidPact");
		JTextField voidpactamount = new JTextField(Float.toString(combat.getVoidPact().getAmount()));
		voidpactamount.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				combat.getVoidPact().setAmount(Float.parseFloat(voidpactamount.getText()));
			}
		});
		JTextField voidpactuptime = new JTextField(Float.toString(combat.getVoidPact().getUptime()));
		voidpactuptime.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				combat.getVoidPact().setUptime(Float.parseFloat(voidpactuptime.getText()));
			}
		});
		raidbuff.add(voidpactbox);
		raidbuff.add(voidpact);
		raidbuff.add(voidpactamount);
		raidbuff.add(voidpactuptime);
		
		
		
		
		
		JCheckBox surgicalbox = new JCheckBox();
		surgicalbox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (surgicalbox.isSelected()) {
					combat.getSurgical().setActive(true);
				} else {
					combat.getSurgical().setActive(false);
				}
			}
		});
		surgicalbox.setSelected(combat.getSurgical().isActive());
		JLabel surgical = new JLabel("Surgical");
		JTextField surgicalamount = new JTextField(Float.toString(combat.getSurgical().getAmount()));
		surgicalamount.setEditable(false);
		JTextField surgicaluptime = new JTextField(Float.toString(combat.getSurgical().getUptime()));
		surgicaluptime.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				combat.getSurgical().setUptime(Float.parseFloat(surgicaluptime.getText()));
			}
		});
		raidbuff.add(surgicalbox);
		raidbuff.add(surgical);
		raidbuff.add(surgicalamount);
		raidbuff.add(surgicaluptime);
		
		
		
		
		
		JCheckBox pyrokinetict4box = new JCheckBox();
		pyrokinetict4box.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (pyrokinetict4box.isSelected()) {
					combat.getPyroKineticT4().setActive(true);
				} else {
					combat.getPyroKineticT4().setActive(false);
				}
			}
		});
		pyrokinetict4box.setSelected(combat.getPyroKineticT4().isActive());
		JLabel pyrokinetict4 = new JLabel("PyroKineticT4");
		JTextField pyrokinetict4amount = new JTextField(Float.toString(combat.getPyroKineticT4().getAmount()));
		pyrokinetict4amount.setEditable(false);
		JTextField pyrokinetict4uptime = new JTextField(Float.toString(combat.getPyroKineticT4().getUptime()));
		pyrokinetict4uptime.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				combat.getPyroKineticT4().setUptime(Float.parseFloat(pyrokinetict4uptime.getText()));
			}
		});
		raidbuff.add(pyrokinetict4box);
		raidbuff.add(pyrokinetict4);
		raidbuff.add(pyrokinetict4amount);
		raidbuff.add(pyrokinetict4uptime);
		
		
		
		
		
		JCheckBox dualfirebox = new JCheckBox();
		dualfirebox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (dualfirebox.isSelected()) {
					combat.getDualFire().setActive(true);
				} else {
					combat.getDualFire().setActive(false);
				}
			}
		});
		dualfirebox.setSelected(combat.getDualFire().isActive());
		JLabel dualfire = new JLabel("DualFire");
		JTextField dualfireamount = new JTextField(Float.toString(combat.getDualFire().getAmount()));
		dualfireamount.setEditable(false);
		JTextField dualfireuptime = new JTextField(Float.toString(combat.getDualFire().getUptime()));
		dualfireuptime.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				combat.getDualFire().setUptime(Float.parseFloat(dualfireuptime.getText()));
			}
		});
		raidbuff.add(dualfirebox);
		raidbuff.add(dualfire);
		raidbuff.add(dualfireamount);
		raidbuff.add(dualfireuptime);
		
		
		
		
		
		JCheckBox bloodthirstbox = new JCheckBox();
		bloodthirstbox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (bloodthirstbox.isSelected()) {
					combat.getBloodThirst().setActive(true);
				} else {
					combat.getBloodThirst().setActive(false);
				}
			}
		});
		bloodthirstbox.setSelected(combat.getBloodThirst().isActive());
		JLabel bloodthirst = new JLabel("BloodThirst");
		JTextField bloodthirstamount = new JTextField(Float.toString(combat.getBloodThirst().getAmount()));
		bloodthirstamount.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				combat.getBloodThirst().setAmount(Float.parseFloat(bloodthirstamount.getText()));
			}
		});
		JTextField bloodthirstuptime = new JTextField(Float.toString(combat.getBloodThirst().getUptime()));
		bloodthirstuptime.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				combat.getBloodThirst().setUptime(Float.parseFloat(bloodthirstuptime.getText()));
			}
		});
		raidbuff.add(bloodthirstbox);
		raidbuff.add(bloodthirst);
		raidbuff.add(bloodthirstamount);
		raidbuff.add(bloodthirstuptime);
		
		
		
		//input verifiers
		armorredamount.setInputVerifier(percentverifier);
		armorreduptime.setInputVerifier(percentverifier);
		reduceallresamount.setInputVerifier(percentverifier);
		reduceallresuptime.setInputVerifier(percentverifier);
		reducephysresamount.setInputVerifier(percentverifier);
		reducephysresuptime.setInputVerifier(percentverifier);
		reducemagresamount.setInputVerifier(percentverifier);
		reducemagresuptime.setInputVerifier(percentverifier);
		reducetechresamount.setInputVerifier(percentverifier);
		reducetechresuptime.setInputVerifier(percentverifier);
		reducedeflectamount.setInputVerifier(percentverifier);
		reducedeflectuptime.setInputVerifier(percentverifier);
		weaponspecdebuffamount.setInputVerifier(floatverifier);
		weaponspecdebuffuptime.setInputVerifier(percentverifier);
		technophiledebuffamount.setInputVerifier(floatverifier);
		technophiledebuffuptime.setInputVerifier(percentverifier);
		spellweaverdebuffamount.setInputVerifier(floatverifier);
		spellweaverdebuffuptime.setInputVerifier(percentverifier);
		punishamount.setInputVerifier(percentverifier);
		punishuptime.setInputVerifier(percentverifier);
		powerlinkamount.setInputVerifier(percentverifier);
		powerlinkuptime.setInputVerifier(percentverifier);
		powerlinkt4amount.setInputVerifier(percentverifier);
		powerlinkt4uptime.setInputVerifier(percentverifier);		
		empoweringamount.setInputVerifier(percentverifier);
		empoweringuptime.setInputVerifier(percentverifier);		
		empoweringt4amount.setInputVerifier(percentverifier);
		empoweringt4uptime.setInputVerifier(percentverifier);
		empoweringauraamount.setInputVerifier(percentverifier);
		empoweringaurauptime.setInputVerifier(percentverifier);
		voidpactamount.setInputVerifier(percentverifier);
		voidpactuptime.setInputVerifier(percentverifier);
		surgicalamount.setInputVerifier(percentverifier);
		surgicaluptime.setInputVerifier(percentverifier);
		pyrokinetict4amount.setInputVerifier(percentverifier);
		pyrokinetict4uptime.setInputVerifier(percentverifier);
		dualfireamount.setInputVerifier(percentverifier);
		dualfireuptime.setInputVerifier(percentverifier);
		bloodthirstamount.setInputVerifier(percentverifier);
		bloodthirstuptime.setInputVerifier(percentverifier);
		
		
		
		this.setLayout(new GridLayout(1, 1));
		raidbuff.setBorder(BorderFactory.createLineBorder(Color.black));
		this.add(raidbuff);
	}

}
