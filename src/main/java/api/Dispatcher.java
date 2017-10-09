package api;


import api.resource.InvoiceResource;
import api.resource.exceptions.RequestInvalidException;
import http.HttpRequest;
import http.HttpResponse;
import http.HttpStatus;

public class Dispatcher {

    private InvoiceResource invoiceResource = new InvoiceResource();

    private void responseError(HttpResponse response, Exception e) {
        response.setBody("{\"error\":\"" + e + "\"}");
        response.setStatus(HttpStatus.BAD_REQUEST);
    }

    public void doPost(HttpRequest request, HttpResponse response) {
        try {
            if (request.isEqualsPath(invoiceResource.INVOICE)) {
                    invoiceResource.createInvoice(request.getBody());
                response.setStatus(HttpStatus.CREATED);
            } else {
                throw new RequestInvalidException(request.getPath());
            }
        } catch (Exception e) {
            responseError(response, e);
        }
    }

}
