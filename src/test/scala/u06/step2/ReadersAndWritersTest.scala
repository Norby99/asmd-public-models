package scala.u06.step2

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*
import u06.utils.MSet

class ReadersAndWritersTest extends AnyFunSuite:

  import ReadersAndWriters.Place.*

  test("a writer can write if there are no readers or writers"):

    val expected = List(
      List(MSet(P1, P5), MSet(P2, P5), MSet(P3, P4, P5), MSet(P6, P4, P5), MSet(P1, P4, P5), MSet(P1, P7)),
      List(MSet(P1, P5), MSet(P2, P5), MSet(P3, P4, P5), MSet(P6, P4, P5), MSet(P1, P4, P5), MSet(P2, P4, P5)),
      List(MSet(P1, P5), MSet(P2, P5), MSet(P3, P4, P5), MSet(P3, P7), MSet(P3, P1, P5), MSet(P3, P2, P5)),
      List(MSet(P1, P5), MSet(P2, P5), MSet(P3, P4, P5), MSet(P3, P7), MSet(P3, P1, P5), MSet(P1, P6, P5)),
    )

    ReadersAndWriters.pnRW.paths(MSet(P1, P5), 6).toSet should be (expected.toSet)
