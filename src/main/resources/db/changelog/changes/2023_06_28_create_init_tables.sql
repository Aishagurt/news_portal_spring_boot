CREATE TABLE t_permission(
    id bigint auto_increment,
    role varchar(255),
    primary key (id)
);

CREATE TABLE t_users (
    id bigint auto_increment,
    email varchar(255),
    full_name varchar(255),
    password varchar(255),
    primary key (id)
);

CREATE TABLE t_users_permissions(
    user_id bigint,
    permissions_id bigint
);

CREATE TABLE t_courses(
    id bigint auto_increment,
    name varchar(255),
    description text,
    price int,
    primary key (id)
);

ALTER TABLE t_users_permissions
    ADD CONSTRAINT fk_t_users_permissions_t_users
        FOREIGN KEY (user_id)
            REFERENCES t_users (id)
            ON DELETE CASCADE;

ALTER TABLE t_users_permissions
    ADD CONSTRAINT fk_t_users_permissions_t_permission
        FOREIGN KEY (permissions_id)
            REFERENCES t_permission (id)
            ON DELETE CASCADE;