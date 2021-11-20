package controller;

import library.model.Book;
import library.model.Card;
import library.model.Student;
import library.service.book.BookService;
import library.service.card.StudentService;
import library.service.student.CardService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LibaryServlet", value = "/librarys")
public class LibaryServlet extends HttpServlet {
    BookService bookService = new BookService();
    StudentService studentService = new StudentService();
    CardService cardService = new CardService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "borrow":
                showBorrowForm(request, response);
                break;
            case "listcard":
                listCard(request, response);
                break;
            case "delete":
                deleteCard(request, response);
                break;
            default:
                listBook(request, response);
                break;
        }
    }

    private void deleteCard(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            cardService.delete(id);
            request.setAttribute("cardList",cardService.findAll());
            response.sendRedirect("/librarys?action=listcard");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private void listCard(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("card/listcard.jsp");
        try {
            request.setAttribute("cardList", cardService.findAll());
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void listBook(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("book/list.jsp");
        try {
            request.setAttribute("bookList", bookService.findAll());
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showBorrowForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("card/borrow.jsp");
        int bookId = Integer.parseInt(request.getParameter("id"));
        Book book = bookService.findById(bookId);
        request.setAttribute("book", book);
        request.setAttribute("studentList", studentService.findAll());
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void borrow(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("card/listcard.jsp");
        try {
            int idB = Integer.parseInt(request.getParameter("id"));
            Book book = bookService.findById(idB);
            int idS = Integer.parseInt(request.getParameter("student"));
            Student student = studentService.findById(idS);
            String borrowDate = request.getParameter("borrowDate");
            String payDate = request.getParameter("payDate");
            Card card = new Card(book, student,true, borrowDate, payDate);
//            request.setAttribute("studentList", studentService.findAll());
            try {
                cardService.insert(card);
                request.setAttribute("cardList", cardService.findAll());
                dispatcher.forward(request, response);
            } catch (SQLException | ServletException | IOException e) {
                e.printStackTrace();
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "borrow":
                borrow(request, response);
                break;
        }
    }


}
