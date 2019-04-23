package test_2018;

import java.util.ArrayList;

public class WordPair{
	
	private final String first, second;
	
	public WordPair(String first, String second){
		this.first = first;
		this.second = second;
	}
	
	public String getFirst(){
		return first;
	}
	
	public String getSecond(){
		return second;
	}
}

class WordPairList{
	
	private ArrayList<WordPair> allPairs;
	
	public WordPairList(String[] words){
	}
	
	public int numMatches(){
		return 0;
	}
}
