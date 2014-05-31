import java.io.*;
import java.util.ArrayList;

public class Battles extends User {
    
    private ArrayList<Base> MONSTERS; //Dependent on location
    private ArrayList<Base> _eInPlay; //Enemies in battle
    
    public Battle() {
	init( MONSTERS );
	showHp();
    }

    public void init( ArrayList<Base> mon ) {
	int enmyCt = 1 + Math.random()*4; //How many enemies in play?
	while ( enmyCt > 0 ) { //Add rand enmys to battle depending on MONSTERS
	    _eInPlay.add( Math.random()*MONSTERS.size() );
	    enmyCt--;
	}
    }

    //Show name and HP
    public void showHp() {
	String ene = "<><><>--ENEMY--<><><>"; //Enemies & HP 
	String pla = "<><><>--TEAM--<><><>"; //Team & HP

	for ( int i = 0; i < _eInPlay.size(); i++ ) {
	    ene += _eInPlay.get(i).getName() + ": " 
		+ _eInPlay.get(i).getHp + "\n";
	}
	ene += "---------------------"

	for ( int i = 0; i < _team.size(); i++ ) {
	    pla += getTeam().get(i).getName() + ": " 
		+ getTeam().get(i).getHp + "\n"; //getTeam from User
	}
	pla += "--------------------";

	System.out.println( ene );
	System.out.println( "\n" );
	System.out.println( pla );
    }    

    

}

       
