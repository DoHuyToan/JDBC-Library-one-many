package library.service;

import java.sql.SQLException;
import java.util.List;

public interface IService <T> {
    List<T> findAll();
    void insert(T t) throws SQLException;
    void update(T t) throws SQLException;
    void delete(int id) throws SQLException;
    T findById(int id);
}
