package com.xqy.www.producerimport com.xqy.www.domain.Boyimport com.xqy.www.dubbo.factory.DubboGenericServiceFactoryimport com.xqy.www.dubbo.manager.DubboServiceManagerimport com.xqy.www.dubbo.service.SuperServiceimport com.xqy.www.producer.ProducerApplication.Companion.producerContextimport org.mybatis.spring.annotation.MapperScanimport org.slf4j.Loggerimport org.slf4j.LoggerFactoryimport org.springframework.boot.autoconfigure.SpringBootApplicationimport org.springframework.boot.runApplicationimport org.springframework.context.ConfigurableApplicationContext@SpringBootApplication@MapperScan("com.xqy.www.mybatis.mapper")class ProducerApplication {    companion object {        lateinit var producerContext: ConfigurableApplicationContext    }}private val logger: Logger by lazy {    LoggerFactory.getLogger(ProducerApplication::class.java)}fun main(args: Array<String>) {    producerContext = runApplication<ProducerApplication>(*args)    DubboGenericServiceFactory.init()    val map = producerContext.getBeansOfType(SuperService::class.java)    map.forEach { t, u ->        DubboServiceManager.saveService(t, u)    }    logger.debug("provider 服务配置注册成功")    logger.debug("Provider 服务启动 ^_^")    try {        System.`in`.read()    } catch (e: Exception) {        e.printStackTrace()    }}