package com.example.Payment.Project.Service;

import com.example.Payment.Project.Model.Refund;
import com.example.Payment.Project.Model.User;
import com.example.Payment.Project.Repository.RefundRepository;
import com.example.Payment.Project.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RefundRepository refundRepository;

    public User addUser(User user) {
        user.setTransactionList(new ArrayList<>());
       User savedUser =  userRepository.save(user);
       return savedUser;
    }

    public int getMaxRefund() {
        int id = 0;
        int maxRefund = 0;
        for(Refund refund : refundRepository.findAll()){
            if(maxRefund < refund.getAmount()){
                maxRefund = refund.getAmount();
                id = refund.getUserId();
            }
        }
        return id;
    }
}
