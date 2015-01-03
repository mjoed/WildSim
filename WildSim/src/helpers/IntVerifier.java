package helpers; 

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class IntVerifier extends InputVerifier {
	
	JComponent comp;
	
	public IntVerifier(JComponent comp) {
		this.comp = comp;
	}

	@Override
	public boolean verify(JComponent input) {
		String text =((JTextField) input).getText();
		
		@SuppressWarnings("unused")
		float  n = 0; 

		
        try {
        	n = Integer.parseInt(text); 
        } catch (NumberFormatException e) {
            Runnable runnable = new Runnable() {
                public void run() {
                  JOptionPane.showMessageDialog(comp,
                      "Not a Integer!", "Error",
                      JOptionPane.ERROR_MESSAGE);
                }
            };
            SwingUtilities.invokeLater(runnable);
        	return false; 
        }
        
        return true;
	}
}