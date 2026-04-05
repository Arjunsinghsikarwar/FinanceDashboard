package com.example.FinanceDataProcessing.FinanceProject.Repo;

import com.example.FinanceDataProcessing.FinanceProject.Enums.Type;
import com.example.FinanceDataProcessing.FinanceProject.Model.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RecordRepo extends JpaRepository<Record,String> {

    List<Record> findByType(Type type1);

    List<Record> findByCategory(String category);

    List<Record> findByDate(LocalDate date);

    @Query(value = "Select sum(amount) from record r where r.type = 'INCOME' ",nativeQuery = true)
    Long findTotalByIncome();

    @Query(value = "Select sum(amount) from record r where r.type = 'EXPENSE'",nativeQuery = true)
    Long findTotalByExpenses();

    @Query(value = "Select sum(amount) from record r where r.category = :category",nativeQuery = true)
    Long getTotalByCategory(@Param("category") String category);
}
