package com.example.capstoneprojectswimmingapp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import java.time.LocalDate
import androidx.compose.material3.AlertDialog
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedTextField



// function to find out what each level each lesson is in:
@RequiresApi(Build.VERSION_CODES.O)
fun getLevelFromLessonTitle(title: String?): String {
    // when statement gose through the list below in order:
    return when {
        title == null -> "Level ${UserProfileState.startingLevel}" // if there is no lesson title use users starting level.
        title.startsWith("Level 1") -> "Level 1" // Checking if the title is level 1.
        title.startsWith("Level 2") -> "Level 2" // Checking if the title is level 2.
        title.startsWith("Level 3") -> "Level 3" // Checking if the title is level 3.
        title.startsWith("Level 4") -> "Level 4" // Checking if the title is level 4.
        title.startsWith("Level 5") -> "Level 5" // Checking if the title is level 5.
        else -> "Level ${UserProfileState.startingLevel}" // if non match use users starting level.
    }
}

// function to get the matching level from the level title:
@RequiresApi(Build.VERSION_CODES.O)
fun getLevelNumberFromText(levelText: String): Int {
    // when statement gose through the list below in order:
    return when (levelText) {
        "Level 1" -> 1 // level 1 = 1
        "Level 2" -> 2
        "Level 3" -> 3
        "Level 4" -> 4
        "Level 5" -> 5
        else -> UserProfileState.startingLevel // if none of the above match use users starting level
    }
}



////////////////////////////////////////////////////////////////////////////////////////////////////



// Profile Page:
@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfilePage(navController: NavController) { // Calling the navController.

    val firstName = UserProfileState.firstName // creating a value called firstName and defining it as the saved user info from the onboarding / login page
    val secondName = UserProfileState.secondName // creating a value called secondName and defining it as the saved user info from the onboarding / login page
    val email = UserProfileState.email // creating a value called email and defining it as the saved user info from the onboarding / login page

    var showEditDialog by remember { mutableStateOf(false) } // creating a variable called showEditDialog this is used to either hid or show the edit dialog
    var editLabel by remember { mutableStateOf("") } // creating a variable called editLabel this is used to remember witch dialog section is being edited
    var editValue by remember { mutableStateOf("") } // creating a variable called editValue this is used to remember the text that is currently in the individual dialog sections

    val today = LocalDate.now() // creating a value called today and defining it as the current date (used to work out what lesson the user is on).

    var showLessonDayDialog by remember { mutableStateOf(false) } // creating a variable called showLessonDayDialog used to show weather the lesson selection dialog is visible or not.
    var tempLessonDay by remember { mutableStateOf(UserProfileState.preferredLessonDay) } // creating a variable called tempLessonDay used to remember the users selected day.


    // creating a value called currentLesson used to find the lesson the user is currently on based on their onboarding date, the current date and starting level.
    val currentLesson = getLessonForDate(
        selectedDate = today, // getting the current date
        preferredLessonDay = UserProfileState.preferredLessonDay, // getting the users lesson day
        onboardingDate = UserProfileState.onboardingDate, // getting the users onboarding date
        startingLevel = UserProfileState.startingLevel // getting the users staring level
    )

    val currentLevelText = getLevelFromLessonTitle(currentLesson?.title) // creating a value called currentLevelText and defining it as the current lesson, fund using the getLevelFromLessonTitle function.
    val currentLevelNumber = getLevelNumberFromText(currentLevelText) // creating a value called currentLevelNumber and defining it as the current level, using the getLevelNumberFromText function.

    val currentLevelProgress = ProgressState.currentLevelProgressPercent(currentLevelNumber) // creating a value called currentLevelProgress used to find out the users current progress in their current level
    val currentLevelCompleted = ProgressState.currentLevelCompletedExercises(currentLevelNumber) // creating a value called currentLevelCompleted used to show the number of completed exercises
    val currentLevelTotal = ProgressState.currentLevelTotalExercises(currentLevelNumber) // creating a value called currentLevelTotal used to show the number of exercises in the current level (e.g., level 4 has 17 exercises)

    val overallProgress = ProgressState.overallProgressPercent(UserProfileState.startingLevel) // creating a value called overallProgress used ot dined the users progres through all the levels.
    val overallCompleted = ProgressState.overallCompletedExercises(UserProfileState.startingLevel) // creating a value called overallCompleted used to show the number of exercises the user has completed overall
    val overallTotal = ProgressState.overallTotalExercises(UserProfileState.startingLevel) // creating a value called overallTotal used ot show the number of exercises there are (e.g., there are 70 exercises)


    // Adding a Scaffold to the lesson page to insure a consistent app layout and that basic material design structure is implemented into the page:
    Scaffold(
        modifier = Modifier
            .fillMaxSize(), // Having the Scaffold fill the full size of the page / device.
        // Putting a top bar into the Library page:
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Profile") }, // Giving this page a different name to the main page to let user know what page they are on.
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF2E4862), // Setting the background color of the top bar as the same dark blue as the bottom bar (to keep a consistent them).
                    titleContentColor = White // Making the content in the top bar white.
                )
            )
        },
        // Adding the bottom bar into the page:
        bottomBar = {
            BottomNavBar(navController) // calling the BottomNavBar composable and defining it as the bottom bar.
        }

        // inner padding (where the content of the page is):
    ) { innerPadding ->

        // Adding a column to the page (so all the content in the library page go is a list):
        Column(
            modifier = Modifier
                .fillMaxSize() // Having the column fill the full size of the page
                .background(Color(0xFFF7F7F7)) // Setting the background color for the column
                .padding(innerPadding) // adding innerPadding to the Column
                .verticalScroll(rememberScrollState()) // Making the column scrollable so uses can move the page up and down to see content that could be hidden do to the size of the device.
                .padding(horizontal = 20.dp, vertical = 24.dp), // adding horizontal and vertical padding to the page to stop the content of the page touching the edges of the page.
            horizontalAlignment = Alignment.CenterHorizontally // Having all the content in the column aligned in the horizontal center.
        ) {
            // adding a profile icon to the top of the page
            Icon(
                imageVector = Icons.Default.Person, // adding the image from the Icons folder.
                contentDescription = "Profile picture", // adding a description of the image
                modifier = Modifier.size(110.dp), // setting the size of the image
                tint = Color(0xFF2E4862) // setting the color of the image
            )

            Spacer(modifier = Modifier.height(12.dp))

            //Adding some text to display the users first and second name below the user icon image:
            Text(
                text = "$firstName $secondName", // calling the users first and second name
                fontSize = 24.sp, // setting the size of the text
                fontWeight = FontWeight.Bold, // making the text bold
                color = Color(0xFF2E4862) // setting the color of thet text
            )

            Spacer(modifier = Modifier.height(32.dp))

            // calling a profile info row used to display the users firstName info and allow them to change it:
            ProfileInfoRow(
                label = "First Name", // Adding a label to the top of the text row to lets the user know what this section is.
                value = firstName, // calling the firstName value, to display the users first name.
                // when the user clicks on the row do the following:
                onChangeClick = {
                    editLabel = "First Name" // adding a label to let the user know what this section is doing.
                    editValue = UserProfileState.firstName // calling the editValue and setting it to edit the first name value.
                    showEditDialog = true // changing the edit dialog to true to allow the user to edit the firstName
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // calling a profile info row used to display the users secondName info and allow them to change it:
            ProfileInfoRow(
                label = "Second Name",
                value = secondName,
                onChangeClick = {
                    editLabel = "Second Name"
                    editValue = UserProfileState.secondName
                    showEditDialog = true
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // calling a profile info row used to display the users email and allow them to change it:
            ProfileInfoRow(
                label = "Email",
                value = email,
                onChangeClick = {
                    editLabel = "Email"
                    editValue = UserProfileState.email
                    showEditDialog = true
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // calling a profile info row used to display the users staring level:
            ProfileInfoRow(
                label = "Starting Level",
                value = "Level ${UserProfileState.startingLevel}", // calling the users starting level
                onChangeClick = { }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // calling the profile info row used to display the users preferred lesson day and allow them to change the day:
            ProfileInfoRow(
                label = "Lesson Day", // adding a label to let the user know what this section is
                value = UserProfileState.preferredLessonDay, // calling the users preferred lesson day and displaying it.
                // when user click this row do the following:
                onChangeClick = {
                    tempLessonDay = UserProfileState.preferredLessonDay // calling the preferredLessonDay to allow them to change the day
                    showLessonDayDialog = true // turn the showLessonDayDialog to true to allow user to change the lesson day
                }
            )

            Spacer(modifier = Modifier.height(24.dp))

            // calling the ProgressSection card used to display the users progress through their current level:
            ProgressSection(
                lessonTitle = "Current Level ($currentLevelText)", // adding a title and showing the current level
                progressPercent = currentLevelProgress, // showing the progress percentage
                completedExercises = currentLevelCompleted, // showing the number of completed exercises
                totalExercises = currentLevelTotal // showing the total number of exercises
            )

            Spacer(modifier = Modifier.height(16.dp))

            // calling the ProgressSection card used to display the users progress through all the levels:
            ProgressSection(
                lessonTitle = "Overall", // adding a title to the card.
                progressPercent = overallProgress, // showing the progress percentage overall
                completedExercises = overallCompleted, // showing the number of completed exercises
                totalExercises = overallTotal // showing the total number of exercises
            )

        }

        // if statement used to show the lesson day edit dialog:
        if (showLessonDayDialog) {
            AlertDialog(
                onDismissRequest = { showLessonDayDialog = false }, // closes the dialog
                title = {Text("Change Lesson Day")}, // adding some text to let the user know what this pop up dialog dose
                text = {
                    // calling the DaySelector function (used in the preferences page):
                    DaySelector(
                        selectedDay = tempLessonDay, // showing the current selected day.
                        onDaySelected = { tempLessonDay = it } // updating the selected day to the new one.
                    )
                },

                // button to save the change:
                confirmButton = {
                    TextButton(
                        // when clicked do the following:
                        onClick = {
                            UserProfileState.preferredLessonDay = tempLessonDay // update the preferredLessonDay with the new day
                            showLessonDayDialog = false // close the dialog
                        }
                    ) {
                        Text("Save") // text to let the user know what the button dose.
                    }
                },
                // button to cancel the change to the lesson day:
                dismissButton = {
                    TextButton(
                        onClick = { showLessonDayDialog = false } // closes the dialog
                    ) {
                        Text("Cancel") // text to let the user know what the button dose.
                    }
                }
            )
        }

        // if statement used to show the dialog card for editing the users' info:
        if (showEditDialog) {
            AlertDialog(
                onDismissRequest = { showEditDialog = false }, // closes the dialog
                title = {Text("Change $editLabel")}, // giving the dialog a title
                // text filed to allow users to edit their chosen section:
                text = {
                    OutlinedTextField(
                        value = editValue, // calling the value and having it aper
                        onValueChange = { editValue = it }, // updating the value with the changes the user has made.
                        label = { Text(editLabel) }, // label to match the changes to the relevant field
                        singleLine = true // having the text all be on the same line.
                    )
                },

                // Saving any changes to the relevant value:
                confirmButton = {
                    TextButton(
                        // when the button is clicked do the following:
                        onClick = {
                            // when statement used to check witch user value is being edited and update it with the changes:
                            when (editLabel) {
                                "First Name" -> UserProfileState.firstName = editValue // cheks the firstName value and updates it
                                "Second Name" -> UserProfileState.secondName = editValue // cheks the secondName value and updates it
                                "Email" -> UserProfileState.email = editValue // cheks the email value and updates it
                            }
                            showEditDialog = false // closes the dialog
                        }
                    ) {
                        Text("Save") // text to let the user know what the button dose.
                    }
                },

                // button to cancel the change any changes to the users info:
                dismissButton = {
                    TextButton(
                        onClick = { showEditDialog = false }  // closes the dialog
                    ) {
                        Text("Cancel") // text to let the user know what the button dose.
                    }
                }
            )
        }
    }
}







// creating a reusable dialog card used to allow user to edit their info:
@Composable
fun ProfileInfoRow(
    label: String,
    value: String,
    onChangeClick: () -> Unit
) {
    // adding a card to the function:
    Card(
        modifier = Modifier.fillMaxWidth(), // having the card fill the max width
        colors = CardDefaults.cardColors(
            containerColor = Color.White // setting the color of the card
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp), // adding some elevation to the card to make it stand out more.
        shape = RoundedCornerShape(14.dp) // making the edges of the card round
    ) {
        // adding a row to the card
        Row(
            modifier = Modifier
                .fillMaxWidth() // having the fill the max width of the card
                .padding(16.dp), // adding some padding to the card
            verticalAlignment = Alignment.CenterVertically // aligning the row in the vertical center of the card.
        ) {
            // adding a column into the row:
            Column(
                modifier = Modifier.weight(1f)
            ) {
                // adding a text filed in to the column:
                Text(
                    text = label, // defining the text as the label
                    fontSize = 14.sp, // setting the size of the text
                    color = Color.Gray, // setting the color of the text
                    fontWeight = FontWeight.Medium //  setting the fontWight of the text
                )

                Spacer(modifier = Modifier.height(4.dp))

                // text value used for calling the user info:
                Text(
                    text = value, // defining this text as the value
                    fontSize = 18.sp, // setting the font size of the text
                    fontWeight = FontWeight.SemiBold // making the text semiBold
                )
            }

            // text button used to allow the user to change info:
            TextButton(
                onClick = onChangeClick
            ) {
                Text(
                    text = "Change", // text letting the user know what this button dose
                    color = Color(0xFF659DF2), // setting the color so that it stands out
                    fontWeight = FontWeight.Bold // making the text button bold.
                )
            }
        }
    }
}




// making a card used to show the user progress:
@Composable
fun ProgressSection(
    lessonTitle: String,
    progressPercent: Int,
    completedExercises: Int,
    totalExercises: Int
) {
    // adding a card to the function:
    Card(
        modifier = Modifier.fillMaxWidth(), // having the card fill the max width
        colors = CardDefaults.cardColors(
            containerColor = Color.White // setting the color of the card
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp), // adding some elevation to the card to make it stand out more.
        shape = RoundedCornerShape(14.dp) // making the edges of the card round
    ) {
        // adding a column into the card:
        Column(
            modifier = Modifier.padding(16.dp) // adding padding into the column
        ) {
            // adding some text to let the user know what this section is:
            Text(
                text = "Progress", // adding text
                fontSize = 20.sp, // setting text size
                fontWeight = FontWeight.Bold, // making the text bold
                color = Color(0xFF2E4862) // setting the color of the text
            )

            Spacer(modifier = Modifier.height(12.dp))

            //
            Text(
                text = "$lessonTitle Progress: $progressPercent%", // text to show the lesson title and the progress percent
                fontSize = 16.sp, // setting the text size
                fontWeight = FontWeight.Medium // setting the font weight
            )

            Spacer(modifier = Modifier.height(8.dp))

            // progress bar to visualize the users progress:
            LinearProgressIndicator(
                progress = { progressPercent / 100f }, // creating the progress bar to show the users progress.
                modifier = Modifier.fillMaxWidth(), // having the progress bar fill the max width.
                color = Color(0xFF659DF2), // color of the bar when a user completes an exercise.
                trackColor = Color(0xFFE3EAF4)// color of the bar at defoliate
            )

            Spacer(modifier = Modifier.height(12.dp))

            // text to show the number of completed exercises:
            Text(
                text = "Exercises Completed: $completedExercises / $totalExercises", // text to show the number of completed exercises vs the number of exercises.
                fontSize = 15.sp, // setting the text size
                color = Color(0xFF595959) // setting the font weight
            )
        }
    }
}