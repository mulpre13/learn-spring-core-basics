package woosung.learn.springcorebasics.order

import woosung.learn.springcorebasics.discount.DiscountPolicy
import woosung.learn.springcorebasics.member.Member
import woosung.learn.springcorebasics.member.MemberRepository

class OrderServiceImpl(
    private val memberRepository: MemberRepository, private val discountPolicy: DiscountPolicy
) : OrderService {

    override fun createOrder(memberId: Long, itemName: String, itemPrice: Int): Order {
        val member: Member = memberRepository.findById(memberId)!!
        val discountPrice: Int = discountPolicy.discount(member, itemPrice)

        return Order(memberId, itemName, itemPrice, discountPrice)
    }
}
