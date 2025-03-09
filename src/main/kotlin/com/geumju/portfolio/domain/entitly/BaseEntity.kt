package com.geumju.portfolio.domain.entitly

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import java.time.LocalDate
import java.time.LocalDateTime

@MappedSuperclass // JPA Entity 클래스들이 BaseTimeEntity를 상속할 경우 필드들(createdDate, modifiedDate)도 컬럼으로 인식하도록 합니다.
abstract class BaseEntity {

    @CreatedDate // Entity가 생성되어 저장될 때 시간이 자동 저장됩니다.
    @Column(nullable = false, updatable = false) // Entity가 생성되어 저장될 때 시간이 자동 저장
    var createdDateTime: LocalDateTime = LocalDateTime.now() // 생성일 시간

    @LastModifiedBy // 조회한 Entity의 값을 변경할 때 시간이 자동 저장됩니다.
    @Column(nullable = false) // 조회한 Entity의 값을 변경할 때 시간이 자동 저장
    var ypdatedDateTime: LocalDateTime = LocalDateTime.now() // 수정일 시간


}