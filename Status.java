import java.util.*;

public abstract class Status{
    protected boolean buff;
    protected String name;
    protected boolean isBuff(){
	return buff;
    }
    public void affect(Base a, Status s){

	ArrayList<Status> stat=a.getStatuses();
	stat.add(s);
<<<<<<< HEAD
	a.setStatuses(stat);
=======

	// a.getStatuses().add(s);
	// ArrayList<Status> stat=a.getStatuses();
	// a.setStatuses(stat);
>>>>>>> 8e406d83ebacf3d0586d1720f8d1cb64c7b0a4c8
    }
    public abstract String effect();// how cause effect
  public String getName(){
	return name;
    }
    public void setName(String n){
	name=n;
    }
	
}
class Bless extends Status{
    public  Bless(){
	buff= true;
    }
    public String effect(){
	return "";}
}
	
	
