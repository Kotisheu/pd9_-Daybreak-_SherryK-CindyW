import java.io.*;
import java.util.ArrayList;

public class User extends Game {
    
    private ArrayList<Base> _avail; //available team members
    private ArrayList<Base> _team; //the user's team in battle (up to 4);
    
    public User() {
	_avail = new ArrayList<Base>();
	_team = new ArrayList<Base>();
    }

    public ArrayList<Base> addTeam( int i ) {
	if ( _team.length < 4 ) {
	    //add person to team and remove from list of available
	    _team.add( i );
	    _avail.remove( i );
	}
	return _team;
    }

    public Base remTeam( int i ) {
	//return removed person; remove from team and add to list of available
	if ( _team.length != 1 )
	    return _avail.add( _team.remove(i) );

	return null;
    }

    public ArrayList<Base> getTeam() {
	return _team;
    }
    
    public ArrayList<Base> getAvail() {
	return _avail;
    }

}


			 
