import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class ScoreTableModel extends AbstractTableModel {

	private Vector<Student> mData;
	private String[] mColumNames = {"이름", "C", "JAVA","C++","총점","평균"};
	
	public ScoreTableModel(Vector<Student> v, int n) {
		mData = v;
		
		// mData에 빈 학생 객체들을 추가
		for ( int i = 0; i < n; i++)
			mData.add(new Student());
		
	}
	
	@Override
	public int getColumnCount() {
		return mColumNames.length;
	}

	@Override
	public int getRowCount() {
		if (mData != null)
			return mData.size();
		else
			return 0;
	}

	@Override
	public Object getValueAt(int r, int c) {
		Student s = mData.get(r);
		
		switch(c) {
		case 0: return s.GetName();
		case 1: return s.GetCScore();
		
		}
		
		return null;
	}

	@Override
	public String getColumnName(int column) {
		return mColumNames[column];
	}

	@Override
	public boolean isCellEditable(int r, int c) { // 편집가능여부로 만들기.
		if(c<=3)
			return true;
		else
			return false;
		
		//return super.isCellEditable(r, c);
	}

	@Override
	public void setValueAt(Object aValue, int r, int c) {
		Student s = mData.get(r);
		
		switch(c) {
		case 0: s.SetName((String) aValue); break;
		case 1: 
			int n = Integer.parseInt((String) aValue);
			s.SetCScore(n);
			break;
		}
		
		// s에 대해 합계 계산
		this.fireTableDataChanged();
	}
	
	public void addRow() { // 추가
		mData.add(new Student());
	}

}





