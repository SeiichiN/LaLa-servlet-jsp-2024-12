--
-- データベース: date_test
--

-- person テーブル

CREATE TABLE person (
  id INT AUTO_INCREMENT,
  name VARCHAR(100),
  birthday DATE,
  PRIMARY KEY (id)
);

INSERT INTO person
  (name, birthday)
VALUES
  ('染谷 将太',    '1992-09-03'),
  ('二階堂 ふみ',  '1994-09-21');
  

-- 修正時刻: Tue 2025/01/14 07:07:06
