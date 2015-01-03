package helpers; 

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import classes.Ability;


public class PrioVerifier extends InputVerifier {
	
	JComponent comp;
	JTextField shredprio;
	JTextField impaleprio;
	JTextField ckprio;
	JTextField ruinprio;
	Ability shred;
	Ability impale;
	Ability ck;
	Ability ruin;
	//(1 -> shred, 2 -> impale, 3 -> ck, 4 -> ruin)
	int changedAbility;
	
	
	
	public PrioVerifier(JComponent comp, JTextField shredprio, JTextField impaleprio, JTextField ckprio, JTextField ruinprio, Ability shred, Ability impale, Ability ck, Ability ruin, int changedAbility) {
		this.comp = comp;
		this.shredprio = shredprio;
		this.impaleprio = impaleprio;
		this.ckprio = ckprio;
		this.ruinprio = ruinprio;
		this.shred = shred;
		this.impale = impale;
		this.ck = ck;
		this.ruin = ruin;
		this.changedAbility = changedAbility;
	}

	@Override
	public boolean verify(JComponent input) {
		String text =((JTextField) input).getText();
		int n = 0; 

		
        try {
        	n = Integer.parseInt(text); 
        } catch (NumberFormatException e) {
            Runnable runnable = new Runnable() {
                public void run() {
                  JOptionPane.showMessageDialog(comp,
                      "Not a Number!", "Error",
                      JOptionPane.ERROR_MESSAGE);
                }
            };
            SwingUtilities.invokeLater(runnable);
        	return false; 
        }
        
        if (n < 1 || n > 4) {
            Runnable runnable = new Runnable() {
                public void run() {
                  JOptionPane.showMessageDialog(comp,
                      "Must be between 1 and 4", "Error",
                      JOptionPane.ERROR_MESSAGE);
                }
            };
            SwingUtilities.invokeLater(runnable);
        	return false;
        }
        
        helpers.setPriorities(shredprio, impaleprio, ckprio, ruinprio, shred, impale, ck, ruin, changedAbility);
        	

        return true;
	}
}