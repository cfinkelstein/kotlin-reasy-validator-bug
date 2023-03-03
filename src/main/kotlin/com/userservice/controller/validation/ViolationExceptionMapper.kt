package com.userservice.controller.validation


import javax.validation.ConstraintViolationException
import javax.ws.rs.core.Response
import javax.ws.rs.ext.ExceptionMapper
import javax.ws.rs.ext.Provider

@Provider
class ViolationExceptionMapper: ExceptionMapper<ConstraintViolationException> {

    override fun toResponse(ex: ConstraintViolationException): Response {
        ex.printStackTrace()
        return Response.status(400).build()
    }

}