package api.daos.memory;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import api.daos.DaoFactory;
import api.daos.memory.DaoMemoryFactory;
import api.entities.Invoice;

public class InvoiceDaoMemoryTest {

    private Invoice invoice;

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
        invoice = new Invoice();
        DaoFactory.getFactory().getInvoiceDao().create(invoice);
    }

    @Test
    public void testReadInvoice() {
        assertEquals(1, DaoFactory.getFactory().getInvoiceDao().read(1).GetId());
    }

    @Test
    public void testReadNonExistId() {
        assertNull(DaoFactory.getFactory().getInvoiceDao().read(2));
    }

}
