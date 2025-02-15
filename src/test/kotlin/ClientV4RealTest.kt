import cz.matejvana.spacexkotapi.request.PaginatedResponse
import cz.matejvana.spacexkotapi.v4.ClientV4
import cz.matejvana.spacexkotapi.v4.capsules.CapsuleDto
import cz.matejvana.spacexkotapi.v4.cores.CoreDto
import cz.matejvana.spacexkotapi.v4.crew.CrewDto
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
}
