package kg.ksucta.kgiai.datenbank2.ig1_15.murat.dao.repository.impl;

import kg.ksucta.kgiai.datenbank2.ig1_15.murat.dao.repository.AbstractRepository;
import kg.ksucta.kgiai.datenbank2.ig1_15.murat.dao.repository.AccountTypeRepository;
import kg.ksucta.kgiai.datenbank2.ig1_15.murat.model.AccountType;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountTypeRepositoryImpl extends AbstractRepository<AccountType, Long> implements AccountTypeRepository {
    private static AccountTypeRepositoryImpl ourInstance = new AccountTypeRepositoryImpl("account_type");

    public AccountTypeRepositoryImpl(String tableName) {
        super(tableName);
    }

    public static AccountTypeRepositoryImpl getInstance() {
        return ourInstance;
    }


    @Override
    protected AccountType getBindClass(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        return new AccountType(id, name);
    }

    @Override
    protected String commaSeparatedValuesFor(AccountType clas) {
        return String.format("null, '%s'", clas.getName());
    }
}
