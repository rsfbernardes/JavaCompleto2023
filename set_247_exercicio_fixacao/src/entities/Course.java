package entities;

import java.util.HashSet;
import java.util.Set;

public class Course {

	private String name;
	private Instructor instructor;
	private Set<Student> students = new HashSet<>();
	
	public Course(String name, Instructor instructor) {
		this.name = name;
		this.instructor = instructor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public Set<Student> getStudents() {
		return students;
	}
	
	public void addStudent(Student student) {
		students.add(student);
	}
}
