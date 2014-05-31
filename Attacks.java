//**NOTE: attacks under this class should have a constructer specifying target and attacker (and other stuff listed in Attacks variables). Has method Declare to use norm attack (uses str) or mag attack(uses wis) when popped out of heap.

public class Attacks {
    
    private int _pri; //how long it takes to use attack
    private int _multiplier; //damage multiplier
    private int _mag; //mp used
    private Base _tar;
    private Base _atkr;

    //People will have certain attacks in their attack ArrayList based on their class

    public int Norm ( Base tar, Base atkr ) {
	//values will probably change b/c of whatever values we use
	//strength of atk depends on attack
	//defense is 1/2defense + random range 1-4;
	int dam = 
	    atkr.getAtk()*_multiplier - 
	    ( tar.getDef()*.5 + Math.random()*4 );
	
	atkr.setMp ( atkr.getMp() - _mag ); //lose mp

	tar.setHp ( tar.getHp() - dam ); //lose hp

	check(tar);
	/*::::::INPUT CHECK FOR TARGET DEAD OR NOT::::::
	  if ( tar.getHp() <= 0 ) 
	      tar.kddkaldk( tralse );
	*/
	return dam;
    }
      
    public int Mag ( Base tar, Base atkr ) {
	int dam = atkr.getWis()*_multiplier - 
	    ( tar.getDef()*.5 + Math.random()*4 );
	
	atkr.setMp ( tar.getMp() - _mag ); //use mp

	tar.setHp ( tar.getHp() - dam ); //lose hp
	
	check(tar);
	return dam;
    }

    public int getPri() {
	return _pri;
    }

    public Base getUser() {
	return _atkr;
    }
    
    public Base getTar() {
	return _tar;
    }

}
