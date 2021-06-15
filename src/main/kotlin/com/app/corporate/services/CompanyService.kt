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
    fun all(): MutableIterable<Company> =
        db.findAll()

    fun save(company: Company): Company =
        db.save(company)

    fun read(id: Long): Optional<Company> =
        db.findById(id)

    fun update(id: Long, company: Company): ResponseEntity<Company?> {
        val companyData: Optional<Company> = this.read(id)

        if (!companyData.isPresent) {
            return ResponseEntity<Company?>(HttpStatus.NOT_FOUND)
        }

        val updatedCompany: Company = companyData.get()

        updatedCompany.name = company.name

        return ResponseEntity<Company?>(this.save(updatedCompany), HttpStatus.OK)
    }

    fun delete(id: Long) =
        db.deleteById(id)
}