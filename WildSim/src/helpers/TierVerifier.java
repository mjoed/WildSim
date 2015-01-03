package helpers; 

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class TierVerifier extends InputVerifier {
	
	JComponent comp;
	
	public TierVerifier(JComponent comp) {
		this.comp = comp;
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
                      "Not a valid Ability Tier! (0-8)", "Error",
                      JOptionPane.ERROR_MESSAGE);
                }
            };
            SwingUtilities.invokeLater(runnable);
        	return false; 
        }
        
        if (n < 0 || n > 8) {
            Runnable runnable = new Runnable() {
                public void run() {
                  JOptionPane.showMessageDialog(comp,
                      "Not a valid Ability Tier! (0-8)", "Error",
                      JOptionPane.ERROR_MESSAGE);
                }
            };
            SwingUtilities.invokeLater(runnable);
        	return false;
        }

        return true;
	}
}