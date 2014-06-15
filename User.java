import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class User{
    
    private ArrayList<People> _all; //all team members.
    private ArrayList<People> _avail; //available team members
    private ArrayList<People> _team; //the user's team in battle (up to 4);
    private Area _loc;
    private People you = new Main();
    private int munny;
    
    public User() {
	_avail = new ArrayList<People>();
	_team = new ArrayList<People>();
	_all = new ArrayList<People>();
	munny = 500; 
   }
    public User(String name){
	this();
	you= new Main(name);
	_team.add(you);
	_all.add(you);
	//	System.out.println( you.getPlace() );
	_loc = you.getPlace();
    }

    public void moveFd() {
	you.setPlace(you.getPlace().moveFoward());
    }
    public void moveBk() {
	//	you.setPlace(you.getPlace().moveBackward());
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
	       System.out.print( "\t1: Talk\n\t2: Inn\n" +
				 "\t3: Shop\n\t4: Items\n" + 
				 "\t5: Equip\n\t6: Status\n" +
				 "\t7: Next Area\n\t8: Previous Area\n" );
	       int response = read( 1, 8 );
	       //==========================================
	       if ( response == 1 ) {
	       }
	       else if ( response == 5 ) {
		   eqPrompt();
	       }
	       else if ( response == 7 ) {
		   moveFd();
	       }
	       else if ( response == 8 ) {
		   moveBk();
	       }
	       //=========================================
	   }
	   else { 	       	      
	       System.out.print( "\t1: Take a step forward.\n" + 
				 "\t2: Take a step backward.\n" +
				 "\t3: Items\n\t4: Equip\n" +
				 "\t5: Status\n" );
	       int response = read( 1, 5 );
	       //==========================================
	       if ( response == 1 ) {
		   moveFd();
	       }
	       else if ( response == 2 ) {
		   moveBk();
	       }
	       //==========================================
	   }
	}
    }
    
    //Check if entered a valid int from lo to high inclusive
    public int read( int lo, int hi ) {
	BufferedReader input = 
	       new BufferedReader( new InputStreamReader(System.in) );
	   int response = 0;
	   
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

	read( 1, _all.size() );

	//Equips;
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

			 
