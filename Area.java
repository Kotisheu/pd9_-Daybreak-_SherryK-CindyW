import java.util.ArrayList;

public abstract class Area{
    protected ArrayList<Item> store;//what items are availiable in this place
    protected ArrayList<Monster> munstars;// what monsters are here
    protected ArrayList<Trivia> citizens;// trivia given by talking to random people in towns :)
    protected boolean first; // is this first time here?- trigger event
    protected String name;
    protected boolean town;//true if town, false if outside area
    protected int step;//step this is 0 at <town>, starting step for area
    protected int stepstowards;// steps to town in front
    protected int stepsbackwards;//steps to town behind
    protected Area nextplace;
    protected Area backplace;

    protected static Area pellet = new Village();
    protected static Area stonehenge = new Grassland();
    protected static Area kaetown = new Townuno();
    protected static Area feywood = new Forest();
    protected static Area seaporte= new Towndos();
    protected static Area aguael= new Water(); 
    protected static Area tree= new Towntres();
    protected static Area sans= new Mountain(); 
    protected static Area metro= new Towncuatro();
    protected static Area dessert = new Desert();
    protected static Area towere= new Tower();

    public ArrayList<Monster> getMon() {
	return munstars;
    }
    public boolean isTown() {
	return town;
    }
    public boolean hasVisited() {
	return first;
    }
    public void visited() {
	first = true;
    }

    public Area moveFoward(){
	if (town){
	    if ( nextplace != null )
		return nextplace;
	    else {
		System.out.println( "The phantom of an old man appears and mutters something. It's hard to hear, but you can make out the words 'you shall not pass'" );
		return this;
	    }
	}
	else if ( step >= 10 ) {
	    return nextplace;
	}
	else{ 
	    step+=1;
	    return Check();
	}
    }

    public Area moveBackward(){
	if (town){
	    if ( backplace != null )
		return backplace;
	    else {
		System.out.println( "A mysterious invisible wall blocks your path." );
		return this;
	    }
	}
	else if ( step <= 1 ) {
	    return backplace;
	}
	else{ 
	    step-=1;
	    return Check();
	}
    }
    
    
    public void setFrontBack( Area f, Area b ) {
	nextplace = f;
	backplace = b;
    }
    
    public abstract Area Check();
    public abstract int event();
}


class Village extends Area{
    public Village() {
	first = false;//if false, trigger event, change to true
	town = true;
	name= "Pellet Town";
	munstars = new ArrayList<Monster>();
	store = new ArrayList<Item>();
	citizens = new ArrayList<Trivia>();
	step = 0;
	stepstowards = 10;
	stepsbackwards = 0;
	nextplace= stonehenge;
	backplace=null;
    }
    public int event() { 
	return -1;
    }
    public Area Check(){//town no need to do anything
	return this;
    }

}
class Grassland extends Area{
    public Grassland(){
	first = false;
	town= false;
	name= "Stonehenge";
	munstars = new ArrayList<Monster>();
	munstars.add( new Slime() );
	munstars.add( new Kids() );
	munstars.add( new Snail() );	
	store = null;//noneedforstore
	citizens = null; // nopeople
	step = 1;
	stepstowards = 10;
	stepsbackwards = 0;
	nextplace=kaetown;
	System.out.println( nextplace );
	backplace=pellet;
    }
    public int event() {
	System.out.println( (new Story()).A1 );
	return -1;
    }
    public Area Check(){
	if (step == stepstowards){
	}
	if(step==stepsbackwards){
	}
	return this;
    }
}
class Townuno extends Area{
    public Townuno(){
	first = false;//if false, trigger event, change to true
	town = true;
	name= "Kaetown";
	munstars = new ArrayList<Monster>();
	store = new ArrayList<Item>();
	citizens = new ArrayList<Trivia>();
	step = 0;
	stepstowards = 10;
	stepsbackwards = 0;
	nextplace=feywood;
	backplace=stonehenge;

    }
    public int event() {
	System.out.println( (new Story()).t1 );
	System.out.println( (new Story()).E3 );
	return 1;
    }

    public Area Check(){
	return this;
    }
}
class Forest extends Area{
    public Forest(){
	town = false;
	first = false;
	town= false;
	name= "Feywood";
	munstars = new ArrayList<Monster>();
	munstars.add( new Goblin() );
	munstars.add( new Monkey() );
	munstars.add( new Camper() );
	store = null;//noneedforstore
	citizens = null; // nopeople
	step = 1;
	stepstowards = 10;
	stepsbackwards = 0;
	nextplace=seaporte;
	backplace=kaetown;

    }
    public int event() {
	System.out.println( (new Story()).A2 );
	return -1;
    }

    public Area Check(){
	if (step == stepstowards){
	}
	if(step==stepsbackwards){
	}
	return this;
    }
}

class Towndos extends Area{
    public Towndos(){
	first = false;//if false, trigger event, change to true
	town = true;
	name= "Seaporte";
	munstars = new ArrayList<Monster>();
	store = new ArrayList<Item>();
	citizens = new ArrayList<Trivia>();
	step = 0;
	stepstowards = 10;
	stepsbackwards = 0;
	nextplace= aguael;
	backplace=feywood;

    }
    public int event() {
	System.out.println( (new Story()).t2 );
	System.out.println( (new Story()).E1 );
     	return 2;
    }
    public Area Check(){
	return this;
    }
}
class Water extends Area{
    public Water(){

	first = false;
	town= false;
	name= "Aguael";
	munstars = new ArrayList<Monster>();
	munstars.add( new Fish() );
	munstars.add( new Shark() );
	munstars.add( new Pirate() );
	store = null;//noneedforstore
	citizens = null; // nopeople
	step = 1;
	stepstowards = 10;
	stepsbackwards = 0;
	nextplace=tree;
	backplace=seaporte;
    }
    public int event() {
	System.out.println( (new Story()).A3 );
	System.out.println( (new Story()).E2 );
	return 3;
    }
    public Area Check(){
	return this;	
    }
}
class Towntres extends Area{
    public Towntres(){
	first = false;//if false, trigger event, change to true
	town = true;
	name= "Town Tree";
	munstars = new ArrayList<Monster>();
	store = new ArrayList<Item>();
	citizens = new ArrayList<Trivia>();
	step = 0;
	stepstowards = 10;
	stepsbackwards = 0;
	nextplace= sans;
	backplace=aguael;

    }
    public int event() {
	System.out.println( (new Story()).t3 );
	System.out.println( (new Story()).E5 );
	return 4;
    }
    public Area Check(){
	return this;
    }
}
class Mountain extends Area{
    public Mountain(){

	first = false;
	town= false;
	name= "Sans";
	munstars = new ArrayList<Monster>();
	munstars.add( new Goat() );
	munstars.add( new Lion() );
	munstars.add( new Hiker() );
	store = null;//noneedforstore
	citizens = null; // nopeople
	step = 1;
	stepstowards = 10;
	stepsbackwards = 0;
	nextplace=metro;
	backplace=tree;

    }
    public int event() {
	System.out.println( (new Story()).A4 );
	return -1;
    }
    public Area Check(){
	return this;
    }
}
class Towncuatro extends Area{
    public Towncuatro(){
	first = false;//if false, trigger event, change to true
	town = true;
	name= "Metro";
	munstars = new ArrayList<Monster>();
	store = new ArrayList<Item>();
	citizens = new ArrayList<Trivia>();
	step = 0;
	stepstowards = 10;
	stepsbackwards = 0;
	nextplace= dessert;
	backplace=sans;

    }
    public int event() {
	System.out.println( (new Story()).t4 );
	System.out.println( (new Story()).E4 );
	return 5;
    }
    public Area Check(){
	return this;
    }
}
class Desert extends Area{
    public Desert(){
	first = false;
	town= false;
	name= "Dessert Desert";
	munstars = new ArrayList<Monster>();
	munstars.add( new Cake() );
	munstars.add( new Icecream() );
	munstars.add( new Fat() );
	store = null;//noneedforstore
	citizens = null; // nopeople
	step = 1;
	stepstowards = 10;
	stepsbackwards = 0;
	nextplace=towere;
	backplace=metro;
    }
    public int event() {
	System.out.println( (new Story()).A5 );
	return -1;
    }
    public Area Check(){	
	return this;
    }
}
class Tower extends Area{
    public Tower(){
	first = false;//if false, trigger event, change to true
	town = true;
	name= "Towere";
	munstars = new ArrayList<Monster>();
	store = new ArrayList<Item>();
	citizens = new ArrayList<Trivia>();
	step = 0;
	stepstowards = 10;
	stepsbackwards = 0;
	nextplace= null;
	backplace= dessert;
    }
    public int event() {
	System.out.println( (new Story()).E6 );
	return 6;
    }
    public Area Check(){
	return this;
    }
}
