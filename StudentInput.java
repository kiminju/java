import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class StudentInput{

	public static void main(String[] args) {
		FileInputStream fin = null;
		ObjectInputStream ois = null;
		

		try{
			fin = new FileInputStream("studentlist.dat");
			ois = new ObjectInputStream(fin);
			
			ArrayList list = (ArrayList)ois.readObject();
			Student b1 = (Student)list.get(0);
			Student b2 = (Student)list.get(1);
			Student b3 = (Student)list.get(2);
			System.out.println(list);
			
			System.out.println(b1.toString());
			System.out.println(b2.toString());
			System.out.println(b3.toString());
			
		}catch(Exception ex){
		}finally{
			if(fin != null) try{fin.close();}catch(IOException e){}
			if(ois != null) try{ois.close();}catch(IOException e){}
		}
		} // finally
	} // main end
 // class end