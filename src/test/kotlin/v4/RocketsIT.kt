import cz.matejvana.spacexkotapi.request.PaginatedResponse
import cz.matejvana.spacexkotapi.v4.SpaceXClientV4
import cz.matejvana.spacexkotapi.v4.rockets.RocketDto
import io.mockk.every
import io.mockk.mockk
import kotlin.test.*

class RocketsIT {

    @Test
    fun testGetAllRockets() {
        val client = mockk<SpaceXClientV4>()
        every { client.rockets.getAll() } returns listOf(
            RocketDto(
                "id1",
                "Falcon 1",
                "rocket",
                true,
                2,
                0,
                6700000,
                40,
                "2006-03-24",
                "USA",
                "SpaceX",
                RocketDto.Dimension(22.25, 73.0),
                RocketDto.Dimension(1.68, 5.5),
                RocketDto.Mass(30146, 66460),
                listOf(),
                RocketDto.FirstStage(true, 1, 44.3, 169, RocketDto.Thrust(420, 940), RocketDto.Thrust(480, 1080)),
                RocketDto.SecondStage(
                    false,
                    1,
                    3.38,
                    378,
                    RocketDto.Thrust(31, 70),
                    RocketDto.Payloads(
                        "option1",
                        RocketDto.CompositeFairing(RocketDto.Dimension(3.5, 11.5), RocketDto.Dimension(1.68, 5.5))
                    )
                ),
                RocketDto.Engines(
                    1,
                    "merlin",
                    "1C",
                    null,
                    RocketDto.ISP(267, 304),
                    1,
                    "RP-1",
                    "LOX",
                    RocketDto.Thrust(420, 940),
                    RocketDto.Thrust(480, 1080),
                    96.0
                ),
                RocketDto.LandingLegs(0, null),
                listOf(),
                "https://en.wikipedia.org/wiki/Falcon_1",
                "The Falcon 1 was an expendable launch system privately developed and manufactured by SpaceX during 2006-2009."
            ),
            RocketDto(
                "id2",
                "Falcon 9",
                "rocket",
                true,
                2,
                0,
                50000000,
                97,
                "2010-06-04",
                "USA",
                "SpaceX",
                RocketDto.Dimension(70.0, 229.6),
                RocketDto.Dimension(3.7, 12.0),
                RocketDto.Mass(549054, 1207920),
                listOf(),
                RocketDto.FirstStage(
                    true,
                    9,
                    385.0,
                    162,
                    RocketDto.Thrust(7607, 1710000),
                    RocketDto.Thrust(8227, 1849500)
                ),
                RocketDto.SecondStage(
                    false,
                    1,
                    90.0,
                    397,
                    RocketDto.Thrust(934, 210000),
                    RocketDto.Payloads(
                        "option1",
                        RocketDto.CompositeFairing(RocketDto.Dimension(13.1, 43.0), RocketDto.Dimension(5.2, 17.1))
                    )
                ),
                RocketDto.Engines(
                    9,
                    "merlin",
                    "1D+",
                    "octaweb",
                    RocketDto.ISP(282, 311),
                    2,
                    "RP-1",
                    "LOX",
                    RocketDto.Thrust(7607, 1710000),
                    RocketDto.Thrust(8227, 1849500),
                    180.1
                ),
                RocketDto.LandingLegs(4, "carbon fiber"),
                listOf(),
                "https://en.wikipedia.org/wiki/Falcon_9",
                "The Falcon 9 is a partially reusable two-stage-to-orbit medium-lift launch vehicle designed and manufactured by SpaceX."
            )
        )

        val rockets = client.rockets.getAll()
        assertTrue(rockets.isNotEmpty())
        assertEquals(2, rockets.size)
        assertEquals("id1", rockets[0].id)
        assertEquals("Falcon 1", rockets[0].name)
        assertEquals("rocket", rockets[0].type)
        assertTrue(rockets[0].active)
        assertEquals(2, rockets[0].stages)
        assertEquals(0, rockets[0].boosters)
        assertEquals(6700000, rockets[0].costPerLaunch)
        assertEquals(40, rockets[0].successRatePct)
        assertEquals("2006-03-24", rockets[0].firstFlight)
        assertEquals("USA", rockets[0].country)
        assertEquals("SpaceX", rockets[0].company)
        assertEquals(22.25, rockets[0].height.meters)
        assertEquals(73.0, rockets[0].height.feet)
        assertEquals(1.68, rockets[0].diameter.meters)
        assertEquals(5.5, rockets[0].diameter.feet)
        assertEquals(30146, rockets[0].mass.kg)
        assertEquals(66460, rockets[0].mass.lb)
        assertTrue(rockets[0].payloadWeights.isEmpty())
        assertTrue(rockets[0].firstStage.reusable)
        assertEquals(1, rockets[0].firstStage.engines)
        assertEquals(44.3, rockets[0].firstStage.fuelAmountTons)
        assertEquals(169, rockets[0].firstStage.burnTimeSec)
        assertEquals(420, rockets[0].firstStage.thrustSeaLevel.kN)
        assertEquals(940, rockets[0].firstStage.thrustSeaLevel.lbf)
        assertEquals(480, rockets[0].firstStage.thrustVacuum.kN)
        assertEquals(1080, rockets[0].firstStage.thrustVacuum.lbf)
        assertFalse(rockets[0].secondStage.reusable)
        assertEquals(1, rockets[0].secondStage.engines)
        assertEquals(3.38, rockets[0].secondStage.fuelAmountTons)
        assertEquals(378, rockets[0].secondStage.burnTimeSec)
        assertEquals(31, rockets[0].secondStage.thrust.kN)
        assertEquals(70, rockets[0].secondStage.thrust.lbf)
        assertEquals("option1", rockets[0].secondStage.payloads.option1)
        assertEquals(3.5, rockets[0].secondStage.payloads.compositeFairing.height.meters)
        assertEquals(11.5, rockets[0].secondStage.payloads.compositeFairing.height.feet)
        assertEquals(1.68, rockets[0].secondStage.payloads.compositeFairing.diameter.meters)
        assertEquals(5.5, rockets[0].secondStage.payloads.compositeFairing.diameter.feet)
        assertEquals(1, rockets[0].engines.number)
        assertEquals("merlin", rockets[0].engines.type)
        assertEquals("1C", rockets[0].engines.version)
        assertNull(rockets[0].engines.layout)
        assertEquals(267, rockets[0].engines.isp.seaLevel)
        assertEquals(304, rockets[0].engines.isp.vacuum)
        assertEquals(1, rockets[0].engines.engineLossMax)
        assertEquals("RP-1", rockets[0].engines.propellant1)
        assertEquals("LOX", rockets[0].engines.propellant2)
        assertEquals(420, rockets[0].engines.thrustSeaLevel.kN)
        assertEquals(940, rockets[0].engines.thrustSeaLevel.lbf)
        assertEquals(480, rockets[0].engines.thrustVacuum.kN)
        assertEquals(1080, rockets[0].engines.thrustVacuum.lbf)
        assertEquals(96.0, rockets[0].engines.thrustToWeight)
        assertEquals(0, rockets[0].landingLegs.number)
        assertNull(rockets[0].landingLegs.material)
        assertTrue(rockets[0].flickrImages.isEmpty())
        assertEquals("https://en.wikipedia.org/wiki/Falcon_1", rockets[0].wikipedia)
        assertEquals(
            "The Falcon 1 was an expendable launch system privately developed and manufactured by SpaceX during 2006-2009.",
            rockets[0].description
        )
    }

    @Test
    fun testGetAllRocketsInternetFailure() {
        val client = mockk<SpaceXClientV4>()
        every { client.rockets.getAll() } throws RuntimeException("Internet connection error")

        assertFailsWith<RuntimeException> {
            client.rockets.getAll()
        }
    }

    @Test
    fun testGetAllRockets400StatusCode() {
        val client = mockk<SpaceXClientV4>()
        every { client.rockets.getAll() } throws RuntimeException("HTTP 400 Bad Request")

        assertFailsWith<RuntimeException> {
            client.rockets.getAll()
        }
    }

    @Test
    fun testGetRocketByIdSuccess() {
        val client = mockk<SpaceXClientV4>()
        val rocket = RocketDto(
            "id",
            "Falcon 1",
            "rocket",
            true,
            2,
            0,
            6700000,
            40,
            "2006-03-24",
            "USA",
            "SpaceX",
            RocketDto.Dimension(22.25, 73.0),
            RocketDto.Dimension(1.68, 5.5),
            RocketDto.Mass(30146, 66460),
            listOf(),
            RocketDto.FirstStage(true, 1, 44.3, 169, RocketDto.Thrust(420, 940), RocketDto.Thrust(480, 1080)),
            RocketDto.SecondStage(
                false,
                1,
                3.38,
                378,
                RocketDto.Thrust(31, 70),
                RocketDto.Payloads(
                    "option1",
                    RocketDto.CompositeFairing(RocketDto.Dimension(3.5, 11.5), RocketDto.Dimension(1.68, 5.5))
                )
            ),
            RocketDto.Engines(
                1,
                "merlin",
                "1C",
                null,
                RocketDto.ISP(267, 304),
                1,
                "RP-1",
                "LOX",
                RocketDto.Thrust(420, 940),
                RocketDto.Thrust(480, 1080),
                96.0
            ),
            RocketDto.LandingLegs(0, null),
            listOf(),
            "https://en.wikipedia.org/wiki/Falcon_1",
            "The Falcon 1 was an expendable launch system privately developed and manufactured by SpaceX during 2006-2009."
        )
        every { client.rockets.getById("id") } returns rocket

        val result = client.rockets.getById("id")
        assertNotNull(result)
        assertEquals("id", result.id)
        assertEquals("Falcon 1", result.name)
        assertEquals("rocket", result.type)
        assertTrue(result.active)
        assertEquals(2, result.stages)
        assertEquals(0, result.boosters)
        assertEquals(6700000, result.costPerLaunch)
        assertEquals(40, result.successRatePct)
        assertEquals("2006-03-24", result.firstFlight)
        assertEquals("USA", result.country)
        assertEquals("SpaceX", result.company)
        assertEquals(22.25, result.height.meters)
        assertEquals(73.0, result.height.feet)
        assertEquals(1.68, result.diameter.meters)
        assertEquals(5.5, result.diameter.feet)
        assertEquals(30146, result.mass.kg)
        assertEquals(66460, result.mass.lb)
        assertTrue(result.payloadWeights.isEmpty())
        assertTrue(result.firstStage.reusable)
        assertEquals(1, result.firstStage.engines)
        assertEquals(44.3, result.firstStage.fuelAmountTons)
        assertEquals(169, result.firstStage.burnTimeSec)
        assertEquals(420, result.firstStage.thrustSeaLevel.kN)
        assertEquals(940, result.firstStage.thrustSeaLevel.lbf)
        assertEquals(480, result.firstStage.thrustVacuum.kN)
        assertEquals(1080, result.firstStage.thrustVacuum.lbf)
        assertFalse(result.secondStage.reusable)
        assertEquals(1, result.secondStage.engines)
        assertEquals(3.38, result.secondStage.fuelAmountTons)
        assertEquals(378, result.secondStage.burnTimeSec)
        assertEquals(31, result.secondStage.thrust.kN)
        assertEquals(70, result.secondStage.thrust.lbf)
        assertEquals("option1", result.secondStage.payloads.option1)
        assertEquals(3.5, result.secondStage.payloads.compositeFairing.height.meters)
        assertEquals(11.5, result.secondStage.payloads.compositeFairing.height.feet)
        assertEquals(1.68, result.secondStage.payloads.compositeFairing.diameter.meters)
        assertEquals(5.5, result.secondStage.payloads.compositeFairing.diameter.feet)
        assertEquals(1, result.engines.number)
        assertEquals("merlin", result.engines.type)
        assertEquals("1C", result.engines.version)
        assertNull(result.engines.layout)
        assertEquals(267, result.engines.isp.seaLevel)
        assertEquals(304, result.engines.isp.vacuum)
        assertEquals(1, result.engines.engineLossMax)
        assertEquals("RP-1", result.engines.propellant1)
        assertEquals("LOX", result.engines.propellant2)
        assertEquals(420, result.engines.thrustSeaLevel.kN)
        assertEquals(940, result.engines.thrustSeaLevel.lbf)
        assertEquals(480, result.engines.thrustVacuum.kN)
        assertEquals(1080, result.engines.thrustVacuum.lbf)
        assertEquals(96.0, result.engines.thrustToWeight)
        assertEquals(0, result.landingLegs.number)
        assertNull(result.landingLegs.material)
        assertTrue(result.flickrImages.isEmpty())
        assertEquals("https://en.wikipedia.org/wiki/Falcon_1", result.wikipedia)
        assertEquals(
            "The Falcon 1 was an expendable launch system privately developed and manufactured by SpaceX during 2006-2009.",
            result.description
        )
    }

    @Test
    fun testGetRocketByIdInternetFailure() {
        val client = mockk<SpaceXClientV4>()
        every { client.rockets.getById("id") } throws RuntimeException("Internet connection error")

        assertFailsWith<RuntimeException> {
            client.rockets.getById("id")
        }
    }

    @Test
    fun testGetRocketById400StatusCode() {
        val client = mockk<SpaceXClientV4>()
        every { client.rockets.getById("id") } throws RuntimeException("HTTP 400 Bad Request")

        assertFailsWith<RuntimeException> {
            client.rockets.getById("id")
        }
    }

    @Test
    fun testQueryRocketsSuccess() {
        val client = mockk<SpaceXClientV4>()
        val paginatedResponse = PaginatedResponse(
            docs = listOf(
                RocketDto(
                    "id",
                    "Falcon 1",
                    "rocket",
                    true,
                    2,
                    0,
                    6700000,
                    40,
                    "2006-03-24",
                    "USA",
                    "SpaceX",
                    RocketDto.Dimension(22.25, 73.0),
                    RocketDto.Dimension(1.68, 5.5),
                    RocketDto.Mass(30146, 66460),
                    listOf(),
                    RocketDto.FirstStage(true, 1, 44.3, 169, RocketDto.Thrust(420, 940), RocketDto.Thrust(480, 1080)),
                    RocketDto.SecondStage(
                        false,
                        1,
                        3.38,
                        378,
                        RocketDto.Thrust(31, 70),
                        RocketDto.Payloads(
                            "option1",
                            RocketDto.CompositeFairing(RocketDto.Dimension(3.5, 11.5), RocketDto.Dimension(1.68, 5.5))
                        )
                    ),
                    RocketDto.Engines(
                        1,
                        "merlin",
                        "1C",
                        null,
                        RocketDto.ISP(267, 304),
                        1,
                        "RP-1",
                        "LOX",
                        RocketDto.Thrust(420, 940),
                        RocketDto.Thrust(480, 1080),
                        96.0
                    ),
                    RocketDto.LandingLegs(0, null),
                    listOf(),
                    "https://en.wikipedia.org/wiki/Falcon_1",
                    "The Falcon 1 was an expendable launch system privately developed and manufactured by SpaceX during 2006-2009."
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
        every { client.rockets.query(any()) } returns paginatedResponse

        val result = client.rockets.query(mapOf("active" to true))
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
        assertEquals("Falcon 1", result.docs[0].name)
        assertEquals("rocket", result.docs[0].type)
        assertTrue(result.docs[0].active)
        assertEquals(2, result.docs[0].stages)
        assertEquals(0, result.docs[0].boosters)
        assertEquals(6700000, result.docs[0].costPerLaunch)
        assertEquals(40, result.docs[0].successRatePct)
        assertEquals("2006-03-24", result.docs[0].firstFlight)
        assertEquals("USA", result.docs[0].country)
        assertEquals("SpaceX", result.docs[0].company)
        assertEquals(22.25, result.docs[0].height.meters)
        assertEquals(73.0, result.docs[0].height.feet)
        assertEquals(1.68, result.docs[0].diameter.meters)
        assertEquals(5.5, result.docs[0].diameter.feet)
        assertEquals(30146, result.docs[0].mass.kg)
        assertEquals(66460, result.docs[0].mass.lb)
        assertTrue(result.docs[0].payloadWeights.isEmpty())
        assertTrue(result.docs[0].firstStage.reusable)
        assertEquals(1, result.docs[0].firstStage.engines)
        assertEquals(44.3, result.docs[0].firstStage.fuelAmountTons)
        assertEquals(169, result.docs[0].firstStage.burnTimeSec)
        assertEquals(420, result.docs[0].firstStage.thrustSeaLevel.kN)
        assertEquals(940, result.docs[0].firstStage.thrustSeaLevel.lbf)
        assertEquals(480, result.docs[0].firstStage.thrustVacuum.kN)
        assertEquals(1080, result.docs[0].firstStage.thrustVacuum.lbf)
        assertFalse(result.docs[0].secondStage.reusable)
        assertEquals(1, result.docs[0].secondStage.engines)
        assertEquals(3.38, result.docs[0].secondStage.fuelAmountTons)
        assertEquals(378, result.docs[0].secondStage.burnTimeSec)
        assertEquals(31, result.docs[0].secondStage.thrust.kN)
        assertEquals(70, result.docs[0].secondStage.thrust.lbf)
        assertEquals("option1", result.docs[0].secondStage.payloads.option1)
        assertEquals(3.5, result.docs[0].secondStage.payloads.compositeFairing.height.meters)
        assertEquals(11.5, result.docs[0].secondStage.payloads.compositeFairing.height.feet)
        assertEquals(1.68, result.docs[0].secondStage.payloads.compositeFairing.diameter.meters)
        assertEquals(5.5, result.docs[0].secondStage.payloads.compositeFairing.diameter.feet)
        assertEquals(1, result.docs[0].engines.number)
        assertEquals("merlin", result.docs[0].engines.type)
        assertEquals("1C", result.docs[0].engines.version)
        assertNull(result.docs[0].engines.layout)
        assertEquals(267, result.docs[0].engines.isp.seaLevel)
        assertEquals(304, result.docs[0].engines.isp.vacuum)
        assertEquals(1, result.docs[0].engines.engineLossMax)
        assertEquals("RP-1", result.docs[0].engines.propellant1)
        assertEquals("LOX", result.docs[0].engines.propellant2)
        assertEquals(420, result.docs[0].engines.thrustSeaLevel.kN)
        assertEquals(940, result.docs[0].engines.thrustSeaLevel.lbf)
        assertEquals(480, result.docs[0].engines.thrustVacuum.kN)
        assertEquals(1080, result.docs[0].engines.thrustVacuum.lbf)
        assertEquals(96.0, result.docs[0].engines.thrustToWeight)
        assertEquals(0, result.docs[0].landingLegs.number)
        assertNull(result.docs[0].landingLegs.material)
        assertTrue(result.docs[0].flickrImages.isEmpty())
        assertEquals("https://en.wikipedia.org/wiki/Falcon_1", result.docs[0].wikipedia)
        assertEquals(
            "The Falcon 1 was an expendable launch system privately developed and manufactured by SpaceX during 2006-2009.",
            result.docs[0].description
        )
    }

    @Test
    fun testQueryRocketsInternetFailure() {
        val client = mockk<SpaceXClientV4>()
        every { client.rockets.query(any()) } throws RuntimeException("Internet connection error")

        assertFailsWith<RuntimeException> {
            client.rockets.query(mapOf("active" to true))
        }
    }

    @Test
    fun testQueryRockets400StatusCode() {
        val client = mockk<SpaceXClientV4>()
        every { client.rockets.query(any()) } throws RuntimeException("HTTP 400 Bad Request")

        assertFailsWith<RuntimeException> {
            client.rockets.query(mapOf("active" to true))
        }
    }
}