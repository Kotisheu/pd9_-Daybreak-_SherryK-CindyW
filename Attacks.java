//**NOTE: attacks under this class should have a constructer specifying target and attacker (and other stuff listed in Attacks variables). Has method Declare to use norm attack (uses str) or mag attack(uses wis) when popped out of heap.

public abstract class Attacks {
    
    protected String _name;
    protected String _description;
    protected int _pri; //how long it takes to use attack
    protected int tmpPri;
    protected double _multiplier; //damage multiplier
    protected int _mag; //mp used
    protected Base _tar;
    protected Base _atkr;

    //People will have certain attacks in their attack ArrayList based on their class

    public String norm ( Base tar, Base atkr ) {
	//values will probably change b/c of whatever values we use
	//strength of atk depends on attack
	//defense is 1/2defense + random range 1-4;
	String det = atkr.getName() + " dealt ";
	int dam = 
	    (int) ( atkr.getStr()*_multiplier ) - 
	    ( (int) (tar.getDef()*.5) + (int)(Math.random()*2) );
	
	if ( dam < 0 ) 
	    dam = 0;	 

	atkr.setMp ( atkr.getMp() - _mag ); //lose mp

	tar.setHp ( tar.getHp() - dam ); //lose hp

	check(tar);

   	det += dam + " damage to " + tar.getName();

	return det;
    }
      
    public String mag ( Base tar, Base atkr ) {
	String det = atkr.getName() + " dealt ";

	int dam = 
	    (int) ( atkr.getWis()*_multiplier ) - 
	    ( (int)(tar.getRes()*.5) + (int)(Math.random()*2) );
	
	if ( dam > 0 ) 
	    dam = 0;	

	atkr.setMp ( tar.getMp() - _mag ); //use mp

	tar.setHp ( tar.getHp() - dam ); //lose hp
	
	check(tar);

   	det += dam + " damage to " + tar.getName();

	return det;
    }

    public void check( Base b ) { //Is it dead?
	if ( b.getHp() <= 0 )  
	    b.setDead(true);
    }

    public int getPri() {
	return tmpPri;
    }

    public void setPri( int i ) {
	tmpPri = i;
    }

    public Base getUser() {
	return _atkr;
    }
    
    public Base getTar() {
	return _tar;
    }

    public String getName() {
	return _name;
    }

    public String getDesc() {
	return _description;
    }

    public abstract void declare();

}

class A1 extends Attacks {

    public A1() {
	_name = "Smash";
	_description = "Weak attack.";
	_pri = tmpPri = 1;
	_multiplier = 1;
	_mag = 0;
    }
    
    public A1 ( Base tar, Base atkr ) {	
	this();
	_tar = tar;
	_atkr = atkr;
	_atkr.canAtk(false);
    }

    public void declare() {
	
	if( !_tar.getDead() && !_atkr.getDead() )//As long as no one is dead there
	    System.out.println( norm( _tar, _atkr ) ); //declare a normal attack
	_atkr.canAtk(true);
    }

}

class A2 extends Attacks {

    public A2() {
	_name = "Holy Smash";
	_description = "Does slightly more damage than smash. Uses 2MP.";
	_pri = tmpPri = 2;
	_multiplier = 1.5;
	_mag = 2;
    }
    
    public A2 ( Base tar, Base atkr ) {
	this();
	_tar = tar;
	_atkr = atkr;
	_atkr.canAtk(false);
	
    }

    public void declare() {
	
	if( !_tar.getDead() && !_atkr.getDead() )//As long as no one is dead there

	    System.out.println( norm( _tar, _atkr ) ); //declare a normal attack
	_atkr.canAtk(true);
    }

}

class A3 extends Attacks {
    
    public A3() {    
	_name = "Omni Smash";
	_description = "Triple attack power of smash. Uses 5MP. Wait time is 1 turn.";
	_pri = tmpPri = 2;
	_multiplier = 3;
	_mag = 5;
    }

    public A3 ( Base tar, Base atkr ) {	
	this();
	_tar = tar;
	_atkr = atkr;
	_atkr.canAtk(false);
    }

    public void declare() {
	
	if( !_tar.getDead() && !_atkr.getDead() )//As long as no one is dead there
	    System.out.println( norm( _tar, _atkr ) ); //declare a normal attack
	_atkr.canAtk(true);
    }

}

class M1 extends Attacks {

    public M1() {
	_name = "Cast";
	_description = "Basic magic attack. Uses 3MP.";
	_pri = tmpPri = 1;
	_multiplier = 1;
	_mag = 3;
    }

    public M1 ( Base tar, Base atkr ) {       
	this();
	_tar = tar;
	_atkr = atkr;
	_atkr.canAtk(false);
    }
    
    public void declare() {
	
	if( !_tar.getDead() && !_atkr.getDead() )//As long as no one is dead there
	    System.out.println( mag( _tar, _atkr ) ); //declare a magic attack
	_atkr.canAtk(true);
    }

}

class M2 extends Attacks {
    
    public M2() {
	_name = "Blast";
	_description = "Slightly more powerful than cast. Uses 5MP.";
	_pri = tmpPri = 1;
	_multiplier = 1.5;
	_mag = 5;
    }
    public M2 ( Base tar, Base atkr ) {
	this();
	_tar = tar;
	_atkr = atkr;
	_atkr.canAtk(false);
    }

    public void declare() {
	
	if( !_tar.getDead() && !_atkr.getDead() )//As long as no one is dead there
	    System.out.println( mag( _tar, _atkr ) ); //declare a magic attack
	_atkr.canAtk(true);
    }

}

class M3 extends Attacks {
    
    public M3() {
	_name = "Divine Strike";
	_description = "Does A LOT more damage than cast and blast. Uses 20MP. Wait time is 2 turns.";
	_pri = tmpPri = 3;
	_multiplier = 5;
	_mag = 20;
    }	

    public M3 ( Base tar, Base atkr ) {
	this();
	_tar = tar;
	_atkr = atkr;
	_atkr.canAtk(false);
    }

    public void declare() {
	
	if( !_tar.getDead() && !_atkr.getDead() )//As long as no one is dead there
	    System.out.println( mag( _tar, _atkr ) ); //declare a magic attack
	_atkr.canAtk(true);
    }

}
