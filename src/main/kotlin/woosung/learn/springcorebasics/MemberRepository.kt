package woosung.learn.springcorebasics

interface MemberRepository {
    fun save(member: Member)
    fun findById(id: Long): Member?
}
