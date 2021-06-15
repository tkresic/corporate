package com.app.corporate.services

import com.app.corporate.models.Company
import com.app.corporate.repositories.CompanyRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.Optional

/**
 * Company service.
 */
@Service
class CompanyService(val db: CompanyRepository) {
    fun save(company: Company): Company =
        db.save(company)

    fun read(): Optional<Company> =
        db.findFirstByIdIsNotNullOrderByCreatedAtAsc()

    fun update(company: Company): ResponseEntity<Company?> {
        val companyData: Optional<Company> = this.read()

        if (!companyData.isPresent) {
            return ResponseEntity<Company?>(HttpStatus.NOT_FOUND)
        }

        val updatedCompany: Company = companyData.get()

        updatedCompany.name = company.name
        updatedCompany.address = company.address
        updatedCompany.pidn = company.pidn
        updatedCompany.phone = company.phone

        return ResponseEntity<Company?>(this.save(updatedCompany), HttpStatus.OK)
    }
}