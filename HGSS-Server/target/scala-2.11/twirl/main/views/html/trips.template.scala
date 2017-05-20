
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object trips_Scope0 {
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

class trips extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[List[BTTrip],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(trips: List[BTTrip]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.23*/("""
"""),_display_(/*2.2*/main("Trips")/*2.15*/ {_display_(Seq[Any](format.raw/*2.17*/("""

  """),format.raw/*4.3*/("""<div class="window">
    <h1 class="horizontalLine"><span>Trips</span></h1>
    <div class="row separate">

      <table class="table table-bordered separate">
        <thead>
          <tr><th>Departure date</th><th>Price</th><th>Places taken</th><th>Stops</th></tr>
        </thead>
        <tbody>
        """),_display_(/*13.10*/for(trip <- trips) yield /*13.28*/ {_display_(Seq[Any](format.raw/*13.30*/("""
          """),format.raw/*14.11*/("""<tr>
            <td>
            """),_display_(/*16.14*/trip/*16.18*/.dateToString()),format.raw/*16.33*/("""
            """),format.raw/*17.13*/("""</td>
            <td>
            """),_display_(/*19.14*/trip/*19.18*/.price),format.raw/*19.24*/("""
            """),format.raw/*20.13*/("""</td>
            <td>
            """),_display_(/*22.14*/trip/*22.18*/.passengers.size()),format.raw/*22.36*/(""" """),format.raw/*22.37*/("""/ """),_display_(/*22.40*/trip/*22.44*/.numOfPlaces),format.raw/*22.56*/("""
            """),format.raw/*23.13*/("""</td>
            <td>
             """),_display_(/*25.15*/for(location <- trip.locations) yield /*25.46*/ {_display_(Seq[Any](format.raw/*25.48*/("""
               """),_display_(/*26.17*/location/*26.25*/.name),format.raw/*26.30*/("""
             """)))}),format.raw/*27.15*/("""
            """),format.raw/*28.13*/("""</td>
          </tr>
        """)))}),format.raw/*30.10*/("""
        """),format.raw/*31.9*/("""</tbody>
      </table>
    </div>
  </div>
""")))}))
      }
    }
  }

  def render(trips:List[BTTrip]): play.twirl.api.HtmlFormat.Appendable = apply(trips)

  def f:((List[BTTrip]) => play.twirl.api.HtmlFormat.Appendable) = (trips) => apply(trips)

  def ref: this.type = this

}


}

/**/
object trips extends trips_Scope0.trips
              /*
                  -- GENERATED --
                  DATE: Sun Apr 09 03:30:50 CEST 2017
                  SOURCE: /home/penic/Workspace/Intellij/noplaynogain/app/views/trips.scala.html
                  HASH: aebd0caa7611f6ca483909b74ccca024cb262df1
                  MATRIX: 751->1|867->22|894->24|915->37|954->39|984->43|1321->353|1355->371|1395->373|1434->384|1496->419|1509->423|1545->438|1586->451|1649->487|1662->491|1689->497|1730->510|1793->546|1806->550|1845->568|1874->569|1904->572|1917->576|1950->588|1991->601|2055->638|2102->669|2142->671|2186->688|2203->696|2229->701|2275->716|2316->729|2378->760|2414->769
                  LINES: 27->1|32->1|33->2|33->2|33->2|35->4|44->13|44->13|44->13|45->14|47->16|47->16|47->16|48->17|50->19|50->19|50->19|51->20|53->22|53->22|53->22|53->22|53->22|53->22|53->22|54->23|56->25|56->25|56->25|57->26|57->26|57->26|58->27|59->28|61->30|62->31
                  -- GENERATED --
              */
          