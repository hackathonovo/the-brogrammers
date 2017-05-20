
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object landing_Scope0 {
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

class landing extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*1.2*/main("Watplaces")/*1.19*/ {_display_(Seq[Any](format.raw/*1.21*/("""


  """),format.raw/*4.3*/("""<link rel="stylesheet" type="text/css" href=""""),_display_(/*4.49*/routes/*4.55*/.Assets.at("stylesheets/landing.css")),format.raw/*4.92*/("""">
  <script src=""""),_display_(/*5.17*/routes/*5.23*/.Assets.at("javascripts/googlePlaces.js")),format.raw/*5.64*/("""" type="text/javascript"></script>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBOVsLLDx5MQmY4CUaD9-kt5Dqw5tPjJV4&libraries=places&callback=initAutocomplete"
  async defer></script>


  <div class="window" id="headingWindow">
    <h1 class="text-center" >Find your ride</h1>
    <div class="row">
    <form class="form-inline text-center boaty-search" action="/trips">
      <div class="form-group">
        """),format.raw/*15.54*/("""
        """),format.raw/*16.9*/("""<div class="form-group has-feedback">
          <input type="text" name="from" class="form-control input-lg pac-inputs"  id="pac-input" placeholder="From..">
          <i class="text-muted glyphicon glyphicon-map-marker form-control-feedback"></i>
        </div>
      </div>
      <div class="form-group">
        <div class="form-group has-feedback">
        <input type="text" name="to" class="form-control input-lg pac-inputs" id="pac-input2" placeholder="To..">
          <i class="text-muted glyphicon glyphicon-map-marker form-control-feedback"></i>
        </div>
      </div>
      <button type="submit" value="Submit" class="btn btn-info btn-lg">Go</button>
    </form>
    </div>

  </div>

  <img src=""""),_display_(/*33.14*/routes/*33.20*/.Assets.at("images/cro_island_1.png")),format.raw/*33.57*/("""" class="img-responsive" alt="skyline">


  <div class="window" id="missionWindow">
    <div class="row">
      <h2 class="text-center horizontalLine"><span>How does Boaty work?</span></h2>
      <div class="col-md-4 separate">
        <h3><span class="glyphicon glyphicon-user text-info"></span> Shared economy </h3>
        <p> Sharing boat trips between people. Fill any empty seats on your boat on your trip.
        Have some company and earn money for it!</p>
      </div>
      <div class="col-md-4 separate">
        <h3><span class="glyphicon glyphicon-search text-info"></span> Find a trip</h3>
        <p>Search for a specific trip you want to participate in. Filter by all the possible
        destinations or filter the trips by the price if you're not sure where to go!</p>
      </div>
      <div class="col-md-4 separate">
        <h3><span class="glyphicon glyphicon-plus text-info"></span> Create a ride</h3>
        <p>Easily connect to people going to the same city or island! Share your experience
        with other registered users and save some money while enjoying it!</p>
      </div>


    </div>
  </div>


  <script>

//          $("#firstWindow").css("height", $(window).height() ); /*- $(".navbar").height()*/

  </script>

""")))}),format.raw/*66.2*/("""
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
object landing extends landing_Scope0.landing
              /*
                  -- GENERATED --
                  DATE: Sun Apr 09 05:28:02 CEST 2017
                  SOURCE: /home/penic/Workspace/Intellij/noplaynogain/app/views/landing.scala.html
                  HASH: e914b5ecf079ab6d749bf091642a7abcba57e68f
                  MATRIX: 831->1|856->18|895->20|926->25|998->71|1012->77|1069->114|1114->133|1128->139|1189->180|1645->653|1681->662|2423->1377|2438->1383|2496->1420|3782->2676
                  LINES: 32->1|32->1|32->1|35->4|35->4|35->4|35->4|36->5|36->5|36->5|46->15|47->16|64->33|64->33|64->33|97->66
                  -- GENERATED --
              */
          