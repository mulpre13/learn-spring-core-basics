package woosung.learn.springcorebasics.discount

import woosung.learn.springcorebasics.member.Grade
import woosung.learn.springcorebasics.member.Member

class RateDiscountPolicy : DiscountPolicy {
    private val discountPercent = 10
    override fun discount(member: Member, price: Int): Int =
        if (member.grade == Grade.VIP) price * discountPercent / 100 else 0
}
