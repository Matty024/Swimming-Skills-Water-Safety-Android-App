# Swimming Skills & Water Safety awareness Android App

### Overview:
An Android Application designed and developed to support swim skilled development and water safety awareness through structured Learning and progress tracking.

This project was developed as my final year Capstone Project for my BSc (Hons) Computing (Application Software Development) degree at Robert Gordan's University. 


### About the project:
The goal of this project was to Design and Evaluate a Mobile Application to Support Swim Skills Development and Water Safety Awareness through the use of structured learning and progress tracking.

The project was cared out over approximately 10 weeks and covering the full development lifecycle consisting of;
Research -> Requirement gathering -> Design -> Development -> Testing -> Evaluation 

The app was developed over approximately 4 week using Android Studios, Kotlin, Jetpack Compose, based on the research, requirements, and design work done earlier in the project.

The application was designed as an academic prototype rather than a replacement for traditional swim teaching methods


### Features: 
- Structured Swimming Lessons - Lessons are organised across five progressive swimming levels.
- Water Safety Awareness - Water Safety questions are incorporated alogside swimming lessons.
- Progress tracking - Users can mark exercises as completed and monitor their progress through the individual levels as well as their overall progress.
- Weekly Calendar - Lessons are automatically scheduled according to the user's selected lesson day.
- Starting level Selection - Users complete an onboarding process to determine an appropriate starting level.
- User Profile - Users can enter and update their profile info and their preferred lesson day.
- Additional lessons - Extra lessons can be added to the user's calendar.
- Custom Lessons - User's cam create their own lessons and exercises.
-  Accessible Navigation - A consistent navigation system allowing for users to move between the different pages in the app


### Screenshots:
Onboarding page - First time opening the app, where users can select their starting level and preferences:

 <img width="473" height="947" alt="Screenshot 2026-04-24 155445" src="https://github.com/user-attachments/assets/fd4c3fdd-604d-4509-a626-602ddc6e333e" />

<img width="627" height="906" alt="Screenshot 2026-08-19 164758" src="https://github.com/user-attachments/assets/f70d5a8a-3999-4810-86da-f5d67254fbef" />

<img width="598" height="940" alt="Screenshot 2026-08-19 164822" src="https://github.com/user-attachments/assets/740095ed-2aa5-4fb4-9949-185d9bf5cced" />


Home page - Weekly calendar showing a scheduled lessons:

<img width="490" height="960" alt="Screenshot 2026-04-24 160229" src="https://github.com/user-attachments/assets/a491ecc4-9b17-4173-9562-68a310cf9d5a" />

Lesson page - Showing a lesson and the exercises in that lesson:

Progress - Showing the users progress for the level their in and their overall progress:





### Tools Used:
- Kotlin
- Jetpack Compose
- Android Studio
- Miro
- Lucid chart


### Technical implementation: 
Navigation:
Navigation was implemented using Jetpack Compose Navigation and NavController, providing navigation between the different pages in the app. 

Reusable Components:
Reusable components were created for elements such as the lessons headers, exercise cards, and the bottom navigation bar to streamlined the code and to reduce filler code. 

Lesson Scheduling:
A Scheduling system was used to determine the user's first lesson date from their scheduled lesson day and then progressing through the structured lessons week by week.

Progress Tracking:
User progress was tracked via the exercise cards with the cards containing a check box used to calculate the progress for the individual swimming level and the overall progress

Modular Structure:
The Applications code was separated across several KT files to make the code easer to maintain and to troubleshoot.


### Testing:
The Application was evaluated using both functional and usability testing.

Functional testing was conducted on the app's core features:
- Navigation
- Lesson Scheduling
- User info
- Starting level selection
- Progress tracking
- Additional lessons
- Creating custom lessons
- Compatibility across multiple Android devices

Usability testing was conducted with 3 users with different experience levels, with the feedback indicating that the app was overall clear and easy to navigate, while also identifying some areas to improve such as the button size.


### Challenges and Solutions: 
1) Weekly lesson scheduling

Challenge: Users first lesson needs to appear on their selected day and automatically progress to the next lesson each week.
   
Solution: Created scheduling logic that compares the user's selected lesson day against their onboarding date this fides the first matching lesson date and then progresses through the lesson sequence on the following lesson date.
   
2) Progress calculation

Challenge: Users overall progress included earlier levels when a users started in a higher level.
   
Solution: Updated the progress calculation to account for the users starting level, removing levels earlier levels that the user never did when calculation the user progress.
   
3) Striction of content
   
Challenge: All the content/code for the application was in 1 kt file making it hared to troubleshoot and to manage all the code.
   
Solution: Separated the content into different kt files and used imports to call the different files together allowing for navigation and the reusable sections to work correctly.

### What I Learned:

### Limitations:
There 

### Future Development:

### Final Report:












