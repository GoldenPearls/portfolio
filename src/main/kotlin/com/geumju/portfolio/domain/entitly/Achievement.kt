package com.geumju.portfolio.domain.entitly

import jakarta.persistence.*
import org.springframework.context.annotation.Description
import java.time.LocalDate

@Entity
class Achievement(
        title: String, //
        description: String, // 설명
        achievedDate: LocalDate?, // 달성일
        host: String, // 주최
        isActive: Boolean // 활성화 여부
) : BaseEntity(){  // BaseEntity 상속

    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 생성  (auto_increment)
    @Column(name = "achievement_id")
    var id: Long? = null //null이 허용된다. 코틀린은 null에 대한 안전성을 위해 기본적으로 null을 허용하지 않는다.

    var title: String = title

    var description: String = description

    var achievedDate: LocalDate? =  achievedDate

    var host: String = host

    var isActive: Boolean = isActive
}