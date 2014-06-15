public class Main extends People{
    public Main(){
    	super();
    	
	person="You";
    
	name="bob";
	setPlace( new Village() );
	bhp=hp=50+(int)(Math.random()*lvl*10);
	bmp=mp=20+(int)(Math.random()*lvl*10);
	bstr=str=7+(int)(Math.random()*lvl*5);
	bwis=wis=5+(int)(Math.random()*lvl*5);
	bluck=luk=8+(int)(Math.random()*lvl*5);
	bspd=spd=5+(int)(Math.random()*lvl*5);
	bdef=def=8+(int)(Math.random()*lvl*5);
	lvl=1;
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

    public Main(String n){
        this();
	name=n;

    }
    //Heals and updates character stats
    public void lvlUp() {
	//Clear statuses
	statuses = new ArrayList<Status>();
	lvl += 1; //level increase
	if ( lvl == 5 ) {
	    Attacks atk = new A2();
	    System.out.println(getName()+" has learned "+atk.getName()+ "!"); 
	    attks.add(atk);
	}
	if ( lvl == 10 ) {
	    Attacks atk = new A3();
	    System.out.println(getName()+" has learned "+atk.getName()+ "!"); 
	    attks.add(atk);
	}
	hp = bhp += 3;
	mp = bmp += 2;
	str = bstr += 2;
	wis = bwis += 2;
	luk = bluk += 2;
	spd = bspd += 2;
	def = bdef += 2;
	res = bres += 2;
    }
}
