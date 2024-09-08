PRAGMA foreign_keys = ON;

CREATE TABLE IF NOT EXISTS beneficiary (
  user_id INTEGER NOT NULL,
  payment_id INTEGER NOT NULL,
  amount REAL NOT NULL,
  status TEXT NOT NULL CHECK(status IN ('settled', 'unsettled')),
  PRIMARY KEY (user_id, payment_id),
  FOREIGN KEY (payment_id) REFERENCES payment (id) ON UPDATE CASCADE ON DELETE RESTRICT,
  FOREIGN KEY (user_id) REFERENCES user (id) ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE IF NOT EXISTS payer (
  user_id INTEGER NOT NULL,
  payment_id INTEGER NOT NULL,
  amount REAL NOT NULL,
  PRIMARY KEY (user_id, payment_id),
  FOREIGN KEY (payment_id) REFERENCES payment (id) ON UPDATE CASCADE ON DELETE RESTRICT,
  FOREIGN KEY (user_id) REFERENCES user (id) ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE IF NOT EXISTS payment (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  amount REAL NOT NULL,
  time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  title TEXT NOT NULL,
  status TEXT NOT NULL CHECK(status IN ('settled', 'unsettled'))
);

CREATE TABLE IF NOT EXISTS repayment (
  payment_id INTEGER NOT NULL,
  payer_user_id INTEGER NOT NULL,
  beneficiary_user_id INTEGER NOT NULL,
  time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  amount REAL NOT NULL,
  PRIMARY KEY (payment_id, payer_user_id, beneficiary_user_id, time),
  FOREIGN KEY (payment_id, payer_user_id)
    REFERENCES payer (payment_id, user_id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  FOREIGN KEY (payment_id, beneficiary_user_id)
    REFERENCES beneficiary (payment_id, user_id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS user (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  name TEXT NOT NULL,
  joining_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  email TEXT,
  password TEXT
);
