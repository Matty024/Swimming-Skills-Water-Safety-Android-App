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



//
@RequiresApi(Build.VERSION_CODES.O)
fun getLevelFromLessonTitle(title: String?): String {
    //
    return when {
        title == null -> "Level ${UserProfileState.startingLevel}" //
        title.startsWith("Level 1") -> "Level 1" //
        title.startsWith("Level 2") -> "Level 2" //
        title.startsWith("Level 3") -> "Level 3" //
        title.startsWith("Level 4") -> "Level 4" //
        title.startsWith("Level 5") -> "Level 5" //
        else -> "Level ${UserProfileState.startingLevel}" //
    }
}

//
@RequiresApi(Build.VERSION_CODES.O)
fun getLevelNumberFromText(levelText: String): Int {
    //
    return when (levelText) {
        "Level 1" -> 1 //
        "Level 2" -> 2 //
        "Level 3" -> 3 //
        "Level 4" -> 4 //
        "Level 5" -> 5 //
        else -> UserProfileState.startingLevel //
    }
}



////////////////////////////////////////////////////////////////////////////////////////////////////



// Profile Page:
@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfilePage(navController: NavController) { //

    //
    val firstName = UserProfileState.firstName //
    val secondName = UserProfileState.secondName //
    val email = UserProfileState.email //

    var showEditDialog by remember { mutableStateOf(false) } //
    var editLabel by remember { mutableStateOf("") } //
    var editValue by remember { mutableStateOf("") } //

    val today = LocalDate.now() //

    var showLessonDayDialog by remember { mutableStateOf(false) } //
    var tempLessonDay by remember { mutableStateOf(UserProfileState.preferredLessonDay) } //


    //
    val currentLesson = getLessonForDate(
        selectedDate = today,
        preferredLessonDay = UserProfileState.preferredLessonDay,
        onboardingDate = UserProfileState.onboardingDate,
        startingLevel = UserProfileState.startingLevel
    )

    //
    val currentLevelText = getLevelFromLessonTitle(currentLesson?.title)
    val currentLevelNumber = getLevelNumberFromText(currentLevelText)

    val currentLevelProgress = ProgressState.currentLevelProgressPercent(currentLevelNumber)
    val currentLevelCompleted = ProgressState.currentLevelCompletedExercises(currentLevelNumber)
    val currentLevelTotal = ProgressState.currentLevelTotalExercises(currentLevelNumber)

    val overallProgress = ProgressState.overallProgressPercent(UserProfileState.startingLevel)
    val overallCompleted = ProgressState.overallCompletedExercises(UserProfileState.startingLevel)
    val overallTotal = ProgressState.overallTotalExercises(UserProfileState.startingLevel)

    //
    Scaffold(
        modifier = Modifier.fillMaxSize(),

        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Profile") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF2E4862),
                    titleContentColor = White
                )
            )
        },

        bottomBar = {
            BottomNavBar(navController)
        }

    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF7F7F7))
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp, vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Profile picture",
                modifier = Modifier.size(110.dp),
                tint = Color(0xFF2E4862)
            )

            Spacer(modifier = Modifier.height(12.dp))

            //
            Text(
                text = "$firstName $secondName",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2E4862)
            )

            Spacer(modifier = Modifier.height(32.dp))

            ProfileInfoRow(
                label = "First Name",
                value = firstName,
                onChangeClick = {
                    editLabel = "First Name"
                    editValue = UserProfileState.firstName
                    showEditDialog = true
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            //
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

            //
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

            //
            ProfileInfoRow(
                label = "Starting Level",
                value = "Level ${UserProfileState.startingLevel}",
                onChangeClick = { }
            )

            Spacer(modifier = Modifier.height(16.dp))





            ProfileInfoRow(
                label = "Lesson Day",
                value = UserProfileState.preferredLessonDay,
                onChangeClick = {
                    tempLessonDay = UserProfileState.preferredLessonDay
                    showLessonDayDialog = true
                }
            )



            //
            Spacer(modifier = Modifier.height(24.dp))

            //
            ProgressSection(
                lessonTitle = "Current Level ($currentLevelText)",
                progressPercent = currentLevelProgress,
                completedExercises = currentLevelCompleted,
                totalExercises = currentLevelTotal
            )

            Spacer(modifier = Modifier.height(16.dp))

            //
            ProgressSection(
                lessonTitle = "Overall",
                progressPercent = overallProgress,
                completedExercises = overallCompleted,
                totalExercises = overallTotal
            )

        }




        if (showLessonDayDialog) {
            AlertDialog(
                onDismissRequest = { showLessonDayDialog = false },
                title = {
                    Text("Change Lesson Day")
                },
                text = {
                    DaySelector(
                        selectedDay = tempLessonDay,
                        onDaySelected = { tempLessonDay = it }
                    )
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            UserProfileState.preferredLessonDay = tempLessonDay
                            showLessonDayDialog = false
                        }
                    ) {
                        Text("Save")
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = { showLessonDayDialog = false }
                    ) {
                        Text("Cancel")
                    }
                }
            )
        }



        if (showEditDialog) {
            AlertDialog(
                onDismissRequest = { showEditDialog = false },
                title = {
                    Text("Change $editLabel")
                },
                text = {
                    OutlinedTextField(
                        value = editValue,
                        onValueChange = { editValue = it },
                        label = { Text(editLabel) },
                        singleLine = true
                    )
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            when (editLabel) {
                                "First Name" -> UserProfileState.firstName = editValue
                                "Second Name" -> UserProfileState.secondName = editValue
                                "Email" -> UserProfileState.email = editValue
                            }
                            showEditDialog = false
                        }
                    ) {
                        Text("Save")
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = { showEditDialog = false }
                    ) {
                        Text("Cancel")
                    }
                }
            )
        }
    }
}







//
@Composable
fun ProfileInfoRow(
    label: String,
    value: String,
    onChangeClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(14.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = label,
                    fontSize = 14.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Medium
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = value,
                    fontSize = 18.sp,
                    color = Color(0xFF2E4862),
                    fontWeight = FontWeight.SemiBold
                )
            }

            TextButton(
                onClick = onChangeClick
            ) {
                Text(
                    text = "Change",
                    color = Color(0xFF659DF2),
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}




//
@Composable
fun ProgressSection(
    lessonTitle: String,
    progressPercent: Int,
    completedExercises: Int,
    totalExercises: Int
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(14.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Progress",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2E4862)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "$lessonTitle Progress: $progressPercent%",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(8.dp))

            LinearProgressIndicator(
                progress = { progressPercent / 100f },
                modifier = Modifier.fillMaxWidth(),
                color = Color(0xFF659DF2),
                trackColor = Color(0xFFE3EAF4)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Exercises Completed: $completedExercises / $totalExercises",
                fontSize = 15.sp,
                color = Color(0xFF595959)
            )
        }
    }
}