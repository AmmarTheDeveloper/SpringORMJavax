package com.springorm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springorm.dao.StudentDao;
import com.springorm.entities.Student;

public class App {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void insert(StudentDao studentDao) throws IOException {

		System.out.println("************** ADD STUDENT **************");

		System.out.println("Enter user name: ");
		String sname = br.readLine();

		System.out.println("Enter age: ");
		int sage = Integer.parseInt(br.readLine());

		Student st = new Student(sname, sage);
		int insert = studentDao.insert(st);
		System.out.println("Student added successfully, got id: " + insert);
		System.out.println("**********************************************************************");

	}

	public static void getAll(StudentDao studentDao) {
		System.out.println("************** ALL Students **************");

		List<Student> students = studentDao.getStudents();

		for (Student student : students) {

			System.out.println("--------------");

			System.out.println("Student Id: " + student.getId());
			System.out.println("Student Name: " + student.getName());
			System.out.println("Student Age: " + student.getAge());
		}

		System.out.println("************************************************");
	}

	public static void get(StudentDao studentDao) throws NumberFormatException, IOException {

		System.out.println("************** Student Enquiry **************");

		System.out.println("Enter student id to find: ");
		int sid = Integer.parseInt(br.readLine());

		Student student = studentDao.getStudent(sid);

		if (student != null) {

			System.out.println("Student Id: " + student.getId());
			System.out.println("Student Name: " + student.getName());
			System.out.println("Student Age: " + student.getAge());

		} else {
			System.out.println("Student not found");
		}

		System.out.println("***************************************************");

	}

	public static void delete(StudentDao studentDao) throws NumberFormatException, IOException {

		System.out.println("Enter student id to delete: ");
		int sid = Integer.parseInt(br.readLine());

		Student student = studentDao.getStudent(sid);

		if (student != null) {

			studentDao.delete(student);

			System.out.println("Deleted student");

		} else {
			System.out.println("Student not found to delete");
		}

		System.out.println("***************************************************");
	}

	public static void update(StudentDao studentDao) throws IOException {
		System.out.println("************** UPDATE STUDENT **************");

		System.out.println("Enter studnet id: ");
		int sid = Integer.parseInt(br.readLine());

		Student st = studentDao.getStudent(sid);

		if (st != null) {

			System.out.println("Enter student name: ");
			String sname = br.readLine();

			System.out.println("Enter student age: ");
			int sage = Integer.parseInt(br.readLine());
			
			st.setName(sname);
			st.setAge(sage);

			studentDao.update(st);

			System.out.println("Student updated");

		} else {
			System.out.println("Student not found to update");
		}

		System.out.println("**********************************************************************");
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("com/springorm/cfg.xml");
		StudentDao studentDao = cpx.getBean("studentDao", StudentDao.class);

//    		Student student = new Student("Ammar Ansari",19);
//    		int insert = studentDao.insert(student);
//    		
//    		System.out.println(insert);

		try {

			while (true) {
				System.out.println("PRESS 1 for adding new student");
				System.out.println("PRESS 2 for display all students");
				System.out.println("PRESS 3 for get detail of single student");
				System.out.println("PRESS 4 for delete student");
				System.out.println("PRESS 5 for update student");
				System.out.println("PRESS 6 for exit");

				int choice = Integer.parseInt(br.readLine());

				switch (choice) {
				case 1:
					insert(studentDao);
					break;
				case 2:
					getAll(studentDao);
					break;
				case 3:
					get(studentDao);
					break;
				case 4:
					delete(studentDao);
					break;
				case 5:
					update(studentDao);
					break;
				case 6:
					break;
				default:
					System.err.println("Select a valid option!!!");
					System.out.println("************************************************************");
					break;
				}

				if (choice == 6) {
					break;
				}

			}

		} catch (Exception e) {
			System.out.println("Invalid input");
			System.out.println(e.getMessage());
		}

		System.out.println("Thank you for using my application");
		System.out.println("see you soon");

	}
}
