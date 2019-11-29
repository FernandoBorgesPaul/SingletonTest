
import java.util.LinkedList;

public class GetTheTiles implements Runnable {
	
	public void run() {
		
		//How you create a new instance of Singleton
		
		Singleton newInstance = Singleton.getInstance();
		
		//Get the unique ID for instance object
		
		System.out.println("1st Instance ID: " + System.identityHashCode(newInstance));
		
		//Get all the letters stored in the List
		
		System.out.println(newInstance.getLetterList());
		
		LinkedList<String> playerOneTiles = newInstance.getTitles(7);
		
		System.out.println("Player 1: " + playerOneTiles);
		
		System.out.println("Got Tiles");
		
	}
	

}
