package v4

import cz.matejvana.spacexkotapi.request.PaginatedResponse
import cz.matejvana.spacexkotapi.v4.ClientV4
import cz.matejvana.spacexkotapi.v4.capsules.CapsuleDto
import io.mockk.every
import io.mockk.mockk
import kotlin.test.*

class CapsulesIT {

    @Test
    fun testAllCapsulesSuccess() {
        val client = mockk<ClientV4>()
        every { client.capsules.getAll() } returns listOf(
            CapsuleDto(
                "id",
                "serial",
                "status",
                "type",
                "dragon",
                1,
                1,
                1,
                "lastUpdate",
                emptyList()
            ),
            CapsuleDto(
                "id2",
                "serial2",
                "status2",
                "type2",
                "dragon2",
                2,
                2,
                2,
                "lastUpdate2",
                emptyList()
            )
        )

        val capsules = client.capsules.getAll()
        assertTrue(capsules.isNotEmpty())
        assertEquals(2, capsules.size)
        assertEquals("id", capsules[0].id)
        assertEquals("serial", capsules[0].serial)
        assertEquals("status", capsules[0].status)
        assertEquals("type", capsules[0].type)
        assertEquals("dragon", capsules[0].dragon)
        assertEquals(1, capsules[0].reuseCount)
        assertEquals(1, capsules[0].waterLandings)
        assertEquals(1, capsules[0].landLandings)
        assertEquals("lastUpdate", capsules[0].lastUpdate)
        assertTrue(capsules[0].launches.isEmpty())

        assertEquals("id2", capsules[1].id)
        assertEquals("serial2", capsules[1].serial)
        assertEquals("status2", capsules[1].status)
        assertEquals("type2", capsules[1].type)
        assertEquals("dragon2", capsules[1].dragon)
        assertEquals(2, capsules[1].reuseCount)
        assertEquals(2, capsules[1].waterLandings)
        assertEquals(2, capsules[1].landLandings)
        assertEquals("lastUpdate2", capsules[1].lastUpdate)
        assertTrue(capsules[1].launches.isEmpty())
    }

    @Test
    fun testAllCapsulesInternetFailure() {
        val client = mockk<ClientV4>()
        every { client.capsules.getAll() } throws RuntimeException("Internet connection error")

        assertFailsWith<RuntimeException> {
            client.capsules.getAll()
        }
    }

    @Test
    fun testAllCapsules400StatusCode() {
        val client = mockk<ClientV4>()
        every { client.capsules.getAll() } throws RuntimeException("HTTP 400 Bad Request")

        assertFailsWith<RuntimeException> {
            client.capsules.getAll()
        }
    }

    @Test
    fun testCapsuleByIdSuccess() {
        val client = mockk<ClientV4>()
        val capsule = CapsuleDto(
            "id",
            "serial",
            "status",
            "type",
            "dragon",
            1,
            1,
            1,
            "lastUpdate",
            emptyList()
        )
        every { client.capsules.getById("id") } returns capsule

        val result = client.capsules.getById("id")
        assertNotNull(result)
        assertEquals("id", result.id)
        assertEquals("serial", result.serial)
        assertEquals("status", result.status)
        assertEquals("type", result.type)
        assertEquals("dragon", result.dragon)
        assertEquals(1, result.reuseCount)
        assertEquals(1, result.waterLandings)
        assertEquals(1, result.landLandings)
        assertEquals("lastUpdate", result.lastUpdate)
        assertTrue(result.launches.isEmpty())
    }

    @Test
    fun testCapsuleByIdInternetFailure() {
        val client = mockk<ClientV4>()
        every { client.capsules.getById("id") } throws RuntimeException("Internet connection error")

        assertFailsWith<RuntimeException> {
            client.capsules.getById("id")
        }
    }

    @Test
    fun testCapsuleById400StatusCode() {
        val client = mockk<ClientV4>()
        every { client.capsules.getById("id") } throws RuntimeException("HTTP 400 Bad Request")

        assertFailsWith<RuntimeException> {
            client.capsules.getById("id")
        }
    }

    @Test
    fun testQueryCapsulesSuccess() {
        val client = mockk<ClientV4>()
        val paginatedResponse = PaginatedResponse(
            docs = listOf(
                CapsuleDto(
                    "id",
                    "serial",
                    "status",
                    "type",
                    "dragon",
                    1,
                    1,
                    1,
                    "lastUpdate",
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
        every { client.capsules.query(any()) } returns paginatedResponse

        val result = client.capsules.query(mapOf("limit" to 1))
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
        assertEquals("status", result.docs[0].status)
        assertEquals("type", result.docs[0].type)
        assertEquals("dragon", result.docs[0].dragon)
        assertEquals(1, result.docs[0].reuseCount)
        assertEquals(1, result.docs[0].waterLandings)
        assertEquals(1, result.docs[0].landLandings)
        assertEquals("lastUpdate", result.docs[0].lastUpdate)
        assertTrue(result.docs[0].launches.isEmpty())
    }

    @Test
    fun testQueryCapsulesInternetFailure() {
        val client = mockk<ClientV4>()
        every { client.capsules.query(any()) } throws RuntimeException("Internet connection error")

        assertFailsWith<RuntimeException> {
            client.capsules.query(mapOf("limit" to 1))
        }
    }

    @Test
    fun testQueryCapsules400StatusCode() {
        val client = mockk<ClientV4>()
        every { client.capsules.query(any()) } throws RuntimeException("HTTP 400 Bad Request")

        assertFailsWith<RuntimeException> {
            client.capsules.query(mapOf("limit" to 1))
        }
    }
}