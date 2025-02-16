import cz.matejvana.spacexkotapi.request.PaginatedResponse
import cz.matejvana.spacexkotapi.v4.ClientV4
import cz.matejvana.spacexkotapi.v4.capsules.CapsuleDto
import cz.matejvana.spacexkotapi.v4.cores.CoreDto
import cz.matejvana.spacexkotapi.v4.crew.CrewDto
import cz.matejvana.spacexkotapi.v4.dragons.DragonDto
import cz.matejvana.spacexkotapi.v4.history.HistoryDto
import cz.matejvana.spacexkotapi.v4.landpads.LandingPadDto
import cz.matejvana.spacexkotapi.v4.payloads.PayloadDto
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ClientV4RealTest {

    private val clientV4 = ClientV4()

    @Test
    fun `check returns true for real SpaceX API`() {
        val result = clientV4.check()
        assertTrue(result)
    }

    @Test
    fun `allCapsules returns non-empty list of capsules`() {
        val capsules: List<CapsuleDto> = clientV4.capsules.getAll()

        assertTrue(capsules.isNotEmpty())

        assertNotNull(capsules[0].serial)
    }

    @Test
    fun `capsuleById returns capsule (capsule id is from allCapsules)`() {
        val capsules: List<CapsuleDto> = clientV4.capsules.getAll()

        assertTrue(capsules.isNotEmpty())

        assertNotNull(capsules[0].serial)

        val capsule: CapsuleDto = clientV4.capsules.getById(capsules[0].id)

        assertNotNull(capsule)
        assertEquals(capsules[0].serial, capsule.serial)
    }

    @Test
    fun `query capsule test`() {
        val pagiantion: PaginatedResponse<CapsuleDto> = clientV4.capsules.query(mapOf("limit" to 1))

        assertTrue(pagiantion.docs.isNotEmpty())
    }

    @Test
    fun `allCompanies returns non-empty list of companies`() {
        val companies = clientV4.company.getAllInfo()

        assertNotNull(companies)
    }

    @Test
    fun `allCores returns non-empty list of cores`() {
        val cores: List<CoreDto> = clientV4.cores.getAll()

        assertTrue(cores.isNotEmpty())

        assertNotNull(cores[0].serial)
    }

    @Test
    fun `coreById returns core (core id is from allCores)`() {
        val cores: List<CoreDto> = clientV4.cores.getAll()

        assertTrue(cores.isNotEmpty())

        assertNotNull(cores[0].serial)

        val core: CoreDto = clientV4.cores.getById(cores[0].id)

        assertNotNull(core)
        assertEquals(cores[0].serial, core.serial)
    }

    @Test
    fun `query core test`() {
        val pagination: PaginatedResponse<CoreDto> = clientV4.cores.query(mapOf("limit" to 1))

        assertTrue(pagination.docs.isNotEmpty())
    }

    @Test
    fun `allCrew returns non-empty list of crew`() {
        val crew: List<CrewDto> = clientV4.crew.getAll()

        assertTrue(crew.isNotEmpty())

        assertNotNull(crew[0].name)
    }

    @Test
    fun `crewById returns crew (crew id is from allCrew)`() {
        val crew: List<CrewDto> = clientV4.crew.getAll()

        assertTrue(crew.isNotEmpty())

        assertNotNull(crew[0].name)

        val crewMember: CrewDto = clientV4.crew.getById(crew[0].id)

        assertNotNull(crewMember)
        assertEquals(crew[0].name, crewMember.name)
    }

    @Test
    fun `query crew test`() {
        val pagination: PaginatedResponse<CrewDto> = clientV4.crew.query(mapOf("limit" to 1))

        assertTrue(pagination.docs.isNotEmpty())
    }

    @Test
    fun `allDragons returns non-empty list of dragons`() {
        val dragons: List<DragonDto> = clientV4.dragons.getAll()

        assertTrue(dragons.isNotEmpty())

        assertNotNull(dragons[0].name)
    }

    @Test
    fun `dragonById returns dragon (dragon id is from allDragons)`() {
        val dragons: List<DragonDto> = clientV4.dragons.getAll()

        assertTrue(dragons.isNotEmpty())

        assertNotNull(dragons[0].name)

        val dragon: DragonDto = clientV4.dragons.getById(dragons[0].id)

        assertNotNull(dragon)
        assertEquals(dragons[0].name, dragon.name)
    }

    @Test
    fun `query dragon test`() {
        val pagination: PaginatedResponse<DragonDto> = clientV4.dragons.query(mapOf("limit" to 1))

        assertTrue(pagination.docs.isNotEmpty())
    }

    @Test
    fun `allHistory returns non-empty list of history`() {
        val history: List<HistoryDto> = clientV4.history.getAll()

        assertTrue(history.isNotEmpty())

        assertNotNull(history[0].title)
    }

    @Test
    fun `historyById returns history (history id is from allHistory)`() {
        val history: List<HistoryDto> = clientV4.history.getAll()

        assertTrue(history.isNotEmpty())

        assertNotNull(history[0].title)

        val historyItem: HistoryDto = clientV4.history.getById(history[0].id)

        assertNotNull(historyItem)
        assertEquals(history[0].title, historyItem.title)
    }

    @Test
    fun `query history test`() {
        val pagination: PaginatedResponse<HistoryDto> = clientV4.history.query(mapOf("limit" to 1))

        assertTrue(pagination.docs.isNotEmpty())
    }

    @Test
    fun `allLandPads returns non-empty list of landpads`() {
        val landpads: List<LandingPadDto> = clientV4.landPads.getAll()

        assertTrue(landpads.isNotEmpty())

        assertNotNull(landpads[0].name)
    }

    @Test
    fun `landpadsById returns landingpads (landing pad id is from allLandPads)`() {
        val landpads: List<LandingPadDto> = clientV4.landPads.getAll()

        assertTrue(landpads.isNotEmpty())

        assertNotNull(landpads[0].name)

        val landingPadDto: LandingPadDto = clientV4.landPads.getById(landpads[0].id)

        assertNotNull(landingPadDto)
        assertEquals(landpads[0].name, landingPadDto.name)
    }

    @Test
    fun `query landpads test`() {
        val pagination: PaginatedResponse<LandingPadDto> = clientV4.landPads.query(mapOf("limit" to 1))

        assertTrue(pagination.docs.isNotEmpty())
    }

    @Test
    fun `allLaunchPads returns non-empty list of launchpads`() {
        val launchpads: List<LaunchPadDto> = clientV4.launchPads.getAll()

        assertTrue(launchpads.isNotEmpty())

        assertNotNull(launchpads[0].name)
    }

    @Test
    fun `launchpadsById returns launchpads (launch pad id is from allLaunchPads)`() {
        val launchpads: List<LaunchPadDto> = clientV4.launchPads.getAll()

        assertTrue(launchpads.isNotEmpty())

        assertNotNull(launchpads[0].name)

        val launchPadDto: LaunchPadDto = clientV4.launchPads.getById(launchpads[0].id)

        assertNotNull(launchPadDto)
        assertEquals(launchpads[0].name, launchPadDto.name)
    }

    @Test
    fun `query launchpads test`() {
        val pagination: PaginatedResponse<LaunchPadDto> = clientV4.launchPads.query(mapOf("limit" to 1))

        assertTrue(pagination.docs.isNotEmpty())
    }

    @Test
    fun `allPayloads returns non-empty list of payloads`() {
        val payloads: List<PayloadDto> = clientV4.payloads.getAll()

        assertTrue(payloads.isNotEmpty())

        assertNotNull(payloads[0].name)
    }

    @Test
    fun `payloadById returns payload (payload id is from allPayloads)`() {
        val payloads: List<PayloadDto> = clientV4.payloads.getAll()

        assertTrue(payloads.isNotEmpty())

        assertNotNull(payloads[0].name)

        val payload: PayloadDto = clientV4.payloads.getById(payloads[0].id)

        assertNotNull(payload)
        assertEquals(payloads[0].name, payload.name)
    }

    @Test
    fun `query payloads test`() {
        val pagination: PaginatedResponse<PayloadDto> = clientV4.payloads.query(mapOf("limit" to 1))

        assertTrue(pagination.docs.isNotEmpty())
    }

    @Test
    fun `roadster get returns roadster`() {
        val roadster = clientV4.roadster.get()

        assertNotNull(roadster)
    }

    @Test
    fun `roadster query returns roadster`() {
        val roadster = clientV4.roadster.query(mapOf("limit" to 1))

        assertNotNull(roadster)
    }

    @Test
    fun `allRockets returns non-empty list of rockets`() {
        val rockets = clientV4.rockets.getAll()

        assertTrue(rockets.isNotEmpty())

        assertNotNull(rockets[0].name)
    }

    @Test
    fun `rocketById returns rocket (rocket id is from allRockets)`() {
        val rockets = clientV4.rockets.getAll()

        assertTrue(rockets.isNotEmpty())

        assertNotNull(rockets[0].name)

        val rocket = clientV4.rockets.getById(rockets[0].id)

        assertNotNull(rocket)
        assertEquals(rockets[0].name, rocket.name)
    }

    @Test
    fun `query rockets test`() {
        val pagination = clientV4.rockets.query(mapOf("limit" to 1))

        assertTrue(pagination.docs.isNotEmpty())
    }
}
