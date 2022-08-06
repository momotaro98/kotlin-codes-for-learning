USE dev_db;

CREATE TABLE IF NOT EXISTS customers (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(128),
  `email` VARCHAR(1024),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARACTER SET=utf8mb4;