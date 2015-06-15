import java.io.Serializable;

public class Studentinout implements Serializable {// 시리얼(직렬)<-->pararell(병렬)시킬 수 있는 인터페이스가 있다는 의미.
   //직렬 병렬은 어딘가에 전송시킬 때 필요하다. 직렬은 그냥 일렬로 줄 세울 수 있다는 의미.
    private String name;
    private String time;
    private String text;
    
    
    public Studentinout(String time, String name,String text){//데이터클래스라 메인 없이 그냥 생성자
        this.name = name;
        this.time = time;
        this.text = text;
        
    }
    
    public String getname() {
        return name;
    }
    public String gettime() {
        return time;
    }
    public String gettext() {
        return text;
    }
    
   
  
    
   
    public void setname(String name) {
        this.name = name;
    }
    public void settext(String text) {
    	this.text = text;
    }
    public void settime(String time) {
    	this.time = time;
    }
    public String toString(){// 오브젝트의 메소드 toString이므로 오버라이드 가능
        return gettime() + "," + getname() + "," + gettext();
    }
}
    
    
    
   
