import java.util.ArrayList;

public abstract class Base{
    
    protected int hp,mp,lvl,exp,str,wis,luk,spd,def,res,mun,height,weight;//curent amount(12)
    protected int bhp,bmp,bexp,bstr,bwis,bluk,bspd,bdef,bres,bheight,bweight;//max amount/base amount depending : > (10)
    protected boolean canAtk; //can character attakc? (not waiting on a move)
    protected boolean defing; // is character defending
    protected boolean ran; //did char try to run
    protected boolean isDead;
    protected String name;
    protected String person;
    protected Area place;
    protected ArrayList<Item> inventory;// what items do you have 
    protected ArrayList<Status> statuses;// what buffs/debuffs are on you
    protected ArrayList<Attacks> attks = new ArrayList<Attacks>() {{ add(new A1()); }};//what attacks can you perform. Everyone can perform a simple attack
    protected Weapon wep;
    protected Armor arm;
    public int getHp(){
	if ( hp < 0 ) 
	    return 0;
	return hp;
    }
    public void setHp(int n){
	hp= n;
    }
    public int getMp(){
	if ( mp < 0 )
	    return 0;
	return mp;
    }
    public void setMp(int n){
	mp= n;
    }
    
    public int getLvl(){
	return lvl;
    }
    public void setLvl(int n){
	lvl= n;
    }
    
    public int getExp(){
	return exp;
    }
    public void setExp(int n){
	exp= n;
    }

    public int getNxt(){ //Amount to next lvl
	return bexp;
    }
    public void setNxt(int n){
	bexp= n;
    }
    
    public int getStr(){
	if ( str < 0 )
	    return 0;
	return str;
    }
    public void setStr(int n){
	str= n;
    }
    
    public int getWis(){
	if ( wis < 0 )
	    return 0;
	return wis;
    }
    public void setWis(int n){
	wis= n;
    }
    
    public int getLuk(){
	if ( luk < 0 )
	    return 0;
	return luk;
    }
    public void setLuk(int n){
	luk= n;
    }
    
    public int getSpd(){
	if ( spd < 0 )
	    return 0;
	return spd;
    }
    public void setSpd(int n){
	spd= n;
    }
    
    public int getDef(){
	if ( def < 0 )
	    return 0;
	return def;
    }
    public void setDef(int n){
	def= n;
    }

    public int getRes(){ //magic guard
	if ( res < 0 )
	    return 0;
	return res;
    }
    public void setRes(int n){
	res= n;
    }
    
    public int getMun(){
	if ( mun < 0 )
	    return 0;
	return mun;
    }
    public void setMun(int n){
	mun= n;
    }
    
    public int getHeight(){
	if ( height < 0 )
	    return 0;
	return height;
    }
    public void setHeight(int n){
	height= n;
    }
    
    public int getWeight(){
	if ( height < 0 )
	    return 0;
	return weight;
    }
    public void setWeight(int n){
	weight= n;
    }
    //12
    public int getbHp(){
	return bhp;
    }
    public void setbHp(int n){
	bhp= n;
    }
    
    public int getbMp(){
	return bmp;
    }
    public void setbMp(int n){
	bmp= n;
    }
    
    public int getbExp(){
	return bexp;
    }
    public void setbExp(int n){
	bexp= n;
    }
    
    public int getbStr(){
	return bstr;
    }
    public void setbStr(int n){
	bstr= n;
    }
    
    public int getbWis(){
	return bwis;
    }
    public void setbWis(int n){
	bwis= n;
    }
    
    public int getbLuk(){
	return bluk;
    }
    public void setbLuk(int n){
	bluk= n;
    }
    
    public int getbSpd(){
	return bspd;
    }
    public void setbSpd(int n){
	bspd= n;
    }
    
    public int getbDef(){
	return bdef;
    }
    public void setbDef(int n){
	bdef= n;
    }
    
    public int getbHeight(){
	return bheight;
    }
    public void setbHeight(int n){
	bheight= n;
    }
    
    public int getbWeight(){
	return bweight;
    }
    public void setbWeight(int n){
	bweight= n;
    }
    //10
    public boolean getDead(){
	return isDead;
    }
    public void setDead(boolean n){
	isDead= n;
    }
    public String getName(){
	return name;
    }
    public void setName( String n){
	name= n;
    }
    public String getPerson(){
	return person;
    }
    public void setPerson(String n){
	person= n;
    }
    public Area getPlace(){
	return place;
    }
    public void setPlace(Area n){
	place=n;
    }
    public ArrayList<Item> getInv(){
	return inventory;
    }
    public void setInv(ArrayList<Item> n){
	inventory= n;
    }
    public ArrayList<Status> getStatuses(){
	return statuses;
    }
    public void setStatuses(ArrayList<Status> n){
	statuses=n;
    }
    public ArrayList<Attacks> getAttks(){
	return attks;
    }
    public void setAttks(ArrayList<Attacks> n){
	attks=n;
    }
    public Weapon getWep(){
	return wep;
    }
    public void setWep(Weapon n){
	wep=n;
	wep.equip( this );
    }
    public Armor getArm(){
	return arm;
    }
    public void setArm(Armor n){
	arm=n;
    }

    public boolean canAtk() {
	return canAtk;
    }
    public void canAtk( boolean b ) {
	canAtk = b;
    }
    public boolean ran() {
	return ran;
    }
    public void ran( boolean b ) {
	ran = b;
    }
	
}
