package api.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Invoice {

    private int id;

    private double total;

    private String client;

    private Date date;

    public Invoice() {
    }

    public Invoice(int id, String client) {
        this.id = id;
        this.client = client;

    }

    public Invoice(int id) {
        this.id = id;
    }

    public void SetId(int id) {
        this.id = id;
    }

    public void SetTotal(double total) {
        this.total = total;
    }

    public void SetClient(String client) {
        this.client = client;
    }

    public void SetDate(Date date) {
        this.date = date;
    }

    public int GetId() {
        return this.id;
    }

    public double GetTotal() {
        return this.total;
    }

    public String GetClient() {
        return this.client;

    }

    public Date GetDate() {
        return this.date;
    }

    @Override
    public String toString() {
        String formattedDate = new SimpleDateFormat("HH:00 dd-MMM-yyyy ").format(date);
        return "Theme [id=" + id + ", client=" + client + ", date=" + formattedDate + ", total=" + total + "]";
    }

}
