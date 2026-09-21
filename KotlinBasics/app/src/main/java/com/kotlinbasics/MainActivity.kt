package com.kotlinbasics

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key.Companion.I
import androidx.compose.ui.tooling.preview.Preview
import com.kotlinbasics.ui.theme.KotlinBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinBasicsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
        //week03Variables()
        //week03Functions()
        week04Classes()
        //week04Collections()
    }
}
private fun week03Variables() {
    println("Week 03: Variables")

    val courseName = "Mobile Programming"  // java final
    // courseName = "Data Structure"  // error

    var week = 2
    week = 3
    println("Course : $courseName")
    println("Week : $week")

    println("========= Kotlin Variables =========")

    // val(immutable) vs var(mutable)
    val name = "Android"
    var version = 8

    println("Hi $name $version")

    val age: Int = 24
    val height: Double = 177.7
    val isStudent: Boolean = false

    println("Age: $age, Height: $height, Student: $isStudent")

//    var nickname:String = null
    var nickname:String? = null
    nickname = "mirae"
    println("Nickname: $nickname ${nickname?.length}")
}

private fun week03Functions(){
//    println("Week 03: Functions")
//
//    fun greet(name: String) = "Hello, $name!"
//
//    println(greet("Android developer"))

    println("== Kotlin Functions ==")

    fun greet(name: String): String {
        return "Hello, $name!"
    }

    fun add(a: Int, b: Int) = a + b

    fun introduce(name: String, age: Int = 19){
        println("My name is $name and I'm $age years old")
    }

    println(greet("Kotlin"))
    println("Sum: ${add(5, -71)}")
    introduce("Kim", 7)
    introduce("Park")

    fun printAll(vip: Boolean, name: String){
        println("$vip, $name")
    }

    //fun printMany(msg: String){
    fun printMany(vararg msg: String){  // variable arguments
        for(m in msg) println(m)
    }

    //printAll("dy", true)
    printAll(true, "dy")
    printAll(name = "mirae", vip = true)  // named arguments

    printMany("A", "B", "C", "D")
}

private fun week04Classes(){
    Log.d("KotlinWeek04", "== Kotlin Classes ==")

    class Person(val name: String, var age: Int){
        fun introduce(){
            Log.d("KotlinWeek04", "안녕하세요, $name ($age 세)입니다.")
        }
        fun birthday(){
            age++
            Log.d("KotlinWeek04", "$name 의 생일! 이제 $age 세...")
        }
    }
    val person1 = Person("홍길동", 27)
    person1.introduce()
    person1.birthday()

    class Animal(var species: String){ // 주생성자
        var weight: Double = 0.0 // 부생성자, 부생성자는 입력 안할 시 주생성자로만 돌아감
        constructor(species: String, weight: Double) : this(species){
            this.weight = weight
            Log.d("KotlinWeek04", "$species 의 무게 : $weight kg")
        }
        fun makeSound(){
            Log.d("KotlinWeek04", "$species 가 소리를 냅니다.")
        }
    }
    val puppy = Animal("웰시코기", 10.5)
    val puppy2 = Animal("포메라니안", 10.0)
    val puppy3 = Animal("호랑이")
    puppy.makeSound()
    puppy2.makeSound()
    puppy3.makeSound()
}

private fun week04Collections(){
    println("=============== kotlin Collectrions =================")

    val fruits = listOf("apple", "banana", "orange") //리스트 추가 불가
    val mutableFruits = mutableListOf("kiwi", "watermelon") //리스트 추가 가능

    mutableFruits.add("banana")
    println("Fruits $fruits")
    println("Mutable Fruits: $mutableFruits")

    val scores = mapOf("Kim" to 100, "Park" to 96, "Lee" to 97)
    println("Scroes: $scores")

    for(fruit in mutableFruits) {
        println("I like $fruit")
    }

    scores.forEach{(name, score) -> println("$name scored $score")}
    fruits.forEach{fruit -> println("$fruit")}
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KotlinBasicsTheme {
        Greeting("Android")
    }
}