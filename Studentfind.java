

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Studentfind extends javax.swing.JFrame implements ActionListener {
	
	private JTextField name;
	JButton bt1 = new JButton("찾기");
	JButton bt2 = new JButton("취소");
	MyFrame frame = new MyFrame();
	ButtonGroup bg = new ButtonGroup();
	int row = ViewStudent.tableBook.getSelectedRow();
	
	
	public Studentfind(){
		frame.setTitle("학생 정보 찾기");
		frame.setSize(400, 300);
		frame.setLocation(500, 300);
		JLabel Name = new JLabel("학생 이름은 무엇인가요?");
		Name.setBounds(120, 50, 300, 30);;
		frame.getContentPane().add(Name);
		name = new JTextField();
		name.setText("");
		name.setColumns(10);
		name.setBounds(140, 100, 62, 30);
		frame.getContentPane().add(name);
		bt1.setBounds(70, 180, 97, 40);
		frame.getContentPane().add(bt1);
		bt2.setBounds(200, 180,97, 40);
		frame.getContentPane().add(bt2);
		frame.setVisible(true);
		
		bt1.addActionListener(this);
		bt2.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bt1){
			String s_name = name.getText();
			int found =-1;
			for(int i =0; i<ViewStudent.s_list.size();i++){
				Student temp = ViewStudent.s_list.get(i);
				if(temp.getname().equals(s_name))
				{
					found = i;
					String name = ViewStudent.s_list.get(i).getname();
					int age = ViewStudent.s_list.get(i).getage();
					String phone = ViewStudent.s_list.get(i).getphone();
					String subject = ViewStudent.s_list.get(i).getsubject();
					JOptionPane.showConfirmDialog(this, " 찾으시는학생의 정보입니다.\n" + 
							"\n학생 이름 : "+name + "\n학생 나이 : " + age + 
							"\n전화번호 : " + phone + "\n수강과목 : " +subject,
							"메시지", JOptionPane.CANCEL_OPTION );
					frame.dispose();
				}
			}
			if(found==-1){
				JOptionPane.showConfirmDialog(this, " 찾으시는 학생이 없습니다.",
						"메시지", JOptionPane.CLOSED_OPTION);
				//frame.dispose();
				} 
		}
			
		else if(e.getSource() == bt2){
			frame.dispose();
		}
	}
	
	



	
	
	
	
}