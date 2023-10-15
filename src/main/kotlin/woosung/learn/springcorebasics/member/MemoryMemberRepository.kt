package woosung.learn.springcorebasics.member

import org.springframework.stereotype.Component

private val store: MutableMap<Long, Member> = mutableMapOf()

@Component
class MemoryMemberRepository : MemberRepository {

    override fun save(member: Member) {
        store.put(member.id, member)
    }

    override fun findById(id: Long): Member? = store[id]
}