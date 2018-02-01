package com.example.michel.myretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.ref.WeakReference;
import java.lang.reflect.Array;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = (ListView) findViewById(R.id.list_view);
        textView = (TextView) findViewById(R.id.michel_txt);



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<NYresult> call = api.getTopstories();

        call.enqueue(new Callback<NYresult>() {
            @Override
            public void onResponse(Call<NYresult> call, Response<NYresult> response) {


                NYresult topstories = response.body();


                Log.e("myretrofit","la réponse = " + topstories.getResults());



                    String[] myresults = new String [topstories.getResults().size()];

                    for(int i = 0; i < topstories.getResults().size(); i++){
                        myresults[i] = topstories.getResults().get(i).getTitle();
                    }

                final ArrayAdapter<String> adapter = new ArrayAdapter<String>
                        (MainActivity.this, android.R.layout.simple_list_item_1,
                                myresults);
                listView.setAdapter(adapter);


                textView.setText("michel");
            }

            @Override
            public void onFailure(Call<NYresult> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

    }
}
