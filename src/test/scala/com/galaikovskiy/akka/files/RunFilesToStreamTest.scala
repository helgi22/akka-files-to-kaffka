package com.galaikovskiy.akka.files

import org.scalatest.FunSuite

class RunFilesToStreamTest extends FunSuite {
  test("test main method") {
    RunFilesToStream.main(Array("C:\\temp\\DMP-TEST\\Files\\"))
  }
}
