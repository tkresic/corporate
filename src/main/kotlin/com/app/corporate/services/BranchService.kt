package com.app.corporate.services

import com.app.corporate.models.Branch
import com.app.corporate.repositories.BranchRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.Optional

/**
 * Branch service.
 */
@Service
class BranchService(val db: BranchRepository) {
    fun save(branch: Branch): Branch =
        db.save(branch)

    fun read(id: Long): Optional<Branch> =
        db.findById(id)

    fun update(id: Long, branch: Branch): ResponseEntity<Branch?> {
        val branchData: Optional<Branch> = this.read(id)

        if (!branchData.isPresent) {
            return ResponseEntity<Branch?>(HttpStatus.NOT_FOUND)
        }

        val updatedBranch: Branch = branchData.get()

        updatedBranch.name = branch.name
        updatedBranch.businessPlaceLabel = branch.businessPlaceLabel
        updatedBranch.address = branch.address
        updatedBranch.phone = branch.phone

        return ResponseEntity<Branch?>(this.save(updatedBranch), HttpStatus.OK)
    }
}