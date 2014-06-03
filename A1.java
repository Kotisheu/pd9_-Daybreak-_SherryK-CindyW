public class A1 extends Attacks {
    
    public A1 ( Base tar, Base atkr ) {
	
	_name = "Smash";
	_pri = 1;
	_multiplier = 1;
	_mag = 0;
	_tar = tar;
	_atkr = atkr;

    }

    public void declare() {
	
	norm( _tar, _atkr ); //declare a normal attack

    }

}
