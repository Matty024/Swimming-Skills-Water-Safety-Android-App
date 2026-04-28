package com.example.capstoneprojectswimmingapp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import java.time.LocalDate


// Yes or no questions function:
@Composable
fun YesNoQuestion(
    selected: String,
    onSelected: (String) -> Unit
) {
    // adding a row into the page:
    Row(
        verticalAlignment = Alignment.CenterVertically // having the row aligned in the vertical center.
    ) {
        // Adding a Radio Button (used to answer yes) (allows user to choose between 2 options):
        RadioButton(
            selected = selected == "Yes", // When the button is selected it is yes
            onClick = { onSelected("Yes") } //  when the button is clicked save it as yes
        )
        Text("Yes") // Adding text to the button

        Spacer(modifier = Modifier.width(12.dp))

        // Adding a Radio Button (used to answer No)
        RadioButton(
            selected = selected == "No", // When the button is selected it is no
            onClick = { onSelected("No") } // when the button is clicked save it as No
        )
        Text("No") // adding text to lett the user know what this option is.
    }
}

// Function used in the yes no question to assign a level to the user depending on there level:
fun determineStartingLevel(
    hasDoneSwimmingBefore: String, // calling the hasDoneSwimmingBefore variable.
    canSwimFC: String, // calling the canSwimFC variable.
    canSwimBC: String, // calling the canSwimBC variable.
    canFloat: String // calling the canFloat variable.
): Int {
    return when {
        hasDoneSwimmingBefore == "No" -> 1 // if user answer no to Q1 (have gone swimming before?) the user will be put in level 1 (1)

        canSwimFC == "Yes" && canSwimBC == "Yes" && canFloat == "Yes" -> 3 // if user answers yes to question 2-4 (can swim FC, can swim BC, and can float) the user will be put in level 3 (3)

        else -> 2 // if user answers no to any on the above question level 2 (2)
    }
}








// Welcome screen (when the user first opens the app this is the first page they will see:
@Composable
fun WelcomeScreen(navController: NavController) { //
    // Adding a box to the page (used to surround all the content of the page and make the whole page clickable for navigation:
    Box(
        modifier = Modifier
            .fillMaxSize() // Having the box fill the max size of the page.
            .clickable { navController.navigate("login") } // when box is clicked navigat the user to the login page
    ) {
        // Adding an image as the background of the page:
        Image(
            painter = painterResource(R.drawable.login), // calling the image from the drawable folder
            contentDescription = null, // setting the description of the image as null
            modifier = Modifier.fillMaxSize(), // Having the image fill the max size of the page / device.
            contentScale = ContentScale.Crop //
        )

        // Adding a column inside the box used for housing the content and centering the content of the column:
        Column(
            modifier = Modifier
                .fillMaxSize() // Having the column fill the max size of the page
                .padding(24.dp), // adding padding around the column.
            verticalArrangement = Arrangement.Center, // Having the text aligned in the vertical center of the page.
            horizontalAlignment = Alignment.CenterHorizontally // Having the text aligned in the horizontal center of the page.
        ) {
            // Adding a welcome message to the page:
            Text(
                text = "Welcome", // Message text
                color = Color.White, // Setting the color of the text to white
                fontSize = 42.sp, // setting the size of the text
                fontWeight = FontWeight.Bold // Making the text bold.
            )

            Spacer(modifier = Modifier.height(7.dp)) // adding some space to separate the 2 text fields.

            // Adding some text to let the user know how to go to the next page:
            Text(
                text = "Tap to get started", // text letting the user know.
                color = Color.LightGray, // Setting the color to light gray (making it slightly duller that the welcome to not take a way form it)
                fontSize = 17.sp // Setting the size of the text.
            )
        }
    }
}







// Login page (page to let user create an account):
@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountPage(navController: NavController){
    var firstName by remember { mutableStateOf("") } // Creating a variable called firstName and defining it as mutableStateOf() (used to remember values and update them if the value is changed).
    var secondName by remember { mutableStateOf("") } // Creating a variable called secondName and defining it as mutableStateOf()
    var email by remember { mutableStateOf("") } // Creating a variable called email and defining it as mutableStateOf()

    // Adding a box to the page (used to add an image as a background of the page):
    Box(
        modifier = Modifier.fillMaxSize() // Having the box fill the max size of the page.
    ) {
        // Adding an image to the box to make it a background:
        Image(
            painter = painterResource(R.drawable.login), // calling the image from the drawable folder
            contentDescription = null, // setting the description of the image as null
            modifier = Modifier.fillMaxSize(), // Having the image fill the max size of the page / device.
            contentScale = ContentScale.Crop //
        )

        // adding a LazyColumn so that the text / items in the inner padding fallow in a list and when the app is running the page can be scrollable:
        LazyColumn(
            modifier = Modifier
                .fillMaxSize() // having the LazyColumn fill the full size of the page / device.
                .padding(20.dp), // setting the color of the LazyColumn
            verticalArrangement = Arrangement.Center, // Having the lazyColumn in the vertical center of the page
            horizontalAlignment = Alignment.CenterHorizontally // Having the lazyColumn in the horizontal center of the page (both these Arrangement are used so that the content of the lazeColumn is in the middle of the page)
        ) {
            // Item is used to house the content of the lazyColumn:
            item {
                // Adding a card to the lazyColumn
                Card(
                    modifier = Modifier.fillMaxWidth(), // Having the card fill the full width of the lazyColumn.
                    shape = RoundedCornerShape(20.dp), // Having edges of the card rounded
                    // Setting the color of the card:
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White // Making the color white
                    )
                ) {
                    // adding a column to the card
                    Column(
                        modifier = Modifier.padding(20.dp) // adding some padding to the column
                    ) {
                        // adding some text to the column:
                        Text(
                            text = "Create Account", // defining the text
                            textAlign = TextAlign.Center, // aligning the text in the center of the page.
                            fontSize = 28.sp, // setting the size of the text
                            fontWeight = FontWeight.Bold, // Making the text bold
                            color = Color.Black, // setting the color of the text
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        // adding an outlined text field into the card for the users firstName:
                        OutlinedTextField(
                            value = firstName, // calling the firstname variable and setting it as the value for the text field.
                            onValueChange = { firstName = it }, // when uses enter text into this field it updating firstName variable.
                            label = { Text("First Name") }, // Adding a label/text into the field so users know what it is doing.
                            modifier = Modifier.fillMaxWidth(), // Having the text field fill the max width of the column
                            singleLine = true // having the text be all be on the same line and able to be scrolled side to side.
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        // adding an outlined text field into the card for the users secondName:
                        OutlinedTextField(
                            value = secondName, // calling the secondName variable and setting it as the value for this text field.
                            onValueChange = { secondName = it }, // when uses enter text into this field it updates the secondName variable.
                            label = { Text("Second Name") },
                            modifier = Modifier.fillMaxWidth(),
                            singleLine = true
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        // adding an outlined text field into the card for the users email:
                        OutlinedTextField(
                            value = email, // calling the email variable and setting it as the value for this text field.
                            onValueChange = { email = it }, // when uses enter text into this field it updates the email variable.
                            label = { Text("Email Address") },
                            modifier = Modifier.fillMaxWidth(),
                            singleLine = true
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        // Adding a button into the column/card (used to save the user info date and navigate the users to the preference page):
                        Button(
                            onClick = {
                                UserProfileState.firstName = firstName // calling the UserProfileState.firstName and defining it as the saved firstName user date.
                                UserProfileState.secondName = secondName // saving the secondName data into UserProfileState
                                UserProfileState.email = email // saving the email data into UserProfileState
                                navController.navigate("Preferences") // using the navController to navigate the user to the preference page when the button is clicked.
                            },

                            modifier = Modifier.fillMaxWidth(), // having the button fill the max width of the page

                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF659DF2), // setting the color fo the button
                                contentColor = Color.White // Setting the color of the text in the button
                            )
                        ) {
                            Text("Continue") // Adding text to the button
                        }

                    }
                }
            }
        }
    }
}





// Preferences page (used for selecting a lesson day and a starting level):
@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PreferencesPage(navController: NavController) {

    var hasDoneSwimmingBefore by remember { mutableStateOf("") } // Creating a variable called hasDoneSwimmingBefore and defining it as mutableStateOf() (used to save / change an input the user makes)
    var canSwimFC by remember { mutableStateOf("") } // Creating a variable called canSwimFC and defining it as mutableStateOf()
    var canSwimBC by remember { mutableStateOf("") } // Creating a variable called canSwimBC and defining it as mutableStateOf()
    var canFloat by remember { mutableStateOf("") } // Creating a variable called canFloat and defining it as mutableStateOf()
    var preferredDay by remember { mutableStateOf("") } // Creating a variable called preferredDay and defining it as mutableStateOf()

    // Adding a box to the page (used to add an image as a background of the page):
    Box(
        modifier = Modifier.fillMaxSize() // Having the box fill the max size of the page.
    ) {
        // Setting an image as the background of the page:
        Image(
            painter = painterResource(R.drawable.login), // calling the image from the drawable folder
            contentDescription = null, // setting the description of the image as null
            modifier = Modifier.fillMaxSize(), // Having the image fill the max size of the page / device.
            contentScale = ContentScale.Crop
        )

        // adding a LazyColumn so that the text / items in the inner padding fallow in a list and when the app is running the page can be scrollable:
        LazyColumn(
            modifier = Modifier
                .fillMaxSize() // having the LazyColumn fill the full size of the page / device.
                .padding(20.dp), // setting the color of the LazyColumn.
            verticalArrangement = Arrangement.Center, // Having the lazyColumn in the vertical center of the page
            horizontalAlignment = Alignment.CenterHorizontally // Having the lazyColumn in the horizontal center of the page (both these Arrangement are used so that the content of the lazeColumn is in the middle of the page)
        ) {
            // Item is used to house the content of the lazyColumn:
            item {
                // Adding a card to the lazyColumn:
                Card(
                    modifier = Modifier.fillMaxWidth(), // Having the card fill the full width of the lazyColumn.
                    shape = RoundedCornerShape(20.dp), // Having edges of the card rounded
                    // Setting the color of the card:
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White // Making the color of the card white
                    )
                ) {
                    // adding a column to the card
                    Column(
                        modifier = Modifier
                            .padding(20.dp), // adding some padding to the column
                    ) {
                        // adding some text to the column:
                        Text(
                            text = "Preferences", // defining the text
                            textAlign = TextAlign.Center, // aligning the text in the center of the page.
                            fontSize = 28.sp, // setting the size of the text
                            fontWeight = FontWeight.Bold, // Making the text bold
                            color = Color.Black, // setting the color of the text
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        // Adding some text to the card (the text is used to define the question for the user)
                        Text(
                            text = "Have you done swimming before?", // Adding the question into the text
                            fontWeight = FontWeight.SemiBold // making the text semiBold.
                        )
                        // Calling the YesNoQuestion function
                        YesNoQuestion(
                            selected = hasDoneSwimmingBefore, // calling the hasDoneSwimmingBefore variable and setting it as the value for this YesNoQuestion.
                            onSelected = { hasDoneSwimmingBefore = it } // saving the option the user has selected into the hasDoneSwimmingBefore variable
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        // Adding some text to the card (the text is used to define the question for the user):
                        Text(
                            text = "Can you swim FC for more than 15m?",
                            fontWeight = FontWeight.SemiBold
                        )
                        // Calling the YesNoQuestion function:
                        YesNoQuestion(
                            selected = canSwimFC, // calling the canSwimFC variable and setting it as the value for this YesNoQuestion.
                            onSelected = { canSwimFC = it } // saving the option the user has selected into the canSimFC variable
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        // Adding some text to the card (the text is used to define the question for the user):
                        Text(
                            text = "Can you swim BC for more than 15m?",
                            fontWeight = FontWeight.SemiBold
                        )
                        // Calling the YesNoQuestion function
                        YesNoQuestion(
                            selected = canSwimBC, // calling the canSwimBC variable and setting it as the value for this YesNoQuestion.
                            onSelected = { canSwimBC = it } // saving the option the user has selected into the canSimBC variable
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        // Adding some text to the card (the text is used to define the question for the user):
                        Text(
                            text = "Can you float on your front/back for more than 5 seconds?",
                            fontWeight = FontWeight.SemiBold
                        )
                        // Calling the YesNoQuestion function
                        YesNoQuestion(
                            selected = canFloat, // calling the canFloat variable and setting it as the value for this YesNoQuestion.
                            onSelected = { canFloat = it } // saving the option the user has selected into the canFloat variable
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        // Calling the DaySelector function (used to allow user to select a lessons' day):
                        DaySelector(
                            selectedDay = preferredDay, // calling the preferredDay variable.
                            onDaySelected = { preferredDay = it } // Saving the input the user makes into the preferredDay variable.
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        // Adding a button into the card (used to save the users preferences and navigate the user to the home page):
                        Button(
                            // when the button is clicked do the following:
                            onClick = {
                                // select the users starting level using determineStartingLevel (by defining UserProfileState as determineStartingLevel, taking the inputs the user made and saving them as there values in the determineStartingLevel function):
                                UserProfileState.startingLevel = determineStartingLevel(
                                    hasDoneSwimmingBefore = hasDoneSwimmingBefore, // calling the hasDoneSwimmingBefore and defining it as the saved hasDoneSwimmingBefore from the determineStartingLevel function.
                                    canSwimFC = canSwimFC, // saving the canSwimFC data into determineStartingLevel.
                                    canSwimBC = canSwimBC, // saving the canSwimBC data into determineStartingLevel.
                                    canFloat = canFloat // saving the canFloat data into determineStartingLevel.
                                )

                                UserProfileState.preferredLessonDay = preferredDay // Saving the preferredDay
                                UserProfileState.onboardingDate = LocalDate.now() // Saving the current date (when the user opened the app)

                                navController.navigate("home") // navigate the user to the home page.
                            },
                            modifier = Modifier.fillMaxWidth(), // having the button fill the max width of the page.
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF659DF2), // setting the color of the button.
                                contentColor = Color.White, // setting the color of the text in the button.
                            )
                        ) {
                            Text("Continue") // adding text into the button.
                        }
                    }
                }
            }
        }
    }
}





// DaySelector Function (used of choosing a lesson day):
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DaySelector(
    selectedDay: String,
    onDaySelected: (String) -> Unit
) {
    // creating a value called days and defining it as a list, adding all the days of the week:
    val days = listOf(
        "Monday", "Tuesday", "Wednesday",
        "Thursday", "Friday", "Saturday", "Sunday"
    )

    var expanded by remember { mutableStateOf(false) } // creating a variable called expanded used to see if the dropdown box is open or not (setting the value at false so the box is closed when first seen)

    // creating a ExposedDropdownMenuBox used to show the list of days
    ExposedDropdownMenuBox(
        expanded = expanded, // defining expanded as the expanded variable
        onExpandedChange = { expanded = !expanded } // checking if the box is opened or closed
    ) {
        // creating an outline text field:
        OutlinedTextField(
            value = selectedDay, // calling the selectedDay value
            onValueChange = {},
            readOnly = true, // reedOnly is used to stop users from entering text, only allowing them to ender text from the electedDay list.
            label = { Text("Select lesson day") }, // adding alabel to the field to let the user know what it does.
            // adding a dropdown arrow to the text filed
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) // changing its orientation what the card is opened
            },
            modifier = Modifier
                .menuAnchor() //
                .fillMaxWidth() // Having the text filed fill the max width of the box.
        )

        // dropdown menu the user will see
        ExposedDropdownMenu(
            expanded = expanded, // show the menu when it is opened
            onDismissRequest = { expanded = false } // close the menu is the user clicks outside the box.
        ) {
            // creating the menu (loops over each day int the onDaySelected and creates an option for each):
            days.forEach { day ->
                DropdownMenuItem(
                    text = { Text(day) }, // taking each day and displaying it
                    // when a day is clicked to the following:
                    onClick = {
                        onDaySelected(day) // save the selected day / display it
                        expanded = false // close the menu.
                    }
                )
            }
        }
    }
}
