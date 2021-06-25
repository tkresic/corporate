package com.app.corporate.services

import com.app.corporate.models.Branch
import com.app.corporate.models.CashRegister
import com.app.corporate.repositories.BranchRepository
import com.app.corporate.repositories.CashRegisterRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.Optional

/**
 * Branch service.
 */
@Service
class BranchService(
    val branchDb: BranchRepository,
    val cashRegisterDb: CashRegisterRepository
)
{
    fun save(branch: Branch): Branch =
        branchDb.save(branch)

    fun read(id: Long): Optional<Branch> =
        branchDb.findById(id)

    fun byCashRegister(cashRegisterId: Long): ResponseEntity<Branch?> {
        val cashRegisterData: Optional<CashRegister> = cashRegisterDb.findById(cashRegisterId)
        if (!cashRegisterData.isPresent) {
            return ResponseEntity<Branch?>(HttpStatus.NOT_FOUND)
        }
        val data: CashRegister = cashRegisterData.get()
        return ResponseEntity<Branch?>(data.branch, HttpStatus.OK)
    }

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