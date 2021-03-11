import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class TableEx2 extends JFrame {

		private JTable mTable;
		//private JFrame frame;
		private JTextField mTvName;
		private JTextField mTvAge;
		private JTextField mTvGender;
		
		public TableEx2() {
			super("테이블 예제2"); //자식클래스에서는 super로 부모클래스를 받아온다.
			
			buildGUI();
			
			setSize(450,300);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setVisible(true);
		}
		
		private void buildGUI() {
			this.add(createTablePanel(), BorderLayout.CENTER); // 테이블 갖는 패널을 부착.
			//this.add(createtextPanel(),BorderLayout.SOUTH);
			this.add(createbuttonPanel(), BorderLayout.SOUTH);
		}

		private JPanel createTablePanel() {
			JPanel p = new JPanel(new BorderLayout());
			
			String[] columNames = {"이름", "나이", "성별"}; //배열은 같은 타입만 묶을수 있다. // JScrollPane이 필요하다.
			DefaultTableModel model = new DefaultTableModel(columNames,0);
			
			mTable = new JTable(model);
			
			p.add(new JScrollPane(mTable));
			mTable.setRowHeight(30);
			
			return p;
		}
		
		/*private JPanel createtextPanel() {
			JPanel
		}*/
		
		private JPanel createbuttonPanel() {
			JPanel p = new JPanel(new GridLayout(0,2));
			JPanel pp = new JPanel();
			
			JButton b1 = new JButton("추가");
			JButton b2 = new JButton("삭제");
			
			p.add(b1);
			p.add(b2);

			b1.addActionListener(mHandler1);
			b2.addActionListener(mHandler2);
/*
			JLabel name = new JLabel("이름");
			JTextField t1 = new JTextField();
			JLabel age = new JLabel("나이");
			JTextField t2 = new JTextField();
			JLabel gender = new JLabel("성별");
			JTextField t3 = new JTextField();
			
			pp.add(name);
			pp.add(t1);
			pp.add(age);
			pp.add(t2);
			pp.add(gender);
			pp.add(t3);*/
			
			return p;
		}
		
		ActionListener mHandler1 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String arr[] = new String[3];
				arr[0] = mTvName.getText();
				arr[0] = mTvAge.getText();
				arr[0] = mTvGender.getText();
				
				DefaultTableModel model = (DefaultTableModel) mTable.getModel();
				model.addRow(arr);
				
				mTvName.setText("");
				mTvAge.setText("");
				mTvGender.setText("");
				
			}
		};
		
		ActionListener mHandler2 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = mTable.getSelectedRow();
				if (row ==-1) return;
				
				DefaultTableModel model = (DefaultTableModel) mTable.getModel();
				model.removeRow(row);
			}
		};
		
		public static void main(String[] args) {
			new TableEx2();

		}
	


}
