package com.example.diceroller

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton : Button = findViewById(R.id.button)
        rollButton.setOnClickListener{ rollDice() }
    }

    private fun rollDice() {
        val dice = Dice(6)  //create a dice object
        val diceRoll = dice.roll()  //roll the dice and get a nr 1..6
        val diceImage: ImageView = findViewById(R.id.imageView)
        val mediaPlayer = MediaPlayer.create(this,R.raw.ronaldo_siuu)
        mediaPlayer.start()
        when(diceRoll){
            1->diceImage.setImageResource(R.drawable.dice_1)
            2->diceImage.setImageResource(R.drawable.dice_2)
            3->diceImage.setImageResource(R.drawable.dice_3)
            4->diceImage.setImageResource(R.drawable.dice_4)
            5->diceImage.setImageResource(R.drawable.dice_5)
            6->diceImage.setImageResource(R.drawable.dice_6)
        }//update the dice image based on the random nr
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }   //get a random nr from 1 to 6(numSides)
}