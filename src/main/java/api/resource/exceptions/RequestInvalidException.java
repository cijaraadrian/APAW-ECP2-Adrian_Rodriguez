package api.resource.exceptions;

public class RequestInvalidException extends Exception {

    private static final long serialVersionUID = 1L;

    public static final String DESCRIPTION = "Petición no implementada";

    public RequestInvalidException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public RequestInvalidException() {
        this("");
    }

}
