package woosung.learn.springcorebasics.member

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import woosung.learn.springcorebasics.AppConfig

class MemberServiceTest : FunSpec() {
    init {
        val appConfig = AppConfig()
        val memberService = appConfig.memberService()

        test("join") {
            val member = Member(1L, "A", Grade.VIP)

            memberService.join(member)
            val findMember = memberService.findMember(1L)

            member shouldBe findMember
        }
    }
}
