package api.controllers;

import java.util.ArrayList;
import java.util.List;

import api.daos.DaoFactory;
import api.dtos.ShoppingDto;
import api.entities.Invoice;
import api.entities.Shopping;

public class ShoppingController {

    public boolean createShopping(int InvoiceId, int idShopping) {
        Invoice invoice = DaoFactory.getFactory().getInvoiceDao().read(InvoiceId);
        if (invoice != null) {
            DaoFactory.getFactory().getShoppingDao().create(new Shopping(invoice, idShopping));
            return true;
        } else {
            return false;
        }
    }

    public List<ShoppingDto> ShoppingList() {
        List<ShoppingDto> ShoppingDtoList = new ArrayList<>();
        List<Shopping> shopping = DaoFactory.getFactory().getShoppingDao().findAll();
        for (Shopping shop : shopping) {
            ShoppingDtoList.add(new ShoppingDto(shop));
        }
        return ShoppingDtoList;
    }

    public List<ShoppingDto> ShoppingList(int IdInvoice) {
        List<ShoppingDto> ShoppingDtoList = new ArrayList<>();
        List<Shopping> shopping = DaoFactory.getFactory().getShoppingDao().getListByIdInvoice(IdInvoice);

        for (Shopping shop : shopping) {
            ShoppingDtoList.add(new ShoppingDto(shop));
        }
        return ShoppingDtoList;
    }

}
