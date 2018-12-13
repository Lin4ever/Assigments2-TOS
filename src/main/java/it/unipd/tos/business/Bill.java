////////////////////////////////////////////////////////////////////
// [Zhaohui] [Lin] [1144553]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.MenuItem;

import java.util.List;

public class Bill implements RestaurantBill{

    public double getOrderPrice(List<MenuItem> itemsOrdered) throws RestaurantBillException{
        double total=0;

        if(itemsOrdered.size()>20){
            throw new RestaurantBillException("Errore! ci sono più di 20 elementi nell'ordine");
        }
        long pizze = itemsOrdered.stream().filter(a -> a.getType().equals(MenuItem.itemType.PIZZA)).count();
        if(pizze>10){
            double min = itemsOrdered.get(0).getPrice();
            for (MenuItem m : itemsOrdered) {
                total += m.getPrice();
                if(m.getType().equals(MenuItem.itemType.PIZZA) && m.getPrice()<min){
                    min=m.getPrice();
                }
            }
            total -= min;
        }
        else {
            for (MenuItem m : itemsOrdered) {
                total += m.getPrice();
            }
        }

        if(total>100){
            total=total*0.95;
        }
        return total;
    }
}
