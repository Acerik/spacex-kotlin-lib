package v4

import cz.matejvana.spacexkotapi.request.PaginatedResponse
import cz.matejvana.spacexkotapi.v4.SpaceXClientV4
import cz.matejvana.spacexkotapi.v4.launches.LaunchV4Dto
import io.mockk.every
import io.mockk.mockk
import kotlin.test.*

class LaunchesV4IT {

    @Test
    fun testAllLaunchesV4Success() {
        val client = mockk<SpaceXClientV4>()
        every { client.launchesV4.getAll() } returns listOf(
            LaunchV4Dto(
                id = "id",
                flightNumber = 1,
                name = "Test Launch",
                dateUtc = "2021-01-01T00:00:00.000Z",
                dateUnix = 1609459200,
                dateLocal = "2021-01-01T00:00:00",
                datePrecision = "hour",
                staticFireDateUtc = null,
                staticFireDateUnix = null,
                tbd = false,
                net = false,
                window = null,
                launchLibraryId = null,
                rocket = "rocket_id",
                success = true,
                failures = emptyList(),
                upcoming = false,
                details = "Test launch details",
                fairings = null,
                crew = emptyList(),
                ships = emptyList(),
                capsules = emptyList(),
                payloads = emptyList(),
                launchpad = "launchpad_id",
                cores = emptyList(),
                links = null,
                autoUpdate = true
            )
        )

        val launches = client.launchesV4.getAll()
        assertTrue(launches.isNotEmpty())
        assertEquals(1, launches.size)
        assertEquals("id", launches[0].id)
        assertEquals("Test Launch", launches[0].name)
    }

    @Test
    fun testLaunchV4ByIdSuccess() {
        val client = mockk<SpaceXClientV4>()
        val launch = LaunchV4Dto(
            id = "id",
            flightNumber = 1,
            name = "Test Launch",
            dateUtc = "2021-01-01T00:00:00.000Z",
            dateUnix = 1609459200,
            dateLocal = "2021-01-01T00:00:00",
            datePrecision = "hour",
            staticFireDateUtc = null,
            staticFireDateUnix = null,
            tbd = false,
            net = false,
            window = null,
            launchLibraryId = null,
            rocket = "rocket_id",
            success = true,
            failures = emptyList(),
            upcoming = false,
            details = "Test launch details",
            fairings = null,
            crew = emptyList(),
            ships = emptyList(),
            capsules = emptyList(),
            payloads = emptyList(),
            launchpad = "launchpad_id",
            cores = emptyList(),
            links = null,
            autoUpdate = true
        )
        every { client.launchesV4.getById("id") } returns launch

        val result = client.launchesV4.getById("id")
        assertNotNull(result)
        assertEquals("id", result.id)
        assertEquals("Test Launch", result.name)
    }

    @Test
    fun testQueryLaunchesV4Success() {
        val client = mockk<SpaceXClientV4>()
        val paginatedResponse = PaginatedResponse(
            docs = listOf(
                LaunchV4Dto(
                    id = "id",
                    flightNumber = 1,
                    name = "Test Launch",
                    dateUtc = "2021-01-01T00:00:00.000Z",
                    dateUnix = 1609459200,
                    dateLocal = "2021-01-01T00:00:00",
                    datePrecision = "hour",
                    staticFireDateUtc = null,
                    staticFireDateUnix = null,
                    tbd = false,
                    net = false,
                    window = null,
                    launchLibraryId = null,
                    rocket = "rocket_id",
                    success = true,
                    failures = emptyList(),
                    upcoming = false,
                    details = "Test launch details",
                    fairings = null,
                    crew = emptyList(),
                    ships = emptyList(),
                    capsules = emptyList(),
                    payloads = emptyList(),
                    launchpad = "launchpad_id",
                    cores = emptyList(),
                    links = null,
                    autoUpdate = true
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
        every { client.launchesV4.query(any()) } returns paginatedResponse

        val result = client.launchesV4.query(mapOf("limit" to 1))
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
        assertEquals("Test Launch", result.docs[0].name)
    }

    @Test
    fun testLatestLaunchV4Success() {
        val client = mockk<SpaceXClientV4>()
        val launch = LaunchV4Dto(
            id = "id",
            flightNumber = 1,
            name = "Latest Launch",
            dateUtc = "2021-01-01T00:00:00.000Z",
            dateUnix = 1609459200,
            dateLocal = "2021-01-01T00:00:00",
            datePrecision = "hour",
            staticFireDateUtc = null,
            staticFireDateUnix = null,
            tbd = false,
            net = false,
            window = null,
            launchLibraryId = null,
            rocket = "rocket_id",
            success = true,
            failures = emptyList(),
            upcoming = false,
            details = "Latest launch details",
            fairings = null,
            crew = emptyList(),
            ships = emptyList(),
            capsules = emptyList(),
            payloads = emptyList(),
            launchpad = "launchpad_id",
            cores = emptyList(),
            links = null,
            autoUpdate = true
        )
        every { client.launchesV4.latest() } returns launch

        val result = client.launchesV4.latest()
        assertNotNull(result)
        assertEquals("id", result.id)
        assertEquals("Latest Launch", result.name)
    }

    @Test
    fun testNextLaunchV4Success() {
        val client = mockk<SpaceXClientV4>()
        val launch = LaunchV4Dto(
            id = "id",
            flightNumber = 1,
            name = "Next Launch",
            dateUtc = "2021-01-01T00:00:00.000Z",
            dateUnix = 1609459200,
            dateLocal = "2021-01-01T00:00:00",
            datePrecision = "hour",
            staticFireDateUtc = null,
            staticFireDateUnix = null,
            tbd = false,
            net = false,
            window = null,
            launchLibraryId = null,
            rocket = "rocket_id",
            success = true,
            failures = emptyList(),
            upcoming = false,
            details = "Next launch details",
            fairings = null,
            crew = emptyList(),
            ships = emptyList(),
            capsules = emptyList(),
            payloads = emptyList(),
            launchpad = "launchpad_id",
            cores = emptyList(),
            links = null,
            autoUpdate = true
        )
        every { client.launchesV4.next() } returns launch

        val result = client.launchesV4.next()
        assertNotNull(result)
        assertEquals("id", result.id)
        assertEquals("Next Launch", result.name)
    }

    @Test
    fun testPastLaunchesV4Success() {
        val client = mockk<SpaceXClientV4>()
        every { client.launchesV4.past() } returns listOf(
            LaunchV4Dto(
                id = "id",
                flightNumber = 1,
                name = "Past Launch",
                dateUtc = "2021-01-01T00:00:00.000Z",
                dateUnix = 1609459200,
                dateLocal = "2021-01-01T00:00:00",
                datePrecision = "hour",
                staticFireDateUtc = null,
                staticFireDateUnix = null,
                tbd = false,
                net = false,
                window = null,
                launchLibraryId = null,
                rocket = "rocket_id",
                success = true,
                failures = emptyList(),
                upcoming = false,
                details = "Past launch details",
                fairings = null,
                crew = emptyList(),
                ships = emptyList(),
                capsules = emptyList(),
                payloads = emptyList(),
                launchpad = "launchpad_id",
                cores = emptyList(),
                links = null,
                autoUpdate = true
            )
        )

        val launches = client.launchesV4.past()
        assertTrue(launches.isNotEmpty())
        assertEquals(1, launches.size)
        assertEquals("id", launches[0].id)
        assertEquals("Past Launch", launches[0].name)
    }

    @Test
    fun testUpcomingLaunchesV4Success() {
        val client = mockk<SpaceXClientV4>()
        every { client.launchesV4.upcoming() } returns listOf(
            LaunchV4Dto(
                id = "id",
                flightNumber = 1,
                name = "Upcoming Launch",
                dateUtc = "2021-01-01T00:00:00.000Z",
                dateUnix = 1609459200,
                dateLocal = "2021-01-01T00:00:00",
                datePrecision = "hour",
                staticFireDateUtc = null,
                staticFireDateUnix = null,
                tbd = false,
                net = false,
                window = null,
                launchLibraryId = null,
                rocket = "rocket_id",
                success = true,
                failures = emptyList(),
                upcoming = true,
                details = "Upcoming launch details",
                fairings = null,
                crew = emptyList(),
                ships = emptyList(),
                capsules = emptyList(),
                payloads = emptyList(),
                launchpad = "launchpad_id",
                cores = emptyList(),
                links = null,
                autoUpdate = true
            )
        )

        val launches = client.launchesV4.upcoming()
        assertTrue(launches.isNotEmpty())
        assertEquals(1, launches.size)
        assertEquals("id", launches[0].id)
        assertEquals("Upcoming Launch", launches[0].name)
    }
}