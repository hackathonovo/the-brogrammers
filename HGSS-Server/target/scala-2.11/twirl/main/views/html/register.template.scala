
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object register_Scope0 {
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

class register extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Form[BTUser],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(userForm: Form[BTUser]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.26*/("""

"""),_display_(/*3.2*/main("Student form")/*3.22*/ {_display_(Seq[Any](format.raw/*3.24*/("""
  """),format.raw/*4.3*/("""<div class="window">
      <h1 class="horizontalLine text-center"><span>Register</span></h1>
    <div class="col-4-md col-md-offset-5">
      """),_display_(/*7.8*/helper/*7.14*/.form(action = routes.Public.register())/*7.54*/ {_display_(Seq[Any](format.raw/*7.56*/("""
        """),format.raw/*8.9*/("""<fieldset class="separate">
          <input type="hidden" value=""""),_display_(/*9.40*/userForm("id")/*9.54*/.valueOr("")),format.raw/*9.66*/("""" name="id" />
          """),_display_(/*10.12*/helper/*10.18*/.inputText(userForm("username"), '_label -> "Username", '_showConstraints -> false, '_showErrors -> false)),format.raw/*10.124*/("""
          """),_display_(/*11.12*/helper/*11.18*/.inputPassword(userForm("password"), '_label -> "Password", '_showConstraints -> false, '_showErrors -> false)),format.raw/*11.128*/("""
          """),_display_(/*12.12*/helper/*12.18*/.inputText(userForm("firstName"), '_label -> "Name", '_showConstraints -> false, '_showErrors -> false)),format.raw/*12.121*/("""
          """),_display_(/*13.12*/helper/*13.18*/.inputText(userForm("lastName"), '_label -> "Surname", '_showConstraints -> false, '_showErrors -> false)),format.raw/*13.123*/("""
          """),_display_(/*14.12*/helper/*14.18*/.inputText(userForm("country"), '_label -> "Country", '_showConstraints -> false, '_showErrors -> false)),format.raw/*14.122*/("""
          """),_display_(/*15.12*/helper/*15.18*/.inputDate(userForm("birth"), '_label -> "Birtdate", '_showConstraints -> false, '_showErrors -> false)),format.raw/*15.121*/("""

        """),format.raw/*17.9*/("""</fieldset>
        <button type="submit" class="btn btn-primary">
          <i class="glyphicon glyphicon-ok"></i> Save
        </button>
        <a class="btn btn-primary" href=""""),_display_(/*21.43*/routes/*21.49*/.Public.landing()),format.raw/*21.66*/(""""><i class="glyphicon glyphicon-remove"></i> Cancel</a>
      """)))}),format.raw/*22.8*/("""
    """),format.raw/*23.5*/("""</div>
  </div>


""")))}))
      }
    }
  }

  def render(userForm:Form[BTUser]): play.twirl.api.HtmlFormat.Appendable = apply(userForm)

  def f:((Form[BTUser]) => play.twirl.api.HtmlFormat.Appendable) = (userForm) => apply(userForm)

  def ref: this.type = this

}


}

/**/
object register extends register_Scope0.register
              /*
                  -- GENERATED --
                  DATE: Sun Apr 09 05:28:02 CEST 2017
                  SOURCE: /home/penic/Workspace/Intellij/noplaynogain/app/views/register.scala.html
                  HASH: 4bc5670be1d0044d9e4f04a1c4f2fe935c7c5aa8
                  MATRIX: 757->1|876->25|904->28|932->48|971->50|1000->53|1168->196|1182->202|1230->242|1269->244|1304->253|1397->320|1419->334|1451->346|1504->372|1519->378|1647->484|1686->496|1701->502|1833->612|1872->624|1887->630|2012->733|2051->745|2066->751|2193->856|2232->868|2247->874|2373->978|2412->990|2427->996|2552->1099|2589->1109|2797->1290|2812->1296|2850->1313|2943->1376|2975->1381
                  LINES: 27->1|32->1|34->3|34->3|34->3|35->4|38->7|38->7|38->7|38->7|39->8|40->9|40->9|40->9|41->10|41->10|41->10|42->11|42->11|42->11|43->12|43->12|43->12|44->13|44->13|44->13|45->14|45->14|45->14|46->15|46->15|46->15|48->17|52->21|52->21|52->21|53->22|54->23
                  -- GENERATED --
              */
          