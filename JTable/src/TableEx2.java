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
			super("���̺� ����2"); //�ڽ�Ŭ���������� super�� �θ�Ŭ������ �޾ƿ´�.
			
			buildGUI();
			
			setSize(450,300);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setVisible(true);
		}
		
		private void buildGUI() {
			this.add(createTablePanel(), BorderLayout.CENTER); // ���̺� ���� �г��� ����.
			//this.add(createtextPanel(),BorderLayout.SOUTH);
			this.add(createbuttonPanel(), BorderLayout.SOUTH);
		}

		private JPanel createTablePanel() {
			JPanel p = new JPanel(new BorderLayout());
			
			String[] columNames = {"�̸�", "����", "����"}; //�迭�� ���� Ÿ�Ը� ������ �ִ�. // JScrollPane�� �ʿ��ϴ�.
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
			
			JButton b1 = new JButton("�߰�");
			JButton b2 = new JButton("����");
			
			p.add(b1);
			p.add(b2);

			b1.addActionListener(mHandler1);
			b2.addActionListener(mHandler2);
/*
			JLabel name = new JLabel("�̸�");
			JTextField t1 = new JTextField();
			JLabel age = new JLabel("����");
			JTextField t2 = new JTextField();
			JLabel gender = new JLabel("����");
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
