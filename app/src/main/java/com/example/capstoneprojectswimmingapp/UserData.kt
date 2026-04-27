package com.example.capstoneprojectswimmingapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import java.time.DayOfWeek


import java.time.LocalDate



// Creating an object class used for storing user information (mutableStateOf() is used to automatically update the variable if there are any changes to the value):
@RequiresApi(Build.VERSION_CODES.O)
object UserProfileState {

    // User info:
    var firstName by mutableStateOf("") // Creating a variable called firstName and defining it as mutableStateOf() (used to remember values and update them if the value is changed).
    var secondName by mutableStateOf("") // Creating a variable called secondName and defining it as mutableStateOf()
    var email by mutableStateOf("") // Creating a variable called email and defining it as mutableStateOf()

    // User preferences / ability:
    var startingLevel by mutableIntStateOf(1) // Creating a variable called startingLevel and defining it as mutableStateOf() (setting the value of the mutableStateOf() to numerical and having it start at 1 (level 1)).
    var preferredLessonDay by mutableStateOf("") // Creating a variable called preferredLessonDay and defining it as mutableStateOf()

    var onboardingDate by mutableStateOf(LocalDate.now()) // Creating a variable called onboardingDate and defining it as mutableStateOf() (setting the value of the mutableStateOf() to LocalDate (the date the app is first opened)).
}



// function used in the preferences page for selecting a day for lesson and used in profile page to change day:
@RequiresApi(Build.VERSION_CODES.O)
fun dayStringToDayOfWeek(day: String): DayOfWeek? {
    return when (day) {
        "Monday" -> DayOfWeek.MONDAY // converting the "Monday" string into same day but in. DayOfWeek
        "Tuesday" -> DayOfWeek.TUESDAY // // converting the "Tuesday" into DayOfWeek
        "Wednesday" -> DayOfWeek.WEDNESDAY // converting the "Wednesday" into DayOfWeek
        "Thursday" -> DayOfWeek.THURSDAY // converting the "Thursday" into DayOfWeek
        "Friday" -> DayOfWeek.FRIDAY // converting the "Friday" into DayOfWeek
        "Saturday" -> DayOfWeek.SATURDAY // converting the "Saturday" into DayOfWeek
        "Sunday" -> DayOfWeek.SUNDAY // converting the "Sunday" into DayOfWeek
        else -> null // in no day is selected or input is invalided return null
    }
}



// function that finds the first day that matches the users preferences and after first time opening:
@RequiresApi(Build.VERSION_CODES.O)
fun firstLessonDate(onboardingDate: LocalDate, preferredDay: DayOfWeek): LocalDate {
    var date = onboardingDate // Creating a variable called date and defining it as the onboardingDate

    // while loop that gose over every day after the onboarding until finding the first day that matches:
    while (date.dayOfWeek != preferredDay) {
        date = date.plusDays(1)
    }
    return date // returns that found date
}



// Function to find the week / lesson the user is currently on:
@RequiresApi(Build.VERSION_CODES.O)
fun weeksBetween(startDate: LocalDate, currentDate: LocalDate): Long {
    return java.time.temporal.ChronoUnit.WEEKS.between(startDate, currentDate) // counting how many days have passed to see what week / lesson the user is on.
}



// Function used to map the users starting level:
fun lessonStartIndexForLevel(level: Int): Int {
    return when (level) {
        1 -> 0 // Level 1 = 0
        2 -> 2 // Level 2 = 2
        3 -> 4 // Level 3 = 4
        4 -> 6 // Level 4 = 6
        5 -> 8 // Level 5 = 8
        else -> 0
    }
}
