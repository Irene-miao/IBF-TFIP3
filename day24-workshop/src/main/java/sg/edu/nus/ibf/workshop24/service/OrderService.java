package sg.edu.nus.ibf.workshop24.service;

import java.util.Random;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.nus.ibf.workshop24.exception.OrderException;
import sg.edu.nus.ibf.workshop24.model.FruitProducts;
import sg.edu.nus.ibf.workshop24.model.PurchaseOrder;
import sg.edu.nus.ibf.workshop24.repository.LineItemsRepository;
import sg.edu.nus.ibf.workshop24.repository.PurchaseOrderRepository;

@Service
public class OrderService {
    
    LineItemsRepository lineItemRepo;
    PurchaseOrderRepository purchaseOrderRepo;

    OrderService(LineItemsRepository lineItemRepo, PurchaseOrderRepository purchaseOrderRepo){
        this.lineItemRepo = lineItemRepo;
        this.purchaseOrderRepo = purchaseOrderRepo;
    }


    // if any operation fail, revert data to original
    // prevent another operation to interfere with this operation
    @Transactional(rollbackFor = OrderException.class)
    public void createOrder(PurchaseOrder purchaseOrder) throws OrderException {
       
        // create order id
        Random rand = new Random();
        int ordId = rand.nextInt(10000000);
        String orderId = String.valueOf(ordId);

        purchaseOrder.setOrderId(ordId);
        FruitProducts.fruitProducts = lineItemRepo.getProducts();

        purchaseOrderRepo.insertPurchaseOrder(purchaseOrder);
        
        if (purchaseOrder.getLineItems().size() > 5){
            throw new OrderException("can not order more than 5 items");
        }

        //  save purchase order items to repo
        lineItemRepo.addLineItems(purchaseOrder.getLineItems(), orderId);
    }
   



}
