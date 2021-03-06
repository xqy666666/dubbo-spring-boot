package com.xqy.www.dubbo.factory

import com.alibaba.dubbo.config.*
import com.alibaba.dubbo.rpc.service.GenericService
import com.xqy.www.dubbo.service.DubboGenericService
import com.xqy.www.dubbo.utils.*

/**
 * @program: dubbo-spring-boot
 *
 * @description: 用于初始化泛化调用核心类
 *
 * @author: XIEQIONGYU 敲代码的小灰灰
 *
 * @create: 2018-04-14 16:07
 **/
object DubboGenericServiceFactory {


    //懒加载DubboGenericService实例
    private val dubboGenericService:GenericService by lazy {
        DubboGenericService()
    }
    // 该实例很重量，里面封装了所有与注册中心及服务提供方连接，请缓存

    private val serviceConfig:ServiceConfig<GenericService> by lazy {
        ServiceConfig<GenericService>()
    }
    private val applicationConfig:ApplicationConfig by lazy {
        ApplicationConfig().apply {
            name = DUBBO_PROVIDEER_NAME
        }
    }
    private val registryConfig:RegistryConfig by lazy {
        RegistryConfig().apply {
            protocol = PROCOTOL
            address = LOCALHOST
            timeout = TIME_OUT

        }
    }
    private val protocolConfig:ProtocolConfig by lazy {
        ProtocolConfig().apply {
            name = PROTOCOL_NAME
            port = DUBBO_PORT
        }
    }
//    private val providerConfig:ProviderConfig by lazy {
//        ProviderConfig().apply {
//            filter = FILTER
//
//        }
//    }
    fun init(){
        serviceConfig.application = applicationConfig
        serviceConfig.registry = registryConfig
        serviceConfig.protocol = protocolConfig
//        serviceConfig.provider = providerConfig
        // 弱类型接口名
        serviceConfig.`interface` = SUPER_SERVICE
        serviceConfig.version = VERSION
        // 指向一个通用服务实现
        serviceConfig.ref = dubboGenericService

        // 暴露及注册服务
        serviceConfig.export()
    }
}