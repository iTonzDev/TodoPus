package com.thehoiman.todopus.repositories

import com.thehoiman.todopus.entities.Todo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TodoRepository  : JpaRepository<Todo, Long> {
}