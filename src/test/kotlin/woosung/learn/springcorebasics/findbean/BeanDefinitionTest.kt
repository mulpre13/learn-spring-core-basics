package woosung.learn.springcorebasics.findbean

import io.kotest.core.spec.style.FunSpec
import org.springframework.beans.factory.config.BeanDefinition.ROLE_APPLICATION
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import woosung.learn.springcorebasics.AppConfig

class BeanDefinitionTest : FunSpec() {
    init {
        val appConfig = AnnotationConfigApplicationContext(AppConfig::class.java)

        test("bean definition") {
            val beanNames = appConfig.beanDefinitionNames
            beanNames.forEach {
                val beanDefinition = appConfig.getBeanDefinition(it)
                if (beanDefinition.role == ROLE_APPLICATION) {
                    println("name $it | bean $beanDefinition")
                }
            }
        }
    }
}