public abstract class Monster extends Base{
    protected String disc;
}
//grassland
class Slime extends Monster{
    public Slime(){
	name= "Slim";
	person="Slime";
	bhp=hp=19+(int)(Math.random()*lvl*10);
	bmp=mp=17+(int)(Math.random()*lvl*10);
	bstr=str= 5+(int)(Math.random()*lvl*5);
	bwis=wis=4+(int)(Math.random()*lvl*5);
	bluk=luk=4+(int)(Math.random()*lvl*5);
	bspd=spd=3+(int)(Math.random()*lvl*5);
	bdef=def=5+(int)(Math.random()*lvl*5);
	lvl=1+((int) (Math.random()*5));
	bheight=height=18;//cm
	bweight=weight=2;//kg
	isDead=false;
	exp=5+lvl;//exp given to player
	wep= null;
	arm=null;
	mun=1;
	inventory=null;//possible drops
	statuses=null;
	attks=null;

    }
}
class Snail extends Monster{
    public Snail(){
	name= "Naie";
	person="Snai;";
	bhp=hp=22+(int)(Math.random()*lvl*11);
	bmp=mp=14+(int)(Math.random()*lvl*11);
	bstr=str= 5+(int)(Math.random()*lvl*5);
	bwis=wis=2+(int)(Math.random()*lvl*5);
	bluk=luk=5+(int)(Math.random()*lvl*5);
	bspd=spd=2+(int)(Math.random()*lvl*5);
	bdef=def=6+(int)(Math.random()*lvl*5);
	lvl=2+((int) (Math.random()*5));
	bheight=height=5;//cm
	bweight=weight=1;//kg
	isDead=false;
	exp=5+lvl;
	wep= null;
	arm=null;
	mun=1;
	inventory=null;//possible drops
	statuses=null;
	attks=null;

    }
}
class Kids extends Monster{
    public Kids(){
	name= "Kid";
	person="Child";
	bhp=hp=39+(int)(Math.random()*lvl*12);
	bmp=mp=25+(int)(Math.random()*lvl*12);
	bstr=str= 7+(int)(Math.random()*lvl*6);
	bwis=wis=6+(int)(Math.random()*lvl*6);
	bluk=luk=11+(int)(Math.random()*lvl*6);
	bspd=spd=8+(int)(Math.random()*lvl*6);
	bdef=def=7+(int)(Math.random()*lvl*6);
	lvl=3+((int) (Math.random()*6));
	bheight=height=114;//cm
	bweight=weight=25;//kg
	isDead=false;
	exp=5+lvl;
	wep= new Stick();
	arm= new Clothes();
	mun=10;
	inventory=null;
	statuses=null;
	attks=null;
    }
}
//Forest
class Goblin extends Monster{
    public Goblin(){
	name= "Gobs";
	person="Goblin";
	bhp=hp=41+(int)(Math.random()*lvl*13);
	bmp=mp=40+(int)(Math.random()*lvl*13);
	bstr=str= 7+(int)(Math.random()*lvl*7);
	bwis=wis=3+(int)(Math.random()*lvl*7);
	bluk=luk=5+(int)(Math.random()*lvl*7);
	bspd=spd=5+(int)(Math.random()*lvl*7);
	bdef=def=6+(int)(Math.random()*lvl*7);
	lvl=4+((int) (Math.random()*5));
	bheight=height=55;//cm
	bweight=weight=30;//kg
	isDead=false;
	exp=5+lvl;
	wep= null;
	arm=null;
	mun=1;
	inventory=null;//possible drops
	statuses=null;
	attks=null;

    }
}
class Monkey extends Monster{
    public Monkey(){
	name= "Mankey";
	person="Monkey";
	bhp=hp=52+(int)(Math.random()*lvl*14);
	bmp=mp=49+(int)(Math.random()*lvl*14);
	bstr=str= 5+(int)(Math.random()*lvl*7);
	bwis=wis=7+(int)(Math.random()*lvl*7);
	bluk=luk=5+(int)(Math.random()*lvl*7);
	bspd=spd=6+(int)(Math.random()*lvl*7);
	bdef=def=4+(int)(Math.random()*lvl*7);
	lvl=5+((int) (Math.random()*5));
	bheight=height=75;//cm
	bweight=weight=30;//kg
	isDead=false;
	exp=5+lvl;
	wep= null;
	arm=null;
	mun=1;
	inventory=null;//possible drops
	statuses=null;
	attks=null;

    }
}
class Camper extends Monster{
    public Camper(){
	name= "Campi";
	person="Camper";
	bhp=hp=73+(int)(Math.random()*lvl*15);
	bmp=mp=57+(int)(Math.random()*lvl*15);
	bstr=str= 10+(int)(Math.random()*lvl*8);
	bwis=wis=10+(int)(Math.random()*lvl*8);
	bluk=luk=8+(int)(Math.random()*lvl*8);
	bspd=spd=11+(int)(Math.random()*lvl*8);
	bdef=def=11+(int)(Math.random()*lvl*8);
	lvl=6+((int) (Math.random()*6));
	bheight=height=167;//cm
	bweight=weight=67;//kg
	isDead=false;
	exp=5+lvl;
	wep= null;
	arm=null;
	mun=1;
	inventory=null;//possible drops
	statuses=null;
	attks=null;

    }
}
//Water
class Fish extends Monster{
    public Fish(){
	name= "Pira";
	person="Piranah";
	bhp=hp=65+(int)(Math.random()*lvl*16);
	bmp=mp=51+(int)(Math.random()*lvl*16);
	bstr=str=6+(int)(Math.random()*lvl*9);
	bwis=wis=5+(int)(Math.random()*lvl*9);
	bluk=luk=6+(int)(Math.random()*lvl*9);
	bspd=spd=5+(int)(Math.random()*lvl*9);
	bdef=def=5+(int)(Math.random()*lvl*9);
	lvl=7+((int) (Math.random()*5));
	bheight=height=33;//cm
	bweight=weight=4;//kg
	isDead=false;
	exp=5+lvl;
	wep= null;
	arm=null;
	mun=1;
	inventory=null;//possible drops
	statuses=null;
	attks=null;

    }
}
class Shark extends Monster{
    public Shark(){
	name= "Karhs";
	person="Shark";
	bhp=hp=66+(int)(Math.random()*lvl*17);
	bmp=mp=60+(int)(Math.random()*lvl*17);
	bstr=str= 7+(int)(Math.random()*lvl*9);
	bwis=wis=8+(int)(Math.random()*lvl*9);
	bluk=luk=6+(int)(Math.random()*lvl*9);
	bspd=spd=7+(int)(Math.random()*lvl*9);
	bdef=def=10+(int)(Math.random()*lvl*9);
	lvl=8+((int) (Math.random()*5));
	bheight=height=200;//cm
	bweight=weight=40;//kg
	isDead=false;
	exp=5+lvl;
	wep= null;
	arm=null;
	mun=1;
	inventory=null;//possible drops
	statuses=null;
	attks=null;

    }
}
class Pirate extends Monster{
    public Pirate(){
	name= "Etarr";
	person="Pirate";
	bhp=hp=89+(int)(Math.random()*lvl*18);
	bmp=mp=86+(int)(Math.random()*lvl*18);
	bstr=str= 10+(int)(Math.random()*lvl*10);
	bwis=wis=13+(int)(Math.random()*lvl*10);
	bluk=luk=12+(int)(Math.random()*lvl*10);
	bspd=spd=11+(int)(Math.random()*lvl*10);
	bdef=def=14+(int)(Math.random()*lvl*10);
	lvl=9+((int) (Math.random()*6));
	bheight=height=175;//cm
	bweight=weight=68;//kg
	isDead=false;
	exp=5+lvl;
	wep= new Stick();
	arm= new Clothes();
	mun=10;
	inventory=null;
	statuses=null;
	attks=null;
    }
}
//Mountain
class Goat extends Monster{
    public Goat(){
	name= "Tee";
	person="Goat";
	bhp=hp=84+(int)(Math.random()*lvl*19);
	bmp=mp=73+(int)(Math.random()*lvl*19);
	bstr=str= 7+(int)(Math.random()*lvl*11);
	bwis=wis=10+(int)(Math.random()*lvl*11);
	bluk=luk=10+(int)(Math.random()*lvl*11);
	bspd=spd=11+(int)(Math.random()*lvl*11);
	bdef=def=9+(int)(Math.random()*lvl*11);
	lvl=10+((int) (Math.random()*5));
	bheight=height=100;//cm
	bweight=weight=100;//kg
	isDead=false;
	exp=5+lvl;
	wep= null;
	arm=null;
	mun=1;
	inventory=null;//possible drops
	statuses=null;
	attks=null;

    }
}
class Lion extends Monster{
    public Lion(){
	name= "Niol";
	person="Lion";
	bhp=hp=91+(int)(Math.random()*lvl*20);
	bmp=mp=78+(int)(Math.random()*lvl*20);
	bstr=str=10+(int)(Math.random()*lvl*11);
	bwis=wis=8+(int)(Math.random()*lvl*11);
	bluk=luk=11+(int)(Math.random()*lvl*11);
	bspd=spd=10+(int)(Math.random()*lvl*11);
	bdef=def=10+(int)(Math.random()*lvl*11);
	lvl=11+((int) (Math.random()*5));
	bheight=height=250;//cm
	bweight=weight=150;//kg
	isDead=false;
	exp=5+lvl;
	wep= null;
	arm=null;
	mun=1;
	inventory=null;//possible drops
	statuses=null;
	attks=null;

    }
}
class Hiker extends Monster{
    public Hiker(){
	name= "Mike";
	person="Hiker";
	bhp=hp=108+(int)(Math.random()*lvl*21);
	bmp=mp=105+(int)(Math.random()*lvl*21);
	bstr=str=16+(int)(Math.random()*lvl*12);
	bwis=wis=14+(int)(Math.random()*lvl*12);
	bluk=luk=15+(int)(Math.random()*lvl*12);
	bspd=spd=16+(int)(Math.random()*lvl*12);
	bdef=def=15+(int)(Math.random()*lvl*12);
	lvl=12+((int) (Math.random()*6));
	bheight=height=180;//cm
	bweight=weight=68;//kg
	isDead=false;
	exp=5+lvl;
	wep= new Stick();
	arm= new Clothes();
	mun=10;
	inventory=null;
	statuses=null;
	attks=null;
    }
}
//Desert (slooow monsters)
class Cake extends Monster{//or pie?
    public Cake(){
	name= "Slice";
	person="Cake";
	bhp=hp=101+(int)(Math.random()*lvl*22);
	bmp=mp=93+(int)(Math.random()*lvl*22);
	bstr=str=12+(int)(Math.random()*lvl*13);
	bwis=wis=9+(int)(Math.random()*lvl*13);
	bluk=luk=13+(int)(Math.random()*lvl*13);
	bspd=spd=3+(int)(Math.random()*lvl*1.3);
	bdef=def=13+(int)(Math.random()*lvl*13);
	lvl=13+((int) (Math.random()*5));
	bheight=height=122;//cm
	bweight=weight=83;//kg
	isDead=false;
	exp=5+lvl;
	wep= null;
	arm=null;
	mun=1;
	inventory=null;//possible drops
	statuses=null;
	attks=null;

    }
}
class Icecream extends Monster{
    public Icecream(){
	name= "Ecimearc";
	person="Ice Cream";
	bhp=hp=108+(int)(Math.random()*lvl*23);
	bmp=mp=105+(int)(Math.random()*lvl*23);
	bstr=str= 11+(int)(Math.random()*lvl*13);
	bwis=wis=10+(int)(Math.random()*lvl*13);
	bluk=luk=13+(int)(Math.random()*lvl*13);
	bspd=spd=3+(int)(Math.random()*lvl*1.3);
	bdef=def=10+(int)(Math.random()*lvl*13);
	lvl=14+((int) (Math.random()*5));
	bheight=height=100;//cm
	bweight=weight=75;//kg
	isDead=false;
	exp=5+lvl;
	wep= null;
	arm=null;
	mun=1;
	inventory=null;//possible drops
	statuses=null;
	attks=null;

    }
}
class Fat extends Monster{//uh :D
    public Fat(){
	name= "Phatti";
	person="Fat";
	bhp=hp=137+(int)(Math.random()*lvl*24);
	bmp=mp=129+(int)(Math.random()*lvl*24);
	bstr=str= 19+(int)(Math.random()*lvl*14);
	bwis=wis=16+(int)(Math.random()*lvl*14);
	bluk=luk=14+(int)(Math.random()*lvl*14);
	bspd=spd=6+(int)(Math.random()*lvl*1.4);
	bdef=def=14+(int)(Math.random()*lvl*14);
	lvl=15+((int) (Math.random()*6));
	bheight=height=148;//cm
	bweight=weight=100;//kg
	isDead=false;
	exp=5+lvl;
	wep= new Stick();
	arm= new Clothes();
	mun=10;
	inventory=null;
	statuses=null;
	attks=null;
    }
}
