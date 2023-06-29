package application;

import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

import entities.Course;
import entities.Instructor;
import entities.Student;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Instructor alex = new Instructor("Alex", 99);
		
		Course A = new Course("A", alex);
		Course B = new Course("B", alex);
		Course C = new Course("C", alex);
		
		System.out.print("How many students for course A? ");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			Student student = new Student(sc.nextInt());
			A.addStudent(student);
		}
		
		System.out.print("How many students for course B? ");
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			Student student = new Student(sc.nextInt());
			B.addStudent(student);
		}
		
		System.out.print("How many students for course C? ");
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			Student student = new Student(sc.nextInt());
			C.addStudent(student);
		}

		Set<Student> totalStudents = new HashSet<>(A.getStudents());
		totalStudents.addAll(B.getStudents());
		totalStudents.addAll(C.getStudents());
		
		System.out.print("Total students: " + totalStudents.size());
		
		sc.close();
	}
}
