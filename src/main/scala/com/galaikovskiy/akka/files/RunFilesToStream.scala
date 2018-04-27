package com.galaikovskiy.akka.files

import java.nio.file.{FileSystems, Path}

import akka.NotUsed
import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.alpakka.file.scaladsl.{Directory, DirectoryChangesSource}
import akka.stream.scaladsl.Source

import scala.concurrent.duration._

object RunFilesToStream {

  def main(args: Array[String]): Unit = {
    if (args.length != 1) throw new IllegalArgumentException("Usage: DirectoryChangesSourceTest [path]")
    val path: String = args(0)

    implicit val system: ActorSystem = ActorSystem()
    implicit val materializer = ActorMaterializer()

    // #minimal-sample
    val fs = FileSystems.getDefault
    val dir = fs.getPath(path)
    val source: Source[Path, NotUsed] = Directory.ls(dir)
    source.runForeach(f => println(f getFileName))


    val changes = DirectoryChangesSource(fs.getPath(path), pollInterval = 1.second, maxBufferSize = 1000)

    changes.runForeach {
      case (path, change) => println("Path: " + path + ", Change: " + change)
    }
    // #minimal-sample

    // #simple-lines
  }

}
