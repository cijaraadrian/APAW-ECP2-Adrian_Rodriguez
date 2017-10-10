package http;

import static org.junit.Assert.assertEquals;

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

    private HttpRequest request;

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
        request = new HttpRequest();
    }

    private void createInvoice() {
        request = new HttpRequestBuilder().method(HttpMethod.POST).path(InvoiceResource.INVOICE).body("1").build();
        new HttpClientService().httpRequest(request);
    }

    private void createShopping() {
        this.createInvoice();
        request = new HttpRequestBuilder().method(HttpMethod.POST).path(ShoppingResource.SHOPPING).body("1:1").build();
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
        request = new HttpRequestBuilder().method(HttpMethod.POST).path(ShoppingResource.SHOPPING).body("1:0").build();
        new HttpClientService().httpRequest(request);
    }

    @Test
    public void testCreateShoppingIdInvoiceNotFoundException() {
        exception.expect(HttpException.class);
        request = new HttpRequestBuilder().method(HttpMethod.POST).path(ShoppingResource.SHOPPING).body("6:4").build();
        new HttpClientService().httpRequest(request);
    }

    @Test
    public void testCreateShoppingIdInvoiceInvalidException() {
        exception.expect(HttpException.class);
        request = new HttpRequestBuilder().method(HttpMethod.POST).path(ShoppingResource.SHOPPING).body("-1:8").build();
        new HttpClientService().httpRequest(request);
    }

    @Test
    public void testGetShoppingListForIdInvoice() {
        this.createInvoice();
        this.createShopping();
        request = new HttpRequestBuilder().method(HttpMethod.GET).path(ShoppingResource.SHOPPING).body("1").build();
        assertEquals("[{\"clientInvoice\":\"null,\"idInvoice\":1,\"idShopping\":1}, {\"clientInvoice\":\"null,\"idInvoice\":1,\"idShopping\":2}]",
                new HttpClientService().httpRequest(request).getBody());

    }

    @Test
    public void testGetShoppingListForIdInvoiceInvalidException() {
        exception.expect(HttpException.class);
        request = new HttpRequestBuilder().method(HttpMethod.GET).path(ShoppingResource.SHOPPING).body("-1").build();
        new HttpClientService().httpRequest(request).getBody();
    }

}
