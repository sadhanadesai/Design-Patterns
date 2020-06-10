package wordPlay.driver;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.text.DecimalFormat;

import wordPlay.handler.WordRotator;
import wordPlay.metrics.MetricsCalculator;
import wordPlay.util.FileProcessor;
import wordPlay.util.Results;



/**
 * @author John Doe
 *
 */
public class Driver {
	
	/**
	 * This is the main method in which input file is read line by line, rotate 
	 * and metrics are getting calculated and are displayed in metrics.txt file
	 * 
	 */
	
	public static void main(String[] args) throws IOException {
		

		/*
		 * As the build.xml specifies the arguments as input,output or metrics, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */
		if ((args.length != 3) || (args[0].equals("${input}")) || (args[1].equals("${output}")) || (args[2].equals("${metrics}"))) {
			System.err.println("Error: Incorrect number of arguments. Program accepts 3 arguments.");
			System.exit(0);
		}
		//System.out.println("Hello World! Lets get started with the assignment");
		
		/* Create FileProcessor  object to access FileProcessor java code
		 * Using the path to the input file
		 *  */ 
		
		FileProcessor fp = new FileProcessor("/Users/sadhanadesai/csx42-summer-2020-assign1-sadhanadesai/wordPlay/src/wordPlay/util/input.txt");
		
		DecimalFormat df = new DecimalFormat("#.##");
		/**
		 * Creating instance for new output file that displays results
		 * Passing args [1] as parameter for the output
		 * 
		 */
		//Map<String, Integer> wordFreq = new HashMap<String, Integer>();
		//DecimalFormat df2 = new DecimalFormat("#.##");
		
		//Results newFile = new Results(args[1]);
		//Results metricsFile = new Results(args[2]);
		
		String sent = new String(); 
		int wordCount = 1;
		int sentCount = 0;
		int charCount = 0;
		int word_counter = 0;
		
				
		/* Fetching input file contents 
		 * using FileProcessor object to call the method
		 * and to check if reached end of file
		 * print the words using poll method defined in FileProcessor
		 *  */	
		try {
			while((sent = fp.poll())!= null)  {
			//System.out.println(wordCount);
			word_counter++;
			/*for (int i = 0; i < sent.length(); i++) {
				charCount++;
			}*/
			charCount = charCount + sent.length();
			WordRotator wd = new WordRotator(sent,wordCount);
		    System.out.print(wd.reverseString());
		    if (sent.contains(".")) {
				wordCount = 1;
				sentCount++;
				System.out.println();
			}
		    else {
				wordCount++;
				System.out.print(" ");
			}
		    //System.out.println(sentCount);
			}   
		}
		catch(Exception e) {
			e.getMessage();
			System.out.println(e);
			
		}
		System.out.println("AVG_NUM_WORDS_PER_SENTENCE = " +df.format(MetricsCalculator.avg_words(word_counter,sentCount)));
		System.out.println("AVG_WORD_LENGTH = " +df.format(MetricsCalculator.word_length(word_counter,charCount)));
	}
}
