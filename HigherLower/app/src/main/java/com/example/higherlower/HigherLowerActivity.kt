package com.example.higherlower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_higher_lower.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var currentThrow = 1
    private var lastThrow = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_higher_lower)
        initViews()
    }

    private fun initViews() {
        updateUI()
        btnLower.setOnClickListener {onClickLower()}
        btnEqual.setOnClickListener {onClickEqual()}
        btnHigher.setOnClickListener {onClickHigher()}
    }

    private fun updateUI() {
        lastThrowIndicator.text = getString(R.string.lastThrowIndicator, lastThrow)

        when (currentThrow) {
            1 -> diceFace.setImageResource(R.drawable.dice1)
            2 -> diceFace.setImageResource(R.drawable.dice2)
            3 -> diceFace.setImageResource(R.drawable.dice3)
            4 -> diceFace.setImageResource(R.drawable.dice4)
            5 -> diceFace.setImageResource(R.drawable.dice5)
            6 -> diceFace.setImageResource(R.drawable.dice6)
        }
    }

    private fun onClickLower() {
        throwDice()
        if (currentThrow < lastThrow) {
            toast(win = true)
        } else toast(win = false)

        updateUI()
    }

    private fun onClickEqual() {
        throwDice()
        if (currentThrow == lastThrow) {
            toast(win = true)
        } else toast(win = false)

        updateUI()
    }

    private fun onClickHigher() {
        throwDice()
        if (currentThrow > lastThrow) {
            toast(win = true)
        } else toast(win = false)

        updateUI()
    }

    private fun throwDice() {
        lastThrow = currentThrow
        currentThrow = Random.nextInt(1,6)
    }

    private fun toast(win:Boolean) {
        if (win) {
            Toast.makeText(this, getString(R.string.win), Toast.LENGTH_SHORT).show()
        } else Toast.makeText(this, getString(R.string.lose), Toast.LENGTH_SHORT).show()
    }
}
