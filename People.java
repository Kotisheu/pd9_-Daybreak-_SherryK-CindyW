public abstract class People extends Base{

    public People() {
	defing = false;
	canAtk = true;
	isDead = false;
	ran = false;
    }
    
    public void defend() {
	def += 5;
	defing = true;
	canAtk = false;
    }

    public void setNormal() { //Normal defense after defending 
	if ( defing ) { 
	    def -= 5;
	    defing = false;
	    canAtk = true;
	}
	if ( ran ) {
	    ran = false;
	    canAtk = true;
	}
    }

    public void compNorm() { //set after battle?
	canAtk = true;
	ran = false;
	defing = false;
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
class Kangaroo extends People {
    public Kangaroo(){
	name= "Joey";
	person= "Mysterious Kangaroo";
	bhp=hp=50+(int)(Math.random()*lvl*10);
	bmp=mp=20+(int)(Math.random()*lvl*10);
	bstr=str=7+(int)(Math.random()*lvl*5);
	bwis=wis=5+(int)(Math.random()*lvl*5);
	bluk=luk=8+(int)(Math.random()*lvl*5);
	bspd=spd=5+(int)(Math.random()*lvl*5);
	bdef=def=8+(int)(Math.random()*lvl*5);
	lvl=3;
	exp=0;
	bexp= 50*lvl;
	bheight=height=117;//cm
	bweight=weight=78;//kg
	inventory= null;
	statuses= null;
	attks=null;
	wep= new Stick();
	arm= new Leather();
	mun=500;

	isDead=false;
    }
    public void lvlUp(){
    }
}
class Girl extends People {
    public Girl(){
	name="Mahou";
	person=" Drowning girl";
	hp= (int)(bhp*.2);
	bhp=20+(int)(Math.random()*lvl*10);
	bmp=mp=50+(int)(Math.random()*lvl*100);
	bstr=str=7+(int)(Math.random()*lvl*5);
	bwis=wis=5+(int)(Math.random()*lvl*5);
	bluk=luk=8+(int)(Math.random()*lvl*5);
	bspd=spd=5+(int)(Math.random()*lvl*5);
	bdef=def=8+(int)(Math.random()*lvl*5);
	lvl=6;
	exp=0;
	bexp= 50*lvl;
	bheight=height=135;//cm
	bweight=weight=38;//kg
	inventory= null;
	statuses= null;
	attks=null;
	wep= new Stick();
	arm= new Leather();
	mun=500;

	isDead=false;
    }
  public void lvlUp(){
    }
}
class Tree extends People {
    public Tree(){
	name="Drake";
	person="Tree man";
bhp=hp=50+(int)(Math.random()*lvl*100);
	bmp=mp=20+(int)(Math.random()*lvl*10);
	bstr=str=7+(int)(Math.random()*lvl*5);
	bwis=wis=5+(int)(Math.random()*lvl*5);
	bluk=luk=8+(int)(Math.random()*lvl*5);
	bspd=spd=5+(int)(Math.random()*lvl*5);
	bdef=def=8+(int)(Math.random()*lvl*5);
	lvl=9;
	exp=0;
	bexp= 50*lvl;
	bheight=height=300;//cm
	bweight=weight=75;//kg
	inventory= null;
	statuses= null;
	attks=null;
	wep= new Stick();
	arm= new Leather();
	mun=500;

	isDead=false;
    }
  public void lvlUp(){
    }
}
class Thief extends People {
    public Thief(){
	name="Robert";
	person= "Thief";
bhp=hp=50+(int)(Math.random()*lvl*10);
	bmp=mp=20+(int)(Math.random()*lvl*10);
	bstr=str=7+(int)(Math.random()*lvl*5);
	bwis=wis=5+(int)(Math.random()*lvl*5);
	bluk=luk=8+(int)(Math.random()*lvl*5);
	bspd=spd=5+(int)(Math.random()*lvl*15);
	bdef=def=8+(int)(Math.random()*lvl*5);
	lvl=12;
	exp=0;
	bexp= 50*lvl;
	bheight=height=175;//cm
	bweight=weight=59;//kg
	inventory= null;
	statuses= null;
	attks=null;
	wep= new Stick();
	arm= new Leather();
	mun=500;

	isDead=false;
    }
  public void lvlUp(){
    }
}
