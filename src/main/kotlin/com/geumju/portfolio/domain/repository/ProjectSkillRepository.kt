package com.geumju.portfolio.domain.repository

import com.geumju.portfolio.domain.entitly.Introduction
import com.geumju.portfolio.domain.entitly.Link
import com.geumju.portfolio.domain.entitly.Project
import com.geumju.portfolio.domain.entitly.ProjectSkill
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional


interface ProjectSkillRepository:JpaRepository<ProjectSkill, Long>{

    // select * from project_skill where project_id = :projectId and skill_id = :skillId
    fun findByProjectIdAndSkillI(projectId: Long, skillId: Long): Optional<ProjectSkill>
}