package com.myRide.controller;

import com.myRide.entity.User;
import com.myRide.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.List;

@WebServlet(name = "ViewUsers", urlPatterns = {"/viewusers"})

public class ViewUsers extends HttpServlet {

    GenericDao<User> userDao;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        userDao = new GenericDao(User.class);

        List<User> users = userDao.getAll();

        request.setAttribute("users", users);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/users.jsp");
        dispatcher.forward(request, response);
    }
}


