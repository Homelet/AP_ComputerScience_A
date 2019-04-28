package example.OOP;

public abstract class Student extends Human{
	
	public Student(String name, int age){
		super(name, age);
	}
	
	public abstract void play();
	
	public abstract void study();
	
	public void i_am_a_student(){
		System.out.println("I am a Student!");
	}
}
