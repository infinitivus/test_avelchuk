// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:5
  PersonController_0: controllers.PersonController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:5
    PersonController_0: controllers.PersonController
  ) = this(errorHandler, PersonController_0, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, PersonController_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.PersonController.login(request:Request)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.PersonController.checkPerson(request:Request)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """registration""", """controllers.PersonController.registrationPerson(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """authorisation""", """controllers.PersonController.authorisationPerson(request:Request)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:5
  private[this] lazy val controllers_PersonController_login0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_PersonController_login0_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      PersonController_0.login(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PersonController",
      "login",
      Seq(classOf[play.mvc.Http.Request]),
      "GET",
      this.prefix + """""",
      """""",
      Seq()
    )
  )

  // @LINE:6
  private[this] lazy val controllers_PersonController_checkPerson1_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_PersonController_checkPerson1_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      PersonController_0.checkPerson(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PersonController",
      "checkPerson",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """login""",
      """""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_PersonController_registrationPerson2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("registration")))
  )
  private[this] lazy val controllers_PersonController_registrationPerson2_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      PersonController_0.registrationPerson(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PersonController",
      "registrationPerson",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """registration""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_PersonController_authorisationPerson3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("authorisation")))
  )
  private[this] lazy val controllers_PersonController_authorisationPerson3_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      PersonController_0.authorisationPerson(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PersonController",
      "authorisationPerson",
      Seq(classOf[play.mvc.Http.Request]),
      "GET",
      this.prefix + """authorisation""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:5
    case controllers_PersonController_login0_route(params@_) =>
      call { 
        controllers_PersonController_login0_invoker.call(
          req => PersonController_0.login(req))
      }
  
    // @LINE:6
    case controllers_PersonController_checkPerson1_route(params@_) =>
      call { 
        controllers_PersonController_checkPerson1_invoker.call(
          req => PersonController_0.checkPerson(req))
      }
  
    // @LINE:7
    case controllers_PersonController_registrationPerson2_route(params@_) =>
      call { 
        controllers_PersonController_registrationPerson2_invoker.call(
          req => PersonController_0.registrationPerson(req))
      }
  
    // @LINE:8
    case controllers_PersonController_authorisationPerson3_route(params@_) =>
      call { 
        controllers_PersonController_authorisationPerson3_invoker.call(
          req => PersonController_0.authorisationPerson(req))
      }
  }
}
