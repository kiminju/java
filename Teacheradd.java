

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Teacheradd extends javax.swing.JFrame implements ActionListener {
	private JTextField name;
	private JTextField age;
	private JTextField phone;
	private JTextField subject;
	private JTextField day;
	private JTextField pay;
	JButton bt1 = new JButton("등록");
	JButton bt2 = new JButton("취소");
	JRadioButton english;
	JRadioButton math;
	MyFrame frame = new MyFrame();
	ButtonGroup bg = new ButtonGroup();
	
	public Teacheradd(){
	
		frame.setTitle("선생님 등록");
		frame.setSize(500, 330);
		frame.setLocation(500, 300);
		JLabel mName = new JLabel("선생님성함 :");
		mName.setBounds(27, 15, 90, 30);
		frame.getContentPane().add(mName);
		
		JLabel mAge = new JLabel("선생님나이 :");
		mAge.setBounds(27, 45, 90, 30);
		frame.getContentPane().add(mAge);
		
		JLabel mPhone = new JLabel("전화번호 :");
		mPhone.setBounds(27, 75, 90, 30);
		frame.getContentPane().add(mPhone);
		

		
		JLabel mday= new JLabel("담당 요일 :");
		mday.setBounds(27, 150, 90, 30);
		frame.getContentPane().add(mday);
		
		JLabel mpay = new JLabel("선생님월급 :");
		mpay.setBounds(27, 190, 90, 30);
		frame.getContentPane().add(mpay);
		
		JLabel subjects = new JLabel("수강 과목 :");
		subjects.setBounds(27, 110, 90, 30);
		frame.getContentPane().add(subjects);
		
		english = new JRadioButton("영어");
		english.setBounds(117, 120, 90, 23);
		
		math = new JRadioButton("수학");
		math.setBounds(207,120, 90, 23);
		
		
		bg.add(english);
		bg.add(math);
		
		frame.getContentPane().add(english);
		frame.getContentPane().add(math);
		
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(110, 20, 62, 21);
		frame.getContentPane().add(name);
	
		age = new JTextField();
		age.setColumns(10);
		age.setBounds(110, 50, 62, 21);
		frame.getContentPane().add(age);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(110, 80, 144, 21);
		frame.getContentPane().add(phone);
		

		
		day = new JTextField();
		day.setColumns(10);
		day.setBounds(110, 160, 150, 21);
		frame.getContentPane().add(day);
		
		pay = new JTextField();
		pay.setColumns(10);
		pay.setBounds(110, 198, 150, 21);
		frame.getContentPane().add(pay);

		bt1.setBounds(97, 232, 97, 40);
		frame.getContentPane().add(bt1);
		
		bt2.setBounds(280, 232, 97, 40);
		frame.getContentPane().add(bt2);
		
		
		
		frame.setVisible(true);
		
		bt1.addActionListener(this);
		bt2.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bt1){
			String s_name = name.getText();
			String s_age = age.getText();
			String s_phone = phone.getText();
			String s_subject = null;
			String s_day = day.getText();
			String s_pay = pay.getText();
			if(english.isSelected()){
				s_subject = "영";
			}else if(math.isSelected()){
				s_subject = "수";
			}
			if(s_name.equals("")){
				JOptionPane.showMessageDialog(this, "선생님 이름을 입력해 주세요", "메시지", JOptionPane.INFORMATION_MESSAGE);
			}else if(s_name.equals("")){
				JOptionPane.showMessageDialog(this, "선생님 이름을 입력해 주세요", "메시지", JOptionPane.INFORMATION_MESSAGE);
			}else if(s_age.equals("")){
				JOptionPane.showMessageDialog(this, "선생님 나이를 입력해 주세요", "메시지", JOptionPane.INFORMATION_MESSAGE);
			}else if(s_phone.equals("")){
				JOptionPane.showMessageDialog(this, "회원 전화번호를 입력해 주세요", "메시지", JOptionPane.INFORMATION_MESSAGE);
			}
			else if(s_subject.equals("")){
				JOptionPane.showMessageDialog(this, "담당과목을 입력해 주세요", "메시지", JOptionPane.INFORMATION_MESSAGE);
			}else if(s_day.equals("")){
				JOptionPane.showMessageDialog(this, "담당요일을 입력해 주세요", "메시지", JOptionPane.INFORMATION_MESSAGE);
			}else if(s_pay.equals("")){
				JOptionPane.showMessageDialog(this, "선생님 월급을 입력해 주세요", "메시지", JOptionPane.INFORMATION_MESSAGE);
			}
			else{
				//for(int i=0; i<s_list.size(); i++){
					//if(s_name.equals(s_list.get(i).getname())){
						//JOptionPane.showMessageDialog(this, "동일한 회원이름이 있습니다.", "메시지", JOptionPane.INFORMATION_MESSAGE);
					//}
				
				//}
			 if(!integerOrNot(s_age)){
					JOptionPane.showMessageDialog(this, "나이는 문자를 입력할 수 없습니다.", "메시지", JOptionPane.INFORMATION_MESSAGE);
				}else if(!integerOrNot(s_phone)){
					JOptionPane.showMessageDialog(this, "전화번호는 문자를 입력할 수 없습니다.", "메시지", JOptionPane.INFORMATION_MESSAGE);
				}else if(!((s_phone.length() ==11))){
					JOptionPane.showMessageDialog(this, "잘못된 전화번호를 입력하였습니다.", "메시지", JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					int check = JOptionPane.showConfirmDialog(this, "입력한 내용이 맞습니까?\n" + 
							"\n선생님 이름 : "+s_name + "\n선생님 나이 : " + s_age + 
							"\n전화번호 : " + s_phone + "\n담당과목 : " +s_subject+ "\n담당요일 : " +s_day+ "\n선생님월급 : " +s_pay,
							"메시지", JOptionPane.INFORMATION_MESSAGE );
					if(check == 0){
						String name = s_name;
						int age = Integer.parseInt(s_age);
						String phone = s_phone;
						String subject = s_subject;
						String day = s_day;
						int pay = Integer.parseInt(s_pay);
						Academy new_teacher = new Academy(name,age,phone,subject,day,pay);
						ViewStudent.t_list.add(new_teacher);
						}
						JOptionPane.showMessageDialog(this, "등록되었습니다.", "메시지", JOptionPane.INFORMATION_MESSAGE);
						
						ViewStudent.tableteacher.setModel(new TeacherTable(ViewStudent.t_list));
						int check2 = JOptionPane.showConfirmDialog(this, "계속 입력하시겠습니까?");
						if(check2 == 0){
							name.setText(null);
							age.setText(null);
							bg.clearSelection();
							pay.setText(null);
							day.setText(null);
				
						}else if(check2 == 1){
							frame.setVisible(false);
						}
					}
				}
			}
		else if(e.getSource() == bt2){
			frame.dispose();
		}
	}
	
	public boolean integerOrNot(String strData){ // 입력값이 숫자인지 문자인지 판별 : 
		char[] charData = strData.toCharArray();
		boolean check=true;
		while(check){
			for(int i=0; i<charData.length; i++){		
				if(!Character.isDigit(charData[i])){
						check = !check;
						break;
				}
			}
			break;	
		}return check;
	}



	
	
	
	
}