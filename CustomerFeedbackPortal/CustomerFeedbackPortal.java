import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CustomerFeedbackPortal{
    static String[] names = new String[100];
static int[] ratings = new int[100];
static String[] comments = new String[100];

static int count = 0;

static Scanner userInput = new Scanner(System.in);
//The main method
public static void main(String[] args) {

loadFeedback(); // Load feedback from file at the start of the program

while (true) {
showMenu();// Display the menu

int choice;// Get the user choice

try {// Handle invalid input
choice = Integer.parseInt(userInput.nextLine());
} catch (NumberFormatException e) {
System.out.println("Please enter a valid number");
continue;
}

switch (choice) {// Handle the user choice+ method calls
case 1:
addFeedback();
break;
case 2:
showAll();
break;
case 3:
showAverage();
break;
case 4:
searchByRating();
break;
case 5:
deleteFeedback();
break;
case 6:
saveFeedback();
break;
case 7:
saveFeedback();
userInput.close();
return;
default:
System.out.println("Invalid choice please try again");
}
}}
// Display the menu
static void showMenu() {
System.out.println("===== CUSTOMER FEEDBACK PORTAL =====");
System.out.println("1. Add feedback");
System.out.println("2. Show all feedback");
System.out.println("3. Show average rating");
System.out.println("4. Search by rating");
System.out.println("5. Delete feedback");
System.out.println("6. Save to file");
System.out.println("7. Save and exit");
System.out.print("Choose: ");
}

// Add new feedback
static void addFeedback(){

if (count >= 100) {
System.out.println("You reached the feedback limit.");//check feedback limits
return;
}

System.out.print("Enter your name: ");
String name = userInput.nextLine();

if (name.isEmpty()) {//validate name input
System.out.println("Name cannot be empty.");
return;
}

System.out.print("Enter the rating 1-5: ");
int rating;

try {
rating = Integer.parseInt(userInput.nextLine());//validate rating input
} catch (NumberFormatException e) {// Handle invalid input
System.out.println("Rating must be a number.");
return;
}

if (rating < 1 || rating > 5) {//rang of rating
System.out.println("Rating must be between 1 and 5.");
return;
}

System.out.print("Enter your comment: ");
String comment = userInput.nextLine();

if (comment.isEmpty()) {
System.out.println("Comment cannot be empty.");
return;
}

// Store the feedback in the arrays
names[count] = name;
ratings[count] = rating;
comments[count] = comment;
count++;

System.out.println("Feedback added successfully.");
}

// Display all feedback
static void showAll() {

if (count == 0) {// Check if there is any feedback to display
System.out.println("No feedback available.");
return;
}

for (int i = 0; i < count; i++) {
// Display each feedback entry
System.out.println("Name: " + names[i]);
System.out.println("Rating: " + ratings[i]);
System.out.println("Comment: " + comments[i]);
}
}

// Calculate and display the average rating
static void showAverage(){
if (count == 0){
System.out.println("no feedback available");
return;
}
int sum = 0;
for (int i =0; i<count; i++){
sum += ratings[i];

}
double avg = (double) sum / count;
System.out .println("average rating is : " + avg);
}

// Search feedback by rating
static void searchByRating() {

System.out.print("Enter the rating from 1-5: ");

int searchRating;

try {
searchRating = Integer.parseInt(userInput.nextLine());//validate rating input
} catch (NumberFormatException e) {// Handle invalid input
System.out.println("Please enter a valid number.");
return;
}

if (searchRating < 1 || searchRating > 5) {
System.out.println("Rating must be between 1 and 5.");
return;
}

boolean found = false;//  check if any feedback is found

for (int i = 0; i < count; i++) {
if (ratings[i] == searchRating) {
System.out.println("Name: " + names[i]);
System.out.println("Rating: " + ratings[i]);
System.out.println("Comment: " + comments[i]);
found = true;
}
}

if (!found) {
System.out.println("No feedback found with rating " + searchRating);
}
}

// Delete feedback by index
static void deleteFeedback() {

if (count == 0) {
System.out.println("No feedback available.");
return;
}

System.out.print("Enter index:");

int index;

try {
index = Integer.parseInt(userInput.nextLine());
} catch (NumberFormatException e) {
System.out.println("Please enter a valid number.");
return;
}

// Validate the index
if (index < 0 || index >= count) {
System.out.println("Invalid index.");
return;
}

// Shift the remaining feedback to the left
for (int i = index; i < count - 1; i++) {
names[i] = names[i + 1];
ratings[i] = ratings[i + 1];
comments[i] = comments[i + 1];
}
count--;
// Clear the last position
names[count] = null;
ratings[count] = 0;
comments[count] = null;

System.out.println("Feedback deleted successfully.");
}

// Save feedback to file(txt)
static void saveFeedback() {

try (BufferedWriter writer = new BufferedWriter(new FileWriter("feedback.txt"))) {//we use BufferedWriter and FileWriter -->to write into the file
for (int i = 0; i < count; i++) {
writer.write(names[i] + "|" + ratings[i] + "|" + comments[i]);
writer.newLine();
}

System.out.println("Feedback saved successfully.");

} catch (IOException e) {
System.out.println("Error: " + e.getMessage());
}
}

// Load feedback from feedback.txt
static void loadFeedback() {

try (BufferedReader reader =
new BufferedReader(new FileReader("feedback.txt"))) {

String line;

while ((line = reader.readLine()) != null) {
String[] parts = line.split("\\|", 3);
if (parts.length == 3 && count < 100) {
try {
names[count] = parts[0];
ratings[count] = Integer.parseInt(parts[1]);
comments[count] = parts[2];

count++;

} catch (NumberFormatException e) {
System.out.println("Skipping invalid feedback record.");
}
}
}
if (count > 0) {
System.out.println(count + " feedback entries loaded.");
}

}
 catch (IOException e) {
System.out.println("No saved feedback found. Starting a new list.");
}
}}
