package com.geumju.portfolio.domain.entitly

import jakarta.persistence.*

@Entity
class ProjectSkill(
        project: Project,
        Skill: Skill
) : BaseEntity(){  // BaseEntity 상속

    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 생성  (auto_increment)
    @Column(name = "project_skill_id")
    var id: Long? = null //null이 허용된다. 코틀린은 null에 대한 안전성을 위해 기본적으로 null을 허용하지 않는다.

    @ManyToOne(targetEntity = Project::class, fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    var project: Project = project

    @ManyToOne(targetEntity = Skill::class, fetch = FetchType.LAZY)
    @JoinColumn(name = "skill_id", nullable = false)
    var skill: Skill = Skill
}