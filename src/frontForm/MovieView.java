package frontForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class MovieView {
	
	JFrame mainFrame;
	JPanel controlPanel;
	private static JLabel statusLabel;
	
	public MovieView(){movieGui();}
	
	private void movieGui() {
		mainFrame = new JFrame("Movie List From Current Folder");
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent){
				System.exit(0); } } );
	    mainFrame.setSize(500,700);
	    mainFrame.setLocationRelativeTo(null);
	    statusLabel = new JLabel("",JLabel.CENTER);
	    statusLabel.setText("STATUS LABEL");
	    
	    //create a menu bar
	      final JMenuBar menuBar = new JMenuBar();
	    //create menus
	      JMenu fileMenu = new JMenu("File");
	      JMenu editMenu = new JMenu("Edit"); 
	      JMenu aboutMenu = new JMenu("About");
	      JMenu linkMenu = new JMenu("Links");
	    //create menu items
	      JMenuItem newMenuItem = new JMenuItem("New");
	      newMenuItem.setActionCommand("New");
	      JMenuItem openMenuItem = new JMenuItem("Open");
	      openMenuItem.setActionCommand("Open");
	      JMenuItem exitMenuItem = new JMenuItem("Exit");
	      exitMenuItem.setActionCommand("Exit");
	      JMenuItem cutMenuItem = new JMenuItem("Cut");
	      cutMenuItem.setActionCommand("Cut");
	      JMenuItem copyMenuItem = new JMenuItem("Copy");
	      copyMenuItem.setActionCommand("Copy");
	      JMenuItem pasteMenuItem = new JMenuItem("Paste");
	      pasteMenuItem.setActionCommand("Paste");
	    //add menu items to menus
	      fileMenu.add(newMenuItem);
	      fileMenu.add(openMenuItem);
	      fileMenu.addSeparator();
	      fileMenu.add(exitMenuItem);        	      
	      editMenu.add(cutMenuItem);
	      editMenu.add(copyMenuItem);
	      editMenu.add(pasteMenuItem);
	    //add menu to menubar
	      menuBar.add(fileMenu);
	      menuBar.add(editMenu);
	      menuBar.add(aboutMenu);       
	      menuBar.add(linkMenu);
	    //add menubar to the frame
	      mainFrame.setJMenuBar(menuBar);
	      
	      MovieControl setStatusLabel = new MovieControl();
	      pasteMenuItem.addActionListener(setStatusLabel);
	      
	      JButton refreshButton = new JButton("Odśwież liste filmów");
	      JButton nameChangeButton = new JButton("Zmień nazwę pozycji");
	      JButton watchButton = new JButton("Odtwórz film");
	      
	      refreshButton.setActionCommand("refresh");
	      nameChangeButton.setActionCommand("newName");
	      watchButton.setActionCommand("watch");
      
	      controlPanel = new JPanel();
	      controlPanel.add(refreshButton);
	      controlPanel.add(nameChangeButton);
	      controlPanel.add(watchButton);
	      JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, controlPanel, statusLabel);
	      mainFrame.add(splitPane);
      
	      refreshButton.addActionListener(new ButtonClickListener());
	      nameChangeButton.addActionListener(new ButtonClickListener());
	      watchButton.addActionListener(new ButtonClickListener());
      
	}
	
	public static void changeStatusLabel(String str) {statusLabel.setText(str);}
	class ButtonClickListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();  
			
			if( command.equals( "refresh" ))  {
				statusLabel.setText("Odśwież liste filmów");
			} else if( command.equals( "newName" ) )  {
				statusLabel.setText("Zmień nazwę pozycji"); 
			} else {
				statusLabel.setText("Odtwórz film");
			} } }
	
	void showGui() {mainFrame.setVisible(true);}

}