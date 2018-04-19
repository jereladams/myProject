package com.myRide.controller;

import com.myRide.entity.Car;
import com.myRide.entity.Repair;
import com.myRide.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ViewRepairs", urlPatterns = {"/viewrepairs"})

public class ViewRepairs extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        GenericDao<Repair> dao = new GenericDao(Repair.class);

        List<Repair> repairs = dao.getAll();

        req.setAttribute("repairs", repairs);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/repairs.jsp");
        dispatcher.forward(req, resp);
    }
}

