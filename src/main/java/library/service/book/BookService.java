package library.service.book;

import library.config.ConnectionSingleton;
import library.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookService implements IBookService{
    Connection connection = ConnectionSingleton.getConnection();

    @Override
    public List<Book> findAll() {
        List<Book> bookLis = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("select * from book");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("idB");
                String name = rs.getString("name");
                String author = rs.getString("author");
                String description = rs.getString("description");
                int quantity = rs.getInt("quantity");
                bookLis.add(new Book(id, name, author, description, quantity));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookLis;
    }

    @Override
    public Book findById(int id) {
        Book book = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("select * from book where idB=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                String author = rs.getString("author");
                String description = rs.getString("description");
                int quantity = rs.getInt("quantity");
                book = new Book(name, author, description, quantity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    @Override
    public void insert(Book book) throws SQLException {
    }

    @Override
    public void update(Book book) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }


}
