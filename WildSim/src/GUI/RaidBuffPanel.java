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
	
	JCheckBox armorredbox;
	JTextField armorredamount;
	JTextField armorreduptime;
	
	JCheckBox reduceallresbox;
	JTextField reduceallresamount;
	JTextField reduceallresuptime;

	JCheckBox reducephysresbox;
	JTextField reducephysresuptime;

	JCheckBox reducemagresbox;
	JTextField reducemagresamount;
	JTextField reducemagresuptime;

	JCheckBox reducetechresbox;
	JTextField reducetechresamount;
	JTextField reducetechresuptime;

	JCheckBox reducedeflectbox;
	JTextField reducedeflectamount;
	JTextField reducedeflectuptime;

	JCheckBox weaponspecdebuffbox;
	JTextField weaponspecdebuffamount;
	JTextField weaponspecdebuffuptime;

	JCheckBox technophiledebuffbox;
	JTextField technophiledebuffamount;
	JTextField technophiledebuffuptime;

	JCheckBox spellweaverdebuffbox;
	JTextField spellweaverdebuffamount;
	JTextField spellweaverdebuffuptime;

	JCheckBox punishbox;
	JTextField punishuptime;

	JCheckBox powerlinkbox;
	JTextField powerlinkamount;
	JTextField powerlinkuptime;

	JCheckBox powerlinkt4box;
	JTextField powerlinkt4uptime;

	JCheckBox empoweringbox;
	JTextField empoweringamount;
	JTextField empoweringuptime;

	JCheckBox empoweringt4box;
	JTextField empoweringt4uptime;

	JCheckBox empoweringaurabox;
	JTextField empoweringaurauptime;


	JCheckBox voidpactbox;
	JTextField voidpactamount;
	JTextField voidpactuptime;


	JCheckBox surgicalbox;
	JTextField surgicaluptime;

	JCheckBox pyrokinetict4box;
	JTextField pyrokinetict4uptime;

	JCheckBox dualfirebox;
	JTextField dualfireuptime;


	JCheckBox bloodthirstbox;
	JTextField bloodthirstamount;
	JTextField bloodthirstuptime;
	
	Combat combat;
	
	public RaidBuffPanel(Combat combat) {
		
		this.combat = combat;
		
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
				
		armorredbox = new JCheckBox();
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
		armorredamount = new JTextField(Float.toString(combat.getArmorRed().getAmount()));
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
		armorreduptime = new JTextField(Float.toString(combat.getArmorRed().getUptime()));
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
		
		
		
		
		reduceallresbox = new JCheckBox();
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
		reduceallresamount = new JTextField(Float.toString(combat.getReduceAllRes().getAmount()));
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
		reduceallresuptime = new JTextField(Float.toString(combat.getReduceAllRes().getUptime()));
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
		
		
		
		
		
		reducephysresbox = new JCheckBox();
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
		reducephysresuptime = new JTextField(Float.toString(combat.getReducePhysRes().getUptime()));
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
		
		
		
		
		
		reducemagresbox = new JCheckBox();
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
		reducemagresamount = new JTextField(Float.toString(combat.getReduceMagRes().getAmount()));
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
		reducemagresuptime = new JTextField(Float.toString(combat.getReduceMagRes().getUptime()));
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
				
		
		
		
		
		reducetechresbox = new JCheckBox();
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
		reducetechresamount = new JTextField(Float.toString(combat.getReduceTechRes().getAmount()));
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
		reducetechresuptime = new JTextField(Float.toString(combat.getReduceTechRes().getUptime()));
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
		
		
		
		
		
		reducedeflectbox = new JCheckBox();
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
		reducedeflectamount = new JTextField(Float.toString(combat.getReduceDeflect().getAmount()));
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
		reducedeflectuptime = new JTextField(Float.toString(combat.getReduceDeflect().getUptime()));
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
				
		
		
		weaponspecdebuffbox = new JCheckBox();
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
		weaponspecdebuffamount = new JTextField(Float.toString(combat.getWeaponSpecDebuff().getAmount()));
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
		weaponspecdebuffuptime = new JTextField(Float.toString(combat.getWeaponSpecDebuff().getUptime()));
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
		
		
		
		
		
		technophiledebuffbox = new JCheckBox();
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
		technophiledebuffamount = new JTextField(Float.toString(combat.getTechnophileDebuff().getAmount()));
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
		technophiledebuffuptime = new JTextField(Float.toString(combat.getTechnophileDebuff().getUptime()));
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
		
		
		
		
		
		spellweaverdebuffbox = new JCheckBox();
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
		spellweaverdebuffamount = new JTextField(Float.toString(combat.getSpellweaverDebuff().getAmount()));
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
		spellweaverdebuffuptime = new JTextField(Float.toString(combat.getSpellweaverDebuff().getUptime()));
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
		
		
		punishbox = new JCheckBox();
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
		punishuptime = new JTextField(Float.toString(combat.getPunish().getUptime()));
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
		
		
		
		
		
		powerlinkbox = new JCheckBox();
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
		powerlinkamount = new JTextField(Float.toString(combat.getPowerLink().getAmount()));
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
		powerlinkuptime = new JTextField(Float.toString(combat.getPowerLink().getUptime()));
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
		
		
		
		
		
		powerlinkt4box = new JCheckBox();
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
		powerlinkt4uptime = new JTextField(Float.toString(combat.getPowerLinkT4().getUptime()));
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
		
		
		
		
		
		empoweringbox = new JCheckBox();
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
		empoweringamount = new JTextField(Float.toString(combat.getEmpowering().getAmount()));
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
		empoweringuptime = new JTextField(Float.toString(combat.getEmpowering().getUptime()));
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
		
		
		
		
		
		empoweringt4box = new JCheckBox();
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
		empoweringt4uptime = new JTextField(Float.toString(combat.getEmpoweringT4().getUptime()));
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
		
		
		
		
		
		empoweringaurabox = new JCheckBox();
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
		empoweringaurauptime = new JTextField(Float.toString(combat.getEmpoweringAura().getUptime()));
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
		
		
		
		
		
		voidpactbox = new JCheckBox();
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
		voidpactamount = new JTextField(Float.toString(combat.getVoidPact().getAmount()));
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
		voidpactuptime = new JTextField(Float.toString(combat.getVoidPact().getUptime()));
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
		
		
		
		
		
		surgicalbox = new JCheckBox();
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
		surgicaluptime = new JTextField(Float.toString(combat.getSurgical().getUptime()));
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
		
		
		
		
		
		pyrokinetict4box = new JCheckBox();
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
		pyrokinetict4uptime = new JTextField(Float.toString(combat.getPyroKineticT4().getUptime()));
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
		
		
		
		
		
		dualfirebox = new JCheckBox();
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
		dualfireuptime = new JTextField(Float.toString(combat.getDualFire().getUptime()));
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
		
		
		
		
		
		bloodthirstbox = new JCheckBox();
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
		bloodthirstamount = new JTextField(Float.toString(combat.getBloodThirst().getAmount()));
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
		bloodthirstuptime = new JTextField(Float.toString(combat.getBloodThirst().getUptime()));
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
	
	public String getCurrentValues() {
		StringBuilder valuestring = new StringBuilder();
		valuestring.append(armorredbox.isSelected() + ";" + armorredamount.getText() + ";" + armorreduptime.getText() + ";");
		valuestring.append(reduceallresbox.isSelected() + ";" + reduceallresamount.getText() + ";" + reduceallresuptime.getText() + ";");
		valuestring.append(reducephysresbox.isSelected() + ";" + reducephysresuptime.getText() + ";");
		valuestring.append(reducemagresbox.isSelected() + ";" + reducemagresamount.getText() + ";" + reducemagresuptime.getText() + ";");
		valuestring.append(reducetechresbox.isSelected() + ";" + reducetechresamount.getText() + ";" + reducetechresuptime.getText() + ";");
		valuestring.append(reducedeflectbox.isSelected() + ";" + reducedeflectamount.getText() + ";" + reducedeflectuptime.getText() + ";");
		valuestring.append(weaponspecdebuffbox.isSelected() + ";" + weaponspecdebuffamount.getText() + ";" + weaponspecdebuffuptime.getText() + ";");
		valuestring.append(technophiledebuffbox.isSelected() + ";" + technophiledebuffamount.getText() + ";" + technophiledebuffuptime.getText() + ";");
		valuestring.append(spellweaverdebuffbox.isSelected() + ";" + spellweaverdebuffamount.getText() + ";" + spellweaverdebuffuptime.getText() + ";");
		valuestring.append(punishbox.isSelected() + ";" + punishuptime.getText() + ";");
		valuestring.append(powerlinkbox.isSelected() + ";" + powerlinkamount.getText() + ";" + powerlinkuptime.getText() + ";");
		valuestring.append(powerlinkt4box.isSelected() + ";" + powerlinkt4uptime.getText() + ";");
		valuestring.append(empoweringbox.isSelected() + ";" + empoweringamount.getText() + ";" + empoweringuptime.getText() + ";");
		valuestring.append(empoweringt4box.isSelected() + ";" + empoweringt4uptime.getText() + ";");
		valuestring.append(empoweringaurabox.isSelected() + ";" + empoweringaurauptime.getText() + ";");
		valuestring.append(voidpactbox.isSelected() + ";" + voidpactamount.getText() + ";" + voidpactuptime.getText() + ";");
		valuestring.append(surgicalbox.isSelected() + ";" + surgicaluptime.getText() + ";");
		valuestring.append(pyrokinetict4box.isSelected() + ";" + pyrokinetict4uptime.getText() + ";");
		valuestring.append(dualfirebox.isSelected() + ";" + dualfireuptime.getText() + ";");
		valuestring.append(bloodthirstbox.isSelected() + ";" + bloodthirstamount.getText() + ";" + bloodthirstuptime.getText() + ";");
		valuestring.append(System.lineSeparator());
		
		return valuestring.toString();
	}
	
	public void setCurrentValues(String currVal) {
		String[] values = currVal.split(";");
		
		combat.getArmorRed().setActive(Boolean.parseBoolean(values[0]));
		armorredbox.setSelected(Boolean.parseBoolean(values[0]));
		combat.getArmorRed().setAmount(Float.parseFloat(values[1]));
		armorredamount.setText(values[1]);
		combat.getArmorRed().setUptime(Float.parseFloat(values[2]));
		armorreduptime.setText(values[2]);
		
		combat.getReduceAllRes().setActive(Boolean.parseBoolean(values[3]));
		reduceallresbox.setSelected(Boolean.parseBoolean(values[3]));
		combat.getReduceAllRes().setAmount(Float.parseFloat(values[4]));
		reduceallresamount.setText(values[4]);
		combat.getReduceAllRes().setUptime(Float.parseFloat(values[5]));
		reduceallresuptime.setText(values[5]);
		
		combat.getReducePhysRes().setActive(Boolean.parseBoolean(values[6]));
		reducephysresbox.setSelected(Boolean.parseBoolean(values[6]));
		combat.getReducePhysRes().setUptime(Float.parseFloat(values[7]));
		reducephysresuptime.setText(values[7]);
		
		combat.getReduceMagRes().setActive(Boolean.parseBoolean(values[8]));
		reducemagresbox.setSelected(Boolean.parseBoolean(values[8]));
		combat.getReduceMagRes().setAmount(Float.parseFloat(values[9]));
		reducemagresamount.setText(values[9]);
		combat.getReduceMagRes().setUptime(Float.parseFloat(values[10]));
		reducemagresuptime.setText(values[10]);
		
		combat.getReduceTechRes().setActive(Boolean.parseBoolean(values[11]));
		reducetechresbox.setSelected(Boolean.parseBoolean(values[11]));
		combat.getReduceTechRes().setAmount(Float.parseFloat(values[12]));
		reducetechresamount.setText(values[12]);
		combat.getReduceTechRes().setUptime(Float.parseFloat(values[13]));
		reducetechresuptime.setText(values[13]);
		
		combat.getReduceDeflect().setActive(Boolean.parseBoolean(values[14]));
		reducedeflectbox.setSelected(Boolean.parseBoolean(values[14]));
		combat.getReduceDeflect().setAmount(Float.parseFloat(values[15]));
		reducedeflectamount.setText(values[15]);
		combat.getReduceDeflect().setUptime(Float.parseFloat(values[16]));
		reducedeflectuptime.setText(values[16]);
		
		combat.getWeaponSpecDebuff().setActive(Boolean.parseBoolean(values[17]));
		weaponspecdebuffbox.setSelected(Boolean.parseBoolean(values[17]));
		combat.getWeaponSpecDebuff().setAmount(Float.parseFloat(values[18]));
		weaponspecdebuffamount.setText(values[18]);
		combat.getWeaponSpecDebuff().setUptime(Float.parseFloat(values[19]));
		weaponspecdebuffuptime.setText(values[19]);
		
		combat.getTechnophileDebuff().setActive(Boolean.parseBoolean(values[20]));
		technophiledebuffbox.setSelected(Boolean.parseBoolean(values[20]));
		combat.getTechnophileDebuff().setAmount(Float.parseFloat(values[21]));
		technophiledebuffamount.setText(values[21]);
		combat.getTechnophileDebuff().setUptime(Float.parseFloat(values[22]));
		technophiledebuffuptime.setText(values[22]);
		
		combat.getSpellweaverDebuff().setActive(Boolean.parseBoolean(values[23]));
		spellweaverdebuffbox.setSelected(Boolean.parseBoolean(values[23]));
		combat.getSpellweaverDebuff().setAmount(Float.parseFloat(values[24]));
		spellweaverdebuffamount.setText(values[24]);
		combat.getSpellweaverDebuff().setUptime(Float.parseFloat(values[25]));
		spellweaverdebuffuptime.setText(values[25]);
		
		combat.getPunish().setActive(Boolean.parseBoolean(values[26]));
		punishbox.setSelected(Boolean.parseBoolean(values[26]));
		combat.getPunish().setUptime(Float.parseFloat(values[27]));
		punishuptime.setText(values[27]);
		
		combat.getPowerLink().setActive(Boolean.parseBoolean(values[28]));
		powerlinkbox.setSelected(Boolean.parseBoolean(values[28]));
		combat.getPowerLink().setAmount(Float.parseFloat(values[29]));
		powerlinkamount.setText(values[29]);
		combat.getPowerLink().setUptime(Float.parseFloat(values[30]));
		powerlinkuptime.setText(values[30]);
		
		combat.getPowerLinkT4().setActive(Boolean.parseBoolean(values[31]));
		powerlinkt4box.setSelected(Boolean.parseBoolean(values[31]));
		combat.getPowerLinkT4().setUptime(Float.parseFloat(values[32]));
		powerlinkt4uptime.setText(values[32]);
		
		combat.getEmpowering().setActive(Boolean.parseBoolean(values[33]));
		empoweringbox.setSelected(Boolean.parseBoolean(values[33]));
		combat.getEmpowering().setAmount(Float.parseFloat(values[34]));
		empoweringamount.setText(values[34]);
		combat.getEmpowering().setUptime(Float.parseFloat(values[35]));
		empoweringuptime.setText(values[35]);
		
		combat.getEmpoweringT4().setActive(Boolean.parseBoolean(values[36]));
		empoweringt4box.setSelected(Boolean.parseBoolean(values[36]));
		combat.getEmpoweringT4().setUptime(Float.parseFloat(values[37]));
		empoweringt4uptime.setText(values[37]);
		
		combat.getEmpoweringAura().setActive(Boolean.parseBoolean(values[38]));
		empoweringaurabox.setSelected(Boolean.parseBoolean(values[38]));
		combat.getEmpoweringAura().setUptime(Float.parseFloat(values[39]));
		empoweringaurauptime.setText(values[39]);
		
		combat.getVoidPact().setActive(Boolean.parseBoolean(values[40]));
		voidpactbox.setSelected(Boolean.parseBoolean(values[40]));
		combat.getVoidPact().setAmount(Float.parseFloat(values[41]));
		voidpactamount.setText(values[41]);
		combat.getVoidPact().setUptime(Float.parseFloat(values[42]));
		voidpactuptime.setText(values[42]);
		
		combat.getSurgical().setActive(Boolean.parseBoolean(values[43]));
		surgicalbox.setSelected(Boolean.parseBoolean(values[43]));
		combat.getSurgical().setUptime(Float.parseFloat(values[44]));
		surgicaluptime.setText(values[44]);
		
		combat.getPyroKineticT4().setActive(Boolean.parseBoolean(values[45]));
		pyrokinetict4box.setSelected(Boolean.parseBoolean(values[45]));
		combat.getPyroKineticT4().setUptime(Float.parseFloat(values[46]));
		pyrokinetict4uptime.setText(values[46]);
		
		combat.getDualFire().setActive(Boolean.parseBoolean(values[47]));
		dualfirebox.setSelected(Boolean.parseBoolean(values[47]));
		combat.getDualFire().setUptime(Float.parseFloat(values[48]));
		dualfireuptime.setText(values[48]);
		
		combat.getBloodThirst().setActive(Boolean.parseBoolean(values[49]));
		bloodthirstbox.setSelected(Boolean.parseBoolean(values[49]));
		combat.getBloodThirst().setAmount(Float.parseFloat(values[50]));
		bloodthirstamount.setText(values[50]);
		combat.getBloodThirst().setUptime(Float.parseFloat(values[51]));
		bloodthirstuptime.setText(values[51]);
		
	}

}
