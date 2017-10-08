package api.dtos;

import api.entities.Invoice;

public class InvoiceDto {

    private int id;

    private String client;

    public InvoiceDto() {
    }

    public InvoiceDto(Invoice invoice) {
        this.id = invoice.GetId();
        this.client = invoice.GetClient();
    }

    public void SetId(int id) {
        this.id = id;
    }

    public void SetClient(String client) {
        this.client = client;
    }

    public int GetId() {
        return this.id;
    }

    public String GetClient() {
        return this.client;
    }

    public String toString() {
        return "{\"id\":" + id + ",\"client\":\"" + client + "\"}";
    }

}
