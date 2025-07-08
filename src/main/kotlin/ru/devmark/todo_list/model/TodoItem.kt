package ru.devmark.todo_list.model

data class TodoItem(
    val id: Long,
    val title: String,
    val order: Int,
)
