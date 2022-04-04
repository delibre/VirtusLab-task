package com.virtuslab.internship.discount;

import com.virtuslab.internship.receipt.Receipt;


public class Discount {
    public Receipt apply(Receipt receipt) {
        var discount10 = new TenPercentDiscount();
        var discount15 = new FifteenPercentDiscount();

        var receiptAfterDiscount15 = discount15.apply(receipt);

        return discount10.apply(receiptAfterDiscount15);
    }
}
