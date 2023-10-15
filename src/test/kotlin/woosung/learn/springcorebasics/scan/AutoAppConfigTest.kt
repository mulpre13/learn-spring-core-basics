package woosung.learn.springcorebasics.scan

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.types.shouldBeSameInstanceAs
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import woosung.learn.springcorebasics.AutoAppConfig
import woosung.learn.springcorebasics.member.MemberService

class AutoAppConfigTest : FunSpec() {
    init {
        test("test scan") {
            val appContext = AnnotationConfigApplicationContext(AutoAppConfig::class.java)

            val memberService = appContext.getBean(MemberService::class.java)
            memberService shouldBeSameInstanceAs MemberService::class.java
        }
    }
}