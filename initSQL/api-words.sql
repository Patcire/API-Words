-- API-WORDS

CREATE TABLE teams
(
    id_team INT NOT NULL,
    name    VARCHAR(50),
    badge   VARCHAR(50),
    score   INT,
    PRIMARY KEY (id_team)
);

CREATE TABLE players
(
    id_player  INT NOT NULL,
    score      INT,
    role       ENUM ('admin', 'user'),
    avatar_img VARCHAR(150),
    fk_id_team INT NOT NULL,
    PRIMARY KEY (id_player),
    FOREIGN KEY (fk_id_team) REFERENCES teams (id_team)
);

CREATE TABLE games
(
    id_game         INT NOT NULL,
    max_tries       INT,
    difficulty_game ENUM ('low', 'mid', 'high'),
    description     VARCHAR(250),
    PRIMARY KEY (id_game),
    CHECK (max_tries BETWEEN 0 AND 6)
);

CREATE TABLE words
(
    id_word INT NOT NULL,
    word    VARCHAR(5),
    PRIMARY KEY (id_word)
);

CREATE TABLE words_games
(
    fk_id_game      INT NOT NULL,
    fk_id_word      INT NOT NULL,
    difficulty_word ENUM ('low', 'mid', 'high'),
    PRIMARY KEY (fk_id_game, fk_id_word),
    FOREIGN KEY (fk_id_game) REFERENCES games (id_game),
    FOREIGN KEY (fk_id_word) REFERENCES words (id_word)
);

CREATE TABLE matches
(
    id_match     INT NOT NULL,
    word         VARCHAR(5),
    score        INT,
    n_try        INT,
    date         DATETIME,
    fk_id_player INT NOT NULL,
    fk_id_game   INT NOT NULL,
    PRIMARY KEY (id_match),
    CHECK (n_try BETWEEN 0 AND 6),
    FOREIGN KEY (fk_id_game) REFERENCES games (id_game),
    FOREIGN KEY (fk_id_player) REFERENCES players (id_player)
);

-- DATOS INICIALES
-- Datos de ejemplo para la tabla 'teams'
INSERT INTO teams (id_team, name, badge, score)
VALUES (1, 'Equipo A', 'badge_a.png', 100),
       (2, 'Equipo B', 'badge_b.png', 90),
       (3, 'Equipo C', 'badge_c.png', 80),
       (4, 'Equipo D', 'badge_d.png', 70),
       (5, 'Equipo E', 'badge_e.png', 60),
       (6, 'Equipo F', 'badge_f.png', 50),
       (7, 'Equipo G', 'badge_g.png', 40),
       (8, 'Equipo H', 'badge_h.png', 30),
       (9, 'Equipo I', 'badge_i.png', 20),
       (10, 'Equipo J', 'badge_j.png', 10);

-- Datos de ejemplo para la tabla 'players'
INSERT INTO players (id_player, score, role, avatar_img, fk_id_team)
VALUES (1, 80, 'admin', 'avatar_1.png', 1),
       (2, 70, 'user', 'avatar_2.png', 1),
       (3, 60, 'user', 'avatar_3.png', 2),
       (4, 50, 'user', 'avatar_4.png', 2),
       (5, 40, 'admin', 'avatar_5.png', 3),
       (6, 30, 'user', 'avatar_6.png', 3),
       (7, 20, 'user', 'avatar_7.png', 4),
       (8, 10, 'user', 'avatar_8.png', 4),
       (9, 5, 'user', 'avatar_9.png', 5),
       (10, 2, 'user', 'avatar_10.png', 5);

-- Datos de ejemplo para la tabla 'games'
INSERT INTO games (id_game, max_tries, difficulty_game, description)
VALUES (1, 5, 'low', 'Juego 1 - Fácil'),
       (2, 4, 'mid', 'Juego 2 - Medio'),
       (3, 6, 'high', 'Juego 3 - Difícil'),
       (4, 3, 'low', 'Juego 4 - Fácil'),
       (5, 5, 'mid', 'Juego 5 - Medio'),
       (6, 4, 'high', 'Juego 6 - Difícil'),
       (7, 2, 'low', 'Juego 7 - Fácil'),
       (8, 6, 'mid', 'Juego 8 - Medio'),
       (9, 4, 'high', 'Juego 9 - Difícil'),
       (10, 3, 'low', 'Juego 10 - Fácil');

-- Datos de ejemplo para la tabla 'words'
INSERT INTO words (id_word, word)
VALUES (1, 'perro'),
       (2, 'gato'),
       (3, 'casa'),
       (4, 'sol'),
       (5, 'luz'),
       (6, 'agua'),
       (7, 'mesa'),
       (8, 'silla'),
       (9, 'amor'),
       (10, 'vida');

-- Datos de ejemplo para la tabla 'words_games'
INSERT INTO words_games (fk_id_game, fk_id_word, difficulty_word)
VALUES (1, 1, 'low'),
       (2, 2, 'mid'),
       (3, 3, 'high'),
       (4, 4, 'low'),
       (5, 5, 'mid'),
       (6, 6, 'high'),
       (7, 7, 'low'),
       (8, 8, 'mid'),
       (9, 9, 'high'),
       (10, 10, 'low');

-- Datos de ejemplo para la tabla 'matches'
INSERT INTO matches (id_match, word, score, n_try, date, fk_id_player, fk_id_game)
VALUES (1, 'perro', 50, 3, '2023-01-01 12:00:00', 1, 1),
       (2, 'gato', 40, 4, '2023-01-02 13:30:00', 2, 2),
       (3, 'casa', 30, 2, '2023-01-03 15:45:00', 3, 3),
       (4, 'sol', 20, 1, '2023-01-04 10:15:00', 4, 4),
       (5, 'luz', 10, 0, '2023-01-05 09:00:00', 5, 5),
       (6, 'agua', 5, 5, '2023-01-06 14:20:00', 6, 6),
       (7, 'mesa', 2, 2, '2023-01-07 16:30:00', 7, 7),
       (8, 'silla', 1, 3, '2023-01-08 11:45:00', 8, 8),
       (9, 'amor', 0, 4, '2023-01-09 08:00:00', 9, 9),
       (10, 'vida', 0, 6, '2023-01-10 17:00:00', 10, 10);