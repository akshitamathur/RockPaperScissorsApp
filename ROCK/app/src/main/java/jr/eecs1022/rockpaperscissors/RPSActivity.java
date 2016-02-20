package jr.eecs1022.rockpaperscissors;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;


public class RPSActivity extends AppCompatActivity
{
    private static final String MODULE = "RSPActivity";

    private int curDrawable = R.drawable.splash;
//    private int curState = 0;

    //Used for Enumeration code
    private States currentState = States.SPLASH;
    private enum States{SPLASH, THREE, TWO, ONE, RESULT}

    public void buttonPressed(View view) {
        System.out.println("buttonPressed called");
        ImageView imageView = (ImageView) findViewById(R.id.imageView);

//THIS IS THE FIRST TASK CODE - NO RANDOMIZATION
//        curState++;
//        if(curState == 5){
//            curState = 0;
//            curDrawable = R.drawable.splash;
//        }else if (curState == 1){
//            curDrawable = R.drawable.image3;
//        }else if (curState == 2){
//            curDrawable = R.drawable.image2;
//        }else if (curState == 3){
//            curDrawable = R.drawable.image1;
//        }else{
//            curDrawable = R.drawable.rock;
//        }


        // SECOND - WITH RANDOMIZATION
//        Random random = new Random();
//        curState++;
//        if(curState == 5){
//            curState = 0;
//            curDrawable = R.drawable.splash1;
//        }else if (curState == 1){
//            curDrawable = R.drawable.image3a;
//        }else if (curState == 2){
//            curDrawable = R.drawable.image2a;
//        }else if (curState == 3){
//            curDrawable = R.drawable.image1a;
//        }else{
//            int number = random.nextInt(3);
//            if(number == 0){
//                curDrawable = R.drawable.rock1;
//            }else if(number == 1){
//                curDrawable = R.drawable.paper1;
//            }else{
//                curDrawable = R.drawable.scissors1;
//            }
//
//        }


        //THREE - Changing Button Text
//        Random random = new Random();
//        Button btn = (Button)findViewById(R.id.button);
//        curState++;
//        if(curState == 5){
//            curState = 0;
//            curDrawable = R.drawable.splash2;
//            btn.setText("Play");
//        }else if (curState == 1){
//            curDrawable = R.drawable.image3a;
//            btn.setText("Keep Going");
//        }else if (curState == 2){
//            curDrawable = R.drawable.image2a;
//            btn.setText("Keep Going");
//        }else if (curState == 3){
//            curDrawable = R.drawable.image1a;
//            btn.setText("Keep Going");
//        }else{
//            int number = random.nextInt(3);
//            btn.setText("Play again?");
//            if(number == 0){
//                curDrawable = R.drawable.rock1;
//            }else if(number == 1){
//                curDrawable = R.drawable.paper1;
//            }else{
//                curDrawable = R.drawable.scissors1;
//            }
//
//        }

// With SPOCK and LIZARD and custom images
//        Random random = new Random();
//        Button btn = (Button)findViewById(R.id.button);
//        curState++;
//        if(curState == 5){
//            curState = 0;
//            curDrawable = R.drawable.splash2;
//            btn.setText("Let's Start");
//        }else if (curState == 1){
//            curDrawable = R.drawable.image3a;
//            btn.setText("Keep Going");
//        }else if (curState == 2){
//            curDrawable = R.drawable.image2a;
//            btn.setText("Keep Going");
//        }else if (curState == 3){
//            curDrawable = R.drawable.image1a;
//            btn.setText("Keep Going");
//        }else{
//            int number = random.nextInt(5);
//            btn.setText("Play again?");
//            if(number == 0){
//                curDrawable = R.drawable.rock1;
//            }else if(number == 1){
//                curDrawable = R.drawable.paper1;
//            }else if (number == 2){
//                curDrawable = R.drawable.scissors1;
//            }else if (number == 3){
//                curDrawable = R.drawable.lizard;
//            }else{
//                curDrawable = R.drawable.spock;
//            }
//    }

        //Using ENUMERATION
        Button btn = (Button)findViewById(R.id.button);
        Random random = new Random();

        switch(currentState){
            case SPLASH:
                currentState = States.THREE;
                curDrawable = R.drawable.image3a;
                btn.setText("Keep Going");
                break;
            case THREE:
                currentState = States.TWO;
                curDrawable = R.drawable.image2a;
                btn.setText("Keep Going");
                break;
            case TWO:
                currentState = States.ONE;
                curDrawable = R.drawable.image1a;
                btn.setText("Keep Going");
                break;
            case ONE:
                currentState = States.RESULT;
                curDrawable = R.drawable.image1a;
                btn.setText("Play Again?");
                int number = random.nextInt(5);
                if (number == 0){
                    curDrawable = R.drawable.rock1;
                }else if(number == 1){
                    curDrawable = R.drawable.paper1;
                }else if (number == 2){
                    curDrawable = R.drawable.scissors1;
                }else if (number == 3){
                    curDrawable = R.drawable.lizard;
                }else{
                    curDrawable = R.drawable.spock;
                }
                break;
            case RESULT:
                currentState = States.SPLASH;
                curDrawable = R.drawable.splash2;
                btn.setText("Ready?");
                break;
        }


        imageView.setImageResource(curDrawable);
        System.out.println("buttonPressed done");


    }

    @Override
    protected void onSaveInstanceState (Bundle outState){
        System.out.println("Inside onSaveInstanceState");
        super.onSaveInstanceState(outState);
        outState.putInt("image", curDrawable);
    }
    @Override
    protected void onRestoreInstanceState (Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        curDrawable = savedInstanceState.getInt("image", R.drawable.splash2);
        Button btn = (Button)findViewById(R.id.button);
        if(curDrawable == R.drawable.splash2){
            currentState = States.SPLASH;
            btn.setText("Ready?");
        }else if(curDrawable == R.drawable.image3a){
            currentState = States.THREE;
            btn.setText("Keep Going");
        }else if (curDrawable == R.drawable.image2a){
            currentState = States.TWO;
            btn.setText("Keep Going");
        }else if (curDrawable == R.drawable.image1a){
            currentState = States.ONE;
            btn.setText("Keep Going");
        }else{
            currentState = States.RESULT;
            btn.setText("Play Again?");
        }

        ImageView iv = (ImageView)findViewById(R.id.imageView);
        iv.setImageResource(curDrawable);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rps);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_r, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




}
