package sgu.hrm;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
        name = "Bearer Authentication",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
public class Swagger {
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")
                .packagesToScan(
                        "sgu.hrm.module_heso_luong_ngach.controllers",
                        "sgu.hrm.module_security",
                        "sgu.hrm.module_soyeulylich.controllers",
                        "sgu.hrm.module_soyeulylich_chitiet.controllers",
                        "sgu.hrm.module_taikhoan.controller",
                        "sgu.hrm.module_utilities.controllers"
                )
                .build();
    }
}
