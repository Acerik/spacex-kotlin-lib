import cz.matejvana.spacexkotapi.request.PaginatedResponse
import cz.matejvana.spacexkotapi.v4.SpaceXClientV4
import cz.matejvana.spacexkotapi.v4.capsules.CapsuleDto
import cz.matejvana.spacexkotapi.v4.cores.CoreDto
import cz.matejvana.spacexkotapi.v4.crew.CrewDto
import cz.matejvana.spacexkotapi.v4.dragons.DragonDto
import cz.matejvana.spacexkotapi.v4.history.HistoryDto
import cz.matejvana.spacexkotapi.v4.landpads.LandingPadDto
import cz.matejvana.spacexkotapi.v4.launches.LaunchV4Dto
import cz.matejvana.spacexkotapi.v4.launches.LaunchV5Dto
import cz.matejvana.spacexkotapi.v4.launchpads.LaunchPadDto
import cz.matejvana.spacexkotapi.v4.payloads.PayloadDto
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class SpaceXClientV4RealTest {

    private val spaceXClientV4 = SpaceXClientV4()

    @Test
    fun `check returns true for real SpaceX API`() {
        val result = spaceXClientV4.check()
        assertTrue(result)
    }

    @Test
    fun `allCapsules returns non-empty list of capsules`() {
        val capsules: List<CapsuleDto> = spaceXClientV4.capsules.getAll()

        assertTrue(capsules.isNotEmpty())

        assertNotNull(capsules[0].serial)
    }

    @Test
    fun `capsuleById returns capsule (capsule id is from allCapsules)`() {
        val capsules: List<CapsuleDto> = spaceXClientV4.capsules.getAll()

        assertTrue(capsules.isNotEmpty())

        assertNotNull(capsules[0].serial)

        val capsule: CapsuleDto = spaceXClientV4.capsules.getById(capsules[0].id)

        assertNotNull(capsule)
        assertEquals(capsules[0].serial, capsule.serial)
    }

    @Test
    fun `query capsule test`() {
        val pagiantion: PaginatedResponse<CapsuleDto> = spaceXClientV4.capsules.query(mapOf("limit" to 1))

        assertTrue(pagiantion.docs.isNotEmpty())
    }

    @Test
    fun `allCompanies returns non-empty list of companies`() {
        val companies = spaceXClientV4.company.getAllInfo()

        assertNotNull(companies)
    }

    @Test
    fun `allCores returns non-empty list of cores`() {
        val cores: List<CoreDto> = spaceXClientV4.cores.getAll()

        assertTrue(cores.isNotEmpty())

        assertNotNull(cores[0].serial)
    }

    @Test
    fun `coreById returns core (core id is from allCores)`() {
        val cores: List<CoreDto> = spaceXClientV4.cores.getAll()

        assertTrue(cores.isNotEmpty())

        assertNotNull(cores[0].serial)

        val core: CoreDto = spaceXClientV4.cores.getById(cores[0].id)

        assertNotNull(core)
        assertEquals(cores[0].serial, core.serial)
    }

    @Test
    fun `query core test`() {
        val pagination: PaginatedResponse<CoreDto> = spaceXClientV4.cores.query(mapOf("limit" to 1))

        assertTrue(pagination.docs.isNotEmpty())
    }

    @Test
    fun `allCrew returns non-empty list of crew`() {
        val crew: List<CrewDto> = spaceXClientV4.crew.getAll()

        assertTrue(crew.isNotEmpty())

        assertNotNull(crew[0].name)
    }

    @Test
    fun `crewById returns crew (crew id is from allCrew)`() {
        val crew: List<CrewDto> = spaceXClientV4.crew.getAll()

        assertTrue(crew.isNotEmpty())

        assertNotNull(crew[0].name)

        val crewMember: CrewDto = spaceXClientV4.crew.getById(crew[0].id)

        assertNotNull(crewMember)
        assertEquals(crew[0].name, crewMember.name)
    }

    @Test
    fun `query crew test`() {
        val pagination: PaginatedResponse<CrewDto> = spaceXClientV4.crew.query(mapOf("limit" to 1))

        assertTrue(pagination.docs.isNotEmpty())
    }

    @Test
    fun `allDragons returns non-empty list of dragons`() {
        val dragons: List<DragonDto> = spaceXClientV4.dragons.getAll()

        assertTrue(dragons.isNotEmpty())

        assertNotNull(dragons[0].name)
    }

    @Test
    fun `dragonById returns dragon (dragon id is from allDragons)`() {
        val dragons: List<DragonDto> = spaceXClientV4.dragons.getAll()

        assertTrue(dragons.isNotEmpty())

        assertNotNull(dragons[0].name)

        val dragon: DragonDto = spaceXClientV4.dragons.getById(dragons[0].id)

        assertNotNull(dragon)
        assertEquals(dragons[0].name, dragon.name)
    }

    @Test
    fun `query dragon test`() {
        val pagination: PaginatedResponse<DragonDto> = spaceXClientV4.dragons.query(mapOf("limit" to 1))

        assertTrue(pagination.docs.isNotEmpty())
    }

    @Test
    fun `allHistory returns non-empty list of history`() {
        val history: List<HistoryDto> = spaceXClientV4.history.getAll()

        assertTrue(history.isNotEmpty())

        assertNotNull(history[0].title)
    }

    @Test
    fun `historyById returns history (history id is from allHistory)`() {
        val history: List<HistoryDto> = spaceXClientV4.history.getAll()

        assertTrue(history.isNotEmpty())

        assertNotNull(history[0].title)

        val historyItem: HistoryDto = spaceXClientV4.history.getById(history[0].id)

        assertNotNull(historyItem)
        assertEquals(history[0].title, historyItem.title)
    }

    @Test
    fun `query history test`() {
        val pagination: PaginatedResponse<HistoryDto> = spaceXClientV4.history.query(mapOf("limit" to 1))

        assertTrue(pagination.docs.isNotEmpty())
    }

    @Test
    fun `allLandPads returns non-empty list of landpads`() {
        val landpads: List<LandingPadDto> = spaceXClientV4.landPads.getAll()

        assertTrue(landpads.isNotEmpty())

        assertNotNull(landpads[0].name)
    }

    @Test
    fun `landpadsById returns landingpads (landing pad id is from allLandPads)`() {
        val landpads: List<LandingPadDto> = spaceXClientV4.landPads.getAll()

        assertTrue(landpads.isNotEmpty())

        assertNotNull(landpads[0].name)

        val landingPadDto: LandingPadDto = spaceXClientV4.landPads.getById(landpads[0].id)

        assertNotNull(landingPadDto)
        assertEquals(landpads[0].name, landingPadDto.name)
    }

    @Test
    fun `query landpads test`() {
        val pagination: PaginatedResponse<LandingPadDto> = spaceXClientV4.landPads.query(mapOf("limit" to 1))

        assertTrue(pagination.docs.isNotEmpty())
    }

    @Test
    fun `allLaunchPads returns non-empty list of launchpads`() {
        val launchpads: List<LaunchPadDto> = spaceXClientV4.launchPads.getAll()

        assertTrue(launchpads.isNotEmpty())

        assertNotNull(launchpads[0].name)
    }

    @Test
    fun `launchpadsById returns launchpads (launch pad id is from allLaunchPads)`() {
        val launchpads: List<LaunchPadDto> = spaceXClientV4.launchPads.getAll()

        assertTrue(launchpads.isNotEmpty())

        assertNotNull(launchpads[0].name)

        val launchPadDto: LaunchPadDto = spaceXClientV4.launchPads.getById(launchpads[0].id)

        assertNotNull(launchPadDto)
        assertEquals(launchpads[0].name, launchPadDto.name)
    }

    @Test
    fun `query launchpads test`() {
        val pagination: PaginatedResponse<LaunchPadDto> = spaceXClientV4.launchPads.query(mapOf("limit" to 1))

        assertTrue(pagination.docs.isNotEmpty())
    }

    @Test
    fun `allPayloads returns non-empty list of payloads`() {
        val payloads: List<PayloadDto> = spaceXClientV4.payloads.getAll()

        assertTrue(payloads.isNotEmpty())

        assertNotNull(payloads[0].name)
    }

    @Test
    fun `payloadById returns payload (payload id is from allPayloads)`() {
        val payloads: List<PayloadDto> = spaceXClientV4.payloads.getAll()

        assertTrue(payloads.isNotEmpty())

        assertNotNull(payloads[0].name)

        val payload: PayloadDto = spaceXClientV4.payloads.getById(payloads[0].id)

        assertNotNull(payload)
        assertEquals(payloads[0].name, payload.name)
    }

    @Test
    fun `query payloads test`() {
        val pagination: PaginatedResponse<PayloadDto> = spaceXClientV4.payloads.query(mapOf("limit" to 1))

        assertTrue(pagination.docs.isNotEmpty())
    }

    @Test
    fun `roadster get returns roadster`() {
        val roadster = spaceXClientV4.roadster.get()

        assertNotNull(roadster)
    }

    @Test
    fun `roadster query returns roadster`() {
        val roadster = spaceXClientV4.roadster.query(mapOf("limit" to 1))

        assertNotNull(roadster)
    }

    @Test
    fun `allRockets returns non-empty list of rockets`() {
        val rockets = spaceXClientV4.rockets.getAll()

        assertTrue(rockets.isNotEmpty())

        assertNotNull(rockets[0].name)
    }

    @Test
    fun `rocketById returns rocket (rocket id is from allRockets)`() {
        val rockets = spaceXClientV4.rockets.getAll()

        assertTrue(rockets.isNotEmpty())

        assertNotNull(rockets[0].name)

        val rocket = spaceXClientV4.rockets.getById(rockets[0].id)

        assertNotNull(rocket)
        assertEquals(rockets[0].name, rocket.name)
    }

    @Test
    fun `query rockets test`() {
        val pagination = spaceXClientV4.rockets.query(mapOf("limit" to 1))

        assertTrue(pagination.docs.isNotEmpty())
    }

    @Test
    fun `allShips returns non-empty list of ships`() {
        val ships = spaceXClientV4.ships.getAll()

        assertTrue(ships.isNotEmpty())

        assertNotNull(ships[0].name)
    }

    @Test
    fun `shipById returns ship (ship id is from allShips)`() {
        val ships = spaceXClientV4.ships.getAll()

        assertTrue(ships.isNotEmpty())

        assertNotNull(ships[0].name)

        val ship = spaceXClientV4.ships.getById(ships[0].id)

        assertNotNull(ship)
        assertEquals(ships[0].name, ship.name)
    }

    @Test
    fun `query ships test`() {
        val pagination = spaceXClientV4.ships.query(mapOf("limit" to 1))

        assertTrue(pagination.docs.isNotEmpty())
    }

    @Test
    fun `allStarlink returns non-empty list of starlinks`() {
        val starlinks = spaceXClientV4.starlink.getAll()

        assertTrue(starlinks.isNotEmpty())

        assertNotNull(starlinks[0].version)
    }

    @Test
    fun `starlinkById returns starlink (starlink id is from allStarlink)`() {
        val starlinks = spaceXClientV4.starlink.getAll()

        assertTrue(starlinks.isNotEmpty())

        assertNotNull(starlinks[0].version)

        val starlink = spaceXClientV4.starlink.getById(starlinks[0].id)

        assertNotNull(starlink)
        assertEquals(starlinks[0].version, starlink.version)
    }

    @Test
    fun `query starlink test`() {
        val pagination = spaceXClientV4.starlink.query(mapOf("limit" to 1))

        assertTrue(pagination.docs.isNotEmpty())
    }

    @Test
    fun `allLaunchesV4 returns non-empty list of launches`() {
        val launches: List<LaunchV4Dto> = spaceXClientV4.launchesV4.getAll()

        assertTrue(launches.isNotEmpty())

        assertNotNull(launches[0].name)
    }

    @Test
    fun `launchV4ById returns launch (launch id is from allLaunchesV4)`() {
        val launches: List<LaunchV4Dto> = spaceXClientV4.launchesV4.getAll()

        assertTrue(launches.isNotEmpty())

        assertNotNull(launches[0].name)

        val launch: LaunchV4Dto = spaceXClientV4.launchesV4.getById(launches[0].id)

        assertNotNull(launch)
        assertEquals(launches[0].name, launch.name)
    }

    @Test
    fun `query launchesV4 test`() {
        val pagination: PaginatedResponse<LaunchV4Dto> = spaceXClientV4.launchesV4.query(mapOf("limit" to 1))

        assertTrue(pagination.docs.isNotEmpty())
    }

    @Test
    fun `allLaunchesV5 returns non-empty list of launches`() {
        val launches: List<LaunchV5Dto> = spaceXClientV4.launchesV5.getAll()

        assertTrue(launches.isNotEmpty())

        assertNotNull(launches[0].name)
    }

    @Test
    fun `launchV5ById returns launch (launch id is from allLaunchesV5)`() {
        val launches: List<LaunchV5Dto> = spaceXClientV4.launchesV5.getAll()

        assertTrue(launches.isNotEmpty())

        assertNotNull(launches[0].name)

        val launch: LaunchV5Dto = spaceXClientV4.launchesV5.getById(launches[0].id)

        assertNotNull(launch)
        assertEquals(launches[0].name, launch.name)
    }

    @Test
    fun `query launchesV5 test`() {
        val pagination: PaginatedResponse<LaunchV5Dto> = spaceXClientV4.launchesV5.query(mapOf("limit" to 1))

        assertTrue(pagination.docs.isNotEmpty())
    }
}
