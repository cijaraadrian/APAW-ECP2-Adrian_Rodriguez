package api.entitites;

import static org.junit.Assert.*;

import org.junit.Test;

import api.entities.Invoice;
import api.entities.Shopping;

public class ShoppingTest {

    @Test
    public void test() {
        Shopping shopping = new Shopping();
        assertEquals(0, shopping.GetId());
        assertEquals(0, shopping.GetAmount());
        assertEquals(0, shopping.GetCost(), 0);
        assertEquals(null, shopping.GetInvoice());

        Invoice invoice = new Invoice();
        shopping.SetId(1);
        shopping.SetAmount(1);
        shopping.SetInvoice(invoice);
        assertEquals(1, shopping.GetId());
        assertEquals(1, shopping.GetAmount());
        assertEquals(invoice, shopping.GetInvoice());

    }

}
