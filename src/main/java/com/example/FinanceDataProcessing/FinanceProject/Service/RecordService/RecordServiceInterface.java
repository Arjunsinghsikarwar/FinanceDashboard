package com.example.FinanceDataProcessing.FinanceProject.Service.RecordService;

import com.example.FinanceDataProcessing.FinanceProject.Model.Record;

import java.time.LocalDate;
import java.util.List;

public interface RecordServiceInterface {

    Record createNewRecord(Record record);
    List<Record> getAllRecord();
    Record getRecordById(String recordId);


    List<Record> getRecordByType(String type);

    List<Record> getRecordByCategory(String category);

    List<Record> getRecordsByDate(LocalDate date);
}
