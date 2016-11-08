package controllers

import javax.inject._

import es.weso.schema._
import play.api.Logger
import play.api.i18n.{I18nSupport, MessagesApi}
import play.api.mvc._

import scala.util.{Failure, Success}

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class CheckData @Inject()(val messagesApi: MessagesApi) extends Controller with I18nSupport {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def check(data: String,format: Option[String], engine: Option[String]) = Action { req =>
    Logger.info(s"Data check: $data $format $engine")
/*    val dataFormat = format.getOrElse(DataFormats.defaultDa)
    val dataName = engine.getOrElse(Schemas.defaultSchemaName)
    Logger.info(s"Data detected: $data $schemaFormat $schemaName")
    Schemas.fromString(data,schemaFormat,schemaName,None) match {
      case Success(schema) => {
        schema.serialize("SHEXC") match {
          case Success(result) => Ok(views.html.index(result))
          case Failure(e) => Ok(views.html.index(s"Error: $e"))
        }
      }
      case Failure(e) => {
        Ok(views.html.index(s"Error: $e"))
      } */
    Ok(views.html.index(s"..."))
    }

}
