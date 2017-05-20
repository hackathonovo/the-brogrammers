
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/penic/Workspace/Intellij/noplaynogain/conf/routes
// @DATE:Sun Apr 09 05:28:01 CEST 2017

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseBTController BTController = new controllers.ReverseBTController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseUsers Users = new controllers.ReverseUsers(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseWebJarAssets WebJarAssets = new controllers.ReverseWebJarAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReversePublic Public = new controllers.ReversePublic(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseBTController BTController = new controllers.javascript.ReverseBTController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseUsers Users = new controllers.javascript.ReverseUsers(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseWebJarAssets WebJarAssets = new controllers.javascript.ReverseWebJarAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReversePublic Public = new controllers.javascript.ReversePublic(RoutesPrefix.byNamePrefix());
  }

}
