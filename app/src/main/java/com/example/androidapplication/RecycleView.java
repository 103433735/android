package com.example.androidapplication;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecycleView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycle_view);
        RecyclerView rcvData = findViewById(R.id.tableView); // tao tableview

        Adapter adapter = new Adapter(createStudentList()); // đăng ký cell
        rcvData.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL,false));
        rcvData.setAdapter(adapter);
        adapter.setOnItemClick(new Adapter.OnItemClick() {

                                   @Override
                                   public void clickName(String name) {
                                       Toast.makeText(RecycleView.this, name, Toast.LENGTH_SHORT).show();
                                   }

                                   @Override
                                   public void clickAge(String age) {
                                       Toast.makeText(RecycleView.this, age, Toast.LENGTH_SHORT).show();
                                   }

                                   @Override
                                   public void clickItem() {
                                       Toast.makeText(RecycleView.this, "This item is selected", Toast.LENGTH_SHORT).show();
                                   }
                               }

        );
    }

    private List<Student> createStudentList() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("nguyen anh duc", 24, "1", "Hanoi"));
        studentList.add(new Student("nguyen anh duc", 24, "2", "Hanoi"));
        studentList.add(new Student("nguyen anh duc", 24, "3", "Hanoi"));
        studentList.add(new Student("nguyen anh duc", 24, "4", "Hanoi"));
        studentList.add(new Student("nguyen anh duc", 24, "5", "Hanoi"));
        studentList.add(new Student("nguyen anh duc", 24, "6", "Hanoi"));
        studentList.add(new Student("nguyen anh duc", 24, "7", "Hanoi"));
        studentList.add(new Student("nguyen anh duc", 24, "8", "Hanoi"));
        studentList.add(new Student("nguyen anh duc", 24, "9", "Hanoi"));
        studentList.add(new Student("nguyen anh duc", 24, "10", "Hanoi"));
        studentList.add(new Student("nguyen anh duc", 24, "11", "Hanoi"));
        studentList.add(new Student("nguyen anh duc", 24, "12", "Hanoi"));
        studentList.add(new Student("nguyen anh duc", 24, "13", "Hanoi"));
        studentList.add(new Student("nguyen anh duc", 24, "14", "Hanoi"));
        studentList.add(new Student("nguyen anh duc", 24, "15", "Hanoi"));
        studentList.add(new Student("nguyen anh duc", 24, "16", "Hanoi"));
        studentList.add(new Student("nguyen anh duc", 24, "17", "Hanoi"));
        studentList.add(new Student("nguyen anh duc", 24, "18", "Hanoi"));
        studentList.add(new Student("nguyen anh duc", 24, "19", "Hanoi"));

        return studentList;

    }
}