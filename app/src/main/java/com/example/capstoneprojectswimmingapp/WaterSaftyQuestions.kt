package com.example.capstoneprojectswimmingapp


import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


// Reusable water safety card (for use in the Lessons page):
@Composable
fun WaterSafetyCard(
    questionTitle: String, // Defining questionTitle as a string class for use in the WaterSafetyCard.
    questionText: String, // Defining questionText as a string class.
    options: List<String>, // Defining options as a list (string) class.
    correctAnswer: String, // Defining correctAnswer as a string class.
    completed: Boolean, // Defining completed as a boolean class.
    onCorrectAnswer: () -> Unit // Calling the onCorrectAnswer function into the composable and defining it as a boolean class.
) {
    var expanded by remember { mutableStateOf(false) } // Having the mutableStateOf value be false so that the exercise card is closed when first seen / loaded.
    var selectedAnswer by remember { mutableStateOf<String?>(null) } // Having the mutableStateOf remember the selectedAnswer as blank so whe the user first go to the question it is unanswered.
    var feedbackMessage by remember { mutableStateOf("") } // Having the mutableStateOf remember the feedback message as blank so when the user first sees the question it is unanswered.

    // Adding a card to the composable:
    Card(
        modifier = Modifier
            .fillMaxWidth() // Having the card fill the full width of the page.
            .padding(12.dp) // Adding some padding to the card
            .animateContentSize() //  having the card animated when it is opers/closed
            .clickable { expanded = !expanded }, // making the card clickable (so when a user clicks on the card it is either opened or closed)
        // Setting the color of the Exercise card:
        colors = CardDefaults.cardColors(
            containerColor = Color.White // Making the card color white.
        ),
        shape = RoundedCornerShape(16.dp) // Shaping the card so that it has rounded corners (making the curve 16.dp).
    ) {
        // Adding a Row Container inside the Card (this it where the cards content will be placed) (The row is used to have the box with in at one side and the card contest at the other (in a column))
        Row(
            modifier = Modifier
                .fillMaxWidth() // Having the row fill the max width of the card
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
                        .background(Color(0xFF659DF2)) // defining the color of the box.
                )
            }

            // Adding a column to the card (this is where all the contest (title nd question will go):
            Column(
                modifier = Modifier
                    .fillMaxWidth() // having the Column fill the max width of the card
                    .background(Color.White) // Setting the color of the column to white.
                    .padding(16.dp) // adding some padding around the column.
            ) {
                // Adding some text to the Column.
                Text(
                    text = questionTitle, // Calling the questionTitle variable and defining it as text.
                    fontWeight = FontWeight.Bold, // Making the title text bold.
                    style = MaterialTheme.typography.titleMedium // Giving the title text some style (defining its style as titlMedium)
                )

                // if statement. (if the card is opened, do the following):
                if (expanded) {
                    Spacer(modifier = Modifier.height(8.dp)) // adding some space between the title text and anything below it.

                    // Adding Texted to the card if it is opened:
                    Text(
                        text = questionText, // Calling the questionText value and defining it as text.
                        color = Color(0xFF595959), // Setting the color of the description variable.
                        style = MaterialTheme.typography.bodyMedium // Giving the title text some style (defining its style as bodyMedium)
                    )

                    Spacer(modifier = Modifier.height(5.dp)) // Adding another space modifier between the description and anything below it:

                    // Calling the options value:
                    options.forEach { option ->
                        // adding a row to the options value:
                        Row(
                            modifier = Modifier
                                .fillMaxWidth() // Having the row fill the full width of the card
                                .clickable {
                                    selectedAnswer = option
                                    // if the user clicks the correc answer do the following:
                                    if (option == correctAnswer) {
                                        feedbackMessage = "Correct answer" // display a correct answer message to the user.
                                        onCorrectAnswer() //
                                    // if the user answers the question wrong do the following:
                                    } else {
                                        feedbackMessage = "Wrong answer" // display a Wrong answer message.
                                    }
                                }
                                .padding(vertical = 1.dp), // adding some vertical padding to the options value.
                            verticalAlignment = Alignment.CenterVertically // having it aligned in the vertical center of the page.
                        ) {
                            // Adding a RadioButton (this allows the user to select 1 answer form a set of options):
                            RadioButton(
                                selected = selectedAnswer == option, // selected is used to see if an option is selected or not, by calling the selectedAnswer variable and having it = the option value.
                                // Making the button clickable (when clicked do the following):
                                onClick = {
                                    selectedAnswer = option
                                    // if the user clicks the correc answer do the following:
                                    if (option == correctAnswer) {
                                        feedbackMessage = "Correct answer" // display a correct answer message to the user.
                                        onCorrectAnswer()
                                    // if the user answers the question wrong do the following:
                                    } else {
                                        feedbackMessage = "Wrong answer" // display a Wrong answer message.
                                    }
                                }
                            )

                            Spacer(modifier = Modifier.width(7.dp)) // Adding some width space.

                            // Adding some text:
                            Text(
                                text = option, // defining the text as the option Value.
                                color = Color(0xFF595959) // changing the color of the text.
                            )
                        }
                    }

                    // if the feedback message is not empty do the following
                    if (feedbackMessage.isNotEmpty()) {
                        Spacer(modifier = Modifier.height(10.dp)) // add some height space.

                        // add a text box
                        Text(
                            text = feedbackMessage, // defining the texts as the feedbackMessage value.
                            // Setting the color of the text:
                            color = if (feedbackMessage == "Correct answer") {
                                Color(0xFF2E7D32) // if the user answers correctly make the text green
                            } else {
                                Color(0xFFC62828) // else, if the user answers incorrectly make the text red.
                            },
                            fontWeight = FontWeight.SemiBold // setting the fontWeight of the text.
                        )
                    }

                    // Section when the card is closed to let the user know if they have answered this question or not:
                    // if the question is answered do the following:
                    if (completed) {
                        Spacer(modifier = Modifier.height(8.dp))

                        // text box to let the user know that they have completed the question:
                        Text(
                            text = "Completed", // Letting the user know the question has been answered.
                            color = Color(0xFF659DF2), // Setting the color of the text.
                            fontWeight = FontWeight.SemiBold // setting the font weight of the text.
                        )
                    }
                // else, if the user has not answered the question do this:
                } else {
                    // text box to let the user know they need to answer the question:
                    Text(
                        text = "Tap to answer", // text letting the user know they can tap the card they answer the question.
                        color = Color(0xFF659DF2), // Setting the color of the text
                        fontSize = 14.sp // setting the font size of the tex
                    )
                }
            }
        }
    }
}