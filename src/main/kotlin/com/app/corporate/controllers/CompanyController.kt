package com.app.corporate.controllers

import com.app.corporate.models.Company
import com.app.corporate.services.CompanyService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.Optional

/**
 * Company controller for CRUD methods.
 */
@RestController
@RequestMapping("/api/company")
class CompanyController(val service: CompanyService) {
    @GetMapping
    fun read(): Optional<Company> =
        service.read()

    @PutMapping
    fun update(@RequestBody company: Company): ResponseEntity<Company?> =
        service.update(company);
}