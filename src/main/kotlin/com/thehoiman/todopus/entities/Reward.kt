package com.thehoiman.todopus.entities

import java.time.LocalDate
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank
import java.time.LocalDateTime


enum class Status {
    Active,
    Inactive,
    Delete
}

@Entity
data class Reward (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,

        @get : NotBlank
        val title: String="",

        val status: Status = Status.Active,

        val point: Int = 0,

        val createDate: LocalDateTime = LocalDateTime.now(),

        val updateDate: LocalDateTime? = null


)