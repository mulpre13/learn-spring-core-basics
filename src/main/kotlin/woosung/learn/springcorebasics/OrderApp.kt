package woosung.learn.springcorebasics

import woosung.learn.springcorebasics.member.Grade
import woosung.learn.springcorebasics.member.Member
import woosung.learn.springcorebasics.member.MemberServiceImpl
import woosung.learn.springcorebasics.order.Order
import woosung.learn.springcorebasics.order.OrderServiceImpl

fun main() {
    val memberService = MemberServiceImpl()
    val orderService = OrderServiceImpl()

    val memberId = 1L
    val member = Member(memberId, "memberA", Grade.VIP)
    memberService.join(member)

    val order: Order = orderService.createOrder(memberId, "itemA", 10000)

    println("order = $order")
    println("order.finalPrice = ${order.finalPrice}")
}
