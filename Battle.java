import java.io.*;
import java.util.*;

public class Battle {
    private User _user;
    private ArrayList<Monster> MONSTERS; //Dependent on location
    private ArrayList<Monster> _eInPlay; //Enemies in battle
    private boolean end = true;
    private AtkHeap acts;
    private int gainM;//money
    private int gainE;//exp
    //    private Queue turn;

    public Battle( User u ) {
	_user = u;
	end = false;
	//TESTING PURPOSES
	// MONSTERS = new ArrayList<Monster>();
	// MONSTERS.add( new Slime() );
	//
	_eInPlay = new ArrayList<Monster>();
	MONSTERS = _user.getLoc().getMon(); //get monster list from area
	init( MONSTERS ); 
	//	System.out.println( _eInPlay );
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
	    showHp(); //HP is shown
	    if ( isOver() ) {break;}; //Game over if player dies/monsters die
	    try {
		Thread.sleep(500);
	    } catch(InterruptedException ex) {
		Thread.currentThread().interrupt();
	    }
	    bPrompt(); //Ask player for their next move
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

    public void bPrompt() {
	ArrayList<People> team = _user.getTeam();
	System.out.println ( "\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n" );
	for ( int i = 0; team.size() > i; i++ ) {
	    while ( team.get(i).canAtk() ) {
		System.out.println("What will " + team.get(i).getName() + " do?\n");
		System.out.print( "\t1: Attack\n\t2: Defend\n\t3: Status\n\t4: Run\n" );
		int response = read( 1, 4 );
		System.out.println( response );
		if ( response == 1 ) { 
		    //==============Choose Attack==================
		    System.out.println( "Which attack?\n" );
		    String out = ""; //listattks
		    for ( int j = 0; j < team.get(i).getAttks().size(); j++ ) {
			out += "\t" + (j+1) + ": " + 
			    team.get(i).getAttks().get(j).getName();
		    }
		    out += "\n\t0: Exit\n";
		
		    System.out.print( out );
		    int atk = read( 0, team.get(i).getAttks().size() );
		    if ( atk == 0 ) { //Exit
			return; }
		    //===============Choose Target====================
		    System.out.println( "Who do you wish to slay?\n" );
		    String en = ""; //list enemies
		    for ( int k = 0; k < _eInPlay.size(); k++ ) {
			en += "\t" + (k+1) + ": " +
			    _eInPlay.get(k).getName() + "\n";
		    }
		    en += "\t0: Exit\n";
		    System.out.print(en);

		    int tar = read( 0, _eInPlay.size() );//listenemies
		    if ( tar == 0 ) { //Exit
			return;
		    }
		    //==============================================
		
		    if ( atk == 1 ) {
			acts.add( new A1( _eInPlay.get(tar-1), team.get(i) ) );
		    }
		    else if ( atk == 2 ) {
			acts.add( new A2( _eInPlay.get(tar-1), team.get(i) ) );
		    }
		    else if ( atk == 3 ) {
			acts.add( new A3( _eInPlay.get(tar-1), team.get(i) ) );
		    }
		    
		}
		if ( response == 2 ) {
		    team.get(i).defend();
		}
		if ( response == 3 ) {   	
		    People p = team.get(i);
		    ArrayList<Status> stats = p.getStatuses();
		    System.out.println("-----------" + p.getName() + "-----------");
		    System.out.println("HP: " + p.getHp()) ;
		    System.out.println("MP: " + p.getMp()) ;
		    System.out.println("LVL: " + p.getLvl()) ;
		    System.out.println("NEXT LVL: " + p.getNxt()) ;
		    if ( stats.size() == 0 ) 		
			System.out.println("Nothing seems to be wrong!");
		    else 
			System.out.println( stats );
		}
		else if( response == 4 ){//Chances of runnign increases w/ luk
		    int roll = (int)(Math.random()*500)+team.get(i).getLuk();
		    int beat = (int)(Math.random()*500);
		    team.get(i).canAtk(false);
		    if ( roll > beat) {
			end = true;
			System.out.println( "Escape was a success! " +
					    gainM + " $ dropped as you scampered away.");
			_user.addMun ( gainM*-1 );
			return;
		    }
		    else {
			System.out.println( "You can't escape!" );
		    }
		}
	    }
	}
    	System.out.println( "\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n" );
    }

    //Check if entered a valid int from lo to high inclusive
    public int read( int lo, int hi ) {
	BufferedReader input = 
	    new BufferedReader( new InputStreamReader(System.in) );
	int response = -1;
	   
	while ( response < lo || response > hi ) {
	       
	    //************Reads input.**************************
	    try {
		response = Integer.parseInt(input.readLine());
	    }
	    //Catch exceptions and ask for correct integer input
	    catch (IOException e) { 	    
	    }
	    catch (NumberFormatException e) { 	    
	    }
	    if ( response > hi || response < lo ) {
		System.out.print( "(Enter a valid integer value.) " );
		input = new BufferedReader( new InputStreamReader(System.in) );
	    }
	    //****************************************************
	}
	return response;
    }
    
    //Available attacks for person
    public void listAtks( People p ) {
    }	

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
	int enmyCt = 1 + (int)(Math.random()*4); //How many enemies in play?
	while ( enmyCt > 0 ) { //Add rand enmys to battle depending on MONSTERS
	    try {
	    Class mans = MONSTERS.get((int)(Math.random()
					    *MONSTERS.size())).getClass();
	    _eInPlay.add( (Monster)(mans.newInstance()) );
	    }
	    catch(InstantiationException e) {
	    }
	    catch(IllegalAccessException e) {
	    }
	    enmyCt--;
	}
	for ( Monster m : _eInPlay ) {
	    gainE += m.getExp();
	    gainM += m.getMun();
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
	    if ( !p.getDead() ) {
		p.setNormal();
		pla += "     " + p.getName() + ": " 
		    + p.getHp() + "\n"; 
	    }
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
	if ( end ) {
	    return end;
	}
	else if ( _eInPlay.size() == 0 ) {
	    setEnd( true );
	    winnings(); //gain things
	}
	else if ( teamDead() ) {
	    setEnd(true);
	    System.out.println( "\tGAME OVER" );
	    System.exit(1);
	}
	for ( People p : _user.getTeam() ) {
	    p.compNorm();
	}
	return end;
    }

    //Player gain exp/munny!
    public void winnings() {
	//Divide exp amongst characters
	int div = 0;
	ArrayList<People> team = _user.getTeam();
	for ( People p : team ) {
	    if ( !p.getDead() ) 
		div += 1;
	}
	gainE = gainE/div;

	for ( People p : team ) {
	    if ( !p.getDead() ) {
		System.out.println(p.getName() + " gained " + gainE + " exp!"); 
		p.gainExp( gainE );
	    }
	}
	System.out.println( "Earned " + gainM + " $!" );
	_user.addMun( gainM );
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

       
