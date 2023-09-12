package woosung.learn.springcorebasics

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import woosung.learn.springcorebasics.discount.DiscountPolicy
import woosung.learn.springcorebasics.discount.RateDiscountPolicy
import woosung.learn.springcorebasics.member.MemberRepository
import woosung.learn.springcorebasics.member.MemberService
import woosung.learn.springcorebasics.member.MemberServiceImpl
import woosung.learn.springcorebasics.member.MemoryMemberRepository
import woosung.learn.springcorebasics.order.OrderService
import woosung.learn.springcorebasics.order.OrderServiceImpl

@Configuration
class AppConfig {
    @Bean
    fun memberService(): MemberService = MemberServiceImpl(memberRepository())

    @Bean
    fun orderService(): OrderService = OrderServiceImpl(memberRepository(), discountPolicy())

    @Bean
    fun memberRepository(): MemberRepository = MemoryMemberRepository()

    @Bean
    fun discountPolicy(): DiscountPolicy = RateDiscountPolicy()
}
