package com.example.FinanceDataProcessing.FinanceProject.Service.RecordService.RecordServiceImpl;

import com.example.FinanceDataProcessing.FinanceProject.Enums.Type;
import com.example.FinanceDataProcessing.FinanceProject.ExceptionHandling.ResourceNotFound;
import com.example.FinanceDataProcessing.FinanceProject.Model.Record;
import com.example.FinanceDataProcessing.FinanceProject.Repo.RecordRepo;
import com.example.FinanceDataProcessing.FinanceProject.Service.RecordService.RecordServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RecordServiceImplementation implements RecordServiceInterface {

    @Autowired
    private RecordRepo repo;

    @Override
    public Record createNewRecord(Record record) {
        return repo.save(record);
    }

    @Override
    public List<Record> getAllRecord() {
        return repo.findAll();
    }

    @Override
    public Record getRecordById(String recordId) {
        return repo.findById(recordId).orElseThrow(()-> new ResourceNotFound("This"+recordId+" Record Is Not Found"));
    }

    @Override
    public List<Record> getRecordByType(String type) {
        Type type1;

        try{
            type1 = Type.valueOf(type.toUpperCase());
        }
        catch(IllegalArgumentException e) {
            throw new IllegalArgumentException("This Type Do Not Exist :" + type);
        }
      return repo.findByType(type1);
    }

    @Override
    public List<Record> getRecordByCategory(String category) {
       return repo.findByCategory(category);
    }

    public List<Record> getRecordsByDate(LocalDate date) {
        return repo.findByDate(date);
    }

}
