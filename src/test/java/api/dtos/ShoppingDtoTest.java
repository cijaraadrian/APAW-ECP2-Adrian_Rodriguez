package api.dtos;

import static org.junit.Assert.*;

import org.junit.Test;

public class ShoppingDtoTest {

    @Test
    public void test() {

        ShoppingDto shoppingDto = new ShoppingDto();
        assertEquals(null, shoppingDto.getClientInvoice());
        assertEquals(0, shoppingDto.getIdInvoice());
        assertEquals(0, shoppingDto.getIdShopping());

        shoppingDto.setClientInvoice("Cliente");
        shoppingDto.setIdInvoice(1);
        shoppingDto.setIdShopping(3);
        assertEquals("Cliente", shoppingDto.getClientInvoice());
        assertEquals(1, shoppingDto.getIdInvoice());
        assertEquals(3, shoppingDto.getIdShopping());
    }

}
