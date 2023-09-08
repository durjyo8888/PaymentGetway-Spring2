package com.example.Payment.Project.Service;

import com.example.Payment.Project.Model.Transaction;
import com.example.Payment.Project.Model.User;
import com.example.Payment.Project.Repository.TransactionRepository;
import com.example.Payment.Project.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    UserRepository userRepository;


    public Transaction addTransaction(int userId, int amount, int pin)throws Exception {
        Optional<User>optionalUser = userRepository.findById(userId);
        if(!optionalUser.isPresent()){
            throw new Exception("User not exist");
        }

        User user = optionalUser.get();
        Transaction transaction = new Transaction();

        transaction.setAmount(amount);
        transaction.setTime(new Date());

        if(user.getPin() == pin){
            transaction.setStatus(true);
            transaction.setAmountDeducted(true);
        }else{
            transaction.setStatus(false);
            transaction.setAmountDeducted(false);
        }
        transaction.setUser(user);

        transaction = transactionRepository.save(transaction);
        user.getTransactionList().add(transaction);
        userRepository.save(user);
//        transaction = transactionRepository.save(transaction);
        return transaction;
    }

    public int getSuccessfullyTransaction(int userId) throws Exception{
        Optional<User> optionalUser = userRepository.findById(userId);
        if(!optionalUser.isPresent()){
            throw new Exception("user not found");
        }
        int noOfSuccessTransaction = 0;

        User user = optionalUser.get();

        for(Transaction transaction : user.getTransactionList()){
            if(transaction.isStatus()){
                noOfSuccessTransaction++;
            }
        }
        return noOfSuccessTransaction;
    }

    public void deleteFailedTransaction() {
        for(User user : userRepository.findAll()){
            for(Transaction currTransaction : user.getTransactionList()){
                if(currTransaction.isStatus() == false){
                    transactionRepository.delete(currTransaction);
                }
            }
        }
    }
}
