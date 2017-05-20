
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object navigation_Scope0 {
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

class navigation extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.4*/("""

"""),format.raw/*3.1*/("""<div class="navbar navbar-inverse" id="mynavbar">
    <div class="containter">
        """),format.raw/*5.62*/("""
        """),format.raw/*6.9*/("""<div class="navbar-header">
            <a class="navbar-brand" href=""""),_display_(/*7.44*/routes/*7.50*/.Public.landing()),format.raw/*7.67*/(""""> Boaty </a>
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <!--defines these button which appears on xs devices, icon bar is line on the button-->
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav navbar-left">
            """),_display_(/*18.14*/if(controllers.Users.currentUser() != null)/*18.57*/ {_display_(Seq[Any](format.raw/*18.59*/("""
                """),format.raw/*19.17*/("""<li><a href=""""),_display_(/*19.31*/routes/*19.37*/.Public.landing()),format.raw/*19.54*/("""">Search</a></li>
                <li><a href=""""),_display_(/*20.31*/routes/*20.37*/.BTController.createTrip()),format.raw/*20.63*/("""">Create Trip</a></li>
                """),format.raw/*21.89*/("""
                """),format.raw/*22.77*/("""
                """),format.raw/*23.81*/("""
            """)))}),format.raw/*24.14*/("""
            """),format.raw/*25.13*/("""</ul>
            <ul class="nav navbar-nav navbar-right">
            """),_display_(/*27.14*/if(controllers.Users.currentUser() != null)/*27.57*/ {_display_(Seq[Any](format.raw/*27.59*/("""
                """),format.raw/*28.17*/("""<li><p class="navbar-text"><i>Logged in as: """),_display_(/*28.62*/controllers/*28.73*/.Users.currentUser().username),format.raw/*28.102*/("""</i></p></li>
                <li><a href=""""),_display_(/*29.31*/routes/*29.37*/.Users.logout()),format.raw/*29.52*/("""">Logout</a></li>
            """)))}/*30.15*/else/*30.20*/{_display_(Seq[Any](format.raw/*30.21*/("""
                """),format.raw/*31.17*/("""<li><a href=""""),_display_(/*31.31*/routes/*31.37*/.Public.loginForm()),format.raw/*31.56*/("""">Login</a></li>
                <li><a href=""""),_display_(/*32.31*/routes/*32.37*/.Public.registerForm()),format.raw/*32.59*/("""">Register</a></li>
            """)))}),format.raw/*33.14*/("""
            """),format.raw/*34.13*/("""</ul>
        </div>
    </div>


</div>



"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


}

/**/
object navigation extends navigation_Scope0.navigation
              /*
                  -- GENERATED --
                  DATE: Sun Apr 09 05:28:02 CEST 2017
                  SOURCE: /home/penic/Workspace/Intellij/noplaynogain/app/views/navigation.scala.html
                  HASH: 39f96adf5808215eb1795524e1f7fb515f685e80
                  MATRIX: 748->1|844->3|872->5|986->145|1021->154|1118->225|1132->231|1169->248|1840->892|1892->935|1932->937|1977->954|2018->968|2033->974|2071->991|2146->1039|2161->1045|2208->1071|2275->1182|2320->1259|2365->1340|2410->1354|2451->1367|2550->1439|2602->1482|2642->1484|2687->1501|2759->1546|2779->1557|2830->1586|2901->1630|2916->1636|2952->1651|3002->1683|3015->1688|3054->1689|3099->1706|3140->1720|3155->1726|3195->1745|3269->1792|3284->1798|3327->1820|3391->1853|3432->1866
                  LINES: 27->1|32->1|34->3|36->5|37->6|38->7|38->7|38->7|49->18|49->18|49->18|50->19|50->19|50->19|50->19|51->20|51->20|51->20|52->21|53->22|54->23|55->24|56->25|58->27|58->27|58->27|59->28|59->28|59->28|59->28|60->29|60->29|60->29|61->30|61->30|61->30|62->31|62->31|62->31|62->31|63->32|63->32|63->32|64->33|65->34
                  -- GENERATED --
              */
          