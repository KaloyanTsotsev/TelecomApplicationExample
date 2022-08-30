package com.example.norcomapllication.config;

import com.example.norcomapllication.service.DeviceService;
import com.example.norcomapllication.service.MobilePlanService;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

public class OwnerSecurityExpressionRoot extends SecurityExpressionRoot implements
    MethodSecurityExpressionOperations {

  private Object filterObject;
  private Object returnObject;
  private DeviceService deviceService;
  private MobilePlanService mobilePlanService;

  /**
   * Creates a new instance
   *
   * @param authentication the {@link Authentication} to use. Cannot be null.
   */
  public OwnerSecurityExpressionRoot(Authentication authentication) {
    super(authentication);
  }


  public boolean isOwner(Long id) {
    String userName = currentUsername();
    if (userName != null) {
      return deviceService.isOwner(userName, id) || mobilePlanService.isOwner(userName,id);
    }

    return false;
  }

  public String currentUsername() {
    Authentication auth = getAuthentication();
    if (auth.getPrincipal() instanceof UserDetails) {
      return ((UserDetails)auth.getPrincipal()).getUsername();
    }
    return null;
  }

  @Override
  public void setFilterObject(Object filterObject) {
    this.filterObject = filterObject;
  }

  @Override
  public Object getFilterObject() {
    return filterObject;
  }

  @Override
  public void setReturnObject(Object returnObject) {
    this.returnObject = returnObject;
  }

  @Override
  public Object getReturnObject() {
    return returnObject;
  }

  @Override
  public Object getThis() {
    return this;
  }

  public void setDeviceService(DeviceService deviceService) {
    this.deviceService=deviceService;
  }
}
