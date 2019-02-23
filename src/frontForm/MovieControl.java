package frontForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovieControl implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		 new MovieModel(e.getActionCommand());
		
	}
}