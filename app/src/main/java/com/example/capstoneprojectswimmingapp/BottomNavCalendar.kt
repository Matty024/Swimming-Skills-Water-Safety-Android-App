package com.example.capstoneprojectswimmingapp

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale


// Calendar (used in the home page):
@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun CalendarView(selectedDate: MutableState<LocalDate>) {

    // Getting the current date and logging/saving it:
    val today = LocalDate.now() // Creating a value called today and gives is a value of LocalDate.now (this gets all the dates)
    Log.e("TAG", "CalendarView: $today") // Log.e is used to debug the gathered dates.

    val weeks = getWeeksFromToday(today, 52) // Creating a value called weeks that get 52 weeks from the current date.

    // Setting the calendar to a weekly size / format:
    val pagerState = rememberPagerState( // creating a value called pagerState that keeps track of the current date you are on and makes the calendar scrollable.
        pageCount = { weeks.size } // number of pages = number of weeks
    )

    // Adding a column to the calendar and having it fill the max width of the page:
    Column(modifier = Modifier.fillMaxWidth()) {

        // Formatting for the selected dates (showing dates at the top of the page):
        val dateFormat = if (selectedDate.value.year == today.year) { // Creating a value called dateFormat.
            DateTimeFormatter.ofPattern("d MMM", Locale.getDefault()) // if the selected date is the same date as this year display it as 7 Apr
        } else {
            DateTimeFormatter.ofPattern("d MMM yyyy", Locale.getDefault()) // else if the date does not match current dat display is as 7 Apr 2027
        }
        selectedDate.value.format(dateFormat)
    }

    // Adding a row into the calendar:
    Row(
        modifier = Modifier
            .fillMaxWidth() // Making the row fill the full size of the page
            .padding(horizontal = 8.dp) // adding horizontal padding to the Row
    ) {
        // List of days starting with Sunday (Sun):
        listOf("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat").forEach { day ->
            Text(
                text = day, // calling the list of days into the text function.
                modifier = Modifier.weight(1f), // modifier.weigh(1f) is used to give every day equal weight.
                textAlign = TextAlign.Center // Having the text aligned in the center of the page.
            )
        }
    }

    // Creating a horizontal page (this allows uses to swip left or right to see different weeks (or pages)):
    HorizontalPager(
        state = pagerState, // Starts the user on the current date week.
        modifier = Modifier.fillMaxWidth() // Having the page fill the full width of the page.
    ) { page ->

        val weekDates = weeks[page] // creating a value called weekDates (this gets a list of all the dates that correspond with the pagerState (starting date))

        // Adding a row to the calendar:
        Row(
            modifier = Modifier
                .fillMaxWidth() // Having the row fill the max width of the page.
                .padding(horizontal = 8.dp)  // Adding horizontal padding.
        ) {
            // Looping over each day in the week:
            weekDates.forEach { date ->
                MutableInteractionSource() //

                // Adding a box into the calendar:
                Box(
                    modifier = Modifier
                        .weight(1f) // giving all the dates the same weight.
                        .height(37.dp)  // Setting the heigh of the box to 37
                        .clip(CircleShape) // Making the clickable area on the dates circular.
                        .padding(top = 3.dp) // adding top padding ot the box
                        .clickable{ selectedDate.value = date } // When a different date is taped update the current selected date to the new one.
                        .background(Color.Transparent), // Making the background color transparent.
                    contentAlignment = Alignment.Center // aligning the box center.
                ) {

                    // Adding text into the box:
                    Text(
                        text = date.dayOfMonth.toString(), // Calling the date. and displaying the in a tring format (7 8 9 10).
                        textAlign = TextAlign.Center, // Aligning the text in the center.
                        fontSize = 25.sp, // Making the text size 25.sp
                        color = if (date == selectedDate.value) Color(0xFF659DF2) else Color.Black, // coloring the text (if date is selected chang it color, else leve color black)
                        textDecoration = if (date == selectedDate.value) // if the date = the selected date
                            TextDecoration.Underline // underline the text
                        else TextDecoration.None // in date is not selected leve it.
                    )
                }
            }
        }
    }

    // Adding a bottom divider to the calendar (used to separate the calendar from the rest of the home page).
    Divider(
        modifier = Modifier
            .fillMaxWidth() // Having the divider fill the max width of the page.
            .padding(top = 18.dp), // adding some padding to the divider so that the calendar is not right against the edges of the page.
        thickness = 1.dp, // Making the divider 1.dp thick
        color = Color.LightGray // coloring the divider light gray.
    )
}

// Calendar helper function:
@RequiresApi(Build.VERSION_CODES.O)
fun getWeeksFromToday(
    today: LocalDate, // getting the starting date.
    weeksCount: Int): // counting how may weeks will be generated.
        List<List<LocalDate>> { // getting a list of every week (all weeks contain 7 days)

    val weeks = mutableListOf<List<LocalDate>>() // creating a valu to store every generated week
    var currentStartOfWeek = today //starting with the current day but having the calendar move back to get the date on Sunday.

    // while function to find the Sunday of the current week:
    while (currentStartOfWeek.dayOfWeek != DayOfWeek.SUNDAY) {
        currentStartOfWeek = currentStartOfWeek.minusDays(1)
    }

    // Generating each week:
    repeat(weeksCount) {
        val week = (0 until 7).map { currentStartOfWeek.plusDays(it.toLong()) } // making a list of 7 dates starting at the current date.
        weeks.add(week) // adding the 7 dates into the week value
        currentStartOfWeek = currentStartOfWeek.plusWeeks(1) // moving the dates so that the first date in the list of 7 is a Sunday.
    }
    // Logging all the weeks:
    weeks.forEach { week ->
        Log.e("TAG", "Week: ${week.joinToString(", ")}") // logging all the weeks and printing them using Logcat.
    }
    return weeks // returning the list of weeks back to the CalendarView
}





// Bottom Bar (used in the Home, Library, and Profile pages):
@Composable
fun BottomNavBar(navController: NavController) {

    val navBackStackEntry = navController.currentBackStackEntryAsState() // sees what current page the user is on (e.g., home or profile page)
    val currentRoute = navBackStackEntry.value?.destination?.route // gets the current page root name (e.g., home)

    // creating a navigation bar
    NavigationBar(
        containerColor = Color(0xFF2E4862), // setting the color of the nav bar to a dark blue.
    ) {

        // Adding an item into the nav bar:
        NavigationBarItem(
            selected = currentRoute == "Home", // if the current page the user is on is the home page then activate this code.
            onClick = {
                navController.navigate("Home") { // if the nav bar item is click navigat the user to the home page
                    popUpTo(navController.graph.startDestinationId) // clears the back stack until reaching the home page
                    launchSingleTop = true // prevents any duplicant screens from appearing.
                }
            },
            // adding an Icon to the nav bar:
            icon = {
                Icon(Icons.Default.Home, // Using the home icon from the Icons library.
                    contentDescription = "Home", // giving the icon a description and defining it as home button
                    modifier = Modifier.size(40.dp) // making the size of the home Icon as 40 dp
                ) },
            // Color of the Home Icon:
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = White, // when the Home Icon is selected it will ture white
                unselectedIconColor = Color.LightGray, // when the Home Icon is not selected it will be Light gray
                indicatorColor = Color.Transparent // making the light pink indicator around the Home Icon Transparent. (as the pick indicator apers with the home Icon as a default feature).
            )
        )

        // Adding a Second item into the nav bar:
        NavigationBarItem(
            selected = currentRoute == "Library", // if the current page the user is on is the home page then activate this code.
            onClick = {
                navController.navigate("Library") { // if the nav bar item is click navigat the user to the library page
                    popUpTo(navController.graph.startDestinationId) // clears the back stack until reaching the library page
                    launchSingleTop = true // prevents any duplicant screens from appearing.
                }
            },
            // Adding an Icon into the nav bar
            icon = {
                Icon(Icons.Default.Search, // Using the Search Icon from the Icons Library.
                    contentDescription = "Library", // Giving the Library Icon a description and defining it as Library button.
                    modifier = Modifier.size(40.dp) // Setting the Size of the Icon as 40 dp
                ) },
            // Coloring the Library Icon:
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = White, // when the Library Icon is selected the Icon will turn white.
                unselectedIconColor = Color.LightGray, // when the Library Icon is not selected the Icon will be light gray.
                indicatorColor = Color.Transparent // making sure that the is no transparent indicator around the Icon.
            )
        )

        // Adding a third item into the nav bar:
        NavigationBarItem(
            selected = currentRoute == "Profile", // if the current page the user is on is the home page then activate this code.
            onClick = {
                navController.navigate("Profile") { // if the nav bar item is click navigat the user to the profile page
                    popUpTo(navController.graph.startDestinationId) // clears the back stack until reaching the profile page
                    launchSingleTop = true // prevents any duplicant screens from appearing.
                }
            },
            // Adding an Icon into the nav bar
            icon = {
                Icon(Icons.Default.Person, // Using the Person Icon from the Icons Profile.
                    contentDescription = "Profile", // Giving the Profile Icon a description and defining it as Profile button.
                    modifier = Modifier.size(40.dp) // Setting the Size of the Icon as 40 dp.
                )},
            // Coloring the Profile Icon:
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = White, // when the Profile Icon is selected the Icon will turn white.
                unselectedIconColor = Color.LightGray, // when the Profile Icon is not selected the Icon will be light gray.
                indicatorColor = Color.Transparent // making sure that the is no transparent indicator around the Icon.
            )
        )
    }
}