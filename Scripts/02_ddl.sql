/* 상품 */
CREATE TABLE product (
	pseq NUMBER(5) NOT NULL PRIMARY KEY, /* 상품번호 */
	name VARCHAR2(100) DEFAULT '0', /* 상품명 */
	kind CHAR(1), /* 상품종류 */
	price1 NUMBER(7) DEFAULT '0', /* 원가 */
	price2 NUMBER(7) DEFAULT '0', /* 판매가 */
	price3 NUMBER(7) DEFAULT '0', /* 수익 */
	content VARCHAR2(1000) DEFAULT NULL, /* 상품내용 */
	image VARCHAR2(50) DEFAULT 'default.jpg', /* 상품이미지 */
	useyn CHAR(1) DEFAULT 'y', /* 상품삭제여부 */
	bestyn CHAR(1) DEFAULT 'n', /* 베스트상품여부 */
	indate DATE DEFAULT SYSDATE /* 등록일 */
);

/* 상품 시퀀스 생성 */
CREATE SEQUENCE PRODUCT_SEQ
 START WITH 1
 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER TRI_PRODUCT_PSEQ_SEQ
BEFORE INSERT ON PRODUCT
FOR EACH ROW
BEGIN
	IF inserting AND :NEW.PSEQ IS NULL THEN
		SELECT PRODUCT_SEQ.NEXTVAL INTO :NEW.PSEQ FROM DUAL;
	END IF;
END;

DROP TRIGGER TRI_PRODUCT_PSEQ_SEQ;
DROP SEQUENCE PRODUCT_SEQ;

/* 주문 */
CREATE TABLE orders (
	oseq NUMBER(10) NOT NULL PRIMARY KEY, /* 주문번호 */
	id VARCHAR2(20), /* 주문자아이디 */
	indate DATE DEFAULT SYSDATE /* 주문일 */
);

/* 주문 시퀀스 생성 */
CREATE SEQUENCE ORDERS_SEQ
 START WITH 1
 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER TRI_PRODUCT_OSEQ_SEQ
BEFORE INSERT ON ORDERS
FOR EACH ROW
BEGIN
	IF inserting AND :NEW.OSEQ IS NULL THEN
		SELECT ORDERS_SEQ.NEXTVAL INTO :NEW.OSEQ FROM DUAL;
	END IF;
END;

DROP TRIGGER TRI_PRODUCT_PSEQ_SEQ;
DROP SEQUENCE ORDERS_SEQ;

/* 주문상세 */
CREATE TABLE order_detail (
	odseq NUMBER(10) NOT NULL PRIMARY KEY, /* 주문상세번호 */
	oseq NUMBER(10), /* 주문번호 */
	pseq NUMBER(5), /* 상품번호 */
	quantity NUMBER(5), /* 주문수량 */
	result CHAR(1) DEFAULT '1' /* 처리완료여부 */
);

/* 장바구니 */
CREATE TABLE cart (
	cseq NUMBER(10) NOT NULL PRIMARY KEY, /* 장바구니번호 */
	id VARCHAR2(20), /* 회원아이디 */
	pseq NUMBER(5), /* 상품번호 */
	quantity NUMBER(5) DEFAULT '1', /* 수량 */
	result CHAR(1) DEFAULT '1', /* 처리완료여부 */
	indate DATE DEFAULT SYSDATE /* 등록일 */
);

/* 회원 */
CREATE TABLE member (
	id VARCHAR2(20) NOT NULL PRIMARY KEY, /* 회원아이디 */
	pwd VARCHAR2(20), /* 회원암호 */
	name VARCHAR2(40), /* 회원이름 */
	email VARCHAR2(40), /* 회원이메일 */
	zip_num VARCHAR2(7), /* 우편번호 */
	address VARCHAR2(100), /* 주소 */
	phone VARCHAR2(20), /* 전화번호 */
	useyn CHAR(1) DEFAULT 'y', /* 탈퇴여부 */
	indate DATE DEFAULT SYSDATE /* 가입일 */
);

/* QNA 게시판 */
CREATE TABLE qna (
	qseq NUMBER(5) NOT NULL PRIMARY KEY, /* 글번호 */
	subject VARCHAR2(30), /* 제목 */
	content VARCHAR2(1000), /* 문의내용 */
	reply VARCHAR2(1000), /* 답변내용 */
	id VARCHAR2(20), /* 작성자아이디 */
	rep CHAR(1) DEFAULT '1', /* 답변유무 */
	indate DATE DEFAULT SYSDATE /* 작성일 */
);

/* QNA 게시판 시퀀스 생성 */
CREATE SEQUENCE QNA_SEQ
 START WITH 1
 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER TRI_QNA_QSEQ_SEQ
BEFORE INSERT ON MEMBER
FOR EACH ROW
BEGIN
	IF inserting AND :NEW.QSEQ IS NULL THEN
		SELECT QNA_SEQ.NEXTVAL INTO :NEW.QSEQ FROM DUAL;
	END IF;
END;

DROP TRIGGER TRI_QNA_QSEQ_SEQ;
DROP SEQUENCE QNA_SEQ;

/* 주소 */
CREATE TABLE address (
	zip_num VARCHAR2(7), /* 우편번호 */
	sido VARCHAR2(30), /* 시도 */
	gugun VARCHAR2(30), /* 구군 */
	dong VARCHAR2(100), /* 동 */
	bunji VARCHAR2(30), /* 번지 */
	zip_code VARCHAR2(30) /* 우편코드 */
);

/* 관리자 */
CREATE TABLE worker (
	id VARCHAR2(20) NOT NULL PRIMARY KEY, /* 관리자아이디 */
	pwd VARCHAR2(20), /* 관리자암호 */
	name VARCHAR2(40), /* 관리자이름 */
	phone VARCHAR2(20) /* 전화번호 */
);

/* 이 후는 외래키 */
ALTER TABLE orders
	ADD
		CONSTRAINT FK_member_TO_orders
		FOREIGN KEY (
			id
		)
		REFERENCES member (
			id
		);

ALTER TABLE order_detail
	ADD
		CONSTRAINT FK_orders_TO_order_detail
		FOREIGN KEY (
			oseq
		)
		REFERENCES orders (
			oseq
		);

ALTER TABLE order_detail
	ADD
		CONSTRAINT FK_product_TO_order_detail
		FOREIGN KEY (
			pseq
		)
		REFERENCES product (
			pseq
		);

ALTER TABLE cart
	ADD
		CONSTRAINT FK_product_TO_cart
		FOREIGN KEY (
			pseq
		)
		REFERENCES product (
			pseq
		);

ALTER TABLE cart
	ADD
		CONSTRAINT FK_member_TO_cart
		FOREIGN KEY (
			id
		)
		REFERENCES member (
			id
		);

ALTER TABLE qna
	ADD
		CONSTRAINT FK_member_TO_qna
		FOREIGN KEY (
			id
		)
		REFERENCES member (
			id
		);
		
