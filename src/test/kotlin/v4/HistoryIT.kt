package v4

import cz.matejvana.spacexkotapi.request.PaginatedResponse
import cz.matejvana.spacexkotapi.v4.ClientV4
import cz.matejvana.spacexkotapi.v4.history.HistoryDto
import io.mockk.every
import io.mockk.mockk
import kotlin.test.*

class HistoryIT {

    @Test
    fun testAllHistorySuccess() {
        val client = mockk<ClientV4>()
        every { client.history.getAll() } returns listOf(
            HistoryDto(
                "id",
                "title",
                "eventDateUtc",
                1234567890L,
                "details",
                HistoryDto.Links("article")
            ),
            HistoryDto(
                "id2",
                "title2",
                "eventDateUtc2",
                1234567891L,
                "details2",
                HistoryDto.Links("article2")
            )
        )

        val history = client.history.getAll()
        assertTrue(history.isNotEmpty())
        assertEquals(2, history.size)
        assertEquals("id", history[0].id)
        assertEquals("title", history[0].title)
        assertEquals("eventDateUtc", history[0].eventDateUtc)
        assertEquals(1234567890L, history[0].eventDateUnix)
        assertEquals("details", history[0].details)
        assertEquals("article", history[0].links?.article)

        assertEquals("id2", history[1].id)
        assertEquals("title2", history[1].title)
        assertEquals("eventDateUtc2", history[1].eventDateUtc)
        assertEquals(1234567891L, history[1].eventDateUnix)
        assertEquals("details2", history[1].details)
        assertEquals("article2", history[1].links?.article)
    }

    @Test
    fun testAllHistoryInternetFailure() {
        val client = mockk<ClientV4>()
        every { client.history.getAll() } throws RuntimeException("Internet connection error")

        assertFailsWith<RuntimeException> {
            client.history.getAll()
        }
    }

    @Test
    fun testAllHistory400StatusCode() {
        val client = mockk<ClientV4>()
        every { client.history.getAll() } throws RuntimeException("HTTP 400 Bad Request")

        assertFailsWith<RuntimeException> {
            client.history.getAll()
        }
    }

    @Test
    fun testHistoryByIdSuccess() {
        val client = mockk<ClientV4>()
        val historyItem = HistoryDto(
            "id",
            "title",
            "eventDateUtc",
            1234567890L,
            "details",
            HistoryDto.Links("article")
        )
        every { client.history.getById("id") } returns historyItem

        val result = client.history.getById("id")
        assertNotNull(result)
        assertEquals("id", result.id)
        assertEquals("title", result.title)
        assertEquals("eventDateUtc", result.eventDateUtc)
        assertEquals(1234567890L, result.eventDateUnix)
        assertEquals("details", result.details)
        assertEquals("article", result.links?.article)
    }

    @Test
    fun testHistoryByIdInternetFailure() {
        val client = mockk<ClientV4>()
        every { client.history.getById("id") } throws RuntimeException("Internet connection error")

        assertFailsWith<RuntimeException> {
            client.history.getById("id")
        }
    }

    @Test
    fun testHistoryById400StatusCode() {
        val client = mockk<ClientV4>()
        every { client.history.getById("id") } throws RuntimeException("HTTP 400 Bad Request")

        assertFailsWith<RuntimeException> {
            client.history.getById("id")
        }
    }

    @Test
    fun testQueryHistorySuccess() {
        val client = mockk<ClientV4>()
        val paginatedResponse = PaginatedResponse(
            docs = listOf(
                HistoryDto(
                    "id",
                    "title",
                    "eventDateUtc",
                    1234567890L,
                    "details",
                    HistoryDto.Links("article")
                )
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
        every { client.history.query(any()) } returns paginatedResponse

        val result = client.history.query(mapOf("limit" to 1))
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
        assertEquals("title", result.docs[0].title)
        assertEquals("eventDateUtc", result.docs[0].eventDateUtc)
        assertEquals(1234567890L, result.docs[0].eventDateUnix)
        assertEquals("details", result.docs[0].details)
        assertEquals("article", result.docs[0].links?.article)
    }

    @Test
    fun testQueryHistoryInternetFailure() {
        val client = mockk<ClientV4>()
        every { client.history.query(any()) } throws RuntimeException("Internet connection error")

        assertFailsWith<RuntimeException> {
            client.history.query(mapOf("limit" to 1))
        }
    }

    @Test
    fun testQueryHistory400StatusCode() {
        val client = mockk<ClientV4>()
        every { client.history.query(any()) } throws RuntimeException("HTTP 400 Bad Request")

        assertFailsWith<RuntimeException> {
            client.history.query(mapOf("limit" to 1))
        }
    }
}