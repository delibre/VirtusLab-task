package com.virtuslab.internship.receipt;

import com.virtuslab.internship.basket.Basket;
import com.virtuslab.internship.product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReceiptGenerator {

    public Receipt generate(Basket basket) {
        List<ReceiptEntry> receiptEntries = new ArrayList<>();

        Map<Product, Integer> products = new HashMap<>();
        for (Product value : basket.getProducts()) {
            if (products.containsKey(value)) {
                Integer valueCounter = products.get(value);
                valueCounter++;
                products.put(value, valueCounter);
            } else {
                products.put(value, 1);
            }
        }

        for(Map.Entry<Product, Integer> value : products.entrySet()){
            receiptEntries.add(new ReceiptEntry(value.getKey(), value.getValue()));
        }

        return new Receipt(receiptEntries);
    }
}
