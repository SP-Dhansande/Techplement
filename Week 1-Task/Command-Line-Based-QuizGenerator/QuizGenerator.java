import java.util.Scanner;

public class QuizGenerator {
    public static void main(String[] args) {
        QuizManager quizManager = new QuizManager();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {
            try {
                System.out.println("\nCommand Options:");
                System.out.println("1. Create Quiz");
                System.out.println("2. Add Question to Quiz");
                System.out.println("3. Take Quiz");
                System.out.println("4. List Quizzes");
                System.out.println("5. Exit");
                System.out.print("Enter command number: ");

                String input = scanner.nextLine().trim();  // Read input as a String
                if (input.isEmpty()) {
                    System.out.println("No input provided. Please try again.");
                    continue;
                }

                int command = Integer.parseInt(input);

                switch (command) {
                    case 1:
                        System.out.print("Enter quiz topic: ");
                        String topic = scanner.nextLine().trim();
                        quizManager.createQuiz(topic);
                        break;
                    case 2:
                        System.out.print("Enter quiz topic: ");
                        topic = scanner.nextLine().trim();
                        System.out.print("Enter question: ");
                        String questionText = scanner.nextLine().trim();
                        String[] options = new String[4];
                        for (int i = 0; i < 4; i++) {
                            System.out.print("Enter option " + (i + 1) + ": ");
                            options[i] = scanner.nextLine().trim();
                        }
                        int correctAnswer = 0;
                        boolean validInput = false;
                        while (!validInput) {
                            try {
                                System.out.print("Enter correct answer (1-4): ");
                                String answerInput = scanner.nextLine().trim();
                                if (answerInput.isEmpty()) {
                                    System.out.println("No input provided. Please try again.");
                                    continue;
                                }
                                correctAnswer = Integer.parseInt(answerInput);
                                if (correctAnswer < 1 || correctAnswer > 4) {
                                    throw new IllegalArgumentException("Please choose a number between 1 and 4.");
                                }
                                validInput = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input. Please enter a number.");
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        Question question = new Question(questionText, options, correctAnswer);
                        quizManager.addQuestionToQuiz(topic, question);
                        break;
                    case 3:
                        System.out.print("Enter quiz topic: ");
                        topic = scanner.nextLine().trim();
                        quizManager.takeQuiz(topic);
                        break;
                    case 4:
                        quizManager.listQuizzes();
                        break;
                    case 5:
                        System.out.println("Exiting the Quiz Generator.");
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid command. Please enter a number between 1 and 5.");
                }
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
                e.printStackTrace();  // Print stack trace for debugging
            }
        }

        scanner.close();
    }
}






