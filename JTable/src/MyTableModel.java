import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {
	String[] columNames = {"�̸�", "����", "����"};
	
	Object[][] data = {
			{"���ָ�", 22, "��" },
			{"�Ҽ���", 20, "��" }
	};

	@Override
	public int getColumnCount() {
		return columNames.length; 
	}

	@Override
	public int getRowCount() {
		return data.length; // ������ : ������ �迭 2�� ������ �ִٴ� ��.
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data[rowIndex][columnIndex];
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
		// �˻�
		data[rowIndex][columnIndex] = aValue;
	}

	
	
	
}
