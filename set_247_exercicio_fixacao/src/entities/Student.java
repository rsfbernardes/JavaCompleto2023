package entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Student {

	private String name;
	private int code;
	private final Set<Course> courses = new HashSet<>();
	
	public Student(int code) {
		this.code = code;
	}
	
	public Student(String name, int code) {
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

	@Override
	public int hashCode() {
		return Objects.hash(code);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return code == other.code;
	}
}
