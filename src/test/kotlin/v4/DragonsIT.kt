package v4

import cz.matejvana.spacexkotapi.request.PaginatedResponse
import cz.matejvana.spacexkotapi.v4.ClientV4
import cz.matejvana.spacexkotapi.v4.dragons.DragonDto
import io.mockk.every
import io.mockk.mockk
import kotlin.test.*

class DragonsIT {

    @Test
    fun testAllDragonsSuccess() {
        val client = mockk<ClientV4>()
        every { client.dragons.getAll() } returns listOf(
            DragonDto(
                "id",
                "name",
                "type",
                true,
                4,
                30,
                2,
                4200,
                9250,
                "firstFlight",
                DragonDto.HeatShield("PICA-X", 3.0, 1600, "NASA"),
                emptyList<DragonDto.Thruster>(),
                DragonDto.PayloadMass(6000, 13228),
                DragonDto.PayloadVolume(25, 883),
                DragonDto.PayloadMass(3000, 6614),
                DragonDto.PayloadVolume(11, 388),
                DragonDto.PressurizedCapsule(DragonDto.PayloadVolume(25, 883)),
                DragonDto.Trunk(DragonDto.PayloadVolume(14, 494), DragonDto.Trunk.Cargo(2, true)),
                DragonDto.Dimension(7.0, 23),
                DragonDto.Dimension(3.7, 12),
                emptyList(),
                "wikipedia",
                "description"
            ),
            DragonDto(
                "id2",
                "name2",
                "type2",
                false,
                7,
                45,
                3,
                6000,
                13228,
                "firstFlight2",
                DragonDto.HeatShield("PICA-X2", 4.0, 1700, "NASA2"),
                emptyList<DragonDto.Thruster>(),
                DragonDto.PayloadMass(7000, 15432),
                DragonDto.PayloadVolume(30, 1059),
                DragonDto.PayloadMass(3500, 7716),
                DragonDto.PayloadVolume(15, 530),
                DragonDto.PressurizedCapsule(DragonDto.PayloadVolume(30, 1059)),
                DragonDto.Trunk(DragonDto.PayloadVolume(20, 706), DragonDto.Trunk.Cargo(3, false)),
                DragonDto.Dimension(8.0, 26),
                DragonDto.Dimension(4.2, 14),
                emptyList(),
                "wikipedia2",
                "description2"
            )
        )

        val dragons = client.dragons.getAll()
        assertTrue(dragons.isNotEmpty())
        assertEquals(2, dragons.size)
        assertEquals("id", dragons[0].id)
        assertEquals("name", dragons[0].name)
        assertEquals("type", dragons[0].type)
        assertTrue(dragons[0].active)
        assertEquals(4, dragons[0].crewCapacity)
        assertEquals(30, dragons[0].sidewallAngleDeg)
        assertEquals(2, dragons[0].orbitDurationYr)
        assertEquals(4200, dragons[0].dryMassKg)
        assertEquals(9250, dragons[0].dryMassLb)
        assertEquals("firstFlight", dragons[0].firstFlight)
        assertEquals("PICA-X", dragons[0].heatShield.material)
        assertEquals(3.0, dragons[0].heatShield.sizeMeters)
        assertEquals(1600, dragons[0].heatShield.tempDegrees)
        assertEquals("NASA", dragons[0].heatShield.devPartner)
        assertEquals(6000, dragons[0].launchPayloadMass.kg)
        assertEquals(13228, dragons[0].launchPayloadMass.lb)
        assertEquals(25, dragons[0].launchPayloadVol.cubicMeters)
        assertEquals(883, dragons[0].launchPayloadVol.cubicFeet)
        assertEquals(3000, dragons[0].returnPayloadMass.kg)
        assertEquals(6614, dragons[0].returnPayloadMass.lb)
        assertEquals(11, dragons[0].returnPayloadVol.cubicMeters)
        assertEquals(388, dragons[0].returnPayloadVol.cubicFeet)
        assertEquals(25, dragons[0].pressurizedCapsule.payloadVolume.cubicMeters)
        assertEquals(883, dragons[0].pressurizedCapsule.payloadVolume.cubicFeet)
        assertEquals(14, dragons[0].trunk.trunkVolume.cubicMeters)
        assertEquals(494, dragons[0].trunk.trunkVolume.cubicFeet)
        assertEquals(2, dragons[0].trunk.cargo.solarArray)
        dragons[0].trunk.cargo.unpressurizedCargo?.let { assertTrue(it) }
        assertEquals(7.0, dragons[0].heightWTrunk.meters)
        assertEquals(23, dragons[0].heightWTrunk.feet)
        assertEquals(3.7, dragons[0].diameter.meters)
        assertEquals(12, dragons[0].diameter.feet)
        assertEquals("wikipedia", dragons[0].wikipedia)
        assertEquals("description", dragons[0].description)

        assertEquals("id2", dragons[1].id)
        assertEquals("name2", dragons[1].name)
        assertEquals("type2", dragons[1].type)
        assertFalse(dragons[1].active)
        assertEquals(7, dragons[1].crewCapacity)
        assertEquals(45, dragons[1].sidewallAngleDeg)
        assertEquals(3, dragons[1].orbitDurationYr)
        assertEquals(6000, dragons[1].dryMassKg)
        assertEquals(13228, dragons[1].dryMassLb)
        assertEquals("firstFlight2", dragons[1].firstFlight)
        assertEquals("PICA-X2", dragons[1].heatShield.material)
        assertEquals(4.0, dragons[1].heatShield.sizeMeters)
        assertEquals(1700, dragons[1].heatShield.tempDegrees)
        assertEquals("NASA2", dragons[1].heatShield.devPartner)
        assertEquals(7000, dragons[1].launchPayloadMass.kg)
        assertEquals(15432, dragons[1].launchPayloadMass.lb)
        assertEquals(30, dragons[1].launchPayloadVol.cubicMeters)
        assertEquals(1059, dragons[1].launchPayloadVol.cubicFeet)
        assertEquals(3500, dragons[1].returnPayloadMass.kg)
        assertEquals(7716, dragons[1].returnPayloadMass.lb)
        assertEquals(15, dragons[1].returnPayloadVol.cubicMeters)
        assertEquals(530, dragons[1].returnPayloadVol.cubicFeet)
        assertEquals(30, dragons[1].pressurizedCapsule.payloadVolume.cubicMeters)
        assertEquals(1059, dragons[1].pressurizedCapsule.payloadVolume.cubicFeet)
        assertEquals(20, dragons[1].trunk.trunkVolume.cubicMeters)
        assertEquals(706, dragons[1].trunk.trunkVolume.cubicFeet)
        assertEquals(3, dragons[1].trunk.cargo.solarArray)
        dragons[1].trunk.cargo.unpressurizedCargo?.let { assertFalse(it) }
        assertEquals(8.0, dragons[1].heightWTrunk.meters)
        assertEquals(26, dragons[1].heightWTrunk.feet)
        assertEquals(4.2, dragons[1].diameter.meters)
        assertEquals(14, dragons[1].diameter.feet)
        assertEquals("wikipedia2", dragons[1].wikipedia)
        assertEquals("description2", dragons[1].description)
    }

    @Test
    fun testAllDragonsInternetFailure() {
        val client = mockk<ClientV4>()
        every { client.dragons.getAll() } throws RuntimeException("Internet connection error")

        assertFailsWith<RuntimeException> {
            client.dragons.getAll()
        }
    }

    @Test
    fun testAllDragons400StatusCode() {
        val client = mockk<ClientV4>()
        every { client.dragons.getAll() } throws RuntimeException("HTTP 400 Bad Request")

        assertFailsWith<RuntimeException> {
            client.dragons.getAll()
        }
    }

    @Test
    fun testDragonByIdSuccess() {
        val client = mockk<ClientV4>()
        val dragon = DragonDto(
            "id",
            "name",
            "type",
            true,
            4,
            30,
            2,
            4200,
            9250,
            "firstFlight",
            DragonDto.HeatShield("PICA-X", 3.0, 1600, "NASA"),
            emptyList<DragonDto.Thruster>(),
            DragonDto.PayloadMass(6000, 13228),
            DragonDto.PayloadVolume(25, 883),
            DragonDto.PayloadMass(3000, 6614),
            DragonDto.PayloadVolume(11, 388),
            DragonDto.PressurizedCapsule(DragonDto.PayloadVolume(25, 883)),
            DragonDto.Trunk(DragonDto.PayloadVolume(14, 494), DragonDto.Trunk.Cargo(2, true)),
            DragonDto.Dimension(7.0, 23),
            DragonDto.Dimension(3.7, 12),
            emptyList(),
            "wikipedia",
            "description"
        )
        every { client.dragons.getById("id") } returns dragon

        val result = client.dragons.getById("id")
        assertNotNull(result)
        assertEquals("id", result.id)
        assertEquals("name", result.name)
        assertEquals("type", result.type)
        assertTrue(result.active)
        assertEquals(4, result.crewCapacity)
        assertEquals(30, result.sidewallAngleDeg)
        assertEquals(2, result.orbitDurationYr)
        assertEquals(4200, result.dryMassKg)
        assertEquals(9250, result.dryMassLb)
        assertEquals("firstFlight", result.firstFlight)
        assertEquals("PICA-X", result.heatShield.material)
        assertEquals(3.0, result.heatShield.sizeMeters)
        assertEquals(1600, result.heatShield.tempDegrees)
        assertEquals("NASA", result.heatShield.devPartner)
        assertEquals(6000, result.launchPayloadMass.kg)
        assertEquals(13228, result.launchPayloadMass.lb)
        assertEquals(25, result.launchPayloadVol.cubicMeters)
        assertEquals(883, result.launchPayloadVol.cubicFeet)
        assertEquals(3000, result.returnPayloadMass.kg)
        assertEquals(6614, result.returnPayloadMass.lb)
        assertEquals(11, result.returnPayloadVol.cubicMeters)
        assertEquals(388, result.returnPayloadVol.cubicFeet)
        assertEquals(25, result.pressurizedCapsule.payloadVolume.cubicMeters)
        assertEquals(883, result.pressurizedCapsule.payloadVolume.cubicFeet)
        assertEquals(14, result.trunk.trunkVolume.cubicMeters)
        assertEquals(494, result.trunk.trunkVolume.cubicFeet)
        assertEquals(2, result.trunk.cargo.solarArray)
        result.trunk.cargo.unpressurizedCargo?.let { assertTrue(it) }
        assertEquals(7.0, result.heightWTrunk.meters)
        assertEquals(23, result.heightWTrunk.feet)
        assertEquals(3.7, result.diameter.meters)
        assertEquals(12, result.diameter.feet)
        assertEquals("wikipedia", result.wikipedia)
        assertEquals("description", result.description)
    }

    @Test
    fun testDragonByIdInternetFailure() {
        val client = mockk<ClientV4>()
        every { client.dragons.getById("id") } throws RuntimeException("Internet connection error")

        assertFailsWith<RuntimeException> {
            client.dragons.getById("id")
        }
    }

    @Test
    fun testDragonById400StatusCode() {
        val client = mockk<ClientV4>()
        every { client.dragons.getById("id") } throws RuntimeException("HTTP 400 Bad Request")

        assertFailsWith<RuntimeException> {
            client.dragons.getById("id")
        }
    }

    @Test
    fun testQueryDragonsSuccess() {
        val client = mockk<ClientV4>()
        val paginatedResponse = PaginatedResponse(
            docs = listOf(
                DragonDto(
                    "id",
                    "name",
                    "type",
                    true,
                    4,
                    30,
                    2,
                    4200,
                    9250,
                    "firstFlight",
                    DragonDto.HeatShield("PICA-X", 3.0, 1600, "NASA"),
                    emptyList<DragonDto.Thruster>(),
                    DragonDto.PayloadMass(6000, 13228),
                    DragonDto.PayloadVolume(25, 883),
                    DragonDto.PayloadMass(3000, 6614),
                    DragonDto.PayloadVolume(11, 388),
                    DragonDto.PressurizedCapsule(DragonDto.PayloadVolume(25, 883)),
                    DragonDto.Trunk(DragonDto.PayloadVolume(14, 494), DragonDto.Trunk.Cargo(2, true)),
                    DragonDto.Dimension(7.0, 23),
                    DragonDto.Dimension(3.7, 12),
                    emptyList(),
                    "wikipedia",
                    "description"
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
        every { client.dragons.query(any()) } returns paginatedResponse

        val result = client.dragons.query(mapOf("limit" to 1))
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
        assertTrue(result.docs[0].active)
        assertEquals(4, result.docs[0].crewCapacity)
        assertEquals(30, result.docs[0].sidewallAngleDeg)
        assertEquals(2, result.docs[0].orbitDurationYr)
        assertEquals(4200, result.docs[0].dryMassKg)
        assertEquals(9250, result.docs[0].dryMassLb)
        assertEquals("firstFlight", result.docs[0].firstFlight)
        assertEquals("PICA-X", result.docs[0].heatShield.material)
        assertEquals(3.0, result.docs[0].heatShield.sizeMeters)
        assertEquals(1600, result.docs[0].heatShield.tempDegrees)
        assertEquals("NASA", result.docs[0].heatShield.devPartner)
        assertEquals(6000, result.docs[0].launchPayloadMass.kg)
        assertEquals(13228, result.docs[0].launchPayloadMass.lb)
        assertEquals(25, result.docs[0].launchPayloadVol.cubicMeters)
        assertEquals(883, result.docs[0].launchPayloadVol.cubicFeet)
        assertEquals(3000, result.docs[0].returnPayloadMass.kg)
        assertEquals(6614, result.docs[0].returnPayloadMass.lb)
        assertEquals(11, result.docs[0].returnPayloadVol.cubicMeters)
        assertEquals(388, result.docs[0].returnPayloadVol.cubicFeet)
        assertEquals(25, result.docs[0].pressurizedCapsule.payloadVolume.cubicMeters)
        assertEquals(883, result.docs[0].pressurizedCapsule.payloadVolume.cubicFeet)
        assertEquals(14, result.docs[0].trunk.trunkVolume.cubicMeters)
        assertEquals(494, result.docs[0].trunk.trunkVolume.cubicFeet)
        assertEquals(2, result.docs[0].trunk.cargo.solarArray)
        result.docs[0].trunk.cargo.unpressurizedCargo?.let { assertTrue(it) }
        assertEquals(7.0, result.docs[0].heightWTrunk.meters)
        assertEquals(23, result.docs[0].heightWTrunk.feet)
        assertEquals(3.7, result.docs[0].diameter.meters)
        assertEquals(12, result.docs[0].diameter.feet)
        assertEquals("wikipedia", result.docs[0].wikipedia)
        assertEquals("description", result.docs[0].description)
    }

    @Test
    fun testQueryDragonsInternetFailure() {
        val client = mockk<ClientV4>()
        every { client.dragons.query(any()) } throws RuntimeException("Internet connection error")

        assertFailsWith<RuntimeException> {
            client.dragons.query(mapOf("limit" to 1))
        }
    }

    @Test
    fun testQueryDragons400StatusCode() {
        val client = mockk<ClientV4>()
        every { client.dragons.query(any()) } throws RuntimeException("HTTP 400 Bad Request")

        assertFailsWith<RuntimeException> {
            client.dragons.query(mapOf("limit" to 1))
        }
    }
}