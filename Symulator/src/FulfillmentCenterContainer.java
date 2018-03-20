import javax.swing.*;
import java.util.*;

public class FulfillmentCenterContainer {

    Map<String, FulfillmentCenter> warehouses ;


    public FulfillmentCenterContainer(){
        warehouses = new HashMap<String, FulfillmentCenter>();
    }

    public void addCenter(String name, double capacity) {


        warehouses.put(name, new FulfillmentCenter(name, capacity));

    }

    public void addCenter(FulfillmentCenter warehouse) {
        warehouses.put(warehouse.getName(), warehouse);

    }

    public void removeCenter(String name) {
        warehouses.remove(name);

    }

    public List<FulfillmentCenter> findEmpty() {  // zwraca puste magazyny
         List<FulfillmentCenter> emptyWarehouses=new ArrayList<>();
       Set<Map.Entry<String, FulfillmentCenter>> entrySet = warehouses.entrySet();

        for (Map.Entry<String, FulfillmentCenter> entry : entrySet) {

           if (entry.getValue().globalCapacity == 0.0) {

               emptyWarehouses.add(entry.getValue());

            }

       }
       return emptyWarehouses;
    }

    public void summary(){  // zwraca nazwe i procentowe zapelnienie magazynu

        for( FulfillmentCenter x : warehouses.values() )
            System.out.println("Warehouse name: " + x.getName() + " Capacity in %: " + (x.globalCapacity)/(x.getCapacity())*100.0+ " %");

    }
}
