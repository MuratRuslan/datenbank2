package kg.ksucta.kgiai.datenbank2.ig1_15.murat.dao.repository.impl;

import kg.ksucta.kgiai.datenbank2.ig1_15.murat.dao.repository.AbstractRepository;
import kg.ksucta.kgiai.datenbank2.ig1_15.murat.dao.repository.UserRepository;
import kg.ksucta.kgiai.datenbank2.ig1_15.murat.model.User;
import kg.ksucta.kgiai.datenbank2.ig1_15.murat.utils.SqlUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl extends AbstractRepository<User, Long> implements UserRepository {
    private static UserRepositoryImpl ourInstance = new UserRepositoryImpl("user");

    public static UserRepositoryImpl getInstance() {
        return ourInstance;
    }

    private UserRepositoryImpl(String name) {
        super(name);
    }

    protected User getBindClass(ResultSet resultSet) throws SQLException {
        Long userId = resultSet.getLong("id");
        String name = resultSet.getString("name");
        String surname = resultSet.getString("surname");
        String middleName = resultSet.getString("middle_name");
        return new User(userId, name, surname, middleName);
    }

    @Override
    protected String commaSeparatedValuesFor(User clas) {
        return String.format("null, '%s', '%s', '%s'", clas.getName(), clas.getSurname(), clas.getMiddleName());
    }
}
