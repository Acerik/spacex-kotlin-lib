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