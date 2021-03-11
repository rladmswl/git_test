import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JTable;

public class VectorTableModelEx extends JFrame {
	private JTable mTable;
	private Vector<Person> mData;
	
	public Vector TableModelEx() {
		setTitle("VectorTableModelEx"); //자식클래스에서는 super로 부모클래스를 받아온다.
		
		buildGUI();
		
		setSize(450,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private void buildGUI() {
		
	}

}
