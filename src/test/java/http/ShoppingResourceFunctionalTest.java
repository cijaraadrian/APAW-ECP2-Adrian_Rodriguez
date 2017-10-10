package http;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import api.daos.DaoFactory;
import api.daos.memory.DaoMemoryFactory;
import api.resource.InvoiceResource;
import api.resource.ShoppingResource;

public class ShoppingResourceFunctionalTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
        new HttpRequest();
    }

    private void createInvoice() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(InvoiceResource.INVOICE).body("1").build();
        new HttpClientService().httpRequest(request);
    }

    private void createShopping() {
        this.createInvoice();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(ShoppingResource.SHOPPING).body("1:1").build();
        new HttpClientService().httpRequest(request);
        request = new HttpRequestBuilder().method(HttpMethod.POST).path(ShoppingResource.SHOPPING).body("1:2").build();
        new HttpClientService().httpRequest(request);
    }

    @Test
    public void testCreateShopping() {
        this.createShopping();
    }

    @Test
    public void testCreateShoppingInvalidException() {
        exception.expect(HttpException.class);
        this.createShopping();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(ShoppingResource.SHOPPING).body("1:0").build();
        new HttpClientService().httpRequest(request);
    }

    @Test
    public void testCreateShoppingIdInvoiceNotFoundException() {
        exception.expect(HttpException.class);
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(ShoppingResource.SHOPPING).body("6:4").build();
        new HttpClientService().httpRequest(request);
    }
    
    @Test
    public void testCreateShoppingIdInvoiceInvalidException() {
        exception.expect(HttpException.class);
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(ShoppingResource.SHOPPING).body("-1:8").build();
        new HttpClientService().httpRequest(request);
    }

    

}
