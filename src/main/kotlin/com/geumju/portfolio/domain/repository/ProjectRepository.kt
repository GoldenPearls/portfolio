package com.geumju.portfolio.domain.repository

import com.geumju.portfolio.domain.entitly.Introduction
import com.geumju.portfolio.domain.entitly.Link
import com.geumju.portfolio.domain.entitly.Project
import org.springframework.data.jpa.repository.JpaRepository


interface ProjectRepository:JpaRepository<Project, Long>{
}