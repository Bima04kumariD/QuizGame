import java.util.Scanner;
class Question {
    String questionText;
    String[] choices;
    int correctAnswer;
    Question(String qsText, String[] ch, int correctOption) {
        this.questionText = qsText;
        this.choices = ch;
        this.correctAnswer = correctOption;
    }
    public boolean showQuestion(Scanner sc, int timeLimit) {
        System.out.println(questionText);
        for (int i = 0; i < choices.length; i++) {
            System.out.println(i + 1 + "." + choices[i]);
        }
        System.out.println("You have 5 sec to answer");
        long startTime = System.currentTimeMillis();
        while (true) {
            if (System.currentTimeMillis() - startTime > timeLimit * 1000) {
                System.out.println("\nTime's up! You didn't answer in time.");
                return false; }
            if (sc.hasNextInt()) {
                int input = sc.nextInt();
                return input == correctAnswer;
            }
        }
    }
}
class QuizGame{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = 0;
        Question[] qs = {new Question("What does HTTP stand for?", new String[]{"HyperText Transfer Protocol", "HighTech Transfer Protocol", "HyperText Transport Procedure", "HighTech Transfer Procedure"}, 1), new Question("Which planet is known as the Red Planet?", new String[]{"Venus", "Mars", "Jupiter", "Saturn"}, 2),new Question("How many players are there in a soccer team on the field?", new String[]{"9", "10", "11", "12"}, 3),new Question("Which country is famous for inventing pizza?", new String[]{"France", "Italy", "Mexico", "Greece"}, 2)};
        for (Question ques : qs) {
            if (ques.showQuestion(sc,5)) {
                System.out.println("Correct!!!");
                score++; }
            else {
                System.out.println("Wrong Answer");
            }
        }
        System.out.println("Your score:"+score);
        sc.close();
    }
}