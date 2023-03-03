package com.userservice.controller

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import io.restassured.response.Response
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.hamcrest.Matchers.*
import org.hamcrest.MatcherAssert.*
import java.util.*
import javax.inject.Inject


@QuarkusTest
class UserControllerTest {

    @Test
    fun `userById - default coroutine handling with suspend`() {
        assertThat(given()
            .`when`()
            .get("http://localhost:8081/api/users/nb/ce8339ea-ce7f-4fba-b8dc-9539aaf3453d")
            .statusCode, `is`(200)
        )
    }

    @Test
    fun `userById - blocking`() {
        assertThat(given()
            .`when`()
            .get("http://localhost:8081/api/users/b/ce8339ea-ce7f-4fba-b8dc-9539aaf3453d")
            .statusCode, `is`(200)
        )
    }

    @Test
    fun `userById - non blocking handling with mutiny`() {
        assertThat(given()
            .`when`()
            .get("http://localhost:8081/api/users/nbuni/ce8339ea-ce7f-4fba-b8dc-9539aaf3453d")
            .statusCode, `is`(200)
        )
    }

}