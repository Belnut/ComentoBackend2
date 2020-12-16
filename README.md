# Comento 실습과제

## 3주차 : sql문 실습 및 Restapi 구현

### 1. API 구축을 위한 SQL 작성
- 월별 접속자 수 (OK)
- 일자별 접속자 수 (OK)
- 평균 하루 로그인 수 (OK)
- 휴일을 제외한 로그인 수 (OK)
- 부서별 월별 로그인 수 (OK)

### 2. RestController를 활용하여 Rest API 구축
- 월별 접속자 수 (OK)
- 일자별 접속자 수 (OK)
- 평균 하루 로그인 수 (OK)
- 휴일을 제외한 로그인 수 (OK)
- 부서별 월별 로그인 수 (NO)

### 추가과제)3. HTTP 추가 공부
- 

### 기타

#### december 13
- TODO: 
  - 부서별 월별 로그인 수 기능 구현
  - API문서와 다른 API 수정
  - HTTP 공부 내용 문서화
  
- 질문내용 
  - 실제 구현 중 API 문서와 다르게 개발되어야 하는 경우는 어떻게 해야 하나요?
  - Mapper.xml 에서 중복되는 쿼리문들은 어떻게 하는 것이 더 나은가요?
    - 1.조건을 이용하여 중복을 최소화 
    - 2.내용이 중복되어도 새로 만듬 (아래 상단 2개의 쿼리문)

#### december 16

- 변경점 (develop branch)
  - Request Result 반환 재설계 (Sinlge or List)
  - sql 내용 일부 변경
  - log 기능 일부 추가
  
#### december 17
- 변경점 (develop branch)
  - LookupMapper Logging 연결
  - sql 에러 수정 (mybatis dynamic sql grammar error)
