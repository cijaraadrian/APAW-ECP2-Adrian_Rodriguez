package api.dtos;

import static org.junit.Assert.*;

import org.junit.Test;

public class InvoiceDtoTest {

    @Test
    public void test() {
        InvoiceDto invoice = new InvoiceDto();
        assertEquals(0, invoice.GetId());
        assertEquals(null, invoice.GetClient());
        invoice.SetId(1);
        assertEquals(1, invoice.GetId());
        assertEquals(null, invoice.GetClient());
        invoice.SetClient("CLIENT 1");
        assertEquals("CLIENT 1", invoice.GetClient());

    }

}
