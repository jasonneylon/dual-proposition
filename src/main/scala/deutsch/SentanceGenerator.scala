package deutsch

object Gender extends Enumeration {
  val Der, Die, Das = Value
}

trait Noun{
  def gender: Gender.Value
  def proposition: String
  def word: String
}

case class AufNoun(val gender: Gender.Value, val word: String) extends Noun {
  def proposition: String = "auf"
}

case class AnNoun(val gender: Gender.Value, val word: String) extends Noun {
  def proposition: String = "an"
}


case class InNoun(val gender: Gender.Value, val word: String) extends Noun {
  def proposition: String = "in"
}

object SentanceGenerator {

  private def dativArticle(gender: Gender.Value) =
    gender match {
      case Gender.Der => "dem"
      case Gender.Die => "der"
      case Gender.Das => "dem"
    }

  private def akkusativArticle(gender: Gender.Value) =
    gender match {
      case Gender.Der => "den"
      case Gender.Die => "die"
      case Gender.Das => "das"
    }

  private def dativPrepostion(noun: Noun) =
    noun match {
      case InNoun(Gender.Der, _) => "im"
      case AnNoun(Gender.Der | Gender.Das, _) => "am"
      case __ => s"${noun.proposition} ${dativArticle(noun.gender)}"
    }

  private def akkusativePrepostion(noun: Noun) =
    noun match {
      case AnNoun(Gender.Das, _) => "ans"
      case __ => s"${noun.proposition} ${akkusativArticle(noun.gender)}"
    }

    def dativSentance(noun: Noun): String = s"Ich bin ${dativPrepostion(noun)} ${noun.word}"
    def akkusativSentance(noun: Noun): String = s"Ich reise ${akkusativePrepostion(noun)} ${noun.word}"
}
