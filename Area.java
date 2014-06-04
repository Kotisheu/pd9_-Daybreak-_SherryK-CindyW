import java.util.ArrayList;

public abstract class Area{
    protected ArrayList<Item> store;//what items are availiable in this place
    protected ArrayList<Monster> munstars;// what monsters are here
    protected ArrayList<Trivia> people;// trivia given by talking to random people in towns :)
    protected boolean first; // is this first time here?- trigger event
    protected String name;
    protected boolean town;//true if town, false if outside area
    protected int step;//step this is at <town>, starting step for area
    protected int stepstowards;// steps to town in front
    protected int stepsbackwards;//steps to town behind
    
    public ArrayList<Monster> getMon() {
	return munstars;
    }
}
//Wait this should be in a different file? or no...
class Village extends Area{
    //I just fleshed this out so i could try testing....
    public Village() {
	first = true;
	town = true;
	munstars = new ArrayList<Monster>();
	store = new ArrayList<Item>();
	people = new ArrayList<Trivia>();
	step = 0;
	stepstowards = 10;
	stepsbackwards = 0;
	System.out.println( "random story?" );
    }
 }
