import java.util.*;

public class Main extends People{

    protected Area pellet;
    protected Area stonehenge;
    protected Area kaetown;
    protected Area feywood;
    protected Area seaporte;
    protected Area aguael; 
    protected Area tree;
    protected Area sans; 
    protected Area metro;
    protected Area dessert;
    protected Area towere;

    public Main(){

    	super();
 
	person="You";
    
	name="bob";
	
	pellet = new Village();
	stonehenge = new Grassland();
	kaetown = new Townuno();
	feywood = new Forest();
	seaporte= new Towndos();
	aguael= new Water(); 
	tree= new Towntres();
	sans= new Mountain(); 
	metro= new Towncuatro();
	dessert = new Desert();
	towere= new Tower();

	pellet.setFrontBack( stonehenge, null );
	stonehenge.setFrontBack( kaetown, pellet );
	kaetown.setFrontBack( feywood, stonehenge );
	feywood.setFrontBack( seaporte, kaetown );
	seaporte.setFrontBack( aguael, feywood );
	aguael.setFrontBack( tree, seaporte );
	tree.setFrontBack( sans, aguael );
	sans.setFrontBack( metro, tree );
	metro.setFrontBack( dessert, sans );
	dessert.setFrontBack( towere, metro );
	towere.setFrontBack( null, dessert );

	setPlace( pellet );

	bhp=hp=50+(int)(Math.random()*lvl*10);
	bmp=mp=20+(int)(Math.random()*lvl*10);
	bstr=str=7+(int)(Math.random()*lvl*5);
	bwis=wis=5+(int)(Math.random()*lvl*5);
	bluk=luk=8+(int)(Math.random()*lvl*5);
	bspd=spd=5+(int)(Math.random()*lvl*5);
	bdef=def=8+(int)(Math.random()*lvl*5);
	lvl=1;
	exp=0;
	bexp= 100;
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
