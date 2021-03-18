package com.store.trade.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenerationTime;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Trades")
public class Trade {

    @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    private String tradeId;
    
    @Column(name ="version")
    private int version;
    
    @Column(name ="counterParty")
    private String counterParty;
    
    @Column(name ="bookId")
    private String bookId;
    
   @Column(name ="maturityDate")
    private LocalDate maturityDate;
    
   @Column(name ="createdDate")
    private LocalDate createdDate;
    
    
    @Column(name ="expiredFlag")
    private String expiredFlag;

    @CreationTimestamp
    private Date createdAt;
    
    
    @CreationTimestamp
    private Date updatedAt;
    
    
    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getCounterParty() {
        return counterParty;
    }

    public void setCounterParty(String counterParty) {
        this.counterParty = counterParty;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public LocalDate getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(LocalDate maturityDate) {
        this.maturityDate = maturityDate;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public String getExpiredFlag() {
        return expiredFlag;
    }

    public void setExpiredFlag(String expiredFlag) {
        this.expiredFlag = expiredFlag;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "tradeId='" + tradeId + '\'' +
                ", version=" + version +
                ", counterParty='" + counterParty + '\'' +
                ", bookId='" + bookId + '\'' +
                ", maturityDate=" + maturityDate +
                ", createdDate=" + createdDate +
                ", expiredFlag='" + expiredFlag + '\'' +
                '}';
    }
}
