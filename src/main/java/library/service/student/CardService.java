package library.service.student;

import library.config.ConnectionSingleton;
import library.model.Book;
import library.model.Card;
import library.model.Student;
import library.service.book.BookService;
import library.service.card.StudentService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CardService implements ICardService{
    Connection connection = ConnectionSingleton.getConnection();
    StudentService studentService = new StudentService();
    BookService bookService = new BookService();

    @Override
    public List<Card> findAll() {
        List<Card> cardList = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("select * from card");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("idC");
                int idS = rs.getInt("idS");
                Student student = studentService.findById(idS);
                int idB = rs.getInt("idB");
                Book book = bookService.findById(idB);
                boolean status = rs.getBoolean("status");
                String borrowDate = rs.getString("borrowDate");
                String payDate = rs.getString("payDate");
                cardList.add(new Card(id, book, student, status, borrowDate, payDate));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cardList;
    }

    @Override
    public Card findById(int id) {
        Card card = null;
        try {
            PreparedStatement ps = connection.prepareStatement("select * from card where idC=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int idS = rs.getInt("idS");
                Student student = studentService.findById(idS);
                int idB = rs.getInt("idB");
                Book book = bookService.findById(idB);
                boolean status = rs.getBoolean("status");
                String borrowDate = rs.getString("borrowDate");
                String payDate = rs.getString("payDate");
                card = new Card(book, student, status, borrowDate, payDate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return card;
    }

    @Override
    public void insert(Card card) throws SQLException {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into card(idB, idS, status, borrowDate, payDate) value (?,?,?,?,?)");
            ps.setInt(1, card.getBook().getId());
            ps.setInt(2, card.getStudent().getId());
            ps.setBoolean(3, card.getStatus());
            ps.setString(4, card.getBorrowDate());
            ps.setString(5, card.getPayDate());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Card card) throws SQLException {
        try {
            PreparedStatement ps = connection.prepareStatement("update card set idB=?, idS=?, status=?, borrowDate=?, payDate=? where idC=?");
            ps.setInt(1, card.getBook().getId());
            ps.setInt(2, card.getStudent().getId());
            ps.setBoolean(3, card.getStatus());
            ps.setString(4, card.getBorrowDate());
            ps.setString(5, card.getPayDate());
            ps.setInt(6, card.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        try {
            PreparedStatement ps = connection.prepareStatement("delete  from card where idC=?");
            ps.setInt(1, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
