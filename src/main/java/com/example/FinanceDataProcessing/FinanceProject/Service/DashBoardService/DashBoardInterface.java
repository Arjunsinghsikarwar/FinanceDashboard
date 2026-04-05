package com.example.FinanceDataProcessing.FinanceProject.Service.DashBoardService;

public interface DashBoardInterface {

    Long getTotalIncome();


    Long getTotalExpenses();

    Long getNetAmount();

    Long getCategoryBasedTotal(String category);
}
