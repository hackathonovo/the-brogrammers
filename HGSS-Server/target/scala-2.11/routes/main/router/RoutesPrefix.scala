
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/penic/Workspace/Intellij/noplaynogain/conf/routes
// @DATE:Sun Apr 09 05:28:01 CEST 2017


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
