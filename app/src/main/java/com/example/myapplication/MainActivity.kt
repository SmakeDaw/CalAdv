package com.example.myapplication

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder
import kotlin.system.exitProcess


class MainActivity : AppCompatActivity() {

    var str:String = ""
    var spinlock = 0
    var numlock = 0
    var num1 = 0
    var num2 = 0
    var operand = ""
    var operand2 = ""
    var operandlock = 2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        zero.setOnClickListener{
//            if(show.text.toString() == "0" || operandlock == 2){
//                numlock = 0
//                operandlock = 1
//                show.setText("0")
//            }else{
//                str = show.text.toString().plus("0")
//                show.setText(str)
//            }
            numadd("0")
        }

        one.setOnClickListener{
            numadd("1")
        }

        two.setOnClickListener{
            numadd("2")
        }

        three.setOnClickListener{
            numadd("3")
        }

        four.setOnClickListener{
            numadd("4")
        }
        five.setOnClickListener{
            numadd("5")
        }
        six.setOnClickListener{
            numadd("6")
        }
        seven.setOnClickListener{
            numadd("7")
        }
        eight.setOnClickListener{
            numadd("8")
        }
        nine.setOnClickListener{
            numadd("9")
        }

        plus.setOnClickListener{
            if(operand == "")
                operand = "+"
            else
                operand2 = "+"
            prcess()
//            if(num1 == 0 ) {
//                num1 = show.text.toString().toInt()
//                //num2 = show.text.toString().toInt()
//                operandlock = 2
//            } else if(operandlock == 1){
//                num1 = num1 + show.text.toString().toInt()
//                show.setText(num1.toString())
//                operandlock = 2
//                num2 = 1
//
//            }
        }
        minus.setOnClickListener{
            if(operand == "")
                operand = "-"
            else
                operand2 = "-"
            prcess()
        }

        power.setOnClickListener{
            if(operand == "")
                operand = "X"
            else
                operand2 = "X"
            prcess()
        }

        divide.setOnClickListener{
            if(operand == "")
                operand = "/"
            else
                operand2 = "/"
            prcess()
        }

        dot.setOnClickListener{
            if(spinlock == 0){
                str = show.text.toString().plus(".")
                show.setText(str)
                spinlock = 1
            }
        }

        result.setOnClickListener{

            if(operandlock != 2){
                if(operand == "+"){
                    num2 = num1 + show.text.toString().toInt()
                } else if(operand == "-"){
                    num2 = num1 - show.text.toString().toInt()
                } else if(operand == "X"){
                    num2 = num1 * show.text.toString().toInt()
                } else if(operand == "/"){
                    if(show.text.toString().toInt() == 0){
                        show.setText("Divider is Zero. Please press C")
                    } else {
                        num2 = num1 / show.text.toString().toInt()

                    }
                } else if(operand == "%"){
                    if(show.text.toString().toInt() == 0){
                        show.setText("Divider is Zero. Please press C")
                    } else {
                        num2 = num1 % show.text.toString().toInt()

                    }
                }

                show.setText(num2.toString())

            }else {
                show.setText(num2.toString())
            }
            spinlock = 0
            numlock = 1
            num1 = 0
            operand = ""
            operand2 = ""
            operandlock = 2
        }
        clear.setOnClickListener{
            spinlock = 0
            numlock = 1
            num1 = 0
            num2 = 0
            operand = ""
            operand2 = ""
            operandlock = 2
            show.setText("0")
        }
        dell.setOnClickListener{
            if(show.text.toString().length == 1){
                show.setText("0")
            } else {
                show.setText(show.text.toString().dropLast(1))
            }
        }
        percent.setOnClickListener{
            if(operand == "")
                operand = "%"
            else
                operand2 = "%"
            prcess()
        }
    }
    fun prcess(){
        if(operand2 != ""){
            if(operand == "+" && operandlock == 1){
                num1 = num1 + show.text.toString().toInt()
            } else if(operand == "-" && operandlock == 1){
                num1 = num1 - show.text.toString().toInt()
            } else if(operand == "X" && operandlock == 1){
                num1 = num1 * show.text.toString().toInt()
            } else if(operand == "/" && operandlock == 1){
                if(show.text.toString().toInt() != 0) {
                    num1 = num1 / show.text.toString().toInt()
                } else {
                    show.setText("Divider is Zero. Please press C")
                }
            } else if(operand == "%" && operandlock == 1){
                if(show.text.toString().toInt() != 0) {
                    num1 = num1 % show.text.toString().toInt()
                } else {
                    show.setText("Divider is Zero. Please press C")
                }
            }
            operand = operand2
        } else if (num1 == 0){
                num1 = show.text.toString().toInt()
        }
        show.setText(num1.toString())
        operandlock = 2
        num2 = num1

    }fun numadd(ss:String){
        if(show.text.toString() == "0" || operandlock == 2){
            numlock = 0
            operandlock = 1
            show.setText(ss)
        }else{
            str= show.text.toString().plus(ss)
            show.setText(str)
        }
    }
}