public class GradeManager {

    // Method to reverse each student name (like "Alice" becomes "ecilA")
    public static String[] reverseStudentNames(String[] names) {
        String[] reversedNames = new String[names.length]; // create new array to store reversed names

        for (int i = 0; i < names.length; i++) {
            String original = names[i];
            String reversed = "";

            // Reverse the string character by character
            for (int j = original.length() - 1; j >= 0; j--) {
                reversed += original.charAt(j);
            }

            reversedNames[i] = reversed; // save reversed name in the array
        }

        return reversedNames; // return new array
    }

    // Method to get letter grade based on numeric score
    public static char getLetterGrade(int score) {
        if (score >= 90) {
            return 'A';
        } else if (score >= 80) {
            return 'B';
        } else if (score >= 70) {
            return 'C';
        } else if (score >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

    // Method to find names of students who scored below 60
    public static String[] findFailingStudents(String[] names, int[] scores) {
        // Count how many failed first
        int count = 0;
        for (int score : scores) {
            if (score < 60) {
                count++;
            }
        }

        // Create an array for failed students
        String[] failedStudents = new String[count];
        int index = 0;

        // Add names of students who failed
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] < 60) {
                failedStudents[index] = names[i];
                index++;
            }
        }

        return failedStudents;
    }

    // Main method to test everything
    public static void main(String[] args) {
        // Sample data
        String[] students = {"Alice", "Bob", "Charlie", "Diana"};
        int[] scores = {95, 67, 45, 78};

        // 1. Reverse names
        System.out.println("Reversed Student Names:");
        String[] reversed = reverseStudentNames(students);
        for (String name : reversed) {
            System.out.println(name);
        }

        System.out.println("\nLetter Grades:");
        // 2. Print letter grades
        for (int i = 0; i < students.length; i++) {
            char grade = getLetterGrade(scores[i]);
            System.out.println(students[i] + ": " + grade);
        }

        // 3. Print students who failed
        System.out.println("\nFailing Students:");
        String[] failed = findFailingStudents(students, scores);
        for (String name : failed) {
            System.out.println(name);
        }
    }
}
