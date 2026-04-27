package com.example.capstoneprojectswimmingapp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController



// Individual Lessons:
// Level 1 (Newbie):
@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun L1Lesson1(navController: NavController){ // Calling the navController.
    // Adding a Scaffold to the lesson page to insure a consistent app layout and that basic material design structure is implemented into the page:
    Scaffold(
        modifier = Modifier.fillMaxSize(), // Having the Scaffold fill the full size of the page / device
        // Adding a top bar to the top of the page:
        topBar = {
            // Calling the LessonHeader composable so that the header can be added to the lesson page
            LessonHeader(
                navController = navController, // calling the navController so that the back button can be used.
                levelText = "Level 1:", // calling the levelText value from the lessonHeader and defining it as level 1.
                lessonText = "Lesson 1" // calling the lessonText value from the lessonHeader and defining it as lesson 1.
            )
        }
        // where the content of the page goes:
    ) { innerPadding ->

        // adding a LazyColumn so that the text / items in the inner padding fallow in a list and when the app is running the page can be scrollable:
        LazyColumn(
            modifier = Modifier
                .fillMaxSize() // having the LazyColumn fill the full size of the page / device.
                .background(Color(0xFFF7F7F7)) // setting the color of the LazyColumn
                .padding(innerPadding) // adding padding to the LazyColumn.
        ) {
            // Item is used to house the content of the lazyColumn:
            item {
                // Subtitle, letting the user know blow it the exercises for this page:
                Text(
                    text = "Exercises:", // Text letting the user know what is below
                    fontSize = 25.sp, // setting the font size for the text
                    modifier = Modifier.padding(20.dp) // adding some padding around the text.
                )

                // Exercises:

                // Exercise 1:
                // Calling the reusable Exercise Card composable:
                ExerciseCard(
                    title = "Exercise 1: Entering the water (by the side)", //  Giving the card a title
                    description = "Sit down on the side of the pool, put 2 hands to 1 side and turn body and slide into the water.", // Adding in a description to the card
                    number = "", // Giving the card a number of repetitions.
                    checked = ProgressState.l1Lesson1Exercise1Completed, // Calling the checked clas from the ExerciseCard and defining it as the progressState and giving it a specific value for this exercise.
                    onCheckedChange = {
                        ProgressState.l1Lesson1Exercise1Completed = it
                    } // When the user clicks the checked box in the lesson progress page the l1Lesson1Exercise1Completed will be ticked as done (go from a false value to a true value) and then be counted in the level progress.
                )

                // Adding a Space Modifier.height to add some separation between the different exercises.
                Spacer(modifier = Modifier.height(10.dp))

                // Exercise 2:
                ExerciseCard(
                    title = "Exercise 2: Blowing bubbles",
                    description = "Put mouth in the water and blow out with your mouth.",
                    number = "",
                    checked = ProgressState.l1Lesson1Exercise2Completed,
                    onCheckedChange = { ProgressState.l1Lesson1Exercise2Completed = it }
                )

                Spacer(modifier = Modifier.height(10.dp))

                // Exercise 3:
                ExerciseCard(
                    title = "Exercise 3: Kick on front (with a noodle and bored)",
                    description = "Put a noodle round you, under your armpits, and hold a board out in front in both hands (if able put head in the water), blowing bubbles, small fast kicks kicking from your hips, pointy tose. ",
                    number = "7m and back X2",
                    checked = ProgressState.l1Lesson1Exercise3Completed,
                    onCheckedChange = { ProgressState.l1Lesson1Exercise3Completed = it }
                )

                Spacer(modifier = Modifier.height(10.dp))

                // Exercise 4:
                ExerciseCard(
                    title = "Exercise 4: Kick on front (with a board)",
                    description = "2 hand holding the out in front board, face in the water blowing bubbles, small fast kicks, kicking from your hips.",
                    number = "7m and back X2",
                    checked = ProgressState.l1Lesson1Exercise4Completed,
                    onCheckedChange = { ProgressState.l1Lesson1Exercise4Completed = it }
                )

                Spacer(modifier = Modifier.height(10.dp))

                // Exercise 5:
                ExerciseCard(
                    title = "Exercise 5: Kick on front (arms by side)",
                    description = "Arms glued to your sides, head in the water blowing bubbles, kicking from the hips pointy toes, small fast kicks",
                    number = "7m and back X2",
                    checked = ProgressState.l1Lesson1Exercise5Completed,
                    onCheckedChange = { ProgressState.l1Lesson1Exercise5Completed = it }
                )

                Spacer(modifier = Modifier.height(10.dp))

                // Exercise 6:
                ExerciseCard(
                    title = "Exercise 6: Floating (star float on front) (with and without a noodle)",
                    description = "Face in the water, arms and legs stretched apart, holding for 5 seconds",
                    number = "For 5 seconds X2",
                    checked = ProgressState.l1Lesson1Exercise6Completed,
                    onCheckedChange = { ProgressState.l1Lesson1Exercise6Completed = it }
                )

                Spacer(modifier = Modifier.height(10.dp))

                // Exercise 7:
                ExerciseCard(
                    title = "Exercise 7: Exiting the pool (using the stairs)",
                    description = "hand holding each railing, climbing out 1 step at a time",
                    number = "",
                    checked = ProgressState.l1Lesson1Exercise7Completed,
                    onCheckedChange = { ProgressState.l1Lesson1Exercise7Completed = it }
                )

                Spacer(modifier = Modifier.height(10.dp))


                // Exercise 8:
                ExerciseCard(
                    title = "Exercise 8: Jumping in (into a noodle)",
                    description = "Toes over the edg, arms by side, jumping forward away from the wall, entering the water feet first.",
                    number = "X2",
                    checked = ProgressState.l1Lesson1Exercise8Completed,
                    onCheckedChange = { ProgressState.l1Lesson1Exercise8Completed = it }
                )

                Spacer(modifier = Modifier.height(10.dp))

                // Water safety awareness question:
                // adding a title to let the user know what this section is about:
                Text(
                    text = "Water Safety", // Naming the text function
                    fontSize = 25.sp, // Setting the size of the text
                    modifier = Modifier.padding(20.dp) // adding some padding to the text
                )

                // Calling the reusable water safety card:
                WaterSafetyCard(
                    questionTitle = "Water Safety Question 1", // adding the title ot the reusable question title
                    questionText = "What should you do before getting into the water?", // adding the question to the reusable question text box
                    // adding the list of posable answers to the relabeled options section:
                    options = listOf(
                        "Jump straight in",
                        "Check the area is safe",
                        "Push someone else in",
                        "Run at the pool edge"
                    ),
                    correctAnswer = "Check the area is safe", // Stating witch of the answers in the options list is correct.
                    completed = ProgressState.l1Lesson1WS1Completed, // // Calling the completed class from the water safety card and defining it as the progressState and giving it a specific value for this exercise.
                    onCorrectAnswer = { ProgressState.l1Lesson1WS1Completed = true } // updating the progress state to true to lett the app know that the answer has been correctly answered.
                )
            }
        }
    }
}


// Lesson 2:
@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun L1Lesson2(navController: NavController){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            LessonHeader(
                navController = navController,
                levelText = "Level 1:",
                lessonText = "Lesson 2"
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
            }

            // Exercises:
            item {
                ExerciseCard(
                    title = "Exercise 1: Entering the water (by stairs)",
                    description = "hand holding each railing, climbing in 1 step at a time",
                    number = "",
                    checked = ProgressState.l1Lesson2Exercise1Completed,
                    onCheckedChange = { ProgressState.l1Lesson2Exercise1Completed = it }
                )
            }

            item { Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 2: Bob's (on the side)",
                    description = "Both hands holding the wall, moving up and down, putting head under the water and back out 5 times.",
                    number = "X5",
                    checked = ProgressState.l1Lesson2Exercise2Completed,
                    onCheckedChange = { ProgressState.l1Lesson2Exercise2Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 3: Kick on back (with a noodle)",
                    description = "Noodle on back, head lining back looking up at the roof, pushing tummy up to the roof, small fast kick, kicking from the hips, and having ponty toes",
                    number = "7m and back X2",
                    checked = ProgressState.l1Lesson2Exercise3Completed,
                    onCheckedChange = { ProgressState.l1Lesson2Exercise3Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 4: Kick on back (hugging a board)",
                    description = "Hugging board to chest, pushing tummy up, small fast kick, kicking from the hips, and having ponty toes",
                    number = "7m and back X2",
                    checked = ProgressState.l1Lesson2Exercise4Completed,
                    onCheckedChange = { ProgressState.l1Lesson2Exercise4Completed = it }
                )
            }

            item { Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 5: Kick on back (arms by side)",
                    description = "Arms glued to your side, pushing tummy up, looking up at roof, small fast kick, kicking from the hips, and having ponty toes",
                    number = "7m and back X2",
                    checked = ProgressState.l1Lesson2Exercise5Completed,
                    onCheckedChange = { ProgressState.l1Lesson2Exercise5Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 6: Floating (star float on back) (with and without a noodle)",
                    description = "Leaning back, looking up at the roof, pushing tummy all the way up out of the water, arms and legs stretched apart, holding for 5 seconds",
                    number = "For 5 seconds X2",
                    checked = ProgressState.l1Lesson2Exercise6Completed,
                    onCheckedChange = { ProgressState.l1Lesson2Exercise6Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 7: Pencil floats on back and front (with a noodle)",
                    description = "One hand on top of each other, arms squeezing ears, legs glued together. \n On front: face in the water blowing bubbles. \n on Back: looking up at the roof, pushing tummy up out of the water.",
                    number = "For 5 seconds X2",
                    checked = ProgressState.l1Lesson2Exercise7Completed,
                    onCheckedChange = { ProgressState.l1Lesson2Exercise7Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 8: Jumping in (into a noodle)",
                    description = "Toes over the edg, arms by side, jumping forward away from the wall, entering the water feet first.",
                    number = "X2",
                    checked = ProgressState.l1Lesson2Exercise8Completed,
                    onCheckedChange = { ProgressState.l1Lesson2Exercise8Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            // Water safety awareness question:
            item {
                Text(
                    text = "Water Safety:",
                    fontSize = 25.sp,
                    modifier = Modifier.padding(20.dp)
                )
            }

            item {
                WaterSafetyCard(
                    questionTitle = "Water Safety Question 1",
                    questionText = "If you see someone drowning or in trouble in the water what should you do?",
                    options = listOf(
                        "Panic",
                        "Tell an adult / lifeguard",
                        "Nothing",
                        "Save them yourself"
                    ),
                    correctAnswer = "Tell an adult / lifeguard",
                    completed = ProgressState.l1Lesson1WS1Completed,
                    onCorrectAnswer = { ProgressState.l1Lesson1WS1Completed = true }
                )
            }
        }
    }
}



////////////////////////////////////////////////////////////////////////////////////////////////////
// Level 2:



// Lesson 1:
@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun L2Lesson1(navController: NavController){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            LessonHeader(
                navController = navController,
                levelText = "Level 2:",
                lessonText = "Lesson 1"
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
            }

            // Exercises:
            item {
                ExerciseCard(
                    title = "Exercise 1: BRS legs (on the side)",
                    description = "Sitting on the edg of the pool legs out in front, bring both feet to the wall, turn feet out  (like penguins) and snap legs round in a circle.",
                    number = "X5",
                    checked = ProgressState.l2Lesson1Exercise1Completed,
                    onCheckedChange = { ProgressState.l2Lesson1Exercise1Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 2: Jumping in (with or without a noodle)",
                    description = "Toes over the edg, arms by side, jumping forward away from the wall, entering the water feet first.",
                    number = "X3 (Soldier, Pencil, Star)",
                    checked = ProgressState.l2Lesson1Exercise2Completed,
                    onCheckedChange = { ProgressState.l2Lesson1Exercise2Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 3: Blowing bubbles",
                    description = "Put mouth in the water and blow out with your mouth.",
                    number = "",
                    checked = ProgressState.l2Lesson1Exercise3Completed,
                    onCheckedChange = { ProgressState.l2Lesson1Exercise3Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 4: FC kick (with a board)",
                    description = "2 hand holding the out in front board, face in the water blowing bubbles, small fast kicks, kicking from your hips.",
                    number = "7m and back",
                    checked = ProgressState.l2Lesson1Exercise4Completed,
                    onCheckedChange = { ProgressState.l2Lesson1Exercise4Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 5: FC kick (arms by side)",
                    description = "Arms glued to your sides, head in the water blowing bubbles, kicking from the hips pointy toes, small fast kicks",
                    number = "7m and back (X2)",
                    checked = ProgressState.l2Lesson1Exercise5Completed,
                    onCheckedChange = { ProgressState.l2Lesson1Exercise5Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 6: Single arm FC (with pull boy)",
                    description = "Holding pull boy in 1 hand, other arms comes out over the water, entering finger tips first next to pull boy, and pulling arms down to your side and repeat, keep kicks going. (note: best to try on the side before trying in the water)",
                    number = "7m and back (X2)",
                    checked = ProgressState.l2Lesson1Exercise6Completed,
                    onCheckedChange = { ProgressState.l2Lesson1Exercise6Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 7: FC swim",
                    description = "Both arms constantly moving, when 1 arm gose in the other arm comes out, small fast kicks, blowing bubbles.",
                    number = "7m and back (X2)",
                    checked = ProgressState.l2Lesson1Exercise7Completed,
                    onCheckedChange = { ProgressState.l2Lesson1Exercise7Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 8: Floating (Star, pencil, and mushroom floats)",
                    description = "Star float into a pencil float: arms and legs stretched apart in a big star hold for 5 seconds then bring arms and legs together (Repeat on back and front) \n mushroom float: bring legs up to chest, rap arms around legs, tuck chin in and hold for as long as possible.",
                    number = "(X3)",
                    checked = ProgressState.l2Lesson1Exercise8Completed,
                    onCheckedChange = { ProgressState.l2Lesson1Exercise8Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            // Water safety awareness question:
            item {
                Text(
                    text = "Water Safety:",
                    fontSize = 25.sp,
                    modifier = Modifier.padding(20.dp)
                )
            }

            item {
                WaterSafetyCard(
                    questionTitle = "Water Safety Question 1",
                    questionText = "What should you do after using equipment from the pool?",
                    options = listOf(
                        "Leave it in the water",
                        "Throw it",
                        "Put it away",
                        "Take it home"
                    ),
                    correctAnswer = "Put it away",
                    completed = ProgressState.l1Lesson1WS1Completed,
                    onCorrectAnswer = { ProgressState.l1Lesson1WS1Completed = true }
                )
            }
        }
    }
}



// Lesson 2:
@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun L2Lesson2(navController: NavController){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            LessonHeader(
                navController = navController,
                levelText = "Level 2:",
                lessonText = "Lesson 2"
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
            }

            // Exercises:
            item {
                ExerciseCard(
                    title = "Exercise 1: Entering water (by side)",
                    description = "Sit down on the side of the pool, put 2 hands to 1 side and turn body and slide into the water.",
                    number = "",
                    checked = ProgressState.l2Lesson2Exercise1Completed,
                    onCheckedChange = { ProgressState.l2Lesson2Exercise1Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 2: Push and glides (with a noodle)",
                    description = "One hand holding the wall, one arm out in front holding a noodle, both feet on the wall, put face in the water and push of the wall, putting both hand on the noodle and gliding for as long as possible.",
                    number = "(X2)",
                    checked = ProgressState.l2Lesson2Exercise2Completed,
                    onCheckedChange = { ProgressState.l2Lesson2Exercise2Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 3: BC kick (with a board)",
                    description = "Hugging board to chest, pushing tummy up, small fast kick, kicking from the hips, and having ponty toes",
                    number = "7m and back",
                    checked = ProgressState.l2Lesson2Exercise3Completed,
                    onCheckedChange = { ProgressState.l2Lesson2Exercise3Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 4: BC kick (arms by side)",
                    description = "Arms glued to your side, pushing tummy up, looking up at roof, small fast kick, kicking from the hips, and having ponty toes",
                    number = "7m and back",
                    checked = ProgressState.l2Lesson2Exercise4Completed,
                    onCheckedChange = { ProgressState.l2Lesson2Exercise4Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 5: Single arm BC (with pull boy)",
                    description = "Hugging pull boy to chest in 1 hand, other amr starts by your side, thumb comes out over the water turning hand and pinky in, arm brushing ear as it gose in, making sure arms is strait. (note: try on the side first before in the water)",
                    number = "7m and back",
                    checked = ProgressState.l2Lesson2Exercise5Completed,
                    onCheckedChange = { ProgressState.l2Lesson2Exercise5Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 6: BC Swim",
                    description = "Arms are constantly moving, when one hand gose in the other hand comes out, keeping fast kicks and strait arms.",
                    number = "7m and back (X2)",
                    checked = ProgressState.l2Lesson2Exercise6Completed,
                    onCheckedChange = { ProgressState.l2Lesson2Exercise6Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 7: Sculling (with a noodle)",
                    description = "Make a cup shape with your hands, arms are out in front, pushing the water away and pulling the water in, make sure to turn your hand as you do this.",
                    number = "7m and back",
                    checked = ProgressState.l2Lesson2Exercise7Completed,
                    onCheckedChange = { ProgressState.l2Lesson2Exercise7Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 8: Butterfly wiggles (with a noodle)",
                    description = "Legs glued together, arms above head holding a noodle hips moving back and forth, keeping arms and head still. (not best to try on the side first)",
                    number = "7m and back",
                    checked = ProgressState.l2Lesson2Exercise8Completed,
                    onCheckedChange = { ProgressState.l2Lesson2Exercise8Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 9: Butterfly wiggles (Arms by side)",
                    description = "Arms glued to your side, hips moving back and forth, keeping head still.",
                    number = "7m and back",
                    checked = ProgressState.l2Lesson2Exercise9Completed,
                    onCheckedChange = { ProgressState.l2Lesson2Exercise9Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            // Water safety awareness question:
            item {
                Text(
                    text = "Water Safety:",
                    fontSize = 25.sp,
                    modifier = Modifier.padding(20.dp)
                )
            }

            item {
                WaterSafetyCard(
                    questionTitle = "Water Safety Question 1",
                    questionText = "What should you do if an alarm sounds?",
                    options = listOf(
                        "Stay in the water",
                        "Follow the instructions from the lifeguard",
                        "Panic",
                        "Run out the building as fast as possible"
                    ),
                    correctAnswer = "Follow the instructions from the lifeguard",
                    completed = ProgressState.l1Lesson1WS1Completed,
                    onCorrectAnswer = { ProgressState.l1Lesson1WS1Completed = true }
                )
            }
        }
    }
}




////////////////////////////////////////////////////////////////////////////////////////////////////
// Level 3:



// Lesson 1:
@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun L3Lesson1(navController: NavController){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            LessonHeader(
                navController = navController,
                levelText = "Level 3:",
                lessonText = "Lesson 1"
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
            }

            // Exercises:
            item {
                ExerciseCard(
                    title = "Exercise 1: Sitting Dive",
                    description = "Legs in the water, feet on the wall, arms squeezing ears, finger tips pointing down to the water, fall ing froward finger tips first, make sure to keep head down.",
                    number = "(X3)",
                    checked = ProgressState.l3Lesson1Exercise1Completed,
                    onCheckedChange = { ProgressState.l3Lesson1Exercise1Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 2: BRS kick (on the side)",
                    description = "Sitting on the edg of the pool legs out in front, bring both feet to the wall, turn feet out  (like penguins) and snap legs round in a circle.",
                    number = "5 legs",
                    checked = ProgressState.l3Lesson1Exercise2Completed,
                    onCheckedChange = { ProgressState.l3Lesson1Exercise2Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 3: BRS kick on back (with a noodle)",
                    description = "Noodle on your back, legs out in front, bring legs in, turn feet out and snap round",
                    number = "15m and back",
                    checked = ProgressState.l3Lesson1Exercise3Completed,
                    onCheckedChange = { ProgressState.l3Lesson1Exercise3Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 4: Push and glide",
                    description = "One hand holding the wall, one arm out in front, both feet on the wall, put face in the water and push of the wall, into streamlined position and gliding for as long as possible.",
                    number = "(X2)",
                    checked = ProgressState.l3Lesson1Exercise4Completed,
                    onCheckedChange = { ProgressState.l3Lesson1Exercise4Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 5: FC kick (with a board)",
                    description = "2 hand holding the out in front board, face in the water blowing bubbles, small fast kicks, kicking from your hips.",
                    number = "15m and back",
                    checked = ProgressState.l3Lesson1Exercise5Completed,
                    onCheckedChange = { ProgressState.l3Lesson1Exercise5Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 6: FC kick (streamlined)",
                    description = "One hand on top of each other, arms squeezing ears, small fast kicks, kicking from your hips, pointy toes.",
                    number = "15m and back",
                    checked = ProgressState.l3Lesson1Exercise6Completed,
                    onCheckedChange = { ProgressState.l3Lesson1Exercise6Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 7: FC kick breathing to the side (with pull boy)",
                    description = "One arm out in front holding a pull boy, one arm by side, small fast kicks, turning head to the side away form arm holding pull boy, plowing bubbles when face is in the water and then a quick breath in.",
                    number = "15m and back (X2)",
                    checked = ProgressState.l3Lesson1Exercise7Completed,
                    onCheckedChange = { ProgressState.l3Lesson1Exercise7Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 8: Single arm FC (with pull boy)",
                    description = "Holding pull boy in 1 hand, other arms comes out over the water, entering finger tips first next to pull boy, and pulling arms down to your side and repeat, turning head to the side to breath, keep kicks going. (note: best to try on the side before trying in the water)",
                    number = "15m and back (X2)",
                    checked = ProgressState.l3Lesson1Exercise8Completed,
                    onCheckedChange = { ProgressState.l3Lesson1Exercise8Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 9: FC Swim",
                    description = "Both arms constantly moving, when 1 arm gose in the other arm comes out, counting arms and breathing on every 3rd arm pull, small fast kicks, blowing bubbles.",
                    number = "15m and back (X2)",
                    checked = ProgressState.l3Lesson1Exercise9Completed,
                    onCheckedChange = { ProgressState.l3Lesson1Exercise9Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 10: Sculling (on back) (with and without a noodle)",
                    description = "Arms by your side in a cup shape, palms of your hands pointing down at your feet, pulling the water out and in, keeping legs glued together, not moving.",
                    number = "15m and back (X2)",
                    checked = ProgressState.l3Lesson1Exercise10Completed,
                    onCheckedChange = { ProgressState.l3Lesson1Exercise10Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            // Water safety awareness question:
            item {
                Text(
                    text = "Water Safety:",
                    fontSize = 25.sp,
                    modifier = Modifier.padding(20.dp)
                )
            }

            item {
                WaterSafetyCard(
                    questionTitle = "Water Safety Question 1",
                    questionText = "Should you go swimming Alone?",
                    options = listOf(
                        "Yes you should",
                        "No you shouldn't",
                        "If your strong enough",
                    ),
                    correctAnswer = "No you shouldn't",
                    completed = ProgressState.l1Lesson1WS1Completed,
                    onCorrectAnswer = { ProgressState.l1Lesson1WS1Completed = true }
                )
            }
        }
    }
}



// Lesson 2:
@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun L3Lesson2(navController: NavController){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            LessonHeader(
                navController = navController,
                levelText = "Level 3:",
                lessonText = "Lesson 2"
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
            }

            // Exercises:
            item {
                ExerciseCard(
                    title = "Exercise 1: BRS kick on back (with a noodle)",
                    description = "Noodle on your back, legs out in front, bring legs in, turn feet out and snap round.",
                    number = "15m and back",
                    checked = ProgressState.l3Lesson2Exercise1Completed,
                    onCheckedChange = { ProgressState.l3Lesson2Exercise1Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 2: BRS kick on front (with a noodle)",
                    description = "Noodle on front and make a window with it, hold on to the window and keep your head out the water, legs out behind you, bring legs in, turn feet out and snap round, make sure to keep legs in the water.",
                    number = "15m and back",
                    checked = ProgressState.l3Lesson2Exercise2Completed,
                    onCheckedChange = { ProgressState.l3Lesson2Exercise2Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 3: FLY wiggles (with or without a noodle)",
                    description = "Hips moving back and forth, legs glued together \n With a noodle: keep arms and head still \n Without: arms by side keeping head still.",
                    number = "7m and back (X2)",
                    checked = ProgressState.l3Lesson2Exercise3Completed,
                    onCheckedChange = { ProgressState.l3Lesson2Exercise3Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 4: BC kick (with a board)",
                    description = "Hugging board to chest, pushing tummy up, small fast kick, kicking from the hips, and having ponty toes",
                    number = "15m and back",
                    checked = ProgressState.l3Lesson2Exercise4Completed,
                    onCheckedChange = { ProgressState.l3Lesson2Exercise4Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 5: BC kick (Streamlined)",
                    description = "One hand on top of each other, arms squeezing ears, small fast kicks, kicking from your hips, pointy toes.",
                    number = "15m and back",
                    checked = ProgressState.l3Lesson2Exercise5Completed,
                    onCheckedChange = { ProgressState.l3Lesson2Exercise5Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 6: Single arm BC (with pull boy)",
                    description = "Hugging pull boy to chest in 1 hand, other amr starts by your side, thumb comes out over the water turning hand and pinky in, arm brushing ear as it gose in, making sure arms is strait. (note: try on the side first before in the water)",
                    number = "15m and back (X2)",
                    checked = ProgressState.l3Lesson2Exercise6Completed,
                    onCheckedChange = { ProgressState.l3Lesson2Exercise6Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 7: BC swim",
                    description = "Arms are constantly moving, when one hand gose in the other hand comes out, keeping fast kicks and strait arms.",
                    number = "15m and back (X2)",
                    checked = ProgressState.l3Lesson2Exercise7Completed,
                    onCheckedChange = { ProgressState.l3Lesson2Exercise7Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            // Water safety awareness question:
            item {
                Text(
                    text = "Water Safety:",
                    fontSize = 25.sp,
                    modifier = Modifier.padding(20.dp)
                )
            }

            item {
                WaterSafetyCard(
                    questionTitle = "Water Safety Question 1",
                    questionText = "Why should you check the water before jumping / going in?",
                    options = listOf(
                        "There could be people",
                        "The water could be shallow",
                        "There could be sharp rocks under the water",
                        "All of the above"
                    ),
                    correctAnswer = "All of the above",
                    completed = ProgressState.l1Lesson1WS1Completed,
                    onCorrectAnswer = { ProgressState.l1Lesson1WS1Completed = true }
                )
            }
        }
    }
}




///////////////////////////////////////////////////////////////////////////////////////////////////
// Level 4:



// Lesson 1:
@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun L4Lesson1(navController: NavController){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            LessonHeader(
                navController = navController,
                levelText = "Level 4:",
                lessonText = "Lesson 1"
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
            }

            // Exercises:
            item {
                ExerciseCard(
                    title = "Exercise 1: Standing Dive",
                    description = "Both feet on the edg, arms squeezing ears, finger tip pointing down at the water and dive in entering finger tips first, make sure to keep head down (note: can try crouching dive fist)",
                    number = "(X2)",
                    checked = ProgressState.l4Lesson1Exercise1Completed,
                    onCheckedChange = { ProgressState.l4Lesson1Exercise1Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 2: Forward roles",
                    description = "push of the wall into a glide, after bring arms down, tuck chin and bring legs up and roll round (note: best to tru forward roll out of the water, on something soft)",
                    number = "(X2)",
                    checked = ProgressState.l4Lesson1Exercise2Completed,
                    onCheckedChange = { ProgressState.l4Lesson1Exercise2Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 3: FC kick (with a board)",
                    description = "2 hand holding the out in front board, face in the water blowing bubbles, small fast kicks, kicking from your hips.",
                    number = "25m",
                    checked = ProgressState.l4Lesson1Exercise3Completed,
                    onCheckedChange = { ProgressState.l4Lesson1Exercise3Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 4: FC kick (streamlined)",
                    description = "One hand on top of each other, arms squeezing ears, small fast kicks, kicking from your hips, pointy toes.",
                    number = "25m",
                    checked = ProgressState.l4Lesson1Exercise4Completed,
                    onCheckedChange = { ProgressState.l4Lesson1Exercise4Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 5: FC kick breathing to the side (with pull boy)",
                    description = "One arm out in front holding a pull boy, one arm by side, small fast kicks, turning head to the side away form arm holding pull boy, plowing bubbles when face is in the water and then a quick breath in.",
                    number = "25m (X2)",
                    checked = ProgressState.l4Lesson1Exercise5Completed,
                    onCheckedChange = { ProgressState.l4Lesson1Exercise5Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 6: Single arm FC (with pull boy)",
                    description = "Holding pull boy in 1 hand, other arms comes out over the water, entering finger tips first next to pull boy, and pulling arms down to your side and repeat, turning head to the side to breath, keep kicks going.",
                    number = "25m (X2)",
                    checked = ProgressState.l4Lesson1Exercise6Completed,
                    onCheckedChange = { ProgressState.l4Lesson1Exercise6Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 7: FC swim",
                    description = "Both arms constantly moving, when 1 arm gose in the other arm comes out, counting arms and breathing on every 3rd arm pull, small fast kicks, blowing bubbles.",
                    number = "25m (X2)",
                    checked = ProgressState.l4Lesson1Exercise7Completed,
                    onCheckedChange = { ProgressState.l4Lesson1Exercise7Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 8: FLY wiggles (arms by side and streamlined)",
                    description = "Legs glued together hips moving back and forth, wiggling from the hips \n Arms by side: arms glued to your side, keeping head still \n Streamlined: arms squeezing ears, keeping arms and head still.",
                    number = "15m and back (X2)",
                    checked = ProgressState.l4Lesson1Exercise8Completed,
                    onCheckedChange = { ProgressState.l4Lesson1Exercise8Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 9: 4 FLY arms (Swim)",
                    description = "Both arms come out over the water at the same time, entering the water in front of you, keeping arms strait, 2 wiggles to every 1 arm. (note: best to try out of the water first)",
                    number = "4 FLY arms (X2)",
                    checked = ProgressState.l4Lesson1Exercise9Completed,
                    onCheckedChange = { ProgressState.l4Lesson1Exercise9Completed = it }
                )
            }
        }
    }
}



// Lesson 2:
@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun L4Lesson2(navController: NavController){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            LessonHeader(
                navController = navController,
                levelText = "Level 4:",
                lessonText = "Lesson 2"
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
            }

            // Exercises:
            item {
                ExerciseCard(
                    title = "Exercise 1: Treading water",
                    description = "Standing on ght edg of the pool and stepping into the water, then use sculling hands and ether BRS kicks or fluter kick to keep head out the water for 30 seconds.",
                    number = "For 30 Seconds",
                    checked = ProgressState.l4Lesson2Exercise1Completed,
                    onCheckedChange = { ProgressState.l4Lesson2Exercise1Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 2: BC kick (with a board)",
                    description = "Hugging board to chest, pushing tummy up, small fast kick, kicking from the hips, and having ponty toes.",
                    number = "25m",
                    checked = ProgressState.l4Lesson2Exercise2Completed,
                    onCheckedChange = { ProgressState.l4Lesson2Exercise2Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 3: BC kick (streamlined)",
                    description = "One hand on top of each other, arms squeezing ears, small fast kicks, kicking from your hips, pointy toes.",
                    number = "25m",
                    checked = ProgressState.l4Lesson2Exercise3Completed,
                    onCheckedChange = { ProgressState.l4Lesson2Exercise3Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 4: BC single arm (with a pull boy)",
                    description = "Hugging pull boy to chest in 1 hand, other amr starts by your side, thumb comes out over the water turning hand and pinky in, arm brushing ear as it gose in, making sure arms is strait.",
                    number = "25m (X2)",
                    checked = ProgressState.l4Lesson2Exercise4Completed,
                    onCheckedChange = { ProgressState.l4Lesson2Exercise4Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 5: BC swim",
                    description = "Arms are constantly moving, when one hand gose in the other hand comes out, keeping fast kicks and strait arms.",
                    number = "25m (X2)",
                    checked = ProgressState.l4Lesson2Exercise5Completed,
                    onCheckedChange = { ProgressState.l4Lesson2Exercise5Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 6: BRS kick on back (with a noodle)",
                    description = "Noodle on your back, legs out in front, bring legs in, turn feet out and snap round.",
                    number = "25m",
                    checked = ProgressState.l4Lesson2Exercise6Completed,
                    onCheckedChange = { ProgressState.l4Lesson2Exercise6Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 7: BRS kick on front (with a noodle)",
                    description = "Noodle on front and make a window with it, hold on to the window and keep your head out the water, legs out behind you, bring legs in, turn feet out and snap round, make sure to keep legs in the water.",
                    number = "25m",
                    checked = ProgressState.l4Lesson2Exercise7Completed,
                    onCheckedChange = { ProgressState.l4Lesson2Exercise7Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 8: BRS swim (with and without a noodle)",
                    description = "Arms out in front, arms go round in a circle and cut up the middle, breathing every time your arms go round, Pull Breath Kick.",
                    number = "25m",
                    checked = ProgressState.l4Lesson2Exercise8Completed,
                    onCheckedChange = { ProgressState.l4Lesson2Exercise8Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 9: 4 different types of sculling",
                    description = "Sculling 1 on back head first: arms by side, small movement in and out, legs still \n Sculling 2 on back feet first: arms by side palms pointing up at hour head, keeping legs still \n Sculling 3 on front arms by side: arms by side, small movement in and out, legs still \n Sculling 4 on front arms above head: Arms out in front palms pointed down at head small movement keeping arms out in front the whole time.",
                    number = "15m (X4)",
                    checked = ProgressState.l4Lesson2Exercise9Completed,
                    onCheckedChange = { ProgressState.l4Lesson2Exercise9Completed = it }
                )
            }
        }
    }
}






////////////////////////////////////////////////////////////////////////////////////////////////////
// Leve 5:



// Lesson 1:
@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun L5Lesson1(navController: NavController){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            LessonHeader(
                navController = navController,
                levelText = "Level 5:",
                lessonText = "Lesson 1"
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
            }

            // Exercises:
            item {
                ExerciseCard(
                    title = "Exercise 1: Diving in and swimming FC",
                    description = "Both feet on the edg, arms squeezing ears, finger tip pointing down at the water and dive in entering finger tips first, make sure to keep head down then transition into FC Swim",
                    number = "(X2)",
                    checked = ProgressState.l5Lesson1Exercise1Completed,
                    onCheckedChange = { ProgressState.l5Lesson1Exercise1Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}


            item {
                ExerciseCard(
                    title = "Exercise 2: FC kick (with a board)",
                    description = "2 hand holding the out in front board, face in the water blowing bubbles, small fast kicks, kicking from your hips.",
                    number = "25m (X2)",
                    checked = ProgressState.l5Lesson1Exercise2Completed,
                    onCheckedChange = { ProgressState.l5Lesson1Exercise2Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 3: FC kick (streamlined)",
                    description = "One hand on top of each other, arms squeezing ears, small fast kicks, kicking from your hips, pointy toes.",
                    number = "25m",
                    checked = ProgressState.l5Lesson1Exercise3Completed,
                    onCheckedChange = { ProgressState.l5Lesson1Exercise3Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 4: FC kick breathing to the side (with pull boy)",
                    description = "One arm out in front holding a pull boy, one arm by side, small fast kicks, turning head to the side away form arm holding pull boy, plowing bubbles when face is in the water and then a quick breath in.",
                    number = "25m (X2)",
                    checked = ProgressState.l5Lesson1Exercise4Completed,
                    onCheckedChange = { ProgressState.l5Lesson1Exercise4Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 5: Single arm FC (with pull boy)",
                    description = "Holding pull boy in 1 hand, other arms comes out over the water, entering finger tips first next to pull boy, and pulling arms down to your side and repeat, turning head to the side to breath, keep kicks going.",
                    number = "25m (X2)",
                    checked = ProgressState.l5Lesson1Exercise5Completed,
                    onCheckedChange = { ProgressState.l5Lesson1Exercise5Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 6: FC swim",
                    description = "Both arms constantly moving, when 1 arm gose in the other arm comes out, counting arms and breathing on every 3rd arm pull, small fast kicks, blowing bubbles.",
                    number = "25m (X2)",
                    checked = ProgressState.l5Lesson1Exercise6Completed,
                    onCheckedChange = { ProgressState.l5Lesson1Exercise6Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 7: BRS kick on back (with a noodle)",
                    description = "Noodle on your back, legs out in front, bring legs in, turn feet out and snap round.",
                    number = "25m",
                    checked = ProgressState.l5Lesson1Exercise7Completed,
                    onCheckedChange = { ProgressState.l5Lesson1Exercise7Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 8: BRS kick on front (with a noodle)",
                    description = "Arms out in front, arms go round in a circle and cut up the middle, breathing every time your arms go round, Pull Breath Kick",
                    number = "25m",
                    checked = ProgressState.l5Lesson1Exercise8Completed,
                    onCheckedChange = { ProgressState.l5Lesson1Exercise8Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 9: BRS arms (with and without a noodle)",
                    description = "Arms out in front, arms go round in a circle and cut up the middle, breathing every time your arms go round, Pull Breath Kick.",
                    number = "25m",
                    checked = ProgressState.l5Lesson1Exercise9Completed,
                    onCheckedChange = { ProgressState.l5Lesson1Exercise9Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 10: 4 different types of sculling",
                    description = "Sculling 1 on back head first: arms by side, small movement in and out, legs still \n Sculling 2 on back feet first: arms by side palms pointing up at hour head, keeping legs still \n Sculling 3 on front arms by side: arms by side, small movement in and out, legs still \n Sculling 4 on front arms above head: Arms out in front palms pointed down at head small movement keeping arms out in front the whole time",
                    number = "15m (X4 as part of a 25m)",
                    checked = ProgressState.l5Lesson1Exercise10Completed,
                    onCheckedChange = { ProgressState.l5Lesson1Exercise10Completed = it }
                )
            }
        }
    }
}




// Lesson 2:
@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun L5Lesson2(navController: NavController){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            LessonHeader(
                navController = navController,
                levelText = "Level 5:",
                lessonText = "Lesson 2"
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
            }

            // Exercises:
            item {
                ExerciseCard(
                    title = "Exercise 1: Push and glide into a forward roles",
                    description = "One arms out in front, one hand on the wall, push of into a streamlined position holding it for as long as possible then go into a forward roll.",
                    number = "(X3)",
                    checked = ProgressState.l5Lesson2Exercise1Completed,
                    onCheckedChange = { ProgressState.l5Lesson2Exercise1Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}


            item {
                ExerciseCard(
                    title = "Exercise 2: BC kick (with a board over knees)",
                    description = "Holding board over knees, pushing tummy up, small fast kick, kicking from the hips, and having ponty toes",
                    number = "25m (X2)",
                    checked = ProgressState.l5Lesson2Exercise2Completed,
                    onCheckedChange = { ProgressState.l5Lesson2Exercise2Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 3: BC kick streamlined)",
                    description = "One hand on top of each other, arms squeezing ears, small fast kicks, kicking from your hips, pointy toes.",
                    number = "25m",
                    checked = ProgressState.l5Lesson2Exercise3Completed,
                    onCheckedChange = { ProgressState.l5Lesson2Exercise3Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 4: Single arm BC (with pull boy)",
                    description = "Hugging pull boy to chest in 1 hand, other amr starts by your side, thumb comes out over the water turning hand and pinky in, arm brushing ear as it gose in, making sure arms is strait.",
                    number = "25m (X2)",
                    checked = ProgressState.l5Lesson2Exercise4Completed,
                    onCheckedChange = { ProgressState.l5Lesson2Exercise4Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 5: BC swim",
                    description = "Arms are constantly moving, when one hand gose in the other hand comes out, keeping fast kicks and strait arms.",
                    number = "25m (X2)",
                    checked = ProgressState.l5Lesson2Exercise5Completed,
                    onCheckedChange = { ProgressState.l5Lesson2Exercise5Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 6: FLY wiggles (Arms by side and streamlined)",
                    description = "Legs glued together hips moving back and forth, wiggling from the hips \n Arms by side: arms glued to your side, keeping head still \n Streamlined: arms squeezing ears, keeping arms and head still.",
                    number = "25m",
                    checked = ProgressState.l5Lesson2Exercise6Completed,
                    onCheckedChange = { ProgressState.l5Lesson2Exercise6Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 7: 4 FLY arms",
                    description = "Both arms come out over the water at the same time, entering the water in front of you, keeping arms strait, 2 wiggles to every 1 arm. (note: best to try out of the water first)",
                    number = "(X2)",
                    checked = ProgressState.l5Lesson2Exercise7Completed,
                    onCheckedChange = { ProgressState.l5Lesson2Exercise7Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 8: FLY swim",
                    description = "Both arms come out over the water at the same time, entering the water in front of you, keeping arms strait, 2 wiggles to every 1 arm.",
                    number = "15m (X2)",
                    checked = ProgressState.l5Lesson2Exercise8Completed,
                    onCheckedChange = { ProgressState.l5Lesson2Exercise8Completed = it }
                )
            }

            item {Spacer(modifier = Modifier.height(10.dp))}

            item {
                ExerciseCard(
                    title = "Exercise 9: Treading water for 45 seconds",
                    description = "Standing on ght edg of the pool and stepping into the water, then use sculling hands and ether BRS kicks or fluter kick to keep head out the water for 45 seconds. (note: could try taking one or both arms out the water for added difficulty)",
                    number = "45 seconds (X2)",
                    checked = ProgressState.l5Lesson2Exercise9Completed,
                    onCheckedChange = { ProgressState.l5Lesson2Exercise9Completed = it }
                )
            }
        }
    }
}