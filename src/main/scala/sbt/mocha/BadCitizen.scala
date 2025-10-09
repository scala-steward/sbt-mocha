package sbt.mocha

import sbt.Tests.Summary
import sbt.protocol.testing.TestResult
import sbt.testing.Event
import sbt.{SuiteResult, Tests}

object BadCitizen {
  type SuiteResult = sbt.SuiteResult
  def output(overall: TestResult, events: Map[String, SuiteResult], summaries: Iterable[Summary]): Tests.Output = Tests.Output(overall, events, summaries)
  def suiteResult(results: Seq[Event]): SuiteResult = SuiteResult(results)
}
