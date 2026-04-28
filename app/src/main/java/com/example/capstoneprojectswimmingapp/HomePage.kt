package com.example.capstoneprojectswimmingapp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import java.time.LocalDate


// Creating a data class for restringing the lesson preview card content:
data class ScheduledLesson(
    val title: String, // creating a value called title and defining it as string class.
    val time: String, // creating a value called time and defining it as string class.
    val description: String, // creating a value called description and defining it as string class.
    val route: String // creating a value called route and defining it as string class.
)

// Lesson Preview card:
@RequiresApi(Build.VERSION_CODES.O)

// list of lesson preview card descriptions used in the home page if there is a lesson:
val lessonSequence = listOf(

    // Level 1 Lesson 1 preview description:
    ScheduledLesson(
        title = "Level 1 - Lesson 1", // Giving the lesson preview card a title.
        time = "30 minutes", // Giving the lesson preview card a time (ruffly how long the lesson will take ot complete)
        description = "Entering the water, Kicking on front, and Floating", // giving the Lesson preview card a description (letting the user know what the lesson is about)
        route = "L1L1" // Setting a route for the lesson (witch lesson the user will be taken to if they click on the lesson)
    ),
    // Level 1 Lesson 2 preview description:
    ScheduledLesson(
        title = "Level 1 - Lesson 2",
        time = "30 minutes",
        description = "Jumping in, Kick on Back, and Floating",
        route = "L1L2"
    ),
    // Level 2 Lesson 1 preview description:
    ScheduledLesson(
        title = "Level 2 - Lesson 1",
        time = "30 minutes",
        description = "BRS kicks, FC kick/Swim, and Floating",
        route = "L2L1"
    ),
    // Level 2 Lesson 2 preview description:
    ScheduledLesson(
        title = "Level 2 - Lesson 2",
        time = "30 minutes",
        description = "Push and glides, BC kick/Swim, Sculling, and FLY wiggles",
        route = "L2L2"
    ),
    // Level 3 Lesson 1 preview description:
    ScheduledLesson(
        title = "Level 3 - Lesson 1",
        time = "30 minutes",
        description = "Sitting Dives, BRS kicks, Push and glides, FC kick/Swim, and Sculling",
        route = "L3L1"
    ),
    // Level 3 Lesson 2 preview description:
    ScheduledLesson(
        title = "Level 3 - Lesson 2",
        time = "30 minutes",
        description = "BRS kicks, FLY wiggles, and BC kick/Swim",
        route = "L3L2"
    ),
    // Level 4 Lesson 1 preview description:
    ScheduledLesson(
        title = "Level 4 - Lesson 1",
        time = "40 minutes",
        description = "Standing Dives, Forward roles, FC Kick/Swim, and FLY wiggles / 4 FLY arms",
        route = "L4L1"
    ),
    // Level 4 Lesson 2 preview description:
    ScheduledLesson(
        title = "Level 4 - Lesson 2",
        time = "40 minutes",
        description = "Treading water, BC kick/Swim, BRS kick/Swim, and 4 different types of Sculling",
        route = "L4L2"
    ),
    // Level 5 Lesson 1 preview description:
    ScheduledLesson(
        title = "Level 5 - Lesson 1",
        time = "60 minutes",
        description = "Diving into FC, FC kick/Swim, BRS kick/Swim, and 4 different types of Sculling",
        route = "L5L1"
    ),
    // Level 5 Lesson 2 preview description:
    ScheduledLesson(
        title = "Level 5 - Lesson 2",
        time = "60 minutes",
        description = "Push and glides into forward roles, BC kick/Swim, FLY wiggles/Swim, and treading water",
        route = "L5L2"
    )
)




// function used to get the lesson from the date and display it:
@RequiresApi(Build.VERSION_CODES.O)
fun getLessonForDate(

    // Calling the users preferences into the function (used to find what day there lessons are on, what level they are at, and their starting date)
    selectedDate: LocalDate, // calling the selected date.
    preferredLessonDay: String, // calling the selected lesson day.
    onboardingDate: LocalDate, // calling the starting date.
    startingLevel: Int // calling the users current level.
): ScheduledLesson? { // checking if there is a lesson on the given date
    // creating a valu used convert the preferred lesson day into an actual day, retiring null if the day is invalid.
    val preferredDayOfWeek = dayStringToDayOfWeek(preferredLessonDay) ?: return null

    // if statement used to see in the selected date matches the preferred lesson date
    if (selectedDate.dayOfWeek != preferredDayOfWeek) {
        return null // returning null if they don't match.
    }

    // creating a value called firstDate used to find the first valid lesson based on the start date and the day the user has their lesson.
    val firstDate = firstLessonDate(onboardingDate, preferredDayOfWeek)

    // if statement to make sure that the first lesson doesn't appear before the starting date:
    if (selectedDate.isBefore(firstDate)) {
        return null
    }

    val weekOffset = weeksBetween(firstDate, selectedDate).toInt() // value used to count how many weeks have passed since the first lesson.
    val startIndex = lessonStartIndexForLevel(startingLevel) // finding which level the user is starting at.
    val lessonIndex = startIndex + weekOffset // value used to fined which lesson the user should be on based the current date and the starting level.

    return lessonSequence.getOrNull(lessonIndex) // returning the lesson or null if there is no lesson to be found.
}



////////////////////////////////////////////////////////////////////////////////////////////////////



// Home page:
@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(navController: NavController){

    // creating a value called selected date used to remember the current date the user is on using mutableStateOf:
    val selectedDate = remember { mutableStateOf(LocalDate.now()) }

    // creating a function (LaunchedEffect) to copy the data from the current selected date (used for adding new lessons to the page so the program know witch date to add the new lesson to):
    LaunchedEffect(selectedDate.value) {
        LessonScheduleState.selectedHomeDate = selectedDate.value
    }

    // value to check in the selected date has a lesson added by the user or not:
    val addedLessonForDay = LessonScheduleState.addedLessons[selectedDate.value]

    // value that called the getLessonForDate function (used to get the lesson for the selected date):
    val todaysLesson = getLessonForDate(
        selectedDate = selectedDate.value, // Calling selectedDate
        preferredLessonDay = UserProfileState.preferredLessonDay, // Calling preferredLessonDay
        onboardingDate = UserProfileState.onboardingDate, // Calling onboardingDate
        startingLevel = UserProfileState.startingLevel // Calling startingLevel
    )


    // Adding a Scaffold to the lesson page to insure a consistent app layout and that basic material design structure is implemented into the page:
    Scaffold(
        modifier = Modifier
            .fillMaxSize(), // Having the Scaffold fill the full size of the page / device.
        // Putting a top bar into the Library page:
        topBar = {
            // Having the top bar aligned center:
            CenterAlignedTopAppBar(
                title = {Text("Swim App")}, // Giving this page a different name to the main page to let user know what page they are on.
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF2E4862), // Setting the background color of the top bar as the same dark blue as the bottom bar (to keep a consistent them).
                    titleContentColor = White ) // Making the content in the top bar white.
            )
        },
        // Adding the bottom bar into the page:
        bottomBar = {
            BottomNavBar(navController) // calling the BottomNavBar composable and defining it as the bottom bar.
        }
    )

    // inner padding (where the content of the page is):
    { innerPadding ->

        // Adding a column to the page (so all the content in the library page go is a list):
        Column(
            modifier = Modifier
                .fillMaxSize() // Having the column fill the full size of the page
                .background(Color(0xFFF7F7F7)) // Setting the background color for the column
                .padding(innerPadding), // adding innerPadding to the Column
            horizontalAlignment = Alignment.CenterHorizontally // Having all the content in the column aligned in the horizontal center.
        )
        {
            // Adding the calendar to the top of the page just below the top bar:
            CalendarView(selectedDate = selectedDate)


            // if statement, if there is a user added lesson today display lesson preview card:
            if (addedLessonForDay != null) {
                // calling the lesson reusable privet card:
                LessonPreviewCard(
                    lessonTitle = addedLessonForDay.title, // displaying the title of the user added lesson.
                    lessonTime = addedLessonForDay.time, // displaying the time of the user added lesson.
                    lessonDescription = addedLessonForDay.description, // displaying the description of the user added lesson.
                    onClick = { navController.navigate(addedLessonForDay.route) } // route that when the user clicks the car it takes them to the user added lesson
                )

              // else if statement, if there is a scheduled lesson today display the preview card:
            } else if (todaysLesson != null) {
                // calling the lesson reusable privet card:
                LessonPreviewCard(
                    lessonTitle = todaysLesson.title, // displaying the title of the scheduled lesson.
                    lessonTime = todaysLesson.time, // displaying the time of the scheduled lesson.
                    lessonDescription = todaysLesson.description, // displaying the description of the scheduled lesson.
                    onClick = { navController.navigate(todaysLesson.route) } // route that when the user clicks the car it takes them to the scheduled lesson
                )


                // else statement, if there is no lesson today display no lesson massage.
            } else {
                // Putting the content in the else statement in a Column:
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally, // aligning the column in the center of the page based on the horizontal axis
                    modifier = Modifier.fillMaxWidth() // having the column fill the full width of the page
                ) {
                    // Text if there is no lesson today:
                    Text(
                        text = "No lesson today", // text letting the user know they don't have a lesson today.
                        textAlign = TextAlign.Center, // centering the text in the middle of the page.
                        fontSize = 23.sp, // making the text size 23 sp.
                        color = Color(0xFF595959), // changing the text color to a dark gray (so that i it does not pop out as much and take a way from the add lesson text button)
                        modifier = Modifier.padding(top = 100.dp) // adding some padding between the calendar and the text
                    )

                    // adding a space modifier to add some extra height between the content:
                    Spacer(modifier = Modifier.height(20.dp)) // setting the height to 20 dp

                    // Text button:
                    TextButton(onClick = {navController.navigate("Library") { // when a user clicks the text button it will navigate them to the library page.
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true }
                    })
                    {
                        // The text for the text button:
                        Text("ADD New Lesson", // text letting the user know they can add a new lesson if they want.
                            textAlign = TextAlign.Center, // centering the text in the middle of the page
                            fontSize = 20.sp, // making the text 20 sp (just a little bit smaller than the No lesson text so it does not overshadow that text)
                            color = Color(0xFF659DF2)) // making the color a light blue so that the text button is easy to see.
                    }
                }
            }
        }
    }
}