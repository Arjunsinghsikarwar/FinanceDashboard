package com.example.FinanceDataProcessing.FinanceProject.Controller;

import com.example.FinanceDataProcessing.FinanceProject.Model.Record;
import com.example.FinanceDataProcessing.FinanceProject.Service.RecordService.RecordServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/record")
public class RecordController {

    @Autowired
    private RecordServiceInterface service;

    @PostMapping("/createNewRecord")
    public ResponseEntity<Record> createNewRecord(@RequestBody Record record)
    {
        return ResponseEntity.status(HttpStatus.OK).body(service.createNewRecord(record));
    }

    @GetMapping("/getAllRecord")
    public ResponseEntity<List<Record>> getAllRecord(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllRecord());
    }

    @GetMapping("/getRecordById/{recordId}")
    public ResponseEntity<Record> getRecordById(@PathVariable String recordId){
        return ResponseEntity.status(200).body(service.getRecordById(recordId));
    }

    // for /records?type=INCOME
    @GetMapping("/type")
    public ResponseEntity<List<Record>> getRecordByType(@RequestParam String type){
     List<Record> record = service.getRecordByType(type);
     return ResponseEntity.status(200).body(record);
    }

    @GetMapping("category")
    public ResponseEntity<List<Record>> getRecordByCategory(@RequestParam String category){
        List<Record> record = service.getRecordByCategory(category);
        return ResponseEntity.status(200).body(record);
    }

    @GetMapping("/by-date")
    public List<Record> getRecordsByDate(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
    ) {
        return service.getRecordsByDate(date);
    }


}
