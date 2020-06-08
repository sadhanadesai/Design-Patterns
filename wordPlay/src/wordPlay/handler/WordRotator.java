package wordPlay.handler;


public class  WordRotator{
	private String wd;
	/**
	 * @return String which gives wd()
	 */

	public WordRotator(String wd) {
		super();
		this.wd = wd;
	}
	/**
	 * Input is a string and the output rotation
	 * @RETURN type is string 
	 * 
	 */

	public String rotateString() {
		int len = wd.length();
		String rotate = "";
		if (!wd.contains(".")) {
			for (int i = len - 1; i >= 0; i--) {
				rotate = rotate + wd.charAt(i);
			}
		} else {
			for (int i = len - 2; i >= 0; i--) {
				rotate = rotate + wd.charAt(i);
			}
			rotate = rotate + ".";
		}
		return rotate;
	}
}

	
}