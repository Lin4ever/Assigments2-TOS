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
    @org.junit.Test
    public void testOrdinePiuDi10Elementi(){
        try {
            List<MenuItem> ordini = new ArrayList<MenuItem>();
            ordini.add(new MenuItem(MenuItem.itemType.PIZZA, "frutti di mare", 11.9));
            ordini.add(new MenuItem(MenuItem.itemType.PRIMO, "risotto al tartufo", 12.0));
            ordini.add(new MenuItem(MenuItem.itemType.PIZZA, "montanara", 9.5));
            ordini.add(new MenuItem(MenuItem.itemType.PIZZA, "capricciosa", 8.5));
            ordini.add(new MenuItem(MenuItem.itemType.PIZZA, "montanara", 9.5));
            ordini.add(new MenuItem(MenuItem.itemType.PIZZA, "tonno e cipolla", 4.5));
            ordini.add(new MenuItem(MenuItem.itemType.PIZZA, "marinara", 3));
			ordini.add(new MenuItem(MenuItem.itemType.PIZZA, "montanara", 9.5));
            ordini.add(new MenuItem(MenuItem.itemType.PIZZA, "tonno e cipolla", 4.5));
			ordini.add(new MenuItem(MenuItem.itemType.PIZZA, "capricciosa", 8.5));
            ordini.add(new MenuItem(MenuItem.itemType.PIZZA, "margherita", 3.5));
            ordini.add(new MenuItem(MenuItem.itemType.PIZZA, "capricciosa", 8.5));
            Bill b = new Bill();
            double tot = b.getOrderPrice(ordini);
            assertEquals(90.4, tot, 0.0);
        }
        catch(RestaurantBillException e){
            System.out.println(e.getMessage());
        }
    }
   
}
