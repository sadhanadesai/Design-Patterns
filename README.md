# CSX42: Assignment 1
## Name: Sadhana Desai
## B00811705
-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in wordPlay/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile wordPlay/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile wordPlay/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile wordPlay/src/build.xml run -Dinput="input.txt" -Doutput="output.txt" -Dmetrics="metrics.txt"

Note: Arguments accept the absolute path of the files.

-----------------------------------------------------------------------
## Description:

The project has four packages which are driver,handler,metrics and util.
Driver.java -
It has all the basic operations to be carried out to call out the functions required to get the desired output.Driver.java is the base of the program.The file is read using FileProcessor object and poll() method.WordRotator object is used to call the rotateString function and rotate each word.I have used some ariables to keep track of word count, sentence count and character count to calculate the metrics.Results object is created to send the file to Results.java and use the methods to write to file and print to the console respectively.

WordRotator.java - 
It is from package handler is used to rotate the string received.It is accepting two arguments which are word and word index respectively to perform rotation and return required rotated string.I have used word length and substring logic to rotate and set the string.

MetricsCalculator.java - 
It is from package metrics to calculate the two basic required metrics from the input file which are average number of words per sentence and average word length.The code has basic two methods to calculate the metrics which are avg_words() and word_length() are  called in Driver.java to write to file.


Results.java,FileDisplayInterface.java and StdoutDisplayInterface.java are used to write to file,some methods are used to write the output as required to the file  and print to the console.

Code is functional and writes the output in output.txt and metrics in metrics.txt

Sample input and output files:

input.txt:

Welcome to design patterns summer 2020.
Start working on this assignment quickly.

output.txt:

eWelcom to igndes ernspatt ummers 2020.
tStar ngworki no this nmentassig uicklyq.

metrics.txt:

AVG_NUM_WORDS_PER_SENTENCE - 6.0
AVG_WORD_LENGTH - 5.67

-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: [6-10-2020]


