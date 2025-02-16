package v4

import cz.matejvana.spacexkotapi.v4.SpaceXClientV4
import cz.matejvana.spacexkotapi.v4.starlink.StarlinkDto
import io.mockk.every
import io.mockk.mockk
import kotlin.test.*

class StarlinkIT {

    @Test
    fun testGetAllStarlink() {
        val client = mockk<SpaceXClientV4>()
        every { client.starlink.getAll() } returns listOf(
            StarlinkDto(
                id = "id1",
                version = "v0.9",
                launch = "5eb87d30ffd86e000604b378",
                longitude = 30.0,
                latitude = -90.0,
                heightKm = 550.0,
                velocityKms = 7.5,
                spaceTrack = StarlinkDto.SpaceTrack(
                    ccsdsOmmVers = "2.0",
                    comment = "GENERATED VIA SPACE-TRACK.ORG API",
                    creationDate = "2020-10-13T04:16:08",
                    originator = "18 SPCS",
                    objectName = "STARLINK-30",
                    objectId = "2019-029K",
                    centerName = "EARTH",
                    refFrame = "TEME",
                    timeSystem = "UTC",
                    meanElementTheory = "SGP4",
                    epoch = "2020-10-13T02:56:59.566560",
                    meanMotion = 16.43170483,
                    eccentricity = 0.0003711,
                    inclination = 52.9708,
                    raOfAscNode = 332.0356,
                    argOfPericenter = 120.7278,
                    meanAnomaly = 242.0157,
                    ephemerisType = 0,
                    classificationType = "U",
                    noradCatId = 44244,
                    elementSetNo = 999,
                    revAtEpoch = 7775,
                    bstar = 0.0022139,
                    meanMotionDot = 0.47180237,
                    meanMotionDdot = 0.000012426,
                    semimajorAxis = 6535.519,
                    period = 87.635,
                    apoapsis = 159.809,
                    periapsis = 154.958,
                    objectType = "PAYLOAD",
                    rcsSize = "LARGE",
                    countryCode = "US",
                    launchDate = "2019-05-24",
                    site = "AFETR",
                    decayDate = "2020-10-13",
                    decayed = 1,
                    file = 2850561,
                    gpId = 163365918,
                    tleLine0 = "0 STARLINK-30",
                    tleLine1 = "1 44244U 19029K   20287.12291165  .47180237  12426-4  22139-2 0  9995",
                    tleLine2 = "2 44244  52.9708 332.0356 0003711 120.7278 242.0157 16.43170483 77756"
                )
            )
        )

        val starlink = client.starlink.getAll()
        assertTrue(starlink.isNotEmpty())
        assertEquals(1, starlink.size)
        assertEquals("id1", starlink[0].id)
        assertEquals("v0.9", starlink[0].version)
        assertEquals("5eb87d30ffd86e000604b378", starlink[0].launch)
        assertEquals(30.0, starlink[0].longitude)
        assertEquals(-90.0, starlink[0].latitude)
        assertEquals(550.0, starlink[0].heightKm)
        assertEquals(7.5, starlink[0].velocityKms)
        assertNotNull(starlink[0].spaceTrack)
        assertEquals("2.0", starlink[0].spaceTrack?.ccsdsOmmVers)
        assertEquals("GENERATED VIA SPACE-TRACK.ORG API", starlink[0].spaceTrack?.comment)
        assertEquals("2020-10-13T04:16:08", starlink[0].spaceTrack?.creationDate)
        assertEquals("18 SPCS", starlink[0].spaceTrack?.originator)
        assertEquals("STARLINK-30", starlink[0].spaceTrack?.objectName)
        assertEquals("2019-029K", starlink[0].spaceTrack?.objectId)
        assertEquals("EARTH", starlink[0].spaceTrack?.centerName)
        assertEquals("TEME", starlink[0].spaceTrack?.refFrame)
        assertEquals("UTC", starlink[0].spaceTrack?.timeSystem)
        assertEquals("SGP4", starlink[0].spaceTrack?.meanElementTheory)
        assertEquals("2020-10-13T02:56:59.566560", starlink[0].spaceTrack?.epoch)
        assertEquals(16.43170483, starlink[0].spaceTrack?.meanMotion)
        assertEquals(0.0003711, starlink[0].spaceTrack?.eccentricity)
        assertEquals(52.9708, starlink[0].spaceTrack?.inclination)
        assertEquals(332.0356, starlink[0].spaceTrack?.raOfAscNode)
        assertEquals(120.7278, starlink[0].spaceTrack?.argOfPericenter)
        assertEquals(242.0157, starlink[0].spaceTrack?.meanAnomaly)
        assertEquals(0, starlink[0].spaceTrack?.ephemerisType)
        assertEquals("U", starlink[0].spaceTrack?.classificationType)
        assertEquals(44244, starlink[0].spaceTrack?.noradCatId)
        assertEquals(999, starlink[0].spaceTrack?.elementSetNo)
        assertEquals(7775, starlink[0].spaceTrack?.revAtEpoch)
        assertEquals(0.0022139, starlink[0].spaceTrack?.bstar)
        assertEquals(0.47180237, starlink[0].spaceTrack?.meanMotionDot)
        assertEquals(0.000012426, starlink[0].spaceTrack?.meanMotionDdot)
        assertEquals(6535.519, starlink[0].spaceTrack?.semimajorAxis)
        assertEquals(87.635, starlink[0].spaceTrack?.period)
        assertEquals(159.809, starlink[0].spaceTrack?.apoapsis)
        assertEquals(154.958, starlink[0].spaceTrack?.periapsis)
        assertEquals("PAYLOAD", starlink[0].spaceTrack?.objectType)
        assertEquals("LARGE", starlink[0].spaceTrack?.rcsSize)
        assertEquals("US", starlink[0].spaceTrack?.countryCode)
        assertEquals("2019-05-24", starlink[0].spaceTrack?.launchDate)
        assertEquals("AFETR", starlink[0].spaceTrack?.site)
        assertEquals("2020-10-13", starlink[0].spaceTrack?.decayDate)
        assertEquals(1, starlink[0].spaceTrack?.decayed)
        assertEquals(2850561, starlink[0].spaceTrack?.file)
        assertEquals(163365918, starlink[0].spaceTrack?.gpId)
        assertEquals("0 STARLINK-30", starlink[0].spaceTrack?.tleLine0)
        assertEquals(
            "1 44244U 19029K   20287.12291165  .47180237  12426-4  22139-2 0  9995",
            starlink[0].spaceTrack?.tleLine1
        )
        assertEquals(
            "2 44244  52.9708 332.0356 0003711 120.7278 242.0157 16.43170483 77756",
            starlink[0].spaceTrack?.tleLine2
        )
    }

    @Test
    fun testGetAllStarlinkInternetFailure() {
        val client = mockk<SpaceXClientV4>()
        every { client.starlink.getAll() } throws RuntimeException("Internet connection error")

        assertFailsWith<RuntimeException> {
            client.starlink.getAll()
        }
    }

    @Test
    fun testGetAllStarlink400StatusCode() {
        val client = mockk<SpaceXClientV4>()
        every { client.starlink.getAll() } throws RuntimeException("HTTP 400 Bad Request")

        assertFailsWith<RuntimeException> {
            client.starlink.getAll()
        }
    }

    @Test
    fun testGetStarlinkByIdSuccess() {
        val client = mockk<SpaceXClientV4>()
        val starlink = StarlinkDto(
            id = "id",
            version = "v0.9",
            launch = "5eb87d30ffd86e000604b378",
            longitude = 30.0,
            latitude = -90.0,
            heightKm = 550.0,
            velocityKms = 7.5,
            spaceTrack = StarlinkDto.SpaceTrack(
                ccsdsOmmVers = "2.0",
                comment = "GENERATED VIA SPACE-TRACK.ORG API",
                creationDate = "2020-10-13T04:16:08",
                originator = "18 SPCS",
                objectName = "STARLINK-30",
                objectId = "2019-029K",
                centerName = "EARTH",
                refFrame = "TEME",
                timeSystem = "UTC",
                meanElementTheory = "SGP4",
                epoch = "2020-10-13T02:56:59.566560",
                meanMotion = 16.43170483,
                eccentricity = 0.0003711,
                inclination = 52.9708,
                raOfAscNode = 332.0356,
                argOfPericenter = 120.7278,
                meanAnomaly = 242.0157,
                ephemerisType = 0,
                classificationType = "U",
                noradCatId = 44244,
                elementSetNo = 999,
                revAtEpoch = 7775,
                bstar = 0.0022139,
                meanMotionDot = 0.47180237,
                meanMotionDdot = 0.000012426,
                semimajorAxis = 6535.519,
                period = 87.635,
                apoapsis = 159.809,
                periapsis = 154.958,
                objectType = "PAYLOAD",
                rcsSize = "LARGE",
                countryCode = "US",
                launchDate = "2019-05-24",
                site = "AFETR",
                decayDate = "2020-10-13",
                decayed = 1,
                file = 2850561,
                gpId = 163365918,
                tleLine0 = "0 STARLINK-30",
                tleLine1 = "1 44244U 19029K   20287.12291165  .47180237  12426-4  22139-2 0  9995",
                tleLine2 = "2 44244  52.9708 332.0356 0003711 120.7278 242.0157 16.43170483 77756"
            )
        )
        every { client.starlink.getById("id") } returns starlink

        val result = client.starlink.getById("id")
        assertNotNull(result)
        assertEquals("id", result.id)
        assertEquals("v0.9", result.version)
        assertEquals("5eb87d30ffd86e000604b378", result.launch)
        assertEquals(30.0, result.longitude)
        assertEquals(-90.0, result.latitude)
        assertEquals(550.0, result.heightKm)
        assertEquals(7.5, result.velocityKms)
        assertNotNull(result.spaceTrack)
        assertEquals("2.0", result.spaceTrack?.ccsdsOmmVers)
        assertEquals("GENERATED VIA SPACE-TRACK.ORG API", result.spaceTrack?.comment)
        assertEquals("2020-10-13T04:16:08", result.spaceTrack?.creationDate)
        assertEquals("18 SPCS", result.spaceTrack?.originator)
        assertEquals("STARLINK-30", result.spaceTrack?.objectName)
        assertEquals("2019-029K", result.spaceTrack?.objectId)
        assertEquals("EARTH", result.spaceTrack?.centerName)
        assertEquals("TEME", result.spaceTrack?.refFrame)
        assertEquals("UTC", result.spaceTrack?.timeSystem)
        assertEquals("SGP4", result.spaceTrack?.meanElementTheory)
        assertEquals("2020-10-13T02:56:59.566560", result.spaceTrack?.epoch)
        assertEquals(16.43170483, result.spaceTrack?.meanMotion)
        assertEquals(0.0003711, result.spaceTrack?.eccentricity)
        assertEquals(52.9708, result.spaceTrack?.inclination)
        assertEquals(332.0356, result.spaceTrack?.raOfAscNode)
        assertEquals(120.7278, result.spaceTrack?.argOfPericenter)
        assertEquals(242.0157, result.spaceTrack?.meanAnomaly)
        assertEquals(0, result.spaceTrack?.ephemerisType)
        assertEquals("U", result.spaceTrack?.classificationType)
        assertEquals(44244, result.spaceTrack?.noradCatId)
        assertEquals(999, result.spaceTrack?.elementSetNo)
        assertEquals(7775, result.spaceTrack?.revAtEpoch)
        assertEquals(0.0022139, result.spaceTrack?.bstar)
        assertEquals(0.47180237, result.spaceTrack?.meanMotionDot)
        assertEquals(0.000012426, result.spaceTrack?.meanMotionDdot)
        assertEquals(6535.519, result.spaceTrack?.semimajorAxis)
        assertEquals(87.635, result.spaceTrack?.period)
        assertEquals(159.809, result.spaceTrack?.apoapsis)
        assertEquals(154.958, result.spaceTrack?.periapsis)
        assertEquals("PAYLOAD", result.spaceTrack?.objectType)
        assertEquals("LARGE", result.spaceTrack?.rcsSize)
        assertEquals("US", result.spaceTrack?.countryCode)
        assertEquals("2019-05-24", result.spaceTrack?.launchDate)
        assertEquals("AFETR", result.spaceTrack?.site)
        assertEquals("2020-10-13", result.spaceTrack?.decayDate)
        assertEquals(1, result.spaceTrack?.decayed)
        assertEquals(2850561, result.spaceTrack?.file)
        assertEquals(163365918, result.spaceTrack?.gpId)
        assertEquals("0 STARLINK-30", result.spaceTrack?.tleLine0)
        assertEquals(
            "1 44244U 19029K   20287.12291165  .47180237  12426-4  22139-2 0  9995",
            result.spaceTrack?.tleLine1
        )
        assertEquals(
            "2 44244  52.9708 332.0356 0003711 120.7278 242.0157 16.43170483 77756",
            result.spaceTrack?.tleLine2
        )
    }

    @Test
    fun testGetStarlinkByIdInternetFailure() {
        val client = mockk<SpaceXClientV4>()
        every { client.starlink.getById("id") } throws RuntimeException("Internet connection error")

        assertFailsWith<RuntimeException> {
            client.starlink.getById("id")
        }
    }

    @Test
    fun testGetStarlinkById400StatusCode() {
        val client = mockk<SpaceXClientV4>()
        every { client.starlink.getById("id") } throws RuntimeException("HTTP 400 Bad Request")

        assertFailsWith<RuntimeException> {
            client.starlink.getById("id")
        }
    }
}