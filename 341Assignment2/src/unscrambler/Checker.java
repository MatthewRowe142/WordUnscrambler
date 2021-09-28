package unscrambler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Checker{
	
	public Checker () throws FileNotFoundException, IOException {
		
	
		try(BufferedReader br = new BufferedReader(new FileReader("/C:/Users/Computer Science/Desktop/words.txt"))) {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();
		}
	}
	public boolean check(String word) throws FileNotFoundException, IOException {
		try(BufferedReader br = new BufferedReader(new FileReader("/C:/Users/Computer Science/Desktop/words.txt"))) {
		StringBuilder sb = new StringBuilder();
		String line = br.readLine();
		
		while(line!=null) {
			if(word.equals(line)) {
				return true;
			}
			line = br.readLine();
		}
		return false;
		}
	}
}
