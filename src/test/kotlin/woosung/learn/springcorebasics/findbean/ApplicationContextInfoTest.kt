package woosung.learn.springcorebasics.findbean

import io.kotest.core.spec.style.FunSpec
import org.springframework.beans.factory.config.BeanDefinition.ROLE_APPLICATION
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import woosung.learn.springcorebasics.AppConfig

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
    }
}