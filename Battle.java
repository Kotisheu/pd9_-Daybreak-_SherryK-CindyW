
import java.io.*;
import java.util.*;

public class Battle {
    private User _user;
    private ArrayList<Monster> MONSTERS; //Dependent on location
    private ArrayList<Monster> _eInPlay; //Enemies in battle
    private boolean end = true;
    private AtkHeap acts;
    //    private Queue turn;

    public Battle( User u ) {
	_user = u;
	end = false;
	//TESTING PURPOSES
	MONSTERS = new ArrayList<Monster>();
	MONSTERS.add( new Slime() );
	//
	    //u.getLoc().getMon(); //get monster list from area
	init( MONSTERS ); 
	acts = new AtkHeap();
	go();
    }

    //Battle commence!
    public void go() {
	while ( !isOver() ) {
	    attack(); //Attacks happen first
	    try { //wait
		Thread.sleep(500);
	    } catch(InterruptedException ex) {
		Thread.currentThread().interrupt();
	    }
	    isOver(); //Game over if player dies/monsters die
	    showHp(); //HP is shown
	    try {
		Thread.sleep(500);
	    } catch(InterruptedException ex) {
		Thread.currentThread().interrupt();
	    }
	    prompt(); //Ask player for their next move
	    try {
		Thread.sleep(500);
	    } catch(InterruptedException ex) {
		Thread.currentThread().interrupt();
	    }
	    enemyGo(); //Enemies attack
	}
    }

    public void enemyGo() {
	for ( int i = 0; _eInPlay.size() > i; i++ ) {
	    // new A1( target,attacker )
	    addAtk( new A1( _user.getTeam().
			     get( (int) (Math.random()*
					 _user.getTeam().size())),
			     _eInPlay.get(i) ) );
	}
    }

    public void prompt() {
	ArrayList<People> team = _user.getTeam();
	System.out.println ( "\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n" );
	for ( int i = 0; team.size() > i; i++ ) {
	    System.out.println("What will " + team.get(i).getName() + " do?\n");
	    System.out.println( "\t1: Attack\n\t2: Defend\n\t3: Run\n\t4: Status" );
	    
	    BufferedReader input = 
		new BufferedReader( new InputStreamReader(System.in) );
	    int response = 0;
	    
	    while ( response != 1 && response != 2 && response != 3 
		    && response != 4 ) {

		//************Reads input.**************************
		try {
		    response = Integer.parseInt(input.readLine());
		}
		//Catch exceptions and ask for correct integer input
		catch (IOException e) { 	    
		}
		catch (NumberFormatException e) { 	    
		}
		if ( response > 4 || response < 1 ) {
		    System.out.print( "(Enter 1, 2, 3, or 4.) " );
		    input = new BufferedReader( new InputStreamReader(System.in) );
		}
		//****************************************************

		//ADD STUFF
		if ( response == 1 ) {  }
		if ( response == 2 ) {
		    team.get(i).defend();
		}
		if ( response == 3 ) {
		    
		else {}
	    }
	}
	System.out.println( "\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n" );
    }
    
    //Available attacks for person
    public void listAtks( People p ) {
	

    //Add attack to atkHeap
    public void addAtk( Attacks a ) {
	acts.add( a );
    }
    
    //Maintains the atkHeap
    public void attack() {
	while ( !acts.isEmpty() && acts.peekMin().getPri() == 1 ) {
	    acts.removeMin().declare();//Attack if attack is next in line  	
	}
	acts.lower();//Lower priority for attacks in play	
    }

    public void init( ArrayList<Monster> mon ) {
	_eInPlay = new ArrayList<Monster>();
	int enmyCt = 1 + (int)(Math.random()*4); //How many enemies in play?
	while ( enmyCt > 0 ) { //Add rand enmys to battle depending on MONSTERS
	    _eInPlay.add( MONSTERS.get((int)(Math.random()*MONSTERS.size())) );
	    enmyCt--;
	}
    }

    //Show name and HP
    public void showHp() {
	String ene = "<><><>--ENEMY--<><><>\n"; //Enemies & HP 
	String pla = "<><><>--TEAM--<><><>\n"; //Team & HP

	//ADD 
	for ( int i = 0; i < _eInPlay.size(); i++ ) {
	    Monster e = _eInPlay.get(i);
	    if ( !e.getDead() )
		ene += "     " + e.getName() + ": " 
		    + e.getHp() + "\n"; //list alive enemies

	    else 
		remE( e ); // remove dead enemies
	}
	ene += "---------------------";

	for ( int i = 0; i < _user.getTeam().size(); i++ ) {
	    People p = _user.getTeam().get(i); //getTeam from User
	    if ( !p.getDead() )
		pla += "     " + p.getName() + ": " 
		    + p.getHp() + "\n"; 
	}
	pla += "--------------------\n";

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
	if ( _eInPlay.size() == 0 ) {
	    setEnd( true );
	    winnings(); //gain things
	}
	else if ( teamDead() ) {
	    setEnd(true);
	    System.out.println( "\tGAME OVER" );
	    System.exit(1);
	}
	return end;
    }

    //Get exp drop from monster and divide it to each alive person on team.
    public int expGain() {
	int gain = 0;
	for ( Monster m : _eInPlay ) 
	    gain += m.getExp();

	int div = 0;
	ArrayList<People> team = _user.getTeam();
	for ( People p : team ) {
	    if ( !p.getDead ) 
		div += 1;
	}
	return gain/div;
    }

    //Get money drops from monsters
    public int munGain() {
	int gain = 0;
	for ( Monster m : _eInPlay ) 
	    gain += m.getMun();
	return gain;
    }    

    //Player gain exp/munny!
    public void winnings() {
	ArrayList<People> team = _user.getTeam();
	for ( People p : team ) {
	    if ( !p.getDead ) 
		p.gainExp( expGain() );
	}
	_user.addMun( munGain() );
    }
	    
    //Is team dead?
    public boolean teamDead() {
	for ( People p : _user.getTeam() ) {
	    if ( p.getHp() <= 0 ) 
		return true;
	}
	return false;
    }

    public static void main ( String[] args ) {
	User me = new User();
	Battle b = new Battle(me);
    }

}

       
