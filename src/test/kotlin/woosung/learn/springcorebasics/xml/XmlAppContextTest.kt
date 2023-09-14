package woosung.learn.springcorebasics.xml

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.types.shouldBeInstanceOf
import org.springframework.context.support.GenericXmlApplicationContext
import woosung.learn.springcorebasics.member.MemberService

class XmlAppContextTest : FunSpec() {
    init {
        test("xml") {
            val appContext = GenericXmlApplicationContext("appConfig.xml")
            val memberService = appContext.getBean("memberService", MemberService::class.java)
            memberService.shouldBeInstanceOf<MemberService>()
        }
    }
}