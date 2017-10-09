package api.dtos;

import api.entities.Shopping;

public class ShoppingDto {

    private String clientInvoice;

    private int idInvoice;

    private int idShopping;

    public ShoppingDto() {
    }

    public ShoppingDto(Shopping shopping) {
        this.clientInvoice = shopping.GetInvoice().GetClient();
        this.idInvoice = shopping.GetInvoice().GetId();
        this.idShopping = shopping.GetId();

    }

    public String getClientInvoice() {
        return clientInvoice;
    }

    public void setClientInvoice(String clientInvoice) {
        this.clientInvoice = clientInvoice;
    }

    public int getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(int idInvoice) {
        this.idInvoice = idInvoice;
    }

    public int getIdShopping() {
        return idShopping;
    }

    public void setIdShopping(int idShopping) {
        this.idShopping = idShopping;
    }

    @Override
    public String toString() {
        return "{\"clientInvoice\":\"" + clientInvoice + ",\"idInvoice\":" + idInvoice + ",\"idShopping\":" + idShopping + "}";
    }

}
