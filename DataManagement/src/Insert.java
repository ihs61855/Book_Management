import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Insert extends JPanel {
	public JTextField textField;
	public JTextField textField_1;
	public JTextField textField_2;
	public JTextField textField_3;
	public JTextField textField_4;
	public JTextField textField_5;
	public JComboBox comboBox;
	/**
	 * Create the panel.
	 */
	public Insert() {
		setLayout(null);
		
		JLabel label = new JLabel("\uCC45 \uC81C\uBAA9       :");
		label.setFont(new Font("HYÁß°íµñ", Font.PLAIN, 15));
		label.setBounds(12, 10, 100, 15);
		add(label);
		
		JLabel lblNewLabel = new JLabel("ÀúÀÚ           :");
		lblNewLabel.setFont(new Font("HYÁß°íµñ", Font.PLAIN, 15));
		lblNewLabel.setBounds(12, 35, 100, 15);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ÃâÆÇ»ç        :");
		lblNewLabel_1.setFont(new Font("HYÁß°íµñ", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(12, 60, 100, 15);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("±¹°¡           :");
		lblNewLabel_2.setFont(new Font("HYÁß°íµñ", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(12, 85, 100, 15);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("¹ßÇà³âµµ     :");
		lblNewLabel_3.setFont(new Font("HYÁß°íµñ", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(12, 110, 100, 15);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("°¡°Ý          :");
		lblNewLabel_4.setFont(new Font("HYÁß°íµñ", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(12, 135, 100, 15);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("¹ÙÄÚµå        :");
		lblNewLabel_5.setFont(new Font("HYÁß°íµñ", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(12, 160, 100, 15);
		add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(200, 7, 200, 21);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(200, 32, 200, 21);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(200, 57, 200, 21);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(200, 82, 200, 21);
		add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(200, 132, 200, 21);
		add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(200, 157, 200, 21);
		add(textField_5);
		textField_5.setColumns(10);
		
		String[] yearlist= {"1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000",
				"2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016"};
		comboBox = new JComboBox(yearlist);
		comboBox.setBounds(200, 107, 109, 21);
		add(comboBox);
		
		JButton button = new JButton("»ðÀÔ");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean fla = true;
				String[] t = { textField.getText(),textField_1.getText(),textField_2.getText(),textField_3.getText(),(String) comboBox.getSelectedItem(),textField_4.getText(),textField_5.getText()};
				for(int i = 0 ; i <7;i++)
				{
					if(t[i].equals(""))
						fla = false;
				}
				System.out.println(fla);
				if(fla==true){
				Main.bst.insert(t);
				Delete.model.setNumRows(0);
				Delete.pin(Main.bst.root);
				Modify.model.setNumRows(0);
				Modify.pin(Main.bst.root);
				User.setmo();
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				FileWriter fw =null;
				try {
					fw = new FileWriter("FileTest.txt");
					Main.bst.save(Main.bst.root, fw);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			}
		});
		button.setBounds(464, 265, 97, 23);
		add(button);

	}
}