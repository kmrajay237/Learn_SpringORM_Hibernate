package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

		/*
		 * Student student=new Student(111,"Hrithik Kumar","Patwatoli"); int r =
		 * studentDao.insert(student); System.out.println("Done : "+r);
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("*****************Welcome to Spring ORM Console Application*******************");
		boolean go = true;
		while (go) {
			System.out.println("PRESS 0 to Exit");
			System.out.println("PRESS 1 to Add new student");
			System.out.println("PRESS 2 to display all student");
			System.out.println("PRESS 3 to get detail of single student");
			System.out.println("PRESS 4 to delete student");
			System.out.println("PRESS 5 to Update student");

			try {
				int input = Integer.parseInt(br.readLine());
				/*
				 * if(input==0) { // Exit }else if(input==1) { // Add new Student }
				 */

				switch (input) {
				case 1:
//					add a new student - Taking input from end user
					System.out.println("Enter Student ID!");
					int sid = Integer.parseInt(br.readLine());

					System.out.println("Enter Student Name!");
					String sname = br.readLine();

					System.out.println("Enter Student City");
					String scity = br.readLine();

//					Creating student object & Setting values
					Student s = new Student();
					s.setId(sid);
					s.setName(sname);
					s.setCity(scity);

//					Saving  student object to database by calling insert of student dao
					int result = studentDao.insert(s);
					System.out.println(result + " student added!!");
					System.out.println("*********************************");
					System.out.println();
					break;

				case 2:
//					display all student
					System.out.println("*********************************");
					List<Student> allStudent = studentDao.getAllStudent();
					for (Student student : allStudent) {
						System.out.println("ID: " + student.getId());
						System.out.println("Name: " + student.getName());
						System.out.println("City: " + student.getCity());
						System.out.println("_______________________________________");
					}
					System.out.println("*********************************");
					break;

				case 3:
//					get single student
					
					System.out.println("Enter Student ID!");
					int uid = Integer.parseInt(br.readLine());
					Student student = studentDao.getStudent(uid);
					System.out.println("ID: " + student.getId());
					System.out.println("Name: " + student.getName());
					System.out.println("City: " + student.getCity());
					System.out.println("_______________________________________");
					
					break;

				case 4:
//					delete student
					
					System.out.println("Enter Student ID!");
					int id = Integer.parseInt(br.readLine());
					studentDao.deleteStudent(id);
					System.out.println("Student Deleted!!!");
					System.out.println("_______________________________________");
					
					break;

				case 5:
//					update student
					break;

				case 0:
//					exit
					go = false;
					break;

				}
			} catch (Exception e) {
				System.out.println("Invalid Input!! Try with Another one");
				System.out.println(e.getMessage());
			}
		}
		System.out.println("Thank You for Using this Application!! See You Soon");

	}

}