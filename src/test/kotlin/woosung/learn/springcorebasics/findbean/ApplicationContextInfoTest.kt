package woosung.learn.springcorebasics.findbean

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.types.shouldBeInstanceOf
import org.springframework.beans.factory.NoSuchBeanDefinitionException
import org.springframework.beans.factory.config.BeanDefinition.ROLE_APPLICATION
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import woosung.learn.springcorebasics.AppConfig
import woosung.learn.springcorebasics.member.MemberService

class ApplicationContextInfoTest : FunSpec() {
    init {
        val appConfig = AnnotationConfigApplicationContext(AppConfig::class.java)

        test("print all bean") {
            val definedBeans = appConfig.beanDefinitionNames
            definedBeans.forEach { println("name: $it, object: ${appConfig.getBean(it)}") }
        }

        test("print application bean") {
            val beanNames = appConfig.beanDefinitionNames
            beanNames.filter { appConfig.getBeanDefinition(it).role == ROLE_APPLICATION }.forEach {
                println("name: $it, object: ${appConfig.getBean(it)}")
            }
        }

        test("find bean by name") {
            val memberService: MemberService = appConfig.getBean("memberService", MemberService::class.java)
            memberService.shouldBeInstanceOf<MemberService>()
        }

        test("find bean by type") {
            val memberService: MemberService = appConfig.getBean(MemberService::class.java)
            memberService.shouldBeInstanceOf<MemberService>()
        }

        test("unable to find bean by name") {
            shouldThrow<NoSuchBeanDefinitionException> {
                appConfig.getBean(
                    "unexisting bean", MemberService::class.java
                )
            }
        }
    }
}
