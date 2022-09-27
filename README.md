# egovWebWatcher
산학 프로젝트 "웹 어플리케이션 테스팅 자동화 서비스를 제공하는 웹 어플리케이션(Web Watcher)"를 표준프레임워크로 이전하는 프로젝트
표준 프레임워크 3.8 버전 업그레이드 이후 공통컴포넌트 적용을 위해선 프로젝트 구조 변화로 인해 프로젝트 구조 변경 필요
이에 따라 프로젝트 이전 

## 기간

2022-09-01 ~


## 기술 스택

### 백 엔드
- 아파피 톰켓 : 8.5
- 자바 : 1.8 jdk
- 표준프레임워크 : 3.10.0
- 스프링 : 4.3.25
- MySql : 8.0

### 프론트 엔드
- HTML5
- CSS3
- jQeury
- Material Design Lite

### CD/CI
- Git

### 배포

- heroku

https://egov-web-watcher.herokuapp.com/

## 디자인
https://www.figma.com/file/4QkriGQPACgyceDZFSxgGU/Watcher?node-id=0%3A1

## 로그

### 2022-09-01 
- clear db 연동
- heroku 최초 배포
- 프로젝트 생성 및 sample page 작성
- 깃 연동

### 2022-09-02
- 테스팅 결과 데이터 추출 및 전처리 (22953 line)
  * clearDB 무료는 시간당 가능 쿼리 횟수가 3600 이므로 데이터를 나누어서 등록할 필요가 있음 
  
### 2022-09-04
- 테스팅 결과 데이터 등록(~800)

### 2022-09-06
- login, site 테이블 db에 추가
- 사이트 패키지 추가
- 모든 사이트 리스트 출력 기능 추가
- ibatis dtd 설치 경로 변경으로인한 에러 해결
- 공통 VO commonVO 추가
  * seq, 생성/변경/삭제 column을 가지고 있는 객체
- 공통 service commonServce 추가
  * 현재 시간을 이용해서 ctime/cdate, utime/udate, dtime/udate 값을 설정해주는 매소드 추가
- katalon recorder를 활용한 테스트 케이스 생성 및 도입 고려

### 2022-09-07
- user 테이블 db에 추가
- 사이트 리스트 페이징 추가
- 유저 별 사이트 리스트 페이지 추가

### 2022-09-13
- site insert 기능 추가
- site insert에 validator 추가
- site delete 기능 추가+삭제 확인
- 오류 해결
  * 엔터를 누를 시 validator를 거치지 않고 sibmit이 되는 오류 해결 -> event.preventDefault를 이용해 엔터로 submit 행위 블락
  * <Warning> <org.apache.commons.validator.ValidatorResources> <BEA-000000> <Form 'null' not found for locale 'ko_KR'> -> validator.jsp 경로 수정
  
### 2022-09-15
 - scenario 테이블 생성
 - 오류 해결
   * 사이트 리스트 페이징 경로 에러 -> c:url를 문자열로 대체
 ### 2022-09-16
 - 사이트 시나리오 다운로드 적용(미완)
 - 사이트 시나리오 이름 validator추가
 
 ### 2022-09-19
 - spring+jakarta api를 활용한 백엔드 validator 패키지 추가 및 사이트 등록에 적용
 - 파일 다운로드 구형
 - site와 file 테이블을 묶어주는 siteWithFileVO을 이용한 사이트+파일 리스트 목록 출력 기능 추가
 - 전체 사이트 리스트 출력 기능 삭제
 - 유저별 사이트 리스트/등록/삭제 기능 추가
 - login 및 유저 컬럼에 version과 로그인 실패 관련 컬럼 추가
 
  ### 2022-09-21
 - fileservice에 filename 컬럼이 누락된 것을 확인 후 해당 컨트롤러,xml,jsp 파일 수정
 - update 페이지 연동
 - sitelist 페이지네이션 오류 수정(userSeq를 searchkey로 설정해 놓은것을 삭제 후 userSeq 조건문 추가)
 
 ### 2022-09-22
  - 회원가입 구현
  - 로그인 구현
  - 사이트 리스트 디자인 적용

 ### 2022-09-23
  - site list 등록 페이지 디자인 적용
  - 화면/롤/권한 관리 공통 컴포넌트 적용 및 프로젝트 이전
  
 ### 2022-09-24
  - site list CRUD 구현
 
 ### 2022-09-25
  - 로그인 및 회원가입 CRUD 구현
  - 표준프레임워크 파일관리 컴포넌트 추가
  - 사이트 리스트 파일 업로드 및 수정 추가
