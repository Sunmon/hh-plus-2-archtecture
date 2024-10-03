# hh-plus-2-archtecture

## 요약

다음 두가지 API를 구현하고, 단위 테스트를 작성한다.
다수의 인스턴스로 어플리케이션이 동작하더라도 기능에 문제가 없도록 동시성 이슈를 고려하여 구현한다.

API

1. [x] 특강 신청 API
2. [x] 특강 신청 여부 조회 API
3. [x] 특강 조회 API

## 구현 기능

특강 신청 API

- [x] {유저의 id, 특강 id}를 받아 특강 신청을 한다.
- [x] 이미 신청한 특강이라면, 이미 신청했다는 메시지를 반환한다.
- [x] 특강 하나당 신청 가능한 인원 제한이 있다.
- [x] 신청 가능한 인원수 이후 신청한 요청은 실패 메세지를 반환한다.

특강 날짜 조회 API
현재 신청 가능한 특강의 날짜별 목록을 조회한다.

- [x] {특강 ID}를 받아 특강 정보를 반환한다. (특강 정보, 강연이 열리는 날짜 정보)

특강 신청 완료 목록 조회 API

- [x] {유저의 id}를 받아 신청한 특강 목록을 반환한다.
- [x] 신청한 특강이 없다면, 빈 배열을 반환한다.
- [x] 특강 목록의 각 항목은 특강 ID, 특강 이름, 강연자 정보를 담고 있어야 한다.

## 설계

### 프로젝트 구조

```
src
├── controller // 외부와 통화는 API 작성
├── domain // Repository <-> Service 간 데이터 교환용
├── entity // DB <-> Repository 간 데이터 교환용
├── repository
├── service
```

Service <--(Domain)--> Repository <--(Entity)--> JPA Repository <--> DB

- @Entity는 JPA에서 사용하는 어노테이션. 따라서 특정 구현체에 의존하는것과 같다고 생각함
- 서비스를 특정 구현에 한정하지 않기 위하여 JPA Repository와 Service 사이에 Repository 한 계층을 더함

### 도메인 설계 (ERD)

![ERD](https://private-user-images.githubusercontent.com/26290571/373421580-d3d11168-3337-4cd4-8dc5-f7b16260bdaf.jpg?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3Mjc5OTE3MDMsIm5iZiI6MTcyNzk5MTQwMywicGF0aCI6Ii8yNjI5MDU3MS8zNzM0MjE1ODAtZDNkMTExNjgtMzMzNy00Y2Q0LThkYzUtZjdiMTYyNjBiZGFmLmpwZz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNDEwMDMlMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjQxMDAzVDIxMzY0M1omWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPTAwZDA3MjMzNTI0YTliMWVhZmIxZThkNDJlY2Y5Yjk1MjcyYWQ3MjViYmFjMzQ1MmIyMDQ4NTRmMGE4MWY5NmQmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0In0.WgsuV2ietl_pDmSZkS0pSlY-W1recEDbuC0pb1OOm48)

- Schedule: 특강의 날짜별 정보를 관리하는 테이블
- Enrollment: 특강 신청 정보를 관리하는 테이블 (특강 신청 내역)

Enrollment 테이블에만 락을 걸면 다수의 인스턴스에서 동일한 결과를 보장할 수 있을 것 같아 차용함.

## 고민

> 프로젝트 구조를 어떻게 구성할 것인가?

- 도메인을 기준으로 구분하는 방법
- 레이어를 기준으로 구분하는 방법

두 가지중 "레이어를 기준으로 구분하는 방법"을 이용하기로 결정.

이 방법이 기능을 추가할 때, 도메인을 기준으로 구분하는 방법보다 유연하다고 판단했기 때문이다.

도메인을 기준으로 구분하게 되면, 두가지 이상의 도메인이 협력해야 하는 기능을 작성해야 할때 어느 도메인에 작성해야 할지 판단이 어려워질것이라고 생각해서다.

따라서 파일 및 기능이 추가될 위치가 보다 명확하도록 레이어를 기준으로 구분하는 방법을 사용하기로 결정했다.

> 신청인원 컬럼을 두는 것이 맞나?

특강 인원 히스토리 테이블을 두면, 특강 신청한 로그가 쌓일것이다.

특정 강의의 신청 히슽토리 개수를 조회하면 신청인원을 알 수 있다.

- 신청 인원 컬럼을 따로 두어 관리하는 것 (DB 테이블 update 빈번)
- 신청 히스토리로 관리하는 것 (매번 select 필요)

~~두 방법중 어느 방법이 좋을지는 아직 모르겠다.~~

멘토링에서 조언받은대로 일급컬렉션으로 분리하여 관리함.

DB의 update는 지양하는 것이 좋을뿐아니라 매번 update 할때마다 lock을 걸게되면 불편할 것이라고 판단했다.

특강이라는 테이블 내에 한가지 컬럼(신청인원 수)을 업데이트 하기 위해 락을 걸게 되는거인데다가 Readlock도 아니고 Writelock을 걸어야 할 것이므로 비효율적이라고 생각했다.


> 엔티티 설계: 엔티티에 Long id만 두기 vs 다른 엔티티 자체를 두기

```java
import java.time.LocalDateTime;

// 1. id만 두기 (fk)
@Entity
class LectureEnrollment {
    Long lectureId;
    Long userId;
    LocalDateTime createdAt;
}

// 2. 객체를 두기 (fk)
@Entity
class LectureEnrollment {
    Lecture lecture;
    User user;
    LocalDateTime createdAt;
}

```

객체를 참조하는 방식을 사용했다.

왜냐하면 1번 방식이 익숙하고 테이블과도 직관적으로 매핑되기는 하나, JPA만의 장점을 활용하지 못하는 것이라고 판단했기 떄문이다.

어차피 Repository용 계층을 하나 더 두었으니 JpaRepository는 Jpa를 활용해서 짜는 것이 좋다고 생각한다.

또한 개발 단계에서 테이블의 변경이 빈번하다면 2번 방식이 더 유연할 것이라고 생각했다.  