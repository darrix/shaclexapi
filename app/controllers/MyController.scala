package controllers

import javax.inject._

import play.api._
import play.api.mvc._
import play.api.i18n.Messages.Implicits._
import play.api.i18n.{I18nSupport, MessagesApi}
import es.weso.schema._

import scala.util.{Failure, Success}
/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class MyController @Inject()(val messagesApi: MessagesApi) extends Controller with I18nSupport {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def prueba = Action {
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
