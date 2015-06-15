import java.util.List;

import javax.swing.table.AbstractTableModel;

public class  StudentinoutTable extends AbstractTableModel {
        //컬럼의 이름
	private final static String[] COLUMNS = {"시간", "이름", "내용"};
        //데이터s
        Object[][] data = {{" ", " "," "}};
        
       

        

        	private List<Studentinout> Studentinout;

        	public StudentinoutTable(List<Studentinout> Studentinout) {
        		this.Studentinout= Studentinout;
        	}

        	@Override
        	public int getRowCount() {
        		return Studentinout.size();
        	}

        	@Override
        	public int getColumnCount() {
        		return COLUMNS.length;
        	}

        	@Override
        	public String getColumnName(int column) {
        		return COLUMNS[column];
        	}

        	@Override
        	public Object getValueAt(int rowIndex, int columnIndex) {
        		Studentinout student = Studentinout.get(rowIndex);
        		switch (columnIndex) {
        		case 0:
        			return student.gettime();
        		case 1:
        			return student.getname();
        		case 2:
        			return student.gettext();
        		

        		}
        		return null;
        	
        	}
	}