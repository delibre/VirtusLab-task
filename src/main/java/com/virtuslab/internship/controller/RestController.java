package com.virtuslab.internship.controller;

import com.virtuslab.internship.basket.Basket;
import com.virtuslab.internship.receipt.Receipt;
import com.virtuslab.internship.receipt.ReceiptGenerator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @PostMapping("/get-receipt")
    public ResponseEntity<Receipt> getReceipt(@RequestBody Basket basket) {

        var receiptGenerator = new ReceiptGenerator();

        var receipt = receiptGenerator.generate(basket);

        return ResponseEntity.ok(receipt);
    }

}
