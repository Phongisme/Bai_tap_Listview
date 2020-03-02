package com.example.listviewbss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvMonHoc;
    ArrayList<String> monHoc;
    Button btnAdd,btnUpdate;
    EditText edtmonhoc;
    int vitri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        monHoc  = new ArrayList<>();
        monHoc.add("Lap trinh androi");
        monHoc.add("Lap trinh Java");
        monHoc.add("Lap trinh Web");
        monHoc.add("Lap trinh CNC");
        monHoc.add("Lap trinh C");
        monHoc.add("Lap trinh C++");
        monHoc.add("Lap trinh C#");
        monHoc.add(" Flutter");
        monHoc.add("mang may tinh");
        monHoc.add(" Python");
        monHoc.add("Ung dung");
        monHoc.add("Python");
        monHoc.add("Lap trinh Python");

        final ArrayAdapter adapter = new ArrayAdapter<>(
                MainActivity.this ,android.R.layout.simple_list_item_1,monHoc);
        lvMonHoc.setAdapter(adapter);
        lvMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                edtmonhoc.setText(monHoc.get(position));
                vitri = position;
            }
        });
        //Xóa một môn học
//        lvMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                monHoc.remove(position);
//                adapter.notifyDataSetChanged();
//                Toast.makeText(MainActivity.this, "Xóa thành công", Toast.LENGTH_SHORT).show();
//            }
//        });
        // Cập nhập lai môn học
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                monHoc.set(vitri,edtmonhoc.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
        //Truyền màn hình
        lvMonHoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                Bundle bundle = new Bundle();
                bundle.putString("du lieu",monHoc.get(position));
                intent.putExtras(bundle);
                startActivity(intent);
                return false;
            }
        });
        //Thêm môn học mơi
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mon = edtmonhoc.getText().toString();
                monHoc.add(mon);
                adapter.notifyDataSetChanged();
            }
        });

    }
    //Ánh xạ
    private void anhXa(){
        lvMonHoc = findViewById(R.id.lvMonHoc);
        btnAdd = findViewById(R.id.btnAdd);
        btnUpdate = findViewById(R.id.btnUpdate);
        edtmonhoc = findViewById(R.id.edtnhap);


    }
}
