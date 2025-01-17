-- 2025년 01월 10일 SCIT 46기 Resume with Login Project 이력서 관리
USE scit;

-- 테이블 삭제
DROP TABLE IF EXISTS scit.test_user;
DROP TABLE IF EXISTS scit.test_resume;

-- 1) 회원 정보 테이블
CREATE TABLE scit.test_user
(	user_id    varchar(30)       
    , user_pwd varchar(200)     NOT NULL
    , user_nm  varchar(30)      NOT NULL
    , roles    varchar(30)      DEFAULT 'ROLE_USER' 
    , CONSTRAINT user_user_id_pk PRIMARY KEY(user_id)
    , CONSTRAINT user_roles_ck CHECK(roles IN ('ROLE_USER', 'ROLE_ADMIN'))
);

CREATE TABLE scit.test_resume
(
    resume_num 			int 			PRIMARY key AUTO_INCREMENT 
    , user_id			varchar(30)		NOT NULL
    , resume_title 		varchar(300)    NOT NULL 
    , resume_location 	char(1)			NOT null
    , resume_job	  	char(1)			NOT null
    , resume_intro		varchar(3000)	not null
    , resume_regdate	date		default (current_date)
    , resume_original_file varchar(300)
    , resume_saved_file 	varchar(300)   
    , CONSTRAINT user_user_id_fk FOREIGN KEY(user_id) REFERENCES scit.test_user(user_id)  
     
);


COMMIT;
SELECT * FROM scit.test_user;
SELECT * FROM scit.test_resume;


