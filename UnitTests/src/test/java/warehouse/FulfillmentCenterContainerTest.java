package warehouse;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class FulfillmentCenterContainerTest {

    FulfillmentCenterContainer fulfillmentCenterContainer;
    FulfillmentCenter warehouse;
    FulfillmentCenter warehouse2 ;
    Item item;
    Item item2;
    @Before
    public void setUp(){
        FulfillmentCenter warehouse = new FulfillmentCenter("ware1", 100);
        FulfillmentCenter warehouse2 = new FulfillmentCenter("ware2", 100);
        item = new Item("item1", ItemCondition.NEW, 2.0, 3 );
        item2 = new Item("item1", ItemCondition.NEW, 2.0, 4 );

        fulfillmentCenterContainer= new FulfillmentCenterContainer();
        fulfillmentCenterContainer.addCenter(warehouse);
        fulfillmentCenterContainer.addCenter(warehouse2);
        warehouse.addProduct(item2);
        warehouse2.addProduct(item);
    }


    @Test
    public void returnEmptyWarehouses(){
        List< FulfillmentCenter > result;
        result=fulfillmentCenterContainer.findEmpty();
        List< FulfillmentCenter > result1 = new ArrayList<>();
        assertEquals(result, result1);


    }
    @Test
    public void schouldAddContainerTest(){
        int size=fulfillmentCenterContainer.warehouses.size();
        Item item3 = new Item("check", ItemCondition.NEW, 200, 3);
        FulfillmentCenter full =new FulfillmentCenter("checkWare", 200);
        full.addProduct(item3);
        fulfillmentCenterContainer.addCenter(full);
        size++;

        assertEquals(size,3 );

    }

    @Test
    public void schouldRemoveContainerTest(){
        int size=fulfillmentCenterContainer.warehouses.size();
        Item item3 = new Item("check", ItemCondition.NEW, 200, 3);
        FulfillmentCenter full =new FulfillmentCenter("checkWare", 200);
        full.addProduct(item3);
        fulfillmentCenterContainer.removeCenter("checkWare");


        assertEquals(size,2 );

    }

}