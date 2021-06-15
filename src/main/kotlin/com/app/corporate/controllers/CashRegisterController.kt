package com.app.corporate.controllers

import com.app.corporate.models.CashRegister
import com.app.corporate.services.CashRegisterService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.Optional

/**
 * CashRegister controller for CRUD methods.
 */
@RestController
@RequestMapping("/api/cashRegister")
class CashRegisterController(val service: CashRegisterService) {
    @GetMapping
    fun index(): MutableIterable<CashRegister> =
        service.all()

    @PostMapping
    fun create(@RequestBody cashRegister: CashRegister) =
        service.save(cashRegister)

    @GetMapping("/{id}")
    fun read(@PathVariable id: Long): Optional<CashRegister> =
        service.read(id)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody cashRegister: CashRegister): ResponseEntity<CashRegister?> =
        service.update(id, cashRegister);

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) =
        service.delete(id)
}