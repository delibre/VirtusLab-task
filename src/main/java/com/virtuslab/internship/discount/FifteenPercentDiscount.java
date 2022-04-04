package com.virtuslab.internship.discount;

import com.virtuslab.internship.product.Product;
import com.virtuslab.internship.receipt.Receipt;
import com.virtuslab.internship.receipt.ReceiptEntry;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class FifteenPercentDiscount {

    public static String NAME = "FifteenPercentDiscount";

    public Receipt apply(Receipt receipt) {
        if (shouldApply(receipt)) {
            var totalPrice = receipt.totalPrice().multiply(BigDecimal.valueOf(0.85));
            var discounts = receipt.discounts();
            discounts.add(NAME);
            return new Receipt(receipt.entries(), discounts, totalPrice);
        }

        return receipt;
    }

    private boolean shouldApply(Receipt receipt) {
        Map<Product.Type, Integer> products = new HashMap<>();
        int productCounter = 0;
        for (ReceiptEntry value : receipt.entries()) {
            if (value.product().type().equals(Product.Type.GRAINS)){
                productCounter += value.quantity();
                products.put(value.product().type(), productCounter);
            }
        }

        return products.get(Product.Type.GRAINS) >= 3;
    }
}