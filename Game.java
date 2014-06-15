import java.io.*;


public class Game {
    
    private User player;

    public Game() {    
	if ( prompt() ) {
	    //Start a new Game with a new User
	    newGame();
	    while( true ) 
		player.printMenu();
	}
	else {
	    System.out.println( "stuff" ); 
	}
    }
    
    //Whoosh! prompt the player if they would like to start a new game.
    public boolean prompt() {
	System.out.print("Would you like to start a new game? <y/n>\n");

	BufferedReader input = 
	    new BufferedReader( new InputStreamReader(System.in) );
	String response = "";
	
	//Reads input. If response is not y or n, ask again.
	try {
	    response = input.readLine();
	    if ( !response.equals( "y" ) && !response.equals( "n" ) )
		return prompt();
	    else if ( response.equals( "y" ) ) { 
		return true; }
	    else 
		return false;
		//loadGame();
	} 
	catch (IOException ioe) {
	    System.out.println("Error reading input.");
	    System.exit(1);
	}
	return false;
    }
      
    public void newGame() {
	System.out.println("Random story text\n");
	System.out.print("Young adventurer, what is your name?\n");

	BufferedReader input = 
	    new BufferedReader( new InputStreamReader(System.in) );
	//Default name????????????
	String name = "Soren";

	try {
	    //input is not empty string/null.
	    String tmp = input.readLine();
	    if ( !tmp.equals( "" ) )
		player = new User(tmp);
	    else  {
		System.out.println( "<Default name>" );
		player = new User();
		//Guy player = new player( name );
	    }
	} 
	catch (IOException ioe) {
	    System.out.println("Error reading input.");
	    System.exit(1);
	}
    }


    public static void main( String[] args ) {
	Game g = new Game();
    }
}
