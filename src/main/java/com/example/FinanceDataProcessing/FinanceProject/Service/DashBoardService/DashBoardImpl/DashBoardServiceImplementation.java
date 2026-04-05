package com.example.FinanceDataProcessing.FinanceProject.Service.DashBoardService.DashBoardImpl;

import com.example.FinanceDataProcessing.FinanceProject.Repo.RecordRepo;
import com.example.FinanceDataProcessing.FinanceProject.Service.DashBoardService.DashBoardInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashBoardServiceImplementation implements DashBoardInterface {

    @Autowired
    private RecordRepo repo;


    @Override
    public Long getTotalIncome() {
      Long value   = repo.findTotalByIncome();
      return value == null ? 0L : value;
    }

    @Override
    public Long getTotalExpenses() {
       Long value  = repo.findTotalByExpenses();
       return value == null ? 0L : value;
    }

    @Override
    public Long getNetAmount() {
        Long net = getTotalIncome() - getTotalExpenses();
        return net;
    }

    @Override
    public Long getCategoryBasedTotal(String category) {
       Long value = repo.getTotalByCategory(category);
       return value == null ? 0L : value;
    }
}

