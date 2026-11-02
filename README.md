1. 프로젝트 소개
- 주제 및 주요 기능: 노래 CRUD
- 필드 구조
  - id
  - title
  - artist
  - album
  - genre
  - releaseYear
- 개발 환경
  - IntelliJ
  - Java 17
  - Spring Boot, Data JPA
  - MariaDB
  - DBeaver
  - Postman
  - Render
  - Docker
  - Git/GitHub
- 프로젝트 구조
![스크린샷 2026-11-02 오후 7.30.16.png](image/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202026-11-02%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%207.30.16.png)
- 리포지토리 링크
  - https://github.com/2026-2-WebService/assign09-c01-22500250.git
- Render 링크
  - https://week9-render.onrender.com/

2. Database SQL Practice
![스크린샷 2026-11-02 오후 5.15.57.png](image/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202026-11-02%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%205.15.57.png)
![스크린샷 2026-11-02 오후 5.16.08.png](image/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202026-11-02%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%205.16.08.png)
![스크린샷 2026-11-02 오후 5.16.25.png](image/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202026-11-02%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%205.16.25.png)
![스크린샷 2026-11-02 오후 5.16.47.png](image/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202026-11-02%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%205.16.47.png)
![스크린샷 2026-11-02 오후 5.16.58.png](image/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202026-11-02%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%205.16.58.png)
![스크린샷 2026-11-02 오후 5.17.07.png](image/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202026-11-02%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%205.17.07.png)
![스크린샷 2026-11-02 오후 5.17.16.png](image/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202026-11-02%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%205.17.16.png)

3. Spring Data JPA 구현
- entity -> 노래 정보를 객체로 표현
  - 테이블과 연결되고, 필드가 테이들의 column
- repository -> 기본 CRUD 기능 제공
  - 인터페이스가 상속해서 데이터 추가, 조회, 수정, 삭제 메서드 활용
- Annotation
  - @Entity
  - @ID
  - @RestController 등등
- GET, POST, PUT, DELETE
- JPA, MariaDB 비교
  - 클래스 / 테이블
  - 객체 인스턴스 / 레코드
  - 객체 필드 / 컬럼
  - id 필드 / 기본 키
  - 저장 / INSERT, UPDATE
  - 조회 / SELECT
  - 삭제 / DELETE

4. JPA와 SQL 비교
- save()
  - songRepository.save(song);
  - INSERT INTO songs
    (title, artist, album, genre, release_year)
    VALUES
    (?, ?, ?, ?, ?);
- findAll()
  - songRepository.findAll();
  - SELECT * FROM songs;
- findById()
  - songRepository.findById(id);
  - SELECT * FROM songs WHERE id = ?;
- deleteById()
  - songRepository.deleteById(id);
  - DELETE FROM songs WHERE id = ?;

5. 배포 및 환경 설정
- 환경변수
  - DB_URL 
  - DB_USERNAME
  - DB_PASSWORD
- Render 배포 과정
  1. 개인 저장소에 프로젝트 업로드
  2. dockerfile 작성
  3. render에서 깃허브 저장소 연결
  4. 실행 환경 docker
  5. 환경변수 설정
  6. 빌드 및 실행
  7. 생성된 배포 링크 접속 및 테스트
- 발생한 문제
  - 처음 저장소에 연결할 때, Render에서 리스트에 안나오는 문제 발생, 깃허브에 재연결하고, 접근 가능 저장소 public 전체로 설정

6. Weekly Report
- 배운 점
   - JPA를 활용해 CRUD 서비스를 구현하는 방법을 배울 수 있었다.
   - 엔티티 필드가 데이터 베이스의 칼럼에 연결된다.
   - 환경 변수를 사용해 소스코드와 분리할 수 있다.
- 문제: 배포 API 요청 404 오류 및 소스 코드 작성 후 실행하는 과정에서 오류 발생
  - 실제 API 경로가 /api/songs 였음
  - 환경변수 등록 중 값 작성중에 공백이 있어 제대로 반영이 안되었음
- 주요 코드
  - songRepository.findAll();
    songRepository.findById(id);
    songRepository.save(song);
    songRepository.deleteById(id);
  - CRUD 관련 코드
  - 전체 목록 조회
  - 특정 ID 노래 조회
  - 새 노래 저장, 기존 entity 저장
  - 특정 ID 노래 삭제
- AI 사용
  - 오류 발생 시에 AI에 원인과 해결 방안 질문
  - Annotation 이해하도록 설명 요청
- 직접 검증
  - render 연결 시 deploy 오류 수정 등등
- AI 사용률
  - 25%