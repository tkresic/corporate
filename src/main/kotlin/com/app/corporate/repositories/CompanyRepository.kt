package com.app.corporate.repositories

import com.app.corporate.models.Company
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

/**
 * Company JPA repository.
 */
interface CompanyRepository : JpaRepository<Company, Long> {
    fun findFirstByIdIsNotNullOrderByCreatedAtAsc(): Optional<Company>
}