package com.example.Payment.Project.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

/*
* Create a payment gateway, User = UserId, Name, Email, AccountNumber, List<Transaction>
Transaction = TransactionId, UserId, Amount, Status, AmountDeducted, Time
*  Refund = Amount, UserId, TransactionId Description:
* A user can do multiple transactions. A transaction can be success or failed.
* Money can be deducted in case of failed transaction as well.
* POST API - Add a UserPOST API -
* Add a Transaction for a given amount
* */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int userId;
    String name;
    String email;
    String accountNo;

    int pin;
    @JsonIgnore
    @OneToMany(mappedBy = "user" ,cascade = CascadeType.ALL)
    List<Transaction> transactionList;
}
