import java.io.*;

public class Game {
    
    protected User player;

    public Game() {    
	if ( prompt() ) {
	    //Start a new Game with a new User
	    System.out.println("=========================================\nWelcome to a new world! You are a young adolescent in the nation of Coperia. Your adventure is about to commence.\n=========================================\n" );
	    newGame();
	    while( true ) 
		player.printMenu();
	}
	else {
	    System.out.println( " What a coward." ); 
	}
    }

    //Whoosh! prompt the player if they would like to start a new game.
    public boolean prompt() {
	System.out.print("Would you like to begin a new adventure? <y/n>\n==========================================\n You:");

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
	System.out.println("=========================================\n As you awake one morning, in your quaint village called Pallet Town, you hear a frightening noise outside your window. You rush out side just as your house comes crashing down. A giant lizardlike monster has just crushed your home. As you look around, you see the remains of your village burning down. You are still frozen with shock when you hear a faint cry for help. You look for the source of the cry and see someone reaching towards you. It's the town elder! You help him sit up, andhe says to you,");
	System.out.print("'Ahh thank you Young adventurer, you are our only hope. What is your name?'\n=========================================\n You:");

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
	System.out.println("=========================================\n'..."+ player.getName()+ "... What a noble name...' '"+player.getName()+ ", you must go out and seek the great Wizard Wisarde who resides in the Tower you can see in the distance. Reach him and have him teach you his ways. Then return and slay the monster that has destroyed our village. However, the way is dangerous. To reach Wisarde, you must go through many other monsters. These may be frightening at first, but if you work hard  you will soon overpower them. Are you up for the challenge?'\n=========================================\n You nod.\n=========================================\n ' Here, it's not much, but have this armor and this weapon. Thank you so much. Farewell and good luck.'\n=========================================\n You obtain Leather Armor and Stick. You equip them.\n=========================================\n"); 
    }


    public static void main( String[] args ) {
	Game g = new Game();
    }
}
