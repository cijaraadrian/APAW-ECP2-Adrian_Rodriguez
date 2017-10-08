package api.daos.memory;

import java.util.HashMap;
import api.daos.InvoiceDao;
import api.entities.Invoice;
import api.daos.memory.GenericDaoMemory;

public class InvoiceDaoMemory extends GenericDaoMemory<Invoice> implements InvoiceDao {

    public InvoiceDaoMemory() {
        this.setMap(new HashMap<Integer, Invoice>());
    }

    @Override
    protected Integer getId(Invoice entity) {
        return entity.GetId();
    }

    @Override
    protected void setId(Invoice entity, Integer id) {
        entity.SetId(id);

    }

}
