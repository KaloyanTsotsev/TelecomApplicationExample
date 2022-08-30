package com.example.norcomapllication.config;

import com.example.norcomapllication.service.DeviceService;
import com.example.norcomapllication.service.MobilePlanService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends GlobalMethodSecurityConfiguration {

  private NorcomMethodSecurityExpressionHandler norcomMethodSecurityExpressionHandler;

  @Override
  protected MethodSecurityExpressionHandler createExpressionHandler() {
    return norcomMethodSecurityExpressionHandler;
  }

  @Bean
  public NorcomMethodSecurityExpressionHandler createExpressionHandler(DeviceService deviceService, MobilePlanService mobilePlanService) {
    return new NorcomMethodSecurityExpressionHandler(deviceService, mobilePlanService);
  }
}

