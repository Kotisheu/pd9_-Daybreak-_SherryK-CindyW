import java.util.ArrayList;
public abstract class Armor extends Item{
    protected int hp,mp,lvl,str,wis,luk,spd,def, height,weight;
    protected ArrayList<Status> statuses;
    protected ArrayList<Attacks> attks;
    protected String disc;
}
class Clothes extends Armor{
    public Clothes(){
	name= "Clothes";
	cost= 10;
	amount=1;
	hp=mp=str=wis=luk=spd=def=1;
	lvl=0;
	weight=1;
	height=0;
	statuses=null;
	attks=null;
	disc="Normal, everyday clothes. Offers little to no protection. Slightly dirty and covered in grass stains.";
	    }
    public String use(){
	//add current armor to inv,put this on
	return "You have worn the clothes.";
    }
    public String purchase(int number){//also sell
    }
	

}
class Leather extends Armor{
    public Leather(){
	hp=mp=str=wis=luk=spd=def=2;
	lvl=1;
	weight=2;
	height=0;
	statuses=null;
	attks=null;
	disc="Slightly smelly leather armor. Offers minimum protection.";
	    }
   public String use(){
	//add current armor to inv,put this on
	return "You have worn the leather armor.";
    }
    public String purchase(int number){//also sell
    } 

}
