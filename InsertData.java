package adminpackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class InsertData extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	static Connection con=null;
	static int acno;
	static InsertData frame1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					frame1 = new InsertData();
					frame1.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public InsertData() {
		initialize();
	}
	
	public void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 573, 402);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Tahoma", Font.PLAIN, 11));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NEW  ACCOUNT  NO.");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel.setBounds(87, 56, 140, 28);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFocusTraversalPolicyProvider(true);
		textField.setFont(new Font("Arial", Font.BOLD, 15));
		textField.setBounds(237, 53, 177, 33);
		textField.setEditable(false);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("GENERATE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String query="select cacno from customer where cacno=(select max(cacno) from customer)";
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jbanking_schema","root","NCSDsaha@12345");
				
					PreparedStatement pst=con.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					rs.next();
					acno=rs.getInt("cacno");
					acno+=1;
					String sacno=String.valueOf(acno);
					textField.setText("   "+sacno);
					
					rs.close();
					pst.close();
					con.close();
					
				}
				catch (SQLException e1) {
					
					e1.printStackTrace();
					
				} catch (ClassNotFoundException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(441, 56, 106, 28);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("ACCOUNT HOLDER NAME");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setBounds(55, 115, 171, 28);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(237, 113, 177, 33);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("INITIAL BALANCE");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_2.setBounds(104, 176, 123, 33);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(237, 176, 177, 33);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("SET PASSWORD");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_3.setBounds(104, 251, 106, 14);
		contentPane.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(237, 240, 177, 33);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("INSERT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jbanking_schema","root","NCSDsaha@12345");
					
					String name=textField_1.getText();
					double balance=Double.parseDouble(textField_2.getText());
					String password=textField_3.getText();
					
					String query="insert into customer values(?,?,?,?)";
					
					PreparedStatement pst=con.prepareStatement(query);
					pst.setInt(1, acno);
					pst.setString(2, name);
					pst.setDouble(3, balance);
					pst.setString(4, password);
					pst.executeUpdate();
					AdminBanking.loadData();
					
					JOptionPane.showMessageDialog(InsertData.this,"DATA SUCCESSFULLY SAVED");
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(237, 301, 106, 33);
		contentPane.add(btnNewButton_1);
	}
}
