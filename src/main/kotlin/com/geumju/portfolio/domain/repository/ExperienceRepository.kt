package com.geumju.portfolio.domain.repository

import com.geumju.portfolio.domain.entitly.Experience
import org.springframework.data.jpa.repository.JpaRepository

//crud를 위한 인터페이스
interface ExperienceRepository:JpaRepository<Experience, Long>{
}