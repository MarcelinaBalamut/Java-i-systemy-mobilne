import java.util.ArrayList;
import java.util.List;

public class SimulatorTest {



    public static void main(String args[]){

        // create item
        Item item=new Item( "milk",ItemCondition.USED, 4.0, 1 );
        Item item2=new Item( "flour",ItemCondition.NEW, 1.0, 2 );
        Item item3=new Item( "rice",ItemCondition.NEW, 1.0, 2);
        Item item4=new Item( "grouce",ItemCondition.USED, 1.0, 1 );
        Item item5=new Item( "bread",ItemCondition.USED, 1.0, 1 );
        Item item6=new Item( "orange juice",ItemCondition.USED, 2.0, 1 );
        Item item7=new Item( "apple juice",ItemCondition.USED, 1.0, 2 );
        Item item8=new Item( "carrot juice",ItemCondition.USED, 1.0, 1 );
        Item item9=new Item( "cake",ItemCondition.NEW, 3.0, 6 );

        // create warehouses



        FulfillmentCenterContainer fulfillmentCenterContainer1= new FulfillmentCenterContainer();


        fulfillmentCenterContainer1.addCenter("warehouse1",50);
        fulfillmentCenterContainer1.addCenter("warehouse2", 90);


        // add warehouses to containers

        fulfillmentCenterContainer1.warehouses.get("warehouse1").addProduct(item2);
        fulfillmentCenterContainer1.warehouses.get("warehouse1").addProduct(item2);
        fulfillmentCenterContainer1.warehouses.get("warehouse1").addProduct(item3);
        fulfillmentCenterContainer1.warehouses.get("warehouse1").addProduct(item3);
        fulfillmentCenterContainer1.warehouses.get("warehouse1").addProduct(item4);
        fulfillmentCenterContainer1.warehouses.get("warehouse1").addProduct(item4);
        fulfillmentCenterContainer1.warehouses.get("warehouse1").addProduct(item5);
        fulfillmentCenterContainer1.warehouses.get("warehouse1").addProduct(item6);
        fulfillmentCenterContainer1.warehouses.get("warehouse1").addProduct(item7);
        fulfillmentCenterContainer1.warehouses.get("warehouse1").addProduct(item8);
        fulfillmentCenterContainer1.warehouses.get("warehouse1").addProduct(item9);
        fulfillmentCenterContainer1.warehouses.get("warehouse2").addProduct(item);
        fulfillmentCenterContainer1.warehouses.get("warehouse2").addProduct(item);
        fulfillmentCenterContainer1.warehouses.get("warehouse2").addProduct(item2);
        fulfillmentCenterContainer1.warehouses.get("warehouse2").addProduct(item3);

        // print item in warehouses
        System.out.println("Item in warehouse1 ");
        fulfillmentCenterContainer1.warehouses.get("warehouse1").summary();
        System.out.println("Item in warehouse2 ");
        fulfillmentCenterContainer1.warehouses.get("warehouse2").summary();
        // sort by name
        System.out.println();
        System.out.println("Item sort by name in warehouse1: ");
        fulfillmentCenterContainer1.warehouses.get("warehouse1").sortByName();
        fulfillmentCenterContainer1.warehouses.get("warehouse1").summary();
        // sort by aumount
        System.out.println();
        System.out.println("Item sort by amount in warehouse1: ");
        fulfillmentCenterContainer1.warehouses.get("warehouse1").sortByAmount();
        fulfillmentCenterContainer1.warehouses.get("warehouse1").summary();
        // count condition
        System.out.println();
        System.out.println("USED condition in warehouse1 ");
        System.out.println(fulfillmentCenterContainer1.warehouses.get("warehouse1").countByCondition(ItemCondition.USED));

        // capacity and number
        System.out.println();
        System.out.println("Max capacity in warehouse1: ");
        System.out.println( fulfillmentCenterContainer1.warehouses.get("warehouse1").getCapacity());
        System.out.println("Capacity in warehouse1 now: ");
       System.out.println( fulfillmentCenterContainer1.warehouses.get("warehouse1").globalCapacity);
       // max
        System.out.println();
        System.out.println("Product with the largest number ");
        fulfillmentCenterContainer1.warehouses.get("warehouse1").max().print();

       //search
        System.out.println();
        System.out.println("Search item by name(bread): ");
        fulfillmentCenterContainer1.warehouses.get("warehouse1").search("bread").print();
        //search partial
        System.out.println();
        System.out.println("Search all items by partial name(juice): ");
        for(Item s:fulfillmentCenterContainer1.warehouses.get("warehouse1").searchPartial("juice")){
            s.print();
        }

       //get product
        System.out.println();
        System.out.println("Before reduction: ");
        fulfillmentCenterContainer1.warehouses.get("warehouse1").summary();
        System.out.println();
        System.out.println("After reduction grouce and orange juice  in warehouse1: ");
        fulfillmentCenterContainer1.warehouses.get("warehouse1").getProduct(item4);
        fulfillmentCenterContainer1.warehouses.get("warehouse1").getProduct(item6);
        fulfillmentCenterContainer1.warehouses.get("warehouse1").summary();

        // remove item
        System.out.println();
        System.out.println("And after delete rice: ");
        fulfillmentCenterContainer1.warehouses.get("warehouse1").removeProduct(item3);
        fulfillmentCenterContainer1.warehouses.get("warehouse1").summary();
        System.out.println("Capacity in warehouse1 now: ");
        System.out.println( fulfillmentCenterContainer1.warehouses.get("warehouse1").globalCapacity);

       // empty warehouse
        System.out.println();
       FulfillmentCenter warehouse=new FulfillmentCenter("warehouse4",20.0);
        fulfillmentCenterContainer1.addCenter(warehouse);
        fulfillmentCenterContainer1.addCenter("warehouse5",20);


        System.out.println("All empty warehouses in fulfillmentCenterContainer1: ");
        for(FulfillmentCenter x: fulfillmentCenterContainer1.findEmpty()){

            System.out.println(x.getName());

        }

            //sumary list of warehouse
        System.out.println();
        System.out.println("Summary of the warehouses capacity ");
        fulfillmentCenterContainer1.summary();
        // remove warehouse
        System.out.println();
        System.out.println("Summary of the warehouses capacity after delete  warehouse2");
        fulfillmentCenterContainer1.removeCenter("warehouse2");
        fulfillmentCenterContainer1.summary();










    }
}
