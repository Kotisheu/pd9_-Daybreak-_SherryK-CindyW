import java.io.*;
import java.util.ArrayList;

public class Battle {
    
    private User _user;
    private ArrayList<Base> MONSTERS; //Dependent on location
    private ArrayList<Base> _eInPlay; //Enemies in battle
    private boolean end = true;
    private Act actTurns;
    private Queue turn;

    public Battle( User u; Area l ) {
	_user = u;
	end = false;
	MONSTERS = l.getMons(); //get monster list from area
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
	    if ( !ene.getDead() )
		ene += _eInPlay.get(i).getName() + ": " 
		    + _eInPlay.get(i).getHp + "\n"; //list alive enemies

	    else 
		remE( _eInPlay.get(i) ); // remove dead enemies
	}
	ene += "---------------------";

	for ( int i = 0; i < _team.size(); i++ ) {
	    if ( !pla.getDead() )
		pla += u.getTeam().get(i).getName() + ": " 
		    + u.getTeam().get(i).getHp + "\n"; //getTeam from User
	}
	pla += "--------------------";

	System.out.println( ene );
	System.out.println( "\n" );
	System.out.println( pla );
    }    

    public void remE( Base e ) { // remove enemy if it is in list
	for ( int i = 0; i < _eInPlay.size(); i++ ) 
	    if ( _eInPlay.get(i).equals(e) ) 
		_eInPlay.remove(i);
    }

    public void setEnd( boolean a ) {
	end = a;
    }
    
    public boolean isOver() { // is battle over?
	if ( _eInPlay.size() == 0 ) 
	    setEnd( true );
	return end;
    }

}

       
