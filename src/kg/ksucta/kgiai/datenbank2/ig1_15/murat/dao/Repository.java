package kg.ksucta.kgiai.datenbank2.ig1_15.murat.dao;

import java.util.Collection;
import java.util.List;

public interface Repository<T, ID> {
    T findOne(ID id);
    List<T> findAll();
    void save(T ... entities);
    void save(Iterable<T> collection);
}
