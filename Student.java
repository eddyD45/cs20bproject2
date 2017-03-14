//creating a class Student with a comparable interface
public class Student implements Comparable<Student> {
	private int id;
	private String name;
	private String school;
	
	Student(int id, String name, String school) {
		this.id = id;
		this.name = name;
		this.school = school;
	}
	Student(Student s){
		s.id = id;
		s.name = name;
		s.school = school;
	}
	//overriding equals method to check if ids are equal, meaning they are the same student
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof Student)) {
			return false;
		}
		Student s = (Student) o;
		return Integer.compare(id, s.id) == 0;
		
	}
	//overriding compareTo to work on Student ids
	@Override
	public int compareTo(Student s) {
		return Integer.compare(this.id, s.id);
	}
	//overriding toString method to return the values of the Student
	@Override
	public String toString() {
		return name + "," + id + "," + school;
	}
	
	
}