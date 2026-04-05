package com.example.FinanceDataProcessing.FinanceProject.Controller;

import com.example.FinanceDataProcessing.FinanceProject.Service.DashBoardService.DashBoardInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/dashBoard")
public class DashBoardController {

    @Autowired
    private DashBoardInterface service;


    @GetMapping("/getTotalIncome")
    public ResponseEntity<Map<String,Long>> getTotalIncome()
    {
        return ResponseEntity.status(200).body(Map.of("total Income",service.getTotalIncome()));
    }

    @GetMapping("/getTotalExpenses")
    public ResponseEntity<Map<String,Long>> getTotalExpenses(){
        return ResponseEntity.status(200).body(Map.of("total Expenses",service.getTotalExpenses()));
    }

    @GetMapping("/getNetAmount")
    public ResponseEntity<Map<String,Long>> getNetAmount()
    {
        return ResponseEntity.status(200).body(Map.of("Net Amount",service.getNetAmount()));
    }

    @GetMapping("/categoryBasedTotal")
    public ResponseEntity<Map<String , Object>> categoryBasedTotal(@RequestParam String category){
        return ResponseEntity.status(200).body(Map.of("category",category,"total",service.getCategoryBasedTotal(category)));
    }


}
