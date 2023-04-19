set serveroutput on
declare
 x number:= 10;
begin
    dbms_output.put_line(x);
end;
//
begin
    <<inner>>
    declare
//   
declare
    empid number;
begin
    select empno into empid from emp where empno=7566;
    dbms_output.put_line(empid);
end;
//
variable v_ename varchar2;
begin
    select ename into :v_ename from emp where empno=7566;
    dbms_output.put_line(:v_ename);
end;
dbms_output.put_line(:v_ename);
//
begin
for i in 1..10 loop
    dbms_output.put_line('i: ' || i);
end loop;
end;
/
''custom type
declare
    type emprec is record(
        empid number,
        ename varchar2(64),
        esal number(7,2));
    er emprec;
begin
    select empno,ename,sal into er.empid,er.ename,er.esal from emp where empno=7566;
    dbms_output.put_line(er.empid || ',' || er.ename || ',' || er.esal);
end;
''
declare
    emprec emp%rowtype;
    cursor cur1 is select * from emp where deptno=10;
begin
    open cur1;
    loop
        fetch cur1 into emprec;
        exit when cur1%NOTFOUND;
        dbms_output.put_line(emprec.ename || ' ' || emprec.job || ' ' || emprec.sal);
    end loop;
    close cur1;
end;
//
--Acitity: To write a  Cursor to display the list of employees who are Working as a Managers or Analyst.
declare
    emprec emp%rowtype;
    cursor cur1 is select * from emp where job in ('MANAGER','ANALYST');
begin
    open cur1;
    loop
        fetch cur1 into emprec;
        exit when cur1%NOTFOUND;
        dbms_output.put_line(emprec.ename || ' ' || emprec.job || ' ' || emprec.sal);
    end loop;
    close cur1;
end;
--Acitity: Write PL/SQL code in Cursor to display employee names and salary
declare
    type emprec is record(        
        ename varchar2(64),
        esal number(7,2));
    er emprec;
    cursor cur1 is select ename,sal from emp;
begin
    open cur1;
    loop
        fetch cur1 into er;
        exit when cur1%NOTFOUND;
        dbms_output.put_line(er.ename || ' ' || er.esal);
    end loop;
    close cur1;
end;
--Acitity: Write PL/SQL code in Procedure to find the Reverse of the number
declare
    no1 varchar2(64):=&number1;
    len1 int;
    result1 varchar2(64);
begin
    len1:=length(no1);
    dbms_output.put_line(len1);
    
    for i in reverse 1..len1 loop
        result1 := result1 || substr(no1,i,1);
    end loop;
    
    dbms_output.put_line(result1);
end;
//
declare
    eno emp.empno%type;
    enam emp.ename%type;
    job emp.job%type;
    manager emp.mgr%type;
    hdate emp.hiredate%type;
    salry emp.sal%type;
    commn emp.comm%type;
    dno emp.deptno%type;
    cursor mycur is select * from emp where deptno=10;
begin
    if not mycur%ISOPEN then
    open mycur;
    end if;
    loop
    fetch mycur into eno,enam,job,manager,hdate,salry, commn,dno;
    exit when mycur%NOTFOUND;    
    dbms_output.put_line(eno || '     ' || enam || '    ' ||dno); 
    end loop;
    close mycur;
end;
--PL/SQL Cursor with Parameters
DECLARE
    r_emp emp%rowtype;
    CURSOR c_emp (low_sal NUMBER, high_sal NUMBER)
    IS
        SELECT *
        FROM emp
        WHERE sal BETWEEN low_sal AND high_sal order by sal;
BEGIN
    -- show mass products
    dbms_output.put_line('Employees...: ');
    OPEN c_emp(1000,2000);
    LOOP
        FETCH c_emp INTO r_emp;
        EXIT WHEN c_emp%notfound;
        dbms_output.put_line(r_emp.ename || ': ' ||r_emp.job || ': ' ||r_emp.sal);
    END LOOP;
    CLOSE c_emp;
END;
/
//
declare
emprec emp%rowtype;
ijob1 VARCHAR2(64):='&ijob10';
--ijob2 VARCHAR2:=&ijob20;
--CURSOR c_emp(job1 VARCHAR2, job2 VARCHAR2) IS select * from emp where job in(job1);
begin
dbms_output.put_line('ijob1 is :' || ijob1);
end;
/