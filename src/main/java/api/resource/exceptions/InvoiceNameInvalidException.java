package api.resource.exceptions;

public class InvoiceNameInvalidException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public static final String DESCRIPTION = "The client name is empty";

    public InvoiceNameInvalidException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public InvoiceNameInvalidException() {
        this("");
    }

}
