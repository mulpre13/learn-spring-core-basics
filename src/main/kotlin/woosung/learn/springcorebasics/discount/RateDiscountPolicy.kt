package woosung.learn.springcorebasics.discount

import org.springframework.stereotype.Component
import woosung.learn.springcorebasics.member.Grade
import woosung.learn.springcorebasics.member.Member

@Component
class RateDiscountPolicy : DiscountPolicy {
    private val discountPercent = 10
    override fun discount(member: Member, price: Int): Int =
        if (member.grade == Grade.VIP) price * discountPercent / 100 else 0
}
