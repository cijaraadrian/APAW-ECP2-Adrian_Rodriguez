package api.daos.memory;

import api.daos.DaoFactory;
import api.daos.InvoiceDao;
import api.daos.ShoppingDao;

public class DaoMemoryFactory extends DaoFactory {

    private InvoiceDao invoiceDao;
    
    private ShoppingDao shoppingDao;

    public InvoiceDao getInvoiceDao() {
        if (invoiceDao == null) {
            invoiceDao = new InvoiceDaoMemory();
        }
        return invoiceDao;

    }

    @Override
    public ShoppingDao getShoppingDao() {
        if (shoppingDao == null) {
            shoppingDao = new ShoppingDaoMemory();// TODO Auto-generated method stub
        }
        return shoppingDao;
    }
}
