-- API-WORDS
DROP TABLE IF EXISTS words_games;
DROP TABLE IF EXISTS words;
DROP TABLE IF EXISTS players;
DROP TABLE IF EXISTS matches;
DROP TABLE IF EXISTS teams;
DROP TABLE IF EXISTS games;

CREATE TABLE teams
(
    id_team BIGINT AUTO_INCREMENT NOT NULL,
    name    VARCHAR(50),
    badge   VARCHAR(50),
    score   INT,
    PRIMARY KEY (id_team)
);


CREATE TABLE players
(
    id_player  BIGINT AUTO_INCREMENT NOT NULL,
    score      INT,
    role       ENUM ('admin', 'user'),
    name       VARCHAR(20),
    avatar_img VARCHAR(150),
    fk_id_team BIGINT                NOT NULL,
    PRIMARY KEY (id_player),
    FOREIGN KEY (fk_id_team) REFERENCES teams (id_team)
);


CREATE TABLE games
(
    id_game         BIGINT AUTO_INCREMENT NOT NULL,
    max_tries       INT,
    difficulty_game ENUM ('low', 'mid', 'high'),
    description     VARCHAR(250),
    PRIMARY KEY (id_game),
    CHECK (max_tries BETWEEN 0 AND 6)
);


CREATE TABLE words
(
    id_word BIGINT AUTO_INCREMENT NOT NULL,
    word    VARCHAR(45),
    PRIMARY KEY (id_word)
);


CREATE TABLE words_games
(
    fk_id_game      BIGINT NOT NULL,
    fk_id_word      BIGINT NOT NULL,
    difficulty_word ENUM ('low', 'mid', 'high'),
    PRIMARY KEY (fk_id_game, fk_id_word),
    FOREIGN KEY (fk_id_game) REFERENCES games (id_game),
    FOREIGN KEY (fk_id_word) REFERENCES words (id_word)
);

-- ALTER TABLE words_games
-- ADD CONSTRAINT "FKlh67w4v1y7yawjce4p8ocjpyp"
--     FOREIGN KEY (fk_id_word)
-- REFERENCES words (id_word);


CREATE TABLE matches
(
    id_match     BIGINT AUTO_INCREMENT NOT NULL,
    word         VARCHAR(45),
    score        INT,
    n_try        INT,
    date         DATE,
    fk_id_player BIGINT                NOT NULL,
    fk_id_game   BIGINT                NOT NULL,
    PRIMARY KEY (id_match),
    CHECK (n_try BETWEEN 0 AND 6),
    FOREIGN KEY (fk_id_game) REFERENCES games (id_game),
    FOREIGN KEY (fk_id_player) REFERENCES players (id_player)
);

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
INSERT INTO players (id_player, score, role, name, avatar_img, fk_id_team)
VALUES (1, 80, 'admin', 'pepe', 'avatar_1.png', 1),
       (2, 70, 'user', 'lala', 'avatar_2.png', 1),
       (3, 60, 'user', 'zzzz', 'avatar_3.png', 2),
       (4, 50, 'user', 'sintax', 'avatar_4.png', 2),
       (5, 40, 'admin', 'oper', 'avatar_5.png', 3),
       (6, 30, 'user', 'carlitos', 'avatar_6.png', 3),
       (7, 20, 'user', 'beyonce', 'avatar_7.png', 4),
       (8, 10, 'user', 'richard', 'avatar_8.png', 4),
       (9, 5, 'user', 'carey', 'avatar_9.png', 5),
       (10, 2, 'user', 'linux', 'avr_10.png', 5);

-- Datos de ejemplo para la tabla 'games'
INSERT INTO games (id_game, max_tries, difficulty_game, description)
VALUES (1, 5, 'high', 'wordle'),
       (2, 4, 'mid', 'hangman');

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
       (1, 3, 'high'),
       (2, 4, 'low'),
       (1, 5, 'mid'),
       (2, 6, 'high'),
       (2, 7, 'low'),
       (2, 8, 'mid'),
       (2, 9, 'high'),
       (1, 10, 'low');

-- Datos de ejemplo para la tabla 'matches'
INSERT INTO matches (id_match, word, score, n_try, date, fk_id_player, fk_id_game)
VALUES (1, 'perro', 50, 3, '2023-01-01 12:00:00', 1, 1),
       (2, 'gato', 40, 4, '2023-01-02 13:30:00', 2, 2),
       (3, 'casa', 30, 2, '2023-01-03 15:45:00', 3, 1),
       (4, 'sol', 20, 1, '2023-01-04 10:15:00', 4, 2),
       (5, 'luz', 10, 0, '2023-01-05 09:00:00', 5, 2),
       (6, 'agua', 5, 5, '2023-01-06 14:20:00', 6, 2),
       (7, 'mesa', 2, 2, '2023-01-07 16:30:00', 7, 1),
       (8, 'silla', 1, 3, '2023-01-08 11:45:00', 8, 2),
       (9, 'amor', 0, 4, '2023-01-09 08:00:00', 9, 1),
       (10, 'vida', 0, 6, '2023-01-10 17:00:00', 10, 1);


