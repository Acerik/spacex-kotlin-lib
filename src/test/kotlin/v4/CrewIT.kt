package v4

import cz.matejvana.spacexkotapi.request.PaginatedResponse
import cz.matejvana.spacexkotapi.v4.SpaceXClientV4
import cz.matejvana.spacexkotapi.v4.crew.CrewDto
import io.mockk.every
import io.mockk.mockk
import kotlin.test.*

class CrewIT {

    @Test
    fun testAllCrewSuccess() {
        val client = mockk<SpaceXClientV4>()
        every { client.crew.getAll() } returns listOf(
            CrewDto(
                "id",
                "name",
                "status",
                "agency",
                "image",
                "wikipedia",
                emptyList()
            ),
            CrewDto(
                "id2",
                "name2",
                "status2",
                "agency2",
                "image2",
                "wikipedia2",
                emptyList()
            )
        )

        val crew = client.crew.getAll()
        assertTrue(crew.isNotEmpty())
        assertEquals(2, crew.size)
        assertEquals("id", crew[0].id)
        assertEquals("name", crew[0].name)
        assertEquals("status", crew[0].status)
        assertEquals("agency", crew[0].agency)
        assertEquals("image", crew[0].image)
        assertEquals("wikipedia", crew[0].wikipedia)
        assertTrue(crew[0].launches.isEmpty())

        assertEquals("id2", crew[1].id)
        assertEquals("name2", crew[1].name)
        assertEquals("status2", crew[1].status)
        assertEquals("agency2", crew[1].agency)
        assertEquals("image2", crew[1].image)
        assertEquals("wikipedia2", crew[1].wikipedia)
        assertTrue(crew[1].launches.isEmpty())
    }

    @Test
    fun testAllCrewInternetFailure() {
        val client = mockk<SpaceXClientV4>()
        every { client.crew.getAll() } throws RuntimeException("Internet connection error")

        assertFailsWith<RuntimeException> {
            client.crew.getAll()
        }
    }

    @Test
    fun testAllCrew400StatusCode() {
        val client = mockk<SpaceXClientV4>()
        every { client.crew.getAll() } throws RuntimeException("HTTP 400 Bad Request")

        assertFailsWith<RuntimeException> {
            client.crew.getAll()
        }
    }

    @Test
    fun testCrewByIdSuccess() {
        val client = mockk<SpaceXClientV4>()
        val crewMember = CrewDto(
            "id",
            "name",
            "status",
            "agency",
            "image",
            "wikipedia",
            emptyList()
        )
        every { client.crew.getById("id") } returns crewMember

        val result = client.crew.getById("id")
        assertNotNull(result)
        assertEquals("id", result.id)
        assertEquals("name", result.name)
        assertEquals("status", result.status)
        assertEquals("agency", result.agency)
        assertEquals("image", result.image)
        assertEquals("wikipedia", result.wikipedia)
        assertTrue(result.launches.isEmpty())
    }

    @Test
    fun testCrewByIdInternetFailure() {
        val client = mockk<SpaceXClientV4>()
        every { client.crew.getById("id") } throws RuntimeException("Internet connection error")

        assertFailsWith<RuntimeException> {
            client.crew.getById("id")
        }
    }

    @Test
    fun testCrewById400StatusCode() {
        val client = mockk<SpaceXClientV4>()
        every { client.crew.getById("id") } throws RuntimeException("HTTP 400 Bad Request")

        assertFailsWith<RuntimeException> {
            client.crew.getById("id")
        }
    }

    @Test
    fun testQueryCrewSuccess() {
        val client = mockk<SpaceXClientV4>()
        val paginatedResponse = PaginatedResponse(
            docs = listOf(
                CrewDto(
                    "id",
                    "name",
                    "status",
                    "agency",
                    "image",
                    "wikipedia",
                    emptyList()
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
        every { client.crew.query(any()) } returns paginatedResponse

        val result = client.crew.query(mapOf("limit" to 1))
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
        assertEquals("name", result.docs[0].name)
        assertEquals("status", result.docs[0].status)
        assertEquals("agency", result.docs[0].agency)
        assertEquals("image", result.docs[0].image)
        assertEquals("wikipedia", result.docs[0].wikipedia)
        assertTrue(result.docs[0].launches.isEmpty())
    }

    @Test
    fun testQueryCrewInternetFailure() {
        val client = mockk<SpaceXClientV4>()
        every { client.crew.query(any()) } throws RuntimeException("Internet connection error")

        assertFailsWith<RuntimeException> {
            client.crew.query(mapOf("limit" to 1))
        }
    }

    @Test
    fun testQueryCrew400StatusCode() {
        val client = mockk<SpaceXClientV4>()
        every { client.crew.query(any()) } throws RuntimeException("HTTP 400 Bad Request")

        assertFailsWith<RuntimeException> {
            client.crew.query(mapOf("limit" to 1))
        }
    }
}