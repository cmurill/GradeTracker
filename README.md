# CSers_2121 Group Project CSCI 2121
* **Authors:** Carlos Murillo, Rogelio Estrada, Matthew Taulton
* **Version:** 1.0
* **Completed:** May 10th, 2023
___
# Grade Tracker Program
## Description
The Grade Tracker Program is a simple program that can be used by anyone to create a course and track the students as well as their grades and assignments in the course. The program implements the use of several topics covered in CSCI 1583 and 2121, including:
* Serialization
* ArrayLists
* Exception Handling
* Object Oriented Programming
* Encapsulation
* Switch Cases - selection statements
* Interfaces
* Inheritance
* And more!
___

## Installation
In order for the Grade Tracker program to work, a java development environment should be running on your machine. Once the JDK is installed on your machine, we will need to follow the next simple steps:
1. Create a directory on your machine where you would like the Grade Tracker Program to exist
1. Download/clone the repository for all the source code from our [GitLab](https://gitlab.cs.uno.edu/rgestrad/csers_2121)
1. Once all the source code has been downloaded to the directory, simply compile all the files in your terminal or in git bash by typing in `javac *.java` into the terminal.
1. Once the source code has compiled correctly, all you need to do is run the text-based user interface. Do this by typing into your terminal `java GradeTrackerTUI`.
1. All done! See the below section **Usage** for instructions on how to use the program.
___

## Usage
Now, we have gotten into how to use the GradeTracker Program. If you have gotten the program to run, you should be prompted with a menu. If you have not gotten it to run, please follow the steps mentioned above in the section titled "Installation".
### Main Menu
The Main Menu should prompt for you to select from one of the menu items below:
* Create a class
* Manage a class
* Serialize
* Deserialize
* Exit the Program

In the below sections we will cover what each one does.

### Create A Class
If you have not ever used the Grade Tracker Program, you're going to want to start with this option. Here the program will prompt us for some more information regarding the course we would like to make. Please fill this in via the console and press Enter. Once completed, we will be redirected to the **Main Menu** of the program again. If we would like to make additional classes, we simply repeat the process.
___

### Manage A Class
Now that we have some classes created, we will need to manage those classes. Press the **Manage a Class** option in the console. If we only created one class, we should have a number with a class name right next to it, and that would be our only option. If multiple classes were made, it will print out a corresponding number and the names of each of the classes that were made. Select the class you would like to manage.

#### Add a Student to the Course
If we have not created a student yet then this will be the option we should choose. We will be prompted to enter the first name, last name, and student I.D. number for the student we are creating. Once complete, we will be brought back to the **Manage a Class** menu.


#### Add an Assignment
If no assignments have been created yet then this will be the option we should choose. Here, we will be prompted to create an assignment for the class and it will be added into the class.   
* First, it prompts us to enter the name of the assignment
* Then, we are prompted to enter the total amount of points the assignment is worth

Once this is complete, we will be brought back to the **Manage a Class** menu.

#### Manage a Student
Now that we have created class(es), student(s), and assignment(s) we can manage the students in the class. If multiple students have been created, the program will print a list of all the students starting with their corresponding number, Student I.D. number, and full name.  

Select the student you would like to mange. Once, the student you would like to manage has been selected, you will be prompted with three menu choices:
* Assign grade: here you choose the assignment from the course and assign a grade to the student selected.
* Back: This option will send you back to the **Manage a Class** option and will prompt you to choose the class you would like to manage.
* View Grades: This options prints out the list of grades for the student with the fractional number and percentage.

#### View the list of students in a course
Once a class(es) have been created, an assignment has been created, and we have assigned a grade to a student for the assignment in the class, it may help to see all of the students in a particular class. This selecion option will print the list of all the students in the class along with their student I.D. and Grade in the class that is being managed.

#### Go Back to the Main Menu
This will send us back to the **Main Menu**.
___
### Serialize
This option from the **Main Menu** will write out to a file named Courses.ser. It will save the current state of the program in case you would like to download it on another computer and use it their without losing your data.

### Deserialize
This option is to load back in your data on another computer or instance of the program. Make sure that the file titled "Courses.ser" is in the same directory as the program. Once you select deserialize, the program will read all your data in and load it from the file. To make sure the deserialization proceess worked, select the **Manage a Class** option and see if your course has been loaded in.
___
## Authors and acknowledgment
Contributions: Carlos Murillo, Rogelio Estrada, Matthew Taulton

