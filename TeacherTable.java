import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;
 
public class TeacherTable extends AbstractTableModel {
        //컬럼의 이름
	private final static String[] COLUMNS =
{"선생님이름", "나이", "전화번호", "과목","근무요일","월급"};
        //데이터s
        Object[][] data = {{" ", " "," "," "," "," "}};
        
       

        

        	private List<Academy> teachers;

        	public TeacherTable(List<Academy> teacher) {
        		this.teachers= teacher;
        	}

        	@Override
        	public int getRowCount() {
        		return teachers.size();
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
        		Academy teacher = teachers.get(rowIndex);
        		switch (columnIndex) {
        		case 0:
        			return teacher.getname();
        		case 1:
        			return teacher.getage();
        		case 2:
        			return teacher.getphone();
        		case 3:
        			return teacher.getsubject();
        		case 4:
        			return teacher.getday();
        		case 5:
        			return teacher.getpay();
        		
        		}
        		return null;
        	}
        	
}

