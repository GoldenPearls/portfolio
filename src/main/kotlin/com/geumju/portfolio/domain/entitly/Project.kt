package com.geumju.portfolio.domain.entitly

import jakarta.persistence.*

@Entity
class Project(
        name: String,
        description: String,
        startYear: Int,
        startMonth: Int,
        endYear: Int?,
        endMonth: Int?, //? : null 허용
        isActive: Boolean
) : BaseEntity(){  // BaseEntity 상속

    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 생성  (auto_increment)
    @Column(name = "project_id")
    var id: Long? = null //null이 허용된다. 코틀린은 null에 대한 안전성을 위해 기본적으로 null을 허용하지 않는다.

    var name: String = name

    var description: String = description

    var startYear: Int = startYear // 시작년도

    var startMonth: Int = startMonth // 시작월 (1~12)

    var endYear: Int? = endYear // 종료년도

    var endMonth: Int? = endMonth // 종료월 (1~12)

    var isActive: Boolean = isActive

    @OneToMany(targetEntity = ProjectDetail::class,
            fetch = FetchType.LAZY,
            cascade = [CascadeType.ALL])
    @JoinColumn(name = "project_id") //매핑이 되는 컬럼이 뭔지 알려줌
    var details: MutableList<ProjectDetail> = mutableListOf() // 1:N 관계, 빈 리스트를 만들어줌, 데이터를 넣고 뺴고가 가능

    @OneToMany(mappedBy = "project",
            fetch = FetchType.LAZY,
            cascade = [CascadeType.ALL])
    var skills : MutableList<ProjectSkill> = mutableListOf()

    fun getEndYearMonth(): String {
        if (endYear != null || endMonth != null) {
            return "Present"
        } else {
            return "${endYear}.${endMonth}"
        }
    }

    fun update(name: String, description: String, startYear: Int, startMonth: Int, endYear: Int?, endMonth: Int?, isActive: Boolean) {
        this.name = name
        this.description = description
        this.startYear = startYear
        this.startMonth = startMonth
        this.endYear = endYear
        this.endMonth = endMonth
        this.isActive = isActive
    } // 업데이트

    fun addDetail(detail: MutableList<ProjectDetail>?) {
        if(details != null){
            this.details.addAll(details)
        }
    } // 디테일 추가
}