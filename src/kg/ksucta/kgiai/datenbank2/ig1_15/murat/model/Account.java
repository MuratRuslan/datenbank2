package kg.ksucta.kgiai.datenbank2.ig1_15.murat.model;

import kg.ksucta.kgiai.datenbank2.ig1_15.murat.model.User;

public class Account {
    private Long id;
    private User user;
    private AccountType accountType;
    private Currency currency;
    private Float amount;

    public Account() {
    }

    public Account(User user, AccountType accountType, Currency currency) {
        this.user = user;
        this.accountType = accountType;
        this.currency = currency;
    }

    public Account(Long id, User user, AccountType accountType, Currency currency) {
        this.id = id;
        this.user = user;
        this.accountType = accountType;
        this.currency = currency;
    }

    public Account(Long id, User user, AccountType accountType, Currency currency, Float amount) {
        this.id = id;
        this.user = user;
        this.accountType = accountType;
        this.currency = currency;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }
}
