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

CREATE TABLE categories(
       id bigint auto_increment primary key,
       name varchar(255)
);


CREATE TABLE posts(
      id bigint auto_increment,
      post_content text,
      created_at datetime,
      image_url varchar(255),
      post_title varchar(255),
      category_id bigint(20),
      primary key (id),
      FOREIGN KEY (category_id) REFERENCES categories (id)
);

CREATE TABLE comments(
    id bigint auto_increment primary key,
    commented_at datetime,
    content text,
    full_name varchar(255),
    post_id bigint(20),
    FOREIGN KEY (post_id) REFERENCES posts (id) ON DELETE CASCADE
);

CREATE TABLE tags(
     id bigint auto_increment primary key,
     tag_name varchar(255)
);

CREATE TABLE post_tags(
  post_id bigint,
  tag_id bigint
);

ALTER TABLE post_tags
    ADD CONSTRAINT fk_t_posts_tags_t_posts
        FOREIGN KEY (post_id)
            REFERENCES posts (id)
            ON DELETE CASCADE;

ALTER TABLE post_tags
    ADD CONSTRAINT fk_t_posts_tags_t_tags
        FOREIGN KEY (tag_id)
            REFERENCES tags (id)
            ON DELETE CASCADE;

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
