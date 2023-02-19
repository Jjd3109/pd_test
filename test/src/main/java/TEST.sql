

drop table test.login_info;
drop table test.superhere_info;


select * from test.login_info;
select * from TEST.superhere_info;


CREATE TABLE TEST.superhere_info(
	ID INT not null auto_increment,
	USER_ID VARCHAR(30) not null,
	FIRST_NM VARCHAR(20) not null,
	LAST_NM VARCHAR(20) not null,
	GENDER_NM VARCHAR(1) not null,
	MOBILE_TYPE VARCHAR(10) not null,
	primary key(ID, USER_ID)
);

create table TEST.login_info(
	ID INT not null auto_increment,
	USER_ID INT not null,
	TOKEN VARCHAR(300) not null,
	LAST_AC_DT BIGINT not null,
	primary KEY(ID),
	foreign key (USER_ID) references superhere_info(ID) 
);

select si.USER_ID, li.LAST_AC_DT, li.TOKEN, si.MOBILE_TYPE 
from test.superhere_info si
join test.login_info li 
on si.ID = li.USER_ID
where si.USER_ID  = 'jongdoo2001'
ORDER BY li.id desc limit 1;
