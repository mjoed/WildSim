package helpers; 

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class PercentageVerifier extends InputVerifier {
	
	JComponent comp;
	
	public PercentageVerifier(JComponent comp) {
		this.comp = comp;
	}

	@Override
	public boolean verify(JComponent input) {
		String text =((JTextField) input).getText();
		
		float  n = 0; 

		
        try {
        	n = Float.parseFloat(text); 
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
        
        if (n < 0 || n > 1) {
            Runnable runnable = new Runnable() {
                public void run() {
                  JOptionPane.showMessageDialog(comp,
                      "Must be between 0%-100% ([0, 1])", "Error",
                      JOptionPane.ERROR_MESSAGE);
                }
            };
            SwingUtilities.invokeLater(runnable);
        	return false;
        }
        
        return true;
	}
}