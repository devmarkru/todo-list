create table if not exists todo (
    id identity primary key,
    title varchar(255) not null,
    order_num int not null
);
