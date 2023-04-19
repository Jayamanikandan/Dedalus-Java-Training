
create or replace procedure proc1
as
    phoneno varchar2(60);
begin    
    phoneno:='001-1234-567';
    DBMS_OUTPUT.PUT_LINE(phoneno);
end proc1;
/
execute proc1()
//
CREATE OR REPLACE PROCEDURE dept_salary_rpt (
    p_deptno       IN   NUMBER,
    p_base_annual  OUT  NUMBER
)
IS
    todays_date     DATE;
    rpt_title       VARCHAR2(60);
    base_sal        INTEGER;
    base_comm_rate  NUMBER;
BEGIN
    todays_date := SYSDATE;
    rpt_title := 'Report For Department # ' || p_deptno || ' on ' || todays_date;
    base_sal := 35525;
    base_comm_rate := 1.33333;
    p_base_annual := ROUND(base_sal * base_comm_rate, 2);

    DBMS_OUTPUT.PUT_LINE(rpt_title);
    DBMS_OUTPUT.PUT_LINE('Base Annual Salary: ' || p_base_annual);
END dept_salary_rpt;
/
variable n_annual_base number;
execute dept_salary_rpt(10,n_annual_base);
print n_annual_base;
//
''** Define procedure within a procedure
create sequence mph210seq
  start with 1
  increment by 1
  nocycle
  nocache;

create table mytracktime(tno number(5),trackedon date);
select * from mytracktime;

create or replace procedure pro14(num in number,enam out varchar2)
as
   procedure tracktime is                                 -- defining a procedure
   begin
       insert into mytracktime values(mph210seq.nextval,sysdate);
   end;
begin
   select ename into  enam from emp where empno=num;
   tracktime;
   dbms_output.put_line(' Ename is :' || enam);
end pro14;
/
variable nam varchar2(20);
execute pro14(7369,:nam);
print nam;
//
''** calling a procedure from a procedure
create procedure pro1(num in number)
as
begin
     dbms_output.put_line('My Lucky Number :' || num);
end pro1;
/
create or replace procedure pro2(num in number,enam out varchar2)
as
begin
   select ename into  enam from emp where empno=num;
   dbms_output.put_line(' Ename is :' || enam);
   pro1(100);     -- invoking a procedure
   
exception
    when NO_DATA_FOUND then
         dbms_output.put_line('Error from Procedure . Employee Number Does Not Exist :( ');
end pro2;
/
variable ename varchar2(64);
execute pro2(7499,:ename);
print ename;
//**
''** function
create or replace function tax(val in number)
return number
is
begin
    return (val*0.10);
end;
/
select ename,tax(sal) from emp;
//
create or replace function empfunc(eno in number)
return number
is
vsal emp.sal%type;
begin
     select sal into vsal from emp where empno=eno;
     return  vsal;  
end;
/
select empfunc(7521) from emp;
select empfunc(7521) from dual;
//
''**Package
''Package specification
create or replace package emppack
 as
      procedure pro12(num in number,enam out varchar2); 
      function tax(val in number) return number;
 end;
 /
 create or replace package body emppack
 as
    procedure pro12(num in number,enam out varchar2) is
    begin
     select ename into  enam from emp where empno=num;
      dbms_output.put_line(' Ename is :' || enam);
    end pro12;
    
    function tax(val in number) return number
    is
    begin
          return (val*0.10);
    end tax;
end emppack;
 /
variable nam varchar2(20);
execute emppack.pro12(7369,:nam);
print nam;
show errors;

desc emppack

drop package emppack;
''after dropping package, could not call proc in package.
''getting error 'identifier 'EMPPACK.PRO12' must be declared'

drop package body emppack;
''after dropping package body, package specification exists (not dropped)
//
/*
assginment:
Create a program to retrieve the number of years of service for a specific employee.
a. Create a stored function called GET_SERVICE_YRS to retrieve the total number of years
of service for a specific employee.
The function should accept the employee ID as a parameter and return the number of years
of service. Add error handling to account for an invalid employee ID.
*/
create or replace procedure GET_SERVICE_YRS(emp_no number,serviceinyrs out number)
as   
begin
     select floor(months_between(sysdate,hiredate) /12) into serviceinyrs  from emp where empno=emp_no; 
end GET_SERVICE_YRS;

variable serviceinyrs number;
execute GET_SERVICE_YRS(7566,:serviceinyrs);
print serviceinyrs;
//
/*
assginment:
b. Invoke the function. You can use the following data:
EXECUTE DBMS_OUTPUT.PUT_LINE(get_service_yrs(999))
Hint: The above statement should produce an error message because there is no employee
with employee ID 999.
*/
create or replace function GET_SERVICE_YRS(emp_no number)
return number
as   
begin    
     select floor(months_between(sysdate,hiredate) /12) into serviceinyrs from emp where empno=emp_no;
     return serviceinyrs;
     EXCEPTION
     WHEN NO_DATA_FOUND THEN
        dbms_output.put_line('there is no employee with employee ID '|| emp_no);     
end GET_SERVICE_YRS;

variable serviceinyrs number;
execute GET_SERVICE_YRS(7566,:serviceinyrs);
print serviceinyrs;
//
variable serviceinyrs number;
execute GET_SERVICE_YRS(999,:serviceinyrs);
print serviceinyrs;
//
/*
assginment:
Make these functions available in a package name EMPPACK
*/
create or replace package emppack
 as      
      function GET_SERVICE_YRS(emp_no in number) return number;
 end;
 /
 create or replace package body emppack
 as
    function GET_SERVICE_YRS(emp_no number)
    return number
    is
        serviceinyrs number;
    begin    
     select floor(months_between(sysdate,hiredate) /12) into serviceinyrs from emp where empno=emp_no;
     return serviceinyrs;
     EXCEPTION
     WHEN NO_DATA_FOUND THEN
        dbms_output.put_line('there is no employee with employee ID '|| emp_no);     
    end GET_SERVICE_YRS;
end emppack;
//
select emppack.GET_SERVICE_YRS(7566) from dual
//

/*
assginment:
Create a stored procedure called UPD_SAL to update the  salaries
for a specific job in the EMP table.
Pass three parameters to the procedure: the job , a new minimum salary, and a new
maximum salary for the job. Add exception handling to account for an invalid job name in the
EMP table. Also, raise an exception if the maximum salary supplied is less than the
minimum salary.
*/
create or replace procedure UPD_SAL(grad salgrade.grade%type,
                minsal salgrade.losal%type, 
                maxsal salgrade.hisal%type)   
as   
   Grade_not_found exception;
    PRAGMA EXCEPTION_INIT (Grade_not_found, -20000);
begin
    
    
     update salgrade set losal=minsal, hisal=maxsal where grade=grad;
     if sql%rowcount = 0 then
        raise Grade_not_found;
     end if;     
end UPD_SAL;

execute UPD_SAL(123,1000,2000);
//
''** triggers
CREATE OR REPLACE TRIGGER trig1
before
    insert or update OF SALGRADE OR 
    delete on emp
begin
    if inserting then
        dbms_output.put_line("You are inserting!");
    elsif updating then
        dbms_output.put_line("You are updating!");
    elsif deleting then
        dbms_output.put_line("You are deleting emp!");
    else
        dbms_output.put_line("You are doing something else!!");
    end if;
end;
/
CREATE OR REPLACE TRIGGER t
   AFTER UPDATE OR INSERT  
   ON emp    
BEGIN
  CASE
    WHEN INSERTING THEN
      DBMS_OUTPUT.PUT_LINE('Inserting');
    WHEN UPDATING('salary') THEN
      DBMS_OUTPUT.PUT_LINE('Updating salary');
    WHEN UPDATING('department_id') THEN
      DBMS_OUTPUT.PUT_LINE('Updating department ID');
    WHEN DELETING THEN
      DBMS_OUTPUT.PUT_LINE('Deleting');
  END CASE;
END;
/
create table hr.session_log(user_id varchar2(20), log_date timestamp, action varchar2(30));
drop table session_log;

create or replace trigger logon_trigger
after logon on schema
begin
    insert into hr.session_log values(user,current_timestamp,'Log On');
end;

create or replace trigger logoff_trigger
before logon on schema
begin
    insert into hr.session_log values(user,current_timestamp,'Log Off');
end;
