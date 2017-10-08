package api.dtos;

public class InvoiceDto {

    private int id;

    private String client;

    public InvoiceDto() {
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
