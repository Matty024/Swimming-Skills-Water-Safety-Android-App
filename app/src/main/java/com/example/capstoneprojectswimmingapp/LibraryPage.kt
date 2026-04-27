package com.example.capstoneprojectswimmingapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll



// Library Page:
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LibraryPage(navController: NavController){ // Calling the navController.

    // Adding a Scaffold to the lesson page to insure a consistent app layout and that basic material design structure is implemented into the page:
    Scaffold(
        modifier = Modifier
            .fillMaxSize(), // Having Scaffold fill the full size of the page.

        // Putting a top bar into the Library page:
        topBar = {
            // Having the top bar aligned center:
            CenterAlignedTopAppBar(
                title = {Text("Library")}, // Giving this page a different name to the main page to let user know what page they are on.
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF2E4862),// Setting the background color of the top bar as the same dark blue as the bottom bar (to keep a consistent them).
                    titleContentColor = White // Making the content in the top bar white.
                )
            ) },

        // Adding the bottom bar into the page
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
                .verticalScroll(rememberScrollState()), // Making the column scrollable so uses can move the page up and down to see content that could be hidden do to the size of the device.
            horizontalAlignment = Alignment.CenterHorizontally // Having all the content in the column aligned in the horizontal center.
        )
        {
            // Text Letting the user know what this page has:
            Text("More Lessons", // letting the user know that this page has more lessons
                textAlign = TextAlign.Center, // aligning the text in the middle of the page.
                fontSize = 30.sp, // making the text 30 sp.
                fontWeight = FontWeight.Bold, // making the font bold.
                modifier = Modifier.padding(top = 15.dp) // Using modifier to add top padding to the text to give more space between the text and the top bar.

            )

            // Adding a space modifier to add height between the 2 text classes.
            Spacer(modifier = Modifier.height(20.dp)) // making the height 20 dp.

            // Adding a second text description:
            Text("Choose from a wide range of different lessons\n" + "to improve or develop your skills", // letting the user know they can choos a new lesson form the list below.
                textAlign = TextAlign.Center, // aligning the text in the middle of the page.
                fontSize = 18.sp, // making the text 18 sp.
                color = Color(0xFF595959), // changing the color of the text to a light gray so it has some contrast compared to the more lesson text.
            )

            // List of Extra Lessons:

            // Space modifier to separate the Text and the Lesson preview cards:
            Spacer(modifier = Modifier.height(20.dp)) // setting the height to 20 dp.

            // Adding a Lesson Preview card to the Library page (calling the LessonPreviewCard for use in the library page):
            LessonPreviewCard(
                lessonTitle = "More KICK (Level 2-3)",
                lessonTime = "20 minutes",
                lessonDescription = "Developing kick on both back and front",
                onClick = {navController.navigate("ExtraLesson1")} // When the user clicks the card they will be taken to Extra lesson 1 page.
            )

            Spacer(modifier = Modifier.height(15.dp))

            // Extra lesson 2:
            LessonPreviewCard(
                lessonTitle = "FC Tech (Level 4-5)",
                lessonTime = "20 minutes",
                lessonDescription = "FC skills & Technique",
                onClick = {navController.navigate("ExtraLesson2")} // When the user clicks the card they will be taken to Extra lesson 2 page.
            )

            Spacer(modifier = Modifier.height(15.dp))

            // Extra Lesson 3:
            LessonPreviewCard(
                lessonTitle = "BC Tech (Level 4-5)",
                lessonTime = "20 minute",
                lessonDescription = "BC skills & Technique",
                onClick = {navController.navigate("ExtraLesson3")} // When the user clicks the card they will be taken to Extra lesson 3 page.
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Button that navigates the user to the createOwnLesson page:
            Button(
                onClick = { navController.navigate("CreateOwnLesson") }, // When button click navigat to the CreateOwnLesson page.
                modifier = Modifier
                    .align(Alignment.CenterHorizontally) // Having the button aligned in the horizontal center of the page.
                    .padding(horizontal = 20.dp, vertical = 20.dp), // Adding padding to the button
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF659DF2), // Setting the background color of the button.
                    contentColor = Color.White // Setting the color of the text in the button
                )
            ) {
                Text("Create Your Own Lesson") // Text inside the button.
            }
        }
    }
}