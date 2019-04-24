package test_2018;

public interface StringChecker{
	
	boolean isValid(String str);
	
	static void main(String[] args){
		StringChecker c = new CodeWordChecker("pass");
		System.out.println(c.isValid("MyPass"));
		System.out.println(c.isValid("Mypassport"));
		System.out.println(c.isValid("happy"));
		System.out.println(c.isValid("1,000,000,000,000,000"));
	}
}

class CodeWordChecker implements StringChecker{
	
	private final int max, min;
	private final String exclude;
	
	public CodeWordChecker(String exclude){
		this(6, 20, exclude);
	}
	
	public CodeWordChecker(int min, int max, String exclude){
		this.max = max;
		this.min = min;
		this.exclude = exclude;
	}
	
	@Override
	public boolean isValid(String str){
		return str.length() >= min && str.length() <= max && !str.contains(exclude);
	}
}

