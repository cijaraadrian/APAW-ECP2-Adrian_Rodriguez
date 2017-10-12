package api;

import api.resource.InvoiceResource;
import api.resource.ShoppingResource;
import api.resource.exceptions.RequestInvalidException;
import http.HttpRequest;
import http.HttpResponse;
import http.HttpStatus;

public class Dispatcher {

    private InvoiceResource invoiceResource = new InvoiceResource();

    private ShoppingResource shoppingResource = new ShoppingResource();

    private void responseError(HttpResponse response, Exception e) {
        response.setBody("{\"error\":\"" + e + "\"}");
        response.setStatus(HttpStatus.BAD_REQUEST);
    }

    public void doPost(HttpRequest request, HttpResponse response) {
        try {
            if (request.isEqualsPath(invoiceResource.INVOICE)) {
                invoiceResource.createInvoice(request.getBody());
                response.setStatus(HttpStatus.CREATED);
            } else if (request.isEqualsPath(ShoppingResource.SHOPPING)) {
                String invoiceId = request.getBody().split(":")[0];
                String shoppingId = request.getBody().split(":")[1];
                shoppingResource.createShopping(Integer.valueOf(invoiceId), Integer.valueOf(shoppingId));
                response.setStatus(HttpStatus.CREATED);
            } else {
                throw new RequestInvalidException(request.getPath());
            }
        } catch (Exception e) {
            responseError(response, e);
        }
    }

    public void doGet(HttpRequest request, HttpResponse response) {
        try {
            if (request.isEqualsPath(shoppingResource.SHOPPING)) {
                response.setBody(shoppingResource.shoppingList(Integer.valueOf(request.getBody())).toString());
            } else if (request.isEqualsPath(invoiceResource.INVOICE + invoiceResource.ID)) {
                response.setBody(invoiceResource.readInvoice(Integer.valueOf(request.paths()[1])).toString());
            } else {
                throw new RequestInvalidException(request.getPath());
            }
        } catch (Exception e) {
            responseError(response, e);
        }
    }

    public void doPut(HttpRequest request, HttpResponse response) {
        try {
            if (request.isEqualsPath(invoiceResource.INVOICE)) {
                String idInvoice = request.getBody().split(":")[0];
                String clientName = request.getBody().split(":")[1];
                invoiceResource.PutInvoice(idInvoice, clientName);

            } else {
                throw new RequestInvalidException(request.getPath());
            }
        } catch (Exception e) {
            responseError(response, e);
        }
    }

}
