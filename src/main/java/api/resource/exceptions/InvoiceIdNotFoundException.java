package api.resource.exceptions;

public class InvoiceIdNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    public static final String DESCRIPTION = "The id of invoice no exists";

    public InvoiceIdNotFoundException() {
        this("");
    }

    public InvoiceIdNotFoundException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

}
