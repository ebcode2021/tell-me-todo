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

<img width="912" alt="figma image" src="https://github.com/ebcode2021/tell-me-todo/assets/84271971/7648c277-a035-4aaf-8869-3dced89e3d0c">

<br />

### 4-2. DB

📦 [Visit ERDCloud](https://www.erdcloud.com/d/Lmxsad4xTLCLjiD4M)

<img width="1006" alt="erd" src="https://github.com/ebcode2021/tell-me-todo/assets/84271971/ff144cd0-cb3a-40f6-8e13-c1521f2aae52">

<br />
** 구현에 따라 지속적으로 변경이 일어나고 있습니다. 최근 ERD는 링크에서 확인 가능합니다.

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
| 회원가입 | /signUp           |
| 프로필   | profile/:nickname |

<br />

### 4-5. API 명세

> REST API 설계 기본 원칙에 따라 설계하였습니다.

<img width="844" alt="api" src="https://github.com/ebcode2021/tell-me-todo/assets/84271971/838de64e-e72b-4d61-b4fa-c1a4cff58de3">

## 5. 구현

> Last Updated : 2024.04.17

### 5-1. 구현 포인트(구현 요구사항)

-   로그인을 안해도 사이트 이용이 가능했으면 좋겠다. \
    (이유 : 사이트에 만족하고, 추가 기능 사용을 원할 때 회원가입을 자유롭게 하도록!)

-   `/profile`에서는 내가 작성한 todo-list를 필요한 날짜만 선택해서 볼 수 있어야 한다.\
    (이유 : to-do 들이 늘어져 있으면 UI가 좋지 않다.)

### 5-2. 구현 순서

1. 비회원의 to do 기능 구현
2. guest 로그인 기능으로 to do 관련 API 구현
3. 로그인/회원가입
4. 프로필 페이지

### 5-3. 현재 진행 사항

-   비회원의 to do 기능 구현 완료 \
    -> localStorage를 사용해서 브라우저 창이 닫히거나 새로고침이 이루어져도 데이터 유지 \
    -> to do item CRUD 가능
-   **(진행중)** guest 로그인 기능으로 to do 관련 API 구현 \
    -> login 모달 생성
    -> User Entity 생성, 서버 부팅시 guest 로그인
    -> (진행중) guest login시 데이터 잘 들어오는가 -> join 구현 + 테스트코드 작성
    -> (예정) guest login시 오늘 날짜의 todo의 items 받아올 수 있게 매핑 -> 렌더링 