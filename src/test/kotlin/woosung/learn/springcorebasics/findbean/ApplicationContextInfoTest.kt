package woosung.learn.springcorebasics.findbean

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import org.springframework.beans.factory.NoSuchBeanDefinitionException
import org.springframework.beans.factory.NoUniqueBeanDefinitionException
import org.springframework.beans.factory.config.BeanDefinition.ROLE_APPLICATION
import org.springframework.beans.factory.getBeansOfType
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import woosung.learn.springcorebasics.AppConfig
import woosung.learn.springcorebasics.discount.DiscountPolicy
import woosung.learn.springcorebasics.discount.FixedDiscountPolicy
import woosung.learn.springcorebasics.discount.RateDiscountPolicy
import woosung.learn.springcorebasics.member.MemberService

class ApplicationContextInfoTest : FunSpec() {
    init {
        val appConfig = AnnotationConfigApplicationContext(AppConfig::class.java)
        val testAppConfig = AnnotationConfigApplicationContext(MultipleBeansConfig::class.java)

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

        test("multiple beans of same type") {
            shouldThrow<NoUniqueBeanDefinitionException> {
                testAppConfig.getBean(DiscountPolicy::class.java)
            }
        }

        test("find bean by name when multiple beans exist") {
            val discountPolicy = testAppConfig.getBean("rateDiscountPolicy", DiscountPolicy::class.java)
            discountPolicy.shouldBeInstanceOf<DiscountPolicy>()
        }

        test("find all beans of type") {
            val beansOfType = testAppConfig.getBeansOfType<DiscountPolicy>()
            println(beansOfType)
            beansOfType.size shouldBe 2
        }
    }
}

@Configuration
private class MultipleBeansConfig {
    @Bean
    fun rateDiscountPolicy(): DiscountPolicy = RateDiscountPolicy()

    @Bean
    fun fixedDiscountPolicy(): DiscountPolicy = FixedDiscountPolicy()
}
