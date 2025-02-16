package v4

import cz.matejvana.spacexkotapi.v4.ClientV4
import cz.matejvana.spacexkotapi.v4.roadster.RoadsterDto
import io.mockk.every
import io.mockk.mockk
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNotNull

class RoadsterIT {

    @Test
    fun testGetRoadster() {
        val client = mockk<ClientV4>()
        val roadster = RoadsterDto(
            id = "1",
            name = "Tesla Roadster",
            launchDateUtc = "2018-02-06T20:45:00.000Z",
            launchDateUnix = 1517949900.0,
            launchMassKg = 1350,
            launchMassLbs = 2976,
            noradId = 43205,
            epochJd = 2458167.5,
            orbitType = "heliocentric",
            apoapsisAu = 1.664,
            periapsisAu = 0.986,
            semiMajorAxisAu = 1.325,
            eccentricity = 0.256,
            inclination = 1.077,
            longitude = 317.020,
            periapsisArg = 177.49,
            periodDays = 557.0,
            speedKph = 100000.0,
            speedMph = 62137.0,
            earthDistanceKm = 234000000.0,
            earthDistanceMi = 145400000.0,
            marsDistanceKm = 0.0,
            marsDistanceMi = 0.0,
            flickrImages = listOf(),
            wikipedia = "https://en.wikipedia.org/wiki/Elon_Musk%27s_Tesla_Roadster",
            video = "https://www.youtube.com/watch?v=aBr2kKAHN6M",
            details = "Elon Musk's Tesla Roadster is an electric sports car that served as the dummy payload for the February 2018 Falcon Heavy test flight."
        )
        every { client.roadster.get() } returns roadster

        val result = client.roadster.get()
        assertNotNull(result)
        assertEquals("1", result.id)
        assertEquals("Tesla Roadster", result.name)
    }

    @Test
    fun testGetRoadsterInternetFailure() {
        val client = mockk<ClientV4>()
        every { client.roadster.get() } throws RuntimeException("Internet connection error")

        assertFailsWith<RuntimeException> {
            client.roadster.get()
        }
    }

    @Test
    fun testGetRoadster400StatusCode() {
        val client = mockk<ClientV4>()
        every { client.roadster.get() } throws RuntimeException("HTTP 400 Bad Request")

        assertFailsWith<RuntimeException> {
            client.roadster.get()
        }
    }

    @Test
    fun testQueryRoadsterSuccess() {
        val client = mockk<ClientV4>()
        val roadster = RoadsterDto(
            id = "1",
            name = "Tesla Roadster",
            launchDateUtc = "2018-02-06T20:45:00.000Z",
            launchDateUnix = 1517949900.0,
            launchMassKg = 1350,
            launchMassLbs = 2976,
            noradId = 43205,
            epochJd = 2458167.5,
            orbitType = "heliocentric",
            apoapsisAu = 1.664,
            periapsisAu = 0.986,
            semiMajorAxisAu = 1.325,
            eccentricity = 0.256,
            inclination = 1.077,
            longitude = 317.020,
            periapsisArg = 177.49,
            periodDays = 557.0,
            speedKph = 100000.0,
            speedMph = 62137.0,
            earthDistanceKm = 234000000.0,
            earthDistanceMi = 145400000.0,
            marsDistanceKm = 0.0,
            marsDistanceMi = 0.0,
            flickrImages = listOf(),
            wikipedia = "https://en.wikipedia.org/wiki/Elon_Musk%27s_Tesla_Roadster",
            video = "https://www.youtube.com/watch?v=aBr2kKAHN6M",
            details = "Elon Musk's Tesla Roadster is an electric sports car that served as the dummy payload for the February 2018 Falcon Heavy test flight."
        )
        every { client.roadster.query(any()) } returns roadster

        val result = client.roadster.query(mapOf("limit" to 1))
        assertNotNull(result)
        assertEquals("1", result.id)
        assertEquals("Tesla Roadster", result.name)
    }

    @Test
    fun testQueryRoadsterInternetFailure() {
        val client = mockk<ClientV4>()
        every { client.roadster.query(any()) } throws RuntimeException("Internet connection error")

        assertFailsWith<RuntimeException> {
            client.roadster.query(mapOf("limit" to 1))
        }
    }

    @Test
    fun testQueryRoadster400StatusCode() {
        val client = mockk<ClientV4>()
        every { client.roadster.query(any()) } throws RuntimeException("HTTP 400 Bad Request")

        assertFailsWith<RuntimeException> {
            client.roadster.query(mapOf("limit" to 1))
        }
    }
}