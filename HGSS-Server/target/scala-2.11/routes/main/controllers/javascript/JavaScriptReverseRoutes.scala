
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/penic/Workspace/Intellij/noplaynogain/conf/routes
// @DATE:Sun Apr 09 05:28:01 CEST 2017

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:8
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:8
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def at: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.at",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:21
  class ReverseBTController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:22
    def createTrip: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.BTController.createTrip",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "createtrip"})
        }
      """
    )
  
    // @LINE:21
    def trips: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.BTController.trips",
      """
        function(from0,to1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "trips" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("from", from0), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("to", to1)])})
        }
      """
    )
  
    // @LINE:23
    def saveTrip: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.BTController.saveTrip",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "saveTrip"})
        }
      """
    )
  
  }

  // @LINE:13
  class ReverseUsers(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def profile: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Users.profile",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "profile"})
        }
      """
    )
  
    // @LINE:13
    def logout: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Users.logout",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
        }
      """
    )
  
  }

  // @LINE:9
  class ReverseWebJarAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def at: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.WebJarAssets.at",
      """
        function(file0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "webjars/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file0)})
        }
      """
    )
  
  }

  // @LINE:11
  class ReversePublic(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:17
    def notAuthLoginForm: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Public.notAuthLoginForm",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
    // @LINE:15
    def landing: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Public.landing",
      """
        function() {
        
          if (true) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "landing"})
          }
        
        }
      """
    )
  
    // @LINE:16
    def loginForm: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Public.loginForm",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
    // @LINE:12
    def register: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Public.register",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "register"})
        }
      """
    )
  
    // @LINE:11
    def registerForm: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Public.registerForm",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "register"})
        }
      """
    )
  
    // @LINE:18
    def login: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Public.login",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
        }
      """
    )
  
  }


}
