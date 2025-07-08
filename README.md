# Todo List

Небольшое приложение на Kotlin и Spring Boot, предоставляющее REST-интерфейс для работы со списком задач. Данные хранятся в базе H2, доступ осуществляется через `JdbcClient`.

## Эндпоинты
- `GET /todo` — возвращает все задачи в порядке возрастания `order`.
- `POST /todo` — добавляет новую задачу с указанным заголовком и присваивает ей наивысший приоритет.

База данных инициализируется из файла `schema.sql` при запуске приложения.

### SQL для создания таблицы
```sql
create table if not exists todo (
    id identity primary key,
    title varchar(255) not null,
    order_num int not null
);
```
