import java.util.*;

public class Village extends Area{

    //I just fleshed this our so i could try testing....

    public Village() {

	first = true;
	town = true;
	munstars = new ArrayList<Monster>();
	store = new ArrayList<Item>();
	people = new ArrayList<Trivia>();
	step = 0;
	stepstowards = 10;
	stepsbackwards = 0;
	System.out.println( "1: random story?" );

    }

}
