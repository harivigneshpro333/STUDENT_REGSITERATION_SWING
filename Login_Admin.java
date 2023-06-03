package Management_DB;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//*****************************
import java.sql.*;

public class Login_Admin extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JTextField pass;
	public static Login_Admin frame;
	/**
	 * Launch the application.
	 */
	
//MainMethod  Started:	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new Login_Admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login_Admin() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 325, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
//label for Admin
		JLabel lblNewLabel_1 = new JLabel("ADMIN ");
		lblNewLabel_1.setForeground(new Color(0, 255, 255));
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_1.setBounds(112, 11, 98, 53);
		contentPane.add(lblNewLabel_1);
//label for Username 		
		JLabel lblNewLabel = new JLabel("USERNAME :");
		lblNewLabel.setForeground(new Color(128, 255, 255));
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 75, 132, 53);
		contentPane.add(lblNewLabel);
//Text field for Username
		user = new JTextField();
		user.setBackground(new Color(192, 192, 192));
		user.setFont(new Font("Times New Roman", Font.BOLD, 22));
		user.setColumns(10);
		user.setText("hari");
		user.setBounds(152, 81, 143, 32);
		contentPane.add(user);
//Label For Password
		JLabel lblNewLabel_2 = new JLabel("PASSWORD :");
		lblNewLabel_2.setForeground(new Color(128, 255, 255));
		lblNewLabel_2.setFont(new Font("Sitka Text", Font.BOLD, 20));
		lblNewLabel_2.setBounds(10, 139, 132, 34);
		contentPane.add(lblNewLabel_2);
//Text for Pasword
		pass = new JTextField();
		pass.setBackground(new Color(192, 192, 192));
		pass.setFont(new Font("Times New Roman", Font.BOLD, 22));
		pass.setColumns(10);
		pass.setText("3016");
		pass.setBounds(152, 135, 143, 34);
		contentPane.add(pass);
//Button for Clear the Data
		JButton clearbu = new JButton("Clear");
		clearbu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//Set The Textfield into Empty String 
				user.setText("");
			    pass.setText("");
			
			}
		});
		clearbu.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		clearbu.setBackground(new Color(254, 80, 97));
		clearbu.setBounds(24, 204, 107, 40);
		contentPane.add(clearbu);
//Button for LOgin	
		JButton loginbu = new JButton("Login");
		loginbu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
//Type Casting 	
				String user1=(String)user.getText();
				String pass1=(String)pass.getText();
//If Empty in textfield its Return Message to the user is Empty				
				if(user1.equals("")||pass1.equals("")) {
					JOptionPane.showMessageDialog(loginbu,"Enter Ur ID First");
					
				}
//Otherwise Execution start
				
				else {
//URL is LOcation in directory Db file Where it Placed
				String jdbcurl="jdbc:sqlite:C:\\Users\\Admin\\eclipse-workspace\\Student_management\\Student_DB.db";
				Connection Conn=DriverManager.getConnection(jdbcurl);
//Query For Read ALL from TABLE				
				String sql="SELECT * FROM LOGIN_FORM";
				Statement state=Conn.createStatement();
//Result Set used to read and Write here				
				ResultSet result=state.executeQuery(sql);
				String []us=new String[5];
				String []ps=new String[5];
				int u=0;
				while(result.next()) {			
					String user2=result.getString("USER");
					String pass2=result.getString("PASS");
//Store the data from db into the Array		
					us[u]=user2;
					ps[u]=pass2;
					 u++;

			}

				Boolean req=false;
//Check the DATA FROM DB To Textfield is Sample is Return True				
				for(int i=0;i<2;i++) {
					if(us[i].contentEquals(user1) && ps[i].contentEquals(pass1)) {
						req=true;
//if Condition is True then Break the loop
						break;
					}
				}
//req is True send the Message to user And Open Next Window 				
			if(req) {
				JOptionPane.showMessageDialog(loginbu, "login Sucessfully...");
// Create the Object to the Next Window here;
				Manage_page page = new Manage_page();
				page.setVisible(true);
				frame.setVisible(false);
				
			}
			else {
				JOptionPane.showMessageDialog(loginbu, "login Denied...");
			}
			
				}
			    }
			catch(Exception S) {
				System.out.println("loginbu"+S);
				
			}
			}
		});
		loginbu.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		loginbu.setBackground(new Color(122, 222, 135));
		loginbu.setBounds(177, 204, 114, 40);
		contentPane.add(loginbu);
//Label For Image in the Window;
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\background projects\\Black image.jpg"));
		lblNewLabel_3.setBounds(0, 0, 325, 266);
		contentPane.add(lblNewLabel_3);
	}
}
