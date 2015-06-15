
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;


public class StudentManager {
	ArrayList<Student>s_list = new ArrayList<Student>();
    private String name;
    private int age;
    private String phone;//-없이 010빼고 숫자로만 입력
    private String subject;
    public StudentManager(ArrayList<Student>s_list, String name, int age, String  phone,String subject){
    this.name = name;
    this.s_list = s_list;
    this.age = age;
    this.phone = phone;
    this.subject = subject;}
    
	public void add(){
		Scanner s = new Scanner(System.in);
		System.out.println("추가 할 학생의 정보를 입력하세요"+"\n"+"   회원이름 나이 전화번호 과목 (띄어써주시기 바랍니다. 전화번호의 -는 생략, 과목은 영/수/영수)");
		String name = s.next();
		int age = s.nextInt();
		String  phone = s.next();
		String subject = s.next();
		int to_add = find(name);
		if(to_add!=-1){
			System.out.println("등록하시려는 학생의 이름이 존재합니다.");
		}
		else{
		Student new_student = new Student(name,age,phone,subject);
		s_list.add(new_student);
		}
	}
	
	public void remove(){
		Scanner s = new Scanner(System.in);
		System.out.println("삭제할 학생의 이름을 입력해주세요");
		String name_ = s.next();
		int phone_ = s.nextInt();
		int to_remove = find(name_);
		if(to_remove == -1){
			System.out.println("찾으시는 학생이 없습니다.");
		}
		else{
		s_list.remove(to_remove-1);
		}
	}
	
	public int find(String name){
		int found =-1;
		for(int i =0; i<s_list.size();i++){
			Student temp = s_list.get(i);
			if(temp.getname().equals(name)
					)
			{
				found=i;
				
			}
		}
		
		return found;
	}
	
	public void modify(){
		Scanner s = new Scanner(System.in);
		
		System.out.println("수정할 학생의 이름을 입력해주세요");
		String name = s.next();
		int to_modify = find(name);
		if(to_modify == -1){
			System.out.println("찾으시는 학생이 없습니다.");
		}
		else{
			System.out.println("추가 할 학생의 정보를 입력하세요"+"\n"+"  나이 전화번호 과목 (띄어써주시기 바랍니다. 전화번호의 -는 생략, 과목은 영/수/영수)");
			int age = s_list.get(to_modify).getage();
			String  phone =s_list.get(to_modify).getphone();
			String subject = s_list.get(to_modify).getsubject();
			Student new_student = new Student(name,age,phone,subject);
			s_list.set(to_modify,  new_student);
			
		}
		
	}
	public void read(){
		FileInputStream fin = null;
		ObjectInputStream ois = null;
		s_list.clear();

		try{
			fin = new FileInputStream("booklist.dat");
			ois = new ObjectInputStream(fin);
			
			ArrayList list = (ArrayList)ois.readObject();
			for(int i =0; i<list.size(); i++){
				System.out.println(list.get(i));
				s_list.add((Student)list.get(i));
			}
			
			
			
		}catch(Exception ex){
		}finally{
			if(fin != null) try{fin.close();}catch(IOException e){}
			if(ois != null) try{ois.close();}catch(IOException e){}
		}
		} // finally
	
	
	public void save(){
		 FileOutputStream fout = null;
	        ObjectOutputStream oos = null;
	        
	        ArrayList list = new ArrayList();
	        for (int i =0; i<s_list.size();i++){
	        	list.add(s_list.get(i));
	        }
	        
	        
	        try{
	            fout = new FileOutputStream("studentlist.dat");
	            oos = new ObjectOutputStream(fout);
	            oos.writeObject(list);
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
	        }
	}
	
	}
	


	


