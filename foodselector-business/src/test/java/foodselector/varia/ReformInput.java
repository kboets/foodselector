package foodselector.varia;

import java.util.ArrayList;
import java.util.List;

public class ReformInput {

	public void reformInputMessage(List<String []> input) {
		
		System.out.println("******* after reformatting  ********");
		int maxwordsPerPhrase = this.calculateMaxWordsInPhrases(input);		
		List<String> words = new ArrayList<String>();
		for(int i=0; i<maxwordsPerPhrase;i++) {			
			for(int j=0;j<input.size();j++) {	
				String [] phrase = input.get(j);
				if(i<phrase.length){
					String word = input.get(j)[i];
					words.add(word);
				}								
			}
			this.printHorizontally(words);
			words.clear();			
		}	
		
	}
	
	private void printHorizontally(List<String> words) {
		int maxCharPerWord = this.calculateMaxCharactersInPhrases(words);		
		StringBuilder builder = new StringBuilder();
		for(int i=0;i<maxCharPerWord;i++) {			
			for(int j=0;j<words.size();j++) {	
				String word = words.get(j);
				if(i<word.length()){					
					Character ch = words.get(j).charAt(i);
					builder.append(ch);
					builder.append("\t");
				}else{
					builder.append("\t");	
				}	
			}
			builder.append("\n");
		}		
		System.out.println(builder.toString());
					
		
	}
	
	private int calculateMaxWordsInPhrases(List<String []> input) {
		int max = 0;
		for (String[] strings : input) {
			if(strings.length > max) {
				max = strings.length;
			}
		}
		return max;
	}
	private int calculateMaxCharactersInPhrases(List<String> words) {
		int max = 0;
		for (String string : words) {
			if(string.length()>max) {
				max=string.length();
			}
		}
		return max;
	}	
	
	public static void main(String[] args) {
		String [] phrase1 = {"This", "is", "a", "test"}; 
		String [] phrase2 = {"Do", "your", "best"};
		String [] phrase3 = {"Act", "now"};
		
		
		List<String []> input = new ArrayList<String[]>();
		input.add(phrase1);
		input.add(phrase2);
		input.add(phrase3);
		
		ReformInput reformInputClass = new ReformInput();
		reformInputClass.reformInputMessage(input);
	}

}
