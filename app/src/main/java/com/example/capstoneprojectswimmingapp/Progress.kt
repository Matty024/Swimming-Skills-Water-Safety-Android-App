package com.example.capstoneprojectswimmingapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue



// Creating an object class used for Progress Tracking for each level:
object ProgressState {

    // Level 1 Lesson 1
    var l1Lesson1Exercise1Completed by mutableStateOf(false) //  Having the checked box in level 1 lesson 1 exercise 1 have a value of false this meent that the checked box will be unchecked when the user first opens the card and the use of mutableStateOf allows the program to change the value and remember it.
    var l1Lesson1Exercise2Completed by mutableStateOf(false)
    var l1Lesson1Exercise3Completed by mutableStateOf(false)
    var l1Lesson1Exercise4Completed by mutableStateOf(false)
    var l1Lesson1Exercise5Completed by mutableStateOf(false)
    var l1Lesson1Exercise6Completed by mutableStateOf(false)
    var l1Lesson1Exercise7Completed by mutableStateOf(false)
    var l1Lesson1Exercise8Completed by mutableStateOf(false)
    // Water Safety Question:
    var l1Lesson1WS1Completed by mutableStateOf(false)

    // Level 1 Lesson 2
    var l1Lesson2Exercise1Completed by mutableStateOf(false)
    var l1Lesson2Exercise2Completed by mutableStateOf(false)
    var l1Lesson2Exercise3Completed by mutableStateOf(false)
    var l1Lesson2Exercise4Completed by mutableStateOf(false)
    var l1Lesson2Exercise5Completed by mutableStateOf(false)
    var l1Lesson2Exercise6Completed by mutableStateOf(false)
    var l1Lesson2Exercise7Completed by mutableStateOf(false)
    var l1Lesson2Exercise8Completed by mutableStateOf(false)
    // Water Safety Question:
    var l1Lesson2WS1Completed by mutableStateOf(false)



    // Value used to calculate the total number of checked exercises:
    val level1CompletedExercises: Int
        // get is used to calculate the number of checked exercises:
        get() = listOf(
            // Level 2 Lesson 2 Questions:
            l1Lesson1Exercise1Completed, // Calling the exercise variable into the value count.
            l1Lesson1Exercise2Completed,
            l1Lesson1Exercise3Completed,
            l1Lesson1Exercise4Completed,
            l1Lesson1Exercise5Completed,
            l1Lesson1Exercise6Completed,
            l1Lesson1Exercise7Completed,
            l1Lesson1Exercise8Completed,
            // Water safety question for lesson 1
            l1Lesson1WS1Completed,

            // Level 1 Lesson 2 Questions:
            l1Lesson2Exercise1Completed,
            l1Lesson2Exercise2Completed,
            l1Lesson2Exercise3Completed,
            l1Lesson2Exercise4Completed,
            l1Lesson2Exercise5Completed,
            l1Lesson2Exercise6Completed,
            l1Lesson2Exercise7Completed,
            l1Lesson2Exercise8Completed,
            // Water safety question for lesson 2:
            l1Lesson2WS1Completed

        ).count { it } // where the count gose and is saved.

    // Comparing the number of checked exercise against the number of exerciser there are:
    val level1TotalExercises: Int
        get() = 18 // taking the total count from the get() and comparing it against the number of exercises there are.

    // Creating a value called level1ProgressPercent (used in the profile page for the progress tracking):
    val level1ProgressPercent: Int
        get() = (level1CompletedExercises * 100) / level1TotalExercises // getting the total progress by timesing all the exercise by 100 the dividing it by the number of exercises checked.


////////////////////////////////////////////////////////////////////////////////////////////////////


    // Level 2 Lesson 1:
    var l2Lesson1Exercise1Completed by mutableStateOf(false)
    var l2Lesson1Exercise2Completed by mutableStateOf(false)
    var l2Lesson1Exercise3Completed by mutableStateOf(false)
    var l2Lesson1Exercise4Completed by mutableStateOf(false)
    var l2Lesson1Exercise5Completed by mutableStateOf(false)
    var l2Lesson1Exercise6Completed by mutableStateOf(false)
    var l2Lesson1Exercise7Completed by mutableStateOf(false)
    var l2Lesson1Exercise8Completed by mutableStateOf(false)
    // Water Safety Question:
    var l2Lesson1WS1Completed by mutableStateOf(false)

    // Leve 2 Lesson 2:
    var l2Lesson2Exercise1Completed by mutableStateOf(false)
    var l2Lesson2Exercise2Completed by mutableStateOf(false)
    var l2Lesson2Exercise3Completed by mutableStateOf(false)
    var l2Lesson2Exercise4Completed by mutableStateOf(false)
    var l2Lesson2Exercise5Completed by mutableStateOf(false)
    var l2Lesson2Exercise6Completed by mutableStateOf(false)
    var l2Lesson2Exercise7Completed by mutableStateOf(false)
    var l2Lesson2Exercise8Completed by mutableStateOf(false)
    var l2Lesson2Exercise9Completed by mutableStateOf(false)
    // Water Safety Question:
    var l2Lesson2WS1Completed by mutableStateOf(false)

    val level2CompletedExercises: Int
        get() = listOf(
            l2Lesson1Exercise1Completed,
            l2Lesson1Exercise2Completed,
            l2Lesson1Exercise3Completed,
            l2Lesson1Exercise4Completed,
            l2Lesson1Exercise5Completed,
            l2Lesson1Exercise6Completed,
            l2Lesson1Exercise7Completed,
            l2Lesson1Exercise8Completed,
            l2Lesson1WS1Completed,

            l2Lesson2Exercise1Completed,
            l2Lesson2Exercise2Completed,
            l2Lesson2Exercise3Completed,
            l2Lesson2Exercise4Completed,
            l2Lesson2Exercise5Completed,
            l2Lesson2Exercise6Completed,
            l2Lesson2Exercise7Completed,
            l2Lesson2Exercise8Completed,
            l2Lesson2Exercise9Completed,
            l2Lesson2WS1Completed
        ).count { it }

    val level2TotalExercises: Int
        get() = 19

    val level2ProgressPercent: Int
        get() = (level2CompletedExercises * 100) / level2TotalExercises


////////////////////////////////////////////////////////////////////////////////////////////////////


    // Level 3: Lesson 1:
    var l3Lesson1Exercise1Completed by mutableStateOf(false)
    var l3Lesson1Exercise2Completed by mutableStateOf(false)
    var l3Lesson1Exercise3Completed by mutableStateOf(false)
    var l3Lesson1Exercise4Completed by mutableStateOf(false)
    var l3Lesson1Exercise5Completed by mutableStateOf(false)
    var l3Lesson1Exercise6Completed by mutableStateOf(false)
    var l3Lesson1Exercise7Completed by mutableStateOf(false)
    var l3Lesson1Exercise8Completed by mutableStateOf(false)
    var l3Lesson1Exercise9Completed by mutableStateOf(false)
    var l3Lesson1Exercise10Completed by mutableStateOf(false)
    // Water Safety Question:
    var l3Lesson1WS1Completed by mutableStateOf(false)

    // Level 3: Lesson 2:
    var l3Lesson2Exercise1Completed by mutableStateOf(false)
    var l3Lesson2Exercise2Completed by mutableStateOf(false)
    var l3Lesson2Exercise3Completed by mutableStateOf(false)
    var l3Lesson2Exercise4Completed by mutableStateOf(false)
    var l3Lesson2Exercise5Completed by mutableStateOf(false)
    var l3Lesson2Exercise6Completed by mutableStateOf(false)
    var l3Lesson2Exercise7Completed by mutableStateOf(false)
    // Water Safety Question:
    var l3Lesson2WS1Completed by mutableStateOf(false)

    val level3CompletedExercises: Int
        get() = listOf(
            l3Lesson1Exercise1Completed,
            l3Lesson1Exercise2Completed,
            l3Lesson1Exercise3Completed,
            l3Lesson1Exercise4Completed,
            l3Lesson1Exercise5Completed,
            l3Lesson1Exercise6Completed,
            l3Lesson1Exercise7Completed,
            l3Lesson1Exercise8Completed,
            l3Lesson1Exercise9Completed,
            l3Lesson1Exercise10Completed,
            l3Lesson1WS1Completed,

            l3Lesson2Exercise1Completed,
            l3Lesson2Exercise2Completed,
            l3Lesson2Exercise3Completed,
            l3Lesson2Exercise4Completed,
            l3Lesson2Exercise5Completed,
            l3Lesson2Exercise6Completed,
            l3Lesson2Exercise7Completed,
            l3Lesson2WS1Completed
        ).count { it }

    val level3TotalExercises: Int
        get() = 19

    val level3ProgressPercent: Int
        get() = (level3CompletedExercises * 100) / level3TotalExercises


////////////////////////////////////////////////////////////////////////////////////////////////////


    // Level 4: Lesson 1:
    var l4Lesson1Exercise1Completed by mutableStateOf(false)
    var l4Lesson1Exercise2Completed by mutableStateOf(false)
    var l4Lesson1Exercise3Completed by mutableStateOf(false)
    var l4Lesson1Exercise4Completed by mutableStateOf(false)
    var l4Lesson1Exercise5Completed by mutableStateOf(false)
    var l4Lesson1Exercise6Completed by mutableStateOf(false)
    var l4Lesson1Exercise7Completed by mutableStateOf(false)
    var l4Lesson1Exercise8Completed by mutableStateOf(false)
    var l4Lesson1Exercise9Completed by mutableStateOf(false)

    // Level 4: Lesson 2:
    var l4Lesson2Exercise1Completed by mutableStateOf(false)
    var l4Lesson2Exercise2Completed by mutableStateOf(false)
    var l4Lesson2Exercise3Completed by mutableStateOf(false)
    var l4Lesson2Exercise4Completed by mutableStateOf(false)
    var l4Lesson2Exercise5Completed by mutableStateOf(false)
    var l4Lesson2Exercise6Completed by mutableStateOf(false)
    var l4Lesson2Exercise7Completed by mutableStateOf(false)
    var l4Lesson2Exercise8Completed by mutableStateOf(false)
    var l4Lesson2Exercise9Completed by mutableStateOf(false)


    val level4CompletedExercises: Int
        get() = listOf(
            l4Lesson1Exercise1Completed,
            l4Lesson1Exercise2Completed,
            l4Lesson1Exercise3Completed,
            l4Lesson1Exercise4Completed,
            l4Lesson1Exercise5Completed,
            l4Lesson1Exercise6Completed,
            l4Lesson1Exercise7Completed,
            l4Lesson1Exercise8Completed,
            l4Lesson1Exercise9Completed,
            l4Lesson2Exercise1Completed,
            l4Lesson2Exercise2Completed,
            l4Lesson2Exercise3Completed,
            l4Lesson2Exercise4Completed,
            l4Lesson2Exercise5Completed,
            l4Lesson2Exercise6Completed,
            l4Lesson2Exercise7Completed,
            l4Lesson2Exercise8Completed,
            l4Lesson2Exercise9Completed
        ).count { it }

    val level4TotalExercises: Int
        get() = 18

    val level4ProgressPercent: Int
        get() = (level4CompletedExercises * 100) / level4TotalExercises


////////////////////////////////////////////////////////////////////////////////////////////////////


    // Level 5: lesson 1:
    var l5Lesson1Exercise1Completed by mutableStateOf(false)
    var l5Lesson1Exercise2Completed by mutableStateOf(false)
    var l5Lesson1Exercise3Completed by mutableStateOf(false)
    var l5Lesson1Exercise4Completed by mutableStateOf(false)
    var l5Lesson1Exercise5Completed by mutableStateOf(false)
    var l5Lesson1Exercise6Completed by mutableStateOf(false)
    var l5Lesson1Exercise7Completed by mutableStateOf(false)
    var l5Lesson1Exercise8Completed by mutableStateOf(false)
    var l5Lesson1Exercise9Completed by mutableStateOf(false)
    var l5Lesson1Exercise10Completed by mutableStateOf(false)

    // Level 5: Lesson 2:
    var l5Lesson2Exercise1Completed by mutableStateOf(false)
    var l5Lesson2Exercise2Completed by mutableStateOf(false)
    var l5Lesson2Exercise3Completed by mutableStateOf(false)
    var l5Lesson2Exercise4Completed by mutableStateOf(false)
    var l5Lesson2Exercise5Completed by mutableStateOf(false)
    var l5Lesson2Exercise6Completed by mutableStateOf(false)
    var l5Lesson2Exercise7Completed by mutableStateOf(false)
    var l5Lesson2Exercise8Completed by mutableStateOf(false)
    var l5Lesson2Exercise9Completed by mutableStateOf(false)



    val level5CompletedExercises: Int
        get() = listOf(
            l5Lesson1Exercise1Completed,
            l5Lesson1Exercise2Completed,
            l5Lesson1Exercise3Completed,
            l5Lesson1Exercise4Completed,
            l5Lesson1Exercise5Completed,
            l5Lesson1Exercise6Completed,
            l5Lesson1Exercise7Completed,
            l5Lesson1Exercise8Completed,
            l5Lesson1Exercise9Completed,
            l5Lesson1Exercise10Completed,
            l5Lesson2Exercise1Completed,
            l5Lesson2Exercise2Completed,
            l5Lesson2Exercise3Completed,
            l5Lesson2Exercise4Completed,
            l5Lesson2Exercise5Completed,
            l5Lesson2Exercise6Completed,
            l5Lesson2Exercise7Completed,
            l5Lesson2Exercise8Completed,
            l5Lesson2Exercise9Completed
        ).count { it }

    val level5TotalExercises: Int
        get() = 19

    val level5ProgressPercent: Int
        get() = (level5CompletedExercises * 100) / level5TotalExercises


////////////////////////////////////////////////////////////////////////////////////////////////////
    // Overall progress through all the levels:

    //
    fun currentLevelCompletedExercises(level: Int): Int {
        return when (level) {
            1 -> level1CompletedExercises
            2 -> level2CompletedExercises
            3 -> level3CompletedExercises
            4 -> level4CompletedExercises
            5 -> level5CompletedExercises
            else -> 0
        }
    }

    //
    fun currentLevelTotalExercises(level: Int): Int {
        return when (level) {
            1 -> level1TotalExercises
            2 -> level2TotalExercises
            3 -> level3TotalExercises
            4 -> level4TotalExercises
            5 -> level5TotalExercises
            else -> 0
        }
    }

    //
    fun currentLevelProgressPercent(level: Int): Int {
        return when (level) {
            1 -> level1ProgressPercent
            2 -> level2ProgressPercent
            3 -> level3ProgressPercent
            4 -> level4ProgressPercent
            5 -> level5ProgressPercent
            else -> 0
        }
    }

    //
    fun overallCompletedExercises(startingLevel: Int): Int {
        return when (startingLevel) {
            1 -> level1CompletedExercises + level2CompletedExercises + level3CompletedExercises + level4CompletedExercises + level5CompletedExercises
            2 -> level2CompletedExercises + level3CompletedExercises + level4CompletedExercises + level5CompletedExercises
            3 -> level3CompletedExercises + level4CompletedExercises + level5CompletedExercises
            4 -> level4CompletedExercises + level5CompletedExercises
            5 -> level5CompletedExercises
            else -> 0
        }
    }

    //
    fun overallTotalExercises(startingLevel: Int): Int {
        return when (startingLevel) {
            1 -> level1TotalExercises + level2TotalExercises + level3TotalExercises + level4TotalExercises + level5TotalExercises
            2 -> level2TotalExercises + level3TotalExercises + level4TotalExercises + level5TotalExercises
            3 -> level3TotalExercises + level4TotalExercises + level5TotalExercises
            4 -> level4TotalExercises + level5TotalExercises
            5 -> level5TotalExercises
            else -> 0
        }
    }

    //
    fun overallProgressPercent(startingLevel: Int): Int {
        val completed = overallCompletedExercises(startingLevel)
        val total = overallTotalExercises(startingLevel)
        return if (total > 0) (completed * 100) / total else 0
    }





////////////////////////////////////////////////////////////////////////////////////////////////////
    // Extra Lesson check box value:

    // Extra Lesson 1 (More Kick):
    var extraLesson1Exercise1Completed by mutableStateOf(false)
    var extraLesson1Exercise2Completed by mutableStateOf(false)
    var extraLesson1Exercise3Completed by mutableStateOf(false)
    var extraLesson1Exercise4Completed by mutableStateOf(false)
    var extraLesson1Exercise5Completed by mutableStateOf(false)



    // Extra Lesson 2 (FC Tech):
    var extraLesson2Exercise1Completed by mutableStateOf(false)
    var extraLesson2Exercise2Completed by mutableStateOf(false)
    var extraLesson2Exercise3Completed by mutableStateOf(false)
    var extraLesson2Exercise4Completed by mutableStateOf(false)
    var extraLesson2Exercise5Completed by mutableStateOf(false)
    var extraLesson2Exercise6Completed by mutableStateOf(false)
    var extraLesson2Exercise7Completed by mutableStateOf(false)



    // Extra Lesson 3 (BC Tech):
    var extraLesson3Exercise1Completed by mutableStateOf(false)
    var extraLesson3Exercise2Completed by mutableStateOf(false)
    var extraLesson3Exercise3Completed by mutableStateOf(false)
    var extraLesson3Exercise4Completed by mutableStateOf(false)
    var extraLesson3Exercise5Completed by mutableStateOf(false)
    var extraLesson3Exercise6Completed by mutableStateOf(false)
    var extraLesson3Exercise7Completed by mutableStateOf(false)
    var extraLesson3Exercise8Completed by mutableStateOf(false)
}