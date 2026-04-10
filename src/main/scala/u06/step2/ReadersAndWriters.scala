package scala.u06.step2

import u06.examples.PNMutualExclusion.Place
import u06.modelling.PetriNet

object ReadersAndWriters:
  enum Place:
    case P1, P2, P3, P4, P5, P6, P7

  export Place.*
  export u06.modelling.PetriNet.*
  export u06.modelling.SystemAnalysis.*
  export u06.utils.MSet

  // DSL-like specification of a Petri Net
  def pnRW = PetriNet[Place](
    MSet(P1) ~~> MSet(P2),
    MSet(P2) ~~> MSet(P3, P4),
    MSet(P6) ~~> MSet(P1),
    MSet(P4, P5) ~~> MSet(P7) ^^^ MSet(P6),
    MSet(P7) ~~> MSet(P1, P5),
    MSet(P3, P5) ~~> MSet(P5, P6)
  ).toSystem