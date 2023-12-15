CREATE TABLE users
(
    id       BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255)        NOT NULL,
    email    VARCHAR(255)
);


CREATE TABLE user_roles
(
    user_id BIGINT,
    role    VARCHAR(255),
    PRIMARY KEY (user_id, role),
    FOREIGN KEY (user_id) REFERENCES users (id)
);

-- Insertar usuario con rol de administrador
INSERT INTO users (username, password, email)
VALUES ('admin_user', 'super', 'admin@example.com');

INSERT INTO user_roles (user_id, role)
VALUES (LAST_INSERT_ID(), 'admin');


-- Insertar usuario con rol de usuario
INSERT INTO users (username, password, email)
VALUES ('regular_user', 'duper', 'user@example.com');

INSERT INTO user_roles (user_id, role)
VALUES (LAST_INSERT_ID(), 'user');