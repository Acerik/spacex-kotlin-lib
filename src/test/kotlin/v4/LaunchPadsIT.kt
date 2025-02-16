package v4

import cz.matejvana.spacexkotapi.request.PaginatedResponse
import cz.matejvana.spacexkotapi.v4.Images
import cz.matejvana.spacexkotapi.v4.SpaceXClientV4
import cz.matejvana.spacexkotapi.v4.launchpads.LaunchPadDto
import io.mockk.every
import io.mockk.mockk
import kotlin.test.*

class LaunchPadsIT {

    @Test
    fun testAllLaunchPadsSuccess() {
        val client = mockk<SpaceXClientV4>()
        every { client.launchPads.getAll() } returns listOf(
            LaunchPadDto(
                "id",
                "name",
                "fullName",
                "status",
                "locality",
                "region",
                "timezone",
                28.5623,
                -80.5774,
                10,
                8,
                emptyList(),
                emptyList(),
                Images(listOf("image1", "image2")),
                "details"
            ),
            LaunchPadDto(
                "id2",
                "name2",
                "fullName2",
                "status2",
                "locality2",
                "region2",
                "timezone2",
                34.6321,
                -120.6108,
                5,
                4,
                emptyList(),
                emptyList(),
                Images(listOf("image3", "image4")),
                "details2"
            )
        )

        val launchPads = client.launchPads.getAll()
        assertTrue(launchPads.isNotEmpty())
        assertEquals(2, launchPads.size)
        assertEquals("id", launchPads[0].id)
        assertEquals("name", launchPads[0].name)
        assertEquals("fullName", launchPads[0].fullName)
        assertEquals("status", launchPads[0].status)
        assertEquals("locality", launchPads[0].locality)
        assertEquals("region", launchPads[0].region)
        assertEquals("timezone", launchPads[0].timezone)
        assertEquals(28.5623, launchPads[0].latitude)
        assertEquals(-80.5774, launchPads[0].longitude)
        assertEquals(10, launchPads[0].launchAttempts)
        assertEquals(8, launchPads[0].launchSuccesses)
        assertTrue(launchPads[0].rockets.isEmpty())
        assertTrue(launchPads[0].launches.isEmpty())
        assertEquals(listOf("image1", "image2"), launchPads[0].images?.large)
        assertEquals("details", launchPads[0].details)

        assertEquals("id2", launchPads[1].id)
        assertEquals("name2", launchPads[1].name)
        assertEquals("fullName2", launchPads[1].fullName)
        assertEquals("status2", launchPads[1].status)
        assertEquals("locality2", launchPads[1].locality)
        assertEquals("region2", launchPads[1].region)
        assertEquals("timezone2", launchPads[1].timezone)
        assertEquals(34.6321, launchPads[1].latitude)
        assertEquals(-120.6108, launchPads[1].longitude)
        assertEquals(5, launchPads[1].launchAttempts)
        assertEquals(4, launchPads[1].launchSuccesses)
        assertTrue(launchPads[1].rockets.isEmpty())
        assertTrue(launchPads[1].launches.isEmpty())
        assertEquals(listOf("image3", "image4"), launchPads[1].images?.large)
        assertEquals("details2", launchPads[1].details)
    }

    @Test
    fun testAllLaunchPadsInternetFailure() {
        val client = mockk<SpaceXClientV4>()
        every { client.launchPads.getAll() } throws RuntimeException("Internet connection error")

        assertFailsWith<RuntimeException> {
            client.launchPads.getAll()
        }
    }

    @Test
    fun testAllLaunchPads400StatusCode() {
        val client = mockk<SpaceXClientV4>()
        every { client.launchPads.getAll() } throws RuntimeException("HTTP 400 Bad Request")

        assertFailsWith<RuntimeException> {
            client.launchPads.getAll()
        }
    }

    @Test
    fun testLaunchPadByIdSuccess() {
        val client = mockk<SpaceXClientV4>()
        val launchPad = LaunchPadDto(
            "id",
            "name",
            "fullName",
            "status",
            "locality",
            "region",
            "timezone",
            28.5623,
            -80.5774,
            10,
            8,
            emptyList(),
            emptyList(),
            Images(listOf("image1", "image2")),
            "details"
        )
        every { client.launchPads.getById("id") } returns launchPad

        val result = client.launchPads.getById("id")
        assertNotNull(result)
        assertEquals("id", result.id)
        assertEquals("name", result.name)
        assertEquals("fullName", result.fullName)
        assertEquals("status", result.status)
        assertEquals("locality", result.locality)
        assertEquals("region", result.region)
        assertEquals("timezone", result.timezone)
        assertEquals(28.5623, result.latitude)
        assertEquals(-80.5774, result.longitude)
        assertEquals(10, result.launchAttempts)
        assertEquals(8, result.launchSuccesses)
        assertTrue(result.rockets.isEmpty())
        assertTrue(result.launches.isEmpty())
        assertEquals(listOf("image1", "image2"), result.images?.large)
        assertEquals("details", result.details)
    }

    @Test
    fun testLaunchPadByIdInternetFailure() {
        val client = mockk<SpaceXClientV4>()
        every { client.launchPads.getById("id") } throws RuntimeException("Internet connection error")

        assertFailsWith<RuntimeException> {
            client.launchPads.getById("id")
        }
    }

    @Test
    fun testLaunchPadById400StatusCode() {
        val client = mockk<SpaceXClientV4>()
        every { client.launchPads.getById("id") } throws RuntimeException("HTTP 400 Bad Request")

        assertFailsWith<RuntimeException> {
            client.launchPads.getById("id")
        }
    }

    @Test
    fun testQueryLaunchPadsSuccess() {
        val client = mockk<SpaceXClientV4>()
        val paginatedResponse = PaginatedResponse(
            docs = listOf(
                LaunchPadDto(
                    "id",
                    "name",
                    "fullName",
                    "status",
                    "locality",
                    "region",
                    "timezone",
                    28.5623,
                    -80.5774,
                    10,
                    8,
                    emptyList(),
                    emptyList(),
                    Images(listOf("image1", "image2")),
                    "details"
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
        every { client.launchPads.query(any()) } returns paginatedResponse

        val result = client.launchPads.query(mapOf("limit" to 1))
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
        assertEquals("fullName", result.docs[0].fullName)
        assertEquals("status", result.docs[0].status)
        assertEquals("locality", result.docs[0].locality)
        assertEquals("region", result.docs[0].region)
        assertEquals("timezone", result.docs[0].timezone)
        assertEquals(28.5623, result.docs[0].latitude)
        assertEquals(-80.5774, result.docs[0].longitude)
        assertEquals(10, result.docs[0].launchAttempts)
        assertEquals(8, result.docs[0].launchSuccesses)
        assertTrue(result.docs[0].rockets.isEmpty())
        assertTrue(result.docs[0].launches.isEmpty())
        assertEquals(listOf("image1", "image2"), result.docs[0].images?.large)
        assertEquals("details", result.docs[0].details)
    }

    @Test
    fun testQueryLaunchPadsInternetFailure() {
        val client = mockk<SpaceXClientV4>()
        every { client.launchPads.query(any()) } throws RuntimeException("Internet connection error")

        assertFailsWith<RuntimeException> {
            client.launchPads.query(mapOf("limit" to 1))
        }
    }

    @Test
    fun testQueryLaunchPads400StatusCode() {
        val client = mockk<SpaceXClientV4>()
        every { client.launchPads.query(any()) } throws RuntimeException("HTTP 400 Bad Request")

        assertFailsWith<RuntimeException> {
            client.launchPads.query(mapOf("limit" to 1))
        }
    }
}