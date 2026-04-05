package com.example.FinanceDataProcessing.FinanceProject.Model;

import com.example.FinanceDataProcessing.FinanceProject.Enums.Type;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Record {

    @Id
    private String recordId;
    private Integer amount;
    @Enumerated(EnumType.STRING)
    private Type type;
    private String category;
    private LocalDate date ;
    private String notes;

    public Record() {
    }

    public Record(Integer amount, String category, LocalDate date, String notes, String recordId , Type type) {
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.notes = notes;
        this.type = type;
        this.recordId = recordId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
