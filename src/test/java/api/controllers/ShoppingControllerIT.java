package api.controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import api.daos.DaoFactory;
import api.daos.memory.DaoMemoryFactory;

public class ShoppingControllerIT {

    private ShoppingController shoppingController;

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
        shoppingController = new ShoppingController();
    }

    @Test
    public void testCreateShoppingAndShoppingList() {
        new InvoiceController().createInvoice2(1, "Cliente 2");
        shoppingController.createShopping(1, 1);
        shoppingController.createShopping(1, 2);
        assertEquals(2, shoppingController.ShoppingList().size());
        assertEquals("Cliente 2", shoppingController.ShoppingList().get(0).getClientInvoice());
        assertEquals(1, shoppingController.ShoppingList().get(0).getIdShopping());
        assertEquals(2, shoppingController.ShoppingList().get(1).getIdShopping());
    }

    @Test
    public void testCreateShoppingNonExistentId() {
        new ShoppingController().createShopping(1, 1);
        assertFalse(shoppingController.createShopping(-1, 1));
    }

}
