package com.example.Payment.Project.Controller;

import com.example.Payment.Project.Model.Transaction;
import com.example.Payment.Project.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @PostMapping("/add-transaction")
    public ResponseEntity addTransaction(@RequestParam int userId, @RequestParam int amount, @RequestParam int pin) {
        try {
            Transaction transaction = transactionService.addTransaction(userId, amount, pin);
            return new ResponseEntity(transaction, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/get-successfully-transaction")
    public ResponseEntity getSuccessfullyTransaction(@RequestParam int userId){
        try{
            int noOfSuccessTransaction = transactionService.getSuccessfullyTransaction(userId);
            return new ResponseEntity(noOfSuccessTransaction,HttpStatus.FOUND);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete-failed-transaction")
    public ResponseEntity deleteFailedTransaction(){
        transactionService.deleteFailedTransaction();
        return new ResponseEntity("Delete all failed transaction",HttpStatus.OK);
    }
}
