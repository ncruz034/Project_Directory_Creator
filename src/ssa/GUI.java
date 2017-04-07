package ssa;


import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;


public class GUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JComboBox<String> comboBox;


	public void initialize() {
		
		Municipalities m = new Municipalities();
		ArrayList<String> municipalities = m.getMunicipalities();
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 400, 208);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblProjectDirectoryCreator = new JLabel("Project Directory Creator");
		lblProjectDirectoryCreator.setBounds(0, 0, 394, 21);
		lblProjectDirectoryCreator.setHorizontalAlignment(SwingConstants.CENTER);
		lblProjectDirectoryCreator.setFont(new Font("Tahoma", Font.BOLD, 17));
		frame.getContentPane().add(lblProjectDirectoryCreator);
		
		JLabel lblSectionTownship = new JLabel("Section Township & Range");
		lblSectionTownship.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSectionTownship.setBounds(21, 67, 166, 14);
		frame.getContentPane().add(lblSectionTownship);
		
		JLabel lblProjectName = new JLabel("Project Name");
		lblProjectName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProjectName.setBounds(57, 92, 130, 14);
		frame.getContentPane().add(lblProjectName);
		
		JLabel lblMunicipality = new JLabel("Municipality");
		lblMunicipality.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMunicipality.setBounds(57, 116, 130, 14);
		frame.getContentPane().add(lblMunicipality);
		
		textField = new JTextField();
		textField.setBounds(218, 67, 86, 14);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(218, 92, 120, 14);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		String[] items = new String[municipalities.size()];
		
		/*
		 * Transfer the ArrayList to an array to be used by
		 * the JComboBox
		 */
		for (String mu: municipalities){
			items[municipalities.indexOf(mu)]= mu;
		}
		/*
		 * Initialize the JComboBox with the list of 
		 * Municipalities.
		 */
		comboBox = new JComboBox<String>(items);
		comboBox.setBounds(218, 113, 120, 16);
		frame.getContentPane().add(comboBox);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {				
				ImputChecker ic = new ImputChecker();				
				ic.imputChecker(textField.getText(), textField_1.getText(),(String) comboBox.getSelectedItem());			
			}
		});
		
		btnEnter.setBounds(40, 141, 67, 23);
		frame.getContentPane().add(btnEnter);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);						
			}
		});
		btnExit.setBounds(120, 141, 67, 23);
		frame.getContentPane().add(btnExit);
		frame.setVisible(true);
	}
}
