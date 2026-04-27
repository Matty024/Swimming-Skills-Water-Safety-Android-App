package com.example.capstoneprojectswimmingapp


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController



// Creating a Date class used to represent 1 Exercise:
data class CustomExercise(
    val title: String, // Creating a value called title and defining it as a string class.
    val description: String, // Creating a value called description and defining it as a string class.
    val repetitions: String // Creating a value called repetitions and defining it as a string class.
)

// Creating a data class for the full lesson:
data class CustomLesson(
    val title: String, // Creating a value called title and defining it as a string class.
    val description: String, // Creating a value called description and defining it as a string class.
    val exercises: List<CustomExercise> // Creating a value called description and defining it as a list of all the exercises.
)

// Creating an object called CustomLessonState, used to store all lessons
object CustomLessonState {
    val customLessons = mutableStateListOf<CustomLesson>() // Creating a value called customLessons and defining mutableStateListOf (where all the lessons are stored).
}



////////////////////////////////////////////////////////////////////////////////////////////////////


// Creating your own Lesson page:
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateOwnLessonPage(navController: NavController) { // calling the navController (used to allow user to navigat to and from this page).

    // List of variables used in this page:
    var lessonTitle by remember { mutableStateOf("") } // crating a variable called lessonTitle and defining it as mutableStateListOf (where all the lessons titles are stored)
    var lessonDescription by remember { mutableStateOf("") } // crating a variable called lessonDescription and defining it as mutableStateListOf (where all the lessons descriptions are stored)

    var exerciseTitle by remember { mutableStateOf("") } // crating a variable called exerciseTitle and defining it as mutableStateListOf (where all the exercise titles are stored)
    var exerciseDescription by remember { mutableStateOf("") } // crating a variable called exerciseDescription and defining it as mutableStateListOf (where one the exercise description are stored)
    var exerciseRepetitions by remember { mutableStateOf("") } // crating a variable called exerciseRepetitions and defining it as mutableStateListOf (where all the exercise repetitions are stored)

    val exercises = remember { mutableStateListOf<CustomExercise>() } // crating a variable called exercises and defining it as mutableStateListOf (where all the exercises are stored)

    // Adding a Scaffold to the lesson page to insure a consistent app layout and that basic material design structure is implemented into the page:
    Scaffold(
        modifier = Modifier.fillMaxSize(), // having the scaffold fill the full size of the page.
        // Adding a top bar to the page:
        topBar = {
            // Calling the public top app bar function:
            CenterAlignedTopAppBar(
                title = { Text("Create Lesson") }, // Adding a title to the top bar (letting the user know what page they are on).
                // Setting the color of the top bar and the content in the top bar:
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF2E4862), // Setting the color of the bar.
                    titleContentColor = White // setting the color of the text.
                )
            )
        }
        // This is where the content of the page goes:
    ) { innerPadding ->

        // Adding a LazyColumn so that the text / items in the inner padding fallow in a list and when the app is running the page can be scrollable:
        LazyColumn(
            modifier = Modifier
                .fillMaxSize() // having the lazy column fill the max size of the page
                .background(Color(0xFFF7F7F7)) // setting the color of the page
                .padding(innerPadding) // adding some inner padding to the column
                .padding(16.dp) // adding padding around the column.
        ) {
            // Item is used to house the content of the lazyColumn:
            item {

                // Adding a text box into the LazyColumn:
                Text(
                    text = "Name of Lesson:", // setting the text (letting the user know this is where you name your lesson).
                    fontSize = 22.sp, // Setting the text size.
                    fontWeight = FontWeight.Bold // Making the text bold.
                )

                // Calling the outLineTextField (to allow users to enter text in ot the UI):
                OutlinedTextField(
                    value = lessonTitle, // Calling the lessonTitle Variable
                    onValueChange = { lessonTitle = it }, // When a user enter text into the field it updates it and saves it into the lessonTitle Variable.
                    label = { Text("Lesson Name") }, // Adding a labe to text the user know what this text field does.
                    modifier = Modifier.fillMaxWidth() // Having the text field fill the full width of the page.
                )

                Spacer(modifier = Modifier.height(12.dp)) // adding some space to separate the 2 text filed's.

                // Calling a second outLineTextField:
                OutlinedTextField(
                    value = lessonDescription, // Calling the lessonDescription Variable.
                    onValueChange = { lessonDescription = it }, // When a user enter text into the field it updates it and saves it into the lessonDescription Variable.
                    label = { Text("Lesson Description") }, // Adding a labe to text the user know what this text field does.
                    modifier = Modifier.fillMaxWidth() // Having the text field fill the full width of the page.
                )

                Spacer(modifier = Modifier.height(24.dp)) // adding separation between the tames in the lazy column.

                // Second text box:
                Text(
                    text = "Add Exercise:", // setting the text (letting the user know this is where you add the content / exercises).
                    fontSize = 22.sp, // Setting the font size for the text.
                    fontWeight = FontWeight.Bold // Making the text bold.
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Calling a second outLineTextField (used for user to create a title for there exercise):
                OutlinedTextField(
                    value = exerciseTitle, // Calling the exerciseTitle Variable.
                    onValueChange = { exerciseTitle = it }, // When a user enter text into the field it updates it and saves it into the exerciseTitle Variable.
                    label = { Text("Exercise Name") }, // Adding a labe to text the user know what this text field does.
                    modifier = Modifier.fillMaxWidth() // Having the text field fill the full width of the page.
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Calling a second outLineTextField (used for user to create a description for there exercise):
                OutlinedTextField(
                    value = exerciseDescription, // Calling the exerciseTitle Variable.
                    onValueChange = { exerciseDescription = it }, // When a user enter text into the field it updates it and saves it into the exerciseTitle Variable.
                    label = { Text("Exercise Description") }, // Adding a labe to text the user know what this text field does.
                    modifier = Modifier.fillMaxWidth() // Having the text field fill the full width of the page.
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Calling a second outLineTextField (used for user to define the repetitions for there exercise):
                OutlinedTextField(
                    value = exerciseRepetitions, // Calling the exerciseRepetitions Variable.
                    onValueChange = { exerciseRepetitions = it }, // When a user enter text into the field it updates it and saves it into the exerciseRepetitions Variable.
                    label = { Text("Repetitions") }, // Adding a labe to text the user know what this text field does.
                    modifier = Modifier.fillMaxWidth() // Having the text field fill the full width of the page.
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Adding a column to the page:
                Column(
                    modifier = Modifier.fillMaxWidth(), // Having the column fill the full size of the page
                    horizontalAlignment = Alignment.CenterHorizontally // Having the column and the content in the column aligned in the horizontal center of the page
                ) {
                    // Adding a button into the column (used to add another exercise into the page / displaying the previous exercises that were added):
                    Button(
                        // When the button is clicked do this:
                        onClick = {
                            // if the exercise title is not blank:
                            if (exerciseTitle.isNotBlank()) {
                                // if title not blank add the current exercise below the ext fields:
                                exercises.add(
                                    // Saving the date the user entered into the 3 text fields:
                                    CustomExercise(
                                        title = exerciseTitle, // Calling the exerciseTitle variable again (used to save the content that is already in the text field).
                                        description = exerciseDescription, // Calling the exerciseDescription variable
                                        repetitions = exerciseRepetitions // Calling the exerciseRepetitions variable
                                    )
                                )
                                // After saving the exercise text filed are returned:
                                exerciseTitle = "" // making the exerciseTitle blank aging.
                                exerciseDescription = "" // making the exerciseDescription blank aging.
                                exerciseRepetitions = "" // making the exerciseRepetitions blank aging.
                            }
                        },
                        // Setting the color of the button:
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF659DF2), // setting the background color for the button.
                            contentColor = White // making the text in the button white
                        )
                    ) {
                        Text("Add Exercise") // adding the text for the button (letting the user know what the button is used for)
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))


            }

            // Item is used to house the content of the lazyColumn (used to create the card for displaying the created lesson when a user click the add new exercise button):
            items(exercises.size) { index ->
                // creating a value called exercise and defining it as the exercises (used to take the saved cerise data and displaying it):
                val exercise = exercises[index]

                // Adding a card into the page:
                Card(
                    modifier = Modifier
                        .fillMaxWidth() // Having the card fill the full size of the page.
                        .padding(bottom = 12.dp), // adding some padding into the column.
                    colors = CardDefaults.cardColors(containerColor = Color.White) // Setting the color of the card to be white
                ) {
                    // adding a column into the card (used for ):
                    Column(modifier = Modifier.padding(16.dp)) { // adding padding into the card.
                        // Adding a text box into the column:
                        Text(
                            text = exercise.title, // Calling the title for saved exercise value.
                            fontWeight = FontWeight.Bold // Making the text bold.
                        )

                        Spacer(modifier = Modifier.height(4.dp)) // adding some heigh to separate the contents in the card.

                        Text(text = exercise.description) // Calling the description from the saved exercise value and adding it to the card.

                        Spacer(modifier = Modifier.height(4.dp)) //

                        Text(
                            text = "Repetitions: ${exercise.repetitions}", // Calling the repetitions from the saved exercise value and adding it to the card.
                            color = Color(0xFF659DF2) // Setting the color of the text
                        )
                    }
                }
            }

            // Item is used to house the content of the lazyColumn:
            item {
                Spacer(modifier = Modifier.height(20.dp)) // adding some height between ths button and the content above.

                // Adding a button to the page (used for adding the created lesson to the calendar and saving it)
                Button(
                    // When button is clicked do the following:
                    onClick = {
                        // Creating a value called newLesson and defining it as the CustomLesson:
                        val newLesson = CustomLesson(
                            title = lessonTitle, //calling the lessonTitle field
                            description = lessonDescription, // calling the lessonDescription field
                            exercises = exercises.toList() // calling the exercises field
                        )

                        CustomLessonState.customLessons.add(newLesson) // adding the newly created lesson to the list of lessons

                        // storing the lesson in the lesson schedule:
                        LessonScheduleState.addedLessons[LessonScheduleState.selectedHomeDate] =
                            AddedLesson(
                                title = lessonTitle,
                                time = "Custom Lesson", // text to tell the user this their custom lesson
                                description = lessonDescription,
                                route = "CreatedLessonView" // route used to take the user to the created lesson page.
                            )

                        // when the user clicks the button they are navigated back to the home page:
                        navController.navigate("Home") {
                            popUpTo("Home") { inclusive = false } // going back through the backstack until finding the home page
                            launchSingleTop = true // if home page is at the top don't go back (to avoid duplication)
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth() // having the button fill the max width of the page (so the button stands out compared to the other button).
                        .padding(bottom = 20.dp), // adding some padding to the button.
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF659DF2), // setting th color of the button
                        contentColor = Color.White // setting the color fot the text in the button.
                    )
                ) {
                    Text("Save and Add Lesson") // Text in the button (letting the user know what this button does).
                }
            }
        }
    }
}






// Created lesson page (when the user create a lesson this is the page where the created lesson content will be displayed):
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreatedLessonViewPage(navController: NavController) {

    //creating a value called customLesson and defining it all the CustomLessonState:
    val customLesson = CustomLessonState.customLessons.lastOrNull() // lastOrNull() is used to return the last (or latest) entry (created lesson) or if it is employ null.

    // Adding a Scaffold to the lesson page to insure a consistent app layout and that basic material design structure is implemented into the page:
    Scaffold(
        modifier = Modifier.fillMaxSize(), // Having the Scaffold fill the full size of the page / device
        // Adding a top bar to the page:
        topBar = {
            // Calling th reusable lesson header:
            LessonHeader(
                navController = navController,
                levelText = "Custom Lesson:", // in the level text inserted of giving it a level this is used to let the user know it is a custom lesson.
                lessonText = customLesson?.title ?: "Lesson" // Calling the created lessons title.
            )
        }
    ) { innerPadding ->
        // if the lesson content == null (or not found) do the following:
        if (customLesson == null) {
            // Adding a box into the if statement:
            Box(
                modifier = Modifier
                    .fillMaxSize() // Having the box fill the max size of the page.
                    .padding(innerPadding), // adding some inner padding into the page.
                contentAlignment = Alignment.Center // having the content of the box aligned in the center of the page.
            ) {
                Text("No content found") // Letting the user know that there was no content to be found.
            }
        // else, if there is content ot be found do the following:
        } else {
            // Add a lazeColumn to the page:
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize() // Having the lazy column fill the max width of the page.
                    .background(Color(0xFFF7F7F7)) // Setting the color of the column
                    .padding(innerPadding) // adding inner padding ot the page.
            ) {
                // Item is used to house the content of the lazyColumn:
                item {
                    // Subtitle, letting the user know blow it the exercises for this page:
                    Text(
                        text = "Exercises:", // Text letting the user know what is below
                        fontSize = 25.sp, // setting the font size for the text
                        modifier = Modifier.padding(20.dp) // adding some padding around the text.
                    )

                    // Calling the customLesson Composable (to add the custom lessons to the page)
                    customLesson.exercises.forEach { exercise ->
                        // Calling the reusable exercise card:
                        ExerciseCard(
                            title = exercise.title, // Setting the title to == title = exerciseTitle
                            description = exercise.description, // Setting the description to == description = exerciseDescription
                            number = exercise.repetitions, // Setting the number to == repetitions = exerciseRepetitions
                            checked = false, // Setting the checked box value to false I(so the box is unchecked when first opened)
                            onCheckedChange = {} // Leaving the checked box blank.
                        )
                    }
                }
            }
        }
    }
}