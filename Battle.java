public abstract Battles {

    private ArrayList<Base> MONSTERS;

    //Initiates a battle. Will be defined for each area.
    //Note: Players set a team(4 guys) that will go into battle
    abstract void init( ArrayList<Base> mon );

}

       