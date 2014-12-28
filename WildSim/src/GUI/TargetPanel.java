package GUI;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import classes.WildstarMob;

@SuppressWarnings("serial")
public class TargetPanel extends JPanel {
	
	public TargetPanel(WildstarMob target) {
		this.setLayout(new GridLayout(8, 2));
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel targetStats = new JLabel("Target Stats");
		JLabel targetStats2 = new JLabel("###");
		
		this.add(targetStats);
		this.add(targetStats2);
		
		JLabel deflect = new JLabel("Deflect: ");
		JTextField deflectinsert = new JTextField(Float.toString(target.getDeflectchance()));
		deflectinsert.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				target.setDeflectchanceBase(Float.parseFloat(deflectinsert.getText()));
			}
		});
		
		JLabel armor = new JLabel("Armor: ");
		JTextField armorinsert = new JTextField(Float.toString(target.getArmor()));
		armorinsert.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				target.setArmorBase(Float.parseFloat(armorinsert.getText()));
			}
		});
		
		JLabel physres = new JLabel("Phys. Res.: ");
		JTextField physresinsert = new JTextField(Float.toString(target.getPhysRes()));
		physresinsert.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				target.setPhysResBase(Float.parseFloat(physresinsert.getText()));
			}
		});
	
		JLabel magres = new JLabel("Mag. Res.: ");
		JTextField magresinsert = new JTextField(Float.toString(target.getMagRes()));
		magresinsert.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				target.setMagResBase(Float.parseFloat(magresinsert.getText()));
			}
		});
	
		JLabel techres = new JLabel("Tech Res.: ");
		JTextField techresinsert = new JTextField(Float.toString(target.getTechRes()));
		techresinsert.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				target.setTechResBase(Float.parseFloat(techresinsert.getText()));
			}
		});
	
		this.add(deflect);
		this.add(deflectinsert);
		this.add(armor);
		this.add(armorinsert);
		this.add(physres);
		this.add(physresinsert);
		this.add(magres);
		this.add(magresinsert);
		this.add(techres);
		this.add(techresinsert);

	}

}
