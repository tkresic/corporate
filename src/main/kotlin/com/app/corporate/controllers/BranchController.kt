package com.app.corporate.controllers

import com.app.corporate.models.Branch
import com.app.corporate.services.BranchService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * Branch controller for CRUD methods.
 */
@RestController
@RequestMapping("/api/branches")
class BranchController(val service: BranchService) {
    @GetMapping("/by-cash-register/{cashRegisterId}")
    fun read(@PathVariable cashRegisterId: Long): ResponseEntity<Branch?> =
        service.byCashRegister(cashRegisterId)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody branch: Branch): ResponseEntity<Branch?> =
        service.update(id, branch);
}