package ru.devmark.todo_list.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.devmark.todo_list.service.TodoListService

@RestController
@RequestMapping("/todo")
class TodoListController(
    private val todoListService: TodoListService,
) {
}