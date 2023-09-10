package woosung.learn.springcorebasics

import woosung.learn.springcorebasics.member.Grade
import woosung.learn.springcorebasics.member.Member

fun main() {
    val appConfig = AppConfig()
    val memberService = appConfig.memberService()
    val member = Member(1L, "A", Grade.VIP)
    memberService.join(member)

    val findMember = memberService.findMember(1L)
    println("new member = ${member.name}")
    println("find member = ${findMember?.name}")
}