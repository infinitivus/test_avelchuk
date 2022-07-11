// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:5
package controllers {

  // @LINE:5
  class ReversePersonController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:5
    def login(): Call = {
      
      Call("GET", _prefix)
    }
  
    // @LINE:6
    def checkPerson(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "login")
    }
  
    // @LINE:7
    def registrationPerson(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "registration")
    }
  
    // @LINE:8
    def authorisationPerson(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "authorisation")
    }
  
  }


}
