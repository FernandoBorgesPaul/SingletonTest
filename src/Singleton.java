import java.util.Arrays;
import java.util.LinkedList;
import java.util.Collections;

public class Singleton {
	
	private static Singleton firstInstance = null;
	
	String[] scrabbleLetters = {"a", "a", "a", "a", "a", "a", "a", "a", "a",
			"b", "b", "c", "c", "d", "d", "d", "d", "e", "e", "e", "e", "e", 
			"e", "e", "e", "e", "e", "e", "e", "f", "f", "g", "g", "g", "h", 
			"h", "i", "i", "i", "i", "i", "i", "i", "i", "i", "j", "k", "l", 
			"l", "l", "l", "m", "m", "n", "n", "n", "n", "n", "n", "o", "o", 
			"o", "o", "o", "o", "o", "o", "p", "p", "q", "r", "r", "r", "r", 
			"r", "r", "s", "s", "s", "s", "t", "t", "t", "t", "t", "t", "u", 
			"u", "u", "u", "v", "v", "w", "w", "x", "y", "y", "z",}; 
	
	private LinkedList<String> letterList = new LinkedList<String>(Arrays.asList(scrabbleLetters));
	
	//Used to slow down the 1st thread
	static boolean firstThread = true;
	
	//Created to keep users from instatiation
	//Only singleton will be able to instantiate this class
	
	private Singleton() {};  // We make it private we are not allowing other class to create a new instance of the class we want to create the singleton.
	
	//We could make getInstance() a sinchronized method to force 
	//every thread to wait its turn. That way only one thread
	//can access a method at a time. This can really slow eveything 
	//down though
	//public static synchronized Singleton getInstance();
	
	public static Singleton getInstance() {
		if(firstInstance == null) {
			
			//This is here to test what happens if threads try 
			//to create instances of this class.
			
			if(firstThread) {
				
				firstThread = false;
				
				try {
					Thread.currentThread();
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
					
				}
			}
			//Here we just use synchronized when the first object 
			//is created
			synchronized (Singleton.class) {
				
				if(firstInstance == null) {
					//If the instance isn't needed it isn't created 
					//This is known as lazy instatiation
					
					firstInstance = new Singleton();
					
					
					//Shuffle the letters of the list
					Collections.shuffle(firstInstance.letterList);
				}
				
			}
			
			
		}
		
		//Under either circumstance this return the instance.
		return firstInstance;
		
	}
	
	public LinkedList<String> getLetterList(){
		
		return firstInstance.letterList;
	}
	
	public LinkedList<String> getTitles(int howManyTitles) {
		
		
		//Titles to be returned to the user
		
		LinkedList<String> titlesToSend = new LinkedList<String>();
		
		//Cycle through the LinkedList while adding the starting 
		//String to the to be returned LInkedList while deleting
		//them from the List
		for (int i = 0; i < howManyTitles; i++) {
			
			titlesToSend.add(firstInstance.letterList.remove(0));
			
		}
		
		return titlesToSend;
	}

}
