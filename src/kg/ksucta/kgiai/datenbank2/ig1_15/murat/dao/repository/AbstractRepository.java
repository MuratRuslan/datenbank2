package kg.ksucta.kgiai.datenbank2.ig1_15.murat.dao.repository;

import kg.ksucta.kgiai.datenbank2.ig1_15.murat.config.JdbcConfig;
import kg.ksucta.kgiai.datenbank2.ig1_15.murat.dao.Repository;
import kg.ksucta.kgiai.datenbank2.ig1_15.murat.model.User;
import kg.ksucta.kgiai.datenbank2.ig1_15.murat.utils.SqlUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractRepository<T, ID> implements Repository<T, ID>{
    protected Connection connection;
    protected Statement statement;
    protected String tableName;

    public AbstractRepository(String tableName) {
        this.tableName = tableName;
        init();
    }

    private void init() {
        try {
            Class.forName(JdbcConfig.JDBC_DRIVER);
            connection = DriverManager.getConnection(JdbcConfig.URL,
                    JdbcConfig.USERNAME, JdbcConfig.PASSWORD);
            statement = connection.createStatement();
            System.out.println("successfully connected");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected abstract T getBindClass(ResultSet resultSet) throws SQLException;

    public T findOne(Long id) {
        try {
            String query = SqlUtils.getByIdQuery(id, tableName);
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            return getBindClass(resultSet);
        } catch (SQLException e) {
            return null;
        }
    }

    public List<T> findAll() {
        try {
            ResultSet resultSet = statement.executeQuery(SqlUtils.getAllQuery(tableName));
            List<T> list = new ArrayList<>();
            while (resultSet.next()) {
                list.add(getBindClass(resultSet));
            }
            return list;
        } catch (SQLException e) {
            return null;
        }
    }

    protected abstract String commaSeparatedValuesFor(T clas);

    @Override
    public void save(T... entities) {
        save(Arrays.asList(entities));
    }

    @Override
    public void save(Iterable<T> collection) {
        try {
            connection.setAutoCommit(false);
            for(T t : collection) {
                statement.executeUpdate(SqlUtils.getInsertQuery(tableName, commaSeparatedValuesFor(t)));
            }
            connection.commit();
            System.out.println("Успешно добавлен!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}
