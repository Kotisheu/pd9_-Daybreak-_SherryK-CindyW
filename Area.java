//EDIT TEMPERARY RETURN STATEMNTS AT MOVEFORWARD AND CHECK() METHODS

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
    protected static Area towntree= new Towntres();
    protected static Area sans= new Mountain(); 
    protected static Area metro= new Towncuatro();
    protected static Area dessert = new Desert();
    protected static Area tower= new Tower();


    public ArrayList<Monster> getMon() {
	return munstars;
    }
    public Area moveFoward(){
	if (town){
	    return nextplace;
	}
	else{ 
	    step+=1;
	    return Check();
	}

	return this;
    }
    public abstract Area Check();


    public static void main( String[] args ) {
    
	Area a = village;
	Area b = grassland;
	System.out.println( grassland );

    }
    
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
	store = null;//noneedforstore
	citizens = null; // nopeople
	step = 1;
	stepstowards = 10;
	stepsbackwards = 0;
	nextplace=kaetown;
	backplace=pellet;
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
    public Area Check(){
	return this;
    }
}
class Forest extends Area{
    public Forest(){
	town = false;
    }
    public Area Check(){
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
    public Area Check(){
	return this;
    }
}
class Water extends Area{
    public Water(){
	town=false;
    }
    public Area Check(){
	return this;	
    }
}
class Towntree extends Area{
    public Towntree(){
	first = false;//if false, trigger event, change to true
	town = true;
	name= "Pellet Town";
	munstars = new ArrayList<Monster>();
	store = new ArrayList<Item>();
	citizens = new ArrayList<Trivia>();
	step = 0;
	stepstowards = 10;
	stepsbackwards = 0;
	nextplace= grassland;
	backplace=null;

    }
    public Area Check(){
	return this;
    }
}
class Sans extends Area{
    public Sans(){
	town= false;
    }
    public Area Check(){
	return this;
    }
}
class Metro extends Area{
    public Metro(){
	first = false;//if false, trigger event, change to true
	town = true;
	name= "Pellet Town";
	munstars = new ArrayList<Monster>();
	store = new ArrayList<Item>();
	citizens = new ArrayList<Trivia>();
	step = 0;
	stepstowards = 10;
	stepsbackwards = 0;
	nextplace= grassland;
	backplace=null;

    }
    public Area Check(){
	return this;
    }
}
class Dessert extends Area{
    public Dessert(){
	town=false;
    }
    public Area Check(){	
	return this;
    }
}
class Tower extends Area{
    public Tower(){
	first = false;//if false, trigger event, change to true
	town = true;
	name= "Pellet Town";
	munstars = new ArrayList<Monster>();
	store = new ArrayList<Item>();
	citizens = new ArrayList<Trivia>();
	step = 0;
	stepstowards = 10;
	stepsbackwards = 0;
	nextplace= grassland;
	backplace=null;
    }
    public Area Check(){
	return this;
    }
}

				       
