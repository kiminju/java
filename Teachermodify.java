

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Teachermodify extends javax.swing.JFrame implements ActionListener {
	
	private JTextField name;
	private JTextField age;
	private JTextField phone;
	private JTextField subject;
	private JTextField day;
	private JTextField pay;
	JButton bt1 = new JButton("등록");
	JButton bt2 = new JButton("취소");
	MyFrame frame = new MyFrame();
	ButtonGroup bg = new ButtonGroup();
	int row = ViewStudent.tableteacher.getSelectedRow();
	
	
	public Teachermodify(){
		frame.setTitle("선생님 정보 수정");
		frame.setSize(500, 330);
		frame.setLocation(500, 300);
		JLabel mName = new JLabel("학생 이름 :");
		mName.setBounds(27, 16, 90, 30);
		frame.getContentPane().add(mName);
		
		JLabel mAge = new JLabel("선생님나이 :");
		mAge.setBounds(27, 45, 90, 30);
		frame.getContentPane().add(mAge);
		
		JLabel mPhone = new JLabel("전화번호 :");
		mPhone.setBounds(27, 75, 90, 30);
		frame.getContentPane().add(mPhone);
		
		JLabel mAddr = new JLabel("담당 과목 :");
		mAddr.setBounds(27, 105, 90, 30);
		frame.getContentPane().add(mAddr);
		
		JLabel mday= new JLabel("담당 요일 :");
		mday.setBounds(27, 135, 90, 30);
		frame.getContentPane().add(mday);
		
		JLabel mpay = new JLabel("선생님월급 :");
		mpay.setBounds(27, 165, 90, 30);
		frame.getContentPane().add(mpay);
		
		name = new JTextField();
		name.setText(ViewStudent.t_list.get(row).getname());
		name.setColumns(10);
		name.setBounds(97, 21, 62, 21);
		frame.getContentPane().add(name);
	
	
		age = new JTextField();
		String age2 = String.valueOf(ViewStudent.t_list.get(row).getage());
		age.setText(age2);
		age.setColumns(10);
		age.setBounds(97, 50, 62, 21);
		frame.getContentPane().add(age);
		
		phone = new JTextField();
		String phone2 = String.valueOf(ViewStudent.t_list.get(row).getphone());
		phone.setText(phone2);
		phone.setColumns(10);
		phone.setBounds(97, 80, 144, 21);
		frame.getContentPane().add(phone);
		
		subject = new JTextField();
		subject.setText(ViewStudent.t_list.get(row).getsubject());
		subject.setColumns(10);
		subject.setBounds(97, 110, 150, 21);
		frame.getContentPane().add(subject);
		
		day = new JTextField();
		day.setText(ViewStudent.t_list.get(row).getday());
		day.setColumns(10);
		day.setBounds(97, 140, 150, 21);
		frame.getContentPane().add(day);
		
		pay = new JTextField();
		String pay2 = String.valueOf(ViewStudent.t_list.get(row).getpay());
		pay.setText(pay2);
		pay.setColumns(10);
		pay.setBounds(100, 170, 150, 21);
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
			String s_subject = subject.getText();
			String s_day = day.getText();
			String s_pay = pay.getText();
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
				else if(!(s_subject.equals("영")||s_subject.equals("영수")||s_subject.equals("수"))){
					JOptionPane.showMessageDialog(this, "과목은 영,영수,수 형태로 입력해주세요.", "메시지", JOptionPane.INFORMATION_MESSAGE);
				}else{
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
						ViewStudent.t_list.remove(row);
						ViewStudent.t_list.add(row, new_teacher);
						}
						JOptionPane.showMessageDialog(this, "수정 되었습니다.", "메시지", JOptionPane.INFORMATION_MESSAGE);
						ViewStudent.tableteacher.setModel(new TeacherTable(ViewStudent.t_list));
						//ViewStudent.tableBook.setModel(new StudentTable(ViewStudent.s_list));
						frame.dispose();
						
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