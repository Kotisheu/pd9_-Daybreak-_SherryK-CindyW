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
    
    public ArrayList<Monster> getMon() {
	return munstars;
    }
    public Area MoveFoward(){
	if (town){
	    return nextplace;
	}
	else{ 
	    step+=1;
	    check();
	}
    }
    public abstract Area Check();

}

class Village extends Area{
    public Village() {
	first = true;
	town = true;
	name= "Pellet Town";
	munstars = new ArrayList<Monster>();
	store = new ArrayList<Item>();
	citizens = new ArrayList<Trivia>();
	step = 0;
	stepstowards = 10;
	stepsbackwards = 0;
	System.out.println( "random story?" );
	nextplace=new Grassland();
	backplace=null;
    }
    public Area Check(){//town no need to do anything
    }

}
class Grassland extends Area{
    public Grassland(){
	first = true;
	town= false;
	name= "Stonehenge";
	munstars = new ArrayList<Monster>();
	store = null;//noneedforstore
	citizens = null; // nopeople
	step = 1;
	stepstowards = 10;
	stepsbackwards = 0;
	System.out.println( "random story?" );
	nextplace=new Kaetown();
	backplace=village();
    }
    public Area Check(){
	if (step == stepstowards){
	}
	if(step==stepsbackwards){
	}
    }
}