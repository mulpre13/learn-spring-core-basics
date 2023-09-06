package woosung.learn.springcorebasics.member

interface MemberRepository {
    fun save(member: Member)
    fun findById(id: Long): Member?
}
