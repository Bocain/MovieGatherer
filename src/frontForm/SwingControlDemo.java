package frontForm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingControlDemo {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private static JLabel statusLabel;
   private JPanel controlPanel;

   public SwingControlDemo(){
      prepareGUI();
   }
   public static void main(String[] args){
      SwingControlDemo swingControlDemo = new SwingControlDemo();  
      swingControlDemo.showEventDemo();       
   }
   private void prepareGUI(){
      mainFrame = new JFrame("Movie List From Current Folder");
      mainFrame.setSize(500,700);
      mainFrame.setLayout(new GridLayout(3, 1));

      headerLabel = new JLabel("",JLabel.LEFT);
      statusLabel = new JLabel("",JLabel.CENTER);        
      statusLabel.setSize(350,100);
      
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0); } } );   
      
      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);  
   }
   
   private void showEventDemo(){
	  //create a menu bar
      final JMenuBar menuBar = new JMenuBar();
      //create menus
      JMenu fileMenu = new JMenu("File");
      JMenu editMenu = new JMenu("Edit"); 
      final JMenu aboutMenu = new JMenu("About");
      final JMenu linkMenu = new JMenu("Links");
      //create menu items
      JMenuItem newMenuItem = new JMenuItem("New");
      newMenuItem.setMnemonic(KeyEvent.VK_N);
      newMenuItem.setActionCommand("New");

      JMenuItem openMenuItem = new JMenuItem("Open");
      openMenuItem.setActionCommand("Open");

      JMenuItem saveMenuItem = new JMenuItem("Save");
      saveMenuItem.setActionCommand("Save");

      JMenuItem exitMenuItem = new JMenuItem("Exit");
      exitMenuItem.setActionCommand("Exit");

      JMenuItem cutMenuItem = new JMenuItem("Cut");
      cutMenuItem.setActionCommand("Cut");

      JMenuItem copyMenuItem = new JMenuItem("Copy");
      copyMenuItem.setActionCommand("Copy");

      JMenuItem pasteMenuItem = new JMenuItem("Paste");
      pasteMenuItem.setActionCommand("Paste");

      MenuItemListener menuItemListener = new MenuItemListener();

      newMenuItem.addActionListener(menuItemListener);
      openMenuItem.addActionListener(menuItemListener);
      saveMenuItem.addActionListener(menuItemListener);
      exitMenuItem.addActionListener(menuItemListener);
      cutMenuItem.addActionListener(menuItemListener);
      copyMenuItem.addActionListener(menuItemListener);
      pasteMenuItem.addActionListener(menuItemListener);
      
      final JCheckBoxMenuItem showWindowMenu = new JCheckBoxMenuItem("Show About", true);
      showWindowMenu.addItemListener(new ItemListener() {
         public void itemStateChanged(ItemEvent e) {
            
            if(showWindowMenu.getState()){
               menuBar.add(aboutMenu);
            } else {
               menuBar.remove(aboutMenu);
            } } } );
      
      final JRadioButtonMenuItem showLinksMenu = new JRadioButtonMenuItem(
    	         "Show Links", true);
    	      showLinksMenu.addItemListener(new ItemListener() {
    	         public void itemStateChanged(ItemEvent e) {
    	            
    	            if(menuBar.getMenu(3)!= null){
    	               menuBar.remove(linkMenu);
    	               mainFrame.repaint();
    	            } else {                   
    	               menuBar.add(linkMenu);
    	               mainFrame.repaint();
    	            } } } );
      
      //add menu items to menus
      fileMenu.add(newMenuItem);
      fileMenu.add(openMenuItem);
      fileMenu.add(saveMenuItem);
      fileMenu.addSeparator();
      fileMenu.add(showWindowMenu);
      fileMenu.addSeparator();
      fileMenu.add(showLinksMenu);       
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
      
      headerLabel.setText("Control in action: Button"); 

      JButton okButton = new JButton("Odśwież liste filmów");
      JButton submitButton = new JButton("Zmień nazwę pozycji");
      JButton cancelButton = new JButton("Odtwórz film");

      okButton.setActionCommand("OK");
      submitButton.setActionCommand("Submit");
      cancelButton.setActionCommand("Cancel");
      
      

		/*
		 * okButton.addActionListener(new ButtonClickListener());
		 * submitButton.addActionListener(new ButtonClickListener());
		 * cancelButton.addActionListener(new ButtonClickListener());
		 */
      
      ButtonClickListener buttonAction = new ButtonClickListener();
      okButton.addActionListener(buttonAction); 
      submitButton.addActionListener(buttonAction); 
      cancelButton.addActionListener(buttonAction); 

      controlPanel.add(okButton);
      controlPanel.add(submitButton);
      controlPanel.add(cancelButton);       

      mainFrame.setVisible(true); }
   
   class MenuItemListener implements ActionListener {
	      public void actionPerformed(ActionEvent e) {            
	         statusLabel.setText(e.getActionCommand() + " JMenuItem clicked.");
	      }    
	   }
   /*
   class ButtonClickListener implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	       String command = e.getActionCommand();  
	       
	       if( command.equals( "OK" ))  {
	          statusLabel.setText("Ok Button clicked.");
	       } else if( command.equals( "Submit" ) )  {
	          statusLabel.setText("Submit Button clicked."); 
	       } else {
	          statusLabel.setText("Cancel Button clicked.");
	       } } }
   */
   public static void setStatusLabel(String statusLabelText) {
	   statusLabel.setText(statusLabelText);
   }

}
