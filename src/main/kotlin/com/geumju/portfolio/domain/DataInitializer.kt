package com.geumju.portfolio.domain

import com.geumju.portfolio.domain.constant.SkillType
import com.geumju.portfolio.domain.entitly.*
import com.geumju.portfolio.domain.repository.*
import jakarta.annotation.PostConstruct
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component // 스프링 빈으로 등록
@Profile(value=["default"]) // 프로파일이 default일 때만 실행,운영 환경에서도 그렇게 개발자의 임의대로 데이터가 들어가면 안 되기 때문에
class DataInitializer( // 생성자 주입
        private val achievementRepository: AchievementRepository,
        private val introductionRepository: IntroductionRepository,
        private val linkRepository: LinkRepository,
        private val skillRepository: SkillRepository,
        private val projectRepository: ProjectRepository,
        private val experienceRepository: ExperienceRepository
) {
    @PostConstruct // 빈이 생성된 후 실행
    fun initalizeData() {
        // 데이터 초기화
        println("스프링이 실행되었습니다., 테스트 데이터를 초기화합니다.")

        val achievements = mutableListOf<Achievement>(
                Achievement(
                        title = "2022 Catkao 해커톤 최우수상",
                        description = "고양이 쇼핑몰 검색 서비스의 아키텍처, 데이터 모델링, API 개발 역할 수행",
                        host = "캣카오",
                        achievedDate = LocalDate.of(2022, 8, 1),
                        isActive = true
                ),
                Achievement(
                        title = "정보처리기사",
                        description = "자료구조, 운영체제, 알고리즘, 데이터베이스 등",
                        host = "한국산업인력공단",
                        achievedDate = LocalDate.of(2020, 2, 2),
                        isActive = true
                ),
        )
        achievementRepository.saveAll(achievements) // 저장

        val introductions = mutableListOf<Introduction>(
                Introduction(content = "주도적으로 문제를 찾고, 해결하는 고양이입니다.", isActive = true),
                Introduction(content = "기술을 위한 기술이 아닌, 비즈니스 문제를 풀기 위한 기술을 추구합니다.",
                        isActive = true),
                Introduction(content = "기존 소스를 리팩토링하여 더 좋은 구조로 개선하는 작업을 좋아합니다.",
                        isActive = true)
        )
        introductionRepository.saveAll(introductions)

        val links = mutableListOf<Link>(
            Link(name = "Github", content = "https://github.com/GoldenPearls", isActive = true),
            Link(name = "Linkedin", content = "https:/www.linkedin.com/in/mellona",
                    isActive = true),
            Link(name = "Velog", content = "https://velog.io/@prettylee620/posts",
                        isActive = true),
            Link(name = "GitBook", content = "https://mellona-log.gitbook.io/log",
                        isActive = true),
        )
        linkRepository.saveAll(links)

        // experience / experience_detail 초기화
        val experience1 = Experience(
                title = "명지전문대학교(Myongji Univ.) : 정보통신공학과(본과정)",
                description = "전문학사",
                startYear = 2018,
                startMonth = 3,
                endYear = 2022,
                endMonth = 2,
                isActive = true,
        )
        experience1.addDetails(
                mutableListOf(
                        ExperienceDetail(content = "GPA 3.56/4.5", isActive = true)
                )
        )
        val experience2 = Experience(
                title = "명지전문대학교(Myongji Univ.) : 컴퓨터공학과(전공심화)",
                description = "학사",
                startYear = 2022,
                startMonth = 3,
                endYear = 2023,
                endMonth = 2,
                isActive = true,
        )
        experience2.addDetails(
                mutableListOf(
                        ExperienceDetail(content = "GPA 3.87/4.5", isActive = true),
                )
        )
        val experience3 = Experience(
                title = "멀티캠퍼스 : 백엔드 14차 과정",
                description = "부트 캠프로 모범상과 팀프로젝트 2등 수상",
                startYear = 2023,
                startMonth = 5,
                endYear = 2023,
                endMonth = 10,
                isActive = true,
        )
        experience3.addDetails(
                mutableListOf(
                        ExperienceDetail(content = "EBS 초중학 웹 사이트 응용유지보수", isActive = true)
                )
        )

        val experience4 = Experience(
                title = "쉐어마인드",
                description = "EBS 초중학 웹 개발자",
                startYear = 2024,
                startMonth = 1,
                endYear = null,
                endMonth = null,
                isActive = true,
        )
        experience4.addDetails(
                mutableListOf(
                        ExperienceDetail(content = "EBS 초중학 웹 사이트 응용유지보수", isActive = true)
                )
        )
        //영속성 컨텍스트에 들어가서 저장 되며, details도 같이 저장
        experienceRepository.saveAll(mutableListOf(experience1, experience2, experience3, experience4))

        // skill 초기화
        val java = Skill(name = "Java", type = SkillType.LANGUAGE.name, isActive = true)
        val kotlin = Skill(name = "Kotlin", type = SkillType.LANGUAGE.name, isActive = true)
        val spring = Skill(name = "Spring", type = SkillType.FRAMEWORK.name, isActive = true)
        val mariadb = Skill(name = "MariaDB", type = SkillType.DATABASE.name, isActive = true)
        val redis = Skill(name = "Redis", type = SkillType.DATABASE.name, isActive = true)
        skillRepository.saveAll(mutableListOf(java, kotlin, spring, mariadb, redis))

        // project / project_detail / project_skill 초기화
        val project1 = Project(
                name = "유기묘 발견 정보 공유 서비스",
                description = "유기묘 위치의 실시간 공유, 임시보호까지 연결해주는 서비스. 구글 맵스를 연동하여 유기묘 위치 정보를 직관적으로 파악할 수 있도록 하는 사용자 경험 개선 작업.",
                startYear = 2022,
                startMonth = 9,
                endYear = 2022,
                endMonth = 12,
                isActive = true
        )
        project1.addDetails(
                mutableListOf(
                        ProjectDetail(content = "구글 맵스를 활용한 유기묘 발견 지역 정보 제공 API 개발", url =
                        null, isActive = true),
                        ProjectDetail(content = "Redis 적용하여 인기 게시글의 조회 속도 1.5초 → 0.5초로 개선", url
                        = null, isActive = true)
                )
        )
        project1.skills.addAll(
                mutableListOf(
                        ProjectSkill(project = project1, skill = java),
                        ProjectSkill(project = project1, skill = spring),
                        ProjectSkill(project = project1, skill = mariadb),
                        ProjectSkill(project = project1, skill = redis)
                )
        )
        val project2 = Project(
                name = "반려동물 홈 카메라 움직임 감지 분석 모듈",
                description = "카메라에서 서버로 전달되는 신호를 분석하여 움직임이 감지될 경우 클라이언트에게 알림 발송 작 업.",
                startYear = 2022,
                startMonth = 12,
                endYear = null,
                endMonth = null,
                isActive = true
        )
        project2.addDetails(
                mutableListOf(
                        ProjectDetail(content = "PIL(Pillow) 활용하여 이미지 분석 기능 개발", url = null,
                                isActive = true),
                        ProjectDetail(content = "알림 발송을 비동기 처리하여 이미지 분석 - 알림 발송 기능간 의존도 감소", url = null, isActive = true),
                                ProjectDetail(content = "Github Repository", url =
                        "https://github.com/infomuscle", isActive = true)
                )
        )
        project2.skills.addAll(
                mutableListOf(
                        ProjectSkill(project = project1, skill = java),
                        ProjectSkill(project = project1, skill = spring),
                        ProjectSkill(project = project1, skill = mariadb),
                        ProjectSkill(project = project1, skill = redis)
                )
        )
        projectRepository.saveAll(mutableListOf(project1, project2))
    }
}