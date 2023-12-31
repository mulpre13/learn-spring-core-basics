package woosung.learn.springcorebasics.discount

import woosung.learn.springcorebasics.member.Member

interface DiscountPolicy {
    /**
     * @return price to be extracted(discounted)
     */
    fun discount(member: Member, price: Int): Int
}