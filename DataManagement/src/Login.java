import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Login dialog = new Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Login() {
		setTitle("Login");
		setBounds(100, 100, 450, 171);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Login System", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("Password");
				lblNewLabel.setBounds(21, 33, 56, 18);
				panel.add(lblNewLabel);
			}
			{
				passwordField = new JPasswordField();
				passwordField.setBounds(110, 27, 300, 30);
				panel.add(passwordField);
			}
			
			JButton btnNewButton = new JButton("Login");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String password = new String(passwordField.getPassword());
					if (password.equals(Main.bst.pass)){
						Main.mainf.setVisible(true);
						Main.mainf.flag = true;
						Main.mainf.tabbedPane.setSelectedIndex(1);
						setVisible(false);
					}
					else 
						JOptionPane.showMessageDialog(null,"Password가 틀렸습니다.");
				}
			});
			btnNewButton.setBounds(218, 69, 90, 30);
			panel.add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("Back");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Main.mainf.setVisible(true);
					Main.mainf.flag = false;
					Main.mainf.tabbedPane.setSelectedIndex(0);
					setVisible(false);
				}
			});
			btnNewButton_1.setBounds(320, 69, 90, 30);
			panel.add(btnNewButton_1);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
}
