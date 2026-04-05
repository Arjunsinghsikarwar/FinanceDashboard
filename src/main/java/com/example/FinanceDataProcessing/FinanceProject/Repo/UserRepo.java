package com.example.FinanceDataProcessing.FinanceProject.Repo;

import com.example.FinanceDataProcessing.FinanceProject.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,String> {
    User findByUserName(String userName);
}
