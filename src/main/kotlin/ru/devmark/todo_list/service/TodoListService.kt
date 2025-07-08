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

    fun addTodo(request: CreateTodoItemRequest): TodoItem =
        // todo в этом методе определять порядок с помощью отдельного запроса в БД, иначе ставить 1
        todoListRepository.save(request.title)
}
