package com.example.norcomapllication.config;

import com.example.norcomapllication.service.DeviceService;
import com.example.norcomapllication.service.MobilePlanService;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.Authentication;

public class NorcomMethodSecurityExpressionHandler extends
    DefaultMethodSecurityExpressionHandler {
  private final DeviceService deviceService;
  private final MobilePlanService mobilePlanService;


  public NorcomMethodSecurityExpressionHandler(DeviceService deviceService, MobilePlanService mobilePlanService) {
    this.deviceService = deviceService;
    this.mobilePlanService = mobilePlanService;
  }

  @Override
  protected MethodSecurityExpressionOperations createSecurityExpressionRoot(
      Authentication authentication, MethodInvocation invocation) {
    OwnerSecurityExpressionRoot root = new OwnerSecurityExpressionRoot(authentication);
    root.setDeviceService(deviceService);
    root.setPermissionEvaluator(getPermissionEvaluator());
    root.setTrustResolver(new AuthenticationTrustResolverImpl());
    root.setRoleHierarchy(getRoleHierarchy());

    return root;

  }
}
