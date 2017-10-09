package api.daos.memory;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import api.daos.DaoFactory;
import api.entities.Invoice;
import api.entities.Shopping;


public class ShoppingDaoMemoryTest {
    
    private Invoice invoice;

    private Shopping shopping;
    
    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
        invoice = new Invoice(1,"Cliente 1");
        shopping = new Shopping(invoice, 1);
        shopping.SetCost(200);
        DaoFactory.getFactory().getShoppingDao().create(shopping);

    }

    @Test
    public void testFindValueByInvoiceId() {
        assertEquals(1, DaoFactory.getFactory().getShoppingDao().findCostByInvoiceId(invoice.GetId()).size());
        assertEquals(200, DaoFactory.getFactory().getShoppingDao().findCostByInvoiceId(invoice.GetId()).get(0).intValue());
    }

}
