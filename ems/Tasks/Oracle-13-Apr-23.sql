-- No.10

27. List the emps whose Salaries are less than 3500.
select * from emp where sal<3500

 

28. List the emps Empno, Ename, Sal of all emp joined before 1 Apr 1981.
select empno, ename, sal from emp where hiredate<'01-04-1981'

 

29. List the emps whose exp is more than 10 years.
select * from emp where MONTHS_BETWEEN(sysdate,hiredate)>120