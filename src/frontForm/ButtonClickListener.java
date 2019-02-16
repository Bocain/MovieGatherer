package frontForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import frontForm.SwingControlDemo;


class ButtonClickListener implements ActionListener{
	
    public void actionPerformed(ActionEvent e) {
       String command = e.getActionCommand();  
       
/*       
       if( command.equals( "OK" ))  {
    	  statusLabel.setText("Ok Button clicked.");
       } else if( command.equals( "Submit" ) )  {
          statusLabel.setText("Submit Button clicked."); 
       } else {
          statusLabel.setText("Cancel Button clicked.");
       } } }
*/
		if( command.equals( "OK" ))  {
			SwingControlDemo.setStatusLabel("Ok Button clicked.");
		} else if( command.equals( "Submit" ) )  {
			SwingControlDemo.setStatusLabel("Submit Button clicked."); 
		} else {
			SwingControlDemo.setStatusLabel("Cancel Button clicked.");
		} } }
