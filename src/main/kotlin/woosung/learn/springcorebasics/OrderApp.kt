package woosung.learn.springcorebasics

import org.springframework.context.annotation.AnnotationConfigApplicationContext
import woosung.learn.springcorebasics.member.Grade
import woosung.learn.springcorebasics.member.Member
import woosung.learn.springcorebasics.member.MemberService
import woosung.learn.springcorebasics.order.Order
import woosung.learn.springcorebasics.order.OrderService

fun main() {
    AnnotationConfigApplicationContext(AppConfig::class.java).apply(fun AnnotationConfigApplicationContext.() {
        val memberService = getBean("memberService", MemberService::class.java)
        val orderService = getBean("orderService", OrderService::class.java)

        val memberId = 1L
        val member = Member(memberId, "memberA", Grade.VIP)
        memberService.join(member)

        val order: Order = orderService.createOrder(memberId, "itemA", 10000)

        println("order = $order")
        println("order.finalPrice = ${order.finalPrice}")
    })
}
