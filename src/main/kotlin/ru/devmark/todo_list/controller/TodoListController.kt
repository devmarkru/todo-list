package ru.devmark.todo_list.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.devmark.todo_list.model.CreateTodoItemRequest
import ru.devmark.todo_list.model.TodoItem
import ru.devmark.todo_list.service.TodoListService

@RestController
@RequestMapping("/todo")
class TodoListController(
    private val todoListService: TodoListService,
) {
    @GetMapping
    fun getAll(): List<TodoItem> = todoListService.getTodos()

    @PostMapping
    fun add(@RequestBody request: CreateTodoItemRequest): TodoItem =
        todoListService.addTodo(request)
}
