package com.geumju.portfolio.domain.entitly

import jakarta.persistence.*

@Entity
class ProjectDetail(
        content : String, // 내용
        url: String, // 링크
        isActive  : Boolean // 활성화 여부
) : BaseEntity(){  // BaseEntity 상속

    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 생성  (auto_increment)
    @Column(name = "project_detail_id")
    var id: Long? = null //null이 허용된다. 코틀린은 null에 대한 안전성을 위해 기본적으로 null을 허용하지 않는다.

    var content: String = content

    var url: String = url

    var isActive: Boolean = isActive

    fun update(content: String, url: String, isActive: Boolean){
        this.content = content
        this.url = url
        this.isActive = isActive
    }
}