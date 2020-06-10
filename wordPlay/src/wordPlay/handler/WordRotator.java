package wordPlay.handler;

//import java.util.HashMap;
//import java.util.Map;

public class  WordRotator{
	private String wd;
	private int word_index;
	/**
	 * @return String which gives wd()
	 */

	public WordRotator(String wd,int word_index) {
		super();
		this.wd = wd;
		this.word_index = word_index;
	}
	/**
	 * Input is a string and the output rotation
	 * @RETURN type is string 
	 * 
	 */

	public String reverseString() {
		
		int len = wd.length();
		word_index = word_index % wd.length();
		String reverse = "";
		if (!wd.contains(".")) {
		   reverse = wd.substring(len - word_index) + wd.substring(0,len - word_index);
		}
		else {
		   wd = wd.substring(0,len-1);
		   reverse = wd.substring(wd.length() - word_index) + wd.substring(0, wd.length() - word_index)+ ".";
		}
		return reverse;
      }
}

	
