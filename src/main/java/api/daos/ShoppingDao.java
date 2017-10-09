package api.daos;

import java.util.List;

import api.entities.Shopping;

public interface ShoppingDao extends GenericDao<Shopping, Integer> {
    List<Integer> findCostByInvoiceId(int invoiceId);
}
