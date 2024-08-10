import java.io.FileNotFoundException;
import java.util.*;
import java.io.*;


public class FileProcessor {

	private String fileName;
	private int stringLength;
	private ArrayList<String> stringList;
	private Scanner input;
	
	public FileProcessor(String fileName, int stringLength) {
		this.fileName = getFileName();
		this.stringLength = getStringLength();
			
	}//end empty-argument constructor
	
	public int getArrayListSize() {
		
		return stringList.size();
	}//end getArrayListSize
	
	public String getFileName() {
		return fileName;
	}//end getFileName

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}//end setFileName

	public int getStringLength() {
		return stringLength;
	}//endgetStringLength

	public void setStringLength(int stringLength) {
		if(this.stringLength < 5 ) {
			stringLength = 5;
		}
		else {
			this.stringLength = stringLength;
		}
	}//endsetStringLength

	public void processFile() {

		System.out.println("Processing File");
		StringTooLongException problem = new StringTooLongException("String is too long!");
		File file=new File("GoodString.txt");
	
		try (Scanner input = new Scanner(file)) {
			
			 while (input.hasNextLine()) {
				 
                String word = input.nextLine() ;
                
                if (word.length() > stringLength) {
                	
                    throw problem;
                }
                else {
                	
                	System.out.println("File processed successfully.");	
                }
			 }
            
        } 	
		catch(FileNotFoundException e) {
		System.out.println(e.getMessage());
			
		}
		catch(StringTooLongException e) {
			System.out.println(e.getMessage());
		}
		
	}//end processFile()
	
	
}//end class
