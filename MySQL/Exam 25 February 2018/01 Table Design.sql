CREATE DATABASE buhtig;
USE buhtig;
CREATE TABLE users
(
    id       INT         NOT NULL PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(30) NOT NULL UNIQUE,
    password VARCHAR(30) NOT NULL,
    email    VARCHAR(50) NOT NULL
);
CREATE TABLE repositories
(
    id   INT         NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL
);
CREATE TABLE repositories_contributors
(
    repository_id  INT,
    contributor_id INT,
    CONSTRAINT fk_repositories_contributors_repositories
        FOREIGN KEY (repository_id)
            REFERENCES repositories (id),
    CONSTRAINT fk_repositories_contributors_users
        FOREIGN KEY (contributor_id)
            REFERENCES users (id)
);
CREATE TABLE issues
(
    id            INT          NOT NULL PRIMARY KEY AUTO_INCREMENT,
    title         VARCHAR(255) NOT NULL,
    issue_status  VARCHAR(6)   NOT NULL,
    repository_id INT          NOT NULL,
    assignee_id   INT          NOT NULL,
    CONSTRAINT fk_issues_repositories
        FOREIGN KEY (repository_id)
            REFERENCES repositories (id),
    CONSTRAINT fk_issues_uses
        FOREIGN KEY (assignee_id)
            REFERENCES users (id)
);
CREATE TABLE commits
(
    id             INT          NOT NULL PRIMARY KEY AUTO_INCREMENT,
    message        VARCHAR(255) NOT NULL,
    issue_id       INT,
    repository_id  INT          NOT NULL,
    contributor_id INT          NOT NULL,
    CONSTRAINT fk_commits_issues
        FOREIGN KEY (issue_id)
            REFERENCES issues (id),
    CONSTRAINT fk_commits_repositories
        FOREIGN KEY (repository_id)
            REFERENCES repositories (id),
    CONSTRAINT fk_commits_users
        FOREIGN KEY (contributor_id)
            REFERENCES users (id)
);
CREATE TABLE files
(
    id        INT            NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name      VARCHAR(100)   NOT NULL,
    size      DECIMAL(10, 2) NOT NULL,
    parent_id INT,
    commit_id INT            NOT NULL,
    CONSTRAINT fk_files_files
        FOREIGN KEY (parent_id)
            REFERENCES files (id),
    CONSTRAINT fk_files_commits
        FOREIGN KEY (commit_id)
            REFERENCES commits (id)
);