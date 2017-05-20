
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object main_Scope0 {
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

class main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.32*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>"""),_display_(/*9.17*/title),format.raw/*9.22*/("""</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        """),format.raw/*13.128*/("""
        """),format.raw/*14.127*/("""
        """),format.raw/*15.9*/("""<link href=""""),_display_(/*15.22*/routes/*15.28*/.Assets.at("stylesheets/stars.css")),format.raw/*15.63*/("""" rel="stylesheet" media="screen">
        <link href=""""),_display_(/*16.22*/routes/*16.28*/.Assets.at("stylesheets/footer.css")),format.raw/*16.64*/("""" rel="stylesheet" media="screen">
        <link href=""""),_display_(/*17.22*/routes/*17.28*/.Assets.at("stylesheets/responsiveText.css")),format.raw/*17.72*/("""" rel="stylesheet" media="screen">
        <link href=""""),_display_(/*18.22*/routes/*18.28*/.Assets.at("stylesheets/main.css")),format.raw/*18.62*/("""" rel="stylesheet" media="screen">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(/*19.59*/routes/*19.65*/.Assets.at("images/favicon.png")),format.raw/*19.97*/("""">

        """),format.raw/*21.30*/("""
    """),format.raw/*22.5*/("""<style>
    padding-bottom: 70px;
    </style>
        
    </head>
    <body>

        <div class="container">

        """),_display_(/*31.10*/navigation()),format.raw/*31.22*/("""

        """),_display_(/*33.10*/if(flash.containsKey("success"))/*33.42*/ {_display_(Seq[Any](format.raw/*33.44*/("""
        """),format.raw/*34.9*/("""<div class="alert alert-success">"""),_display_(/*34.43*/flash/*34.48*/.get("success")),format.raw/*34.63*/("""</div>
        """)))}),format.raw/*35.10*/("""
        """),_display_(/*36.10*/if(flash.containsKey("error"))/*36.40*/ {_display_(Seq[Any](format.raw/*36.42*/("""
        """),format.raw/*37.9*/("""<div class="alert alert-danger">"""),_display_(/*37.42*/flash/*37.47*/.get("error")),format.raw/*37.60*/("""</div>
        """)))}),format.raw/*38.10*/("""
        """),_display_(/*39.10*/content),format.raw/*39.17*/("""
        """),format.raw/*40.9*/("""</div>

    </body>
</html>
"""))
      }
    }
  }

  def render(title:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)

  def ref: this.type = this

}


}

/**/
object main extends main_Scope0.main
              /*
                  -- GENERATED --
                  DATE: Sun Apr 09 05:28:02 CEST 2017
                  SOURCE: /home/penic/Workspace/Intellij/noplaynogain/app/views/main.scala.html
                  HASH: 72bda94993d99dfd536c4581f84490872238c89c
                  MATRIX: 748->1|873->31|903->35|1165->271|1190->276|1546->722|1585->850|1622->860|1662->873|1677->879|1733->914|1817->971|1832->977|1889->1013|1973->1070|1988->1076|2053->1120|2137->1177|2152->1183|2207->1217|2328->1311|2343->1317|2396->1349|2438->1384|2471->1390|2629->1521|2662->1533|2702->1546|2743->1578|2783->1580|2820->1590|2881->1624|2895->1629|2931->1644|2979->1661|3017->1672|3056->1702|3096->1704|3133->1714|3193->1747|3207->1752|3241->1765|3289->1782|3327->1793|3355->1800|3392->1810
                  LINES: 27->1|32->1|34->3|40->9|40->9|44->13|45->14|46->15|46->15|46->15|46->15|47->16|47->16|47->16|48->17|48->17|48->17|49->18|49->18|49->18|50->19|50->19|50->19|52->21|53->22|62->31|62->31|64->33|64->33|64->33|65->34|65->34|65->34|65->34|66->35|67->36|67->36|67->36|68->37|68->37|68->37|68->37|69->38|70->39|70->39|71->40
                  -- GENERATED --
              */
          