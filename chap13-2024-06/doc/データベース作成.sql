-- exampleデータベース
--
-- employeeテーブル p497
--

CREATE TABLE employees (
  id CHAR(6) PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  age INT NOT NULL
);

INSERT INTO employees
  (id, name, age)
VALUES
  ('EMP001', '湊 雄輔', 23),
  ('EMP002', '綾部 みゆき', 22);
  
  