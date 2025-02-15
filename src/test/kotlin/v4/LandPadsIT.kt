package v4

import cz.matejvana.spacexkotapi.request.PaginatedResponse
import cz.matejvana.spacexkotapi.v4.ClientV4
import cz.matejvana.spacexkotapi.v4.Images
import cz.matejvana.spacexkotapi.v4.landpads.LandingPadDto
import io.mockk.every
import io.mockk.mockk
import kotlin.test.*

class LandPadsIT {

    @Test
    fun testAllLandingPadsSuccess() {
        val client = mockk<ClientV4>()
        every { client.landPads.getAll() } returns listOf(
            LandingPadDto(
                "id",
                "name",
                "fullName",
                "status",
                "type",
                "locality",
                "region",
                28.5623,
                -80.5774,
                10,
                8,
                "wikipedia",
                "details",
                emptyList(),
                Images(listOf("image1", "image2"))
            ),
            LandingPadDto(
                "id2",
                "name2",
                "fullName2",
                "status2",
                "type2",
                "locality2",
                "region2",
                34.6321,
                -120.6108,
                5,
                4,
                "wikipedia2",
                "details2",
                emptyList(),
                Images(listOf("image3", "image4"))
            )
        )

        val landingPads = client.landPads.getAll()
        assertTrue(landingPads.isNotEmpty())
        assertEquals(2, landingPads.size)
        assertEquals("id", landingPads[0].id)
        assertEquals("name", landingPads[0].name)
        assertEquals("fullName", landingPads[0].fullName)
        assertEquals("status", landingPads[0].status)
        assertEquals("type", landingPads[0].type)
        assertEquals("locality", landingPads[0].locality)
        assertEquals("region", landingPads[0].region)
        assertEquals(28.5623, landingPads[0].latitude)
        assertEquals(-80.5774, landingPads[0].longitude)
        assertEquals(10, landingPads[0].landingAttempts)
        assertEquals(8, landingPads[0].landingSuccesses)
        assertEquals("wikipedia", landingPads[0].wikipedia)
        assertEquals("details", landingPads[0].details)
        assertTrue(landingPads[0].launches.isEmpty())
        assertEquals(listOf("image1", "image2"), landingPads[0].images?.large)

        assertEquals("id2", landingPads[1].id)
        assertEquals("name2", landingPads[1].name)
        assertEquals("fullName2", landingPads[1].fullName)
        assertEquals("status2", landingPads[1].status)
        assertEquals("type2", landingPads[1].type)
        assertEquals("locality2", landingPads[1].locality)
        assertEquals("region2", landingPads[1].region)
        assertEquals(34.6321, landingPads[1].latitude)
        assertEquals(-120.6108, landingPads[1].longitude)
        assertEquals(5, landingPads[1].landingAttempts)
        assertEquals(4, landingPads[1].landingSuccesses)
        assertEquals("wikipedia2", landingPads[1].wikipedia)
        assertEquals("details2", landingPads[1].details)
        assertTrue(landingPads[1].launches.isEmpty())
        assertEquals(listOf("image3", "image4"), landingPads[1].images?.large)
    }

    @Test
    fun testAllLandingPadsInternetFailure() {
        val client = mockk<ClientV4>()
        every { client.landPads.getAll() } throws RuntimeException("Internet connection error")

        assertFailsWith<RuntimeException> {
            client.landPads.getAll()
        }
    }

    @Test
    fun testAllLandingPads400StatusCode() {
        val client = mockk<ClientV4>()
        every { client.landPads.getAll() } throws RuntimeException("HTTP 400 Bad Request")

        assertFailsWith<RuntimeException> {
            client.landPads.getAll()
        }
    }

    @Test
    fun testLandingPadByIdSuccess() {
        val client = mockk<ClientV4>()
        val landingPad = LandingPadDto(
            "id",
            "name",
            "fullName",
            "status",
            "type",
            "locality",
            "region",
            28.5623,
            -80.5774,
            10,
            8,
            "wikipedia",
            "details",
            emptyList(),
            Images(listOf("image1", "image2"))
        )
        every { client.landPads.getById("id") } returns landingPad

        val result = client.landPads.getById("id")
        assertNotNull(result)
        assertEquals("id", result.id)
        assertEquals("name", result.name)
        assertEquals("fullName", result.fullName)
        assertEquals("status", result.status)
        assertEquals("type", result.type)
        assertEquals("locality", result.locality)
        assertEquals("region", result.region)
        assertEquals(28.5623, result.latitude)
        assertEquals(-80.5774, result.longitude)
        assertEquals(10, result.landingAttempts)
        assertEquals(8, result.landingSuccesses)
        assertEquals("wikipedia", result.wikipedia)
        assertEquals("details", result.details)
        assertTrue(result.launches.isEmpty())
        assertEquals(listOf("image1", "image2"), result.images?.large)
    }

    @Test
    fun testLandingPadByIdInternetFailure() {
        val client = mockk<ClientV4>()
        every { client.landPads.getById("id") } throws RuntimeException("Internet connection error")

        assertFailsWith<RuntimeException> {
            client.landPads.getById("id")
        }
    }

    @Test
    fun testLandingPadById400StatusCode() {
        val client = mockk<ClientV4>()
        every { client.landPads.getById("id") } throws RuntimeException("HTTP 400 Bad Request")

        assertFailsWith<RuntimeException> {
            client.landPads.getById("id")
        }
    }

    @Test
    fun testQueryLandingPadsSuccess() {
        val client = mockk<ClientV4>()
        val paginatedResponse = PaginatedResponse(
            docs = listOf(
                LandingPadDto(
                    "id",
                    "name",
                    "fullName",
                    "status",
                    "type",
                    "locality",
                    "region",
                    28.5623,
                    -80.5774,
                    10,
                    8,
                    "wikipedia",
                    "details",
                    emptyList(),
                    Images(listOf("image1", "image2"))
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
        every { client.landPads.query(any()) } returns paginatedResponse

        val result = client.landPads.query(mapOf("limit" to 1))
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
        assertEquals("type", result.docs[0].type)
        assertEquals("locality", result.docs[0].locality)
        assertEquals("region", result.docs[0].region)
        assertEquals(28.5623, result.docs[0].latitude)
        assertEquals(-80.5774, result.docs[0].longitude)
        assertEquals(10, result.docs[0].landingAttempts)
        assertEquals(8, result.docs[0].landingSuccesses)
        assertEquals("wikipedia", result.docs[0].wikipedia)
        assertEquals("details", result.docs[0].details)
        assertTrue(result.docs[0].launches.isEmpty())
        assertEquals(listOf("image1", "image2"), result.docs[0].images?.large)
    }

    @Test
    fun testQueryLandingPadsInternetFailure() {
        val client = mockk<ClientV4>()
        every { client.landPads.query(any()) } throws RuntimeException("Internet connection error")

        assertFailsWith<RuntimeException> {
            client.landPads.query(mapOf("limit" to 1))
        }
    }

    @Test
    fun testQueryLandingPads400StatusCode() {
        val client = mockk<ClientV4>()
        every { client.landPads.query(any()) } throws RuntimeException("HTTP 400 Bad Request")

        assertFailsWith<RuntimeException> {
            client.landPads.query(mapOf("limit" to 1))
        }
    }
}