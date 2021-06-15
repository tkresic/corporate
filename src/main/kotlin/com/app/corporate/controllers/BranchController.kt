package com.app.corporate.controllers

import com.app.corporate.models.Branch
import com.app.corporate.services.BranchService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.Optional

/**
 * Branch controller for CRUD methods.
 */
@RestController
@RequestMapping("/api/branches")
class BranchController(val service: BranchService) {
    @GetMapping
    fun index(): MutableIterable<Branch> =
        service.all()

    @PostMapping
    fun create(@RequestBody branch: Branch) =
        service.save(branch)

    @GetMapping("/{id}")
    fun read(@PathVariable id: Long): Optional<Branch> =
        service.read(id)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody branch: Branch): ResponseEntity<Branch?> =
        service.update(id, branch);

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) =
        service.delete(id)
}