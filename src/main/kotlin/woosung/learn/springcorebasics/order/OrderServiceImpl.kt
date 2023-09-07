package woosung.learn.springcorebasics.order

import woosung.learn.springcorebasics.discount.FixedDiscountPolicy
import woosung.learn.springcorebasics.member.Member
import woosung.learn.springcorebasics.member.MemoryMemberRepository

class OrderServiceImpl : OrderService {
    private val memberRepository = MemoryMemberRepository()
    private val discountPolicy = FixedDiscountPolicy()

    override fun createOrder(memberId: Long, itemName: String, itemPrice: Int): Order {
        val member: Member = memberRepository.findById(memberId)!!
        val discountPrice: Int = discountPolicy.discount(member, itemPrice)

        return Order(memberId, itemName, itemPrice, discountPrice)
    }
}