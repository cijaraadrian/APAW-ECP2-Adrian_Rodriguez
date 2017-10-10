package api.resource.exceptions;

public class InvoiceFieldInvalidException extends Exception {

    private static final long serialVersionUID = 1L;

    public static final String DESCRIPTION = "Id del invoice no encontrado";

    public InvoiceFieldInvalidException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public InvoiceFieldInvalidException() {
        this("");
    }

}
