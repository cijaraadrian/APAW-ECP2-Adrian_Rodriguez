package api.resource;

import java.util.Optional;
import api.controllers.InvoiceController;
import api.dtos.InvoiceDto;
import api.resource.exceptions.InvoiceIdNotFoundException;

public class InvoiceResource {

    public static final String INVOICE = "invoice";

    public static final String ID = "/{id}";

    public static final String ID_SHOPPING = ID + "/shoppings";

    public InvoiceDto readInvoice(int invoiceId) throws InvoiceIdNotFoundException {
        Optional<InvoiceDto> optional = new InvoiceController().readInvoice(invoiceId);
        return optional.orElseThrow(() -> new InvoiceIdNotFoundException(Integer.toString(invoiceId)));
    }
}
