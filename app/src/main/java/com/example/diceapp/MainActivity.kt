package com.example.diceapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()
        }
        rollDice()
    }

    /**
     * This activity displays the resultant dice value when rolled
     * and also prints a toast message at the same time whrn
     * the button is clicked
     */
    private fun rollDice() {
        //Creating the Dice object dice whose sides are 6
        val dice = Dice(6)
        val diceRoll = dice.roll()

        //Displaying the diceRoll value to the screen by assigning it to the textView
        val diceImage : ImageView = findViewById(R.id.diceImageView)

        val drawableResource = when (diceRoll)   {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_1
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)

        diceImage.contentDescription = diceRoll.toString()

        val diceRollText: TextView = findViewById(R.id.diceMessageView)
        diceRollText.text = diceRoll.toString()

        //Displaying a Toast message when the button is clicked
        Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()
    }

}

/**
 * Declaration of the class Dice
 */
class Dice(private val numSides: Int) {
    //Function to generate random number and return within the specified number of sides of the dice
    fun roll(): Int {
        return (1..numSides).random()
    }
}
