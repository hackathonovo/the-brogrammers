
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object createTrip_Scope0 {
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

class createTrip extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*1.2*/main("Trips")/*1.15*/ {_display_(Seq[Any](format.raw/*1.17*/("""

    """),format.raw/*3.5*/("""<link rel="stylesheet" type="text/css" href=""""),_display_(/*3.51*/routes/*3.57*/.Assets.at("stylesheets/createTrip.css")),format.raw/*3.97*/("""">
    <link rel="stylesheet" type="text/css" href=""""),_display_(/*4.51*/routes/*4.57*/.Assets.at("stylesheets/search.css")),format.raw/*4.93*/("""">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

    """),format.raw/*7.104*/("""
    """),format.raw/*8.5*/("""<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBOVsLLDx5MQmY4CUaD9-kt5Dqw5tPjJV4&libraries=places&callback=initAutocomplete"
    async defer></script>


    <script>
            // This example requires the Places library. Include the libraries=places
            // parameter when you first load the API. For example:
            // <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&libraries=places">

            function initMap() """),format.raw/*17.32*/("""{"""),format.raw/*17.33*/("""
                """),format.raw/*18.17*/("""var map = new google.maps.Map(document.getElementById('map'), """),format.raw/*18.79*/("""{"""),format.raw/*18.80*/("""
                    """),format.raw/*19.21*/("""center: """),format.raw/*19.29*/("""{"""),format.raw/*19.30*/("""lat: 44.398056, lng: 15.7019217"""),format.raw/*19.61*/("""}"""),format.raw/*19.62*/(""",
                    zoom: 7
                """),format.raw/*21.17*/("""}"""),format.raw/*21.18*/(""");
                var input = document.getElementById('pac-input');

                var autocomplete = new google.maps.places.Autocomplete(input);

                // Bind the map's bounds (viewport) property to the autocomplete object,
                // so that the autocomplete requests use the current map bounds for the
                // bounds option in the request.
                autocomplete.bindTo('bounds', map);

                var infowindow = new google.maps.InfoWindow();
                var infowindowContent = document.getElementById('infowindow-content');
                infowindow.setContent(infowindowContent);
                var marker = new google.maps.Marker("""),format.raw/*34.53*/("""{"""),format.raw/*34.54*/("""
                    """),format.raw/*35.21*/("""map: map,
                    anchorPoint: new google.maps.Point(0, -29),
                    animation: google.maps.Animation.DROP
                """),format.raw/*38.17*/("""}"""),format.raw/*38.18*/(""");

                var bounds = new google.maps.LatLngBounds();


                autocomplete.addListener('place_changed', function() """),format.raw/*43.70*/("""{"""),format.raw/*43.71*/("""
"""),format.raw/*44.1*/("""//                    infowindow.close();
//                    marker.setVisible(false);
                    var place = autocomplete.getPlace();
                    if (!place.geometry) """),format.raw/*47.42*/("""{"""),format.raw/*47.43*/("""
                        """),format.raw/*48.25*/("""// User entered the name of a Place that was not suggested and
                        // pressed the Enter key, or the Place Details request failed.
                        window.alert("No details available for input: '" + place.name + "'");
                        return;
                    """),format.raw/*52.21*/("""}"""),format.raw/*52.22*/("""

                    """),format.raw/*54.21*/("""// If the place has a geometry, then present it on a map.
                    if (place.geometry.viewport) """),format.raw/*55.50*/("""{"""),format.raw/*55.51*/("""
"""),format.raw/*56.1*/("""//                        map.fitBounds(place.geometry.viewport);
                    """),format.raw/*57.21*/("""}"""),format.raw/*57.22*/(""" """),format.raw/*57.23*/("""else """),format.raw/*57.28*/("""{"""),format.raw/*57.29*/("""
"""),format.raw/*58.1*/("""//                        map.setCenter(place.geometry.location);
//                        map.setZoom(17);  // Why 17? Because it looks good.
                    """),format.raw/*60.21*/("""}"""),format.raw/*60.22*/("""
                    """),format.raw/*61.21*/("""var marker = new google.maps.Marker("""),format.raw/*61.57*/("""{"""),format.raw/*61.58*/("""
                        """),format.raw/*62.25*/("""map: map,
                    """),format.raw/*63.21*/("""}"""),format.raw/*63.22*/(""");
                    marker.setPosition(place.geometry.location);
                    marker.setVisible(true);
                    bounds.extend(marker.getPosition());



                    var address = '';
                    if (place.address_components) """),format.raw/*71.51*/("""{"""),format.raw/*71.52*/("""
                        """),format.raw/*72.25*/("""address = [
                            (place.address_components[0] && place.address_components[0].short_name || '')
                        ].join(' ');
                    """),format.raw/*75.21*/("""}"""),format.raw/*75.22*/("""






                    """),format.raw/*82.21*/("""$(function () """),format.raw/*82.35*/("""{"""),format.raw/*82.36*/("""
                        """),format.raw/*83.25*/("""var listContainer = $('#list');
                            // value of input
                            inputValue = place.name;
                            // add new list item
                            listContainer.prepend('<li class="list-group-item"> ' + inputValue + '</li>');
                            listContainer.prepend('<input type="hidden" name="locations[]" value="' + inputValue + '"/>');


                        $('#pac-input').val('');
                        $('#pac-input').focus();
                    """),format.raw/*93.21*/("""}"""),format.raw/*93.22*/(""");




                """),format.raw/*98.17*/("""}"""),format.raw/*98.18*/(""");

            """),format.raw/*100.13*/("""}"""),format.raw/*100.14*/("""
    """),format.raw/*101.5*/("""</script>


    <div class="window">
        <h1 class="horizontalLine"><span>Create trip</span></h1>
        <div class="row separator">
            <div class="col-md-4">

                <form action="/saveTrip" method="post">
                    <div class="form-group">
                        <label for="date">Date and time of departure</label>
                        <input type="datetime-local" class="form-control" id="date" name="date">
                    </div>
                    <div class="form-group">
                        <label for="price">Price</label>
                        <input type="text" class="form-control" id="price" name="price">
                    </div>
                    <div class="form-group">
                        <label for="places">Number of places</label>
                        <input type="text" class="form-control" id="places" name="numOfPlaces">
                    </div>
                    <div class="form-group">
                        <label for="places">Locations</label>
                        <div class="input-group">
                            <input type="text" id="pac-input" class="form-control" placeholder="Search seaside location ..." />
                            <span class="input-group-btn">
                                <button class="btn btn-primary" type="button">
                                    <span class="glyphicon glyphicon-plus"></span>
                                </button>
                            </span>
                        </div>
                        <ul id="list" class="list-group location-list"></ul>
                    </div>
                    <button type="submit" class="btn btn-default">Create</button>
                </form>
            </div>
            <div class="col-md-8">
                <div id="map"></div>
                <div id="infowindow-content">
                    <img src="" width="16" height="16" id="place-icon">
                    <span id="place-name"  class="title"></span><br>
                    <span id="place-address"></span>
                </div>
                <script async defer
                src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBOVsLLDx5MQmY4CUaD9-kt5Dqw5tPjJV4&libraries=places&callback=initMap">
                </script>
            </div>
        </div>
    </div>


""")))}))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


}

/**/
object createTrip extends createTrip_Scope0.createTrip
              /*
                  -- GENERATED --
                  DATE: Sun Apr 09 05:28:02 CEST 2017
                  SOURCE: /home/penic/Workspace/Intellij/noplaynogain/app/views/createTrip.scala.html
                  HASH: 6541f4ee23a40e681ea31bff20e909fccba5519b
                  MATRIX: 837->1|858->14|897->16|929->22|1001->68|1015->74|1075->114|1154->167|1168->173|1224->209|1353->409|1384->414|1883->885|1912->886|1957->903|2047->965|2076->966|2125->987|2161->995|2190->996|2249->1027|2278->1028|2352->1074|2381->1075|3098->1764|3127->1765|3176->1786|3352->1934|3381->1935|3545->2071|3574->2072|3602->2073|3818->2261|3847->2262|3900->2287|4224->2583|4253->2584|4303->2606|4438->2713|4467->2714|4495->2715|4609->2801|4638->2802|4667->2803|4700->2808|4729->2809|4757->2810|4949->2974|4978->2975|5027->2996|5091->3032|5120->3033|5173->3058|5231->3088|5260->3089|5549->3350|5578->3351|5631->3376|5834->3551|5863->3552|5918->3579|5960->3593|5989->3594|6042->3619|6600->4149|6629->4150|6680->4173|6709->4174|6754->4190|6784->4191|6817->4196
                  LINES: 32->1|32->1|32->1|34->3|34->3|34->3|34->3|35->4|35->4|35->4|38->7|39->8|48->17|48->17|49->18|49->18|49->18|50->19|50->19|50->19|50->19|50->19|52->21|52->21|65->34|65->34|66->35|69->38|69->38|74->43|74->43|75->44|78->47|78->47|79->48|83->52|83->52|85->54|86->55|86->55|87->56|88->57|88->57|88->57|88->57|88->57|89->58|91->60|91->60|92->61|92->61|92->61|93->62|94->63|94->63|102->71|102->71|103->72|106->75|106->75|113->82|113->82|113->82|114->83|124->93|124->93|129->98|129->98|131->100|131->100|132->101
                  -- GENERATED --
              */
          