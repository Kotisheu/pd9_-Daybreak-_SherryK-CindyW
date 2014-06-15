public abstract class Item{
    protected String name;
    protected int cost;
    protected int amount;
    public abstract String use();
    public abstract String purchase(int number);
    public String getName(){
	return name;
    }
    public void setName(String n){
	name=n;
    }
    public int getAmount(){
	return amount;
    }
    public void setAmount(int n){
	amount=n;
    }
}
