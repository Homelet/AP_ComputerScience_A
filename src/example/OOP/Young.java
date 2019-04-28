package example.OOP;

public class Young extends Student{
	
	public Young(){
		super("Young", 17);
	}
	
	@Override
	public void study(){
		System.out.println("I am Studying!");
	}
	
	@Override
	public void play(){
		System.out.println("I am Coding!");
	}
	
	@Override
	public void i_am_a_student(){
		super.i_am_a_student();
		System.out.println("My Name is " + this.getName());
	}
	
	@Override
	public String toString(){
		return "name:" + this.getName() + ", age:" + this.getAge();
	}
}
