package com.myRide.controller;

import com.myRide.entity.Car;
import com.myRide.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

    @WebServlet(name = "ViewCars", urlPatterns = {"/viewcars"})

    public class ViewCars extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                throws ServletException, IOException {

            GenericDao<Car> dao = new GenericDao(Car.class);

            List<Car> cars = dao.getAll();

            req.setAttribute("cars", cars);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/cars.jsp");
            dispatcher.forward(req, resp);
        }
    }

