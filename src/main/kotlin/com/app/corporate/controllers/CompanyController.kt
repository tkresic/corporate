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
    fun index(): MutableIterable<Company> =
        service.all()

    @PostMapping
    fun create(@RequestBody company: Company) =
        service.save(company)

    @GetMapping("/{id}")
    fun read(@PathVariable id: Long): Optional<Company> =
        service.read(id)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody company: Company): ResponseEntity<Company?> =
        service.update(id, company);

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) =
        service.delete(id)
}