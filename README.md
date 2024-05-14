# Tell me to do

## 1. 프로젝트 소개 📄

> 나의 to do를 친구들과 공유할 수 있는 웹사이트

1인 개발로 진행중인 Tell me to do는 **Spring Boot** 기반의 프로젝트 입니다. \
단순히 개인의 to-do를 관리하는 기능 외에도 다른 유저와의 to-do 공유를 위해 로그인 기능이 필요합니다. 이를 위해 **Spring Security**를 사용하여 사용자 인증을 구현하였습니다. 또한 객체 지향적인 설계를 위해 **JPA**를 선택하여 데이터베이스와의 상호작용을 구현하였으며 동적 쿼리를 편리하게 작성하고 가독성을 높이기 위해 **queryDSL**도 활용하였습니다.

<br />

<p align="center" width="100%">
	<img width="1000" alt="Screenshot 2024-03-15 at 5 08 32 PM" src="https://github.com/ebcode2021/tell-me-todo/assets/84271971/8c55e860-4a11-4831-a04e-e18951f2af45">
</p>

## 2. 개발 기간

-   2024.03 ~ 개발 중

## 3. 개발 환경

**[develop]** \
**back-end** : Java(jdk-21), SpringBoot 3.2.3, Spring Security, Junit5, Thymeleaf \
**database** : JPA, queryDSL, PostgreSQL \
**front-end** : JavaScript, Bootstrap

**[tool & design]** \
**개발 도구** : IntelliJ IDEA \
**디자인** : Figma \
**DB 설계** : ERDCloud

## 4. 설계

### 4-1. 디자인

🎨 [Visit Figma](https://www.figma.com/file/bSmQKmCxq6BoPg1evYlNtp/Tell-me-to-do?type=design&node-id=0-1&mode=design&t=e2aWO3ddeYylvPW0-0)

<img width="912" alt="figma image" src="https://github.com/ebcode2021/tell-me-todo/assets/84271971/f37b0c62-a8f4-4f09-947d-3b9c89b6ace3">

<br />

### 4-2. DB

📦 [Visit ERDCloud](https://www.erdcloud.com/d/Lmxsad4xTLCLjiD4M)

<img width="1006" alt="erd" src="https://github.com/ebcode2021/tell-me-todo/assets/84271971/ff144cd0-cb3a-40f6-8e13-c1521f2aae52">

<br />
** 구현에 따라 지속적으로 변경이 일어나고 있습니다. 최신 ERD는 링크에서 확인 가능합니다.

<br />

### 4-3. 패키지 구조

**도메인 패키지** 구조를 선택했습니다. Entity를 기반으로 패키징하여 직관적으로 개발하기 쉽게 만들고자 했습니다.

**[최상위 레벨 패키지]**

```
domain : entity를 기준으로 하위 패키지 구성
global : 프로젝트 전방위적으로 사용할 수 있는 클래스들로 구성
```

### 4-4. URL 명세

| 도메인   | URL               |
| -------- | ----------------- |
| 메인     | /                 |
| 로그인   | /login            |
| 회원가입 | /join             |
| 프로필   | profile/:nickname |

<br />

### 4-5. API 명세

> REST API 설계 기본 원칙에 따라 설계하였습니다.

<img width="844" alt="api" src="https://github.com/ebcode2021/tell-me-todo/assets/84271971/5ecab711-2361-4d8c-bf73-4e6380b439d5">

## 5. 구현

### 5-1. 구현 포인트(구현 요구사항)

-   로그인을 안해도 사이트 이용이 가능했으면 좋겠다. \
    (이유 : 사이트에 만족하고, 추가 기능 사용을 원할 때 회원가입을 자유롭게 하도록!)

-   `/profile`에서는 내가 작성한 todo-list를 필요한 날짜만 선택해서 볼 수 있어야 한다.\
    (이유 : to-do 들이 늘어져 있으면 UI가 좋지 않다.)

### 5-2. 구현 순서

1. 비회원의 to do 기능 구현
2. guest 로그인 기능으로 to do 관련 API 구현
3. 로그인/회원가입
4. 프로필 페이지 (현재 진행중)
5. 다른 유저와 상호작용

### 5-3. 구현 기능

**1. 로그인**
<img width="1600" alt="메인 페이지" src="https://github.com/ebcode2021/tell-me-todo/assets/84271971/7d5314e0-be39-42d1-8cb7-779e835dfbf6">

<br />

**2. 회원가입**
<img width="1600" alt="회원가입" src="https://github.com/ebcode2021/tell-me-todo/assets/84271971/df16e571-e41e-4018-8e8d-3f32c9157adf">

<br />

**3. 메인(로그인 / 게스트)**
<img width="1600" alt="메인 페이지" src="https://github.com/ebcode2021/tell-me-todo/assets/84271971/d71e5b85-b55d-4569-8c3f-c1148a2981b9">
<img width="1600" alt="메인 페이지" src="https://github.com/ebcode2021/tell-me-todo/assets/84271971/9712f466-dcd8-40f8-bd8a-63cc9c19cc0d">
