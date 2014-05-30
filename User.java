public class User {
    
    private ArrayList<Base> _avail = new ArrayList<Base>(); //available team members
    private Base[] _team = new Base[4]; //the user's team in battle (up to 4);
    
    public Base[] addTeam( Base p ) {
	if ( _team.length == 4 ) {
	    swap( p