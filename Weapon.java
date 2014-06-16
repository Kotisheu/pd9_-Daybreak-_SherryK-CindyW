import java.util.ArrayList;
public abstract class Weapon extends Item{
    protected int hp,mp,lvl,str,wis,luk,spd,def,res,height,weight;
    protected ArrayList<Status> statuses;
    protected ArrayList<Attacks> attks;
    protected String disc;
    
    public int getHp() {
	return hp;
    }
    public int getMp() {
	return mp;
    }
    public int getLvl() {
	return lvl;
    }
    public int getStr() {
	return str;
    }
    public int getWis() {
	return wis;
    }
    public int getLuk() {
	return luk;
    }
    public int getSpd() {
	return spd;
    }
    public int getDef() {
	return def;
    }
    public int getRes() {
	return res;
    }
    public int getHeight() {
	return height;
    }
    public int getWeight() {
	return weight;
    }
    
    public abstract void equip( Base b );
    public abstract void deequip( Base b );
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
    public void equip( Base b ) {
	if ( b.getWep() != null ) {
	    b.getWep().deequip(b);
	b.setbStr(b.getbStr()+str);
	b.setStr(b.getStr()+str);
	b.setbWis(b.getbWis()+str);
	b.setWis(b.getWis()+str);
	}
    }
    public void deequip( Base b ) {
	if ( b.getWep() instanceof Stick ) {
	    b.setbStr(b.getbStr()-str);
	    b.setStr(b.getStr()-str);
	    b.setbWis(b.getbWis()-str);
	    b.setWis(b.getWis()-str);
	}
    }
}
