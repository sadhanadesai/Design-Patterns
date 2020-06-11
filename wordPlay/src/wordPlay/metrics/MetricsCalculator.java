package wordPlay.metrics;

public class MetricsCalculator{
	public static float result = 0;
	
	/**
	* Calculates and returns the average number of words per sentence.
	*
	* @return result is a static variable used to pass value to driver
	* file where function is called.
	*/
	
	public static float avg_words(float word_counter,float sentCount) {
		result = word_counter/sentCount;
		return result;		
	}
	
	/**
	* Calculates and returns the average word length.
	*
	* @return result is a static variable used to pass value to driver
	* file where function is called.
	*/

	public static float word_length(int word_counter, int charCount) {
		result = (float) charCount/word_counter;
		return result;
    }
}