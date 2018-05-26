package com.thehoiman.todopus

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TodopusApplication

fun main(args: Array<String>) {
    runApplication<TodopusApplication>(*args)
}
