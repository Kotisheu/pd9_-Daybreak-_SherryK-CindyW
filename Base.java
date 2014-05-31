public abstract class Base{
    //INPROGRESS, NO TOUCHY PLEASE 
    private int hp,mp,lvl,exp,str,wis,luk,spd,def, mun, height,weight;//curent amount(12)
    private int bhp,bmp,bexp,bstr,bwis,bluck,bspd,bdef,bheight,bweight;//max amount/base amount depending : > (10)
    private boolean isDead;
    private String name;
    private String person;
    private Area place;
    private ArrayList<Item> inventory;// what items do you have 
    private ArrayList<Status> statuses;// what buffs/debuffs are on you
    private Arraylist<Attacks> attks;//what attacks can you perform
    private Weapon wep;
    private Armor arm;
    public int getHp(){
	return hp;
    }
    public void setHp(int n){
	hp= n;
    }
    public int getMp(){
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
    
    public int getStr(){
	return str;
    }
    public void setStr(int n){
	str= n;
    }
    
    public int getWis(){
	return wis;
    }
    public void setWis(int n){
	wis= n;
    }
    
    public int getLuk(){
	return luk;
    }
    public void setLuk(int n){
	luk= n;
    }
    
    public int getSpd(){
	return spd;
    }
    public void setSpd(int n){
	spd= n;
    }
    
    public int getDef(){
	return def;
    }
    public void setDef(int n){
	def= n;
    }
    
    public int getMun(){
	return mun;
    }
    public void setMun(int n){
	mun= n;
    }
    
    public int getHeight(){
	return height;
    }
    public void setHeight(int n){
	height= n;
    }
    
    public int getWeight(){
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
    
    public int getbLuck(){
	return bluck;
    }
    public void setbLuck(int n){
	bluck= n;
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
    }
    public Armor getArm(){
	return arm;
    }
    public void setArm(Armor n){
	arm=n;
    }
	
}
