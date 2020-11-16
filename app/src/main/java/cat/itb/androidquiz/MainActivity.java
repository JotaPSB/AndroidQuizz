package cat.itb.androidquiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView questionText;
    Button buttonTrue;
    Button buttonFalse;
    TextView numberOfQuestions;
    ProgressBar progressBar;
    QuizViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel =  new ViewModelProvider(this).get(QuizViewModel.class);
        questionText = findViewById(R.id.questionText);
        numberOfQuestions= findViewById(R.id.numberOfQuestions);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setMax(viewModel.getQuestionsLength());
        progressBar.setProgress(1);
        buttonTrue=findViewById(R.id.trueButton);
        buttonFalse = findViewById(R.id.falseButton);
        questionText.setText(viewModel.getQuestionText());

        numberOfQuestions.setText(("Question: " + (viewModel.thisQuestion+1) + " of 10"));
        buttonTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkAnswer(true);
                nextQuestion();
            }
        });
        buttonFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
                nextQuestion();
            }
        });


    }
    public  void nextQuestion(){
        if(viewModel.thisQuestion==viewModel.getQuestionsLength()-1){
            finalQuestion();

        }else {
            viewModel.moveToNext();
            refreshScreen();
        }
    }
    public void checkAnswer (boolean answer){
        if (viewModel.getAnswer()==answer) {
            Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(MainActivity.this, "Incorrect", Toast.LENGTH_SHORT).show();
        }
    }
    public void refreshScreen(){
        numberOfQuestions.setText(("Question: " + (viewModel.thisQuestion+1) + " of 10"));
        questionText.setText(viewModel.getQuestionText());
        progressBar.setProgress(viewModel.thisQuestion+1);
    }
    public void finalQuestion() {


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.quizFinal);
        builder.setMessage(R.string.finalText);
        builder.setPositiveButton(R.string.restart, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                viewModel.indexRestart();
                refreshScreen();
            }
        });
        builder.setNegativeButton(R.string.exit,new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                finish();
                System.exit(0);
            }
        });
        AlertDialog alertDialog =  builder.create();
        alertDialog.show();


    }
}