package com.app.corporate.repositories

import com.app.corporate.models.CashRegister
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

/**
 * CashRegister JPA repository.
 */
interface CashRegisterRepository : JpaRepository<CashRegister, Long>