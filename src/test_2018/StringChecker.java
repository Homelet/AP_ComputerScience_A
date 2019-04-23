package test_2018;

public interface StringChecker{
	
	boolean isValid(String str);
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
		if(str.length() > min && str.length() < max){
		}
		return false;
	}
}