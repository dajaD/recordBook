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
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class main extends JFrame 
{
	
	private JPanel contentsPane;
	public String enter;
	
//	launches the application
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					main frame = new main();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

//	creating the frame
	
	public main()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 886, 578);
		contentsPane = new JPanel();
		contentsPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentsPane);
		contentsPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(java.awt.SystemColor.controlShadow);
		panel.setBounds(0,0,189,539);
		contentsPane.add(panel);
		panel.setLayout(null);

		
		JButton ByCName = new JButton("Click Here");
		ByCName.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						searchForm sf = new searchForm();
						sf.lblStatement.setText("Country Name");
						sf.setVisible(true);
						dispose();
					}
				});
		ByCName.setBounds(249,134,89,54);
		contentsPane.add(ByCName);
		
		JButton ByCCode = new JButton("Click Here");
		ByCCode.setBounds(249,203,89,54);
		contentsPane.add(ByCCode);
		
		JButton byCon = new JButton("Click Here");
		byCon.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent e)
			{
				
			}
				});
		byCon.setBounds(249,274,89,54);
		contentsPane.add(byCon);
		
		JButton byPopu = new JButton("Click Here");
		byPopu.setBounds(249,344,89,54);
		contentsPane.add(byPopu);
		
		
		JLabel lblNewLabel = new JLabel("Search for any City");
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.PLAIN, 24));
		lblNewLabel.setBounds(361,134,251,54);
		contentsPane.add(lblNewLabel);
		
		JLabel lblAddNewCity = new JLabel("Add new a City");
		lblAddNewCity.setFont(new Font("Sitka Subheading", Font.PLAIN, 24));
		lblAddNewCity.setBounds(361,203,251,54);
		contentsPane.add(lblAddNewCity);
		
		JLabel lblUpdateCountry = new JLabel("Update the Country");
		lblUpdateCountry.setFont(new Font("Sitka Subheading", Font.PLAIN, 24));
		lblUpdateCountry.setBounds(361,271,251,54);
		contentsPane.add(lblUpdateCountry);
		
		JLabel lblDeleteCountry = new JLabel("Delete the Country");
		lblDeleteCountry.setFont(new Font("Sitka Subheading", Font.PLAIN, 24));
		lblDeleteCountry.setBounds(361,344,251,54);
		contentsPane.add(lblDeleteCountry);
	}

}
