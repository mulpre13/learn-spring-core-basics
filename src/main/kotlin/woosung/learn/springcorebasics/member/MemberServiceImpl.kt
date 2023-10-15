package woosung.learn.springcorebasics.member

import org.springframework.stereotype.Component

@Component
class MemberServiceImpl(private val memberRepository: MemberRepository) : MemberService {
    override fun join(member: Member) {
        memberRepository.save(member)
    }

    override fun findMember(memberId: Long): Member? = memberRepository.findById(memberId)
}
