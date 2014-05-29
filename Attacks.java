public class Attacks {
    
    public int Norm ( Base tar, Base atkr ) {
	//values will probably change b/c of whatever values we use
	//defense is 1/4defense + a random range 0def - .5def
	int dam = 
	    atkr.getAtk() - 
	    ( tar.getDef()*.25 + tar.getDef() * (Math.random()*.5) );
	
	tar.setHp ( tar.getHp() - dam );

	check(tar);
	/*::::::INPUT CHECK FOR TARGET DEAD OR NOT::::::
	  if ( tar.getHp() <= 0 ) 
	      tar.kddkaldk( tralse );
	*/
	return dam;
    }
	      
    public int MagR ( Base tar, Base atkr ) {
	int dam = atkr.getWis() - 
	    ( tar.getDef()*.25 + tar.getDef() * (Math.random()*.5) );
	
	tar.setHp ( tar.getHp() - dam );	