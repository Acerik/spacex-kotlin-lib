package v4

import cz.matejvana.spacexkotapi.v4.ClientV4
import cz.matejvana.spacexkotapi.v4.company.CompanyDto
import io.mockk.every
import io.mockk.mockk
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNotNull

class CompanyIT {

    @Test
    fun testAllCompaniesSuccess() {
        val client = mockk<ClientV4>()
        every { client.company.getAllInfo() } returns
                CompanyDto(
                    "5eb75edc42fea42237d7f3f4",
                    "SpaceX",
                    "Elon Musk",
                    2002,
                    8000,
                    4,
                    3,
                    2,
                    "Elon Musk",
                    "Gwynne Shotwell",
                    "Gwynne Shotwell",
                    "Tom Mueller",
                    74000000,
                    CompanyDto.Headquarters("Rocket Road", "Hawthorne", "California"),
                    CompanyDto.Links(
                        "https://www.spacex.com",
                        "https://www.flickr.com/photos/spacex/",
                        "https://twitter.com/SpaceX",
                        "https://twitter.com/elonmusk"
                    ),
                    "SpaceX designs, manufactures and launches advanced rockets and spacecraft."
                )

        val company = client.company.getAllInfo()
        assertNotNull(company)
        assertEquals("5eb75edc42fea42237d7f3f4", company.id)
        assertEquals("SpaceX", company.name)
        assertEquals("Elon Musk", company.founder)
        assertEquals(2002, company.founded)
        assertEquals(8000, company.employees)
        assertEquals(4, company.vehicles)
        assertEquals(3, company.launchSites)
        assertEquals(2, company.testSites)
        assertEquals("Elon Musk", company.ceo)
        assertEquals("Gwynne Shotwell", company.cto)
        assertEquals("Gwynne Shotwell", company.coo)
        assertEquals("Tom Mueller", company.ctoPropulsion)
        assertEquals(74000000, company.valuation)
        assertEquals("Rocket Road", company.headquarters.address)
        assertEquals("Hawthorne", company.headquarters.city)
        assertEquals("California", company.headquarters.state)
        assertEquals("https://www.spacex.com", company.links.website)
        assertEquals("https://www.flickr.com/photos/spacex/", company.links.flickr)
        assertEquals("https://twitter.com/SpaceX", company.links.twitter)
        assertEquals("https://twitter.com/elonmusk", company.links.elonTwitter)
        assertEquals("SpaceX designs, manufactures and launches advanced rockets and spacecraft.", company.summary)
    }

    @Test
    fun testAllCompaniesInternetFailure() {
        val client = mockk<ClientV4>()
        every { client.company.getAllInfo() } throws RuntimeException("Internet connection error")

        assertFailsWith<RuntimeException> {
            client.company.getAllInfo()
        }
    }

    @Test
    fun testAllCompanies400StatusCode() {
        val client = mockk<ClientV4>()
        every { client.company.getAllInfo() } throws RuntimeException("HTTP 400 Bad Request")

        assertFailsWith<RuntimeException> {
            client.company.getAllInfo()
        }
    }
}