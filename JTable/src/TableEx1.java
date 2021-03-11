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

public class TableEx1 extends JFrame {
	
	private JTable mTable;
	
	public TableEx1() {
		super("테이블 예제1"); //자식클래스에서는 super로 부모클래스를 받아온다.
		
		buildGUI();
		
		setSize(450,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private void buildGUI() {
		this.add(createTablePanel(), BorderLayout.CENTER); // 테이블 갖는 패널을 부착.
		this.add(createbuttonPanel(), BorderLayout.SOUTH);
	}
	
	private JPanel createTablePanel() {
		JPanel p = new JPanel(new BorderLayout());
		
		String[] columNames = {"이름", "나이", "성별"}; //배열은 같은 타입만 묶을수 있다. // JScrollPane이 필요하다.
		Object[][] data = { // Object 로 설정하면 다른타입 묶을 수 있음. 문자열이던 아니던 상관없음.
				//{new String("고주몽"), new Integer(22), "남" },
				{"고주몽", 22, "남" },
				{"소서노", 20, "여" }
		};
		
		mTable = new JTable(data, columNames);
		
		p.add(new JScrollPane(mTable));
		mTable.setRowHeight(30);
		
		return p;
	}

	private JPanel createbuttonPanel() {
		JPanel p = new JPanel(new GridLayout(0,2));
		
		JButton b1 = new JButton("테이블에서 출력");
		JButton b2 = new JButton("모델에서 출력");
		
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
		new TableEx1();

	}

}
