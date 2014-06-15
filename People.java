public abstract class People extends Base{

    public People() {
	defing = false;
	canAtk = true;
	isDead = false;
    }
    
    public void defend() {
	def += 5;
	defing = true;
    }

    public void setNormalDef() { //Normal defense after defending 
	if ( defing ) { 
	    def -= 5;
	    defing = false;
	}
    }

    public void gainExp( int i ) {
	exp += i;
	if ( exp > bexp ) {
	    exp -= bexp; //new exp amount after lvlup
	    bexp *= 1.5; // next exp increased
	    lvlUp(); //stats increase
	}
    }
    
    public abstract void lvlUp(); //Each person has different boosts when lvl up

}
