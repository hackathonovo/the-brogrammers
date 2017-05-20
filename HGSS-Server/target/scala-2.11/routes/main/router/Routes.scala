
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/penic/Workspace/Intellij/noplaynogain/conf/routes
// @DATE:Sun Apr 09 05:28:01 CEST 2017

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:8
  Assets_3: controllers.Assets,
  // @LINE:9
  WebJarAssets_4: controllers.WebJarAssets,
  // @LINE:11
  Public_2: controllers.Public,
  // @LINE:13
  Users_0: controllers.Users,
  // @LINE:21
  BTController_1: controllers.BTController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:8
    Assets_3: controllers.Assets,
    // @LINE:9
    WebJarAssets_4: controllers.WebJarAssets,
    // @LINE:11
    Public_2: controllers.Public,
    // @LINE:13
    Users_0: controllers.Users,
    // @LINE:21
    BTController_1: controllers.BTController
  ) = this(errorHandler, Assets_3, WebJarAssets_4, Public_2, Users_0, BTController_1, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Assets_3, WebJarAssets_4, Public_2, Users_0, BTController_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.at(path:String = "/public", file:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """webjars/""" + "$" + """file<.+>""", """controllers.WebJarAssets.at(file:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """register""", """controllers.Public.registerForm()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """register""", """controllers.Public.register()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """logout""", """controllers.Users.logout()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """profile""", """controllers.Users.profile()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """landing""", """controllers.Public.landing()"""),
    ("""GET""", this.prefix, """controllers.Public.loginForm()"""),
    ("""GET""", this.prefix, """controllers.Public.notAuthLoginForm()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.Public.login()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """landing""", """controllers.Public.landing()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """trips""", """controllers.BTController.trips(from:String, to:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """createtrip""", """controllers.BTController.createTrip()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """saveTrip""", """controllers.BTController.saveTrip()"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:8
  private[this] lazy val controllers_Assets_at0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at0_invoker = createInvoker(
    Assets_3.at(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      """ Map static resources from the /public folder to the /assets URL path""",
      this.prefix + """assets/""" + "$" + """file<.+>"""
    )
  )

  // @LINE:9
  private[this] lazy val controllers_WebJarAssets_at1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("webjars/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_WebJarAssets_at1_invoker = createInvoker(
    WebJarAssets_4.at(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.WebJarAssets",
      "at",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """webjars/""" + "$" + """file<.+>"""
    )
  )

  // @LINE:11
  private[this] lazy val controllers_Public_registerForm2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("register")))
  )
  private[this] lazy val controllers_Public_registerForm2_invoker = createInvoker(
    Public_2.registerForm(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Public",
      "registerForm",
      Nil,
      "GET",
      """""",
      this.prefix + """register"""
    )
  )

  // @LINE:12
  private[this] lazy val controllers_Public_register3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("register")))
  )
  private[this] lazy val controllers_Public_register3_invoker = createInvoker(
    Public_2.register(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Public",
      "register",
      Nil,
      "POST",
      """""",
      this.prefix + """register"""
    )
  )

  // @LINE:13
  private[this] lazy val controllers_Users_logout4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("logout")))
  )
  private[this] lazy val controllers_Users_logout4_invoker = createInvoker(
    Users_0.logout(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Users",
      "logout",
      Nil,
      "GET",
      """""",
      this.prefix + """logout"""
    )
  )

  // @LINE:14
  private[this] lazy val controllers_Users_profile5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("profile")))
  )
  private[this] lazy val controllers_Users_profile5_invoker = createInvoker(
    Users_0.profile(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Users",
      "profile",
      Nil,
      "GET",
      """""",
      this.prefix + """profile"""
    )
  )

  // @LINE:15
  private[this] lazy val controllers_Public_landing6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("landing")))
  )
  private[this] lazy val controllers_Public_landing6_invoker = createInvoker(
    Public_2.landing(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Public",
      "landing",
      Nil,
      "GET",
      """""",
      this.prefix + """landing"""
    )
  )

  // @LINE:16
  private[this] lazy val controllers_Public_loginForm7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_Public_loginForm7_invoker = createInvoker(
    Public_2.loginForm(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Public",
      "loginForm",
      Nil,
      "GET",
      """""",
      this.prefix + """"""
    )
  )

  // @LINE:17
  private[this] lazy val controllers_Public_notAuthLoginForm8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_Public_notAuthLoginForm8_invoker = createInvoker(
    Public_2.notAuthLoginForm(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Public",
      "notAuthLoginForm",
      Nil,
      "GET",
      """""",
      this.prefix + """"""
    )
  )

  // @LINE:18
  private[this] lazy val controllers_Public_login9_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_Public_login9_invoker = createInvoker(
    Public_2.login(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Public",
      "login",
      Nil,
      "POST",
      """""",
      this.prefix + """login"""
    )
  )

  // @LINE:20
  private[this] lazy val controllers_Public_landing10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("landing")))
  )
  private[this] lazy val controllers_Public_landing10_invoker = createInvoker(
    Public_2.landing(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Public",
      "landing",
      Nil,
      "GET",
      """""",
      this.prefix + """landing"""
    )
  )

  // @LINE:21
  private[this] lazy val controllers_BTController_trips11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("trips")))
  )
  private[this] lazy val controllers_BTController_trips11_invoker = createInvoker(
    BTController_1.trips(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.BTController",
      "trips",
      Seq(classOf[String], classOf[String]),
      "GET",
      """""",
      this.prefix + """trips"""
    )
  )

  // @LINE:22
  private[this] lazy val controllers_BTController_createTrip12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("createtrip")))
  )
  private[this] lazy val controllers_BTController_createTrip12_invoker = createInvoker(
    BTController_1.createTrip(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.BTController",
      "createTrip",
      Nil,
      "GET",
      """""",
      this.prefix + """createtrip"""
    )
  )

  // @LINE:23
  private[this] lazy val controllers_BTController_saveTrip13_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("saveTrip")))
  )
  private[this] lazy val controllers_BTController_saveTrip13_invoker = createInvoker(
    BTController_1.saveTrip(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.BTController",
      "saveTrip",
      Nil,
      "POST",
      """""",
      this.prefix + """saveTrip"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:8
    case controllers_Assets_at0_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at0_invoker.call(Assets_3.at(path, file))
      }
  
    // @LINE:9
    case controllers_WebJarAssets_at1_route(params) =>
      call(params.fromPath[String]("file", None)) { (file) =>
        controllers_WebJarAssets_at1_invoker.call(WebJarAssets_4.at(file))
      }
  
    // @LINE:11
    case controllers_Public_registerForm2_route(params) =>
      call { 
        controllers_Public_registerForm2_invoker.call(Public_2.registerForm())
      }
  
    // @LINE:12
    case controllers_Public_register3_route(params) =>
      call { 
        controllers_Public_register3_invoker.call(Public_2.register())
      }
  
    // @LINE:13
    case controllers_Users_logout4_route(params) =>
      call { 
        controllers_Users_logout4_invoker.call(Users_0.logout())
      }
  
    // @LINE:14
    case controllers_Users_profile5_route(params) =>
      call { 
        controllers_Users_profile5_invoker.call(Users_0.profile())
      }
  
    // @LINE:15
    case controllers_Public_landing6_route(params) =>
      call { 
        controllers_Public_landing6_invoker.call(Public_2.landing())
      }
  
    // @LINE:16
    case controllers_Public_loginForm7_route(params) =>
      call { 
        controllers_Public_loginForm7_invoker.call(Public_2.loginForm())
      }
  
    // @LINE:17
    case controllers_Public_notAuthLoginForm8_route(params) =>
      call { 
        controllers_Public_notAuthLoginForm8_invoker.call(Public_2.notAuthLoginForm())
      }
  
    // @LINE:18
    case controllers_Public_login9_route(params) =>
      call { 
        controllers_Public_login9_invoker.call(Public_2.login())
      }
  
    // @LINE:20
    case controllers_Public_landing10_route(params) =>
      call { 
        controllers_Public_landing10_invoker.call(Public_2.landing())
      }
  
    // @LINE:21
    case controllers_BTController_trips11_route(params) =>
      call(params.fromQuery[String]("from", None), params.fromQuery[String]("to", None)) { (from, to) =>
        controllers_BTController_trips11_invoker.call(BTController_1.trips(from, to))
      }
  
    // @LINE:22
    case controllers_BTController_createTrip12_route(params) =>
      call { 
        controllers_BTController_createTrip12_invoker.call(BTController_1.createTrip())
      }
  
    // @LINE:23
    case controllers_BTController_saveTrip13_route(params) =>
      call { 
        controllers_BTController_saveTrip13_invoker.call(BTController_1.saveTrip())
      }
  }
}
