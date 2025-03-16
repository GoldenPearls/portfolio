package com.geumju.portfolio.domain.repository

import com.geumju.portfolio.domain.constant.SkillType
import com.geumju.portfolio.domain.entitly.*
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*


interface SkillRepository:JpaRepository<Skill, Long>{
    // select * from skill where is_active = :isActive
    fun findAllByIsActive(isActive: Boolean) : List<Skill>

    //select * from skill where lower(name) = lower(:name) and type = :type
    fun findByNameIgnoreCaseAndType(name: String, type: SkillType): Optional<Skill>
}