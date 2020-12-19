drop table Employee;
create table Employee
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    name       varchar(20),
    department varchar(20)
);

create table Employee_Audit
(
    audit_id         INT AUTO_INCREMENT PRIMARY KEY,
    id          INT ,
    name       varchar(20),
    department varchar(20)
);


insert into Employee (name,department) values ('Rajesh', 'IT');
insert into Employee (name,department) values ('Kumar', 'Admin');
