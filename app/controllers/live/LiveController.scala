package controllers.live

import models.LiveRoom
import play.api.mvc._

import javax.inject._
import scala.collection.mutable
import play.api.libs.json._


@Singleton
class LiveController @Inject()(val cc: ControllerComponents) extends AbstractController(cc) {
  private val liveRooms = new mutable.ListBuffer[LiveRoom]

  implicit val todoListJson: OFormat[LiveRoom] = Json.format[LiveRoom]

  def getAll: Action[AnyContent] = Action {
    if (liveRooms.isEmpty) {
      NoContent
    } else {
      Ok(Json.toJson(liveRooms))
    }
  }

  def add(id: Long, name: String): Action[AnyContent] = Action {
    val room = LiveRoom(id, name)
    NoContent
  }

  def getById(id: Long): Action[AnyContent] = Action {
    val foundRoom = liveRooms.find(_.id == id)
    foundRoom match {
      case Some(item) => Ok(Json.toJson(item))
      case None => NotFound
    }
  }

}
