# Tell me to do

## 1. 프로젝트 소개 📄

> 나의 to do를 친구들과 공유할 수 있는 웹사이트

Tell me to do는 나의 to-do를 다른 사람들과 공유할 수 있는 웹사이트.\
1인 프로젝트로 진행된 Tell me t

## 2. 개발 기간

2024.03 ~ 개발 중

## 3. 개발 환경

**[Develop]** \
back-end : Java(jdk-21), Junit5, SpringBoot 3.2.3, Spring Security, Thymeleaf \
database : JPA, queryDSL, PostgreSQL \
front-end : JavaScript, Bootstrap

**[Tool & Design]** \
개발 도구 : IntelliJ IDEA \
디자인 : Figma \
DB 설계 : ERDCloud

## 4. 설계

### 4-1. 디자인

-   [🎨 Visit Figma Design](https://www.figma.com/file/bSmQKmCxq6BoPg1evYlNtp/Tell-me-to-do?type=design&node-id=0-1&mode=design&t=e2aWO3ddeYylvPW0-0)
    <img width="912" alt="Screenshot 2024-03-15 at 5 22 27 PM" src="https://github.com/ebcode2021/tell-me-todo/assets/84271971/7648c277-a035-4aaf-8869-3dced89e3d0c">

<br />

### 4-2. DB

-   [📦 Visit Database](https://www.erdcloud.com/d/Bzk9rHYdfNwSpsCTM)  
     <img width="1127" alt="Screenshot 2024-03-15 at 5 24 31 PM" src="https://github.com/ebcode2021/tell-me-todo/assets/84271971/5f6c62b8-f775-4ba9-810a-d447b1c7da70">
    <br />
    \*\* 구현에 따라 업데이트가 지속적으로 이루어질 예정입니다.

<br />

### 4-3. 패키지 구조

선택한 디렉토리 구조 : **도메인 패키지** 구조 \
이유 : Entity를 기반으로 패키징하는 것이 직관적이게 보여 개발하는 내가 편할 것 같아서!

**[최상위 레벨 패키지]**

```
domain : entity를 기준으로 하위 패키지 구성
global : 프로젝트 전방위적으로 사용할 수 있는 클래스들로 구성
```

<br />

### 4-4. URL 명세

| 도메인   | URL               |
| -------- | ----------------- |
| 메인     | /                 |
| 회원가입 | /signUp           |
| 프로필   | profile/:nickname |

<br />

### 4-5. API 명세

> REST API 설계 기본 원칙에 따라 설계하였습니다.

<img width="844" alt="Screenshot 2024-03-15 at 5 35 16 PM" src="https://github.com/ebcode2021/tell-me-todo/assets/84271971/838de64e-e72b-4d61-b4fa-c1a4cff58de3">

## 5. 구현