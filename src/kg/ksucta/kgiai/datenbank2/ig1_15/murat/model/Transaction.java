package kg.ksucta.kgiai.datenbank2.ig1_15.murat.model;

import java.util.Date;

public class Transaction {
    private Long id;
    private Date date;
    private Account from;
    private Account to;
    private Float amount;

    public Transaction() {
        date = new Date();
    }

    public Transaction(Account from, Account to, Float amount) {
        this();
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public Transaction(Long id, Date date, Account from, Account to, Float amount) {
        this.id = id;
        this.date = date;
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Account getFrom() {
        return from;
    }

    public void setFrom(Account from) {
        this.from = from;
    }

    public Account getTo() {
        return to;
    }

    public void setTo(Account to) {
        this.to = to;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }
}
