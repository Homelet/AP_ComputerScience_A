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
	
	public static void main(String[] args){
		String[] words = {
				"the", "red", "fox", "the", "red"
		};
		WordPairList wordPairList = new WordPairList(words);
		System.out.println(wordPairList.numMatches());
	}
}

class WordPairList{
	
	private ArrayList<WordPair> allPairs;
	
	public WordPairList(String[] words){
		allPairs = new ArrayList<>();
		for(int index = 0; index < words.length; index++){
			for(int innerIndex = index + 1; innerIndex < words.length; innerIndex++){
				allPairs.add(new WordPair(words[index], words[innerIndex]));
			}
		}
	}
	
	public int numMatches(){
		int accum = 0;
		for(WordPair w : allPairs){
			if(w.getFirst().equals(w.getSecond()))
				accum++;
		}
		return accum;
	}
}
