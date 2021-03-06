package http;

import org.junit.Before;
import org.junit.Test;

import api.daos.DaoFactory;
import api.daos.memory.DaoMemoryFactory;
import api.resource.InvoiceResource;


public class InvoiceResourceFunctionalTest {

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
    }
    
    private void createInvoice() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(InvoiceResource.INVOICE).body("1").build();
        new HttpClientService().httpRequest(request);
    }
    
    @Test
    public void testCreateInvoice() {
        this.createInvoice();
    }

    @Test(expected = HttpException.class)
    public void testCreateInvoiceBadId() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(InvoiceResource.INVOICE).body("-1").build();
        new HttpClientService().httpRequest(request);
    }
    
    
    @Test(expected = HttpException.class)
    public void testCreateEmptyInvoice() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(InvoiceResource.INVOICE).body("").build();
        new HttpClientService().httpRequest(request);
    }
    
    @Test(expected = HttpException.class)
    public void testCreateInvoiceWithString() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(InvoiceResource.INVOICE).body("Uno").build();
        new HttpClientService().httpRequest(request);
    }
    
    @Test
    public void testGetInvoiceById() {
        this.createInvoice();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(InvoiceResource.INVOICE)
                                                      .path(InvoiceResource.ID).expandPath("1").build();
        new HttpClientService().httpRequest(request);
    }
    
    @Test(expected = HttpException.class)
    public void testGetInvoiceByIdWithIncorrectId() {
        this.createInvoice();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(InvoiceResource.INVOICE)
                                                      .path(InvoiceResource.ID).expandPath("-1").build();
        new HttpClientService().httpRequest(request);
    }
    
    @Test(expected = HttpException.class)
    public void testGetInvoiceByIdNotExists() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(InvoiceResource.INVOICE)
                                                      .path(InvoiceResource.ID).expandPath("1").build();
        new HttpClientService().httpRequest(request);
    }
    
   @Test 
    public void testPutClientNameByIdInvoice() {
        this.createInvoice();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.PUT).path(InvoiceResource.INVOICE).body("1:UPM_CLIENT").build();
        new HttpClientService().httpRequest(request);
    }
   
   @Test(expected = HttpException.class)
   public void testPutClientNameByIdInvoiceWrongId() {
       this.createInvoice();
       HttpRequest request = new HttpRequestBuilder().method(HttpMethod.PUT).path(InvoiceResource.INVOICE).body("-1:UPM_CLIENT").build();
       new HttpClientService().httpRequest(request);
   }
   
   @Test(expected = HttpException.class)
   public void testPutClientNameByIdInvoiceEmptyName() {
       this.createInvoice();
       HttpRequest request = new HttpRequestBuilder().method(HttpMethod.PUT).path(InvoiceResource.INVOICE).body("1").build();
       new HttpClientService().httpRequest(request);
   }
   
   @Test 
   public void testDeleteInvoiceByIdInvoice() {
       this.createInvoice();
       HttpRequest request = new HttpRequestBuilder().method(HttpMethod.DELETE)
                                   .path(InvoiceResource.INVOICE).path(InvoiceResource.ID).expandPath("1").build();
       new HttpClientService().httpRequest(request);
   }
   
   @Test(expected = HttpException.class) 
   public void testDeleteInvoiceByIdInvoiceWorng() {
       this.createInvoice();
       HttpRequest request = new HttpRequestBuilder().method(HttpMethod.DELETE)
                                   .path(InvoiceResource.INVOICE).path(InvoiceResource.ID).expandPath("-2").build();
       new HttpClientService().httpRequest(request);
   }

    
}
