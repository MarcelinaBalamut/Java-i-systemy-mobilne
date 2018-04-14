package warehouse;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FulfillmentCenterTest {
    private FulfillmentCenter fulfillmentCenter;
    private Item item;  // item at list
    private Item item2;  // item at list

    private Item itemTest;

   @Before
    public void setUp(){
       fulfillmentCenter=new FulfillmentCenter("nameWarehouse", 400.0);
       item = new Item("item1", ItemCondition.NEW, 2.0, 3 );
       item2 = new Item("item2", ItemCondition.NEW, 2.0, 4 );



        fulfillmentCenter.addProduct(item);
       fulfillmentCenter.addProduct(item2);

    }

    @Test

    public void shouldSearchItem(){

       itemTest=fulfillmentCenter.search("item1");
       assertEquals(itemTest, item);

    }
@Test
    public void schouldSearchPartialItem(){
       List<Item> result;
        result=fulfillmentCenter.searchPartial("ite");
       assertEquals(result.get(0), item);
    }
    @Test
    public void schouldCountConditions(){
        int result=fulfillmentCenter.countByCondition(ItemCondition.NEW);
        assertEquals(result, 7);
    }

    @Test
    public void schouldCountConditionsBad(){
        int result=fulfillmentCenter.countByCondition(ItemCondition.NEW);
        assertNotEquals(result, 5);
    }


    @Test
    public void schouldSortByName(){
        List< Item > result;
        result=fulfillmentCenter.sortByName();
        List< Item > result1 = new ArrayList<>();
        result1.add(item);
        result1.add( item2);
        assertEquals(result, result1);


    }
    @Test
    public void schouldSortByAmount(){
        List< Item > result;
        result=fulfillmentCenter.sortByAmount();
        List< Item > result1 = new ArrayList<>();
        result1.add(item2);
        result1.add( item);
        assertEquals(result, result1);


    }


    @Test
    public void schouldReturnItemanoutmacNumber(){
        Item result=fulfillmentCenter.max();
        assertEquals(result,item2 );
    }


    @Test(expected = IllegalArgumentException.class)
    public void schouldThrowExceptionWhenDeleteTheSameItem(){
       assertTrue(fulfillmentCenter.removeProduct(item2));
        fulfillmentCenter.removeProduct(item2);


    }

    @Test
    public void schouldThrowExceptionWhenDeleteTheSameItemAssertTrue(){
       assertTrue(  fulfillmentCenter.removeProduct(item2) );


    }
    @Test
    public void schouldAddProduct(){

        Item item3 = new Item("check", ItemCondition.NEW, 200, 3);
        FulfillmentCenter full =new FulfillmentCenter("checkWare", 200);
        int size=full.products.size();
        full.addProduct(item3);

        size++;

        assertEquals(size,1 );

    }
    @Test
    public void schouldAddProductIfNullName(){

        Item item3 = new Item("", ItemCondition.NEW, 200, 3);
        FulfillmentCenter full =new FulfillmentCenter("checkWare", 200);
        int size=full.products.size();
        full.addProduct(item3);


        assertEquals(size,0 );

    }

    @Test
    public void schouldGetCapacity(){

        int result=(int)fulfillmentCenter.getCapacity();
        assertEquals(result,400);
    }
    @Test
    public void schouldGetName(){

        String result=fulfillmentCenter.getName();
        assertEquals(result,"nameWarehouse");
    }



}