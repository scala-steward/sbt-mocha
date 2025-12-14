package sbt

import sbt.internal.util.Appender
import sbt.{Level => SbtLevel}

object TestAppender extends Appender{
    var messages: List[(SbtLevel.Value, String)] = Nil
    var exceptions: List[Throwable] = Nil

    override def appendLog(level: SbtLevel.Value, message: => String): Unit = {
        messages = (level, message) :: messages
    }

    override def trace(t: => Throwable, traceLevel: Int): Unit = {
        exceptions = t :: exceptions
    }
    def name: String = "TestAppender"
    def properties: sbt.internal.util.ConsoleAppender.Properties = ???
    def suppressedMessage: sbt.internal.util.SuppressedTraceContext => Option[String] = ???
    def toLog4J = ???
    def close: Unit = ()
}
