package com.example.cs101_test.exercises

import java.time.temporal.TemporalAmount

object Part3ClassesAndObjects {
    // OBS!!! PLEASE NOTE THAT FROM NOW ON:
    // IN ALL EXERCISES WITH CLASSES AND INTERFACES IT IS IMPORTANT TO PUT THE ATTRIBUTES IN THE
    //      SAME ORDER AS WRITTEN IN THE EXERCISE DESCRIPTION ELSE IT WILL NOT PASS THE TEST!

    // IN ALL EXERCISES THAT INCLUDES A displayDetails FUNCTION, IT DOES NOT MATTER HOW YOU DISPLAY IT
    // AS LONG AS THE VALUES OF THE VARIABLES ARE INCLUDED IN THE PRINTED TEXT.
    // FOR EXAMPLE, displayDetails OUTPUT IN EXERCISE 1 COULD BE ANY OF THE FOLLOWING:
    // - "the title is CS101 testing, the author Jane Doe, and the price 199.0 DKK"
    // - "title: CS101 testing, author: Jane Doe, price: 199.0"
    // - "CS101 testing, 199.0, Jane Doe"
    // - ETC.

    // ---------------------- EXERCISE 1
    // Create a Book class with 3 attributes: title, author, and price (Double)
    // Add a method to display book details called displayDetails that prints title, author and price
    class Book(val title: String,val author: String,val price: Double){
        fun displayDetails(){
            println("Title $title, Author: $author, Price $price")
        }
    }

    // ---------------------- EXERCISE 2
    // Create a Student class with the attributes name, age, and grades (a list of integers)
    // The grades variable must not be in the contructor, but instead created inside the class.
    // Add methods to add a grade (addGrade), calculate the average grade (averageGrade as Double),
    // and display student details (displayDetails) which must print name, age and average grade
    class Student(val name: String,val age: Int){
        private val grades = mutableListOf<Int>()

        fun addGrade(grade: Int){
            grades.add(grade)
        }

        fun averageGrade(): Double{
            return if(grades.isNotEmpty()){
                grades.average()
            } else {
                0.0
            }
        }

        fun displayDetails() {
            println("Name: $name , Age: $age ,Average grade: ${averageGrade()}")
        }
    }

    // ---------------------- EXERCISE 3
    // Create a BankAccount class with the attributes accountNumber, balance (Double), and accountHolder
    // Add methods to deposit, withdraw, and display account details (displayDetails) which must include accountNumber, balance, and accountHolder
    // Ensure that the balance cannot be negative
    class BankAccount(val accountNumber: String,balance: Double,val accountHolder: String){

        var balance: Double = if (balance >= 0) balance else 0.0

        fun deposit(amount: Double) {
            if (amount > 0) {
                balance += amount
            } else {
                println("Deposit amount must be positive.")
            }
        }

        fun withdraw(amount: Double) {
            if (amount <= 0) {
                println("Withdrawal amount must be positive.")
            } else if (balance - amount < 0) {
                println("Insufficient funds. Cannot go below 0.")
            } else {
                balance -= amount
            }
        }
        fun displayDetails() {
            println("Account number: $accountNumber , Balance: $balance ,Account holder: $accountHolder")
        }
    }

    // ---------------------- EXERCISE 4
    // Create a Product class that includes a name (String) and price (Double)
    // Create a Shop class that contains a list of Product objects called products
    // Add methods to add a product (addProduct), remove a product (removeProduct), and print a list of all the products (listProducts)
    // Include a method to calculate and return the total value of all products in the shop (totalValue)
    // Additionally, create a filterProducts function that takes a minimum price (Double) and returns the products above that price
    open class Product(val name: String,var price: Double)

    class Shop {

        private val products = mutableListOf<Product>()

        fun addProduct(product: Product) {
            products.add(product)
        }

        fun removeProduct(product: Product) {
            products.remove(product)
        }

        fun listProducts() {
            for (product in products) {
                println("Name: ${product.name}, Price: ${product.price}")
            }
        }

        fun totalValue(): Double {
            return products.sumOf { it.price }
        }

        fun filterProducts(minPrice: Double): List<Product> {
            return products.filter { it.price > minPrice }
        }
    }
}
