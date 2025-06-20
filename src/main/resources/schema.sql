DROP TABLE IF EXISTS posts;

CREATE TABLE posts (
    slug varchar(255) NOT NULL,
    created_at char(10) NOT NULL,
    html text NOT NULL,
    PRIMARY KEY (slug)
)