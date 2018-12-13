////////////////////////////////////////////////////////////////////
// [Zhaohui] [Lin] [1144553]
////////////////////////////////////////////////////////////////////

package it.unipd.tos;

import it.unipd.tos.business.Bill;
import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.MenuItem;

import static org.junit.Assert.assertEquals;
import org.junit.rules.ExpectedException;

import java.util.List;
import java.util.ArrayList;


public class BillTest {

    @org.junit.Test
    public void testOrdineNormale(){
        try {
            List<MenuItem> ordini = new ArrayList<MenuItem>();
            ordini.add(new MenuItem(MenuItem.itemType.PRIMO, "risotto al radicchio", 12.0));
            ordini.add(new MenuItem(MenuItem.itemType.PRIMO, "risotto al tartufo", 12.0));
            ordini.add(new MenuItem(MenuItem.itemType.PIZZA, "capricciosa", 8.5));
            ordini.add(new MenuItem(MenuItem.itemType.PIZZA, "montanara", 9.5));
            Bill b = new Bill();
            double tot = b.getOrderPrice(ordini);
            assertEquals(42.0, tot, 0.0);
        }
        catch(RestaurantBillException e){
            System.out.println(e.getMessage());
        }
    }
   
}
