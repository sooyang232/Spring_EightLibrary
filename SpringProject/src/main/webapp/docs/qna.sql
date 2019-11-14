create table qna(num int not null,
                title varchar(100) not null,
                content varchar(1000) not null,
                userID varchar(20) not null,
                view int,
                date date,
                reply int,
                step int,
                PRIMARY KEY (num));
                
SELECT * FROM qna;

insert into qna values(1,"qna test","qna test","sooyang",13,"2019-10-19",1,0);
insert into qna values(2,"qna222","qna 222","soo",12,"2019-10-24",2,0);
insert into qna values(3,"qna222","qnb2a 322","관리자",16,"2019-10-25",2,1);