package com.myRide.controller;

import com.myRide.entity.User;
import com.myRide.persistence.GenericDao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "DeleteUsers", urlPatterns = {"/deleteusers"})

public class DeleteUsers extends HttpServlet {

    GenericDao<User> userDao;

    /**
     * Handles HTTP GET requests.
     *
     * @param request  the HttpServletRequest object
     * @param response the HttpServletResponse object
     * @throws ServletException if there is a Servlet failure
     * @throws IOException      if there is an IO failure
     */

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);
    }

    /**
     * Handles HTTP GET requests.
     *
     * @param request  the HttpServletRequest object
     * @param response the HttpServletResponse object
     * @throws ServletException if there is a Servlet failure
     * @throws IOException      if there is an IO failure
     */

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        String userID = request.getParameter("userID");

        GenericDao<User> dao = new GenericDao(User.class);

        dao.delete(dao.getById(Integer.parseInt(userID)));

        //request.setAttribute("users", users);

//        RequestDispatcher dispatcher = request.getRequestDispatcher("/users.jsp");
//        dispatcher.forward(request, response);

       String url = "viewusers";
//
       response.sendRedirect(url);
    }
}