package com.app.corporate.seeds

import com.app.corporate.models.Branch
import com.app.corporate.models.CashRegister
import com.app.corporate.models.Company
import com.app.corporate.repositories.BranchRepository
import com.app.corporate.repositories.CashRegisterRepository
import com.app.corporate.repositories.CompanyRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

/**
 * Database seeder.
 */
@Component
class DatabaseSeeder(
    private val companyRepository: CompanyRepository,
    private val branchRepository: BranchRepository,
    private val cashRegisterRepository: CashRegisterRepository,
) : ApplicationRunner {

    override fun run(args: ApplicationArguments) {
        // Company
        val company = companyRepository.findAll()
        if (company.size <= 0) {
            companyRepository.save(
                Company(
                    id = 1,
                    name = "Bistro Krea d.o.o",
                    address = "Ulica Ivana Mihovila 12",
                    pidn = "08601928691",
                    phone = "01 261 9682",
                )
            );
        }
        // Branch
        val branch = branchRepository.findAll()
        if (branch.size <= 0) {
            branchRepository.save(
                Branch(
                    id = 1,
                    name = "Zagreb Centar",
                    businessPlaceLabel = 1,
                    address = "Ulica Ante Starčevića 152",
                    phone = "01 116 2217",
                )
            )
        }
        // Cash Register
        val cashRegister = cashRegisterRepository.findAll()
        if (cashRegister.size <= 0) {
            cashRegisterRepository.save(
                CashRegister(
                    id = "2072d31b-3e3e-4812-a378-aeedef596b98",
                    branch = branch[0],
                    label = 1
                )
            )
        }
    }
}