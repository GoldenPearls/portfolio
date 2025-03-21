package com.geumju.portfolio.domain.repository

import com.geumju.portfolio.domain.entitly.Experience
import com.geumju.portfolio.domain.entitly.Introduction
import com.geumju.portfolio.domain.entitly.Link
import com.geumju.portfolio.domain.entitly.Project
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional


interface ProjectRepository:JpaRepository<Project, Long>{
    fun findAllByIsActive(isActive: Boolean) : List<Project>
}