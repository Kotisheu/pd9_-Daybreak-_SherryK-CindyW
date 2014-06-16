import java.util.*;
<<<<<<< HEAD
=======

>>>>>>> 557236d054d541b1205bd1b41acb323e2e8a0921
public abstract class Status{
    protected boolean buff;
    protected String name;
    protected boolean isBuff(){
	return buff;
    }
    public void affect(Base a, Status s){
<<<<<<< HEAD
	ArrayList<Status> stat=a.getStatuses()
	    stat.add(s);
=======
	a.getStatuses().add(s);
	ArrayList<Status> stat=a.getStatuses();
>>>>>>> 557236d054d541b1205bd1b41acb323e2e8a0921
	a.setStatuses(stat);
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
	
	
