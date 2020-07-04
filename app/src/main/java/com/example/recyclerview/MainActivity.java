package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recyclerview.WebServices.Asynchtask;
import com.example.recyclerview.WebServices.WebService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity  implements Asynchtask {
    List<Productos> products;
    RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView=(RecyclerView)findViewById(R.id.RecyclerViewProducts);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        products=new ArrayList<>();
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://accesonline-0504.firebaseio.com/accesorios.json",
                datos, MainActivity.this, MainActivity.this);
        ws.execute("GET");

    }

    @Override
    public void processFinish(String result) throws JSONException {
        JSONArray JSONlista =  new JSONArray(result);
        for(int i=0; i< JSONlista.length();i++){
            JSONObject banco=  JSONlista.getJSONObject(i);
            products.add( new Productos(
                    banco.getString("nombre"),
                    banco.getString("imagenurl"),
                    banco.getString("descripcion"),
                    banco.getDouble("precio")
            ));
        }
        MyAdapter adapter=new MyAdapter(MainActivity.this,products);
        mRecyclerView.setAdapter(adapter);
    }
}