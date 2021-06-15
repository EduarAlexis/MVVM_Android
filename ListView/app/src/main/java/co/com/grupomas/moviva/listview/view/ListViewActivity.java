package co.com.grupomas.moviva.listview.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import co.com.grupomas.moviva.listview.R;
import co.com.grupomas.moviva.listview.viewModel.ListViewViewModel;

public class ListViewActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private EditText texto;
    private Button saveText;
    private ListView listView;
    private List<String> list;
    private ArrayAdapter<String> adapterList;
    private ListViewViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        //viewModel = ViewModelProviders.of(this).get(ListViewViewModel.class);
        viewModel = new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(ListViewViewModel.class);
        texto = findViewById(R.id.et_text);
        saveText = findViewById(R.id.btn_saveText);
        saveText.setOnClickListener(this);
        listView = findViewById(R.id.lv_list);
        listView.setOnItemClickListener(this);
        list = new ArrayList<>();

        viewModel.getNameList();

        //Observador que está pendiente de los cambios que pasan en
        final Observer<List<String>> observer = new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> namesList) {
                adapterList = new ArrayAdapter<>(getApplication(), android.R.layout.simple_list_item_1, namesList);
                listView.setAdapter(adapterList);
            }
        };

        viewModel.getListResult().observe(this, observer);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_saveText:
                String text = texto.getText().toString() != "" ? texto.getText().toString() : "";
                viewModel.searchName(text);
                texto.getText().clear();

                /*list.add(text);
                texto.getText().clear();
                adapterList = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
                listView.setAdapter(adapterList);*/
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,""+position, Toast.LENGTH_SHORT).show();
    }
}