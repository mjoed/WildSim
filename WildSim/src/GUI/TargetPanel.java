package GUI;

import helpers.FloatVerifier;
import helpers.PercentageVerifier;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.InputVerifier;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import classes.WildstarMob;

@SuppressWarnings("serial")
public class TargetPanel extends JPanel {
		
	JTextField deflectinsert;
	JTextField armorinsert;
	JTextField physresinsert;
	JTextField magresinsert;
	JTextField techresinsert;
	
	WildstarMob target;
	
	
	public TargetPanel(WildstarMob target) {
		
		this.target = target;
		
		InputVerifier percentverifier = new PercentageVerifier(this);
		InputVerifier floatverifier = new FloatVerifier(this);
		
		this.setLayout(new FlowLayout());
		this.setPreferredSize(new Dimension(240, 100));
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel targetStats = new JLabel("Target Stats");
		targetStats.setPreferredSize(new Dimension(120, 20));
		JLabel targetStats2 = new JLabel("###");
		targetStats2.setPreferredSize(new Dimension(120, 20));

		
		this.add(targetStats);
		this.add(targetStats2);
		
		JLabel deflect = new JLabel("Deflect: ");
		deflect.setPreferredSize(new Dimension(120, 20));
		deflectinsert = new JTextField(Float.toString(target.getDeflectchance()));
		deflectinsert.setPreferredSize(new Dimension(120, 20));
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
		armor.setPreferredSize(new Dimension(120, 20));
		armorinsert = new JTextField(Float.toString(target.getArmor()));
		armorinsert.setPreferredSize(new Dimension(120, 20));
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
		physres.setPreferredSize(new Dimension(120, 20));
		physresinsert = new JTextField(Float.toString(target.getPhysRes()));
		physresinsert.setPreferredSize(new Dimension(120, 20));
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
		magres.setPreferredSize(new Dimension(120, 20));
		magresinsert = new JTextField(Float.toString(target.getMagRes()));
		magresinsert.setPreferredSize(new Dimension(120, 20));
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
		techres.setPreferredSize(new Dimension(120, 20));
		techresinsert = new JTextField(Float.toString(target.getTechRes()));
		techresinsert.setPreferredSize(new Dimension(120, 20));
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
	
		deflectinsert.setInputVerifier(percentverifier);
		armorinsert.setInputVerifier(floatverifier);
		physresinsert.setInputVerifier(floatverifier);
		magresinsert.setInputVerifier(floatverifier);
		techresinsert.setInputVerifier(floatverifier);
	
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
	
	public String getCurrentValues() {
		StringBuilder valuestring = new StringBuilder();
		valuestring.append(deflectinsert.getText() + ";");
		valuestring.append(armorinsert.getText() + ";");
		valuestring.append(physresinsert.getText() + ";");
		valuestring.append(magresinsert.getText() + ";");
		valuestring.append(techresinsert.getText() + ";");
		valuestring.append(System.lineSeparator());
		return valuestring.toString();
	}
	
	public void setCurrentValues(String currVal) {
		String[] values = currVal.split(";");
		
		deflectinsert.setText(values[0]);
		target.setDeflectchanceBase(Float.parseFloat(values[0]));
		armorinsert.setText(values[1]);
		target.setArmorBase(Float.parseFloat(values[1]));
		physresinsert.setText(values[2]);
		target.setPhysResBase(Float.parseFloat(values[2]));
		magresinsert.setText(values[3]);
		target.setMagResBase(Float.parseFloat(values[3]));
		techresinsert.setText(values[4]);
		target.setTechResBase(Float.parseFloat(values[4]));
	}

}
