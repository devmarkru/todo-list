package ru.devmark.todo_list.service

import org.springframework.stereotype.Service
import ru.devmark.todo_list.model.CreateTodoItemRequest
import ru.devmark.todo_list.model.TodoItem
import ru.devmark.todo_list.repository.TodoListRepository

@Service
class TodoListService(
    private val todoListRepository: TodoListRepository,
) {

    fun getTodos(): List<TodoItem> = todoListRepository.findAll()

    fun addTodo(request: CreateTodoItemRequest): TodoItem {
        val maxOrder = todoListRepository.findMaxOrder()
        val newOrder = maxOrder?.plus(1) ?: 1
        return todoListRepository.save(request.title, newOrder)
    }
}
