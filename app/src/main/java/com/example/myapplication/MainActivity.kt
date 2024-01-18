package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var str:String = "" //mem value from show.test.toString()
    var spinlock = 0 // 0 = allow assign dot, 1 = not allow assign dot
    //var numlock = 0
    var num1 = 0 //mem result calculate
    var num2 = 0 //total result calculate
    var operand = "" //operator for calculate
    var operand2 = "" //operator real time
    var operandlock = 2 // 1 = accept receive operator , 2 = not receive operator

    lateinit var show: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val zero: Button = findViewById(R.id.zero)
        val one: Button = findViewById(R.id.one)
        val two: Button = findViewById(R.id.two)
        val three: Button = findViewById(R.id.three)
        val four: Button = findViewById(R.id.four)
        val five: Button = findViewById(R.id.five)
        val six: Button = findViewById(R.id.six)
        val seven: Button = findViewById(R.id.seven)
        val eight: Button = findViewById(R.id.eight)
        val nine: Button = findViewById(R.id.nine)
        val plus: Button = findViewById(R.id.plus)
        val minus: Button = findViewById(R.id.minus)
        val power: Button = findViewById(R.id.power)
        val divide: Button = findViewById(R.id.divide)
        val dot: Button = findViewById(R.id.dot)
        val result: Button = findViewById(R.id.result)
        val clear: Button = findViewById(R.id.clear)
        val dell: Button = findViewById(R.id.dell)
        val percent: Button = findViewById(R.id.percent)
        show = findViewById(R.id.show)

        //Assign number from number button
        zero.setOnClickListener{
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

        //Assign operator from button
        plus.setOnClickListener{
            if(operand == "")
                operand = "+"
            else
                operand2 = "+"
            prcess()
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

        //insert . from button
        dot.setOnClickListener{
            if(spinlock == 0){
                str = show.text.toString().plus(".")
                show.setText(str)
                spinlock = 1
            }
        }

        //Calculating final Result
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
            //numlock = 1
            num1 = 0
            operand = ""
            operand2 = ""
            operandlock = 2
        }

        //Reset all Global Variable
        clear.setOnClickListener{
            spinlock = 0
            //numlock = 1
            num1 = 0
            num2 = 0
            operand = ""
            operand2 = ""
            operandlock = 2
            show.setText("0")
        }

        // Delete 1 index number from last index
        dell.setOnClickListener{
            if(show.text.toString().length == 1){
                show.setText("0")
            } else {
                show.setText(show.text.toString().dropLast(1))
            }
        }

        //Assign modulo from button
        percent.setOnClickListener{
            if(operand == "")
                operand = "%"
            else
                operand2 = "%"
            prcess()
        }
    }

    //function calculate and assign operator
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
            num1 = show.text.toString().toInt()//insert num1 fron textbox if num1 = 0
        }
        show.setText(num1.toString())
        operandlock = 2
        num2 = num1

        //function add number from button
    }fun numadd(ss:String){
        if(show.text.toString() == "0" || operandlock == 2){
            //numlock = 0
            operandlock = 1
            show.setText(ss)
        }else{
            str= show.text.toString().plus(ss)
            show.setText(str)
        }
    }
}
