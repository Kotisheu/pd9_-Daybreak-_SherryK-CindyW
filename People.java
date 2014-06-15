public abstract class People extends Base{

    public void defend() {
	setDef( def + 5 );
    }
    
    public void gainExp( int i ) {
	exp += i;
	if ( exp > nxt ) {
	    exp -= nxt; //new exp amount after lvlup
	    nxt *= 1.5; // next exp increased
	    lvl += 1; //level increase
	    lvlUp(); //stats increase
	}
    }
    
    public abstract void lvlUp(); //Each person has different boosts when lvl up

}
