package com.geumju.portfolio.domain.entitly

import jakarta.persistence.*

@Entity
class ExperienceDetail(
        content : String, // 내용
        isActive  : Boolean // 활성화 여부
)  : BaseEntity(){  // BaseEntity 상속

    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 생성  (auto_increment)
    @Column(name = "experience_detail_id")
    var id: Long? = null //null이 허용된다. 코틀린은 null에 대한 안전성을 위해 기본적으로 null을 허용하지 않는다.

    var content: String = content

    var isActive: Boolean = isActive

    // experience와의 관계는 단방향인 것을 알 수 있음 experience에서 detail을 참조할 수 있지만
    // detail에서 experience를 참조할 수 없음
    fun update(content: String, isActive: Boolean){
        this.content = content
        this.isActive = isActive
    }
}