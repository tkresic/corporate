package com.app.corporate.services

import com.app.corporate.models.CashRegister
import com.app.corporate.repositories.CashRegisterRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.Optional

/**
 * CashRegister service.
 */
@Service
class CashRegisterService(val db: CashRegisterRepository) {
    fun all(): MutableIterable<CashRegister> =
        db.findAll()

    fun save(cashRegister: CashRegister): CashRegister =
        db.save(cashRegister)

    fun read(id: Long): Optional<CashRegister> =
        db.findById(id)

    fun update(id: Long, cashRegister: CashRegister): ResponseEntity<CashRegister?> {
        val cashRegisterData: Optional<CashRegister> = this.read(id)

        if (!cashRegisterData.isPresent) {
            return ResponseEntity<CashRegister?>(HttpStatus.NOT_FOUND)
        }

        val updatedCashRegister: CashRegister = cashRegisterData.get()

        updatedCashRegister.name = cashRegister.name

        return ResponseEntity<CashRegister?>(this.save(updatedCashRegister), HttpStatus.OK)
    }

    fun delete(id: Long) =
        db.deleteById(id)
}