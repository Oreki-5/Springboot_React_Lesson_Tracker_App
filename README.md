"# Springboot_React_Lesson_Tracker_App" 

Functional Requirements

User creation

- User should be able to register as a user
- username should be unique and case sensitive
- password must be stored as a hash for seccurity
- user will have a default role of "user" 


Admin User  
- Admin should be able to create an account for a user
- Admin should be able to assign any role to any user
- Admin should be able to add new lessons into the database


User Dashboard
- any user should be able to see user dashboard
- dashboard will contain a tiled list of lessons
- User should be able to see all the lessons assigned to that user
- User should be able to filter the lessons based on its status( pending, completed, redo)
- User should be able to click on any lesson to view its details
- User should be able to upload an audio file to each unique lesson and submit it for verification
- User should be able to change the file before submitting
- User should not be able to  delete or change the audio file after uploading



Admin Dashboard
- Admin should be able to add new lessons individually
- Admin should be able to see all the lessons assigned to all users
- admin should be able to add a new record for a lesson assigned to a user
- admin should be able to update or delete any record in assignment list
- admin should be given prompt to confirm the deletion of any record
- admin should be able to filter the assignment list based on username
- admin should be able to sort the list based on username


Login page should contain
- simple username password textbox
- validation for wrong password
- success page after login successful
- Link for registering a new user

Register page should contain
- textbox for username, password and confirm password
- additional dropdown box with roles, only visible to admin role


Dashboard details
- must have a table list of assignment record
- admin should be able to see an "add button" for lesson and assignemnt on the top
- each assignment link will redirect to its details page
- user should be able to see only the assignments assigned to them
- admin should be able to see all the assignement records
