package kg.ksucta.kgiai.datenbank2.ig1_15.murat.dao.repository.impl;

import kg.ksucta.kgiai.datenbank2.ig1_15.murat.dao.repository.AbstractRepository;
import kg.ksucta.kgiai.datenbank2.ig1_15.murat.dao.repository.CurrencyRepository;
import kg.ksucta.kgiai.datenbank2.ig1_15.murat.model.Currency;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CurrencyRepositoryImpl extends AbstractRepository<Currency, Long> implements CurrencyRepository {
    private static CurrencyRepositoryImpl ourInstance = new CurrencyRepositoryImpl("currency");

    public static CurrencyRepositoryImpl getInstance() {
        return ourInstance;
    }

    public CurrencyRepositoryImpl(String tableName) {
        super(tableName);
    }

    protected Currency getBindClass(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        return new Currency(id, name);
    }

    @Override
    protected String commaSeparatedValuesFor(Currency clas) {
        return String.format("null, '%s'", clas.getName());
    }
}
