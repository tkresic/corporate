package com.app.corporate.models;

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

/**
 * CashRegister model.
 */
@Entity
@Table(name = "cash_registers")
data class CashRegister(
    @Id
    val id: String,
    var label: Long,
    @ManyToOne
    @JoinColumn(name="branch_id")
    var branch: Branch?,
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),
    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    var updatedAt: LocalDateTime = LocalDateTime.now()
)