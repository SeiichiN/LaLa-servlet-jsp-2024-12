--
-- データベース名: two_tables
-- user: sa
-- pass: (no)

CREATE TABLE departments (
  id   INT    AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO departments (name) VALUES
('総務部'),
('営業部'),
('経理部'),
('開発部');


CREATE TABLE employees (
  id       INT     PRIMARY KEY AUTO_INCREMENT,
  name     VARCHAR(100) NOT NULL,
  gender   INT     NOT NULL,
  birthday DATE    NOT NULL,
  dept_id  INT     NOT NULL
);

ALTER TABLE employees
ADD
  CONSTRAINT fk_dept_id
  FOREIGN KEY (dept_id)
  REFERENCES departments (id);

INSERT INTO employees
  (name, gender, birthday, dept_id)
VALUES
  ('染谷 将太',   1, '1992-09-03', 2),
  ('二階堂 ふみ', 2, '1994-09-21', 3),
  ('渡辺 哲',     1, '1950-09-11', 1),
  ('窪塚 洋介',   1, '1979-09-07', 4),
  ('吉高 由里子', 2, '1988-09-22', 2);

--
-- 結合表
--

SELECT
  e.id       AS empId,
  e.name     AS empName,
  e.gender   AS gender,
  e.birthday AS birghday,
  d.id       AS deptId,
  d.name     AS deptName
FROM employees e
  INNER JOIN departments d
  ON e.dept_id = d.id
ORDER BY e.id ASC;


--
-- 初期化(AUTO_INCREMENT)
--

TRUNCATE TABLE employees;

ALTER TABLE employees ALTER COLUMN id INT AUTO_INCREMENT(1);
