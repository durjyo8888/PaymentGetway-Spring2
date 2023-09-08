package com.example.Payment.Project.Model;
//Refund = Amount, UserId, TransactionId

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table

public class Refund {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int refundId;
    int amount;
    int userId;
    int transactionId;
}
