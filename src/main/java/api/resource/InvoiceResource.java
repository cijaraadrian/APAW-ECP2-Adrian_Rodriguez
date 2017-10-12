package api.resource;

import java.util.Optional;
import api.controllers.InvoiceController;
import api.dtos.InvoiceDto;
import api.resource.exceptions.InvoiceFieldInvalidException;
import api.resource.exceptions.InvoiceIdNotFoundException;
import api.resource.exceptions.InvoiceNameInvalidException;

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
        if (field == null || field.isEmpty() || Integer.parseInt(field) <= 0) {
            throw new InvoiceFieldInvalidException(field);
        }
    }

    private void validateName(String string) throws InvoiceNameInvalidException {
        if (string == null || string.isEmpty()) {
            throw new InvoiceNameInvalidException(string);
        }
    }

    public void PutInvoice(String idInvoice, String clientName) throws InvoiceFieldInvalidException, InvoiceNameInvalidException {
        this.validateField(idInvoice);
        this.validateName(clientName);
        new InvoiceController().PutInvoice(Integer.parseInt(idInvoice), clientName);
    }

    public void DeleteResource(Integer idInvoice) throws InvoiceFieldInvalidException {
        this.validateField(String.valueOf(idInvoice));
        new InvoiceController().deleteInvoice(idInvoice);
    }
}
