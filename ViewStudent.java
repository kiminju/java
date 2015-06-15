import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

public class ViewStudent extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	public static ArrayList<Student> s_list = new ArrayList<Student>();
	public static ArrayList<Studentinout> inout_list = new ArrayList<Studentinout>();
	private String name;
	private int age;
	private String  phone;// -없이 010빼고 숫자로만 입력
	private String subject;
	StudentManager sm = new StudentManager(s_list, name, age, phone, subject);
	public static ArrayList<Academy> t_list = new ArrayList<Academy>();
	private int pay;
	private String day;
	AcademyManager am = new AcademyManager(t_list, name, age, phone, subject,day, pay);
	Date today = new Date();
	SimpleDateFormat time = new SimpleDateFormat("hh시 mm분 ss초 ");

	/**
	 * Creates new form Students
	 */
	public ViewStudent() {

		createMenu();
		setSize(600, 600);
		setVisible(true);
		

	}

	void createMenu() {
		JMenuBar mb = new JMenuBar();
		JMenuItem[] menuItem = new JMenuItem[2];
		String[] itemTitle = { "학생관리", "선생님관리" };
		JMenu Menu1 = new JMenu("학원관리");
		for (int i = 0; i < menuItem.length; i++) {
			menuItem[i] = new JMenuItem(itemTitle[i]);
			menuItem[i].addActionListener(new MenuActionListener());
			Menu1.add(menuItem[i]);
		}
		mb.add(Menu1);
		this.setJMenuBar(mb);
		mb.add(Menu1);
		JMenu menu2 = new JMenu("프로그램");
		mb.add(menu2);

		JMenuItem menu2Item = new JMenuItem("출결프로그램");
		menu2.add(menu2Item);

		menu2Item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initprogram();
			}
		});
		this.setJMenuBar(mb);
	}

	class MenuActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if (cmd.equals("학생관리"))
				initComponents();
			else if (cmd.equals("선생님관리"))
				initComponents2();
		}
		// 학생관리눌럿다가 선생님관리누르면 바뀌게 하기

	}

	private void initprogram() {
		SwingWorker worker = new SwingWorker() {

			@Override
			protected Object doInBackground() throws Exception {
				// test for books
				FileInputStream fin = null;
				ObjectInputStream ois = null;
				s_list.clear();
				try {
					fin = new FileInputStream("studentlist.dat");
					ois = new ObjectInputStream(fin);
					ArrayList list = (ArrayList) ois.readObject();
					for (int i = 0; i < list.size(); i++)
						s_list.add((Student) list.get(i));

				} catch (Exception e) {
					System.out.println(e.getMessage());
				} finally {
					try {
						ois.close();
						fin.close();
					} catch (IOException ioe) {
					}
				}
				return null;
			}
		};
		worker.execute();
	


		enterButton = new javax.swing.JButton();
		buttonPanel = new javax.swing.JPanel();
		scrollpane = new javax.swing.JScrollPane();
		tableprogram = new javax.swing.JTable();
		enterButton = new javax.swing.JButton();
		login = new javax.swing.JTextField("전화번호를 입력하세요 ");
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().removeAll();
		setTitle(" Hello Program");
		tableprogram.setModel(new StudentinoutTable(
				new ArrayList<Studentinout>()));
		buttonPanel.add(login);
		buttonPanel.add(enterButton);
		getContentPane().add(buttonPanel, java.awt.BorderLayout.PAGE_END);
		scrollpane.setViewportView(tableprogram);
		getContentPane().add(scrollpane, java.awt.BorderLayout.CENTER);
		getContentPane().setSize(600, 600);
		enterButton.setText("Search");
		enterButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				enterButtonActionPerformed(evt, login.getText());
			}
		});

		this.pack();
		this.setSize(600,600);
	}

	private void initComponents() {// 학생관리

		scrollpane = new javax.swing.JScrollPane();
		tableBook = new javax.swing.JTable();
		loadButton = new javax.swing.JButton();
		deleteButton = new javax.swing.JButton();
		saveButton = new javax.swing.JButton();
		buttonPanel = new javax.swing.JPanel();
		addButton = new javax.swing.JButton();
		findButton = new javax.swing.JButton();
		modifyButton = new javax.swing.JButton();
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().removeAll();
		setTitle("Student Management System");
		tableBook.setEnabled(true);
		tableBook.setModel(new StudentTable(new ArrayList<Student>()));
		scrollpane.setViewportView(tableBook);

		addButton.setText("add ");
		addButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addButtonActionPerformed(evt);
			}
		});

		getContentPane().add(scrollpane, java.awt.BorderLayout.CENTER);
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
        dtcr.setHorizontalAlignment(SwingConstants.CENTER);
        TableColumnModel tcm = tableBook.getColumnModel();
        for (int i = 0; i < tcm.getColumnCount(); i++) {
           tcm.getColumn(i).setCellRenderer(dtcr);
        }
		saveButton.setText("save");
		saveButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				saveButtonActionPerformed(evt);
			}
		});
		loadButton.setText("Load");
		loadButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				loadButtonActionPerformed(evt);
			}
		});

		deleteButton.setText("delete");
		deleteButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				deleteButtonActionPerformed(evt);
			}
		});
		modifyButton.setText("modify");
		modifyButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				modifyButtonActionPerformed(evt);
			}
		});
		findButton.setText("find");
		findButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				findButtonActionPerformed(evt);
			}
		});

		// /buttons
		buttonPanel.add(loadButton);
		buttonPanel.add(addButton);
		buttonPanel.add(findButton);
		buttonPanel.add(modifyButton);
		buttonPanel.add(deleteButton);
		buttonPanel.add(saveButton);

		getContentPane().add(buttonPanel, java.awt.BorderLayout.PAGE_END);
		this.pack();
		this.setSize(600,600);
	}

	private void initComponents2() {// 선생님관리

		scrollpane = new javax.swing.JScrollPane();
		tableteacher = new javax.swing.JTable();
		loadButton = new javax.swing.JButton();
		deleteButton = new javax.swing.JButton();
		saveButton = new javax.swing.JButton();
		buttonPanel = new javax.swing.JPanel();
		addButton = new javax.swing.JButton();
		findButton = new javax.swing.JButton();
		modifyButton = new javax.swing.JButton();
		getContentPane().removeAll();
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		setTitle("Teacher Management System");

		tableteacher.setModel(new TeacherTable(new ArrayList<Academy>()));
		scrollpane.setViewportView(tableteacher);

		addButton.setText("add ");
		addButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addButtonActionPerformed2(evt);
			}
		});

		getContentPane().add(scrollpane, java.awt.BorderLayout.CENTER);
		saveButton.setText("save");
		saveButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				saveButtonActionPerformed2(evt);
			}
		});
		loadButton.setText("Load");
		loadButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				loadButtonActionPerformed2(evt);
			}
		});

		deleteButton.setText("delete");
		deleteButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				deleteButtonActionPerformed2(evt);
			}
		});
		modifyButton.setText("modify");
		modifyButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				modifyButtonActionPerformed2(evt);
			}
		});
		findButton.setText("find");
		findButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				findButtonActionPerformed2(evt);
			}
		});

		// /buttons
		buttonPanel.add(loadButton);
		buttonPanel.add(addButton);
		buttonPanel.add(findButton);
		buttonPanel.add(modifyButton);
		buttonPanel.add(deleteButton);
		buttonPanel.add(saveButton);

		getContentPane().add(buttonPanel, java.awt.BorderLayout.PAGE_END);
		this.pack();
		this.setSize(600,600);
		
		
	}

	private void enterButtonActionPerformed(java.awt.event.ActionEvent evt,
			String pnum) {

		String time_ = new SimpleDateFormat("hh시 mm분 ss초").format(Calendar.getInstance().getTime());
		String in_out = "";
		for (int i = 0; i < s_list.size(); i++) {
			if (s_list.get(i).getphone().equals(pnum)) {
				Student found = s_list.get(i);
				in_out = "등원";
				for (int j = 0; j < inout_list.size(); j++) {
					if (found.getname().equals(inout_list.get(j).getname())) {
						if (inout_list.get(j).gettext().equals("등원"))
							in_out = "하원";
						else
							in_out = "등원";

					}
					else
						in_out = "등원";
				}
				inout_list.add(new Studentinout(time_, found.getname(), in_out));
			}
			tableprogram.setModel(new StudentinoutTable(inout_list));
		}
		if(in_out==""){
			JOptionPane.showMessageDialog(this, "잘못입력하셨습니다.", "메시지", JOptionPane.ERROR_MESSAGE);
		}
		
		

	}

	private void deleteButtonActionPerformed2(java.awt.event.ActionEvent evt) {
		int row = ViewStudent.tableteacher.getSelectedRow();
		int check = JOptionPane.showConfirmDialog(this, t_list.get(row)
				.getname() + " 삭제하시겠습니까? ", "메시지",
				JOptionPane.INFORMATION_MESSAGE);
		if (check == 0) {
			ViewStudent.t_list.remove(row);

			JOptionPane.showMessageDialog(this, "삭제되었습니다.", "메시지",
					JOptionPane.INFORMATION_MESSAGE);
			ViewStudent.tableteacher.setModel(new TeacherTable(
					ViewStudent.t_list));
		}
		System.out.println("delete button!!!!");
	}

	private void findButtonActionPerformed2(java.awt.event.ActionEvent evt) {
		new Teacherfind();
		System.out.println("find button!!!!");
	}

	private void modifyButtonActionPerformed2(java.awt.event.ActionEvent evt) {
		new Teachermodify();
		System.out.println("modify button!!!!");
	}

	private void addButtonActionPerformed2(java.awt.event.ActionEvent evt) {
		new Teacheradd();
		System.out.println("add button!!!!");
	}

	private void loadButtonActionPerformed2(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_okButtonActionPerformed
		SwingWorker worker = new SwingWorker() {

			@Override
			protected Object doInBackground() throws Exception {
				// test for books
				FileInputStream fin = null;
				ObjectInputStream ois = null;
				t_list.clear();
				try {
					fin = new FileInputStream("teacherlist.dat");
					ois = new ObjectInputStream(fin);
					ArrayList list = (ArrayList) ois.readObject();
					for (int i = 0; i < list.size(); i++)
						t_list.add((Academy) list.get(i));

				} catch (Exception e) {
					System.out.println(e.getMessage());
				} finally {
					try {
						ois.close();
						fin.close();
					} catch (IOException ioe) {
					}
				}
				tableteacher.setModel(new TeacherTable(t_list));
				return null;
			}
		};
		worker.execute();
	}

	private void saveButtonActionPerformed2(java.awt.event.ActionEvent evt) {
		System.out.println("save button!!!!");
		SwingWorker worker = new SwingWorker() {

			@Override
			protected Object doInBackground() throws Exception {
				// test for books
				FileOutputStream fout = null;
				ObjectOutputStream oos = null;

				try {
					fout = new FileOutputStream("teacherlist.dat");
					oos = new ObjectOutputStream(fout);
					oos.writeObject(t_list);
					oos.reset();

					System.out.println("저장되었습니다.\n");

				} catch (Exception ex) {
				} finally {
					try {
						oos.close();
						fout.close();
					} catch (IOException ioe) {
					}
				} // finally
				tableteacher.setModel(new TeacherTable(t_list));
				t_list.clear();
				return null;
			}
		};
		worker.execute();
	}

	// 학생
	private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
		int row = ViewStudent.tableBook.getSelectedRow();
		int check = JOptionPane.showConfirmDialog(this, s_list.get(row)
				.getname() + "학생을 삭제하시겠습니까? : ", "메시지",
				JOptionPane.INFORMATION_MESSAGE);
		if (check == 0) {
			ViewStudent.s_list.remove(row);

			JOptionPane.showMessageDialog(this, "학생이 삭제되었습니다.", "메시지",
					JOptionPane.INFORMATION_MESSAGE);
			ViewStudent.tableBook
					.setModel(new StudentTable(ViewStudent.s_list));
		}
		System.out.println("delete button!!!!");
	}

	private void findButtonActionPerformed(java.awt.event.ActionEvent evt) {
		new Studentfind();
		System.out.println("find button!!!!");
	}

	private void modifyButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// tablebook.addMouseListener(new JTableMouseListener());
		new Studentmodify();
		System.out.println("modify button!!!!");
	}

	private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {
		new Studentadd();
		System.out.println("add button!!!!");
	}

	private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_okButtonActionPerformed
		SwingWorker worker = new SwingWorker() {

			@Override
			protected Object doInBackground() throws Exception {
				// test for books
				FileInputStream fin = null;
				ObjectInputStream ois = null;
				s_list.clear();
				try {
					fin = new FileInputStream("studentlist.dat");
					ois = new ObjectInputStream(fin);
					ArrayList list = (ArrayList) ois.readObject();
					for (int i = 0; i < list.size(); i++)
						s_list.add((Student) list.get(i));

				} catch (Exception e) {
					System.out.println(e.getMessage());
				} finally {
					try {
						ois.close();
						fin.close();
					} catch (IOException ioe) {
					}
				}
				tableBook.setModel(new StudentTable(s_list));
				return null;
			}
		};
		worker.execute();
	}

	private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {
		System.out.println("save button!!!!");
		SwingWorker worker = new SwingWorker() {
			@Override
			protected Object doInBackground() throws Exception {
				// test for books
				FileOutputStream fout = null;
				ObjectOutputStream oos = null;

				try {
					fout = new FileOutputStream("studentlist.dat");
					oos = new ObjectOutputStream(fout);
					oos.writeObject(s_list);
					oos.reset();

					System.out.println("저장되었습니다.\n");

				} catch (Exception ex) {
				} finally {
					try {
						oos.close();
						fout.close();
					} catch (IOException ioe) {
					}
				} // finally
				tableBook.setModel(new StudentTable(s_list));
				s_list.clear();
				return null;
			}
		};
		worker.execute();
	}

	public static void main(String args[]) {

		/* Create and display the form */

		new ViewStudent().setVisible(true);

	}

	private javax.swing.JButton loadButton;
	private javax.swing.JButton addButton;
	private javax.swing.JButton enterButton;
	private javax.swing.JButton modifyButton;
	private javax.swing.JButton deleteButton;
	private javax.swing.JButton saveButton;
	private javax.swing.JButton findButton;
	private javax.swing.JTextField login;
	private javax.swing.JScrollPane scrollpane;
	public static javax.swing.JTable tableBook;
	public static javax.swing.JTable tableteacher;
	public static javax.swing.JTable tableprogram;
	private javax.swing.JPanel buttonPanel;
	

}
