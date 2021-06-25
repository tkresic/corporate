package com.app.corporate.controllers

import com.app.corporate.models.CashRegister
import com.app.corporate.services.CashRegisterService
import org.springframework.web.bind.annotation.*
import java.util.Optional

/**
 * CashRegister controller for CRUD methods.
 */
@RestController
@RequestMapping("/api/cash-registers")
class CashRegisterController(val service: CashRegisterService) {
    @GetMapping("/{id}")
    fun read(@PathVariable id: String): Optional<CashRegister> =
        service.read(id)
}