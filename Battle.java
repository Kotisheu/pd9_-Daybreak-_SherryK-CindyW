import java.io.*;
import java.util.ArrayList;

public class Battle {
    
    private User _user;
    private ArrayList<Monster> MONSTERS; //Dependent on location
    private ArrayList<Monster> _eInPlay; //Enemies in battle
    private boolean end = true;
    private ALHeap acts;
    //    private Queue turn;

    public Battle( User u ) {
	_user = u;
	end = false;
	MONSTERS = u.getLoc().getMon(); //get monster list from area
	init( MONSTERS ); 
	showHp();
	acts = new ALHeap();
    }

    public void init( ArrayList<Monster> mon ) {
	int enmyCt = 1 + (int)(Math.random()*4); //How many enemies in play?
	while ( enmyCt > 0 ) { //Add rand enmys to battle depending on MONSTERS
	    _eInPlay.add( MONSTERS.get((int)(Math.random()*MONSTERS.size())) );
	    enmyCt--;
	}
    }

    //Show name and HP
    public void showHp() {
	String ene = "<><><>--ENEMY--<><><>"; //Enemies & HP 
	String pla = "<><><>--TEAM--<><><>"; //Team & HP

	//ADD 
	for ( int i = 0; i < _eInPlay.size(); i++ ) {
	    Monster e = e
	    if ( !e.getDead() )
		ene += _eInPlay.get(i).getName() + ": " 
		    + _eInPlay.get(i).getHp + "\n"; //list alive enemies

	    else 
		remE( _eInPlay.get(i) ); // remove dead enemies
	}
	ene += "---------------------";

	for ( int i = 0; i < _team.size(); i++ ) {
	    if ( !p.getDead() )
		pla += u.getTeam().get(i).getName() + ": " 
		    + u.getTeam().get(i).getHp + "\n"; //getTeam from User
	}
	pla += "--------------------";

	System.out.println( ene );
	System.out.println( "\n" );
	System.out.println( pla );
    }    

    public void remE( Monster e ) { // remove enemy if it is in list
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

    public static void main ( String args ) {
	User me = new User();
	Battle b = new Battle(me);
    }

}

       
