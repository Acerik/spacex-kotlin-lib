package v4

import cz.matejvana.spacexkotapi.request.PaginatedResponse
import cz.matejvana.spacexkotapi.v4.SpaceXClientV4
import cz.matejvana.spacexkotapi.v4.payloads.PayloadDto
import io.mockk.every
import io.mockk.mockk
import kotlin.test.*

class PayloadsIT {

    @Test
    fun testAllPayloadsSuccess() {
        val client = mockk<SpaceXClientV4>()
        every { client.payloads.getAll() } returns listOf(
            PayloadDto(
                "id",
                "name",
                "type",
                false,
                "launch",
                emptyList(),
                emptyList(),
                emptyList(),
                emptyList(),
                1000.0,
                2204.62,
                "orbit",
                "referenceSystem",
                "regime",
                0.0,
                0.0,
                0.0,
                0.0,
                0.0,
                0.0,
                0.0,
                0.0,
                "epoch",
                0.0,
                0.0,
                0.0,
                0.0,
                PayloadDto.Dragon(
                    "capsule",
                    1000.0,
                    2204.62,
                    3600.0,
                    "manifest",
                    true,
                    false
                )
            ),
            PayloadDto(
                "id2",
                "name2",
                "type2",
                true,
                "launch2",
                emptyList(),
                emptyList(),
                emptyList(),
                emptyList(),
                2000.0,
                4409.24,
                "orbit2",
                "referenceSystem2",
                "regime2",
                0.0,
                0.0,
                0.0,
                0.0,
                0.0,
                0.0,
                0.0,
                0.0,
                "epoch2",
                0.0,
                0.0,
                0.0,
                0.0,
                PayloadDto.Dragon(
                    "capsule2",
                    2000.0,
                    4409.24,
                    7200.0,
                    "manifest2",
                    false,
                    true
                )
            )
        )

        val payloads = client.payloads.getAll()
        assertTrue(payloads.isNotEmpty())
        assertEquals(2, payloads.size)
        assertEquals("id", payloads[0].id)
        assertEquals("name", payloads[0].name)
        assertEquals("type", payloads[0].type)
        assertFalse(payloads[0].reused)
        assertEquals("launch", payloads[0].launch)
        assertEquals(1000.0, payloads[0].massKg)
        assertEquals(2204.62, payloads[0].massLbs)
        assertEquals("orbit", payloads[0].orbit)
        assertEquals("referenceSystem", payloads[0].referenceSystem)
        assertEquals("regime", payloads[0].regime)
        assertEquals("capsule", payloads[0].dragon?.capsule)
        assertEquals(1000.0, payloads[0].dragon?.massReturnedKg)
        assertEquals(2204.62, payloads[0].dragon?.massReturnedLbs)
        assertEquals(3600.0, payloads[0].dragon?.flightTimeSec)
        assertEquals("manifest", payloads[0].dragon?.manifest)
        assertTrue(payloads[0].dragon?.waterLanding == true)
        assertFalse(payloads[0].dragon?.landLanding == true)

        assertEquals("id2", payloads[1].id)
        assertEquals("name2", payloads[1].name)
        assertEquals("type2", payloads[1].type)
        assertTrue(payloads[1].reused)
        assertEquals("launch2", payloads[1].launch)
        assertEquals(2000.0, payloads[1].massKg)
        assertEquals(4409.24, payloads[1].massLbs)
        assertEquals("orbit2", payloads[1].orbit)
        assertEquals("referenceSystem2", payloads[1].referenceSystem)
        assertEquals("regime2", payloads[1].regime)
        assertEquals("capsule2", payloads[1].dragon?.capsule)
        assertEquals(2000.0, payloads[1].dragon?.massReturnedKg)
        assertEquals(4409.24, payloads[1].dragon?.massReturnedLbs)
        assertEquals(7200.0, payloads[1].dragon?.flightTimeSec)
        assertEquals("manifest2", payloads[1].dragon?.manifest)
        assertFalse(payloads[1].dragon?.waterLanding == true)
        assertTrue(payloads[1].dragon?.landLanding == true)
    }

    @Test
    fun testAllPayloadsInternetFailure() {
        val client = mockk<SpaceXClientV4>()
        every { client.payloads.getAll() } throws RuntimeException("Internet connection error")

        assertFailsWith<RuntimeException> {
            client.payloads.getAll()
        }
    }

    @Test
    fun testAllPayloads400StatusCode() {
        val client = mockk<SpaceXClientV4>()
        every { client.payloads.getAll() } throws RuntimeException("HTTP 400 Bad Request")

        assertFailsWith<RuntimeException> {
            client.payloads.getAll()
        }
    }

    @Test
    fun testPayloadByIdSuccess() {
        val client = mockk<SpaceXClientV4>()
        val payload = PayloadDto(
            "id",
            "name",
            "type",
            false,
            "launch",
            emptyList(),
            emptyList(),
            emptyList(),
            emptyList(),
            1000.0,
            2204.62,
            "orbit",
            "referenceSystem",
            "regime",
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            "epoch",
            0.0,
            0.0,
            0.0,
            0.0,
            PayloadDto.Dragon(
                "capsule",
                1000.0,
                2204.62,
                3600.0,
                "manifest",
                true,
                false
            )
        )
        every { client.payloads.getById("id") } returns payload

        val result = client.payloads.getById("id")
        assertNotNull(result)
        assertEquals("id", result.id)
        assertEquals("name", result.name)
        assertEquals("type", result.type)
        assertFalse(result.reused)
        assertEquals("launch", result.launch)
        assertEquals(1000.0, result.massKg)
        assertEquals(2204.62, result.massLbs)
        assertEquals("orbit", result.orbit)
        assertEquals("referenceSystem", result.referenceSystem)
        assertEquals("regime", result.regime)
        assertEquals("capsule", result.dragon?.capsule)
        assertEquals(1000.0, result.dragon?.massReturnedKg)
        assertEquals(2204.62, result.dragon?.massReturnedLbs)
        assertEquals(3600.0, result.dragon?.flightTimeSec)
        assertEquals("manifest", result.dragon?.manifest)
        assertTrue(result.dragon?.waterLanding == true)
        assertFalse(result.dragon?.landLanding == true)
    }

    @Test
    fun testPayloadByIdInternetFailure() {
        val client = mockk<SpaceXClientV4>()
        every { client.payloads.getById("id") } throws RuntimeException("Internet connection error")

        assertFailsWith<RuntimeException> {
            client.payloads.getById("id")
        }
    }

    @Test
    fun testPayloadById400StatusCode() {
        val client = mockk<SpaceXClientV4>()
        every { client.payloads.getById("id") } throws RuntimeException("HTTP 400 Bad Request")

        assertFailsWith<RuntimeException> {
            client.payloads.getById("id")
        }
    }

    @Test
    fun testQueryPayloadsSuccess() {
        val client = mockk<SpaceXClientV4>()
        val paginatedResponse = PaginatedResponse(
            docs = listOf(
                PayloadDto(
                    "id",
                    "name",
                    "type",
                    false,
                    "launch",
                    emptyList(),
                    emptyList(),
                    emptyList(),
                    emptyList(),
                    1000.0,
                    2204.62,
                    "orbit",
                    "referenceSystem",
                    "regime",
                    0.0,
                    0.0,
                    0.0,
                    0.0,
                    0.0,
                    0.0,
                    0.0,
                    0.0,
                    "epoch",
                    0.0,
                    0.0,
                    0.0,
                    0.0,
                    PayloadDto.Dragon(
                        "capsule",
                        1000.0,
                        2204.62,
                        3600.0,
                        "manifest",
                        true,
                        false
                    )
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
        every { client.payloads.query(any()) } returns paginatedResponse

        val result = client.payloads.query(mapOf("limit" to 1))
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
        assertEquals("type", result.docs[0].type)
        assertFalse(result.docs[0].reused)
        assertEquals("launch", result.docs[0].launch)
        assertEquals(1000.0, result.docs[0].massKg)
        assertEquals(2204.62, result.docs[0].massLbs)
        assertEquals("orbit", result.docs[0].orbit)
        assertEquals("referenceSystem", result.docs[0].referenceSystem)
        assertEquals("regime", result.docs[0].regime)
        assertEquals("capsule", result.docs[0].dragon?.capsule)
        assertEquals(1000.0, result.docs[0].dragon?.massReturnedKg)
        assertEquals(2204.62, result.docs[0].dragon?.massReturnedLbs)
        assertEquals(3600.0, result.docs[0].dragon?.flightTimeSec)
        assertEquals("manifest", result.docs[0].dragon?.manifest)
        assertTrue(result.docs[0].dragon?.waterLanding == true)
        assertFalse(result.docs[0].dragon?.landLanding == true)
    }

    @Test
    fun testQueryPayloadsInternetFailure() {
        val client = mockk<SpaceXClientV4>()
        every { client.payloads.query(any()) } throws RuntimeException("Internet connection error")

        assertFailsWith<RuntimeException> {
            client.payloads.query(mapOf("limit" to 1))
        }
    }

    @Test
    fun testQueryPayloads400StatusCode() {
        val client = mockk<SpaceXClientV4>()
        every { client.payloads.query(any()) } throws RuntimeException("HTTP 400 Bad Request")

        assertFailsWith<RuntimeException> {
            client.payloads.query(mapOf("limit" to 1))
        }
    }
}