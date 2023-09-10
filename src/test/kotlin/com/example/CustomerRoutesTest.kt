package com.example

import com.example.plugins.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.*

internal class CustomerRoutesTest {

    @Test
    fun `when data base is empty should return status code OK and message 'No customer found' `() = testApplication {
        application { configureRouting() }

        client.get("/customer").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("No customers found", bodyAsText())
        }
    }

    @Test
    fun `when id is not informed should return status code 400 and message 'Missing id' `() = testApplication{
        application { configureRouting() }

        client.get("/customer/").apply {
            assertEquals(HttpStatusCode.BadRequest, status)
            assertEquals("Missing id", bodyAsText())
        }
    }

}
