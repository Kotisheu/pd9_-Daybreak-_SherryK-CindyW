public abstract class Item{
    protected String name;
    protected int cost;
    protected int amount;
    public abstract String use();
    public abstract String purchase(int number);
}