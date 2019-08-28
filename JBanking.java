package jbankingpackage;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class JBanking
{
	private JFrame frame1,frame2,frame3,frame4,frame5;

	JTextField text1,text2,text3,text4,text5,text6,text7;
	JPasswordField pass1;

	static double totalamount=0,amount;
	static int acno;
	static String password;
	int count=0;

	public static void main(String[] args){
			
		JBanking window1 = new JBanking();
		window1.frame1.setVisible(true);

	}

	public JBanking(){

		initialize1();
	}


	private void initialize1(){

		frame1 = new JFrame();
		frame1.setTitle("Banking");
		frame1.setBounds(400,70,700,400);
		frame1.setResizable(false);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c1=frame1.getContentPane();
		c1.setLayout(null);

		Font f1=new Font("Arial",Font.BOLD,20);
		Font f2=new Font("Arial",Font.PLAIN,20);

		Cursor cur1=new Cursor(Cursor.HAND_CURSOR);

		JLabel label1=new JLabel("ACCOUNT NUMBER");
		label1.setBounds(140,75,230,50);
		c1.add(label1);
		label1.setFont(f1);

		text1=new JTextField();
		text1.setBounds(370,75,290,50);
		c1.add(text1);
		text1.setFont(f2);

		JLabel label2=new JLabel();
		label2.setText("PASSWORD");
		label2.setBounds(140,170,230,50);
		label2.setFont(f1);
		c1.add(label2);

		pass1=new JPasswordField();
		pass1.setBounds(370,170,290,50);
		pass1.setFont(f2);
		c1.add(pass1);

		JButton button1=new JButton("OK");
		button1.setBounds(540,280,70,40);
		button1.setCursor(cur1);
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event1){

					matchData1();
					if(count==1) {
						

						initialize2();
						frame1.setVisible(false);
						JOptionPane optionpane=new JOptionPane();
						optionpane.showMessageDialog(frame2, "LOGIN SUCCESSFULL");
					}
					else {
						
						JOptionPane optionpane10=new JOptionPane();
						optionpane10.showMessageDialog(frame1, "INCORRECT LOGIN DETAILS");
					}
			}
			
		});
		c1.add(button1);

		JLabel background1=new JLabel(new ImageIcon("F:/My projects/JBanking/9fc0dcf592abff4ba9d9cba6e2a17b13.jpg"));
		background1.setBounds(0,0,700,400);
		c1.add(background1);
		
	}

	private void initialize2(){

		frame2=new JFrame("Banking");
		frame2.setBounds(400,70,700,600);
		frame2.setResizable(false);
		frame2.setVisible(true);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c2=frame2.getContentPane();
		c2.setLayout(null);

		Font f3,f4; 
		f3=new Font("Arial",Font.BOLD,20);
		f4=new Font("Arial",Font.BOLD,25);

		Cursor cur2=new Cursor(Cursor.HAND_CURSOR);

		JLabel label3=new JLabel("WELCOME");
		label3.setBounds(250,10,200,50);
		label3.setFont(f3);
		c2.add(label3);

		JLabel label4=new JLabel("SERVICES ARE PROVIDED");
		label4.setBounds(175,45,350,50);
		label4.setFont(f3);
		c2.add(label4);

		JLabel label5=new JLabel("1.");
		label5.setBounds(50,130,40,40);
		label5.setFont(f4);
		c2.add(label5);

		JButton button2=new JButton("DIPOSITE ");
		button2.setBounds(100,130,220,40);
		button2.setCursor(cur2);
		button2.setFont(f4);
 		button2.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent event2){

				initialize3();
			}
		});
		c2.add(button2);

		JLabel label6 =new JLabel("2.");
		label6.setBounds(50,200,40,40);
		label6.setFont(f4);
		c2.add(label6);

		JButton button3 = new JButton("WITHDRAW");
		button3.setBounds(100,200,220,40);
		button3.setCursor(cur2);
		button3.setFont(f4);
		button3.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent event4){

				initialize4();
			}
		});
		c2.add(button3);

		JLabel label7=new JLabel("3.");
		label7.setBounds(50,270,40,40);
		label7.setFont(f4);
		c2.add(label7);

		JButton button4 =new JButton("TRANSFER");
		button4.setBounds(100,270,220,40);
		button4.setCursor(cur2);
		button4.setFont(f4);
		button4.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent event6){

				initialize5();
			}
		});
		c2.add(button4);

		JLabel label8 =new JLabel("4.");
		label8.setBounds(50,340,40,40);
		label8.setFont(f4);
		c2.add(label8);

		JButton button5 =new JButton("BALANCE");
		button5.setBounds(100,340,220,40);
		button5.setCursor(cur2);
		button5.setFont(f4);
		button5.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent event8){

				balance();
			}
		});
		c2.add(button5);

		JLabel label9 =new JLabel("5.");
		label9.setBounds(50,410,40,40);
		label9.setFont(f4);
		c2.add(label9);

		JButton button6 =new JButton("EXIT");
		button6.setBounds(100,410,220,40);
		button6.setCursor(cur2);
		button6.setFont(f4);
		button6.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent event9){

				System.exit(0);
			}
		});
		c2.add(button6);


		JLabel background2=new JLabel(new ImageIcon("F:/My projects/JBanking/9fc0dcf592abff4ba9d9cba6e2a17b13.jpg"));
		background2.setBounds(0,0,700,600);
		c2.add(background2);
		

	}	
	private void initialize3()
	{

			frame3 =new JFrame("DIPOSITE");
			frame3.setBounds(400,70,700,400);
			frame3.setResizable(false);
			frame3.setVisible(true);
			frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			Container c3=frame3.getContentPane();
			c3.setLayout(null);

			Font f5;
			f5=new Font("Arial",Font.BOLD,20);

			Cursor cur3 =new Cursor(Cursor.HAND_CURSOR);

			JLabel label10 =new JLabel("DIPOSITE TO BANK");
			label10.setBounds(175,15,350,50);
			label10.setFont(f5);
			c3.add(label10);

			JLabel label11 =new JLabel("ENTER AMOUNT");
			label11.setBounds(50,70,230,50);
			label11.setFont(f5);
			c3.add(label11);

			text2=new JTextField();
			text2.setBounds(280,70,290,50);
			text2.setFont(f5);
			c3.add(text2);

			JButton button7 = new JButton("OK");
			button7.setBounds(400,200,70,40);
			button7.setCursor(cur3);
			button7.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent event3){


						diposite();
						frame3.setVisible(false);
						
				}
			});
			c3.add(button7);


		JLabel background3=new JLabel(new ImageIcon("F:/My projects/JBanking/9fc0dcf592abff4ba9d9cba6e2a17b13.jpg"));
		background3.setBounds(0,0,700,400);
		c3.add(background3);
		

	}

	private void diposite(){

		amount=Double.parseDouble(text2.getText());
		acno=Integer.parseInt(text1.getText());
		
		Connection con2=null;
		Statement st2=null;
		ResultSet rs2;
		
		if(amount>0 && amount<=100000){
			try {
		
				Class.forName("com.mysql.jdbc.Driver");
	
				con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/jbanking_schema","root","NCSDsaha@12345");
		
				st2=con2.createStatement();
				rs2=st2.executeQuery("select cbalance from customer where cacno="+acno);
				
				rs2.next();
				
				totalamount=rs2.getDouble("cbalance");
				
				totalamount+=amount;
				
				st2.executeUpdate("update customer set cbalance="+totalamount+" where cacno="+acno);
				
				JOptionPane optionpane=new JOptionPane();
				optionpane.showMessageDialog(frame3, amount+" SUCCESSFULLY DIPOSITED\nUPDATED BALANCE IS "+totalamount);
		
				
			}
		
			catch (ClassNotFoundException e) {
			
				System.out.println("exception2 "+e.getMessage());
	
			} 
			catch (SQLException e) {
			
				System.out.println("sql exception4 "+e.getMessage());
			}
		
			try {
				st2.close();
			}
			catch (SQLException e) {
				System.out.println("sql exception 5 "+e.getMessage());
			}
		
			try {
				con2.close();
			}
			catch (SQLException e) {
				System.out.println("sql exception 6 "+e.getMessage());
			}
		
		}
		else{

			JOptionPane optionPane2=new JOptionPane();
			optionPane2.showMessageDialog(frame3,"PLEASE ENTER AMOUNT\nBETWEEN 1 TO 100000");
		}
	}

	private void initialize4(){

			frame4 =new JFrame("WITHDRAW");
			frame4.setBounds(400,70,700,400);
			frame4.setResizable(false);
			frame4.setVisible(true);
			frame4.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			Container c4=frame4.getContentPane();
			c4.setLayout(null);

			Font f6;
			f6=new Font("Arial",Font.BOLD,20);

			Cursor cur4 =new Cursor(Cursor.HAND_CURSOR);

			JLabel label12 =new JLabel("WITHDRAW FROM BANK");
			label12.setBounds(175,15,350,50);
			label12.setFont(f6);
			c4.add(label12);

			JLabel label13 =new JLabel("ENTER AMOUNT");
			label13.setBounds(50,70,230,50);
			label13.setFont(f6);
			c4.add(label13);

			text3=new JTextField();
			text3.setBounds(280,70,290,50);
			text3.setFont(f6);
			c4.add(text3);

			JButton button8 = new JButton("OK");
			button8.setBounds(400,200,70,40);
			button8.setCursor(cur4);
			button8.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent event5){


						withdraw();
						frame4.setVisible(false);
						
				}
			});
			c4.add(button8);


		JLabel background4=new JLabel(new ImageIcon("F:/My projects/JBanking/9fc0dcf592abff4ba9d9cba6e2a17b13.jpg"));
		background4.setBounds(0,0,700,400);
		c4.add(background4);
		

	}

	private void withdraw(){


		amount=Double.parseDouble(text3.getText());
		acno=Integer.parseInt(text1.getText());
		Connection con3=null;
		Statement st3=null;
		ResultSet rs3;

		try {
			
			Class.forName("com.mysql.jdbc.Driver");

			con3=DriverManager.getConnection("jdbc:mysql://localhost:3306/jbanking_schema","root","NCSDsaha@12345");
	
			st3=con3.createStatement();
			rs3=st3.executeQuery("select cbalance from customer where cacno="+acno);
			
			rs3.next();
			
			totalamount=rs3.getDouble("cbalance");
		
			if(totalamount>=amount){
			
				totalamount-=amount;
				st3.executeUpdate("update customer set cbalance="+totalamount+" where cacno="+acno);
				JOptionPane optionPane3=new JOptionPane();
				optionPane3.showMessageDialog(frame4,amount+" SUCCESSFULLY WITHDRAWN\n\nUPDATED BALANCE IS: "+totalamount);
			}
			else if(amount>100000){

				JOptionPane optionPane4=new JOptionPane();
				optionPane4.showMessageDialog(frame4,"PLEASE ENTER AMOUNT\nBELOW OR EQUAL 100000");
			}
			else{

			JOptionPane optionPane5=new JOptionPane();
			optionPane5.showMessageDialog(frame4,"INSUFFICIENT BALANCE");

			}
		}
		
		catch (ClassNotFoundException e) {
			
			System.out.println("exception2 "+e.getMessage());

		} 
		catch (SQLException e) {
		
			System.out.println("sql exception4 "+e.getMessage());
		}
	
		try {
			st3.close();
		}
		catch (SQLException e) {
			System.out.println("sql exception 5 "+e.getMessage());
		}
	
		try {
			con3.close();
		}
		catch (SQLException e) {
			System.out.println("sql exception 6 "+e.getMessage());
		}
	

	}



	private void initialize5(){

			frame5 =new JFrame("TRANSFER");
			frame5.setBounds(400,70,700,510);
			frame5.setResizable(false);
			frame5.setVisible(true);
			frame5.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			Container c5=frame5.getContentPane();
			c5.setLayout(null);

			Font f7,f8;
			f7=new Font("Arial",Font.BOLD,20);
			f8=new Font("Arial",Font.BOLD,15);

			Cursor cur5 =new Cursor(Cursor.HAND_CURSOR);

			JLabel label14 =new JLabel("TRANSFER FROM BANK");
			label14.setBounds(175,15,350,50);
			label14.setFont(f7);
			c5.add(label14);

			JLabel label16 =new JLabel("BENEFICERY ACCOUNT NUMBER");
			label16.setBounds(15,90,340,40);
			label16.setFont(f8);
			c5.add(label16);

			text5=new JTextField();
			text5.setBounds(310,90,320,40);
			text5.setFont(f7);
			c5.add(text5);

			/*JLabel label17 =new JLabel("IFSC CODE");
			label17.setBounds(190,160,340,40);
			label17.setFont(f8);
			c5.add(label17);

			text6=new JTextField();
			text6.setBounds(310,160,320,40);
			text6.setFont(f7);
			c5.add(text6);*/

			JLabel label18 =new JLabel("BENEFICERY NAME");
			label18.setBounds(124,160,340,40);
			label18.setFont(f8);
			c5.add(label18);

			text7=new JTextField();
			text7.setBounds(310,160,320,40);
			text7.setFont(f7);
			c5.add(text7);

			JLabel label15 =new JLabel("ENTER AMOUNT");
			label15.setBounds(142,230,220,40);
			label15.setFont(f8);
			c5.add(label15);

			text4=new JTextField();
			text4.setBounds(310,230,320,40);
			text4.setFont(f7);
			c5.add(text4);

			JButton button9 = new JButton("OK");
			button9.setBounds(450,320,70,40);
			button9.setCursor(cur5);
			button9.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent event7){


						transfer();
						frame5.setVisible(false);
						
				}
			});
			c5.add(button9);


		JLabel background5=new JLabel(new ImageIcon("F:/My projects/JBanking/9fc0dcf592abff4ba9d9cba6e2a17b13.jpg"));
		background5.setBounds(0,0,700,510);
		c5.add(background5);
		

	}
	private void transfer(){


		amount=Double.parseDouble(text4.getText());
		acno=Integer.parseInt(text1.getText());
		int bacno=Integer.parseInt(text5.getText());
		String bname=text7.getText();
		
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jbanking_schema","root","NCSDsaha@12345");
			st=con.createStatement();
			
			rs=st.executeQuery("select cbalance from customer where cacno="+acno);
			rs.next();
			totalamount=rs.getDouble("cbalance");
			
			
			rs=st.executeQuery("select cbalance from customer where cacno="+bacno);
			rs.next();
			double btotalamount=rs.getDouble("cbalance");

			if(totalamount>=amount){
		
				totalamount-=amount;
				st.executeUpdate("update customer set cbalance="+totalamount+" where cacno="+acno);
				
				btotalamount+=amount;
				st.executeUpdate("update customer set cbalance="+btotalamount+" where cacno="+bacno);
				
				JOptionPane optionPane6=new JOptionPane();
				optionPane6.showMessageDialog(frame5,amount+" SUCCESSFULLY TRANSFERED TO "+bname+"\n YOUR UPDATED BALANCE IS: "+totalamount);
			}
			else if(amount>100000){

				JOptionPane optionPane7=new JOptionPane();
				optionPane7.showMessageDialog(frame5,"PLEASE ENTER AMOUNT\nBELOW OR EQUAL 100000");
			}
			else{

				JOptionPane optionPane8=new JOptionPane();
				optionPane8.showMessageDialog(frame5,"INSUFFICIENT BALANCE");
			
			}
		}
		
		catch (ClassNotFoundException e) {
			
			System.out.println("exception2 "+e.getMessage());

		} 
		catch (SQLException e) {
		
			System.out.println("sql exception4 "+e.getMessage());
		}
	
		try {
			st.close();
		}
		catch (SQLException e) {
			System.out.println("sql exception 5 "+e.getMessage());
		}
	
		try {
			con.close();
		}
		catch (SQLException e) {
			System.out.println("sql exception 6 "+e.getMessage());
		}

	}

	private void balance(){

		acno=Integer.parseInt(text1.getText());
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jbanking_schema","root","NCSDsaha@12345");
		
			st=con.createStatement();
			rs=st.executeQuery("select cbalance from customer where cacno="+acno);
			rs.next();
			totalamount=rs.getDouble("cbalance");
			
			JOptionPane optionPane9=new JOptionPane();
			optionPane9.showMessageDialog(frame2,"YOUR CURRENT BALANCE IS: "+totalamount);
		}
		catch (ClassNotFoundException e) {
			
			System.out.println("exception2 "+e.getMessage());

		} 
		catch (SQLException e) {
		
			System.out.println("sql exception4 "+e.getMessage());
		}
	
		try {
			st.close();
		}
		catch (SQLException e) {
			System.out.println("sql exception 5 "+e.getMessage());
		}
	
		try {
			con.close();
		}
		catch (SQLException e) {
			System.out.println("sql exception 6 "+e.getMessage());
		}

	}
	
	private void matchData1(){
		
		String sacno=text1.getText();
		acno=(int)Integer.parseInt(sacno);
		
		char[] chpassword=pass1.getPassword();
		password=String.valueOf(chpassword);
		Connection con1=null;
		Statement st1=null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/jbanking_schema","root","NCSDsaha@12345");

			
			st1=con1.createStatement();
			ResultSet rs1=st1.executeQuery("select cacno,cpassword from customer");
			
			while(rs1.next()) {
				
				int cacno=rs1.getInt("cacno");
				String cpassword=rs1.getString("cpassword");
				if(acno==cacno && password.equals(cpassword)) {
					
					count++;
					break;
				}
				
			}
		} 
		
		catch (ClassNotFoundException e) {
			
			System.out.println("exception1 "+e.getMessage());
	
		} 
		catch (SQLException e) {
			
			System.out.println("sql exception1 "+e.getMessage());
		}
		
		try {
			st1.close();
		}
		catch (SQLException e) {
			System.out.println("sql exception 2 "+e.getMessage());
		}
		
		try {
			con1.close();
		}
		catch (SQLException e) {
			System.out.println("sql exception 3 "+e.getMessage());
		}

		
		
	}

}