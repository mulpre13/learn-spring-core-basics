package woosung.learn.springcorebasics.member

interface MemberService {
    fun join(member: Member)
    fun findMember(memberId: Long): Member?
}