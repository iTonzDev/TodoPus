package com.thehoiman.todopus.controllers

import com.thehoiman.todopus.entities.Reward
import com.thehoiman.todopus.repositories.RewardRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime
import java.util.concurrent.atomic.AtomicLong
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class RewardController(private val rewardRepository: RewardRepository) {


    @GetMapping("/rewards")
    fun getAll() = rewardRepository.findAll()

    @PostMapping("/rewards")
    fun createNewReward(@Valid @RequestBody reward: Reward): Reward =
            rewardRepository.save(reward)


    @GetMapping("/rewards/{id}")
    fun getRewardById(@PathVariable(value = "id") rewardId: Long): ResponseEntity<Reward> {
        return rewardRepository.findById(rewardId).map { reward ->
            ResponseEntity.ok(reward)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/rewards/{id}")
    fun updateRewardById(@PathVariable(value = "id") rewardId: Long,
                          @Valid @RequestBody newReward: Reward): ResponseEntity<Reward> {

        return rewardRepository.findById(rewardId).map { existingReward ->
            val updatedReward = existingReward
                    .copy(title = newReward.title
                            ,status = newReward.status
                            , point = newReward.point
                            ,updateDate = LocalDateTime.now())
            ResponseEntity.ok().body(rewardRepository.save(updatedReward))
        }.orElse(ResponseEntity.notFound().build())

    }


}