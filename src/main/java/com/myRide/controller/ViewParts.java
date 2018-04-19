package com.myRide.controller;

import com.myRide.entity.Part;
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

@WebServlet(name = "ViewParts", urlPatterns = {"/viewparts"})

public class ViewParts extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        GenericDao<Part> dao = new GenericDao(Part.class);

        List<Part> parts = dao.getAll();

        req.setAttribute("parts", parts);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/parts.jsp");
        dispatcher.forward(req, resp);
    }
}

