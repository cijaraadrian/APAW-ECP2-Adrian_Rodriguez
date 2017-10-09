package api.resource.exceptions;

public class ShoppingInvalidException extends Exception {

    private static final long serialVersionUID = 1L;

    public static final String DESCRIPTION = "El valor del id de compra debe ser mayor que 0 ";

    public ShoppingInvalidException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public ShoppingInvalidException() {
        this("");
    }

}
