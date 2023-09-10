package woosung.learn.springcorebasics.discount

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import woosung.learn.springcorebasics.member.Grade
import woosung.learn.springcorebasics.member.Member

class RateDiscountPolicyTest : FunSpec({
    val discountPolicy: DiscountPolicy = RateDiscountPolicy()

    test("10% discount for VIP") {
        // given
        val member = Member(1L, "memberVIP", Grade.VIP)
        // when
        val discount = discountPolicy.discount(member, 10000)
        // then
        discount shouldBe 1000
    }

    test("no discount for non-VIPs") {
        // given
        val member = Member(1L, "memberBASIC", Grade.BASIC)
        // when
        val discount = discountPolicy.discount(member, 10000)
        // then
        discount shouldBe 0
    }
})
