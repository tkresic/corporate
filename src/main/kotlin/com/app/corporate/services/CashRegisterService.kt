package com.app.corporate.services

import com.app.corporate.models.CashRegister
import com.app.corporate.repositories.CashRegisterRepository
import org.springframework.stereotype.Service
import java.util.Optional

/**
 * CashRegister service.
 */
@Service
class CashRegisterService(val db: CashRegisterRepository) {
    fun read(id: Long): Optional<CashRegister> =
        db.findById(id)
}