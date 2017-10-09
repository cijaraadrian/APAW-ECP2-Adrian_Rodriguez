package api.dtos;

import java.util.List;

import api.entities.Invoice;

public class InvoiceShoppingListDto {

    private InvoiceDto invoiceDto;

    private List<Integer> shoppingList;

    public InvoiceShoppingListDto() {
    }

    public InvoiceShoppingListDto(Invoice invoice, List<Integer> shoppingList) {
        invoiceDto = new InvoiceDto(invoice);
        this.shoppingList = shoppingList;
    }

    public InvoiceDto getInvoiceDto() {
        return invoiceDto;
    }

    public List<Integer> getShopping() {
        return shoppingList;
    }

    @Override
    public String toString() {
        return "{" + invoiceDto + "," + shoppingList + "}";
    }

}
