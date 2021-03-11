import javax.swing.table.AbstractTableModel;

public class MyTableModel2 extends AbstractTableModel {
	String[] columNames = {"이름", "나이", "성별"};
	Object[][] data = {
			{"고주몽", "김은지"},
			{22,20},
			{"남", "여"}
			
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
		return data[columnIndex][rowIndex]; // 왜 순서바꿈???
	}

	@Override
	public String getColumnName(int column) { // 김은지 : 헤드부분 출력
		return columNames[column];
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		//return true; // 김은지 : 전제 수정 가능.
		return columnIndex == 0? false : true; // 김은지 : 이름은 수정 못하게함.
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// 검사  /// 무슨검사..?
		data[rowIndex][columnIndex] = aValue;
	}
}
