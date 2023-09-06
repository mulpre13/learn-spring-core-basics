package woosung.learn.springcorebasics

interface MemberService {
    fun join(member: Member)
    fun findMember(memberId: Long): Member?
}