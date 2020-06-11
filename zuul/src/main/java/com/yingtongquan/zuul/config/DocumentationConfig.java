package com.yingtongquan.zuul.config;

import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

@Component
@Primary
public class DocumentationConfig implements SwaggerResourcesProvider {
    private final RouteLocator routeLocator;

    public DocumentationConfig(RouteLocator routeLocator) {
        this.routeLocator = routeLocator;
    }



    @Override
    public List<SwaggerResource> get() {
        List resources = new ArrayList<>();
        resources.add(swaggerResource("系统接口", "/system/v2/api-docs", "1.0"));
        resources.add(swaggerResource("员工接口", "/employees/v2/api-docs", "1.0"));
        resources.add(swaggerResource("订单接口", "/order/v2/api-docs", "1.0"));
        resources.add(swaggerResource("地址接口", "/address/v2/api-docs", "1.0"));
        resources.add(swaggerResource("用户接口", "/user/v2/api-docs", "1.0"));
        resources.add(swaggerResource("地址接口", "/startcommon/v2/api-docs", "1.0"));

        return resources;
    }


    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }
}
