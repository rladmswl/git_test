import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JTable;

public class VectorTableModelEx extends JFrame {
	private JTable mTable;
	private Vector<Person> mData;
	
	public Vector TableModelEx() {
		setTitle("VectorTableModelEx"); //�ڽ�Ŭ���������� super�� �θ�Ŭ������ �޾ƿ´�.
		
		buildGUI();
		
		setSize(450,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private void buildGUI() {
		
	}

}
