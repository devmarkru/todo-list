package ru.devmark.todo_list.repository

import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.simple.JdbcClient
import org.springframework.jdbc.support.GeneratedKeyHolder
import org.springframework.stereotype.Repository
import ru.devmark.todo_list.model.TodoItem

@Repository
class TodoListRepository(
    private val jdbcClient: JdbcClient,
) {

    fun findAll(): List<TodoItem> =
        jdbcClient
            .sql("select id, title, order_num from todo order by order_num desc")
            .query(RowMapperCompanion)
            .list()

    fun save(title: String, order: Int): TodoItem {
        val keyHolder = GeneratedKeyHolder()
        jdbcClient
            .sql("insert into todo(title, order_num) values (:title, :order)")
            .param("title", title)
            .param("order", order)
            .update(keyHolder)
        return TodoItem(keyHolder.key!!.toLong(), title, order)
    }

    fun findMaxOrder(): Int? =
        jdbcClient
            .sql("select max(order_num) from todo")
            .query(Long::class.java)
            .list()
            .firstOrNull()
            ?.toInt()

    companion object {
        val RowMapperCompanion = RowMapper { rs, _ ->
            TodoItem(
                id = rs.getLong("id"),
                title = rs.getString("title"),
                order = rs.getInt("order_num"),
            )
        }
    }
}
