import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AbstractTableModelEx extends JFrame {

	private JTable table;
	
	public AbstractTableModelEx() {
		super("AbstractTableModelEx"); //�ڽ�Ŭ���������� super�� �θ�Ŭ������ �޾ƿ´�.
		
		buildGUI();
		
		setSize(450,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private void buildGUI() {
		this.add(createTablePanel(), BorderLayout.CENTER); // ���̺� ���� �г��� ����.
		//this.add(createbuttonPanel(), BorderLayout.SOUTH);
	}
	
	private JPanel createTablePanel() {
		JPanel p = new JPanel(new BorderLayout());
		
		MyTableModel model = new MyTableModel();
		table = new JTable(model);
		table.setRowHeight(30);;
		
		p.add(new JScrollPane(table));
		return p;
	}

	private ActionListener mHandler = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	};
	
	public static void main(String[] args) {
		new AbstractTableModelEx();
	}
}
