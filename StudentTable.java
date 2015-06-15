import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
 
public class StudentTable extends AbstractTableModel {
        //컬럼의 이름
	private final static String[] COLUMNS =
{"회원이름", "나이", "전화번호", "과목"};
        //데이터s
        Object[][] data = {{" ", " "," "," "}};
        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
        
       

        

        	private List<Student> Students;

        	public StudentTable(List<Student> Students) {
        		this.Students= Students;
        	}

        	@Override
        	public int getRowCount() {
        		return Students.size();
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
        		Student student = Students.get(rowIndex);
        		switch (columnIndex) {
        		case 0:
        			return student.getname();
        		case 1:
        			return student.getage();
        		case 2:
        			return student.getphone();
        		case 3:
        			return student.getsubject();
  

        		}
        		return null;
        	}
}
