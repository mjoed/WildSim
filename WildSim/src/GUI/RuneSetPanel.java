package GUI;

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

import combat.Combat;

@SuppressWarnings("serial")
public class RuneSetPanel extends JPanel {
	
	public RuneSetPanel(Combat combat) {
			

		JPanel runesets = new JPanel(new FlowLayout());
		runesets.setPreferredSize(new Dimension(450, 100));
		
		JLabel runesets1 = new JLabel("Active");
		runesets1.setPreferredSize(new Dimension(70, 20));
		JLabel runesets2 = new JLabel("RuneSet");
		runesets2.setPreferredSize(new Dimension(190, 20));
		JLabel runesets3 = new JLabel("#");
		runesets3.setPreferredSize(new Dimension(190, 20));
		
		
		
		//#
		JCheckBox assassinbox = new JCheckBox();
		assassinbox.setPreferredSize(new Dimension(70, 20));
		assassinbox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (assassinbox.isSelected()) {
					combat.getAssassin().setActive(true);
				} else {
					combat.getAssassin().setActive(false);
				}
			}
		});
		assassinbox.setSelected(combat.getAssassin().isActive());
		JLabel assassin = new JLabel("Assassin/FusionBlast: ");
		assassin.setPreferredSize(new Dimension(190, 20));
		JTextField assassininsert = new JTextField(Integer.toString(combat.getAssassin().getAmount()));
		assassininsert.setPreferredSize(new Dimension(190, 20));
		assassininsert.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				combat.getAssassin().setAmount(Integer.parseInt(assassininsert.getText()));
			}
		});
		
		
		
		//#
		JCheckBox weaponspecbox = new JCheckBox();
		weaponspecbox.setPreferredSize(new Dimension(70, 20));
		weaponspecbox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (weaponspecbox.isSelected()) {
					combat.getWeaponSpec().setActive(true);
				} else {
					combat.getWeaponSpec().setActive(false);
				}
			}
		});
		weaponspecbox.setSelected(combat.getWeaponSpec().isActive());
		JLabel weaponspec = new JLabel("Weapon Specialist: ");
		weaponspec.setPreferredSize(new Dimension(190, 20));
		JTextField weaponspecinsert = new JTextField(Integer.toString(combat.getWeaponSpec().getAmount()));
		weaponspecinsert.setPreferredSize(new Dimension(190, 20));
		weaponspecinsert.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				combat.getWeaponSpec().setAmount(Integer.parseInt(weaponspecinsert.getText()));
			}
		});
		
		
		
		//#
		JCheckBox specterbox = new JCheckBox();
		specterbox.setPreferredSize(new Dimension(70, 20));
		specterbox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (specterbox.isSelected()) {
					combat.getSpecter().setActive(true);
				} else {
					combat.getSpecter().setActive(false);
				}
			}
		});
		specterbox.setSelected(combat.getSpecter().isActive());
		JLabel specter = new JLabel("Specter: ");
		specter.setPreferredSize(new Dimension(190, 20));
		JTextField specterinsert = new JTextField(Integer.toString(combat.getSpecter().getAmount()));
		specterinsert.setPreferredSize(new Dimension(190, 20));
		specterinsert.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				combat.getSpecter().setAmount(Integer.parseInt(specterinsert.getText()));
			}
		});
		
		
		
		//#
		JCheckBox uabox = new JCheckBox();
		uabox.setPreferredSize(new Dimension(70, 20));
		uabox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (uabox.isSelected()) {
					combat.getUnfairAdvantage().setActive(true);
				} else {
					combat.getUnfairAdvantage().setActive(false);
				}
			}
		});
		uabox.setSelected(combat.getUnfairAdvantage().isActive());
		JLabel ua = new JLabel("Unfair Advantage: ");
		ua.setPreferredSize(new Dimension(190, 20));
		JTextField uainsert = new JTextField(Integer.toString(combat.getUnfairAdvantage().getAmount()));
		uainsert.setPreferredSize(new Dimension(190, 20));
		uainsert.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				combat.getUnfairAdvantage().setAmount(Integer.parseInt(uainsert.getText()));
			}
		});
		
		
		
		//#
		JCheckBox suckerpbox = new JCheckBox();
		suckerpbox.setPreferredSize(new Dimension(70, 20));
		suckerpbox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (suckerpbox.isSelected()) {
					combat.getSuckerPunch().setActive(true);
				} else {
					combat.getSuckerPunch().setActive(false);
				}
			}
		});
		suckerpbox.setSelected(combat.getSuckerPunch().isActive());
		JLabel suckerp = new JLabel("Sucker Punch: ");
		suckerp.setPreferredSize(new Dimension(190, 20));
		JTextField suckerpinsert = new JTextField(Integer.toString(combat.getSuckerPunch().getAmount()));
		suckerpinsert.setPreferredSize(new Dimension(190, 20));
		suckerpinsert.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				combat.getSuckerPunch().setAmount(Integer.parseInt(suckerpinsert.getText()));
			}
		});
		
		runesets.add(runesets1);
		runesets.add(runesets2);
		runesets.add(runesets3);
		runesets.add(assassinbox);
		runesets.add(assassin);
		runesets.add(assassininsert);
		runesets.add(weaponspecbox);
		runesets.add(weaponspec);
		runesets.add(weaponspecinsert);
		runesets.add(specterbox);
		runesets.add(specter);
		runesets.add(specterinsert);
		runesets.add(uabox);
		runesets.add(ua);
		runesets.add(uainsert);
		runesets.add(suckerpbox);
		runesets.add(suckerp);
		runesets.add(suckerpinsert);
		
		
		this.setLayout(new GridLayout(1, 1));
		runesets.setBorder(BorderFactory.createLineBorder(Color.black));
		this.add(runesets);
		
		
	}

}
