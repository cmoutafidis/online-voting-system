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
    public Response createUser(final User user) {
        this.userService.createUser(user);

        return Response.ok(user).build();
    }


    @Path("update")
    @POST
    public Response updateUser(final User user) {
        this.userService.updateUser(user);

        return Response.ok(user).build();
    }

    @Path("{id}")
    @GET
    public User getUser(@PathParam("id") final long id) {
        return this.userService.findUserById(id);
    }

    @Path("list")
    @GET
    public List<User> getUsers() {
        return this.userService.getUsers();
    }

}
