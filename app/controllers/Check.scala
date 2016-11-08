package controllers

import javax.inject._

import es.weso.schema._
import play.api.i18n.{I18nSupport, MessagesApi}
import play.api.mvc._

import scala.util.{Failure, Success}

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class Check @Inject()(val messagesApi: MessagesApi) extends Controller with I18nSupport {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def check = Action { req =>
    val str = """<S> { <p> . }"""
    Schemas.fromString(str,"SHEXC","SHEX",None) match {
      case Success(schema) => {
        schema.serialize("SHEXC") match {
          case Success(result) => Ok(views.html.index(result))
          case Failure(e) => Ok(views.html.index(s"Error: $e"))
        }
      }
      case Failure(e) => {
        Ok(views.html.index(s"Error: $e"))
      }
    }

  }

}
