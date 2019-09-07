public class HelloWorld {
	public static void main(String[] args) {

		Student student = new Student();

		student.age = 19;
		student.course = 2;
		student.name = "Ozerov German";
		student.isAlive = true;
System.out.println(student);

	}
}

class Student {
	String name;
	int age;
	int course;
	public boolean isAlive;
public String toString() {
return this.name + "," + this.age + "y.o";

}
}