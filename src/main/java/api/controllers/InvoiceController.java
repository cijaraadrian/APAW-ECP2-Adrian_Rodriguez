package api.controllers;

import java.util.Optional;

import api.daos.DaoFactory;
import api.dtos.InvoiceDto;
import api.entities.Invoice;

public class InvoiceController {

    public Optional<InvoiceDto> readInvoice(int invoiceId) {

        if (existInvoiceId(invoiceId)) {
            return Optional.of(new InvoiceDto(DaoFactory.getFactory().getInvoiceDao().read(invoiceId)));
        } else {
            return Optional.empty();
        }
    }

    public void createInvoice(int id) {
        DaoFactory.getFactory().getInvoiceDao().create(new Invoice(id));

    }

    private boolean existInvoiceId(int invoiceId) {
        return DaoFactory.getFactory().getInvoiceDao().read(invoiceId) != null;
    }

    public void createInvoice2(int id, String client) {
        DaoFactory.getFactory().getInvoiceDao().create(new Invoice(id, client));

    }

    public void PutInvoice(int idInvoice, String clientName) {
        DaoFactory.getFactory().getInvoiceDao().update(new Invoice(idInvoice, clientName));// TODO Auto-generated method stub

    }

    public void deleteInvoice(Integer idInvoice) {
        DaoFactory.getFactory().getInvoiceDao().deleteById(idInvoice);

    }

}
