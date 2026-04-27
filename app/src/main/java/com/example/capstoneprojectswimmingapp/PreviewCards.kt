package com.example.capstoneprojectswimmingapp

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController



// Reusable Lesson Header (for use in the Lesson pages):
@Composable
fun LessonHeader(navController: NavController, levelText: String, lessonText: String){ // Calling the navController, and creating a levelText and lessonText variable and defining both as strings for use in the reusable header.
    // Adding a Box to the composable:
    Box(
        modifier = Modifier
            .fillMaxWidth() // Having the Box fill the full width of the device / Page
            .height(220.dp) // Setting the height of the page at 220 dp
    ) {
        // Image at the top of each lesson page:
        Image(
            painter = painterResource(R.drawable.lesson_image_1), // Adding an image over the box from the drawable folder
            contentDescription = null, // making the description as null.
            modifier = Modifier.fillMaxSize(), // having the image fill the fill max size.
            contentScale = ContentScale.Crop //Having the image slightly cropped to better fit the page layout.
        )

        // Adding a back button (for user to navigate back to the previous page they were on):
        IconButton(
            onClick = {
                if (!navController.popBackStack()) { // if statement that navigates the user back to the page they were last on
                    navController.navigate("Home") // if backStack fails the user will be taken to the home page inside.
                }
            },
            modifier = Modifier
                .align(Alignment.TopStart) // Aligning the back button in the top left of the page
                .padding(26.dp) // adding some padding/space between the button and the walls of the box.
                // adding a background to the button:
                .background(
                    color = Color.Black.copy(alpha = 0.4f), // Making the background black but making the color slightly transparent using alpha = 0.4f
                    shape = CircleShape // Making the shape of the background round.
                )
                .size(40.dp) // setting the size of the background.
        ) {
            // Adding an Icon image to the back button to make it obvious to the user what the button dose.
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack, // Using the back arrow Icon image from the Icons folder.
                contentDescription = "Back Button", // Giving the back button a description.
                tint = Color.White // Making the Icon white
            )
        }

        // Text at the top of the page:
        Column(
            modifier = Modifier
                .align(Alignment.BottomStart) // Having the text appear at the bottom left side of the page.
                .padding(30.dp) // adding some padding/space for the content in the column.
        ) {
            // Adding the level text to the Box image header:
            Text(
                text = levelText, // Defining the text as levelText (which is called up in the top section of the composable and is defined as a string variable).
                color = White, // Making the text white when used.
                fontSize = 28.sp, // Making the font size 28 sp.
                fontWeight = FontWeight.Bold // Making the text bold.
            )

            // Adding the lesson number text to the header:
            Text(
                text = lessonText, // Defining the text as lessonText (which is called up in the top section of the composable and is defined as a string variable).
                color = White, // Making the text white when used.
                fontSize = 37.sp, // Making the font size 37 sp.
                fontWeight = FontWeight.Bold // Making the text bold.
            )
        }
    }
}



////////////////////////////////////////////////////////////////////////////////////////////////////



// Reusable Lesson exercises card (used in the lessons and extra lessons):
@Composable
fun ExerciseCard(
    title: String, // Defining title as a string class for use in the ExerciseCard.
    description: String, // Defining description as a string class.
    number: String, // Defining number as a string class.
    checked: Boolean, // Defining checked as a boolean class.
    onCheckedChange: (Boolean) -> Unit // Calling the onCheckedChange function into the composable and defining it as a boolean.
) {

    // Creating a variable (var) function to remember the expanding cards default state (mutableStateOf)
    var expanded by remember { mutableStateOf(false) } // Having the mutableStateOf value be false so that the exercise card is closed when first seen / loaded.

    // Creating a Card container:
    Card(
        modifier = Modifier // modifier is used to define or decorate or change the behavior / appearance of the card (or other such functions).
            .fillMaxWidth() // Having the card fill the max width of the page / device.
            .padding(12.dp) // Adding padding to the Card so that the card is not right against the edg of the page.
            .animateContentSize() // having the card animated when it is opers/closed
            .clickable { expanded = !expanded }, // making the card clickable (so when a user clicks on the card it is either opened or closed)
        // Setting the color of the Exercise card:
        colors = CardDefaults.cardColors(
            containerColor = Color.White // making the card color white.
        ),
        shape = RoundedCornerShape(16.dp) // Shaping the card so that it has rounded corners (making the curve 16.dp).
    ) {
        // Adding a Row Container inside the Card (this it where the cards content will be placed) (The row is used to have the box with in at one side and the card contest at the other (in a column))
        Row(
            modifier = Modifier
                .fillMaxWidth() // Having the row fill the full width of the page.
                .height(IntrinsicSize.Min) // used to make the row fit the min height that fits into the card (used to controller the card's height)
        ) {

            // Blue indicator line (only when card is expanded):
            // if statement. (if the card is expanded, do the following):
            if (expanded) {
                // Adding a box to the left edg of the expanded card:
                Box(
                    modifier = Modifier
                        .width(4.dp) // Making the width of the box 4.dp large
                        .fillMaxHeight() // Having the box fill the full height of the expanded card
                        .background(Color(0xFF659DF2)) // defining the color of the box
                )
            }

            // Adding a column to the card (this is where all the contest (title, description, and so on will go)
            Column(
                modifier = Modifier
                    .fillMaxWidth() // having the Column fill the max width of the card
                    .background(White) // Setting the color of the column to white.
                    .padding(16.dp) // adding some padding around the column.
            ) {

                // Adding some text to the Column.
                Text(
                    text = title, // Calling the title class and defining it as text.
                    fontWeight = FontWeight.Bold, // Making the title text bold.
                    style = MaterialTheme.typography.titleMedium // Giving the title text some style (defining its style as titlMedium)

                )


                // if statement. (if the card is opened, do the following):
                if (expanded) {
                    Spacer(modifier = Modifier.height(8.dp)) // adding some space between the title text and anything below it.

                    // Adding Texted to the card if it is opened:
                    Text(
                        text = description, // Calling the description class and defining it as text.
                        color = Color(0xFF595959), // Setting the color of the description class
                        style = MaterialTheme.typography.bodyMedium // Giving the title text some style (defining its style as bodyMedium)
                    )

                    // Adding another space modifier between the description and anything below it:
                    Spacer(modifier = Modifier.height(8.dp))

                    // Adding more text to the card if it is opened:
                    Text(
                        text = number, // Calling the number class and defining it as text.
                        color = Color(0xFF659DF2), // Setting the color of the number class.
                        style = MaterialTheme.typography.bodyMedium // Giving the title text some style (defining its style as bodyMedium)
                    )
                }

                // Adding a second Row into thw card
                Row(
                    modifier = Modifier.fillMaxWidth(), // Having the row will the max width of the page.
                    verticalAlignment = Alignment.CenterVertically // Aligning the row in the vertical center of the card.
                ) {

                    Spacer(modifier = Modifier.weight(1f))

                    // if statement. (if the card is closed, do the following)
                    if (!expanded) {
                        Spacer(modifier = Modifier.height(6.dp)) // adding some space between the title text and anything below it.

                        // Adding some text to the closed card:
                        Text(
                            text = "More...", // text used to let the user know that there is more content within the card.
                            color = Color(0xFF659DF2), // setting the color of the more text
                            fontSize = 15.sp // making the text size 15.sp.
                        )
                    }

                    // adding some space between the text when the card is both opened and closed
                    Spacer(modifier = Modifier.width(270.dp))

                    // Calling the reusable ExerciseCheckbox:
                    ExerciseCheckbox(
                        checked = checked,
                        onCheckedChange = onCheckedChange
                    )

                }
            }
        }
    }
}



// Reusable Exercise Checkbox used in the exerciser card and used for progress tracking:
@Composable
fun ExerciseCheckbox(
    checked: Boolean, // Defining checked as a boolean
    onCheckedChange: (Boolean) -> Unit // Calling the onCheckedChange function into the composable and defining it as a boolean.
) {
    // Calling the Checkbox composable function:
    Checkbox(
        checked = checked, // Calling the checked boolean into the checked box
        onCheckedChange = onCheckedChange, // Calling the onCheckedChange function into the Checkbox.
        // Coloring the checkbox:
        colors = CheckboxDefaults.colors(
            checkedColor = Color(0xFF659DF2), // Defining the color when the box it checked.
            uncheckedColor = Color.Gray, // Defining the color when the box is unchecked.
            checkmarkColor = Color.White // Defining the checkmark color when the box is checked.
        )
    )
}



///////////////////////////////////////////////////////////////////////////////////////////////////



// Home page / Library Lesson preview card template:
@Composable
fun LessonPreviewCard(
    lessonTitle: String, // Defining lessonTitle as a string value for use in the LessonPreviewCard.
    lessonTime: String, // Defining lessonTime as a string value.
    lessonDescription: String, // Defining lessonDescription as a string value.
    onClick: () -> Unit // Defining onClick as Unit.
) {

    // Creating a Card container:
    Card(
        modifier = Modifier
            .fillMaxWidth() // Having the Card fill the max width of the page
            .padding(horizontal = 20.dp, vertical = 12.dp) // Adding padding to the card in both the horizontal and vertical direction.
            .clickable { onClick() }, // Making the Card clickable and calling the onClick value.
        // Setting the color for the card
        colors = CardDefaults.cardColors(
            containerColor = Color.White // Making the color of the card white
        ),
        // Adding some shadow (elevation) to the card. (to make the card stand out more):
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp // making the elevation 6.dp
        ),
        // Making the card have rounded corners:
        shape = RoundedCornerShape(16.dp)
    ) {
        // Adding a Row Container inside the Card:
        Row(
            modifier = Modifier
                .fillMaxWidth() // Having the Row fill the full width of the card
                .padding(16.dp) // Adding some padding around the Row.
        ) {
            // Adding a box inside the Row:
            Box(
                modifier = Modifier
                    .width(5.dp) // Making the width of the box 5.dp
                    .height(80.dp) // Making the height of the box 80.dp
                    .background(
                        Color(0xFF659DF2), // Setting the background color of the box
                        shape = RoundedCornerShape(8.dp) // Making the box have rounded corners.
                    )
            )

            // Adding some space between the box and anything next to it:
            Spacer(modifier = Modifier.width(14.dp))

            // Adding a column into the Card (where the content ot the card gose):
            Column(
                modifier = Modifier.weight(1f)
            ) {
                // Adding some text to the Column:
                Text(
                    text = lessonTitle, // Calling the lessonTitle value and defining it as text.
                    fontSize = 22.sp, // Setting the Text size to 22.dp
                    fontWeight = FontWeight.Bold, // Making the Text bold.
                )

                // Adding some space to separate the text form the text below:
                Spacer(modifier = Modifier.height(6.dp))

                // Adding more text to the Column:
                Text(
                    text = lessonTime, // Calling the lessonTime value and defining it as text.
                    fontSize = 16.sp, // Setting the text size to 16.dp (making it slightly smaller than the text above so that it does not take away form the title)
                    color = Color(0xFF659DF2), // Setting the color of the text
                    fontWeight = FontWeight.Medium // Making the font medium.
                )

                Spacer(modifier = Modifier.height(8.dp))


                Text(
                    // Adding text and defining the text as the buildAnnotatedString feature:
                    text = buildAnnotatedString {
                        withStyle(SpanStyle(fontWeight = FontWeight.Bold)) { // Making the text contained in the {} bold.
                            append("Covers: ") // having Covers: be a permanent thing in all the lesson preview cards.
                        }
                        append(lessonDescription) // Calling the lessonDescription value
                    },
                    fontSize = 15.sp, // Making the font size 15.sp
                    color = Color(0xFF595959), // Setting the color of the Text
                )
            }
        }
    }
}
