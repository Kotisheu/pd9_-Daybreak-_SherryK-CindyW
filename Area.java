public class abstract Area{
    protected ArrayList<Items> store;//what items are availiable in this place
    protected ArrayList<Monsters> munstars;// what monsters are here
    protected ArrayList<Trivia> people;// trivia given by talking to random people in towns :)
    protected boolean first; // is this first time here?- trigger event
    protected String name;
    protected boolean town;//true if town, false if outside area
    protected int step;//step this is at <town>, starting step for area
    protected int stepstowards;// steps to town in front
    protected int stepsbackwards;//steps to town behind
    
}
class village extends Area{

}
