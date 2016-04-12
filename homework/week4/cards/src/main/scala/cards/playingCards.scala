package cards

package suits {
    sealed abstract class CardSuit
    case object Spades extends CardSuit
    case object Clubs extends CardSuit
    case object Diamonds extends CardSuit
    case object Hearts extends CardSuit
}

// define package values with type hierarchy for card values here 


// This won't compile because values.CardValue is undefined
case class PlayingCard(suit: suits.CardSuit, value: values.CardValue)
