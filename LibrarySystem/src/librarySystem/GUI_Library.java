package librarySystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import java.sql.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


class databaseCon implements Database{

	@Override
	public void getBooks() {
		System.out.println("Get books from Database");
	}

	@Override
	public void getLibrary() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getUsers() {
		// TODO Auto-generated method stub
		
	}	
}

public class GUI_Library {

	private JFrame frmLibrarySystem;
	private JPanel homePanel, booksPanel, libraryPanel, signupPanel;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Library window = new GUI_Library();
					window.frmLibrarySystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		GUI_Library main = new GUI_Library();
		main.Connection();
		
		databaseCon con = new databaseCon();
		con.getBooks();
		con.getLibrary();
		con.getUsers();
	}
	
	private void Connection() {
		SQLConnector();
	}
	
	public GUI_Library() {
		initialize();		
	}
	
	private void SQLConnector() {
		
		final String DB_URL = "jdbc:mysql://localhost:3306/library system";
		final String USERNAME = "root";
		final String PASSWORD = "";
		
		//String insertIntoDB = "INSERT INTO book (ID, Title, Description, Author, Quantity) VALUES (11,'xyz', 'Description1', 'Adesh', 10)";
		String getFromDb = "SELECT * FROM book;";
		
		Connection con = null;
		Statement stmt = null;
		ArrayList<Books> dbStuff = new ArrayList<Books>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
				
				stmt = con.createStatement();
				
				ResultSet rs = stmt.executeQuery(getFromDb);	

				while(rs.next())
				{
					Books book = new Books();
					book.Id = rs.getInt(1);
					book.title = rs.getString(2);
					book.description = rs.getString(3);
					book.author = rs.getString(4);
					book.quantity = rs.getInt(5);	
					
					dbStuff.add(book);
				}
				
			} catch (SQLException ex) {
				System.out.println("SQL Error: " + ex);
			}
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		
		for(int i = 0; i < dbStuff.size(); i++) {
			System.out.println(dbStuff.get(i).Id + " " + dbStuff.get(i).title + " " + dbStuff.get(i).description + " " + dbStuff.get(i).author + " " + dbStuff.get(i).quantity);
		}
	}

	private void initialize() {
		frmLibrarySystem = new JFrame();
		frmLibrarySystem.setTitle("Library System");
		frmLibrarySystem.setBounds(100, 100, 751, 650);
		frmLibrarySystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel navPanel = new JPanel();
		navPanel.setBackground(Color.GREEN);
		frmLibrarySystem.getContentPane().add(navPanel, BorderLayout.NORTH);
		
		JLayeredPane layeredPane = new JLayeredPane();
		frmLibrarySystem.getContentPane().add(layeredPane, BorderLayout.CENTER);		
		
		signupPanel = new JPanel();
		signupPanel.setBounds(0, 0, 737, 582);
		layeredPane.add(signupPanel);
		signupPanel.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(173, 22, 369, 481);
		signupPanel.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel firstname= new JLabel("First Name");
		firstname.setBounds(10, 10, 134, 30);
		panel_6.add(firstname);
		
		JTextField text1= new JTextField();
		text1.setBounds(178, 10, 165, 30);
		panel_6.add(text1);
		
		JLabel lastname= new JLabel("Last Name");
		lastname.setBounds(10, 50, 134, 30);
		panel_6.add(lastname);
		
		JTextField text2= new JTextField();
		text2.setBounds(178, 50, 165, 30);
		panel_6.add(text2);
		
		JLabel gender= new JLabel("Gender");
		gender.setBounds(10, 90, 134, 30);
		panel_6.add(gender);
		
		JTextField text3= new JTextField();
		text3.setBounds(178, 90, 165, 30);
		panel_6.add(text3);
		
		JLabel birthdate= new JLabel("Date of Birth");
		birthdate.setBounds(10, 130, 134, 30);
		panel_6.add(birthdate);
		
		JTextField text4 = new JTextField();
		text4.setBounds(178, 130, 165, 30);
		panel_6.add(text4);
		
		JLabel address = new JLabel("Address");
		address.setBounds(10, 170, 134, 30);
		panel_6.add(address);
		
		JTextField text5= new JTextField();
		text5.setBounds(178, 170, 165, 30);
		panel_6.add(text5);
		
		JLabel phone = new JLabel("Phone Number");
		phone.setBounds(10, 210, 134, 30);
		panel_6.add(phone);
		
		JTextField text6 = new JTextField();
		text6.setBounds(178, 210, 165, 30);
		panel_6.add(text6);
		
		JLabel emailaddress= new JLabel("Email Address");
		emailaddress.setBounds(10, 250, 134, 30);
		panel_6.add(emailaddress);
		
		JTextField text7= new JTextField();
		text7.setBounds(178, 250, 165, 30);
		panel_6.add(text7);
		
		JLabel username = new JLabel("Username");
		username.setBounds(10, 290, 134, 30);
		panel_6.add(username);
		
		JTextField text8= new JTextField();
		text8.setBounds(178, 290, 165, 30);
		panel_6.add(text8);
		
		JLabel password = new JLabel("Password");
		password.setBounds(10, 330, 134, 30);
		panel_6.add(password);
		
		JTextField text9= new JTextField();
		text9.setBounds(178, 330, 165, 30);
		panel_6.add(text9);
		
		
		JLabel confirmpassword = new JLabel("Confirm Password");
		confirmpassword.setBounds(10, 370, 134, 30);
		panel_6.add(confirmpassword);
		
		JTextField text10= new JTextField();
		text10.setBounds(178, 370, 165, 30);
		panel_6.add(text10);
		
		JButton submitBtn = new JButton("Submit");
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		submitBtn.setBounds(134, 437, 85, 21);
		panel_6.add(submitBtn);
		
		homePanel = new JPanel();
		homePanel.setBackground(Color.ORANGE);
		homePanel.setBounds(0, 0, 737, 582);
		layeredPane.add(homePanel);
		homePanel.setLayout(new BoxLayout(homePanel, BoxLayout.X_AXIS));
		
		booksPanel = new JPanel();
		booksPanel.setBackground(Color.PINK);
		booksPanel.setBounds(0, 0, 737, 582);
		layeredPane.add(booksPanel);
		booksPanel.setLayout(new GridLayout(0, 3, 5, 5));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		booksPanel.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		booksPanel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		booksPanel.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		booksPanel.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		booksPanel.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		booksPanel.add(panel_5);
		
		libraryPanel = new JPanel();
		libraryPanel.setBackground(Color.CYAN);
		libraryPanel.setBounds(0, 0, 737, 582);
		layeredPane.add(libraryPanel);
		
		JButton homeBtn = new JButton("Home");
		homeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelVisibility(true, false,false, false);
			}
		});
		navPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		navPanel.add(homeBtn);
		
		JButton bookBtn = new JButton("Books");
		bookBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelVisibility(false, true,false, false);
			}
		});
		navPanel.add(bookBtn);
		
		JButton libraryBtn = new JButton("Library");
		libraryBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelVisibility(false, false,true, false);
			}
		});
		navPanel.add(libraryBtn);
		
		JButton signupBtn = new JButton("Sign Up");
		signupBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelVisibility(false, false, false, true);
			}
		});
		navPanel.add(signupBtn);
	}
	
	private void panelVisibility(boolean home, boolean books, boolean library, boolean signup) {
		homePanel.setVisible(home);
		booksPanel.setVisible(books);
		libraryPanel.setVisible(library);
		signupPanel.setVisible(signup);
	}
}
