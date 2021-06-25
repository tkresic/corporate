package com.app.corporate.repositories

import com.app.corporate.models.CashRegister
import org.springframework.data.jpa.repository.JpaRepository

/**
 * CashRegister JPA repository.
 */
interface CashRegisterRepository : JpaRepository<CashRegister, String>