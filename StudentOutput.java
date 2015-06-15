import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class StudentOutput{
    
    public static void main(String[] args) {
        FileOutputStream fout = null;
        ObjectOutputStream oos = null;
        
        ArrayList list = new ArrayList();
        Student b1 = new Student("원빈", 15, "01012345678", "영");
        Student b2 = new Student("장동건", 18, "01012345679", "수");
        Student b3 = new Student("이나영", 19, "01012345677", "영수");
        
        
        try{
            fout = new FileOutputStream("studentlist.dat");
            oos = new ObjectOutputStream(fout);
            
            oos.writeObject(list);//�뙆�씪 �엯�젰�쓽 踰뺤튃�뿉 �뵲�씪 �몢踰� �븳 寃껋엫.
            oos.reset();
            oos.writeObject(list);
            oos.reset();
            
            System.out.println("저장되었습니다");
            
        }catch(Exception ex){
        }finally{
            try{
                oos.close();
                fout.close();
            }catch(IOException ioe){}
        } // finally
    } // main end
} // class end
