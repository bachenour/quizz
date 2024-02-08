package fr.ensitech.tpnour;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;

public class Quiz extends AppCompatActivity {

    private Question question1, question2, question3, question4;

    private Integer niveau, score;

    private TextView textViewNumeroQuestion, textViewQuestion, textViewReponse1, textViewReponse2, textViewReponse3, textViewReponse4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        niveau = 0;
        score = 0;

        textViewNumeroQuestion = findViewById(R.id.textViewNumeroQuestion);
        textViewQuestion = findViewById(R.id.textViewQuestion);
        textViewReponse1 = findViewById(R.id.textViewReponse1);
        textViewReponse2 = findViewById(R.id.textViewReponse2);
        textViewReponse3 = findViewById(R.id.textViewReponse3);
        textViewReponse4 = findViewById(R.id.textViewReponse4);

        question1 = new Question("Quel est le premier Président Français de la 4ème République ?",
                Arrays.asList("Vincent Auriol", "René Coty", "Albert LEBRUN", "Paul DOUMER"),
                0);

        question2 = new Question("Combien existe-t-il de pays dans l'union Européenne ?",
                Arrays.asList("15", "24", "27", "32"),
                2);

        question3 = new Question("Quelle est la langue la moins parlée au monde ?",
                Arrays.asList("L'artchi", "Le Silbo", "Rotokas", "Le Piraha"),
                0);

        question4 = new Question("Quel est le pays le plus peuplé du monde ?",
                Arrays.asList("USA", "Chine", "Inde", "Indonésie"),
                2);

        setQuestion(question1);
    }

    private void setQuestion(Question question) {
        textViewNumeroQuestion.setText("Question " + (niveau + 1) + "/4");
        textViewQuestion.setText(question.getQuestion());
        textViewReponse1.setText(question.getReponsesList().get(0));
        textViewReponse2.setText(question.getReponsesList().get(1));
        textViewReponse3.setText(question.getReponsesList().get(2));
        textViewReponse4.setText(question.getReponsesList().get(3));
    }


    public void checkResponse(Integer responseIndex) {
        switch (niveau) {
            case 0:
                if (question1.getCorrectReponseIndex() == responseIndex) {
                    score++;
                }
                break;
            case 1:
                if (question2.getCorrectReponseIndex() == responseIndex) {
                    score++;
                }
                break;
            case 2:
                if (question3.getCorrectReponseIndex() == responseIndex) {
                    score++;
                }
                break;
            case 3:
                if (question4.getCorrectReponseIndex() == responseIndex) {
                    score++;
                }
                break;
        }
        niveau++;
        if (niveau < 4) {
            switch (niveau) {
                case 1:
                    setQuestion(question2);
                    break;
                case 2:
                    setQuestion(question3);
                    break;
                case 3:
                    setQuestion(question4);
                    break;
            }
        } else {
            //On affiche une boîte de dialogue pour indiquer le score et la fin du quiz
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Quiz terminé")
                    .setMessage(Html.fromHtml("Votre score est de : <b>" + score + "/" + "4" + "</>"))
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Quiz.this, MainActivity.class);
                            intent.putExtra("Score", score);
                            setResult(RESULT_OK, intent);
                            finish();
                        }
                    })
                    .create();
            builder.show();
        }
    }

    public void clickResponse1(View view) {
        checkResponse(0);
    }

    public void clickResponse2(View view) {
        checkResponse(1);
    }

    public void clickResponse3(View view) {
        checkResponse(2);
    }

    public void clickResponse4(View view) {
        checkResponse(3);
    }
}