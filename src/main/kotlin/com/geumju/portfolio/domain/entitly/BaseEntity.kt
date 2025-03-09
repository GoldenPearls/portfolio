package com.geumju.portfolio.domain.entitly

import jakarta.persistence.MappedSuperclass

@MappedSuperclass // JPA Entity 클래스들이 BaseTimeEntity를 상속할 경우 필드들(createdDate, modifiedDate)도 컬럼으로 인식하도록 합니다.
abstract class BaseEntity {
}