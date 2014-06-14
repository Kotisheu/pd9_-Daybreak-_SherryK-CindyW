//**NOTE: attacks under this class should have a constructer specifying target and attacker (and other stuff listed in Attacks variables). Has method Declare to use norm attack (uses str) or mag attack(uses wis) when popped out of heap.

public abstract class Attacks {
    
    protected String _name;
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
	    ( (int) (tar.getDef()*.5) + (int)(Math.random()*4) );
	
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
	    ( (int)(tar.getDef()*.5) + (int)(Math.random()*4) );
	
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

    public abstract void declare();

}

class A1 extends Attacks {
    
    public A1 ( Base tar, Base atkr ) {
	
	_name = "Smash";
	_pri = tmpPri = 1;
	_multiplier = 1;
	_mag = 0;
	_tar = tar;
	_atkr = atkr;

    }

    public void declare() {
	
	if( !_tar.getDead() && !_atkr.getDead() )//As long as no one is dead there
	    norm( _tar, _atkr ); //declare a normal attack

    }

}

class A2 extends Attacks {
    
    public A2 ( Base tar, Base atkr ) {
	
	_name = "Holy Smash";
	_pri = tmpPri = 2;
	_multiplier = 1.5;
	_mag = 2;
	_tar = tar;
	_atkr = atkr;

    }

    public void declare() {
	
	if( !_tar.getDead() && !_atkr.getDead() )//As long as no one is dead there
	    norm( _tar, _atkr ); //declare a normal attack

    }

}

class A3 extends Attacks {
    
    public A3 ( Base tar, Base atkr ) {
	
	_name = "Omni Smash";
	_pri = tmpPri = 3;
	_multiplier = 2;
	_mag = 5;
	_tar = tar;
	_atkr = atkr;

    }

    public void declare() {
	
	if( !_tar.getDead() && !_atkr.getDead() )//As long as no one is dead there
	    norm( _tar, _atkr ); //declare a normal attack

    }

}

class M1 extends Attacks {
    
    public M1 ( Base tar, Base atkr ) {
	
	_name = "Cast";
	_pri = tmpPri = 1;
	_multiplier = 1;
	_mag = 3;
	_tar = tar;
	_atkr = atkr;

    }

    public void declare() {
	
	if( !_tar.getDead() && !_atkr.getDead() )//As long as no one is dead there
	    mag( _tar, _atkr ); //declare a normal attack

    }

}

class M2 extends Attacks {
    
    public M2 ( Base tar, Base atkr ) {
	
	_name = "Blast";
	_pri = tmpPri = 2;
	_multiplier = 1.5;
	_mag = 5;
	_tar = tar;
	_atkr = atkr;

    }

    public void declare() {
	
	if( !_tar.getDead() && !_atkr.getDead() )//As long as no one is dead there
	    mag( _tar, _atkr ); //declare a normal attack

    }

}

class M3 extends Attacks {
    
    public M3 ( Base tar, Base atkr ) {
	
	_name = "Divine Strike";
	_pri = tmpPri = 3;
	_multiplier = 3;
	_mag = 10;
	_tar = tar;
	_atkr = atkr;

    }

    public void declare() {
	
	if( !_tar.getDead() && !_atkr.getDead() )//As long as no one is dead there
	    mag( _tar, _atkr ); //declare a normal attack

    }

}
