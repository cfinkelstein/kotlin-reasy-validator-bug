package com.userservice.model.validation

import java.lang.annotation.Documented
import javax.validation.Constraint
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [UUIDConstraintValidator::class])
@Documented
annotation class UUIDPathElement(val message: String = "must be a valid uuid",
                                 val groups: Array<KClass<out Any>> = [],
                                 val payload: Array<KClass<out Any>> = [])