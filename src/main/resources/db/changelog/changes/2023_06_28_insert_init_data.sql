INSERT INTO t_permission (role)
VALUES
    ('ROLE_USER'),
    ('ROLE_STUDENT'),
    ('ROLE_TEACHER'),
    ('ROLE_ADMIN');

INSERT INTO t_users (email, full_name, password)
VALUES
    ('ilyas@gmail.com', 'Ilyas User', '$2a$10$EdojOIvoKPLG0TyNcxOyR.A69iSvlKoJMDqhHOXUNMq0EGxe/H0Lu'),
    ('berik@gmail.com', 'Berik Serikov', '$2a$10$J4fRTgfhCU5u4KHsFXmXJOZj.6gTU624Ao4h6kXQCUwcdRMUPpNjC'),
    ('serik@gmail.com', 'Serik Berikov', '$2a$10$J4fRTgfhCU5u4KHsFXmXJOZj.6gTU624Ao4h6kXQCUwcdRMUPpNjC'),
    ('erik@gmail.com', 'Erik Erikov', '$2a$10$gRvFqjnHgE1jyrNFESgWiuaFsdN925fmDSfcaHbhiax03CIG/QcPO'),
    ('zhandos@gmail.com', 'Ilyas User', '$2a$10$t.EhsVgv6j.rZFbz6r507OOrc5PxszKZc0q1QObAFgtnC.Xyvz/qG');

INSERT INTO t_users_permissions (user_id, permissions_id)
VALUES
    (1,1),
    (1,2),
    (1,3),
    (1,4),
    (2,1),
    (2,2),
    (3,1),
    (3,3),
    (2,3);