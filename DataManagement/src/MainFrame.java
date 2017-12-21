import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.event.*;
import javax.xml.transform.Source;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JTabbedPane;

public class MainFrame extends JFrame {
	private JPanel contentPane;
	public boolean flag;
	JTabbedPane tabbedPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
    public Login pass;
    private	void tabbedPaneMouseClicked(java.awt.event.MouseEvent evt) 
    {                        
    	pass = new Login();
    	pass.setVisible(true);
    	setVisible(false);
    }
    
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("사용자모드", null, panel_1, null);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_5 = new User();
		panel_1.add(panel_5);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("관리자모드", null, panel, null);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		panel.add(tabbedPane_1);                                 
		
		JPanel panel_2 = new Insert();
		tabbedPane_1.addTab("삽입", panel_2);
		
		JPanel panel_3 = new Delete();
		tabbedPane_1.addTab("삭제", panel_3);
		
		JPanel panel_4 = new Modify();
		tabbedPane_1.addTab("수정",panel_4);
		

	    
		tabbedPane.addMouseListener(new java.awt.event.MouseAdapter() 
		{
		        public void mouseClicked(java.awt.event.MouseEvent evt) {
		            int Index=tabbedPane.getSelectedIndex();
		            String msg=tabbedPane.getTitleAt(Index); 
		            if((msg.equals("관리자모드"))&&(flag==false))
		            {
		            	User.setmo();
		            	tabbedPaneMouseClicked(evt);
		        	}
		        }
		  });
		tabbedPane.addMouseListener(new java.awt.event.MouseAdapter() 
		{
		        public void mouseClicked(java.awt.event.MouseEvent evt) {
		            int Index=tabbedPane.getSelectedIndex();
		            String msg=tabbedPane.getTitleAt(Index); 
		            if((msg.equals("사용자모드")))
		            {
		            	panel_5.revalidate();
		        	}
		        }
		  });
	}
}
