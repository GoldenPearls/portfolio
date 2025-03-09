package com.geumju.portfolio.domain.repository

import com.geumju.portfolio.domain.entitly.Achievement
import org.springframework.data.jpa.repository.JpaRepository

//crud를 위한 인터페이스
interface AchievementRepository:JpaRepository<Achievement, Long>{
}