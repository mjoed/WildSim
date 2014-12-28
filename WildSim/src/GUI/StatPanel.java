package GUI;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import classes.WildstarClass;

@SuppressWarnings("serial")
public class StatPanel extends JPanel {
	
	public StatPanel(WildstarClass player) {
		
		this.setLayout(new GridLayout(8, 2));
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel playerStats = new JLabel("Player Stats");
		JLabel playerStats2 = new JLabel("###");
		
		this.add(playerStats);
		this.add(playerStats2);
		
		JLabel ap = new JLabel("AP: ");
		JTextField apinsert = new JTextField(Float.toString(player.getAP()));
		apinsert.addActionListener(e -> {
			player.setAP(Float.parseFloat(e.getActionCommand()));
			apinsert.setText(Float.toString(player.getAP()));
		});
		apinsert.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				player.setAP(Float.parseFloat(apinsert.getText()));
			}
		});
		
		JLabel sp = new JLabel("SP: ");
		JTextField spinsert = new JTextField(Float.toString(player.getSP()));
		spinsert.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				player.setSP(Float.parseFloat(spinsert.getText()));
			}
		});
		
		JLabel crit = new JLabel("Crit: ");
		JTextField critinsert = new JTextField(Float.toString(player.getCrit()));
		critinsert.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				player.setCrit(Float.parseFloat(critinsert.getText()));
			}
		});
		
		
		JLabel critsev = new JLabel("CritSev: ");
		JTextField critsevinsert = new JTextField(Float.toString(player.getCritSev()));
		critsevinsert.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				player.setCritSev(Float.parseFloat(critsevinsert.getText()));
			}
		});
		
		
		JLabel strike = new JLabel("Strikethrough: ");
		JTextField strikeinsert = new JTextField(Float.toString(player.getStrikethrough()));
		strikeinsert.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				player.setStrikethrough(Float.parseFloat(strikeinsert.getText()));
			}
		});
		
		
		JLabel armorpierce = new JLabel("ArmorPierce: ");
		JTextField armorpierceinsert = new JTextField(Float.toString(player.getArmorPierce()));
		armorpierceinsert.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				player.setArmorPierce(Float.parseFloat(armorpierceinsert.getText()));
			}
		});
		
		
		JLabel cdr = new JLabel("CDR: ");
		JTextField cdrinsert = new JTextField(Float.toString(player.getCDReduction()));
		cdrinsert.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				player.setCDReduction(Float.parseFloat(cdrinsert.getText()));
			}
		});
		
		
		this.add(ap);
		this.add(apinsert);
		this.add(sp);
		this.add(spinsert);
		this.add(crit);
		this.add(critinsert);
		this.add(critsev);
		this.add(critsevinsert);
		this.add(strike);
		this.add(strikeinsert);
		this.add(armorpierce);
		this.add(armorpierceinsert);
		this.add(cdr);
		this.add(cdrinsert);
	}

}
