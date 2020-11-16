package cat.itb.androidquiz;

import androidx.lifecycle.ViewModel;

public class QuizViewModel extends ViewModel {
    QuestionModel[] questions={
            new QuestionModel(R.string.question1,false),
            new QuestionModel(R.string.question2,true),
            new QuestionModel(R.string.question3,false),
            new QuestionModel(R.string.question4,true),
            new QuestionModel(R.string.question5,true),
            new QuestionModel(R.string.question6,false),
            new QuestionModel(R.string.question7,true),
            new QuestionModel(R.string.question8,false),
            new QuestionModel(R.string.question9,true),
            new QuestionModel(R.string.question10,false)
    };
    int thisQuestion=0;
    public int getQuestionsLength(){
        return questions.length;
    }
    public int getQuestionText(){
        return questions[thisQuestion].getQuestionText();
    }
    public boolean getAnswer(){
        return questions[thisQuestion].isResposta();
    }
    public void moveToNext(){
        thisQuestion++;
    }
    public void indexRestart(){
        thisQuestion=0;
    }
}
