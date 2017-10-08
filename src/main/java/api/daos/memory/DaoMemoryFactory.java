package api.daos.memory;

import api.daos.DaoFactory;
import api.daos.InvoiceDao;

public class DaoMemoryFactory extends DaoFactory {

    private InvoiceDao invoiceDao;

    public InvoiceDao getInvoiceDao() {
        if (invoiceDao == null) {
            invoiceDao = new InvoiceDaoMemory();
        }
        return invoiceDao;

    }
}
