## 선수지식
- Java

## 과제목표
- 웹 동작 방식 이해
- 웹 어플리케이션 구조 이해
- 데이터베이스 기초 이해
- 웹 어플리케이션 개발

## 레슨드런
- 웹 동작 방식 이해
    - HTTP 동작 방식 이해 - 웹브라우저의 웹서비스 url 를 통해 요청(request) 를 하면 서버에서 해당 요청을 처리하고 응답(response) 하는 프로세스 이해
    - Web Client (일반적으로 brower), WAS(Web Application Server), DB 역할 이해

- 웹 어플리케이션 구조 이해 및 개발
    - HTTP 요청을 처리하기 위한 웹어플리케이션 구조 이해

    - 웹어플리케이션 개발을 위한 기술스택 이해
        - Java 기반 Springboot : Web Application 개발을 위한 기본 오픈소스 프레임웍
        - JPA : 데이터베이스 처리를 위한 Java ORM(Object-Relational Mapping) 프레임웍 
        - Thymeleaf : UI View 처리를 위한 템플릿 엔진

- 데이터베이스 기초 이해
    - Database 설치 및 설정 (Create Database, user) 
    - DDL / DML 이해
        - CREATE TABLE
        - SELECT
        - INSERT
        - UPDATE
        - DELETE
        
---

## 상세 프로젝트 내용
### 기능구현
- Java Springboot 기반 웹 어플리케이션 개발
- MySQL Database를 이용하여 CRUD(Create,Read,Update,Delete) 기능 구현
    - 기능1. 칭찬하기 Insert
    - 기능2. 칭찬 리스트 Select
    - 기능3. 칭찬 수정 Update
    - 기능4. 칭찬 삭제 Delete
    
### 과제 기술 스택
- 개발환경
    - IntelliJ IDEA
    - GIT

- Server 개발
    - Java11
    - Spring Boot
    - JPA

- UI Templete
    - Thymeleaf

- Database
    - MySQL

    
### Sprinig boot 폴더 및 파일 구조
``` bash
Springboot 웹어플리케이션 패키지 구조
hanjoo.kim-cs-project
├── controller            -------> # controller to search path
├── domain                 -------> # entity model
├── dto                 -------> # manage dto
├── repository                 -------> # jpa
└── service                  -------> # business logic
```
