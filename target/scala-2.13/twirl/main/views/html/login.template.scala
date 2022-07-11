
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.data._
import play.core.j.PlayFormsMagicForJava._
import scala.jdk.CollectionConverters._
/*1.2*/import play.mvc.Http.Request

object login extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Form[PersonData],Request,play.i18n.Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(form: Form[PersonData])(implicit request: Request, messages: play.i18n.Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*4.1*/("""
"""),format.raw/*5.1*/("""<form name="PersonData" method="post">
    """),_display_(/*6.6*/helper/*6.12*/.CSRF.formField),format.raw/*6.27*/("""  """),format.raw/*6.29*/("""<!-- This auto-generates a token for you -->
    """),_display_(/*7.6*/helper/*7.12*/.inputText(form("email"))),format.raw/*7.37*/("""
    """),_display_(/*8.6*/helper/*8.12*/.inputPassword(form("password"))),format.raw/*8.44*/("""
    """),format.raw/*9.5*/("""<button autofocus type="submit" formaction="/login" >Вход</button>
    <button type="submit" formaction="/registration">Регистрация</button>
    </form>
"""))
      }
    }
  }

  def render(form:Form[PersonData],request:Request,messages:play.i18n.Messages): play.twirl.api.HtmlFormat.Appendable = apply(form)(request,messages)

  def f:((Form[PersonData]) => (Request,play.i18n.Messages) => play.twirl.api.HtmlFormat.Appendable) = (form) => (request,messages) => apply(form)(request,messages)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/login.scala.html
                  HASH: 09f536dba3b4e2c27880f3afbf21921480a0d9ab
                  MATRIX: 610->1|980->32|1155->114|1182->115|1251->159|1265->165|1300->180|1329->182|1404->232|1418->238|1463->263|1494->269|1508->275|1560->307|1591->312
                  LINES: 23->1|28->3|33->4|34->5|35->6|35->6|35->6|35->6|36->7|36->7|36->7|37->8|37->8|37->8|38->9
                  -- GENERATED --
              */
          