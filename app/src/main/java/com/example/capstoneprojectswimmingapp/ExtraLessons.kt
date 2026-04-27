package com.example.capstoneprojectswimmingapp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import java.time.LocalDate


// Creating a data class called AddedLessons:
data class AddedLesson(
    // Adding some values to the AddedLesson class
    val title: String, // making a value called title and defining it as a string value.
    val time: String, // making a value called time and defining it as a string value.
    val description: String, // making a value called description and defining it as a string value.
    val route: String // making a value called route and defining it as a string value.
)


// Tracking the Added lessons:
@RequiresApi(Build.VERSION_CODES.O)
object LessonScheduleState { // storing lesson scheduled data.
    var selectedHomeDate by mutableStateOf(LocalDate.now()) // updating the localDate

    val addedLessons = mutableStateMapOf<LocalDate, AddedLesson>() // keeps track of all lessons (when lessons are added) and stores them by date.
}





////////////////////////////////////////////////////////////////////////////////////////////////////





// Extra Lesson 1 (More Kick):
@Composable
fun ExtraLesson1(navController : NavController){
    Scaffold(
        modifier = Modifier.fillMaxSize(), // Having the page fill the full size of the device using fillMaxSize.
        topBar = {
            LessonHeader(
                navController = navController, // calling the navController from the LessonHeader card.
                levelText = "Level 2-3:", // Letting the user Know what Level the extra lesson this is for.
                lessonText = "More KICK" //  Giving the Extra Lesson a title.
            )
        }
        // inner padding (where all the pages content goes)
    ) { innerPadding ->
        // adding a column into the page so that the items in the column follow in a line / list (one after another):
        LazyColumn(
            modifier = Modifier
                .fillMaxSize() // having the LazyColumn fill the hole page
                .background(Color(0xFFF7F7F7)) // Setting the color of the page.
                .padding(innerPadding) //
        ) {
            item {

                // Subtitle, letting the user know blow it the exercises for this page:
                Text(
                    text = "Exercises:", // Text letting the user know what is below
                    fontSize = 25.sp, // Making the Text 25.sp large.
                    modifier = Modifier.padding(20.dp) // adding some padding around the text.
                )


                // Exercises:

                // Calling the reusable Exercise Card composable:
                ExerciseCard(
                    title = "Exercise 1: Kick on the side", // Giving the card a title
                    description = "Holding onto the wall with 2 hand and fast kick, with legs extended behind, kicking from the hips, splashes coming from your feet.", // Adding in a description to the card
                    number = "30 seconds (X2)", // Giving the card a number of repetitions.
                    checked = ProgressState.extraLesson1Exercise1Completed, // Calling the checked clas from the ExerciseCard and defining it as the progressState and giving it a specific value for this exercise.
                    onCheckedChange = { ProgressState.extraLesson1Exercise1Completed = it } //
                )


                // Adding a Space Modifier.height to add some separation between the different exercises.
                Spacer(modifier = Modifier.height(10.dp))

                ExerciseCard(
                    title = "Exercise 2: Kick on front (with a board)",
                    description = "2 hand holding the out in front board, face in the water blowing bubbles, small fast kicks, kicking from your hips.",
                    number = "7m or 15m (X2)",
                    checked = ProgressState.extraLesson1Exercise2Completed,
                    onCheckedChange = { ProgressState.extraLesson1Exercise2Completed = it }
                )


                Spacer(modifier = Modifier.height(10.dp))


                ExerciseCard(
                    title = "Exercise 3: Kick on front (arms by side)",
                    description = "Arms glued to your sides, head in the water blowing bubbles, kicking from the hips pointy toes, small fast kicks",
                    number = "7m or 15m (X2)",
                    checked = ProgressState.extraLesson1Exercise3Completed,
                    onCheckedChange = { ProgressState.extraLesson1Exercise3Completed = it }
                )


                Spacer(modifier = Modifier.height(10.dp))


                ExerciseCard(
                    title = "Exercise 4: Kick on back (with a board)",
                    description = "Hugging board to chest, pushing tummy up, small fast kick, kicking from the hips, and having ponty toes.",
                    number = "7m or 15m (X2)",
                    checked = ProgressState.extraLesson1Exercise4Completed,
                    onCheckedChange = { ProgressState.extraLesson1Exercise4Completed = it }
                )


                Spacer(modifier = Modifier.height(10.dp))


                ExerciseCard(
                    title = "Exercise 5: Kick on back (arms by side)",
                    description = "Arms glued to your side, pushing tummy up, looking up at roof, small fast kick, kicking from the hips, and having ponty toes",
                    number = "7m or 15m (X2)",
                    checked = ProgressState.extraLesson1Exercise5Completed,
                    onCheckedChange = { ProgressState.extraLesson1Exercise5Completed = it }
                )


                // space separating the last exercise card and the add lesson button:
                Spacer(modifier = Modifier.height(20.dp))

                // Adding a column around the button so that the button can be aligned in the horizontal center:
                Column(
                    modifier = Modifier.fillMaxWidth(), // Making the column fill the max width of the page
                    horizontalAlignment = Alignment.CenterHorizontally // Having the content of the column aligned in the center (on the horizontal axiz)
                ) {
                    // Adding a button to the bottom of the page so that the user can add the extra lesson to the Home page:
                    Button(
                        // When the user clicks the button the following action in the {} will be carried out:
                        onClick = {
                            // Updating the Home page Lesson with the extra lesson:
                            LessonScheduleState.addedLessons[LessonScheduleState.selectedHomeDate] =

                                // Adding the lesson to the home page / adding a description of the lesson for the preview card:
                                AddedLesson(
                                    title = "More KICK (Level 2-3)", // giving the added lesson card a title.
                                    time = "20 minutes", // Letting the user know how long the lesson should take ruffly.
                                    description = "Developing kick on both back and front", // adding a description the added preview card.
                                    route = "ExtraLesson1" // defining where the user get taken if they click on the preview car in the home pge.
                                )

                            // navigating the user to the home page to show that the lesson has been added.
                            navController.navigate("Home") {
                                popUpTo("Home") { inclusive = false } // going back through the backstack until finding the home page
                                launchSingleTop = true // if home page is at the top don't go back (to avoid duplication)
                            }
                        },
                        // coloring the button the same light blue as the rest of the app.
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF659DF2), // Setting the color for the button
                            contentColor = Color.White // making the content in the button white.
                        )
                    ) {
                        Text("Add Lesson") // Text in the button / letting the user know what the button does.
                    }
                }


                // space separating the button and the bottom of the page:
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}



// Extra Lesson 2 (FC Tech):
@Composable
fun ExtraLesson2(navController : NavController){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            LessonHeader(
                navController = navController,
                levelText = "Level 4-5:",
                lessonText = "FC Technique"
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF7F7F7))
                .padding(innerPadding)
        ) {
            item {
                Text(
                    text = "Exercises:",
                    fontSize = 25.sp,
                    modifier = Modifier.padding(20.dp)
                )

                // Exercises:
                ExerciseCard(
                    title = "Exercise 1: FC kick (with a board)",
                    description = "2 hand holding the out in front board, face in the water blowing bubbles, small fast kicks, kicking from your hips.",
                    number = "15m or 25m (X1)",
                    checked = ProgressState.extraLesson2Exercise1Completed,
                    onCheckedChange = { ProgressState.extraLesson2Exercise1Completed = it }
                )

                Spacer(modifier = Modifier.height(10.dp))

                ExerciseCard(
                    title = "Exercise 2: FC kick (streamlined)",
                    description = "One hand on top of each other, arms squeezing ears, small fast kicks, kicking from your hips, pointy toes.",
                    number = "15m or 25m (X1)",
                    checked = ProgressState.extraLesson2Exercise2Completed,
                    onCheckedChange = { ProgressState.extraLesson2Exercise2Completed = it }
                )

                Spacer(modifier = Modifier.height(10.dp))

                ExerciseCard(
                    title = "Exercise 3: FC kick breathing to the side (with pull boy)",
                    description = "",
                    number = "15m or 25m (X2)",
                    checked = ProgressState.extraLesson2Exercise3Completed,
                    onCheckedChange = { ProgressState.extraLesson2Exercise3Completed = it }
                )

                Spacer(modifier = Modifier.height(10.dp))

                ExerciseCard(
                    title = "Exercise 4: FC single arm (with pull boy)",
                    description = "Holding pull boy in 1 hand, other arms comes out over the water, entering finger tips first next to pull boy, and pulling arms down to your side and repeat, turning head to the side to breath, keep kicks going. (note: best to try on the side before trying in the water)",
                    number = "15m or 25m (X2)",
                    checked = ProgressState.extraLesson2Exercise4Completed,
                    onCheckedChange = { ProgressState.extraLesson2Exercise4Completed = it }
                )

                Spacer(modifier = Modifier.height(10.dp))

                ExerciseCard(
                    title = "Exercise 5: FC high elbow",
                    description = "Both arms constantly moving, when 1 arm gose in the other arm comes out, elbow coming out of the water first as high as possible before stretching arm out and finger tips go in",
                    number = "15m or 25m (X2)",
                    checked = ProgressState.extraLesson2Exercise5Completed,
                    onCheckedChange = { ProgressState.extraLesson2Exercise5Completed = it }
                )

                Spacer(modifier = Modifier.height(10.dp))

                ExerciseCard(
                    title = "Exercise 6: FC opposite touch",
                    description = "Both arms constantly moving, before you take your arm out of the water you touch your opposite hip to the arm you are using.",
                    number = "15m or 25m (X2)",
                    checked = ProgressState.extraLesson2Exercise6Completed,
                    onCheckedChange = { ProgressState.extraLesson2Exercise6Completed = it }
                )

                Spacer(modifier = Modifier.height(10.dp))

                ExerciseCard(
                    title = "Exercise 7: FC Swim",
                    description = "Both arms constantly moving, when 1 arm gose in the other arm comes out, counting arms and breathing on every 3rd arm pull, small fast kicks, blowing bubbles.",
                    number = "15m or 25m (X2)",
                    checked = ProgressState.extraLesson2Exercise7Completed,
                    onCheckedChange = { ProgressState.extraLesson2Exercise7Completed = it }
                )



                Spacer(modifier = Modifier.height(20.dp))

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(
                        onClick = {
                            LessonScheduleState.addedLessons[LessonScheduleState.selectedHomeDate] =
                                AddedLesson(
                                    title = "FC Tech (Level 4-5)",
                                    time = "20 minutes",
                                    description = "FC skills & Technique",
                                    route = "ExtraLesson2"
                                )

                            navController.navigate("Home") {
                                popUpTo("Home") { inclusive = false }
                                launchSingleTop = true
                            }
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF659DF2),
                            contentColor = Color.White
                        )
                    ) {
                        Text("Add Lesson")
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}



// Extra Lesson number 3 (BC Tech):
@Composable
fun ExtraLesson3(navController : NavController){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            LessonHeader(
                navController = navController,
                levelText = "Level 4-5:",
                lessonText = "BC Technique"
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF7F7F7))
                .padding(innerPadding)
        ) {
            item {
                Text(
                    text = "Exercises:",
                    fontSize = 25.sp,
                    modifier = Modifier.padding(20.dp)
                )

                // Exercises:
                ExerciseCard(
                    title = "Exercise 1: BC kick (with a board)",
                    description = "Hugging board to chest, pushing tummy up, small fast kick, kicking from the hips, and having ponty toes",
                    number = "15m or 25m (X1)",
                    checked = ProgressState.extraLesson3Exercise1Completed, //
                    onCheckedChange = { ProgressState.extraLesson3Exercise1Completed = it }
                )

                Spacer(modifier = Modifier.height(10.dp))

                ExerciseCard(
                    title = "Exercise 2: BC kick (streamlined)",
                    description = "One hand on top of each other, arms squeezing ears, small fast kicks, kicking from your hips, pointy toes.",
                    number = "15m or 25m (X1)",
                    checked = ProgressState.extraLesson3Exercise2Completed,
                    onCheckedChange = { ProgressState.extraLesson3Exercise2Completed = it }
                )

                Spacer(modifier = Modifier.height(10.dp))

                ExerciseCard(
                    title = "Exercise 3: BC 6 kick roll",
                    description = "Arms, glowed to your sides, rolling so that one shoulder is out of the water and count dor 6 seconds before rolling aging to the other side and repeat for the distance (note: head stays still just shoulder rolling)",
                    number = "15m or 25m (X1)",
                    checked = ProgressState.extraLesson3Exercise3Completed,
                    onCheckedChange = { ProgressState.extraLesson3Exercise3Completed = it }
                )

                Spacer(modifier = Modifier.height(10.dp))

                ExerciseCard(
                    title = "Exercise 4: BC single arm (with a pull boy)",
                    description = "Hugging pull boy to chest in 1 hand, other amr starts by your side, thumb comes out over the water turning hand and pinky in, arm brushing ear as it gose in, making sure arms is strait. (note: try on the side first before in the water)",
                    number = "15m or 25m (X2)",
                    checked = ProgressState.extraLesson3Exercise4Completed,
                    onCheckedChange = { ProgressState.extraLesson3Exercise4Completed = it }
                )

                Spacer(modifier = Modifier.height(10.dp))

                ExerciseCard(
                    title = "Exercise 5: BC 6 count",
                    description = "One arm comes out of the water and goes in pinky first and you hold it there for 6 seconds before bring that arm down to your side and repeating on your other arm (note: make sure your shoulder comes out of the water every time your arm gose in)",
                    number = "15m or 25m (X2)",
                    checked = ProgressState.extraLesson3Exercise5Completed,
                    onCheckedChange = { ProgressState.extraLesson3Exercise5Completed = it }
                )

                Spacer(modifier = Modifier.height(10.dp))

                ExerciseCard(
                    title = "Exercise 6: BC shark",
                    description = "One arms acrose your stomach, then do single arms, every time your pinky gos ein the water your arms on your stomach comes out the water.",
                    number = "15m or 25m (X2)",
                    checked = ProgressState.extraLesson3Exercise6Completed,
                    onCheckedChange = { ProgressState.extraLesson3Exercise6Completed = it }
                )

                Spacer(modifier = Modifier.height(10.dp))

                ExerciseCard(
                    title = "Exercise 7: BC wave",
                    description = "Arms are constantly moving, when one hand come out start waving your hand before hand gos in (note: still make sure that your pinky gose in first)",
                    number = "15m or 25m (X2)",
                    checked = ProgressState.extraLesson3Exercise7Completed,
                    onCheckedChange = { ProgressState.extraLesson3Exercise7Completed = it }
                )

                Spacer(modifier = Modifier.height(10.dp))

                ExerciseCard(
                    title = "Exercise 8: BC Swim",
                    description = "Arms are constantly moving, when one hand gose in the other hand comes out, keeping fast kicks and strait arms.",
                    number = "15m or 25m (X2)",
                    checked = ProgressState.extraLesson3Exercise8Completed,
                    onCheckedChange = { ProgressState.extraLesson3Exercise8Completed = it }
                )



                Spacer(modifier = Modifier.height(20.dp))

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(
                        onClick = {
                            LessonScheduleState.addedLessons[LessonScheduleState.selectedHomeDate] =
                                AddedLesson(
                                    title = "BC Tech (Level 4-5)",
                                    time = "20 minutes",
                                    description = "BC skills & Technique",
                                    route = "ExtraLesson3"
                                )

                            navController.navigate("Home") {
                                popUpTo("Home") { inclusive = false }
                                launchSingleTop = true
                            }
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF659DF2),
                            contentColor = Color.White
                        )
                    ) {
                        Text("Add Lesson")
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

            }
        }
    }
}