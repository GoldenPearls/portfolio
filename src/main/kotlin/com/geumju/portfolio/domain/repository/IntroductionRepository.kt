package com.geumju.portfolio.domain.repository

import com.geumju.portfolio.domain.entitly.HttpInterface
import com.geumju.portfolio.domain.entitly.Introduction
import org.springframework.data.jpa.repository.JpaRepository


interface IntroductionRepository:JpaRepository<Introduction, Long>{
}