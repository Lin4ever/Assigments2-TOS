////////////////////////////////////////////////////////////////////
// [Zhaohui] [Lin] [1144553]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business.exception;

public class RestaurantBillException extends Throwable{
    private String message;

    public RestaurantBillException(String m){
        message=m;
    }

    public String getMessage() {
        return message;
    }
}

