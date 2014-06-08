//EDIT TEMPERARY RETURN STATEMNTS AT MOVEFORWARD AND CHECK() METHODS
//ALSO LOOK AT LINES 20-26 BECAUSE LEFT YOU A MESSAGE =w=

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
  
    /*
      SHERRY
      I think there should be variables for these, since we shouldnt be creating new areas when they go back. Right? Im not sure how you want to do this, but originally you had backplace = Village(), which doesnt work because it should be new Village(), but i dont know if we want to create a new one. 
IDK.Stuff works now so yey?
    */
    protected static Village village = new Village();
    protected static Grassland grassland = new Grassland();
    protected static Kaetown kaetown = new Kaetown();
    //^^

    public ArrayList<Monster> getMon() {
	return munstars;
    }
    public Area moveFoward(){
	if (town){
	    return nextplace;
	}
	else{ 
	    step+=1;
	    Check();
	}

	//TEMPORARY RETURN STATEMENT
	return null;
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
	first = true;
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
    public Area Check(){//town no need to do anything
	//TEMPORARY RETURN 
	return null;
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
	nextplace=kaetown;
	backplace=village;
    }
    public Area Check(){
	if (step == stepstowards){
	}
	if(step==stepsbackwards){
	}
	//TEMPORARY RETURN 
	return null;
    }
}
class Kaetown extends Area{
    public Kaetown(){
	town = true;
    }
    public Area Check(){
	//TEMPORARY RETURN 
	return null;
    }
}
class Feywood extends Area{
    public Feywood(){
	town = false;
    }
    public Area Check(){
	//TEMPORARY RETURN 
	return null;
    }
}
class Seaporte extends Area{
    public Seaporte(){
	town = true;
    }
    public Area Check(){
	//TEMPORARY RETURN 
	return null;
    }
}
class Aguael extends Area{
    public Aguael(){
	town=false;
    }
    public Area Check(){
	//TEMPORARY RETURN 
	return null;	
    }
}
class Towntree extends Area{
    public Towntree(){
	town=true;
    }
    public Area Check(){
	//TEMPORARY RETURN 
	return null;
    }
}
class Sans extends Area{
    public Sans(){
	town= false;
    }
    public Area Check(){
	//TEMPORARY RETURN 
	return null;
    }
}
class Metro extends Area{
    public Metro(){
	town= true;
    }
    public Area Check(){
	//TEMPORARY RETURN 
	return null;
    }
}
class Dessert extends Area{
    public Dessert(){
	town=false;
    }
    public Area Check(){	
	//TEMPORARY RETURN 
	return null;
    }
}
class Tower extends Area{
    public Tower(){
    }
    public Area Check(){
	//TEMPORARY RETURN 
	return null;
    }
}

				       
