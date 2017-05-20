
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object profile_Scope0 {
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

class profile extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[BTUser,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(user: BTUser):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.16*/("""

"""),_display_(/*3.2*/main("BTUser profile")/*3.24*/ {_display_(Seq[Any](format.raw/*3.26*/("""

  """),format.raw/*5.3*/("""<dl class="dl-horizontal">
    <h2><dd>Profile</dd></h2>
    <h3>
    """),_display_(/*8.6*/if(user.username != null)/*8.31*/ {_display_(Seq[Any](format.raw/*8.33*/(""" """),format.raw/*8.34*/("""<dt>Username</dt> <dd>"""),_display_(/*8.57*/(user.username)),format.raw/*8.72*/("""</dd> """)))}),format.raw/*8.79*/("""
    """),_display_(/*9.6*/if(user.firstName != null)/*9.32*/ {_display_(Seq[Any](format.raw/*9.34*/(""" """),format.raw/*9.35*/("""<dt>Name</dt> <dd>"""),_display_(/*9.54*/(user.firstName)),format.raw/*9.70*/("""</dd> """)))}),format.raw/*9.77*/("""
    """),_display_(/*10.6*/if(user.lastName != null)/*10.31*/ {_display_(Seq[Any](format.raw/*10.33*/(""" """),format.raw/*10.34*/("""<dt>Surname</dt> <dd>"""),_display_(/*10.56*/(user.lastName)),format.raw/*10.71*/("""</dd> """)))}),format.raw/*10.78*/("""
    """),_display_(/*11.6*/if(user.email != null)/*11.28*/ {_display_(Seq[Any](format.raw/*11.30*/(""" """),format.raw/*11.31*/("""<dt>Email</dt> <dd>"""),_display_(/*11.51*/(user.email)),format.raw/*11.63*/("""</dd> """)))}),format.raw/*11.70*/("""
    """),format.raw/*12.5*/("""</h3>
  </dl>

""")))}))
      }
    }
  }

  def render(user:BTUser): play.twirl.api.HtmlFormat.Appendable = apply(user)

  def f:((BTUser) => play.twirl.api.HtmlFormat.Appendable) = (user) => apply(user)

  def ref: this.type = this

}


}

/**/
object profile extends profile_Scope0.profile
              /*
                  -- GENERATED --
                  DATE: Sat Apr 08 17:25:15 CEST 2017
                  SOURCE: /home/penic/Workspace/Intellij/noplaynogain/app/views/profile.scala.html
                  HASH: 93afeadb3427580084c8988b5071299f83fa7157
                  MATRIX: 749->1|858->15|886->18|916->40|955->42|985->46|1081->117|1114->142|1153->144|1181->145|1230->168|1265->183|1302->190|1333->196|1367->222|1406->224|1434->225|1479->244|1515->260|1552->267|1584->273|1618->298|1658->300|1687->301|1736->323|1772->338|1810->345|1842->351|1873->373|1913->375|1942->376|1989->396|2022->408|2060->415|2092->420
                  LINES: 27->1|32->1|34->3|34->3|34->3|36->5|39->8|39->8|39->8|39->8|39->8|39->8|39->8|40->9|40->9|40->9|40->9|40->9|40->9|40->9|41->10|41->10|41->10|41->10|41->10|41->10|41->10|42->11|42->11|42->11|42->11|42->11|42->11|42->11|43->12
                  -- GENERATED --
              */
          