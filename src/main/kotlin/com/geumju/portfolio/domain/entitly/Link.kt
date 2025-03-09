package com.geumju.portfolio.domain.entitly

import jakarta.persistence.*

@Entity
class Link(
        name : String, // 링크 이름
        content : String, // 링크 내용
        isActive  : Boolean // 활성화 여부
) : BaseEntity(){  // BaseEntity 상속

    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 생성  (auto_increment)
    @Column(name = "link_id")
    var id: Long? = null //null이 허용된다. 코틀린은 null에 대한 안전성을 위해 기본적으로 null을 허용하지 않는다.

    var name: String = name

    var content: String = content

    // is_active 알아서 매핑해줌
    var isActive: Boolean = isActive
}