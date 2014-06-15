import java.util.ArrayList;
public abstract class Weapon extends Item{
  protected int hp,mp,lvl,str,wis,luk,spd,def, height,weight;
    protected ArrayList<Status> statuses;
    protected ArrayList<Attacks> attks;
    protected String disc;
}
class Stick extends Weapon{
    public Stick(){// ADD stats to w/e equation :)
	str=wis=5  ;
	lvl= 0;//req. level
	weight= 0;
	height=0;
	statuses=null;
	attks=null;
	disc= "A mundane stick. Can poke things.";
	    }  
    public String use(){
	//add current armor to inv,put this on
	return "You have equipped the stick.";
    }
    public String purchase(int number){//also sell
return "";
    }
}
