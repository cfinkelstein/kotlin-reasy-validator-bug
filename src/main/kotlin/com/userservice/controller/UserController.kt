package com.userservice.controller

import com.userservice.model.*
import com.userservice.model.validation.UUIDPathElement
import kotlinx.coroutines.*
import javax.enterprise.context.ApplicationScoped
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.core.Response

@ApplicationScoped
@Path("/users")
class UserController {

    //validation error as the validator will be executed a second time with a null value
    @GET
    @Path("/{userId}")
    suspend fun userById(
        @UUIDPathElement()
        @PathParam("userId") userId: String): Response  {
        return GlobalScope.async{
            Response.status(200).build()
        }.await()
    }

    //this works as expected - no validation error
    @GET
    @Path("/synchronous/{userId}")
    fun userByIdSynchronous(
        @UUIDPathElement()
        @PathParam("userId") userId: String): Response  {
        return Response.status(200).build()
    }
}