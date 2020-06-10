package wordPlay.metrics;


public class MetricsCalculator{
	public static float result = 0;
	
	public static float avg_words(int word_counter,int sentCount) {
		result = (float) word_counter/sentCount;
		return result;		
	}

	public static float word_length(int word_counter, int charCount) {
		result = (float) charCount/word_counter;
		return result;
    }
}