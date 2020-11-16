package cat.itb.androidquiz;

public class QuestionModel {
    int questionText;
    boolean resposta;

    public QuestionModel(int questionText, boolean resposta) {
        this.questionText = questionText;
        this.resposta = resposta;
    }

    public int getQuestionText() {
        return questionText;
    }

    public void setQuestionText(int questionText) {
        this.questionText = questionText;
    }

    public boolean isResposta() {
        return resposta;
    }

    public void setResposta(boolean resposta) {
        this.resposta = resposta;
    }
}
