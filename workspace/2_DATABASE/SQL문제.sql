-- 4. DDL
-- 1) 
CREATE TABLE TB_CATEGORY(
    NAME VARCHAR2(10),
    USE_YN CHAR(1) DEFAULT 'Y'
);

-- 2)
CREATE TABLE TB_CLASS_TYPE(
    NO VARCHAR2(5) PRIMARY KEY,
    NAME VARCHAR2(10)
);

-- 3)
ALTER TABLE TB_CATEGORY
ADD CONSTRAINT TB_CATEGORY_NAME_PK PRIMARY KEY(NAME);

-- 4)
ALTER TABLE TB_CLASS_TYPE
MODIFY NAME NOT NULL;

-- 5)
ALTER TABLE TB_CLASS_TYPE
MODIFY NO VARCHAR2(10)
MODIFY NAME VARCHAR2(20);

ALTER TABLE TB_CATEGORY
MODIFY NAME VARCHAR2(20);

-- 6)
ALTER TABLE TB_CATEGORY
RENAME COLUMN NAME TO CATEGORY_NAME;

ALTER TABLE TB_CLASS_TYPE
RENAME COLUMN NO TO CLASS_TYPE_NO;

ALTER TABLE TB_CLASS_TYPE
RENAME COLUMN NAME TO CLASS_TYPE_NAME;

-- 7)
ALTER TABLE TB_CATEGORY
RENAME COLUMN CATEGORY_NAME TO PK_CATEGORY_NAME;

ALTER TABLE TB_CLASS_TYPE
RENAME COLUMN CLASS_TYPE_NO TO PK_CLASS_TYPE_NO;

-- 8)
INSERT INTO TB_CATEGORY VALUES('공학','Y');
INSERT INTO TB_CATEGORY VALUES('자연과학','Y');
INSERT INTO TB_CATEGORY VALUES('의학','Y');
INSERT INTO TB_CATEGORY VALUES('예체능','Y');
INSERT INTO TB_CATEGORY VALUES('인문사회','Y');
COMMIT;

-- 9)
ALTER TABLE TB_DEPARTMENT
ADD CONSTRAINT FK_DEPARTMENT_CATEGORY FOREIGN KEY(CATEGORY) REFERENCES TB_CATEGORY(PK_CATEGORY_NAME);

-- 10)
GRANT CREATE VIEW TO WORKBOOK;

CREATE OR REPLACE VIEW VW_학생일반정보(학번, 학생이름, 주소)
AS SELECT STUDENT_NO, STUDENT_NAME, STUDENT_ADDRESS
   FROM TB_STUDENT;

SELECT * FROM VW_학생일반정보;

-- 11)
CREATE OR REPLACE VIEW VW_지도면담(학생이름, 학과이름, 지도교수이름)
AS SELECT STUDENT_NAME, DEPARTMENT_NAME, NVL(PROFESSOR_NAME, '지도교수 없음')
   FROM TB_STUDENT
        LEFT JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
        LEFT JOIN TB_PROFESSOR ON(COACH_PROFESSOR_NO = PROFESSOR_NO)
ORDER BY 2;

SELECT * FROM VW_지도면담;

-- 12)
CREATE OR REPLACE VIEW VIEW_학과별학생수(DEPARTMENT_NAME, STUDENT_COUNT)
AS SELECT DEPARTMENT_NAME, COUNT(*)
   FROM TB_DEPARTMENT
        JOIN TB_STUDENT USING(DEPARTMENT_NO)
   GROUP BY DEPARTMENT_NAME;

SELECT * FROM VIEW_학과별학생수;

COMMIT;
-- 13)
SELECT * FROM VW_학생일반정보
WHERE 학번 = 'A213046'; -- 서가람

UPDATE VW_학생일반정보
SET 학생이름 = '박신우'
WHERE 학번 = 'A213046';

-- 14)
CREATE OR REPLACE VIEW VW_학생일반정보(학번, 학생이름, 주소)
AS SELECT STUDENT_NO, STUDENT_NAME, STUDENT_ADDRESS
   FROM TB_STUDENT
   WITH READ ONLY;
   
-- 15)
-- 문제에서 원한 것
SELECT 과목번호, 과목이름, "누적수강생수(명)"
FROM (SELECT CLASS_NO 과목번호, CLASS_NAME 과목이름, COUNT(*) "누적수강생수(명)"
      FROM TB_GRADE
           JOIN TB_CLASS USING(CLASS_NO)
      WHERE TERM_NO LIKE '2009%'
            OR TERM_NO LIKE '2008%'
            OR TERM_NO LIKE '2007%'
      GROUP BY CLASS_NO, CLASS_NAME
      ORDER BY 3 DESC)
WHERE ROWNUM <= 3;

-- 문제에 나온 결과와 똑같은 결과 만들기
SELECT 과목번호, 과목이름, "누적수강생수(명)"
FROM (SELECT CLASS_NO 과목번호, CLASS_NAME 과목이름, COUNT(*) "누적수강생수(명)"
      FROM TB_GRADE
           JOIN TB_CLASS USING(CLASS_NO)
      WHERE TERM_NO LIKE '2009%'
            OR TERM_NO LIKE '2008%'
            OR TERM_NO LIKE '2007%'
            OR TERM_NO LIKE '2006%'
            OR TERM_NO LIKE '2005%'
      GROUP BY CLASS_NO, CLASS_NAME
      ORDER BY 3 DESC)
WHERE ROWNUM <= 3;

-- 5. DML
-- 1)
INSERT INTO TB_CLASS_TYPE VALUES('01','전공필수');
INSERT INTO TB_CLASS_TYPE VALUES('02','전공선택');
INSERT INTO TB_CLASS_TYPE VALUES('03','교양필수');
INSERT INTO TB_CLASS_TYPE VALUES('04','교양선택');
INSERT INTO TB_CLASS_TYPE VALUES('05','논문지도');

-- 2)
CREATE TABLE TB_학생일반정보(학번, 학생이름, 주소)
AS SELECT STUDENT_NO, STUDENT_NAME, STUDENT_ADDRESS
    FROM TB_STUDENT;

SELECT * FROM TB_학생일반정보;

-- 3)
CREATE TABLE TB_국어국문학과(학번, 학생이름, 출생년도, 교수이름)
AS SELECT STUDENT_NO, STUDENT_NAME, TO_CHAR(TO_DATE(SUBSTR(STUDENT_SSN, 1, 6)), 'YYYY/MM/DD'), NVL(PROFESSOR_NAME, '지도교수 없음')
   FROM TB_STUDENT S
        LEFT JOIN TB_PROFESSOR ON (PROFESSOR_NO = COACH_PROFESSOR_NO)
        LEFT JOIN TB_DEPARTMENT D ON(D.DEPARTMENT_NO = S.DEPARTMENT_NO)
   WHERE DEPARTMENT_NAME = '국어국문학과';

SELECT * FROM TB_국어국문학과;

-- 4)
UPDATE TB_DEPARTMENT
SET CAPACITY = ROUND(CAPACITY * 1.1);

-- 5)
UPDATE TB_STUDENT
SET STUDENT_ADDRESS = '서울시 종로구 숭인동 181-21'
WHERE STUDENT_NO = 'A413042';

-- 6)
UPDATE TB_STUDENT
SET STUDENT_SSN = SUBSTR(STUDENT_SSN, 1, 6);

-- 7)
SELECT STUDENT_NAME, DEPARTMENT_NAME, POINT, TERM_NO, CLASS_NAME
FROM TB_STUDENT
     JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
     JOIN TB_GRADE USING(STUDENT_NO)
     JOIN TB_CLASS USING(CLASS_NO)
WHERE STUDENT_NAME = '김명훈'
      AND DEPARTMENT_NAME = '의학과'
      AND TERM_NO LIKE '2005%'
      AND CLASS_NAME = '피부생리학'; -- 1.5

UPDATE TB_GRADE
SET POINT = 3.5
WHERE STUDENT_NO = (SELECT STUDENT_NO
                    FROM TB_STUDENT
                         JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
                    WHERE STUDENT_NAME = '김명훈'
                          AND DEPARTMENT_NAME = '의학과')
      AND TERM_NO LIKE '2005%'
      AND CLASS_NO = (SELECT CLASS_NO 
                      FROM TB_CLASS
                      WHERE CLASS_NAME = '피부생리학');

COMMIT;
-- 8)
DELETE FROM TB_GRADE
WHERE STUDENT_NO IN (SELECT STUDENT_NO
                    FROM TB_STUDENT
                    WHERE ABSENCE_YN = 'Y');