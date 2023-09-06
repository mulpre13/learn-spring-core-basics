package woosung.learn.springcorebasics

import woosung.learn.springcorebasics.member.Grade
import woosung.learn.springcorebasics.member.Member
import woosung.learn.springcorebasics.member.MemberServiceImpl

class MemberApp {
    fun main(args: List<String>) {
        val memberService = MemberServiceImpl()
        val member = Member(1L, "A", Grade.VIP)
        memberService.join(member)

        val findMember = memberService.findMember(1L)
        println("new member = ${member.name}")
        println("find member = ${findMember?.name}")
    }
}