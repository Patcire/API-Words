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
