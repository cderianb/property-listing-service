create table listings(
     id serial primary key not null,
     user_id int not null,
     price int not null,
     listing_type varchar(5) not null,
     created_at bigint not null,
     updated_at bigint
)