package woosung.learn.springcorebasics

import woosung.learn.springcorebasics.member.Grade
import woosung.learn.springcorebasics.member.Member
import woosung.learn.springcorebasics.order.Order

fun main() {
    val appConfig = AppConfig()
    val memberService = appConfig.memberService()
    val orderService = appConfig.orderService()

    val memberId = 1L
    val member = Member(memberId, "memberA", Grade.VIP)
    memberService.join(member)

    val order: Order = orderService.createOrder(memberId, "itemA", 10000)

    println("order = $order")
    println("order.finalPrice = ${order.finalPrice}")
}
