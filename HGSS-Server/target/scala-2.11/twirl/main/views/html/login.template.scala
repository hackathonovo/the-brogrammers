
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object login_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._

class login extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Form[BTUser],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(userForm: Form[BTUser]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.26*/("""

"""),_display_(/*3.2*/main("Login")/*3.15*/ {_display_(Seq[Any](format.raw/*3.17*/("""

  """),format.raw/*5.3*/("""<div class="window"><h1 class="text-center horizontalLine"><span>Login</span></h1>
    <div class="col-4-md col-md-offset-5">
        """),_display_(/*7.10*/helper/*7.16*/.form(action=routes.Public.login())/*7.51*/ {_display_(Seq[Any](format.raw/*7.53*/("""
          """),format.raw/*8.11*/("""<fieldset class="separate">
            """),_display_(/*9.14*/helper/*9.20*/.inputText(userForm("username"), '_showConstraints -> false, '_showErrors -> false)),format.raw/*9.103*/("""
            """),_display_(/*10.14*/helper/*10.20*/.inputPassword(userForm("password"), '_showConstraints -> false, '_showErrors -> false)),format.raw/*10.107*/("""
          """),format.raw/*11.11*/("""</fieldset>
          <button type="submit" class="btn btn-primary"> Login </button>
          <a class="btn btn-primary" href=""""),_display_(/*13.45*/routes/*13.51*/.Public.registerForm()),format.raw/*13.73*/(""""> Register </a>
        """)))}),format.raw/*14.10*/("""
    """),format.raw/*15.5*/("""</div>
  </div>

""")))}),format.raw/*18.2*/("""
"""))
      }
    }
  }

  def render(userForm:Form[BTUser]): play.twirl.api.HtmlFormat.Appendable = apply(userForm)

  def f:((Form[BTUser]) => play.twirl.api.HtmlFormat.Appendable) = (userForm) => apply(userForm)

  def ref: this.type = this

}


}

/**/
object login extends login_Scope0.login
              /*
                  -- GENERATED --
                  DATE: Sun Apr 09 03:30:50 CEST 2017
                  SOURCE: /home/penic/Workspace/Intellij/noplaynogain/app/views/login.scala.html
                  HASH: ce1f14976e2f40d71d83051809c1cef124cc86aa
                  MATRIX: 751->1|870->25|898->28|919->41|958->43|988->47|1149->182|1163->188|1206->223|1245->225|1283->236|1350->277|1364->283|1468->366|1509->380|1524->386|1633->473|1672->484|1828->613|1843->619|1886->641|1943->667|1975->672|2023->690
                  LINES: 27->1|32->1|34->3|34->3|34->3|36->5|38->7|38->7|38->7|38->7|39->8|40->9|40->9|40->9|41->10|41->10|41->10|42->11|44->13|44->13|44->13|45->14|46->15|49->18
                  -- GENERATED --
              */
          