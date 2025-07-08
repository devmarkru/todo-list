package ru.devmark.todo_list.service

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import ru.devmark.todo_list.model.CreateTodoItemRequest
import ru.devmark.todo_list.model.TodoItem
import ru.devmark.todo_list.repository.TodoListRepository

class TodoListServiceTest {

    private val repository: TodoListRepository = mockk()
    private val service = TodoListService(repository)

    @Test
    fun `getTodos returns list from repository`() {
        val items = listOf(
            TodoItem(1L, "first", 1),
            TodoItem(2L, "second", 2),
        )
        every { repository.findAll() } returns items

        val result = service.getTodos()

        assertEquals(items, result)
        verify(exactly = 1) { repository.findAll() }
    }

    @Test
    fun `addTodo delegates to repository`() {
        val request = CreateTodoItemRequest("new task")
        every { repository.findMaxOrder() } returns 4
        val saved = TodoItem(3L, "new task", 5)
        every { repository.save(request.title, 5) } returns saved

        val result = service.addTodo(request)

        assertEquals(saved, result)
        verify(exactly = 1) {
            repository.findMaxOrder()
            repository.save(request.title, 5)
        }
    }
}
