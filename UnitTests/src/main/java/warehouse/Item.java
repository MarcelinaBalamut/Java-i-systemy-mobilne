package warehouse;

enum ItemCondition{
    NEW, USED, REFURBISHED;
}

public class Item implements Comparable <Item>{


    private String name;
    ItemCondition condition;
    private double mass;
    private int number;

    public Item(String name, ItemCondition condition, double mass, int number){
        this.name=name;
        this.condition=condition;
        this.mass=mass;
        this.number=number;
    }

    public Item(String name){

        this.name=name;
        this.condition=null;
        this.mass=0;
        this.number=0;

    }

    public String getName()
    {
        return name;
    }
    public int getNumber()
    {
        return number;
    }
    public int setNumber(int number)
    {

            this.number = number;
            return number;


    }

    public double getMass()
    {
        return mass;
    }
    public ItemCondition getCondition()
    {
        return condition;
    }
    public void print(){
        System.out.println("Name: "+name+" Condition: "+condition+", Mass for one product: "+mass+", Number: "+number);
    }
    public  int compareTo(Item item){


       return name.compareTo(item.name);
    }

}


