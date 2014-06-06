import java.io.*;
import java.util.ArrayList;

public class User {
    
    private ArrayList<People> _avail; //available team members
    private ArrayList<People> _team; //the user's team in battle (up to 4);
    private Area _loc;
    private People you = new Main();
    
    public User() {
	_avail = new ArrayList<People>();
	_team = new ArrayList<People>();
	_loc = new Village();

    }
    public User(String name){
	this();
	you= new Main(name);
    }

    public void moveFd() {
	you.setPlace(you.getPlace().moveFoward());
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
	if ( _team.size() != 1 && !_team.get(i).equals(you) ) 
	    _avail.add( _team.remove(i) );
 
    }

    public ArrayList<People> getTeam() {
	return _team;
    }
    
    public ArrayList<People> getAvail() {
	return _avail;
    }

    public void setLoc( Area l ) {
	_loc = l;
    }

}


			 
