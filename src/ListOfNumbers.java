/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class ListOfNumbers {
	private List<Integer> list;
	private static final int SIZE = 10;

	public ListOfNumbers () {
		list = new ArrayList<Integer>(SIZE);
		for (int i = 0; i < SIZE; i++)
			list.add(new Integer(i));
	}
	public void writeList() {
		PrintWriter out = null;

		try {
			System.out.println("Entering try statement");
			out = new PrintWriter(new FileWriter("OutFile.txt"));

			for (int i = 0; i < SIZE; i++)
				out.println("Value at: " + i + " = " + list.get(i));
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Caught IndexOutOfBoundsException: " +
					e.getMessage());
		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		} finally {
			if (out != null) {
				System.out.println("Closing PrintWriter");
				out.close();
			} else {
				System.out.println("PrintWriter not open");
			}
		}
	}
	
	/**
	 * Read a text file to obtain int values for list
	 * @param fileName the name of the file
	 */
	public void fileRead(String fileName) {

		try {
			//Read a file
			FileReader file = new FileReader(fileName);
			
			//Assign the file to a new BufferedReader
			BufferedReader reader = new BufferedReader(file);
			
			//Make each new line an element of the list
			for (int i = 0; i < SIZE; i++) {
				list.set(i, Integer.parseInt(reader.readLine()));
			}
		}
		//If the file was not found
		catch (FileNotFoundException e) {
			System.err.println("The file was not found!");
			System.exit(0);
		}
		//IOException 
		catch (IOException e) {
			System.err.println("An IOException has occurred.");
			System.exit(0);
		}
		//If the document wasn't formatted right
		catch (NumberFormatException e) {
			System.err.println("It looks like the text document wasn't formatted right. Is each number on a new line?");
			System.exit(0);
		}
	}
	
	/**
	 * Override the toString method to output all 10 values
	 */
	@Override
	public String toString() {
		String output = "";
		for (int i = 0; i < SIZE; i++) {
			output+=list.get(i)+"\n";
		}
		return output;
	}
	
}