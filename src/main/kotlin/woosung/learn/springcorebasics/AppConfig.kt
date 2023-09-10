package woosung.learn.springcorebasics

import woosung.learn.springcorebasics.discount.RateDiscountPolicy
import woosung.learn.springcorebasics.member.MemberService
import woosung.learn.springcorebasics.member.MemberServiceImpl
import woosung.learn.springcorebasics.member.MemoryMemberRepository
import woosung.learn.springcorebasics.order.OrderService
import woosung.learn.springcorebasics.order.OrderServiceImpl

class AppConfig {
    fun memberService(): MemberService = MemberServiceImpl(MemoryMemberRepository())
    fun orderService(): OrderService = OrderServiceImpl(MemoryMemberRepository(), RateDiscountPolicy())
}