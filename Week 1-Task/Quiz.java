import java.util.ArrayList;
import java.util.Scanner;

class Quiz {
    private String topic;
    private ArrayList<Question> questions = new ArrayList<>();

    public Quiz(String topic) {
        this.topic = topic;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void takeQuiz() {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        System.out.println("Quiz on: " + topic); // Display the quiz topic

        for (Question question : questions) {
            System.out.println(question.getQuestionText());
            String[] options = question.getOptions();
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ": " + options[i]);
            }

            int userAnswer = 0;
            boolean validAnswer = false;
            while (!validAnswer) {
                try {
                    System.out.print("Your answer (1-4): ");
                    String answerInput = scanner.nextLine().trim();
                    if (answerInput.isEmpty()) {
                        System.out.println("No input provided. Please try again.");
                        continue;
                    }
                    userAnswer = Integer.parseInt(answerInput);
                    if (userAnswer < 1 || userAnswer > 4) {
                        throw new IllegalArgumentException("Please choose a number between 1 and 4.");
                    }
                    validAnswer = true;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            if (userAnswer == question.getCorrectAnswer()) {
                score++;
            }
        }

        System.out.println("You scored " + score + " out of " + questions.size() + ".");
    }

    
}
