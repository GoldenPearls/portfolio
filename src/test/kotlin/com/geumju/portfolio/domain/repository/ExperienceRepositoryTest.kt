package com.geumju.portfolio.domain.repository

import com.geumju.portfolio.domain.entitly.Experience
import com.geumju.portfolio.domain.entitly.ExperienceDetail
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import java.sql.DriverManager

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ExperienceRepositoryTest(
    @Autowired val experienceRepository: ExperienceRepository
) {
    val DATA_SIZE = 10

    //더미 객체 생성
    private fun createExperience(n: Int): Experience { // n을 인자로 받는 createExperience 함수 생성
        val experience = Experience( // Experience 객체 생성
                title = "${n}",
                description = "테스트 설명 {n}",
                startYear = 2023,
                startMonth = 9,
                endYear = 2023,
                endMonth = 9,
                isActive = true
        )
        val details = mutableListOf<ExperienceDetail>() // ExperienceDetail을 담을 details 리스트 생성
        for (i in 1..n) { // 1부터 n까지 반복
            val experienceDetail = ExperienceDetail(content = "테스트 ${i}", isActive = true)
            details.add(experienceDetail) // details에 experienceDetail을 추가
        }
        experience.addDetails(details) // experience에 details를 추가
        return experience
    }

    @BeforeAll
    fun beforeAll() {
        println("---데이터 초기화 이전 조회 시작 ----")
        val beforeInitializer = experienceRepository.findAll() // experienceRepository의 모든 데이터를 beforeInitializer에 저장
        assertThat(beforeInitializer).hasSize(0) // beforeInitializer의 사이즈가 0인지 확인
        println("---데이터 초기화 이전 조회 끝 ----")

        println("---테스트 데이터 초기화 시작 ----")
        val experiences = mutableListOf<Experience>()
        for(i in 1 ..DATA_SIZE ){ // 1부터 DATA_SIZE까지 반복
            val experience = createExperience(i) // createExperience 함수 호출
            experiences.add(experience) // experiences에 experience 추가
        }
        experienceRepository.saveAll(experiences) // experiences를 저장
        println("---테스트 데이터 초기화 끝 ----")
    }

    @Test
    fun testFindAll() {
        println("---findAll 테스트 시작 ----")
        val experiences = experienceRepository.findAll() // experienceRepository의 모든 데이터를 experiences에 저장
        assertThat(experiences).hasSize(DATA_SIZE) // experiences의 사이즈가 DATA_SIZE와 같은지 확인

        println("experiences.size : ${experiences.size}")

        for(experience in experiences){
            assertThat(experience.details).hasSize(experience.title.toInt()) // experience의 details의 사이즈가 experience.title.toInt()와 같은지 확인
            println("${experience.title} : ${experience.details.size}")
        }
        
        println("---findAll 테스트 종료 ----")
    }

    @Test
    fun testFindAllByIsActive() {
        println("---findAll 테스트 시작 ----")
        val experiences = experienceRepository.findAllByIsActive(true) // experienceRepository의 모든 데이터를 experiences에 저장
        assertThat(experiences).hasSize(DATA_SIZE) // experiences의 사이즈가 DATA_SIZE와 같은지 확인

        println("experiences.size : ${experiences.size}")

        for(experience in experiences){
            assertThat(experience.details).hasSize(experience.title.toInt()) // experience의 details의 사이즈가 experience.title.toInt()와 같은지 확인
            println("${experience.title} : ${experience.details.size}")
        }

        println("---findAllByIsActive 테스트 종료 ----")
    }
}