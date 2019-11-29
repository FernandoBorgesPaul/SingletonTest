

public class ScabbleTestThreads {

	public static void main(String[] args) {
		
		
		//Create a new Thread created using the Runnable Interface
		//excecute the code in run after 10 seconds
		
	Runnable getTiles = new GetTheTiles();
	Runnable getTilesAgain = new GetTheTiles();
	
	//Call for the core in the method run to execute
	
	new Thread(getTiles).start();
	new Thread(getTilesAgain).start();

	}

}
