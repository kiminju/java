import java.io.Serializable;

public class Academy implements Serializable {// 시리얼(직렬)<-->pararell(병렬)시킬 수 있는 인터페이스가 있다는 의미.
   //직렬 병렬은 어딘가에 전송시킬 때 필요하다. 직렬은 그냥 일렬로 줄 세울 수 있다는 의미.
    private String name;//선생님 성함
    private int age;//선생님 나이
    private String phone;//-없이 숫자로만 입력
    private String subject;//영,수,영수로만 텍스트입력
    private String  day;//근무 요일
    private int pay;
    
    
    public Academy(String name,int age, String phone, String subject,String  day,int pay){//데이터클래스라 메인 없이 그냥 생성자
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.subject = subject;
        this.day = day;
        this.pay = pay;
        
    }
    
    public String getname() {
        return name;
    }
    
    public int getage() {
        return age;
    }
    
    public String getsubject() {
        return subject;
    }

    public String getphone() {
        return phone;
    }
    public String getday() {
        return day;
    }
    public int getpay() {
        return pay;
    }

    
    public void setsubject(String subject) {
        this.subject = subject;
    }
    public void setname(String name) {
        this.name = name;
    }
    
    public void setage(int age) {
        this.age = age;
    }
    
    
    public void setphone(String phone) {
        this.phone = phone;
    }
    public void setday(String day) {
        this.day = day;
    }
    public void setpay(int  pay) {
        this.pay = pay;
    }
    
    public String toString(){// 오브젝트의 메소드 toString이므로 오버라이드 가능
        return getname() + "," + getage() + "," + getphone() + "," + getsubject()+ "," + getday()+ "," + getpay()+ "," ;
    }
    
}
