package com.app.corporate.repositories

import com.app.corporate.models.Company
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Company JPA repository.
 */
interface CompanyRepository : JpaRepository<Company, Long>