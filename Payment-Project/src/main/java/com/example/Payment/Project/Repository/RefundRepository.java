package com.example.Payment.Project.Repository;

import com.example.Payment.Project.Model.Refund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefundRepository extends JpaRepository<Refund,Integer> {
}
