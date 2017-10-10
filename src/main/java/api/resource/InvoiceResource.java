package api.resource;

import java.util.Optional;
import api.controllers.InvoiceController;
import api.dtos.InvoiceDto;
import api.resource.exceptions.InvoiceFieldInvalidException;
import api.resource.exceptions.InvoiceIdNotFoundException;

public class InvoiceResource {

    public static final String INVOICE = "invoice";

    public static final String ID = "/{id}";

    public static final String ID_SHOPPING = ID + "/shoppings";

    public InvoiceDto readInvoice(int invoiceId) throws InvoiceIdNotFoundException, InvoiceFieldInvalidException {
        this.validateField(String.valueOf(invoiceId));
        Optional<InvoiceDto> optional = new InvoiceController().readInvoice(invoiceId);
        return optional.orElseThrow(() -> new InvoiceIdNotFoundException(Integer.toString(invoiceId)));
    }
    
    public void createInvoice(String idInvoice) throws InvoiceFieldInvalidException {
        this.validateField(idInvoice);
        new InvoiceController().createInvoice(Integer.parseInt(idInvoice));
    }
    
    private void validateField(String field) throws InvoiceFieldInvalidException {
        if (field == null || field.isEmpty() || Integer.parseInt(field) <= 0 ) {
            throw new InvoiceFieldInvalidException(field);
        }
    }
}
