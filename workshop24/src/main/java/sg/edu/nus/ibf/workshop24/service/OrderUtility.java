package sg.edu.nus.ibf.workshop24.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.stereotype.Component;

import sg.edu.nus.ibf.workshop24.model.FruitProducts;
import sg.edu.nus.ibf.workshop24.repository.LineItemsRepository;

@Component
public class OrderUtility {
    
    public static Object calculateUnitPrice(String product, Integer quantity){
        List<FruitProducts> fruitProducts = FruitProducts.fruitProducts;

        // Get standardPrice, discount save to BigDecimal variable
        BigDecimal standardPrice = new BigDecimal(0.0);
        BigDecimal discount = new BigDecimal(0.0);
        BigDecimal one = new BigDecimal(1);

             for (FruitProducts fruit: fruitProducts){
            if (fruit.getName().equalsIgnoreCase(product)){  // get product fruit name, price, discount
                standardPrice = fruit.getStandardPrice();
                discount = fruit.getDiscount();
                LineItemsRepository.discount  = discount;
        
            }
        }

        // count total price of product*quantity
        BigDecimal totalPrice = BigDecimal.valueOf(quantity).multiply(standardPrice);

        // count price - discount
        BigDecimal totalPriceAfterDiscount;
         if (discount.compareTo(BigDecimal.ONE) == 0) {
            totalPriceAfterDiscount = totalPrice;
         } else {
           totalPriceAfterDiscount = totalPrice.multiply(one.subtract(discount));

         }

         // count discountedPrice + tax
         BigDecimal totalPriceAfterTax = totalPriceAfterDiscount.add(totalPriceAfterDiscount.multiply(BigDecimal.valueOf(0.05)));

         totalPriceAfterTax = totalPriceAfterTax.setScale(2, RoundingMode.DOWN);
         totalPriceAfterTax = totalPriceAfterTax.stripTrailingZeros();
         System.out.println("Unit Price: " + totalPriceAfterTax);

         return totalPriceAfterTax;
         
         

    }
}
