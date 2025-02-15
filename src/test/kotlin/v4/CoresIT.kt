package v4

import cz.matejvana.spacexkotapi.request.PaginatedResponse
import cz.matejvana.spacexkotapi.v4.ClientV4
import cz.matejvana.spacexkotapi.v4.cores.CoreDto
import io.mockk.every
import io.mockk.mockk
import kotlin.test.*
    
class CoresIT {

    @Test
    fun testGetAllCores() {
        val client = mockk<ClientV4>()
        every { client.cores.getAll() } returns listOf(
            CoreDto("id1", "serial1", 1, "active", 0, 0, 0, 0, 0, "update", listOf()),
            CoreDto("id2", "serial2", 2, "inactive", 1, 1, 1, 1, 1, "update2", listOf())
        )

        val cores = client.cores.getAll()
        assertTrue(cores.isNotEmpty())
        assertEquals(2, cores.size)
        assertEquals("id1", cores[0].id)
        assertEquals("serial1", cores[0].serial)
        assertEquals(1, cores[0].block)
        assertEquals("active", cores[0].status)
        assertEquals(0, cores[0].reuseCount)
        assertEquals(0, cores[0].rtlsAttempts)
        assertEquals(0, cores[0].rtlsLandings)
        assertEquals(0, cores[0].asdsAttempts)
        assertEquals(0, cores[0].asdsLandings)
        assertEquals("update", cores[0].lastUpdate)
        assertTrue(cores[0].launches.isEmpty())

        assertEquals("id2", cores[1].id)
        assertEquals("serial2", cores[1].serial)
        assertEquals(2, cores[1].block)
        assertEquals("inactive", cores[1].status)
        assertEquals(1, cores[1].reuseCount)
        assertEquals(1, cores[1].rtlsAttempts)
        assertEquals(1, cores[1].rtlsLandings)
        assertEquals(1, cores[1].asdsAttempts)
        assertEquals(1, cores[1].asdsLandings)
        assertEquals("update2", cores[1].lastUpdate)
        assertTrue(cores[1].launches.isEmpty())
    }

    @Test
    fun testGetAllCoresInternetFailure() {
        val client = mockk<ClientV4>()
        every { client.cores.getAll() } throws RuntimeException("Internet connection error")

        assertFailsWith<RuntimeException> {
            client.cores.getAll()
        }
    }

    @Test
    fun testGetAllCores400StatusCode() {
        val client = mockk<ClientV4>()
        every { client.cores.getAll() } throws RuntimeException("HTTP 400 Bad Request")

        assertFailsWith<RuntimeException> {
            client.cores.getAll()
        }
    }

    @Test
    fun testGetCoreByIdSuccess() {
        val client = mockk<ClientV4>()
        val core = CoreDto("id", "serial", 1, "active", 0, 0, 0, 0, 0, "update", listOf())
        every { client.cores.getById("id") } returns core

        val result = client.cores.getById("id")
        assertNotNull(result)
        assertEquals("id", result.id)
        assertEquals("serial", result.serial)
        assertEquals(1, result.block)
        assertEquals("active", result.status)
        assertEquals(0, result.reuseCount)
        assertEquals(0, result.rtlsAttempts)
        assertEquals(0, result.rtlsLandings)
        assertEquals(0, result.asdsAttempts)
        assertEquals(0, result.asdsLandings)
        assertEquals("update", result.lastUpdate)
        assertTrue(result.launches.isEmpty())
    }

    @Test
    fun testGetCoreByIdInternetFailure() {
        val client = mockk<ClientV4>()
        every { client.cores.getById("id") } throws RuntimeException("Internet connection error")

        assertFailsWith<RuntimeException> {
            client.cores.getById("id")
        }
    }

    @Test
    fun testGetCoreById400StatusCode() {
        val client = mockk<ClientV4>()
        every { client.cores.getById("id") } throws RuntimeException("HTTP 400 Bad Request")

        assertFailsWith<RuntimeException> {
            client.cores.getById("id")
        }
    }

    @Test
    fun testQueryCoresSuccess() {
        val client = mockk<ClientV4>()
        val paginatedResponse = PaginatedResponse(
            docs = listOf(
                CoreDto("id", "serial", 1, "active", 0, 0, 0, 0, 0, "update", listOf())
            ),
            totalDocs = 1,
            limit = 1,
            totalPages = 1,
            page = 1,
            pagingCounter = 1,
            hasPrevPage = false,
            hasNextPage = false,
            prevPage = null,
            nextPage = null,
            offset = 0
        )
        every { client.cores.query(any()) } returns paginatedResponse

        val result = client.cores.query(mapOf("status" to "active"))
        assertTrue(result.docs.isNotEmpty())
        assertEquals(1, result.totalDocs)
        assertEquals(1, result.limit)
        assertEquals(1, result.totalPages)
        assertEquals(1, result.page)
        assertEquals(1, result.pagingCounter)
        assertFalse(result.hasPrevPage)
        assertFalse(result.hasNextPage)
        assertNull(result.prevPage)
        assertNull(result.nextPage)
        assertEquals(0, result.offset)
        assertEquals(1, result.docs.size)
        assertEquals("id", result.docs[0].id)
        assertEquals("serial", result.docs[0].serial)
        assertEquals(1, result.docs[0].block)
        assertEquals("active", result.docs[0].status)
        assertEquals(0, result.docs[0].reuseCount)
        assertEquals(0, result.docs[0].rtlsAttempts)
        assertEquals(0, result.docs[0].rtlsLandings)
        assertEquals(0, result.docs[0].asdsAttempts)
        assertEquals(0, result.docs[0].asdsLandings)
        assertEquals("update", result.docs[0].lastUpdate)
        assertTrue(result.docs[0].launches.isEmpty())
    }

    @Test
    fun testQueryCoresInternetFailure() {
        val client = mockk<ClientV4>()
        every { client.cores.query(any()) } throws RuntimeException("Internet connection error")

        assertFailsWith<RuntimeException> {
            client.cores.query(mapOf("status" to "active"))
        }
    }

    @Test
    fun testQueryCores400StatusCode() {
        val client = mockk<ClientV4>()
        every { client.cores.query(any()) } throws RuntimeException("HTTP 400 Bad Request")

        assertFailsWith<RuntimeException> {
            client.cores.query(mapOf("status" to "active"))
        }
    }
}