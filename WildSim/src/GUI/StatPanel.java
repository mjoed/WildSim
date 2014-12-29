package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
		
		this.setLayout(new FlowLayout());
		this.setPreferredSize(new Dimension(225, 100));
		
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel playerStats = new JLabel("Player Stats");
		playerStats.setPreferredSize(new Dimension(120, 20));
		JLabel playerStats2 = new JLabel("###");
		playerStats2.setPreferredSize(new Dimension(120, 20));
		
		this.add(playerStats);
		this.add(playerStats2);
		
		JLabel ap = new JLabel("AP: ");
		ap.setPreferredSize(new Dimension(120, 20));
		JTextField apinsert = new JTextField(Float.toString(player.getAP()));
		apinsert.setPreferredSize(new Dimension(120, 20));
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
		sp.setPreferredSize(new Dimension(120, 20));
		JTextField spinsert = new JTextField(Float.toString(player.getSP()));
		spinsert.setPreferredSize(new Dimension(120, 20));
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
		crit.setPreferredSize(new Dimension(120, 20));
		JTextField critinsert = new JTextField(Float.toString(player.getCrit()));
		critinsert.setPreferredSize(new Dimension(120, 20));
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
		critsev.setPreferredSize(new Dimension(120, 20));
		JTextField critsevinsert = new JTextField(Float.toString(player.getCritSev()));
		critsevinsert.setPreferredSize(new Dimension(120, 20));
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
		strike.setPreferredSize(new Dimension(120, 20));
		JTextField strikeinsert = new JTextField(Float.toString(player.getStrikethrough()));
		strikeinsert.setPreferredSize(new Dimension(120, 20));
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
		armorpierce.setPreferredSize(new Dimension(120, 20));
		JTextField armorpierceinsert = new JTextField(Float.toString(player.getArmorPierce()));
		armorpierceinsert.setPreferredSize(new Dimension(120, 20));
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
		cdr.setPreferredSize(new Dimension(120, 20));
		JTextField cdrinsert = new JTextField(Float.toString(player.getCDReduction()));
		cdrinsert.setPreferredSize(new Dimension(120, 20));
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
