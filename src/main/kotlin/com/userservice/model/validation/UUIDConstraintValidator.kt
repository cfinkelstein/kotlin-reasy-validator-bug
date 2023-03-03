package com.userservice.model.validation


import javax.enterprise.context.ApplicationScoped
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

@ApplicationScoped
class UUIDConstraintValidator: ConstraintValidator<UUIDPathElement, String> {
    override fun isValid(uuid: String?, context: ConstraintValidatorContext): Boolean {
        return uuid != null
    }
}