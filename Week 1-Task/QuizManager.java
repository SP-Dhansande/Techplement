import java.util.HashMap;

class QuizManager {
    private HashMap<String, Quiz> quizzes = new HashMap<>();

    public void createQuiz(String topic) {
        if (quizzes.containsKey(topic)) {
            System.out.println("Quiz on \"" + topic + "\" already exists.");
        } else {
            quizzes.put(topic, new Quiz(topic));
            System.out.println("Quiz on \"" + topic + "\" created.");
        }
    }

    public void addQuestionToQuiz(String topic, Question question) {
        Quiz quiz = quizzes.get(topic);
        if (quiz != null) {
            quiz.addQuestion(question);
            System.out.println("Question added to quiz on \"" + topic + "\".");
        } else {
            System.out.println("Quiz on \"" + topic + "\" does not exist.");
        }
    }

    public void takeQuiz(String topic) {
        Quiz quiz = quizzes.get(topic);
        if (quiz != null) {
            quiz.takeQuiz();
        } else {
            System.out.println("Quiz on \"" + topic + "\" does not exist.");
        }
    }

    public void listQuizzes() {
        if (quizzes.isEmpty()) {
            System.out.println("No quizzes available.");
        } else {
            System.out.println("Available quizzes:");
            for (String topic : quizzes.keySet()) {
                System.out.println("- " + topic);
            }
        }
    }
}