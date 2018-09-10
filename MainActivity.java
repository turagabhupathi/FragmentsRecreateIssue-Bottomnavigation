package com.bhu.bottomnavi;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    Home firstFrag;
    account secondFrag;
    items thirdFrag;
    about fourthfrag;
    String TAG_FIRST="first";
    String TAG_SECOND="second";
    String TAG_THIRD="third";
    String TAG_FOURTH="fourth";



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                	Home();
                	break;
                case R.id.navigation_acc:
                	account();
                	break;
                case R.id.itemnav:
					items();
					break;
                case R.id.about:
					about();
					break;
            }
            return true;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        secondFrag = new account();
        firstFrag = new Home();
        thirdFrag = new items();
        fourthfrag = new about();



        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
		Home();

    }
    public void Home() {
    	FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
    	if (firstFrag.isAdded()){
    		ft.show(firstFrag);
		}else {
    		ft.add(R.id.fragments, firstFrag, TAG_FIRST);
		}
		if (secondFrag.isAdded()){
    		ft.hide(secondFrag);
		}
		if (thirdFrag.isAdded()){
    		ft.hide(thirdFrag);
		}
		if (fourthfrag.isAdded()){
    		ft.hide(fourthfrag);
		}
		ft.commit();

	}

	public void account(){
    	FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
    	if (secondFrag.isAdded()){
    		ft.show(secondFrag);
		}else {
    		ft.add(R.id.fragments,secondFrag,TAG_SECOND);
		}
		if (thirdFrag.isAdded()){
    		ft.hide(thirdFrag);
		}
		if (fourthfrag.isAdded()){
    		ft.hide(fourthfrag);
		}
		if (firstFrag.isAdded()){
    		ft.hide(firstFrag);
		}
		ft.commit();
	}
	public void items(){
    	FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
    	if (thirdFrag.isAdded()) {
			ft.show(thirdFrag);
		}else {
    		ft.add(R.id.fragments,thirdFrag,TAG_THIRD);
		}
		if (fourthfrag.isAdded()){
    		ft.hide(fourthfrag);
		}
		if (firstFrag.isAdded()){
    		ft.hide(firstFrag);
		}
		if (secondFrag.isAdded()){
    		ft.hide(secondFrag);
		}
		ft.commit();
	}
	public void about(){
    	FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
    	if (fourthfrag.isAdded()){
    		ft.show(fourthfrag);
		}else {
    		ft.add(R.id.fragments,fourthfrag,TAG_FOURTH);
		}
		if (firstFrag.isAdded()){
    		ft.hide(firstFrag);
		}
		if (secondFrag.isAdded()){
			ft.hide(secondFrag);
		}
		if (thirdFrag.isAdded()){
    		ft.hide(thirdFrag);
		}
		ft.commit();
	}
}
