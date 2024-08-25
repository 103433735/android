package com.example.androidapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// Hiển thị danh sách học sinh trong lớp
public class Adapter extends RecyclerView.Adapter<Adapter.AdapterHoler> {
    interface OnItemClick { //Tuong tu protocol
        void clickName(String name);
        void clickAge(String age);
        void clickItem();
    }
    private List<Student> studentList;
    private OnItemClick onItemClick;
    public OnItemClick getOnItemClick() {
        return onItemClick;
    }
    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    //C1: dung constructor
    public Adapter(List<Student> studentList) {
        this.studentList = studentList;
    }

    class AdapterHoler extends RecyclerView.ViewHolder {
        private TextView tvName;
        private TextView tvAge;
        private TextView tvAddress;
        public AdapterHoler(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvAge = itemView.findViewById(R.id.tvAge);
            tvAddress = itemView.findViewById(R.id.tvAddress);
        }
    }

    //Tạo ra item (viewholer là một view để giu data)
    @NonNull
    @Override
    public AdapterHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //Tao ra mot viewholder bang cach inflater
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student, parent, false);
        return new AdapterHoler(view);
    }

    //binding data cho viewHolder
    @Override
    public void onBindViewHolder(@NonNull AdapterHoler holder, int position) {

        holder.tvName.setText(studentList.get(position).getName());
        holder.tvAge.setText(studentList.get(position).getAge() + "");
        holder.tvAddress.setText(studentList.get(position).getAddress());
        holder.tvName.setOnClickListener(view -> {
            onItemClick.clickName(studentList.get(position).getName());
        });

        holder.tvAge.setOnClickListener(view -> {
            onItemClick.clickName(studentList.get(position).getAge() + "");
        });

        holder.itemView.setOnClickListener(v -> {
            onItemClick.clickItem();
        });
    }

    //hiển thị số lượng item
    @Override
    public int getItemCount() {
        return studentList != null ? studentList.size() : 0;
    }


}
