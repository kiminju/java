

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Studentadd extends javax.swing.JFrame implements ActionListener {
	private JTextField name;
	private JTextField age;
	private JTextField phone;
	private JTextField subject;
	JButton bt1 = new JButton("등록");
	JButton bt2 = new JButton("취소");
	MyFrame frame = new MyFrame();
	JRadioButton english;
	JRadioButton math;
	JRadioButton eandm;
	ButtonGroup bg = new ButtonGroup();
	
	public Studentadd(){
	
		frame.setTitle("신입생");
		frame.setSize(500, 330);
		frame.setLocation(500, 300);
		JLabel mName = new JLabel("학생 이름 :");
		mName.setBounds(27, 16, 90, 30);
		frame.getContentPane().add(mName);
		
		JLabel mAge = new JLabel("학생 나이 :");
		mAge.setBounds(27, 61, 90, 30);
		frame.getContentPane().add(mAge);
		
		JLabel mPhone = new JLabel("전화번호 (숫자로만 입력):");
		mPhone.setBounds(27, 106, 150, 30);
		frame.getContentPane().add(mPhone);
		
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(97, 21, 62, 21);
		frame.getContentPane().add(name);
	
		age = new JTextField();
		age.setColumns(10);
		age.setBounds(97, 66, 62, 21);
		frame.getContentPane().add(age);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(180, 115, 144, 21);
		frame.getContentPane().add(phone);
		
		
		
		JLabel subjects = new JLabel("수강 과목 :");
		subjects.setBounds(27, 158, 90, 30);
		frame.getContentPane().add(subjects);
		
		english = new JRadioButton("영어");
		english.setBounds(117, 165, 90, 23);
		
		math = new JRadioButton("수학");
		math.setBounds(207,165, 90, 23);
		
		eandm = new JRadioButton("영수");
		eandm.setBounds(297, 165, 90, 23);
		
		bg.add(english);
		bg.add(math);
		bg.add(eandm);
		
		frame.getContentPane().add(english);
		frame.getContentPane().add(math);
		frame.getContentPane().add(eandm);

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
			//String s_subject = subject.getText();
			String s_subject = null;
			if(english.isSelected()){
				s_subject = "영";
			}else if(math.isSelected()){
				s_subject = "수";
			}else if(eandm.isSelected()){
				s_subject = "영수";
			}
			if(s_name.equals("")){
				JOptionPane.showMessageDialog(this, "학생 이름을 입력해 주세요", "메시지", JOptionPane.INFORMATION_MESSAGE);
			}else if(s_name.equals("")){
				JOptionPane.showMessageDialog(this, "회원 이름을 입력해 주세요", "메시지", JOptionPane.INFORMATION_MESSAGE);
			}else if(s_age.equals("")){
				JOptionPane.showMessageDialog(this, "회원 나이를 입력해 주세요", "메시지", JOptionPane.INFORMATION_MESSAGE);
			}else if(s_phone.equals("")){
				JOptionPane.showMessageDialog(this, "회원 전화번호를 입력해 주세요", "메시지", JOptionPane.INFORMATION_MESSAGE);
			}
			else if(s_subject.equals("")){
				JOptionPane.showMessageDialog(this, "수강과목을 입력해 주세요", "메시지", JOptionPane.INFORMATION_MESSAGE);
			}
			else{
				
				
				//}
			 if(!integerOrNot(s_age)){
					JOptionPane.showMessageDialog(this, "회원 나이는 문자를 입력할 수 없습니다.", "메시지", JOptionPane.INFORMATION_MESSAGE);
				}else if(!integerOrNot(s_phone)){
					JOptionPane.showMessageDialog(this, "전화번호는 문자를 입력할 수 없습니다.", "메시지", JOptionPane.INFORMATION_MESSAGE);
				}else if(!((s_phone.length() == 11))){
					JOptionPane.showMessageDialog(this, "잘못된 전화번호를 입력하였습니다.", "메시지", JOptionPane.INFORMATION_MESSAGE);
				}
				
			else{
					int check = JOptionPane.showConfirmDialog(this, "입력한 내용이 맞습니까?\n" + 
							"\n학생 이름 : "+s_name + "\n학생 나이 : " + s_age + 
							"\n전화번호 : " + s_phone + "\n수강과목 : " +s_subject,
							"메시지", JOptionPane.INFORMATION_MESSAGE );
					if(check == 0){
						String name = s_name;
						int age = Integer.parseInt(s_age);
						String phone = s_phone;
						String subject = s_subject;
						Student new_student = new Student(name,age,phone,subject);
						ViewStudent.s_list.add(new_student);
						}
						JOptionPane.showMessageDialog(this, "회원이 등록되었습니다.", "메시지", JOptionPane.INFORMATION_MESSAGE);
						
						ViewStudent.tableBook.setModel(new StudentTable(ViewStudent.s_list));
						int check2 = JOptionPane.showConfirmDialog(this, "계속 입력하시겠습니까?");
						if(check2 == 0){
							name.setText(null);
							age.setText(null);
							phone.setText(null);
							bg.clearSelection();
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