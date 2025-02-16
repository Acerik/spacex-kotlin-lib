package v4

import cz.matejvana.spacexkotapi.request.PaginatedResponse
import cz.matejvana.spacexkotapi.v4.ClientV4
import cz.matejvana.spacexkotapi.v4.ships.ShipDto
import io.mockk.every
import io.mockk.mockk
import kotlin.test.*

class ShipsIT {

    @Test
    fun testGetAllShips() {
        val client = mockk<ClientV4>()
        every { client.ships.getAll() } returns listOf(
            ShipDto(
                "id1",
                "Ship 1",
                "legacyId1",
                "model1",
                "type1",
                listOf("role1", "role2"),
                true,
                123456,
                654321,
                111,
                222,
                10000,
                22046,
                2010,
                "Port 1",
                "active",
                20,
                90,
                30.0,
                -90.0,
                "2023-01-01T00:00:00Z",
                "https://link1.com",
                "https://image1.com",
                listOf("launch1", "launch2")
            ),
            ShipDto(
                "id2",
                "Ship 2",
                "legacyId2",
                "model2",
                "type2",
                listOf("role3", "role4"),
                false,
                789012,
                210987,
                333,
                444,
                20000,
                44092,
                2015,
                "Port 2",
                "inactive",
                25,
                180,
                45.0,
                -45.0,
                "2023-01-02T00:00:00Z",
                "https://link2.com",
                "https://image2.com",
                listOf("launch3", "launch4")
            )
        )

        val ships = client.ships.getAll()
        assertTrue(ships.isNotEmpty())
        assertEquals(2, ships.size)
        assertEquals("id1", ships[0].id)
        assertEquals("Ship 1", ships[0].name)
        assertEquals("legacyId1", ships[0].legacyId)
        assertEquals("model1", ships[0].model)
        assertEquals("type1", ships[0].type)
        assertEquals(listOf("role1", "role2"), ships[0].roles)
        assertTrue(ships[0].active)
        assertEquals(123456, ships[0].imo)
        assertEquals(654321, ships[0].mmsi)
        assertEquals(111, ships[0].abs)
        assertEquals(222, ships[0].shipClass)
        assertEquals(10000, ships[0].massKg)
        assertEquals(22046, ships[0].massLbs)
        assertEquals(2010, ships[0].yearBuilt)
        assertEquals("Port 1", ships[0].homePort)
        assertEquals("active", ships[0].status)
        assertEquals(20, ships[0].speedKn)
        assertEquals(90, ships[0].courseDeg)
        assertEquals(30.0, ships[0].latitude)
        assertEquals(-90.0, ships[0].longitude)
        assertEquals("2023-01-01T00:00:00Z", ships[0].lastAisUpdate)
        assertEquals("https://link1.com", ships[0].link)
        assertEquals("https://image1.com", ships[0].image)
        assertEquals(listOf("launch1", "launch2"), ships[0].launches)

        assertEquals("id2", ships[1].id)
        assertEquals("Ship 2", ships[1].name)
        assertEquals("legacyId2", ships[1].legacyId)
        assertEquals("model2", ships[1].model)
        assertEquals("type2", ships[1].type)
        assertEquals(listOf("role3", "role4"), ships[1].roles)
        assertFalse(ships[1].active)
        assertEquals(789012, ships[1].imo)
        assertEquals(210987, ships[1].mmsi)
        assertEquals(333, ships[1].abs)
        assertEquals(444, ships[1].shipClass)
        assertEquals(20000, ships[1].massKg)
        assertEquals(44092, ships[1].massLbs)
        assertEquals(2015, ships[1].yearBuilt)
        assertEquals("Port 2", ships[1].homePort)
        assertEquals("inactive", ships[1].status)
        assertEquals(25, ships[1].speedKn)
        assertEquals(180, ships[1].courseDeg)
        assertEquals(45.0, ships[1].latitude)
        assertEquals(-45.0, ships[1].longitude)
        assertEquals("2023-01-02T00:00:00Z", ships[1].lastAisUpdate)
        assertEquals("https://link2.com", ships[1].link)
        assertEquals("https://image2.com", ships[1].image)
        assertEquals(listOf("launch3", "launch4"), ships[1].launches)
    }

    @Test
    fun testGetAllShipsInternetFailure() {
        val client = mockk<ClientV4>()
        every { client.ships.getAll() } throws RuntimeException("Internet connection error")

        assertFailsWith<RuntimeException> {
            client.ships.getAll()
        }
    }

    @Test
    fun testGetAllShips400StatusCode() {
        val client = mockk<ClientV4>()
        every { client.ships.getAll() } throws RuntimeException("HTTP 400 Bad Request")

        assertFailsWith<RuntimeException> {
            client.ships.getAll()
        }
    }

    @Test
    fun testGetShipByIdSuccess() {
        val client = mockk<ClientV4>()
        val ship = ShipDto(
            "id",
            "Ship 1",
            "legacyId1",
            "model1",
            "type1",
            listOf("role1", "role2"),
            true,
            123456,
            654321,
            111,
            222,
            10000,
            22046,
            2010,
            "Port 1",
            "active",
            20,
            90,
            30.0,
            -90.0,
            "2023-01-01T00:00:00Z",
            "https://link1.com",
            "https://image1.com",
            listOf("launch1", "launch2")
        )
        every { client.ships.getById("id") } returns ship

        val result = client.ships.getById("id")
        assertNotNull(result)
        assertEquals("id", result.id)
        assertEquals("Ship 1", result.name)
        assertEquals("legacyId1", result.legacyId)
        assertEquals("model1", result.model)
        assertEquals("type1", result.type)
        assertEquals(listOf("role1", "role2"), result.roles)
        assertTrue(result.active)
        assertEquals(123456, result.imo)
        assertEquals(654321, result.mmsi)
        assertEquals(111, result.abs)
        assertEquals(222, result.shipClass)
        assertEquals(10000, result.massKg)
        assertEquals(22046, result.massLbs)
        assertEquals(2010, result.yearBuilt)
        assertEquals("Port 1", result.homePort)
        assertEquals("active", result.status)
        assertEquals(20, result.speedKn)
        assertEquals(90, result.courseDeg)
        assertEquals(30.0, result.latitude)
        assertEquals(-90.0, result.longitude)
        assertEquals("2023-01-01T00:00:00Z", result.lastAisUpdate)
        assertEquals("https://link1.com", result.link)
        assertEquals("https://image1.com", result.image)
        assertEquals(listOf("launch1", "launch2"), result.launches)
    }

    @Test
    fun testGetShipByIdInternetFailure() {
        val client = mockk<ClientV4>()
        every { client.ships.getById("id") } throws RuntimeException("Internet connection error")

        assertFailsWith<RuntimeException> {
            client.ships.getById("id")
        }
    }

    @Test
    fun testGetShipById400StatusCode() {
        val client = mockk<ClientV4>()
        every { client.ships.getById("id") } throws RuntimeException("HTTP 400 Bad Request")

        assertFailsWith<RuntimeException> {
            client.ships.getById("id")
        }
    }

    @Test
    fun testQueryShipsSuccess() {
        val client = mockk<ClientV4>()
        val paginatedResponse = PaginatedResponse(
            docs = listOf(
                ShipDto(
                    "id",
                    "Ship 1",
                    "legacyId1",
                    "model1",
                    "type1",
                    listOf("role1", "role2"),
                    true,
                    123456,
                    654321,
                    111,
                    222,
                    10000,
                    22046,
                    2010,
                    "Port 1",
                    "active",
                    20,
                    90,
                    30.0,
                    -90.0,
                    "2023-01-01T00:00:00Z",
                    "https://link1.com",
                    "https://image1.com",
                    listOf("launch1", "launch2")
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
        every { client.ships.query(any()) } returns paginatedResponse

        val result = client.ships.query(mapOf("active" to true))
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
        assertEquals("Ship 1", result.docs[0].name)
        assertEquals("legacyId1", result.docs[0].legacyId)
        assertEquals("model1", result.docs[0].model)
        assertEquals("type1", result.docs[0].type)
        assertEquals(listOf("role1", "role2"), result.docs[0].roles)
        assertTrue(result.docs[0].active)
        assertEquals(123456, result.docs[0].imo)
        assertEquals(654321, result.docs[0].mmsi)
        assertEquals(111, result.docs[0].abs)
        assertEquals(222, result.docs[0].shipClass)
        assertEquals(10000, result.docs[0].massKg)
        assertEquals(22046, result.docs[0].massLbs)
        assertEquals(2010, result.docs[0].yearBuilt)
        assertEquals("Port 1", result.docs[0].homePort)
        assertEquals("active", result.docs[0].status)
        assertEquals(20, result.docs[0].speedKn)
        assertEquals(90, result.docs[0].courseDeg)
        assertEquals(30.0, result.docs[0].latitude)
        assertEquals(-90.0, result.docs[0].longitude)
        assertEquals("2023-01-01T00:00:00Z", result.docs[0].lastAisUpdate)
        assertEquals("https://link1.com", result.docs[0].link)
        assertEquals("https://image1.com", result.docs[0].image)
        assertEquals(listOf("launch1", "launch2"), result.docs[0].launches)
    }

    @Test
    fun testQueryShipsInternetFailure() {
        val client = mockk<ClientV4>()
        every { client.ships.query(any()) } throws RuntimeException("Internet connection error")

        assertFailsWith<RuntimeException> {
            client.ships.query(mapOf("active" to true))
        }
    }

    @Test
    fun testQueryShips400StatusCode() {
        val client = mockk<ClientV4>()
        every { client.ships.query(any()) } throws RuntimeException("HTTP 400 Bad Request")

        assertFailsWith<RuntimeException> {
            client.ships.query(mapOf("active" to true))
        }
    }
}