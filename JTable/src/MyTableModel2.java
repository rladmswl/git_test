import javax.swing.table.AbstractTableModel;

public class MyTableModel2 extends AbstractTableModel {
	String[] columNames = {"�̸�", "����", "����"};
	Object[][] data = {
			{"���ָ�", "������"},
			{22,20},
			{"��", "��"}
			
	};

	@Override
	public int getColumnCount() {
		return columNames.length;
	}

	@Override
	public int getRowCount() {
		return data[0].length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data[columnIndex][rowIndex]; // �� �����ٲ�???
	}

	@Override
	public String getColumnName(int column) { // ������ : ���κ� ���
		return columNames[column];
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		//return true; // ������ : ���� ���� ����.
		return columnIndex == 0? false : true; // ������ : �̸��� ���� ���ϰ���.
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// �˻�  /// �����˻�..?
		data[rowIndex][columnIndex] = aValue;
	}
}
