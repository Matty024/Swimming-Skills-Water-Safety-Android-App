package com.example.capstoneprojectswimmingapp

// Imports used to allow functions and materials to work within the application:
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.capstoneprojectswimmingapp.ui.theme.CapStoneProjectSwimmingAppTheme
import java.time.LocalDate



// MainActivity (loading the app / First this loaded when the app is first started):
class MainActivity : ComponentActivity() { // defining the main activity (this is the first screen opened when the swimming app is started)
    @RequiresApi(Build.VERSION_CODES.O) // This is used to tell the system that this app should only be run on 8.0 (API 26) or higher.
    override fun onCreate(savedInstanceState: Bundle?) { // this is where the UI is set up when the app starts.
        super.onCreate(savedInstanceState) // super is used to call the parent class setup as it is required for all android app to properly install and start.
        enableEdgeToEdge() // this is used to draw the app behind Andrade device systems
        setContent {
            CapStoneProjectSwimmingAppTheme { // calling the app content (color, layout, them)
                AppNavigation() // Calling AppNavigation so that when the app it started it will take the user to the pre-determent starting page (defined in the Navigation).
            }
        }
    }
}



///////////////////////////////////////////////////////////////
// Preview Function to see how each page in the app looks:

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainApp(){
    val navController = rememberNavController() // calling the navController so that the pages can be loaded up

    ProfilePage(navController = navController) // Loading a preview of the app to see how the design is looking without having to run an emulator.

}

////////////////////////////////////////////////////////////////


// Navigation function between the different pages:
@RequiresApi(Build.VERSION_CODES.O) // This is used to tell the system that this app should only be run on 8.0 (API 26) or higher.
@OptIn(ExperimentalMaterial3Api::class) // @OptIn it used to allow experimental components to be used in the app without erroring.
@Composable // Defining the app's UI for the Navigation using a Composable function.
fun AppNavigation() {

    // creating a navController and defining it as remember, to remember what the screen the user is on and moves the user between screens.
    val navController = rememberNavController()

    // NavHost is used to definite the starting screen that the user will start at when they first open the app:
    NavHost(navController = navController, startDestination = "Welcome") {

        // Navigation for "Welcome" page:
        composable("Welcome") { // composable is used to define the WelcomeScreen as "Welcome" so that other pages could use it for navigation.
            WelcomeScreen(navController) // calling the WelcomeScreen page so that user can navigat to different pages from the welcomeScreen.
        }

        // Navigation for "Login" page:
        composable("Login") {
            AccountPage(navController)
        }

        // Navigation for "Preferences" page:
        composable("Preferences"){
            PreferencesPage(navController)
        }


        ////////////////////////////////
        // Main pages navigation:

        // Navigation for "Home" page:
        composable("Home") {
            HomePage(navController)
        }

        // Navigation for "Library" page:
        composable("Library") {
            LibraryPage(navController)
        }

        // Navigation for "Profile" page:
        composable("Profile") {
            ProfilePage(navController)
        }


        ///////////////////////////////
        // Lesson pages navigation:

        // Navigation for "l1L1"
        composable("l1L1") {
            L1Lesson1(navController)
        }

        // Navigation for "l1L2"
        composable("l1L2") {
            L1Lesson2(navController)
        }


        // Navigation for "l2L1"
        composable("l2L1") {
            L2Lesson1(navController)
        }

        // Navigation for "l2L2"
        composable("l2L2") {
            L2Lesson2(navController)
        }

        // Navigation for "l3L1"
        composable("l3L1") {
            L3Lesson1(navController)
        }

        // Navigation for "l3L2"
        composable("l3L2") {
            L3Lesson2(navController)
        }

        // Navigation for "l4L1"
        composable("l4L1") {
            L4Lesson1(navController)
        }

        // Navigation for "l4L2"
        composable("l4L2") {
            L4Lesson2(navController)
        }
        
        
        // Navigation for "l5L1"
        composable("l5L1") {
            L5Lesson1(navController)
        }

        // Navigation for "l5L2"
        composable("l5L2") {
            L5Lesson2(navController)
        }

        ///////////////////////////////////
        // Extra lesson pages navigation:

        // Navigation for "ExtraLesson1" page:
        composable("ExtraLesson1") {
            ExtraLesson1(navController)
        }

        // Navigation for "ExtraLesson2" page:
        composable("ExtraLesson2") {
            ExtraLesson2(navController)
        }

        // Navigation for "ExtraLesson3" page:
        composable("ExtraLesson3") {
            ExtraLesson3(navController)
        }


        //////////////////////////////////////////
        // Create your own lesson page navigation:

        // Navigation for "CreateOwnLesson" page:
        composable("CreateOwnLesson") {
            CreateOwnLessonPage(navController)
        }

        // Navigation for "CreatedLessonView" page:
        composable("CreatedLessonView") {
            CreatedLessonViewPage(navController)
        }
    }
}