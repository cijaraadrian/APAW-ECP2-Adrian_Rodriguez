package api.daos.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import api.daos.ShoppingDao;
import api.entities.Shopping;

public class ShoppingDaoMemory extends GenericDaoMemory<Shopping> implements ShoppingDao {

    public ShoppingDaoMemory() {
        this.setMap(new HashMap<Integer, Shopping>());
    }

    @Override
    public List<Integer> findCostByInvoiceId(int invoiceId) {
        List<Shopping> shopping = this.findAll();
        List<Integer> shoppingCost = new ArrayList<>();
        for (Shopping shop : shopping) {
            if (shop.GetInvoice().GetId() == invoiceId) {
                shoppingCost.add((int) shop.GetCost());
            }
        }
        return shoppingCost;
    }

    @Override
    protected Integer getId(Shopping entity) {
        // TODO Auto-generated method stub
        return entity.GetId();
    }

    @Override
    protected void setId(Shopping entity, Integer id) {
        // TODO Auto-generated method stub
        entity.SetId(id);

    }

}
