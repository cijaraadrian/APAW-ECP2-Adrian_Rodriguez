package api.entities;

public class Shopping {

    private int id;

    private int amount;

    private double cost;

    private Invoice invoice;

    public Shopping() {

    }

    public Shopping(Invoice invoice, int idShopping) {
        this.invoice = invoice;
        this.id = idShopping;
    }

    public int GetId() {
        return this.id;

    }

    public int GetAmount() {
        return this.amount;
    }

    public double GetCost() {
        return this.cost;
    }

    public Invoice GetInvoice() {
        return this.invoice;
    }

    public void SetId(int id) {
        this.id = id;
    }

    public void SetAmount(int amount) {
        this.amount = amount;
    }

    public void SetCost(double cost) {
        this.cost = cost;
    }

    public void SetInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public String toString() {
        return "Shopping [id=" + id + ", Amount=" + amount + ", cost =" + cost + ", invoice=" + invoice + "]";
    }

}
