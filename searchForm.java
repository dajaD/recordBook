/**
 * 
 */
package records;

/**
 * @author Daja Dunbar
 *
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class searchForm extends JFrame
{
	public String enter = "abc";
	
	private JPanel contentsPane;
	
	private JPanel panel = new JPanel();
	
	private JTextField tfForSearch;
	
	String space =" ";
	public JLabel lblStatement;
	
	public void setEnter(String enter)
	{
		this.enter = enter;
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					searchForm frame = new searchForm();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	
	//
	public searchForm()
	{
		main md = new main();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 822, 570);
		
		contentsPane = new JPanel();
		contentsPane.setBorder(new EmptyBorder(5,5,5,5));
		
		setContentPane(contentsPane);
		contentsPane.setLayout(null);
		
		panel.setBounds(10,150,786,138);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		contentsPane.add(panel);
		panel.setLayout(null);
		
		lblStatement = new JLabel("Text");
		lblStatement.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStatement.setBounds(27,46,207,28);
		panel.add(lblStatement);
		
		tfForSearch = new JTextField();
		tfForSearch.setBounds(235,49,280,28);
		panel.add(tfForSearch);
		tfForSearch.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10,314,786,206);
		contentsPane.add(scrollPane);
		
		JLabel Record = new JLabel("Loading... .");
		Record.setVerticalAlignment(SwingConstants.TOP);
		scrollPane.setViewportView(Record);
		
		
		JLabel RecordHeader = new JLabel ("Country Name"
				+ space + "Continent" + space + "Region"
				+ space + "Government Form" + space + "Population");
		RecordHeader.setVerticalAlignment(SwingConstants.TOP);
		RecordHeader.setEnabled(false);
		RecordHeader.setBackground(SystemColor.textHighlight);
		scrollPane.setColumnHeaderView(RecordHeader);
		
		
		JButton btnNew = new JButton ("Get Record");
		btnNew.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//for button
				String code = tfForSearch.getText();
				
				String url = "jdbc:mysql://localhost:3306/tester";
				Connection conn = null;
				try
				{
					conn = DriverManager.getConnection(url, "AliHaider", "lahorepakistan");
				}
				catch (SQLException e1)
				{
					e1.printStackTrace();
				}
				Statement stmt = null;
				try
				{
					stmt = conn.createStatement();
				}
				catch (SQLException e1)
				{
					e1.printStackTrace();
				}
				ResultSet rs = null;
				try
				{
					rs = stmt.executeQuery("SELECT * FROM country where code = '" + code +"'");
				}
				catch (SQLException e1)
				{
					e1.printStackTrace();
				}
				try 
				{
					while(rs.next())
					{
						String CName = rs.getString(2);
						String Continent = rs.getString(3);
						String Region = rs.getString(4);
						String Government = rs.getString(12);
						String Population = rs.getString(7);
						
						Record.setText(CName + space + Continent + space 
								+ Region + space + Government + space + Population);
					}
				}
				catch (SQLException e1)
				{
					e1.printStackTrace();
				}
				try
				{
					conn.close();
				}
				catch (SQLException e1)
				{
					e1.printStackTrace();
				}
			}
		});
		
		btnNew.setBounds(545,49,118,28);
		panel.add(btnNew);
		
		
	}

}
