package warehouse;

import java.util.*;

public class FulfillmentCenter {

    private String warehouseName;
     List<Item> products;
    private double capacity;  // max masa produktów
    public double globalCapacity; //obecna masa

    public FulfillmentCenter(String warehouseName, double capacity ){

        this.warehouseName=warehouseName;
        this.capacity=capacity;
        products=new ArrayList<>();
        globalCapacity=0.0;
    }
    public double getCapacity(){
        return capacity;
    }
    public String getName(){

        return warehouseName;
    }

   public void addProduct(Item item){


       if(globalCapacity+item.getMass()*item.getNumber()<=capacity) {

           if (products.indexOf(item) == -1) {  // jesli nie ma takiego produktu

               if(item.getName()!=null ) {
                   products.add(item);
                   globalCapacity = globalCapacity + (item.getMass() * item.getNumber()); // dodaje do listy
               }

           } else {
               int tempNumber = item.getNumber(); //jesli jest taki produkt to zwieksza jego liczbe
               int index = products.indexOf(item);
               //item.setNumber(tempNumber + item.getNumber());
               products.get(index).setNumber(products.get(index).getNumber()+tempNumber);  // zwieksza liczebnosc
               globalCapacity+=item.getMass()*tempNumber;

           }

       }

       else
           System.err.println("No space in the warehouse");

   }
//    public void getProduct(Item item){
//
//        if(item.getNumber()==1){            //jesli ilosc produktow wieksza niz 1 zmniejsza liczbe, inaczej usuwa calkowicie
//            products.remove(item);
//            globalCapacity=globalCapacity-item.getMass();
//
//        }
//        else if(item.getNumber()>1){
//            item.setNumber(item.getNumber()-1);
//            globalCapacity=globalCapacity-item.getMass();
//        }
//        else{
//            System.out.println(" there is no such product");
//        }
//
//
//    }
    public boolean removeProduct(Item item) throws IllegalArgumentException{



        boolean firstItem = false;
        ListIterator<Item> listIterator1 = products.listIterator();
        while (listIterator1.hasNext()) {
            Item element = listIterator1.next();
            if (element.equals(item)) {         // jesli napotka rowny element to do usuwa
                listIterator1.remove();
                firstItem=true;
                System.out.println(" Product " + item.getName() + " has been removed ");
            }
        }
        if(firstItem==false)
            throw new IllegalArgumentException(" There is any product like this ");

        return true;
    }



    public Item search(String name){ //  przyjmuje nazwę produktu i zwracający go
        Item item;
        Collections.sort(products, new Comparator<Item>() {
            @Override
            public int compare(Item i1, Item i2) {
                return i1.getName().compareTo(i2.getName());
            }
        });

        int index = Collections.binarySearch(products, new Item(name), new Comparator<Item>() {

            public int compare(Item i1, Item i2) {
                return i1.getName().compareTo(i2.getName());
            }
        });

        if(index>-1){   // jesli jest to zwraca
            item=products.get(index);
        }
        else
        {
            System.out.println("No found this item");
            item = new Item(name, null, 0, 0);
        }
        return item;


    }

    public List<Item> searchPartial(String partial) {   // zwraca liste produktow gdzie w nazwie wystepuje jakas czesc
        ArrayList<Item> partialName = new ArrayList<Item>();

        for(Item x : products) {

            if (x.getName().contains(partial))
                partialName.add(x);
        }
        return partialName;
    }



    public int countByCondition(ItemCondition condition){  // zlicza conditiony

       int counter=0;
        for(Item x: products){
            if(condition==x.getCondition()){
                counter+=x.getNumber();
            }

        }
        return counter;
    }
    public void summary(){
        for(Item x: products){
            x.print();
        }

    }

    public List<Item> sortByName(){
       Collections.sort(products);
       return products;

    }


    public List<Item> sortByAmount(){

        Collections.sort(products, new NumberComparator());
        return products;
    }


    public Item max(){  // zaraca produkt o najwiekszej liczebnosci


        Item s1 = Collections.max(products, new Comparator<Item> () {

            public int compare(Item o1, Item o2) {
                return o1.getNumber() - o2.getNumber();
            }
        });
        return s1;
    }



}
