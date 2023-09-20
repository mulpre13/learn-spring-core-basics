package woosung.learn.springcorebasics.singleton

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.types.shouldBeSameInstanceAs
import io.kotest.matchers.types.shouldNotBeSameInstanceAs
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import woosung.learn.springcorebasics.AppConfig
import woosung.learn.springcorebasics.member.MemberService

class SingletonTest : FunSpec() {
    init {
        test("DI Container without Spring") {
            val appConfig = AppConfig()

            val memberService1 = appConfig.memberService()
            val memberService2 = appConfig.memberService()

            memberService1 shouldNotBeSameInstanceAs memberService2
        }

        test("Singleton Objects") {
            val service1 = SingletonService
            val service2 = SingletonService

            service1 shouldBeSameInstanceAs service2
        }

        test("Spring container") {
            val appConfig = AnnotationConfigApplicationContext(AppConfig::class.java)

            val memberService1 = appConfig.getBean("memberService", MemberService::class.java)
            val memberService2 = appConfig.getBean("memberService", MemberService::class.java)

            memberService1 shouldBeSameInstanceAs memberService2
        }
    }
}
