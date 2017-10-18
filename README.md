#spring mybatis search service at oracle DBMS with test case

error case / caution

1. mapper를 잘못연결할경우
2. Criteria 에서 minSalary, maxSalary에 대하여 primitive type의 getter일경우 null임을 파악할 수 없는 문제가 발생한다.
3. Date를 java.util.Date class를 사용하였기 때문에 Date를 test 할 때 SimpleDateFormat.parse를 사용함
