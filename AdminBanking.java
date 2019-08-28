package adminpackage;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

import java.sql.*;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Window;

public class AdminBanking {

	private JFrame frame;
	static private JTable table;
	private JTextField textField;
	static Connection con=null;
	static int acno;
	static TableModel tablemodel;
	static int selectedrow;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jbanking_schema","root","NCSDsaha@12345");
					AdminBanking window = new AdminBanking();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminBanking() {
		initialize();
		loadData();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 452);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 684, 289);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				selectedrow=table.getSelectedRow();
				tablemodel=table.getModel();
			}
		});
		table.setFont(new Font("Arial", Font.BOLD, 15));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("REFRESH");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String query="select * from customer";
				try {
					PreparedStatement pst=con.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					rs.close();
					pst.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(540, 288, 134, 36);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SEARCH");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				acno=Integer.parseInt(textField.getText());
				String query="select cacno,cname,cbalance,cpassword from customer where cacno="+acno;
				try {
					PreparedStatement pst= con.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(309, 298, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("INSERT");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
					InsertData insert=new InsertData();
					insert.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(23, 348, 89, 36);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("UPDATE");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UpdateData update=new UpdateData();
				update.setVisible(true);
				update.textField.setText(tablemodel.getValueAt(selectedrow, 0).toString());
				update.textField_1.setText(tablemodel.getValueAt(selectedrow, 1).toString());
				update.textField_2.setText(tablemodel.getValueAt(selectedrow, 2).toString());
				update.textField_3.setText(tablemodel.getValueAt(selectedrow, 3).toString());
			}
		});
		btnNewButton_3.setBounds(309, 348, 89, 36);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("DELETE");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					acno=(int) tablemodel.getValueAt(selectedrow, 0);
					String query="delete from customer where cacno="+acno;
					PreparedStatement pst= con.prepareStatement(query);
					pst.executeUpdate();
					loadData();
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_4.setBounds(570, 348, 89, 36);
		frame.getContentPane().add(btnNewButton_4);
		
		JLabel lblNewLabel = new JLabel("  ENTER ACCOUNT NO.");
		lblNewLabel.setBounds(0, 291, 146, 29);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(156, 293, 146, 36);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
	static public void loadData() {

		String query="select * from customer";
		try {
			PreparedStatement pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			rs.close();
			pst.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}
}
