package frontForm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JTextArea;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MovieView {

	JFrame mainFrame;
	JPanel controlPanel;
	JTextArea output;
	private static JLabel statusLabel;

	public MovieView() {
		movieGui();
	}

	private void movieGui() {
		mainFrame = new JFrame("Movie List From Current Folder");
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		mainFrame.setSize(500, 700);
		mainFrame.setLocationRelativeTo(null);
		statusLabel = new JLabel("", JLabel.CENTER);
		statusLabel.setText("STATUS LABEL");

		// create a menu bar
		final JMenuBar menuBar = new JMenuBar();
		// create menus
		JMenu fileMenu = new JMenu("File");
		JMenu editMenu = new JMenu("Edit");
		JMenu aboutMenu = new JMenu("About");
		JMenu linkMenu = new JMenu("Links");
		// create menu items
		JMenuItem newMenuItem = new JMenuItem("New");
		newMenuItem.setActionCommand("New");
		JMenuItem openMenuItem = new JMenuItem("Open");
		openMenuItem.setActionCommand("Open");
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.setActionCommand("Exit");
		JMenuItem cutMenuItem = new JMenuItem("Do zagospodarowania");
		cutMenuItem.setActionCommand("Cut");
		JMenuItem copyMenuItem = new JMenuItem("Wersja językowa");
		copyMenuItem.setActionCommand("Copy");
		JMenuItem pasteMenuItem = new JMenuItem("Przywróć nazwy domyślne");
		pasteMenuItem.setActionCommand("Paste");
		// add menu items to menus
		fileMenu.add(newMenuItem);
		fileMenu.add(openMenuItem);
		fileMenu.addSeparator();
		fileMenu.add(exitMenuItem);
		editMenu.add(cutMenuItem);
		editMenu.add(copyMenuItem);
		editMenu.add(pasteMenuItem);
		// add menu to menubar
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(aboutMenu);
		menuBar.add(linkMenu);
		// add menubar to the frame
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

		refreshButton.addActionListener(new ButtonClickListener());
		nameChangeButton.addActionListener(new ButtonClickListener());
		watchButton.addActionListener(new ButtonClickListener());

		// MovieList.metoda11();
		JTable movieTable = new JTable(MovieList.CONTENT_ROWS, MovieList.HEADER_ROW);
		movieTable.setFillsViewportHeight(false);

		// get selected field
		int numberSelectedRowMovieTable = movieTable.getSelectedRow();
		try {
			String valueSelectedRowMovieTable = movieTable.getModel().getValueAt(numberSelectedRowMovieTable, 0)
					.toString();
			statusLabel.setText(valueSelectedRowMovieTable);
		} catch (Exception e) {
			System.out.println("Wybierz film");
		}
		;

		// get selected field second attempt
		ListSelectionModel listSelectionModel;
		listSelectionModel = movieTable.getSelectionModel();
		listSelectionModel.addListSelectionListener(new SharedListSelectionHandler());

		JScrollPane moviePane = new JScrollPane(movieTable);

		moviePane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
				"List of available movies", TitledBorder.CENTER, TitledBorder.TOP));

		JTextField searchFilm = new JTextField(10);

		JPanel testPanel = new JPanel();
		testPanel.add(controlPanel);
		testPanel.add(searchFilm);
		testPanel.add(statusLabel);
		testPanel.add(moviePane);
		testPanel.setLayout(new BoxLayout(testPanel, 1));
		mainFrame.add(testPanel);

	}

	int eliminateDoubleClick = 0;
	int secondClick = 9;

	class SharedListSelectionHandler implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			ListSelectionModel lsm = (ListSelectionModel) e.getSource();

			int firstIndex = e.getFirstIndex();
			int lastIndex = e.getLastIndex();
			boolean isAdjusting = e.getValueIsAdjusting();  
			
			if (lsm.isSelectionEmpty()) { System.out.println("Pusty wybór"); }
			else
			{int minIndex = lsm.getMinSelectionIndex();
             int maxIndex = lsm.getMaxSelectionIndex();
	            for (int i = minIndex; i <= maxIndex; i++) { 
	            	if (lsm.isSelectedIndex(i)) {eliminateDoubleClick = i; } 
	            }
	            
	            if(secondClick==eliminateDoubleClick) {;}
	            else {System.out.println(eliminateDoubleClick);
	            	secondClick=eliminateDoubleClick;}

			} 
			} }

	public static void changeStatusLabel(String str) {
		statusLabel.setText(str);
	}

	class ButtonClickListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();

			if (command.equals("refresh")) {
				statusLabel.setText("Odśwież liste filmów");
			} else if (command.equals("newName")) {
				statusLabel.setText("Zmień nazwę pozycji");
			} else {
				statusLabel.setText("Odtwórz film");
			}
		}
	}

	void showGui() {
		mainFrame.setVisible(true);
	}

}