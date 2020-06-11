package wordPlay.handler;


public class  WordRotator{
	private String wd;
	private int word_index;
	
	/**
	 * WordRotator constructor is used to get word and word index.
	 */

	public WordRotator(String wd,int word_index) {
		super();
		this.wd = wd;
		this.word_index = word_index;
	}
	
	
	/**
	* rotates the string
	*
	* modulus used to work for words of less length 
	* than word index
	* 
	* @return reverse is used to pass rotated string
	*  where function is called.
	*/

	public String rotateString() {
		
		int len = wd.length();
		word_index = word_index % wd.length();
		String rotate = "";
		if (!wd.contains(".")) {
		   rotate = wd.substring(len - word_index) + wd.substring(0,len - word_index);
		}
		else {
		   wd = wd.substring(0,len-1);
		   rotate = wd.substring(wd.length() - word_index) + wd.substring(0, wd.length() - word_index)+ ".";
		}
		return rotate;
      }
}

	
