package controllers

import javax.inject._

import es.weso.schema._
import play.api.i18n.{I18nSupport, MessagesApi}
import play.api.mvc._
import play.api.Logger

import scala.util.{Failure, Success}

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class CheckSchema @Inject()(val messagesApi: MessagesApi) extends Controller with I18nSupport {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def check(schema: String,format: Option[String], engine: Option[String]) = Action { req =>
    Logger.info(s"Schema check: $schema $format $engine")
    val schemaFormat = format.getOrElse(Schemas.defaultSchemaFormat)
    val schemaName = engine.getOrElse(Schemas.defaultSchemaName)
    Logger.info(s"Schemas detected: $schema $schemaFormat $schemaName")
    Schemas.fromString(schema,schemaFormat,schemaName,None) match {
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
