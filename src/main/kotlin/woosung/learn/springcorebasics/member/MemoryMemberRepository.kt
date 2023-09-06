package woosung.learn.springcorebasics.member

private val store: MutableMap<Long, Member> = mutableMapOf()

class MemoryMemberRepository : MemberRepository {

    override fun save(member: Member) {
        store.put(member.id, member)
    }

    override fun findById(id: Long): Member? = store[id]
}