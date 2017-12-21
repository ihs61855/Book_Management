

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.GridLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Modify extends JPanel {
	private JTable table;
	static String header[] = {"책이름", "저자", "출판사","국가","발행년도","가격","바코드"};
	static DefaultTableModel model = new DefaultTableModel(null,header);

	public Modify() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 563, 373);
		add(scrollPane);
		table = new JTable(model);
		table.setAutoCreateRowSorter(true);
		TableRowSorter sorter = new TableRowSorter(table.getModel());
		table.setRowSorter(sorter);
		scrollPane.setViewportView(table);
		pin(Main.bst.root);
		JButton btnNewButton = new JButton("수정");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				if(!(table.getSelectedRow()==-1)){
				String[] value = {"","","","","","",""};
				for(int i = 0 ; i < 7 ; i++){
					value[i] = (String) table.getValueAt(table.getSelectedRow(), i);
				}
				ModifyFrame mof = new ModifyFrame();
				mof.getdata(value);
				mof.setVisible(true);
				}
			}
		});
		btnNewButton.setBounds(575, 10, 97, 23);
		add(btnNewButton);
	}
	static public void pin(NODE nonono) {
		  if (nonono.left != null){
			  pin(nonono.left);
		  }
		  model.addRow(nonono.getData());;
		  if (nonono.right != null) {
			  pin(nonono.right);
		  }
	}
}
