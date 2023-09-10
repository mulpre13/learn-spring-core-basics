package woosung.learn.springcorebasics.order

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import woosung.learn.springcorebasics.AppConfig
import woosung.learn.springcorebasics.member.Grade
import woosung.learn.springcorebasics.member.Member

class OrderServiceTest : FunSpec() {
    init {
        val appConfig = AppConfig()
        val memberService = appConfig.memberService()
        val orderService = appConfig.orderService()

        test("createOrder") {
            val memberId = 1L
            val member = Member(memberId, "memberA", Grade.VIP)
            memberService.join(member)

            val order = orderService.createOrder(memberId, "itemA", 10000)
            order.discountPrice shouldBe 1000
        }
    }
}