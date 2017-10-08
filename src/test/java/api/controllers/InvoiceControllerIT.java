package api.controllers;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import api.daos.DaoFactory;
import api.daos.memory.DaoMemoryFactory;

public class InvoiceControllerIT {

    private InvoiceController invoiceController;

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
        invoiceController = new InvoiceController();
        invoiceController.createInvoice2(1, "Cliente");
    }

    @Test
    public void testReadInvoice() {
        assertEquals(1, invoiceController.readInvoice(1).get().GetId());
        assertEquals("Cliente", invoiceController.readInvoice(1).get().GetClient());
    }

    @Test
    public void testReadInvoiceNonExistId() {
        assertEquals(Optional.empty(), invoiceController.readInvoice(300));
    }

}
