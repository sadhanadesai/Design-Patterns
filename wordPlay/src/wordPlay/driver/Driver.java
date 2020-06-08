package wordPlay.driver;

import java.io.IOException;

import wordPlay.util.FileProcessor;

/**
 * @author John Doe
 *
 */
public class Driver {
	public static void main(String[] args) throws IOException {
		
		String w =  new String();

		/*
		 * As the build.xml specifies the arguments as input,output or metrics, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */
		if ((args.length != 3) || (args[0].equals("${input}")) || (args[1].equals("${output}")) || (args[2].equals("${metrics}"))) {
			System.err.println("Error: Incorrect number of arguments. Program accepts 3 arguments.");
			System.exit(0);
		}
		System.out.println("Hello World! Lets get started with the assignment");
		FileProcessor fp = new FileProcessor("/Users/sadhanadesai/csx42-summer-2020-assign1-sadhanadesai/wordPlay/src/wordPlay/util/input.txt");
		//System.out.println(fp.poll());
		while(fp.getallwords()!= null) {
        	System.out.println(fp.poll());
        }
	}
}
