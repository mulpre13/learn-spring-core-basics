package woosung.learn.springcorebasics.member

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class MemberServiceTest : FunSpec() {
    init {
        val memberService = MemberServiceImpl()

        test("join") {
            val member = Member(1L, "A", Grade.VIP)

            memberService.join(member)
            val findMember = memberService.findMember(1L)

            member shouldBe findMember
        }
    }
}
