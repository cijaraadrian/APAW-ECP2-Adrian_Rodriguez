package api.entitites;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import api.entities.Invoice;

public class InvoiceTest {

    @Test
    public void test() {
        Invoice invoice = new Invoice();
        assertEquals(0, invoice.GetId());
        assertEquals(null, invoice.GetClient());
        assertEquals(0, invoice.GetTotal(), 0);
        assertEquals(null, invoice.GetDate());
        Date date = new Date();
        invoice.SetId(100);
        invoice.SetClient("Client 100");
        invoice.SetDate(date);
        invoice.SetTotal(3400.90);

        assertEquals(100, invoice.GetId());
        assertEquals("Client 100", invoice.GetClient());
        assertEquals(date, invoice.GetDate());
        assertEquals(3400.90, invoice.GetTotal(), 3400.90);

    }

}
