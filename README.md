# CRUD Project Back-end

This is the README for my Football Project. It is a CRUD (Create, Read, Update and Delete) application.

This README will give a detailed overview of the project including the research and development.

 ## Author and Acknowlegements

Project by Joseph Woodward

I'd like to say thank you the QA Trainers for helping me to complete this project.

## Links

- [Presentation](https://docs.google.com/presentation/d/15gCtsKpkF-JWPq3MJJQaX6blx26is6Kq_m93TUEP6OQ/edit?usp=sharing)
- [Jira Board](https://joewoodward.atlassian.net/secure/RapidBoard.jspa?rapidView=1&projectKey=LT5)
- [Front-end Github](https://github.com/JoeWoody97/FootballProjectFront)

## Contents

    1. Resources
    2. Brief
    3. Jira - Kanban Boards
    5. Database Structure
    6. Software Used
    7. Testing
    8. Front-End
    9. Stretch Goals

## Resources

- Presentation
- Jira Board
- Front-end Github Repo

## Brief

To create a CRUD application with the utilisation of supporting tools, methodologies and technologies that encapsulate all core modules covered during training.

This project will involve concepts from all core training modules; more specifically this will involve:

- Project Management
- Databases
- JAVA SE
- Spring Boot
- Front- Development
- Automated Testing

The Requirements set for this project are as below:

    - A Jira board with full expansion on user stories, use cases and tasks needed to complete the project.

    - Clear Documentation from a design phase describing the architecture you will use for your project.

    - A relational database used to store data persistently for the project.

    - A functional application created in the OOP language, following best practices and design principles, that you have covered during training, this application needs to meet the requirements set on your Kanban Board.

    - The application must have a functioning front-end website and integrated API.

    - Fully designed test suites for the application you are creating, as well as automated tests for validation of the application.

    - You must meet an acceptable level of test coverage in your backend and provide consistent reports and evidence that you have done so.

    - Code fully integrated into a Version Control System.

### My Approach

To fulfill the requirements I have decided to create a 5-a-side football league table which will implement CRUD functionality. 

A user will be able to:

- Create a team in the database through postman or the front-end.
- Read the teams from the table and the database.
- Update existing teams on the table and database.
- Delete teams from the table and database.

## Jira - Kanban Boards

For this project I completed three sprints using Agile Scrum Boards, each created for the specific parts of the project.

Here is an example of my Front-end Scrum board:

![alt text](https://github.com/JoeWoody97/FootballProject/blob/dev/football_project_files/Sprint_2_FrontEnd.PNG?raw=true)

I have used user stories and tasks to complete the project and adhere to the criteria. Here is an example of one:

![alt text](https://github.com/JoeWoody97/FootballProject/blob/dev/football_project_files/user_strory.PNG?raw=true)

## Database Structure

An example of the database structure that I have is my team entity relationship diagram that I used for my project. Here is what it looks like:

![alt text](https://github.com/JoeWoody97/FootballProject/blob/dev/football_project_files/Database_Structure.png?raw=true)

## Software Used

***Database***

For my database in this project I have used a H2 database when running tests and my front-end is using a MySQL database.

***Back-end***

My back-end is written in Java using the Spring framework. It also consists of my tests which are Unit, Integration and Selenium. 

***Front-end***

My front-end is written in HTML, CSS and JS. I have used Bootstrap to help make the appearance of it look a lot cleaner and user-friendly. 

## Testing

I have written tests for my project.

The tests have been written using JUnit, Mockito, MockMVC and Selenium.

Here is an image of my test coverage which came to 85%:

![alt text](https://github.com/JoeWoody97/FootballProject/blob/dev/football_project_files/myTestCoverage.PNG?raw=true)

## Front-end 

This is an example of what my front end looks like:

![alt text](https://github.com/JoeWoody97/FootballProject/blob/dev/football_project_files/front_end.PNG?raw=true)

## Stretch Goals

If I had more time to work on this project I would have updated and added further improvements, such as:

- Add extra tables which represent the different districts of the country. For example a "North-West League".
- Clean up the front-end to make it more appealing to footballers.
- Implement functionality that would allow for updating a single field in a row.
- Add more to the "Homepage" such as top goalscorers etc.
