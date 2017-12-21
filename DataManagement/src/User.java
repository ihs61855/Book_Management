import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.ScrollPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class User extends JPanel {
	private JTextField bookname;
	private JTextField bookwriter;
	private JTextField bookpublisher;
	private JTextField booknation;
	private JTextField bookprice1;
	private JTextField bookprice2;
	private JTextField bookbarcode;
	private JTable table;
	JComboBox comboBox;
	JComboBox comboBox_1;
	static String header[] = {"책이름", "저자", "출판사","국가","발행년도","가격","바코드"};
	static DefaultTableModel model = new DefaultTableModel(null,header);
	/**
	 * Create the panel.
	 */
	static public void setmo()
	{
		model.setNumRows(0);
	}
	public User() {

		setLayout(null);
		
		JLabel label = new JLabel("\uCC45 \uC774\uB984:");
		label.setBounds(23, 10, 57, 15);
		add(label);
		
		JLabel lblNewLabel = new JLabel("\uC800\uC790:");
		lblNewLabel.setBounds(23, 35, 57, 15);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uCD9C\uD310\uC0AC :");
		lblNewLabel_1.setBounds(23, 60, 57, 15);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uAD6D\uAC00 :");
		lblNewLabel_2.setBounds(23, 85, 57, 15);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uBC1C\uD589\uB144\uB3C4:");
		lblNewLabel_3.setBounds(261, 35, 57, 15);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\uAC00\uACA9:");
		lblNewLabel_4.setBounds(261, 60, 57, 15);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\uBC14\uCF54\uB4DC:");
		lblNewLabel_5.setBounds(261, 85, 57, 15);
		add(lblNewLabel_5);
		
		bookname = new JTextField();
		bookname.setBounds(78, 7, 203, 21);
		add(bookname);
		bookname.setColumns(10);
		
		bookwriter = new JTextField();
		bookwriter.setColumns(10);
		bookwriter.setBounds(78, 35, 167, 21);
		add(bookwriter);
		
		bookpublisher = new JTextField();
		bookpublisher.setColumns(10);
		bookpublisher.setBounds(78, 60, 167, 21);
		add(bookpublisher);
		
		booknation = new JTextField();
		booknation.setColumns(10);
		booknation.setBounds(78, 85, 167, 21);
		add(booknation);
		
		bookprice1 = new JTextField();
		bookprice1.setColumns(10);
		bookprice1.setBounds(311, 57, 86, 21);
		add(bookprice1);
		
		JLabel lblNewLabel_6 = new JLabel("~");
		lblNewLabel_6.setBounds(409, 60, 15, 15);
		add(lblNewLabel_6);
		
		bookprice2 = new JTextField();
		bookprice2.setColumns(10);
		bookprice2.setBounds(426, 57, 86, 21);
		add(bookprice2);
		
		bookbarcode = new JTextField();
		bookbarcode.setColumns(10);
		bookbarcode.setBounds(311, 82, 201, 21);
		add(bookbarcode);
		String[] yearlist= {"1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000",
				"2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016"};
		comboBox = new JComboBox(yearlist);
		comboBox.setBounds(330, 32, 78, 21);
		add(comboBox);
		
		JLabel label_1 = new JLabel("~");
		label_1.setBounds(419, 35, 15, 15);
		add(label_1);
		
		
		String[] yearlist2={"2016","2015","2014","2013","2012","2011","2010","2009","2008","2007","2006","2005","2004","2003","2002","2001","2000",
				"1999","1998","1997","1996","1995","1994","1993","1992","1991","1990",
		};
		comboBox_1 = new JComboBox(yearlist2);
		comboBox_1.setBounds(434, 32, 78, 21);
		add(comboBox_1);
		
		JButton btnNewButton = new JButton("검색");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model.setNumRows(0);
				ser(Main.bst.root);
				bookname.setText("");
				bookwriter.setText("");
				bookpublisher.setText("");
				booknation.setText("");
				bookprice1.setText("");
				bookprice2.setText("");
				bookbarcode.setText("");
			}
		});
		btnNewButton.setBounds(311, 6, 97, 23);
		add(btnNewButton);
		
		JButton button = new JButton("전체보기");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model.setNumRows(0);
				pin(Main.bst.root);
			}
		});
		button.setBounds(415, 6, 97, 23);
		add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 110, 643, 283);
		add(scrollPane);
		table = new JTable(model);
		table.setAutoCreateRowSorter(true);
		TableRowSorter sorter = new TableRowSorter(table.getModel());
		table.setRowSorter(sorter);
		
		scrollPane.setViewportView(table);

	}
	
	 public void pin(NODE nonono) {
		  if (nonono.left != null){
			  pin(nonono.left);
		  }
		  model.addRow(nonono.getData());;
		  if (nonono.right != null) {
			  pin(nonono.right);
		  }
	}
	 
	 public void ser(NODE nonono) {
		 String[] ge = {
				bookname.getText(),
				bookwriter.getText(),
				bookpublisher.getText(),
				booknation.getText(),
				(String) comboBox.getSelectedItem(),
				(String) comboBox_1.getSelectedItem(),
				bookprice1.getText(),
				bookprice2.getText(),
				bookbarcode.getText()
		 };
		 boolean[] ke = {false,false,false,false,false,false,false,false,false,false};
		 for(int i = 0 ; i < 9 ; i ++)
		 {
			 if(ge[i].equals(""))
				 ke[i] = true;
		 }
		 int year = Integer.parseInt(nonono.year);
		 int year_min = Integer.parseInt(ge[4]);
		 int year_max = Integer.parseInt(ge[5]);
		 if((year>year_min-1)&&(year<year_max+1))
		 {	ke[4] = true;}
		 int price = Integer.parseInt(nonono.price);
		 int price_min=0;
		 int price_max=0;
		 if(ke[6] != true)
		 {price_min = Integer.parseInt(ge[6]);}
		 if(ke[7]!=true)
		 {price_max = Integer.parseInt(ge[7]);}
		 
		 if(!ke[6]&&!ke[7])
		 {
			 if((price>price_min-1) &&(price<price_max+1))
				 ke[9] = true;
		 }
		 else if(ke[6]&&ke[7])
		 {
			 ke[9] = true;
		 }
		 else if(ke[6]&&!ke[7])
		 {
			 if(price<price_max+1)
				 ke[9] = true;
		 }
		 else if(!ke[6]&&ke[7])
		 {
			 if(price>price_min-1)
				 ke[9] = true;
		 }
		  if (nonono.left != null){
			  ser(nonono.left);
		  }
		  
		if((nonono.name.equals(ge[0])||ke[0]==true)&&(nonono.writer.equals(ge[1])||ke[1]==true)&&(nonono.publisher.equals(ge[2])||ke[2]==true)&&(nonono.nation.equals(ge[3])||ke[3]==true)&&
				(nonono.barcode.equals(ge[8])||ke[8]==true)&&ke[4]&&ke[9])
		{
		  model.addRow(nonono.getData());;
		}
		  if (nonono.right != null) {
			  ser(nonono.right);
		  }
	}
}
