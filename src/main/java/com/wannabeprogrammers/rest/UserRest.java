package com.wannabeprogrammers.rest;

import com.wannabeprogrammers.entity.User;
import com.wannabeprogrammers.service.UserService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserRest {

    @Inject
    UserService userService;

    @Path("new")
    @POST
    public Response createTodo(final User todo) {
        this.userService.createUser(todo);

        return Response.ok(todo).build();
    }


    @Path("update")
    @POST
    public Response updateTodo(final User todo) {
        this.userService.updateUser(todo);

        return Response.ok(todo).build();
    }

    @Path("{id}")
    @GET
    public User getTodo(@PathParam("id") final long id) {
        return this.userService.findUserById(id);
    }

    @Path("list")
    @GET
    public List<User> getTodos() {
        return this.userService.getUsers();
    }

}
