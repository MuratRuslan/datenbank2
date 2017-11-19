package kg.ksucta.kgiai.datenbank2.ig1_15.murat.dao.repository.impl;

import kg.ksucta.kgiai.datenbank2.ig1_15.murat.dao.repository.AbstractRepository;
import kg.ksucta.kgiai.datenbank2.ig1_15.murat.dao.repository.TransactionRepository;
import kg.ksucta.kgiai.datenbank2.ig1_15.murat.model.Account;
import kg.ksucta.kgiai.datenbank2.ig1_15.murat.model.Transaction;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TransactionRepositoryImpl extends AbstractRepository<Transaction, Long> implements TransactionRepository {
    private static TransactionRepositoryImpl ourInstance = new TransactionRepositoryImpl("transaction");

    public static TransactionRepositoryImpl getInstance() {
        return ourInstance;
    }

    public TransactionRepositoryImpl(String tableName) {
        super(tableName);
    }

    @Override
    protected Transaction getBindClass(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong("id");
        Account from = AccountRepositoryImpl.getInstance().findOne(resultSet.getLong("from_account"));
        Account to = AccountRepositoryImpl.getInstance().findOne(resultSet.getLong("to_account"));
        Float amount = resultSet.getFloat("amount");
        Date date = resultSet.getDate("date");
        return new Transaction(id, date, from, to, amount);
    }

    @Override
    protected String commaSeparatedValuesFor(Transaction clas) {
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(clas.getDate());
        return String.format("null, '%s', %d, %d, %f",
                date, clas.getFrom().getId(),
                clas.getTo().getId(), clas.getAmount());
    }
}
