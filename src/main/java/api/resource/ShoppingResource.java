package api.resource;

import java.util.List;

import api.controllers.ShoppingController;
import api.dtos.ShoppingDto;
import api.resource.exceptions.InvoiceIdNotFoundException;
import api.resource.exceptions.ShoppingInvalidException;

public class ShoppingResource {
    public static final String SHOPPING = "shopping";

    public void createShopping(int InvoiceId, int IdShopping) throws ShoppingInvalidException, InvoiceIdNotFoundException {
        if (IdShopping <= 0) {
            throw new ShoppingInvalidException(Integer.toString(IdShopping));
        } else if (InvoiceId <= 0) {
            throw new InvoiceIdNotFoundException(Integer.toString(InvoiceId));
        } else {
            if (!new ShoppingController().createShopping(InvoiceId, IdShopping)) {
                throw new InvoiceIdNotFoundException(Integer.toString(IdShopping));
            }
        }
    }

    public List<ShoppingDto> shoppingList() {
        return new ShoppingController().ShoppingList();
    }

    public List<ShoppingDto> shoppingList(int idInvoice) throws InvoiceIdNotFoundException {
        if (idInvoice <= 0) {
            throw new InvoiceIdNotFoundException(Integer.toString(idInvoice));
        } else {
            return new ShoppingController().ShoppingList(idInvoice);
        }
    }
}
