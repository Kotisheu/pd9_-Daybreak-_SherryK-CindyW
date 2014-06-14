public class Main extends People{
    public Main(){
	setPlace( new Village() );
	bhp = hp = 15;
    }
    public Main(String n){
	this();
	name=n;
    }
}
