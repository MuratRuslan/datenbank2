package kg.ksucta.kgiai.datenbank2.ig1_15.murat.dao.repository.impl;

import kg.ksucta.kgiai.datenbank2.ig1_15.murat.dao.repository.AbstractRepository;
import kg.ksucta.kgiai.datenbank2.ig1_15.murat.dao.repository.AccountRepository;
import kg.ksucta.kgiai.datenbank2.ig1_15.murat.dao.repository.AccountTypeRepository;
import kg.ksucta.kgiai.datenbank2.ig1_15.murat.model.Account;
import kg.ksucta.kgiai.datenbank2.ig1_15.murat.model.AccountType;
import kg.ksucta.kgiai.datenbank2.ig1_15.murat.model.Currency;
import kg.ksucta.kgiai.datenbank2.ig1_15.murat.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRepositoryImpl extends AbstractRepository<Account, Long> implements AccountRepository {
    private static AccountRepositoryImpl ourInstance = new AccountRepositoryImpl("account");

    public static AccountRepositoryImpl getInstance() {
        return ourInstance;
    }

    private AccountRepositoryImpl(String tableName) {
        super(tableName);
    }

    @Override
    protected Account getBindClass(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong("id");
        User user = UserRepositoryImpl.getInstance().findOne(resultSet.getLong("user_id"));
        Currency currency = CurrencyRepositoryImpl.getInstance().findOne(resultSet.getLong("currency_d"));
        AccountType accountType = AccountTypeRepositoryImpl.getInstance().findOne(resultSet.getLong("type_id"));
        Float amount = resultSet.getFloat("amount");
        return new Account(id, user, accountType, currency, amount);
    }

    @Override
    protected String commaSeparatedValuesFor(Account clas) {
        return String.format("null, %d, %d, %d, %f",
                clas.getUser().getId(), clas.getAccountType().getId(),
                clas.getCurrency().getId(), clas.getAmount());
    }
}
