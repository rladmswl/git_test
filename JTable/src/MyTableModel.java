import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {
	String[] columNames = {"이름", "나이", "성별"};
	
	Object[][] data = {
			{"고주몽", 22, "남" },
			{"소서노", 20, "여" }
	};

	@Override
	public int getColumnCount() {
		return columNames.length; 
	}

	@Override
	public int getRowCount() {
		return data.length; // 김은지 : 일차원 배열 2개 가지고 있다는 뜻.
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data[rowIndex][columnIndex];
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
		// 검사
		data[rowIndex][columnIndex] = aValue;
	}

	
	
	
}
