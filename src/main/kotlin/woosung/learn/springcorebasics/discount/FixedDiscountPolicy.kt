package woosung.learn.springcorebasics.discount

import woosung.learn.springcorebasics.member.Grade
import woosung.learn.springcorebasics.member.Member

class FixedDiscountPolicy : DiscountPolicy {
    private val fixedDiscount: Int = 1000

    override fun discount(member: Member, price: Int): Int {
        return if (member.grade == Grade.VIP) fixedDiscount else 0
    }

}