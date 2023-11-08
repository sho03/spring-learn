-- init.sql
CREATE TABLE IF NOT EXISTS demo_db.user (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL UNIQUE
);
-- You can add more initialization SQL statements here.
