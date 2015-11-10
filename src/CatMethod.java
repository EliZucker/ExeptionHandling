import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class CatMethod {
	public static void cat(File file)  {
	    RandomAccessFile input = null;
	    String line = null;

	    try {
	        input = new RandomAccessFile(file, "r");
	        while ((line = input.readLine()) != null) {
	            System.out.println(line);
	        }
	        return;
	    } 
	    
	    catch (FileNotFoundException e) {
	    	System.err.println("A FileNotFoundException has occurred.");
	    }
	    
	    catch (IOException e) {
	    	System.err.println("An IOException has occurred.");
	    }
	    
	    finally {
	        if (input != null) {
	        	try {
	            input.close();
	        	}
	        	catch (IOException e) {
	        		System.err.println("An IOException has occurred.");
	        	}
	        }
	    }
	}
}
