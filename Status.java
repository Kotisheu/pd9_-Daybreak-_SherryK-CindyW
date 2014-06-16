import java.util.*;

public abstract class Status{
    protected boolean buff;
    protected String name;
    protected boolean isBuff(){
	return buff;
    }
    public void affect(Base a, Status s){
	a.getStatuses().add(s);
	ArrayList<Status> stat=a.getStatuses();
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
	
	
