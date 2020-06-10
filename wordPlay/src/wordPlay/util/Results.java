package wordPlay.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;



public class Results implements FileDisplayInterface, StdoutDisplayInterface {
	
	FileWriter outputFile;
    File file;
	public Results(String fileName) {
        file = new File(fileName);
        try {
            outputFile = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	/**
	 * To add space after every word 
	 * 
	 */
	
	@Override
	public void printToConsole(String text) {
		// TODO Auto-generated method stub
		System.out.print(text + " ");
	}
	
	/**
	 * To go to the next line after a line is processed
	 * 
	 */
	@Override
	public void printNextLineToConsole() {
		// TODO Auto-generated method stub
		System.out.print("\n");
	}
	/**
	 * 
	 * 
	 */
	@Override
	public void writeToFile(String text) {
		// TODO Auto-generated method stub
		try {
            outputFile.write(text + " ");
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	@Override
	public void writeNextLineToFile() {
		// TODO Auto-generated method stub
		try {
            outputFile.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	

	public void fc() {
		try {
			outputFile.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	
}
