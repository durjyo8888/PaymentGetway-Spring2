package com.example.Payment.Project.Repository;

import com.example.Payment.Project.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserRepository extends JpaRepository<User,Integer>{
}
