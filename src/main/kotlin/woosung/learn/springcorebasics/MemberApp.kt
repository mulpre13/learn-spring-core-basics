package woosung.learn.springcorebasics

import org.springframework.context.annotation.AnnotationConfigApplicationContext
import woosung.learn.springcorebasics.member.Grade
import woosung.learn.springcorebasics.member.Member
import woosung.learn.springcorebasics.member.MemberService

fun main() {
    AnnotationConfigApplicationContext(AppConfig::class.java).apply(fun AnnotationConfigApplicationContext.() {
        val memberService = getBean("memberService", MemberService::class.java)
        val member = Member(1L, "A", Grade.VIP)
        memberService.join(member)

        val findMember = memberService.findMember(1L)
        println("new member = ${member.name}")
        println("find member = ${findMember?.name}")
    })
}