import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class User{
    
    private ArrayList<People> _all; //all team members.
    private ArrayList<People> _avail; //available team members
    private ArrayList<People> _team; //the user's team in battle (up to 4);
    private Trivia T= new Trivia();
    private Area _loc;
    private People you = new Main();
    private int munny;
    private int day=0;
    private int time=0;
    People ka,gi,tr,th;
    
    public User() {
	_avail = new ArrayList<People>();
	_team = new ArrayList<People>();
	_all = new ArrayList<People>();
	munny = 500; 
    }
    public User(String name){
	this();
	you= new Main(name);
	ka = new Kangaroo();
	gi = new Girl();
	tr = new Tree();
	th = new Thief();
	_team.add(you);
	_all.add(you);
	//	System.out.println( you.getPlace() );
	_loc = you.getPlace();
    }
    public String getName(){
	return you.getName();
    }
    public void moveFd() {
	you.setPlace(you.getPlace().moveFoward());
	_loc = you.getPlace();
	if ( !_loc.hasVisited() ) {
	    int e = _loc.event();
	    if ( e == 1 ) {
		System.out.println( "Kangaroo joined your party" );
		_team.add(ka);
		_all.add(ka);
	    }
	    else if ( e == 2 ) {
	    }
	    else if ( e == 3 ) {
		System.out.println( "Mysterious girl joined your party" );
		_team.add(gi);
		_all.add(gi);
	    }
	    else if ( e == 4 ) {
		System.out.println( "Odd tree joined your party" );
		_team.add(tr);
		_all.add(tr);
	    }
	    else if ( e == 5 ) {
		System.out.println( "Sneakty thief joined your party" );
		_team.add(th);
		_all.add(th);
	    }
	    else if ( e == 6 ) {
		if ( day > 30 )
		    System.out.println( "Oh no! He has been slain! Everyone in the tower is hysterically running around." );
		else { 
		    System.out.println( "Rejoice! He is alive! Now you can learnan amazing skill!" );
		    you.addAtks( new M4() );
		}
	    }	
	    _loc.visited();
	}
	int chance = (int)(Math.random()*2);
	if ( !_loc.isTown() && chance == 1 ) {
	    new Battle(this);
	}
    }
    public void moveBk() {
	you.setPlace(you.getPlace().moveBackward());
	_loc = you.getPlace();
	int chance = (int)(Math.random()*2);
	if ( !_loc.isTown() && chance == 1 ) {
	    new Battle(this);
	}
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
	else 
	    System.out.println( "Cannot remove the only person in the team." );
 
    }

    public ArrayList<People> getTeam() {
	return _team;
    }
    
    public ArrayList<People> getAvail() {
	return _avail;
    }

    public void addMun( int m ) {
	munny += m;
    }

    // public void setLoc( Area l ) {
    // 	you.setPlace( l );
    // }

    public Area getLoc() {
	return you.getPlace();
    }

    public void printMenu() {
	System.out.println ( "\n" );
	for ( int i = 0; _team.size() > i; i++ ) {
	    System.out.println("What do you want to do?\n");
	    if ( getLoc() instanceof Village
		 || getLoc() instanceof Townuno 
		 || getLoc() instanceof Towndos 
		 || getLoc() instanceof Towntres 
		 || getLoc() instanceof Towncuatro ) {
		System.out.print( "\t1: Talk\n\t2: Stay at an Inn (50 $/person)\n" +
				  "\t3: Shop\n\t4: Items\n" + 
				  "\t5: Status\n" + "\t6: Edit team\n" +
				  "\t7: Next Area\n\t8: Previous Area\n" );
		int response = read( 1, 8 );
		//==========================================
		if ( response == 1 ) {
		    String ss;
		    if(time<3){
			ss = T.getTrivia(); //+ "\n\t1: Return to town\n";
			time++;
		    }
		    else{
			ss= "It's too late, nobody wants to talk.";
		    }
		    System.out.print(ss);
		}
		else if ( response == 2 ) {
		    int num=0;
		    ArrayList<Status> s = new ArrayList<Status>();
		    for (People v:_all){
			num++;
		    }
		    if ((you.getMun()-(num *50)) >= 0){
			you.setMun(you.getMun()-(num*50));
		   
			for (People w:_all){
			    num++;
			    w.setHp(w.getbHp());
			    w.setMp(w.getbMp());
			    for (Status x:w.getStatuses()){//removes debuffs
				if(x.isBuff()){
				    s.add(x);
				}
			    }
			    w.setStatuses(s);
			    day++;
			    time=0;
			} System.out.println( "You and your friends spend the night in an Inn. All hp is recovered and all debuffs are removed. A fee of 50$ per person has been taken from your account.");
		    }
		    else{
			System.out.println(" You do not have enought money. The Inn costs 50 $ per person.");
		    }
		}
		else if ( response == 3 ) {
		    System.out.println( "Sorry, the shop is currently broken.");

		}

		else if ( response == 4 ) {
		    System.out.println( "You have no items to use!" );
		    //eqPrompt();
		}
		else if ( response == 5 ) {
		    ckStat();
		}
		else if ( response == 6 ) {
		    changePt();
		}
		else if ( response == 7 ) {
		    moveFd();
		}
		else if ( response == 8 ) {
		    moveBk();
		}
		//=========================================
	    }
	    else { //nontown	
		//testforbattle/monster here first       	      
		System.out.print( "\t1: Take a step forward.\n" + 
				  "\t2: Take a step backward.\n" +
				  "\t3: Items\n" +
				  "\t4: Status\n" );
		int response = read( 1, 4 );
		//==========================================
		if ( response == 1 ) {
		    moveFd();
		}
		else if ( response == 2 ) {
		    moveBk();
		}
		else if ( response == 3 ) {
		    eqPrompt();
		}
		else if ( response == 4 ) {
		    ckStat();
		}
	     
		//==========================================
	    }
	}
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

    public void eqPrompt() {
	System.out.println( "Manage equipment of who?\n" );
	for ( int i = 0; i < _all.size(); i++ ) {
	    System.out.println( "\t" + (i+1) + ": " + _all.get(i).getName() );
	}
	System.out.println( "\t0: Exit\n" );
	int rep=read( 0, _all.size() );
	
	//if Exit is chosen
	if ( rep == 0 )
	    return;

	ArrayList<Item> i =_all.get(rep-1).getInv();
	int num=0;
	for(Item a: i){
	    num++;
	    System.out.println( "\t" + num +a.getName()+a.getAmount());
	}//use??

    }

    public void changePt() {
	if ( _avail.size() == 0 || _team.size() == 4 ) {
	    remPrompt();
	}
	else if ( _team.size() == 1 ) {
	    addPrompt();
	}
	else {
	    System.out.println("\t1: Add\n\t2: Remove\n\t0: Exit");
	    int res = read(0,2);
	    if ( res == 0 ) return;
	    else if ( res == 1 ) 
		addPrompt();
	    else 
		remPrompt();
	}
    }
    public void remPrompt() { 
	System.out.println( "Remove?" );
	String rem = "";
	for ( int i = 0; i < _team.size(); i++ ) {
	    rem += "\t" + (i+1) + ": " + _team.get(i).getName() + "\n";
	}
	rem += "\t0: Exit\n";
	System.out.print( rem );
	int ind = read( 0, _team.size() );
	if ( ind == 0 ) return;
	remTeam( ind );
    }
    public void addPrompt() { 
	System.out.println( "Add?" );
	String add = "";
	for ( int i = 0; i < _avail.size(); i++ ) {
	    add += "\t" + (i+1) + ": " + _avail.get(i).getName() + "\n";
	}
	add += "\t0: Exit\n";
	System.out.print( add );
	int ind = read( 0, _avail.size() );
	if ( ind == 0 ) return;
	addTeam( ind );
    }
    
    
    public void ckStat(){
	
	System.out.println( "\n***************************\n$: " + munny );

	for ( People p : _all ) {
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
	// System.out.println( "Check Status of who?\n" );
	// for ( int i = 0; i < _all.size(); i++ ) {
	//     System.out.println( "\t" + (i+1) + ": " + _all.get(i).getName() );
	// }

	// int rep=read( 1, _all.size() );
       
	// ArrayList<Status> i =_all.get(rep-1).getStatuses();
	// int num=0;
	// for(Status a: i){
	//     num++;
	//     System.out.println( "\t" + num +a.getName());

	// }
	
    }
	//     public void printMenu() {
	// 	JFrame screen = new JFrame();
	// 	screen.setTitle("Actions"); //screen props
	// 	screen.setVisible(true);
	// 	screen.setSize( 100, 400 );
	// 	screen.setLayout( new BoxLayout( screen.getContentPane(), BoxLayout.Y_AXIS ) );
	// 	screen.getContentPane().setBackground(Color.black);
	// 	screen.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

	// 	JMenuBar moveMenu; //Menu bar to select move location
	// 	JMenu move;
	// 	JMenuItem inn, shop, go, back, fd, bk;
	// 	JButton talk, items, equip, stats; //buttons to do things

	// moveMenu = new JMenuBar(); 
	// 	move = new JMenu( "Move" );
	// 	inn = new JMenuItem( "Inn" );
	// 	shop = new JMenuItem( "Shop" );
	// 	go = new JMenuItem( "Go forth!" );
	// 	back = new JMenuItem( "Perhaps I forgot something..." );
	// 	fd = new JMenuItem( "Take a step forward" );
	// 	bk = new JMenuItem( "Take a step backward" );

	// 	talk = new JButton( "Talk" );
	// 	items = new JButton( "Items" );
	// 	equip = new JButton( "Equip" );
	// 	stats = new JButton( "Status" );

	// 	//Player options if in towns
	// if ( getLoc() instanceof Village
	// 	     || getLoc() instanceof Townuno 
	// 	     || getLoc() instanceof Towndos 
	// 	     || getLoc() instanceof Towntres 
	// 	     || getLoc() instanceof Towncuatro ) {
	//    screen.add( talk );
	// 	    move.add( inn );
	// 	    move.add( shop );
	//      	    move.add( go );
	// 	    move.add( back );
	//  move );
	// 	    move.setPreferredSize( new Dimension( 90, 20 ) );
	// 	    screen.add( moveMenu );
	// 	    screen.add( items );
	// 	    screen.add( stats );	
	// 	}
	
	// 	//player options out of towns
	// 	else {
	// 	    move.add( move );
	//      	    move.add( fd );
	// 	    move.add( bk );
	// 	    moveMenu.add( move );
	// 	    move.setPreferredSize( new Dimension( 90, 20 ) );
	// 	    screen.add( moveMenu );
	// 	    screen.add( items );
	// 	    screen.add( stats );	
	// 	}
	// 	screen.pack();
	//     }
}

			 
