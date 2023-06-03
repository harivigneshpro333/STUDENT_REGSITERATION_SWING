package Management_DB;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTree;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class Manage_page extends JFrame {

	private JPanel contentPane;
	private JTextField Name;
	public JTextField Mobile;
	public JTextField Course;
	public JTextField IDE;
	private JTable Table;
	public String jdbc="jdbc:sqlite:C:\\Users\\Admin\\eclipse-workspace\\Student_management\\Student_DB.db";
	public String z;
	public String Hour;
    public Boolean fin=false;
	

	
	

	/**
	 * Launch the application.
	 */
	
				
	/**
	 * Create the frame.
	 */
	public Manage_page() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
//Label for Student Headlines
		JLabel lblNewLabel = new JLabel("STUDENTS REGSTRATION");
		lblNewLabel.setForeground(new Color(0, 255, 255));
		lblNewLabel.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel.setBounds(265, 11, 315, 42);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(22, 53, 341, 311);
		contentPane.add(panel);
		panel.setLayout(null);
//Label for Entry 
		JLabel lblNewLabel_1 = new JLabel("ENTRY FORM");
		lblNewLabel_1.setForeground(new Color(0, 255, 255));
		lblNewLabel_1.setFont(new Font("Monotype Corsiva", Font.BOLD, 24));
		lblNewLabel_1.setBounds(94, 31, 163, 23);
		panel.add(lblNewLabel_1);
//Label for Name
		JLabel lblNewLabel_2 = new JLabel("NAME  :");
		lblNewLabel_2.setForeground(new Color(0, 255, 255));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel_2.setBounds(58, 90, 100, 29);
		panel.add(lblNewLabel_2);
//TextField for Name
		Name = new JTextField();
		Name.setFont(new Font("Monotype Corsiva", Font.BOLD, 25));
		Name.setBounds(162, 94, 158, 28);
		panel.add(Name);
		Name.setColumns(10);
//Label for Course
		JLabel lblNewLabel_2_1 = new JLabel("COURSE  :");
		lblNewLabel_2_1.setForeground(new Color(0, 255, 255));
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel_2_1.setBounds(33, 195, 119, 29);
		panel.add(lblNewLabel_2_1);
//textfield for Mobile
		Mobile = new JTextField();
		Mobile.setColumns(10);
		Mobile.setFont(new Font("Monotype Corsiva", Font.BOLD, 25));
		Mobile.setBounds(162, 145, 158, 28);
		panel.add(Mobile);
//Label for ID
		JLabel lblNewLabel_2_1_1 = new JLabel("NEW ID  :");
		lblNewLabel_2_1_1.setForeground(new Color(0, 255, 255));
		lblNewLabel_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel_2_1_1.setBounds(45, 248, 119, 29);
		panel.add(lblNewLabel_2_1_1);
//TextField for Course
		Course = new JTextField();
		Course.setColumns(10);
		Course.setFont(new Font("Monotype Corsiva", Font.BOLD, 25));
		Course.setBounds(162, 199, 158, 28);
		panel.add(Course);
//Label for Mobile
		JLabel lblNewLabel_2_2 = new JLabel("MOBILE  :");
		lblNewLabel_2_2.setForeground(new Color(0, 255, 255));
		lblNewLabel_2_2.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel_2_2.setBounds(33, 141, 119, 29);
		panel.add(lblNewLabel_2_2);
//TextField for Id	
		IDE = new JTextField();
		IDE.setColumns(10);
		IDE.setFont(new Font("Monotype Corsiva", Font.BOLD, 25));
		IDE.setBounds(162, 249, 158, 28);
		panel.add(IDE);
//Image for the Pane by using LABEL
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\background projects\\Black image.jpg"));
		lblNewLabel_3.setBounds(0, 0, 341, 311);
		panel.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 390, 764, 60);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
//Button for Clear the Data
		JButton clearbut = new JButton("CLEAR");
//Actionlistener for the Clear
		clearbut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//Set the Text into Empty by using ("")
				IDE.setText("");
				Name.setText("");
				Mobile.setText("");
				Course.setText("");
			}
		});
		clearbut.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 24));
		clearbut.setBounds(22, 11, 116, 39);
		panel_1.add(clearbut);
//Button for Update		
		JButton updatebut = new JButton("UPDATE");
//Actionlistener For the Update:
		updatebut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//Surrounding try/catch in DB Connetion is Compulsary;
				try {
//Take from the Textfield Data into the Here
					String g=IDE.getText();
					int i=Integer.parseInt(g);
					String na=(String)Name.getText();
					String mo=(String)Mobile.getText();
					String co=(String)Course.getText();
//Automatically take Hours to from The Courses data
					if(co.contentEquals("python")) {Hour="36hrs";}
					else if(co.contentEquals("java")) {Hour="48hrs";}
					else if(co.contentEquals("c")) {Hour="20hrs";}
					else if(co.contentEquals("fullstack")) {Hour="120hrs";}
					else if(co.contentEquals("webdesign")) {Hour="86hrs";}
					else if(co.contentEquals("php")) {Hour="40hrs";}
					else if(co.contentEquals("spring_boot")) {Hour="52hrs";}
					else if(co.contentEquals("c++")) {Hour="24hrs";}
					else if(co.contentEquals("selenium")) {Hour="20hrs";}
					
//Url for the Connect the DB By Using the Location of the DB File in Directory
					String jdbc1="jdbc:sqlite:C:\\Users\\Admin\\eclipse-workspace\\Student_management\\Student_DB.db";
//Connection Used to Connect by Device manager
					Connection con= DriverManager.getConnection(jdbc1);
//Query for the Updating  Data
					String UpQuery="UPDATE STUDENT_DETAILS SET MOBILE=?,COURSE=?, NAME=? ,HOURS=?  WHERE ID=?";
//PreparedStatement  for import Query And Create the Statement:
					PreparedStatement pstate=con.prepareStatement(UpQuery);
					
//Set the Value into The Query;
					  pstate.setString(1,mo);
					  pstate.setString(2,co);
					  pstate.setString(3,na);
					  pstate.setString(4,Hour);
					  pstate.setInt(5,i);
//Execute the Query by using ExecuteUpdate Method:
					  
					int res=pstate.executeUpdate(); //return 0 and 1 if True Return 1 else Return 0
//Give the Message to Admin to Put the Condition;
					if(res>0) {
//Popup Window show to Admin by using JOPTIONPANE 
						JOptionPane.showMessageDialog(updatebut,"UPDATE Successfully...");
//Call the Method purpose of  Displaying  Data From DB to Table in Window
						datab();
//Close the all Connection of DB
						con.close();
						pstate.close();
					}
					
				} catch (SQLException E1) {
					
					System.out.println("update"+E1);
					
				
				}
				
			
			
			}
		});
		updatebut.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 24));
		updatebut.setBounds(167, 11, 146, 38);
		panel_1.add(updatebut);
//button for Insert the DATA
		JButton insertbut = new JButton("INSERT");
		insertbut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
//Connection to Db				
				Connection Conn1=DriverManager.getConnection(jdbc);
				String FinEQuery="SELECT ID FROM STUDENT_DETAILS ";
//Statemnet for take data from db;				
				PreparedStatement psta=Conn1.prepareStatement(FinEQuery);
//Execute the Query by using resultSet execution:When Read The Data From DB Thatcase Using ResultSet Method
				ResultSet r1set=psta.executeQuery();
//Read The Data From DB to Separated Individually Byusing the Loop Until DATA Present
				while(r1set.next()) {
//Point the Required to Read Here;
					int check=r1set.getInt("ID");
//From TextField of IDE into String
					String jen=IDE.getText();
//TypeCasting into String from DB Data;
					String ch=Integer.toString(check);
//Compare the Data from DB and to TextField for IDE in Window
					if(ch.contentEquals(jen)) {
//Return True Otherwise in False
						fin=true;
//Break the Loop When The Condition is True
						break;
					}
					else {
						fin=false;
						
					}	
				}
//Connetion is Close
				Conn1.close();
				r1set.close();
				
				}catch(Exception d) {System.out.println("insert check "+d);}
//Given for Admin is Empty in Textfield To show The Empty by Joptionpane
				if(Name.getText().equals("")||Mobile.getText().equals("")||Course.getText().equals("")||IDE.getText().equals("")) {
					JOptionPane.showMessageDialog(insertbut, "Please Fill The Details Properly");
					
				
				}
//If Already Exists ID to Show its Already Exists:
				else if(fin) {
					JOptionPane.showMessageDialog(insertbut, "Already Exists ID");
					fin=false;
					
				}
//Otherwise Update the Insert the DATA into DB:
				else
				{
				
				try {
				String name=(String)Name.getText();
				String mobile=(String)Mobile.getText();
				String course=(String)Course.getText();
				String id=(String)IDE.getText();
				Hour="";
//Course to Required Hours Zone Give Here;
				if(course.contentEquals("python")) {Hour="";Hour="36hrs";}
				else if(course.contentEquals("java")) {Hour="";Hour="48hrs";}
				else if(course.contentEquals("c")) {Hour="";Hour="20hrs";}
				else if(course.contentEquals("fullstack")) {Hour="";Hour="120hrs";}
				else if(course.contentEquals("webdesign")) {Hour="";Hour="86hrs";}
				else if(course.contentEquals("php")) {Hour="";Hour="40hrs";}
				else if(course.contentEquals("spring_boot")) {Hour="";Hour="52hrs";}
				else if(course.contentEquals("c++")) {Hour="";Hour="24hrs";}
				else if(course.contentEquals("selenium")) {Hour="";Hour="20hrs";}
				
//Create Connection 
				Connection Conne=DriverManager.getConnection(jdbc);
				String upload="INSERT INTO STUDENT_DETAILS(ID,NAME,MOBILE,COURSE,HOURS)"+"VALUES(?,?,?,?,?)";
//Create Statement for Object(Model)		
				PreparedStatement state=Conne.prepareStatement(upload);
// set the to The Query;
				state.setString(1,id);
				state.setString(2,name);
				state.setString(3,mobile);
				state.setString(4,course);
				state.setString(5,Hour);
//Query Execution;				
				int result=state.executeUpdate();
//Call the method for Display and Show Message for User
				if(result>0) {
					JOptionPane.showMessageDialog(insertbut,"Insert Data Successfully");
					datab();
					Name.setText("");
					Mobile.setText("");
					Course.setText("");
					int Id=Integer.parseInt(id);
					int Z=Id+1;
				    z=Integer.toString(Z);
					IDE.setText(z);
//Close the Connection;
						Conne.close();
						state.close();
				}
			
				}catch(Exception s){System.out.println("insert"+s);}	
				}
			}
		});
		insertbut.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 24));
		insertbut.setBounds(467, 11, 127, 38);
		panel_1.add(insertbut);
		
//Button for Delete;
		JButton deletebut = new JButton("DELETE");
//ActionListener for Action for Delete Button;
		deletebut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
//Unquie Used to Delete Easily from the TextField in Window
					String deID=(String)IDE.getText();
// Url Location from the DB file in Directory
			String url="jdbc:sqlite:C:\\Users\\Admin\\eclipse-workspace\\Student_management\\Student_DB.db";
//Delete For Query
			String Query2="DELETE FROM STUDENT_DETAILS WHERE id=?";
//Create the Connection;			
			Connection con1= DriverManager.getConnection(url);
//Create the Statement;
			PreparedStatement dpst=con1.prepareStatement(Query2);
//Set the VALUE To DB
			dpst.setString(1,deID);
//Execution of Query 
			 int RowS=dpst.executeUpdate();
//Call Display and Message for User
			if(RowS>0) {
			  JOptionPane.showMessageDialog(deletebut,"Data Delete Sucessfully...");
			  datab();
			  IDE.setText("");
			  Name.setText("");
			  Mobile.setText("");
			  Course.setText("");
//Close the Connection
			  con1.close();
			  dpst.close();
			}
			
				
			}
			
				
				catch(Exception M) 
				{System.out.println("delete "+M);}
				
			}
			});
		
		deletebut.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 24));
		deletebut.setBounds(615, 11, 127, 38);
		panel_1.add(deletebut);
// Button for Find DATA From DB;
		JButton findbut = new JButton("FIND");
//ActionListener for Action When Click this Button
		findbut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
//Connect the Sql by DriverManager
					Connection Connect1=DriverManager.getConnection(jdbc);
//query for Seach and read the Data from db;
					String FinQuery="SELECT * FROM STUDENT_DETAILS WHERE ID=?";
//Statemnet for take data from db;				
					PreparedStatement pst=Connect1.prepareStatement(FinQuery);
// set the primary key Set String here;				
					pst.setString(1, IDE.getText());
//Execute the Query by using resultSet execution:
					ResultSet rset=pst.executeQuery();
			     
					if(rset.next()) {
						String Navalue=rset.getString("NAME");
						String Covalue=rset.getString("COURSE");
						String Movalue=rset.getString("MOBILE");
						Name.setText(Navalue);
						Mobile.setText(Movalue);
						Course.setText(Covalue);
//Close the  Connection						
						Connect1.close();
						pst.close();
						
					}
					else {
						
						JOptionPane.showMessageDialog(findbut, "Data is Null From DB");
					}
					
					
				} catch (SQLException e1) {
					
					System.out.println("Find"+e1);
				}
				
				
			}
		});
		findbut.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 24));
		findbut.setBounds(337, 11, 107, 39);
		panel_1.add(findbut);
//Label for Set Image in Window
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\background projects\\White news.jpg"));
		lblNewLabel_4.setBounds(0, 0, 764, 60);
		panel_1.add(lblNewLabel_4);
//Scrollpane for the Table:
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(379, 53, 395, 311);
		contentPane.add(scrollPane);
//Create the Table For Display The Data From DB
		Table = new JTable();
		Table.setForeground(new Color(0, 0, 0));
		Table.setBackground(new Color(128, 128, 192));
		Table.setFont(new Font("Monotype Corsiva", Font.ITALIC, 18));
		scrollPane.setViewportView(Table);
//Create the label For Image in Window
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\background projects\\wallpaperflare.com_wallpaper.jpg"));
		lblNewLabel_5.setBounds(0, 0, 784, 461);
		contentPane.add(lblNewLabel_5);
		datab();
		
		    
		
	}
//Create Method For Display Data From DB 
public void datab() {
	
	try {
//connect to sql:
		
		
		Connection Connect=DriverManager.getConnection(jdbc);
//Statement used to create new DAta from db		
		Statement st=Connect.createStatement();
//Query for read all
		String Query="SELECT *FROM STUDENT_DETAILS";
//Execute the query	
		ResultSet rs=st.executeQuery(Query);
//Set meta data by using take  columns also ;		
		ResultSetMetaData rsmd=rs.getMetaData();
//create the model for Table in Swing
		DefaultTableModel model=(DefaultTableModel)Table.getModel();
//Count the How many column from db
		int col=rsmd.getColumnCount();
//create the colname arrays with add the column from db
		String []colname=new String[col];
// run until data in db foor will be run 
		for(int i=0;i<col;i++)
		{
// is the method in model to add column:
			colname[i]=rsmd.getColumnName(i+1);
	}
//column will be from the db to read and add to Table model
		model.setColumnIdentifiers(colname);
//used to set to the row assigning new value
		String iD,NAme,MObile,COurse,HOUrs;
//row will set a Empty like set("")
		model.setRowCount(0);
//read the set to the table model by using while loop to untill db data requirement:		
		while(rs.next()) {
			
			iD=rs.getString(1);
			NAme=rs.getString(2);
			MObile=rs.getString(3);
			COurse=rs.getString(4);
			HOUrs=rs.getString(5);
//create one array to Add the rows from db;
			String[] rows= {iD,NAme,MObile,COurse,HOUrs};
//pre-defined methos to add the arrays into the table rows:
			
			model.addRow(rows);
		}
		
//close the Conn;
		st.close();
		Connect.close();
		
		
	}
	catch (SQLException e) {
		System.out.println("Display Datab"+e);
	}
	
	
	
	
	
}
}
