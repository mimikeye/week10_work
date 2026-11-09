1. 프로젝트 소개
   - 음악 정보를 관리하는 웹 서비스
   - 음악 정보 등록, 조회, 수정, 삭제
   - 제목, 장르, 발매 연도 등등
   - 생성, 수정 시간 기록

   - Repository: https://github.com/2026-2-WebService/assign10-c01-22500250.git
   - Render URL: https://week10-work.onrender.com

2. 주요 구현 내용 및 결과
   - Query Method
     - findByTitleContainingIgnoreCase	제목에 특정 키워드 포함
       - 조건: 제목에 love가 포함된 음악
       - 결과: 조건에 맞는 음악 목록 출력
     - findByGenreAndReleaseYearBetween	장르와 발매 연도 범위
       - 조건: Pop 장르 / 2010~2025년 발매음악
       - 결과: 조건에 맞는 음악 목록 출력
     - findAllByOrderByReleaseYearDesc	발매 연도 기준으로 내림차순
       - 조건: 전체 음악을 발매 연도 내림차순
       - 결과: 조건에 맞는 음악 목록 출력

   - Dirty Checking
     - 기존 음악 정보 조회한 후 PUT 정보수정
     - 변경 사항이 자동으로 반영
     - 결과: save() 호출 없이도 정상적으로 저장됨

   - Auditing
     - @CreatedDate, @LastModifiedDate -> 생성 시간, 수정 시간 구현
     - 결과: 새 음악 등록시 기록됨, 기존 음악 수정하면 수정 시간 바뀜

3. Weekly Review
   - Auditing을 활용해서 생성 시간과 수정 시간을 저장을 자동화할 수 있다는 것을 알게 되었다.
   - Dirty Checking으로 변경사항이 자동으로 반영되게 하는 과정을 알아볼 수 있었다.

   - Auditing 적용 후 DBeaver에서 생성 시간과 수정 시간이 나타나지 않았음
   - 해결 방법: AI에 질문하여 사용중인 버전에서 자동 처리가 되지 않는다는 것을 알게 되었고, 직접 추가한 뒤 정상적으로 테스트 되는것을 확인할 수 있었다.

   - 이번 과제에서는 지난 주 과제에서 추가적인 기능 약 3개 정도를 추가해 서비스를 좀 더 간편하고 사용성이 좋게 만들 수 있었다. 단순 CRUD 기능에서 JPA, 그리고 시간기록이나 수정 자동화를 구현한 부분이 인상깊었다.

4. AI Usage
   - 사용 도구: ChatGPT
   - 주요 질문:
     - 오류 발생시 원인 확인
     - 해결 방법 질문
     - 개념 이해 가지 않는 부분 질문
   - 처음에 이해가 가지 않아 우선 AI가 예시로 만들어준 코드를 내 기존 코드와 비교해 직접 수정하여 적용했다.
   - 약 35%
     - 이번 주 내용은 중간 중간 오류가 많이 발생해서 꽤 도움을 많이 받았다.