package com.geumju.portfolio.domain.repository

import com.geumju.portfolio.domain.entitly.*
import org.springframework.data.jpa.repository.JpaRepository


interface SkillRepository:JpaRepository<Skill, Long>{
}