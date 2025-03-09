package com.geumju.portfolio.domain.repository

import com.geumju.portfolio.domain.entitly.Introduction
import com.geumju.portfolio.domain.entitly.Link
import org.springframework.data.jpa.repository.JpaRepository


interface LinkRepository:JpaRepository<Link, Long>{
}