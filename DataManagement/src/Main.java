import java.io.*;
import java.util.Scanner;

public class Main {
	static public BST bst;
	public static MainFrame mainf;
	public static void main(String[] args) throws IOException {
		bst = new BST();
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("FileTest.txt"),"EUC-KR"));
		String inputLine;
		while((inputLine = br.readLine())!=null)
		{
			String[] input;
			input = inputLine.split("&");
			bst.insert(input);
		}
		br.close();
		
		br = new BufferedReader(new InputStreamReader(new FileInputStream("Pass.txt"),"EUC-KR"));
		bst.pass = br.readLine();
		br.close();

		mainf=new MainFrame();
		mainf.setVisible(true);

	}
}
