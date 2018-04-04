package com.myRide.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.myRide.entity.User;
import com.myRide.persistence.GenericDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

@Path("/users")
@Produces({"application/json"})

public class ViewUsers {

    GenericDao<User> userDao;

    @GET
    public Response doGet() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        StringWriter stringUsers = new StringWriter();

        userDao = new GenericDao(User.class);

        //Get list of Users
        List<User> users = userDao.getAll();

        //Configure Object Mapper for pretty print
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        //Convert Users
        objectMapper.writeValue(stringUsers, users);

         return Response.status(200).entity(stringUsers.toString()).build();
     }

    @GET
    @Path("/{id}")
    public Response doGet(@PathParam("id") Integer id) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        StringWriter stringUser = new StringWriter();

        userDao = new GenericDao(User.class);

        //Get User
         User user = userDao.getById(id);

        //Configure Object Mapper for pretty print
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        //Convert User
        objectMapper.writeValue(stringUser, user);

        return Response.status(200).entity(stringUser.toString()).build();
    }

}


