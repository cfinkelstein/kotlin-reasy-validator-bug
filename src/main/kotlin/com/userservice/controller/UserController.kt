package com.userservice.controller

import com.userservice.model.*
import com.userservice.model.validation.UUIDPathElement
import io.smallrye.mutiny.Uni
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
    @Path("/nb/{userId}")
    suspend fun userById(
        @UUIDPathElement()
        @PathParam("userId") userId: String): Response  {
        return GlobalScope.async{
            Response.status(200).build()
        }.await()
    }

    //this works as expected - no validation error
    @GET
    @Path("/b/{userId}")
    fun userByIdBlocking(
        @UUIDPathElement()
        @PathParam("userId") userId: String): Response  {
        return Response.status(200).build()
    }

    //this works as expected - no validation error
    @GET
    @Path("/nbuni/{userId}")
    fun userByIdNonBlockingUni(
        @UUIDPathElement()
        @PathParam("userId") userId: String): Uni<Response> {
        return Uni.createFrom().item(Response.status(200).build())
    }


}