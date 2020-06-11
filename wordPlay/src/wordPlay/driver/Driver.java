package wordPlay.driver;

import java.io.IOException;
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
		

		/**
		 As the build.xml specifies the arguments as input,output or metrics, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */
		
		if ((args.length != 3) || (args[0].equals("${input}")) || (args[1].equals("${output}")) || (args[2].equals("${metrics}"))) {
			System.err.println("Error: Incorrect number of arguments. Program accepts 3 arguments.");
			System.exit(0);
		}
		//System.out.println("Hello World! Lets get started with the assignment");
		
		/**
		 * Create FileProcessor object to access FileProcessor java code
		 * Using the path to the input file 
		 */
				
		FileProcessor fp = new FileProcessor(args[0]);
		DecimalFormat df = new DecimalFormat("#.##");
		
		/**
		 * Creating instance for new output file that displays results
		 * Passing args [1] as parameter for the output 
		 */
		
		
		Results newFile = new Results(args[1]);
		Results metricsFile = new Results(args[2]);
		
		/**
		 * Initializing the required variables and strings
		 */
		
		String sent = new String(); 
		int wordCount = 1;
		int sentCount = 0;
		int charCount = 0;
		int word_counter = 0;
		float metrics1 = 0;
		float metrics2 = 0;
		
		/**
		 * while terminating condition to read file and set all the
		 * values required to call the functions
		 * 
		 * Code wrapped in try catch to handle exceptions
		 * 
		 * WordRotator called and rotateString method to get
		 * the desired rotated output.
		 * 
		 * Period "." check to handle last word of sentence.
		 * Set 
		 * 
		 * charCount set before calling metrics to remove 
		 * periods in the sentences.
		 */
		
		
		try {
			while((sent = fp.poll())!= null)  {
			word_counter++;
			charCount = charCount + sent.length();
			WordRotator wd = new WordRotator(sent,wordCount);
		    String rot = wd.rotateString();
		    newFile.writeToFile(rot);
			newFile.printToConsole(rot);
		    if (rot.contains(".")) {
				wordCount = 1;
				sentCount++;
				newFile.writeNextLineToFile();
				newFile.printNextLineToConsole();
			}
		    else {
				wordCount++;
				System.out.print(" ");
			}		    
			} 			
			
		}
		catch(Exception e) {
			e.getMessage();
			System.out.println(e);
			
		}		
		
		/**
		 * 
		 * charCount set before calling metrics to remove 
		 * periods in the sentences.
		 * 
		 * metrics1 and metrics2 set for calculating two 
		 * required metrics and getting the values after the 
		 * methods from MetricsCalculator
		 * 
		 */
		
		charCount = charCount - sentCount;
		metrics1 = MetricsCalculator.avg_words(word_counter,sentCount);
		metrics2 = MetricsCalculator.word_length(word_counter,charCount);
		
		
		/**
		 * 
		 * metrics1 and metrics2 are sent to print to console
		 * and write to file metrics.txt
		 * 
		 */
				
		metricsFile.printToConsole("AVG_NUM_WORDS_PER_SENTENCE = " +df.format(metrics1) + "\nAVG_WORD_LENGTH = " +df.format(metrics2));
		metricsFile.writeToFile("AVG_NUM_WORDS_PER_SENTENCE = " +df.format(metrics1) + "\nAVG_WORD_LENGTH = " +df.format(metrics2));
		newFile.fc();
		metricsFile.fc();
	}
}
