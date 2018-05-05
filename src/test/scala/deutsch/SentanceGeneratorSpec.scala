package deutsch

import org.specs2.mutable._
import Gender._
import SentanceGenerator._

class SentanceGeneratorSpec extends Specification {
  "dativ sentances" >> {
    "male in sentance" >> {
      dativSentance(InNoun(Der, "Dschungel")) must_== "Ich bin im Dschungel"
    }
    "male an sentance" >> {
      dativSentance(AnNoun(Der, "See")) must_== "Ich bin am See"
    }
    "neutral an sentance" >> {
      dativSentance(AnNoun(Das, "Meer")) must_== "Ich bin am Meer"
    }
    "female auf sentance" >> {
      dativSentance(AufNoun(Die, "Insel")) must_== "Ich bin auf der Insel"
    }
  }
  "akkusativ sentance" >> {
    "male in sentance" >> {
      akkusativSentance(InNoun(Der, "Dschungel")) must_== "Ich reise in den Dschungel"
    }
    "male an sentance" >> {
      akkusativSentance(AnNoun(Der, "See")) must_== "Ich reise an den See"
    }
    "male an sentance" >> {
      akkusativSentance(AnNoun(Das, "Meer")) must_== "Ich reise ans Meer"
    }
    "female auf sentance" >> {
      akkusativSentance(AufNoun(Die, "Insel")) must_== "Ich reise auf die Insel"
    }
  }
}
