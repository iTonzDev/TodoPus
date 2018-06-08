package com.thehoiman.todopus.controllers

import com.thehoiman.todopus.entities.Todo
import com.thehoiman.todopus.repositories.TodoRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class TodoController(private val todoRepository: TodoRepository) {

    @GetMapping("/todos")
    fun getAll() = todoRepository.findAll()

    @GetMapping("/todos/{id}")
    fun getTodoById(@PathVariable(value = "id") id: Long): ResponseEntity<Todo> {
        return todoRepository.findById(id).map { todo ->
            ResponseEntity.ok(todo)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PostMapping("/todos")
    fun createTodo(@Valid @RequestBody todo: Todo): Todo = todoRepository.save(todo)

    @PutMapping("/todos/{id}")
    fun updateTodoById(@PathVariable(value = "id") id: Long,
                       @Valid @RequestBody todo: Todo): ResponseEntity<Todo> {
        return todoRepository.findById(id).map { existingReward ->
            val updatedTodo = existingReward
                    .copy(title = todo.title,
                            status = todo.status,
                            updateDate = LocalDateTime.now())
            ResponseEntity.ok().body(todoRepository.save(updatedTodo))
        }.orElse(ResponseEntity.notFound().build())

    }

}