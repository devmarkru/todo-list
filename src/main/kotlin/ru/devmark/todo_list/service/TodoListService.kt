package ru.devmark.todo_list.service

import org.springframework.stereotype.Service
import ru.devmark.todo_list.model.CreateTodoItemRequest
import ru.devmark.todo_list.model.TodoItem
import ru.devmark.todo_list.repository.TodoListRepository

@Serviceclass TodoListService(
    private val todoListRepository: TodoListRepository,
) {

    fun getTodos(): List<TodoItem> = todoListRepository.findAll()

    fun addTodo(request: CreateTodoItemRequest): TodoItem =
        todoListRepository.save(request.title)
}
