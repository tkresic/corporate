package com.app.corporate.repositories

import com.app.corporate.models.Branch
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Branch JPA repository.
 */
interface BranchRepository : JpaRepository<Branch, Long>