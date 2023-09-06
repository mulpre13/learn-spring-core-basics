package woosung.learn.springcorebasics


class MemberServiceImpl : MemberService {
    private val memberRepository: MemberRepository = MemoryMemberRepository()

    override fun join(member: Member) {
        memberRepository.save(member)
    }

    override fun findMember(memberId: Long): Member? = memberRepository.findById(memberId)
}
