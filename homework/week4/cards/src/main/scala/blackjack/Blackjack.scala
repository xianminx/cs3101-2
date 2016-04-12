package blackjack

import scala.io.StdIn.readLine
import cards._
import cards.suits._
import cards.values._
import cards.deck._


object Blackjack{

    /**
     * Compute the value of a PlayingCard given a current sum of cards.
     */
    def cardValue(card: PlayingCard, current_sum: Int): Int = {
      card.value match {
        case Ace if current_sum <= 10 => 11
        case Ace if current_sum > 10  => 1
        case Jack | Queen | King => 10
        case NumberValue(value) => value
      }

    }

    def main(args: Array[String]) {

        // val card1 = PlayingCard(Hearts, Queen)
        // val card2 = PlayingCard(Diamonds, NumberValue(9))
        // val card3 = PlayingCard(Spades, Ace)

        // println(card1, cardValue(card1,0))
        // // Should be 10
        // println(card2, cardValue(card2,10))
        // // Should be 9
        // println(card3, cardValue(card3,19))
        // // Should be 1
        // println(card3, cardValue(card3,2))
        // // Should be 11

        // comment the cardValue examples and add game code for Part 3 here

        val cardDeck =new CardDeck
        def nextCard:PlayingCard = {
          val card = cardDeck.nextCard
          println(s"$card")
          card
        }

        var credits = 100
        def playRound()={
          do{
            println(s"PLAYER TURN. Current Credits: $credits")
            var current_sum = 0
            var wants = true
            // player turn
            do{
              val card = nextCard
              current_sum += cardValue(card, current_sum)
              println(s"Current sum: $current_sum")
              if(current_sum <21){
                println(s"Hit or Stand? [H/S]")
                val action = readLine()
                wants = action match {
                  case "H"|"h" => true
                  case "S" |"s" => false
                }
              }
            } while(current_sum <21 && wants)

            if(current_sum == 21){
              println(s"You win!")
              credits +=1
            }else if(current_sum > 21){
                println(s"Dealer wins!\n")
                credits -=1
            }else { // current_sum <21  dealer's turn
              println(s"DEALER TURN")
              var dealer_sum =0
              do{
                val card = nextCard
                dealer_sum += cardValue(card, current_sum)
                println(s"Dealer sum: $dealer_sum")
              } while(dealer_sum <17)

              if(dealer_sum > 21 || dealer_sum < current_sum) {
                  println(s"You win!\n")
                  credits +=1
              } else if(dealer_sum == current_sum){
                  println(s"tied!")
              } else {
                    println(s"Dealer wins!\n")
                    credits -=1
              }
            }
          } while(credits>0)
        }

        playRound

    }
}
