import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class ModifyFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JComboBox comboBox;
	String firstname=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyFrame frame = new ModifyFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void getdata(String[] value)
	{
		textField.setText(value[0]);
		textField_1.setText(value[1]);
		textField_2.setText(value[2]);
		textField_3.setText(value[3]);
		comboBox.setSelectedItem(value[4]);
		textField_4.setText(value[5]);
		textField_5.setText(value[6]);
		firstname=textField.getText();
	}
	/**
	 * Create the frame.
	 */
	public ModifyFrame() {
		setBounds(100, 100, 350, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel label = new JLabel("\uCC45\uC774\uB984       :");
		label.setFont(new Font("HYÁß°íµñ", Font.PLAIN, 15));
		label.setBounds(12, 10, 100, 15);
		getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("\uC800\uC790           :");
		lblNewLabel.setFont(new Font("HYÁß°íµñ", Font.PLAIN, 15));
		lblNewLabel.setBounds(12, 35, 100, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uCD9C\uD310\uC0AC        :");
		lblNewLabel_1.setFont(new Font("HYÁß°íµñ", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(12, 60, 100, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uAD6D\uAC00           :");
		lblNewLabel_2.setFont(new Font("HYÁß°íµñ", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(12, 85, 100, 15);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uBC1C\uD589\uB144\uB3C4     :");
		lblNewLabel_3.setFont(new Font("HYÁß°íµñ", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(12, 110, 100, 15);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\uAC00\uACA9          :");
		lblNewLabel_4.setFont(new Font("HYÁß°íµñ", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(12, 135, 100, 15);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\uBC14\uCF54\uB4DC        :");
		lblNewLabel_5.setFont(new Font("HYÁß°íµñ", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(12, 160, 100, 15);
		getContentPane().add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(124, 9, 200, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(124, 34, 200, 21);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(124, 59, 200, 21);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(124, 84, 200, 21);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(124, 134, 200, 21);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(124, 159, 200, 21);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		String[] yearlist= {"1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000",
				"2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016"};
		comboBox = new JComboBox(yearlist);
		comboBox.setBounds(124, 109, 109, 21);
		getContentPane().add(comboBox);
		
		JButton button = new JButton("\uC218\uC815");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String[] ge = {
						 textField.getText(),
						 textField_1.getText(),
						 textField_2.getText(),
						 textField_3.getText(),
						(String)comboBox.getSelectedItem(),
						textField_4.getText(),
						textField_5.getText(),
					 };
				 boolean ch = true;
				 for(int i =0 ; i < 7 ; i++)
				 {
					 if(ge[i].equals(""))
					 {
						 ch = false;
					 }
				 }
				 if(ch == false)
				 {
					 JOptionPane.showMessageDialog(null,"ºóÄ­ÀÌ ÀÖ½À´Ï´Ù.");
				 }
				 else	 
				 {
					Main.bst.remove(firstname);
					Main.bst.insert(ge);
					Delete.model.setNumRows(0);
					Delete.pin(Main.bst.root);
					Modify.model.setNumRows(0);
					Modify.pin(Main.bst.root);
					setVisible(false);
					FileWriter fw =null;
					try {
						fw = new FileWriter("FileTest.txt");
						Main.bst.save(Main.bst.root, fw);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						fw.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					User.setmo();

				 }
			}
		});
		button.setBounds(124, 337, 97, 23);
		contentPane.add(button);
		
		JButton btnNewButton = new JButton("\uCDE8\uC18C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setBounds(225, 337, 97, 23);
		contentPane.add(btnNewButton);
	}
}
