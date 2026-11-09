package org.webservice.songcrud.repository;

import org.webservice.songcrud.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

//Song은 Entity, Long은 Entity의 기본 키 타입을 의미한다.
public interface SongRepository extends JpaRepository<Song, Long> {
    List<Song> findByTitleContainingIgnoreCase(String keyword);
    List<Song> findByGenreAndReleaseYearBetween(
            String genre, Integer startYear, Integer endYear
    );
    List<Song> findAllByOrderByReleaseYearDesc();
}

//save(): Entity를 데이터 베이스에 저장하거나 수정
//findById(): 기본 키, Id를 이용하여 특정 Entity 조회
//findAll(): 모든 Entity 조회
//deleteById(): 기본 키, Id를 이용하여 특정 Entity 삭제
//existsById(): 해당 기본 키를 가진 Entity가 있는지 확인한다.

//findById()는 조회 결과가 없을 수도 있으므로 null 대신 Optional<Song> 반환

//기본 메서드는 JpaRepository에서 미리 제공, Query Method는 개발자가 직접 정의한다.