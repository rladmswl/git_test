import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

public class TableEx3 extends JFrame {
	
	private JTable mTable;
	
	public TableEx3() {
		super("���̺� ����3"); //�ڽ�Ŭ���������� super�� �θ�Ŭ������ �޾ƿ´�.
		
		buildGUI();
		
		setSize(450,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private void buildGUI() {
		this.add(createTablePanel(), BorderLayout.CENTER); // ���̺� ���� �г��� ����.
		this.add(createbuttonPanel(), BorderLayout.SOUTH);
	}
	
	private JPanel createTablePanel() {
		JPanel p = new JPanel(new BorderLayout());
		
		String[] columNames = {"�̸�", "����", "����"}; //�迭�� ���� Ÿ�Ը� ������ �ִ�. // JScrollPane�� �ʿ��ϴ�.
		Object[][] data = { // Object �� �����ϸ� �ٸ�Ÿ�� ���� �� ����. ���ڿ��̴� �ƴϴ� �������.
				//{new String("���ָ�"), new Integer(22), "��" },
				{"���ָ�", 22, "��" },
				{"�Ҽ���", 20, "��" }
		};
		
		mTable = new JTable(new MyTableModel2());
		
		p.add(new JScrollPane(mTable));
		mTable.setRowHeight(30);
		
		return p;
	}

	private JPanel createbuttonPanel() {
		JPanel p = new JPanel(new GridLayout(0,2));
		
		JButton b1 = new JButton("���̺��� ���");
		JButton b2 = new JButton("�𵨿��� ���");
		
		p.add(b1);
		p.add(b2);

		b1.addActionListener(mHandler1);
		b2.addActionListener(mHandler2);

		
		return p;
	}
	
	private ActionListener mHandler1 = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			int rowNum = mTable.getRowCount();
			int colNum = mTable.getColumnCount();
			
			for (int c = 0; c<colNum; c++) {
				String colName = mTable.getColumnName(c);
				System.out.print(colName + "\t");
			}
			System.out.println();
			
			for (int r = 0; r < rowNum; r++) {
				for (int c = 0; c<colNum; c++) {
					Object cell = mTable.getValueAt(r,c);
					System.out.print(cell + "\t");
				}
				System.out.println();
			}
			System.out.println();
			
		}
	};
	
	private ActionListener mHandler2 = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			TableModel model = mTable.getModel();
			
			int rowNum = model.getRowCount();
			int colNum = model.getColumnCount();
			
			for (int c = 0; c<colNum; c++) {
				String colName = model.getColumnName(c);
				System.out.print(colName + "\t");
			}
			System.out.println();
			
			for (int r = 0; r < rowNum; r++) {
				for (int c = 0; c<colNum; c++) {
					Object cell = model.getValueAt(r,c);
					System.out.print(cell + "\t");
				}
				System.out.println();
			}
			System.out.println();
		}
	};
	
	public static void main(String[] args) {
		new TableEx3();

	}

}
