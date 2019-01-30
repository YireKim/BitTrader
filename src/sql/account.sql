SELECT * FROM account;

SELECT*FROM TAB;


--테이블 생성--
CREATE TABLE  account(
    accountnum VARCHAR2(30), 
    money NUMBER(10), 
    today VARCHAR2(30)
);

--테이블 기입--
INSERT INTO account(accountNum, money, today) \n"
					+ "VALUES('%s','%d','%s')

--테이블 삭제--
DROP TABLE account;

