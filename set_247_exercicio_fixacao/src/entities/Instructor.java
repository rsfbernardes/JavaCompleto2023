package entities;

import java.util.HashSet;
import java.util.Set;

public class Instructor {

	private String name;
	private int code;
	private final Set<Course> courses = new HashSet<Course>();
	
	public Instructor(String name, int code) {
		this.name = name;
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public Set<Course> getCourses() {
		return courses;
	}
	
	public void addCourse(Course course) {
		courses.add(course);
	}
}
