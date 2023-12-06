-- API-WORDS

CREATE TABLE teams
(
    id    INT NOT NULL,
    name  VARCHAR(50),
    badge VARCHAR(50),
    score INT,
    PRIMARY KEY (id)
);

CREATE TABLE players
(
    id         INT NOT NULL,
    score      INT,
    role       ENUM ('admin', 'user'),
    avatar_img VARCHAR(150),
    team_id    INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (team_id) REFERENCES teams (id)
);

CREATE TABLE games
(
    id              INT NOT NULL,
    max_tries       INT,
    difficulty_game ENUM ('low', 'mid', 'high'),
    description     VARCHAR(250),
    PRIMARY KEY (id),
    CHECK (max_tries BETWEEN 0 AND 6)
);

CREATE TABLE words
(
    id INT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE words_games
(
    game_id         INT NOT NULL,
    word_id         INT NOT NULL,
    difficulty_word INT,
    PRIMARY KEY (game_id, word_id),
    CHECK (difficulty_word BETWEEN 1 AND 3),
    FOREIGN KEY (game_id) REFERENCES games (id),
    FOREIGN KEY (word_id) REFERENCES words (id)
);

CREATE TABLE matches
(
    id        INT NOT NULL,
    word      VARCHAR(5),
    score     INT,
    n_try     INT,
    datetime  DATETIME,
    player_id INT NOT NULL,
    game_id   INT NOT NULL,
    PRIMARY KEY (id),
    CHECK (n_try BETWEEN 0 AND 6),
    FOREIGN KEY (game_id) REFERENCES games (id),
    FOREIGN KEY (player_id) REFERENCES players (id)
);
