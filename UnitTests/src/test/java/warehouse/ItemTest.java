package warehouse;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;
import static warehouse.ItemCondition.USED;

public class ItemTest {

    Item item1;
    Item item2;
    Item item3;

    @Before
    public void setUp(){
        item1=new Item("item1", USED, 2.0, 3);
        item2=new Item("item1", USED, 2.0, 3);
        item3=new Item("item2", USED, 2.0, 3);

    }

    @Test
    public void compateToTestSchouldBeGood(){

        int result= item1.getName().compareTo(item2.getName());
        assertEquals(result,0);


    }
    @Test
    public void compareToTestScholudBeDifferent(){

        int result= item2.getName().compareTo(item3.getName());
        assertEquals(result,-1);


    }
    @Test
    public void schouldGetName(){

        String result=item1.getName();
        assertEquals(result,"item1");
    }

    @Test
    public void schouldGetNumber(){

        int result=item1.getNumber();
        assertEquals(result,3);
    }

    @Test

    public void schouldGetMass(){

        int result;
        result=(int)item1.getMass();

        assertEquals(result, 2);
    }

    @Test
    public void schouldGetCondition(){

        ItemCondition result=item1.getCondition();
        assertNotEquals(result,ItemCondition.NEW);
    }




}