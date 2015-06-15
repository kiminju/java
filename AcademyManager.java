
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;


public class AcademyManager {
   
	ArrayList<Academy>t_list = new ArrayList<Academy>();
	private String name;
    private int age;
    private String  phone;//-없이 010빼고 숫자로만 입력
    private String subject;
    private int pay;
    private String day;
    
    public AcademyManager(ArrayList<Academy>t_list, String name, int age, String  phone,String subject,String day,int pay){
        this.name = name;
        this.t_list = t_list;
        this.age = age;
        this.phone = phone;
        this.subject = subject;
        this.pay = pay;
        this.day = day;
        }
	public void add_(){
		Scanner s = new Scanner(System.in);
		System.out.println("추가할 선생님의 정보를 입력하세요"+"\n"+"   선생님이름 나이 전화번호 담당과목 근무요일 월급 설명(띄어써주시기 바랍니다. 전화번호의 -는 생략, 과목은 영/수/영수)");
		String name = s.next();
		int age = s.nextInt();
		String  phone = s.next();
		String subject = s.next();
		String  day= s.next();//근무 요일
	    int pay= s.nextInt();
	    String text= s.next();
	    int to_add = find_(name);
		if(to_add!=-1){
			System.out.println("등록하시려는 선생님의 이름이 존재합니다.");
		}
		else{
	    Academy new_teacher = new Academy(name,age,phone,subject,day,pay);
		t_list.add(new_teacher);
		}
		
	}
	
	public void remove_(){
		Scanner s = new Scanner(System.in);
		System.out.println("삭제할선생님의 이름을 입력해주세요");
		String name_ = s.next();
		int phone_ = s.nextInt();
		int to_remove = find_(name_);
		if(to_remove == -1){
			System.out.println("찾으시는 선생님이 없습니다.");
		}
		else{
		t_list.remove(to_remove-1);
		}
	}
	
	public int find_(String name){
		int found =-1;
		for(int i =0; i<t_list.size();i++){
			Academy temp = t_list.get(i);
			if(temp.getname().equals(name)
					
					)
			{
				found=i;
				
			}
			
		}
		
		return found;
	}
	
	public void modify_(){
		Scanner s = new Scanner(System.in);
		
		System.out.println("수정할 선생님의 이름을 입력해주세요");
		String name = s.next();
		int to_modify = find_(name);
		if(to_modify == -1){
			System.out.println("찾으시는 선생님이 없습니다.");
		}
		else{
			System.out.println("수정할 선생님의 정보를 입력하세요"+"\n"+" 나이 전화번호 담당과목 근무요일 월급 설명(띄어써주시기 바랍니다. 전화번호의 -는 생략, 과목은 영/수/영수)");
			int age = t_list.get(to_modify).getage();
			String  phone =t_list.get(to_modify).getphone();
			String subject = t_list.get(to_modify).getsubject();
			String day = t_list.get(to_modify).getday();
			int pay =t_list.get(to_modify).getpay();
			
			Academy new_teacher = new Academy(name,age,phone,subject,day,pay);
			t_list.set(to_modify,  new_teacher);
			
		}
		
	}
	public void read_(){
		FileInputStream fin = null;
		ObjectInputStream ois = null;
		t_list.clear();

		try{
			fin = new FileInputStream("booklist.dat");
			ois = new ObjectInputStream(fin);
			
			ArrayList list = (ArrayList)ois.readObject();
			for(int i =0; i<list.size(); i++){
				System.out.println(list.get(i));
				t_list.add((Academy)list.get(i));
			}
			
			
			
		}catch(Exception ex){
		}finally{
			if(fin != null) try{fin.close();}catch(IOException e){}
			if(ois != null) try{ois.close();}catch(IOException e){}
		}
		} // finally
	
	
	public void save_(){
		 FileOutputStream fout = null;
	        ObjectOutputStream oos = null;
	        
	        ArrayList list = new ArrayList();
	        for (int i =0; i<t_list.size();i++){
	        	list.add(t_list.get(i));
	        }
	        
	        
	        try{
	            fout = new FileOutputStream("teacherlist.dat");
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
	


	


