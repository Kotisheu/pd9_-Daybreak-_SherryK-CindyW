public class Main extends People{
    public Main(){
	person="You";
    
	name="bob";
	setPlace( new Village() );
	bhp=hp=70+(int)(Math.random()*lvl*50);
	bmp=mp=58+(int)(Math.random()*lvl*50);
	bstr=str=7+(int)(Math.random()*lvl*10);
	bwis=wis=5+(int)(Math.random()*lvl*10);
	bluck=luk=8+(int)(Math.random()*lvl*10);
	bspd=spd=5+(int)(Math.random()*lvl*10);
	bdef=def=8+(int)(Math.random()*lvl*10);
	lvl=1;
	exp=0;
	bexp= lvl*50;
	bheight=height=175;//cm
	bweight=weight=59;//kg
	inventory= null;
	statuses= null;
	attks=null;
	wep= new Stick();
	arm= new Leather();
	mun=500;

	isDead=false;
    }

    public Main(String n){
        this();
	name=n;

    }
}
