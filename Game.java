import java.io.*;

public class Game {
    
    protected User player;

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
	System.out.println("As you awake one morning, in your quaint village called Pallet Town, you hear a frightening noise outside your window. You rush out side just as your house comes crashing down. As you look around, you see the remains of your village burning down. You are still frozen with shock when you hear a faint cry for help. You look for the source of the cry and see someone reaching towards you. It's the town elder! When you get close enough to hear him, he says:  ");
	System.out.print("'Ahh..Young adventurer, you are our only hope. What is your name?\n'");

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
		System.out.println( "Soren" );
		player = new User(name);
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
