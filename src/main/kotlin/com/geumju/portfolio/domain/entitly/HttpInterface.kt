package com.geumju.portfolio.domain.entitly

import jakarta.persistence.*
import jakarta.servlet.http.HttpServletRequest

@Entity
class HttpInterface(httpServletRequest: HttpServletRequest) : BaseEntity(){  // BaseEntity 상속

    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 생성  (auto_increment)
    @Column(name = "http_interface_id")
    var id: Long? = null //null이 허용된다. 코틀린은 null에 대한 안전성을 위해 기본적으로 null을 허용하지 않는다.

    //쿠키는 배열이고, 널 여부 확인을 위해 ?를 붙여준다.
    //$는 문자열 템플릿으로, 다운표 안에서 이렇게 달러하고 중가로 표시를 써주면은 포맷팅
    var cookies: String? = httpServletRequest.cookies
            ?.map {"${it.name}:${it.value}"}
            ?.toString()

    //referer은 이전 페이지의 주소를 나타내는 헤더, 요청이 어디서 왔냐를 봄
    var refer: String? = httpServletRequest.getHeader("referer")

    // refer, localAddr, remoteAddr, remoteHost, requestURI, userAgent등은 클라이언트와 관련된 ip 주소
    var localAddr: String? = httpServletRequest.localAddr

    var remoteAddr: String? = httpServletRequest.remoteAddr

    var remoteHost: String? = httpServletRequest.remoteHost

    var requestURI: String? = httpServletRequest.requestURI

    var userAgent: String? = httpServletRequest.getHeader("user-agent")

}