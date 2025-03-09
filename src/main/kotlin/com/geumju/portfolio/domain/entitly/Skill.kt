package com.geumju.portfolio.domain.entitly

import com.geumju.portfolio.domain.constant.SkillType
import jakarta.persistence.*

@Entity
class Skill(
        name : String, // 스킬 이름
        type : String, // 스킬 타입
        isActive  : Boolean // 활성화 여부
) : BaseEntity(){  // BaseEntity 상속

    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 생성  (auto_increment)
    @Column(name = "skill_id")
    var id: Long? = null //null이 허용된다. 코틀린은 null에 대한 안전성을 위해 기본적으로 null을 허용하지 않는다.

    var name: String = name

    @Column(name = "skill_type")  // 예약어로 쓸 수 있기에 컬럼명을 skill_type로 변경
    @Enumerated(EnumType.STRING) // enum 매핑, enum 타입의 경우, 데이터 정합성 때문에 숫자보다는 문자열로 저장
    var type: SkillType = SkillType.valueOf(type) // enum 매핑
    // SkillType.valueOf(type) : enum class SkillType 에서 type에 해당하는 enum을 찾아서 매핑해줌

    // is_active 알아서 매핑해줌
    var isActive: Boolean = isActive
}
}