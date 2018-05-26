package com.thehoiman.todopus.repositories

import com.thehoiman.todopus.entities.Reward
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface RewardRepository  : JpaRepository<Reward, Long> {
}