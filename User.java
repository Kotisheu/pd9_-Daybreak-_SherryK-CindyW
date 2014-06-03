import java.io.*;
import java.util.ArrayList;

public class User extends Game {
    
    private ArrayList<People> _avail; //available team members
    private ArrayList<People> _team; //the user's team in battle (up to 4);
    
    public User() {
	_avail = new ArrayList<People>();
	_team = new ArrayList<People>();
    }

    public ArrayList<People> addTeam( int i ) {
	if ( _team.size() < 4 ) {
	    //add person to team and remove from list of available
	    _team.add( _avail.get(i) );
	    _avail.remove( i );
	}
	return _team;
    }

    public void remTeam( int i ) {
	//return removed person; remove from team and add to list of available
	if ( _team.size() != 1 ) 
	    _avail.add( _team.remove(i) );
    }

    public ArrayList<People> getTeam() {
	return _team;
    }
    
    public ArrayList<People> getAvail() {
	return _avail;
    }

}


			 
