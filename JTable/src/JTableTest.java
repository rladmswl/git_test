import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class JTableTest {

	public static void main(String[] args) {
// TODO Auto-generated method stub
		new JTable1();
	}

}

class JTable1 extends JFrame implements ActionListener {
	private String[] colname = { "�̸�", "����", "����", "����", "���" };
	private String[][] index = { { "ȫ�浿", "100", "100", "100", "100" }, { "�迵��", "50", "80", "30", "53" },
			{ "��ö��", "0", "0", "100", "33" } };
	protected DefaultTableModel dtm = new DefaultTableModel(index, colname);
	protected JTable jt;
	protected JScrollPane scroll;
	protected Container ct = getContentPane();
	public JTextField name = new JTextField();
	public JTextField kor = new JTextField();
	public JTextField eng = new JTextField();
	public JTextField mat = new JTextField();

	JTable1() {
		ct.setLayout(new BorderLayout());
		jt = new JTable(dtm);
		scroll = new JScrollPane(jt);
		JButton ctrls = new JButton("����");
		JButton insert = new JButton("�߰�");
		JPanel jp1 = new JPanel();
		jp1.setLayout(new GridLayout(2, 5));
		jp1.add(new JLabel("�̸�"));
		jp1.add(new JLabel("����"));
		jp1.add(new JLabel("����"));
		jp1.add(new JLabel("����"));
		jp1.add(ctrls);
		jp1.add(name);
		jp1.add(kor);
		jp1.add(eng);
		jp1.add(mat);
		jp1.add(insert);
		ctrls.addActionListener(this);
		insert.addActionListener(this);
		setTitle("Exam1");
		setSize(500, 400);
		ct.add(scroll, BorderLayout.CENTER);
		ct.add(jp1, BorderLayout.SOUTH);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "����") {
		}
		else if (e.getActionCommand() == "�߰�") {
			//int cal = (Integer.parseInt(kor.getText())+ Integer.parseInt(eng.getText()) + Integer.parseInt(mat.getText())) / 3;
			//String str = Integer.toString(cal);
			String s[] = { name.getText(), kor.getText(), eng.getText(), mat.getText()};//, str 
			dtm.addRow(s);
		}
	}
}