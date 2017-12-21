import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class DeleteFrame extends JFrame {
	JLabel namelabel;
	JLabel writerlabel;
	JLabel publisherlabel;
	JLabel nationlabel;
	JLabel yearlabel;
	JLabel pricelabel;
	JLabel barcodelabel;
	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteFrame frame = new DeleteFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void getdata(String[] value)
	{
		namelabel.setText(value[0]);
		writerlabel.setText(value[1]);
		publisherlabel.setText(value[2]);
		nationlabel.setText(value[3]);
		yearlabel.setText(value[4]);
		pricelabel.setText(value[5]);
		barcodelabel.setText(value[6]);
	}
	/**
	 * Create the frame.
	 */
	public DeleteFrame() {
		setBounds(100, 100, 350, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("삭제");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.bst.remove(namelabel.getText());
				Delete.model.setNumRows(0);
				Delete.pin(Main.bst.root);
				Modify.model.setNumRows(0);
				Modify.pin(Main.bst.root);
				User.setmo();
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
				setVisible(false);
			}
		});
		button.setBounds(100, 258, 97, 23);
		contentPane.add(button);
		
		JLabel label = new JLabel("책제목       :");
		label.setFont(new Font("HY중고딕", Font.PLAIN, 15));
		label.setBounds(12, 10, 100, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("저자           :");
		label_1.setFont(new Font("HY중고딕", Font.PLAIN, 15));
		label_1.setBounds(12, 35, 100, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("출판사        :");
		label_2.setFont(new Font("HY중고딕", Font.PLAIN, 15));
		label_2.setBounds(12, 60, 100, 15);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("국가           :");
		label_3.setFont(new Font("HY중고딕", Font.PLAIN, 15));
		label_3.setBounds(12, 85, 100, 15);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("발행년도     :");
		label_4.setFont(new Font("HY중고딕", Font.PLAIN, 15));
		label_4.setBounds(12, 110, 100, 15);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("가격        :");
		label_5.setFont(new Font("HY중고딕", Font.PLAIN, 15));
		label_5.setBounds(12, 135, 100, 15);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("바코드        :");
		label_6.setFont(new Font("HY중고딕", Font.PLAIN, 15));
		label_6.setBounds(12, 160, 100, 15);
		contentPane.add(label_6);
		
		namelabel = new JLabel("");
		namelabel.setBounds(124, 12, 198, 15);
		contentPane.add(namelabel);

		
		writerlabel = new JLabel("");
		writerlabel.setBounds(124, 37, 198, 15);
		contentPane.add(writerlabel);

		
		publisherlabel = new JLabel("");
		publisherlabel.setBounds(124, 62, 198, 15);
		contentPane.add(publisherlabel);

		
		nationlabel = new JLabel("");
		nationlabel.setBounds(124, 87, 198, 15);
		contentPane.add(nationlabel);

		
		yearlabel = new JLabel("");
		yearlabel.setBounds(124, 112, 198, 15);
		contentPane.add(yearlabel);

		
		pricelabel = new JLabel("");
		pricelabel.setBounds(124, 137, 198, 15);
		contentPane.add(pricelabel);

		
		barcodelabel = new JLabel("");
		barcodelabel.setBounds(124, 162, 198, 15);
		contentPane.add(barcodelabel);

		
		JButton button_1 = new JButton("취소");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		button_1.setBounds(225, 258, 97, 23);
		contentPane.add(button_1);
	}

}
