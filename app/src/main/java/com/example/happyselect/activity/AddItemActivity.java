package com.example.happyselect.activity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.happyselect.R;
import com.example.happyselect.adapter.ItemAdapter;
import com.example.happyselect.entity.DataList1;
import com.example.happyselect.entity.DataList2;
import com.example.happyselect.entity.DataList3;
import com.example.happyselect.entity.DataList4;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static org.litepal.LitePalApplication.getContext;

public class AddItemActivity extends AppCompatActivity {

    SharedPreferences.Editor editor = getContext().getSharedPreferences("data",MODE_PRIVATE).edit();
    SharedPreferences pref = getContext().getSharedPreferences("data",MODE_PRIVATE);
    public int dataListFlag = 1;
    public List<String> itemList = new ArrayList<>();

    @BindView(R.id.date_list_1)
    TextView dateList1;
    @BindView(R.id.date_list_2)
    TextView dateList2;
    @BindView(R.id.date_list_3)
    TextView dateList3;
    @BindView(R.id.date_list_4)
    TextView dateList4;
    @BindView(R.id.item_recycler_view)
    RecyclerView itemRecyclerView;
    @BindView(R.id.toolbar_add)
    Toolbar toolbarAdd;
    @BindView(R.id.add_item_edit_text)
    EditText addItemEditText;
    @BindView(R.id.add_item_btn)
    Button addItemBtn;

    private ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        ButterKnife.bind(this);
        itemRecyclerView = (RecyclerView) findViewById(R.id.item_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        itemRecyclerView.setLayoutManager(linearLayoutManager);

        Log.e("Tag", "AddItemActivity.onCreate");
        dataListFlag = pref.getInt("dataListFlag",1);
        getList(getlistDataFlag());

        switch (getlistDataFlag()){
            case 1:
                dateList1.setBackground(getResources().getDrawable(R.drawable.data_list_text_bg));
                dateList1.setTextColor(getColor(R.color.data_list_name_tc));
                dateList2.setBackground(null);
                dateList2.setTextColor(Color.parseColor("#767571"));
                dateList3.setBackground(null);
                dateList3.setTextColor(Color.parseColor("#767571"));
                dateList4.setBackground(null);
                dateList4.setTextColor(Color.parseColor("#767571"));
                itemList.clear();
                getList(1);
                adapter = new ItemAdapter(itemList);
                adapter.setOnItemClickListener(new ItemAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        LitePal.deleteAll(DataList1.class, "itemText = ?", itemList.get(position));
                        itemList.remove(position);
                        adapter.notifyDataSetChanged();
                        adapter.notifyItemRemoved(position);
                    }
                });
                itemRecyclerView.setAdapter(adapter);
                itemRecyclerView.setItemAnimator(new DefaultItemAnimator());
                break;
            case 2:
                dateList1.setBackground(null);
                dateList1.setTextColor(Color.parseColor("#767571"));
                dateList2.setBackground(getResources().getDrawable(R.drawable.data_list_text_bg));
                dateList2.setTextColor(getColor(R.color.data_list_name_tc));
                dateList3.setBackground(null);
                dateList3.setTextColor(Color.parseColor("#767571"));
                dateList4.setBackground(null);
                dateList4.setTextColor(Color.parseColor("#767571"));
                itemList.clear();
                getList(2);
                adapter = new ItemAdapter(itemList);
                adapter.setOnItemClickListener(new ItemAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        LitePal.deleteAll(DataList2.class, "itemText = ?", itemList.get(position));
                        itemList.remove(position);
                        adapter.notifyDataSetChanged();
                        adapter.notifyItemRemoved(position);
                    }
                });
                itemRecyclerView.setAdapter(adapter);
                itemRecyclerView.setItemAnimator(new DefaultItemAnimator());
                break;
            case 3:
                dateList1.setBackground(null);
                dateList1.setTextColor(Color.parseColor("#767571"));
                dateList2.setBackground(null);
                dateList2.setTextColor(Color.parseColor("#767571"));
                dateList3.setBackground(getResources().getDrawable(R.drawable.data_list_text_bg));
                dateList3.setTextColor(getColor(R.color.data_list_name_tc));
                dateList4.setBackground(null);
                dateList4.setTextColor(Color.parseColor("#767571"));
                itemList.clear();
                getList(3);
                adapter = new ItemAdapter(itemList);
                adapter.setOnItemClickListener(new ItemAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        LitePal.deleteAll(DataList3.class, "itemText = ?", itemList.get(position));
                        itemList.remove(position);
                        adapter.notifyDataSetChanged();
                        adapter.notifyItemRemoved(position);
                    }
                });
                itemRecyclerView.setAdapter(adapter);
                itemRecyclerView.setItemAnimator(new DefaultItemAnimator());
                break;
            case 4:
                dateList1.setBackground(null);
                dateList1.setTextColor(Color.parseColor("#767571"));
                dateList2.setBackground(null);
                dateList2.setTextColor(Color.parseColor("#767571"));
                dateList3.setBackground(null);
                dateList3.setTextColor(Color.parseColor("#767571"));
                dateList4.setBackground(getResources().getDrawable(R.drawable.data_list_text_bg));
                dateList4.setTextColor(getColor(R.color.data_list_name_tc));
                itemList.clear();
                getList(4);
                adapter = new ItemAdapter(itemList);
                adapter.setOnItemClickListener(new ItemAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        LitePal.deleteAll(DataList4.class, "itemText = ?", itemList.get(position));
                        itemList.remove(position);
                        adapter.notifyDataSetChanged();
                        adapter.notifyItemRemoved(position);
                    }
                });
                itemRecyclerView.setAdapter(adapter);
                itemRecyclerView.setItemAnimator(new DefaultItemAnimator());
                break;
        }




        setSupportActionBar(toolbarAdd);


    }

    @Override
    protected void onResume() {
        super.onResume();
        dataListFlag = pref.getInt("dataListFlag",1);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @OnClick({R.id.date_list_1, R.id.date_list_2, R.id.date_list_3, R.id.date_list_4,R.id.add_item_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.date_list_1:

                dateList1.setBackground(getResources().getDrawable(R.drawable.data_list_text_bg));
                dateList1.setTextColor(getColor(R.color.data_list_name_tc));
                dateList2.setBackground(null);
                dateList2.setTextColor(Color.parseColor("#767571"));
                dateList3.setBackground(null);
                dateList3.setTextColor(Color.parseColor("#767571"));
                dateList4.setBackground(null);
                dateList4.setTextColor(Color.parseColor("#767571"));
                editor.putInt("dataListFlag",1);
                editor.apply();
                itemList.clear();
                getList(getlistDataFlag());
                Log.e("flag",getlistDataFlag() + "");
                adapter = new ItemAdapter(itemList);
                adapter.setOnItemClickListener(new ItemAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        LitePal.deleteAll(DataList1.class, "itemText = ?", itemList.get(position));
                        itemList.remove(position);
                        adapter.notifyDataSetChanged();
                        adapter.notifyItemRemoved(position);
                    }
                });
                itemRecyclerView.setAdapter(adapter);
                itemRecyclerView.setItemAnimator(new DefaultItemAnimator());
                break;
            case R.id.date_list_2:
                dateList1.setBackground(null);
                dateList1.setTextColor(Color.parseColor("#767571"));
                dateList2.setBackground(getResources().getDrawable(R.drawable.data_list_text_bg));
                dateList2.setTextColor(getColor(R.color.data_list_name_tc));
                dateList3.setBackground(null);
                dateList3.setTextColor(Color.parseColor("#767571"));
                dateList4.setBackground(null);
                dateList4.setTextColor(Color.parseColor("#767571"));
                editor.putInt("dataListFlag",2);
                editor.apply();
                itemList.clear();
                getList(getlistDataFlag());
                Log.e("flag",getlistDataFlag() + "");
                adapter = new ItemAdapter(itemList);
                adapter.setOnItemClickListener(new ItemAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        LitePal.deleteAll(DataList2.class, "itemText = ?", itemList.get(position));
                        itemList.remove(position);
                        adapter.notifyDataSetChanged();
                        adapter.notifyItemRemoved(position);
                    }
                });
                itemRecyclerView.setAdapter(adapter);
                itemRecyclerView.setItemAnimator(new DefaultItemAnimator());
                break;
            case R.id.date_list_3:
                dateList1.setBackground(null);
                dateList1.setTextColor(Color.parseColor("#767571"));
                dateList2.setBackground(null);
                dateList2.setTextColor(Color.parseColor("#767571"));
                dateList3.setBackground(getResources().getDrawable(R.drawable.data_list_text_bg));
                dateList3.setTextColor(getColor(R.color.data_list_name_tc));
                dateList4.setBackground(null);
                dateList4.setTextColor(Color.parseColor("#767571"));
                editor.putInt("dataListFlag",3);
                editor.apply();
                itemList.clear();
                getList(getlistDataFlag());
                Log.e("flag",getlistDataFlag() + "");
                adapter = new ItemAdapter(itemList);
                adapter.setOnItemClickListener(new ItemAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        LitePal.deleteAll(DataList3.class, "itemText = ?", itemList.get(position));
                        itemList.remove(position);
                        adapter.notifyDataSetChanged();
                        adapter.notifyItemRemoved(position);
                    }
                });
                itemRecyclerView.setAdapter(adapter);
                itemRecyclerView.setItemAnimator(new DefaultItemAnimator());
                break;
            case R.id.date_list_4:
                dateList1.setBackground(null);
                dateList1.setTextColor(Color.parseColor("#767571"));
                dateList2.setBackground(null);
                dateList2.setTextColor(Color.parseColor("#767571"));
                dateList3.setBackground(null);
                dateList3.setTextColor(Color.parseColor("#767571"));
                dateList4.setBackground(getResources().getDrawable(R.drawable.data_list_text_bg));
                dateList4.setTextColor(getColor(R.color.data_list_name_tc));
                editor.putInt("dataListFlag",4);
                editor.apply();
                itemList.clear();
                getList(getlistDataFlag());
                Log.e("flag",getlistDataFlag() + "");
                adapter = new ItemAdapter(itemList);
                adapter.setOnItemClickListener(new ItemAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        LitePal.deleteAll(DataList4.class, "itemText = ?", itemList.get(position));
                        itemList.remove(position);
                        adapter.notifyDataSetChanged();
                        adapter.notifyItemRemoved(position);
                    }
                });
                itemRecyclerView.setAdapter(adapter);
                itemRecyclerView.setItemAnimator(new DefaultItemAnimator());
                break;

            case R.id.add_item_btn:

                String itemContent = addItemEditText.getText().toString();
                if ("".equals(itemContent)) {
                    Toast.makeText(this, "请先输入数据", Toast.LENGTH_SHORT).show();
                } else {
                    itemList.clear();
                    switch (getlistDataFlag()){
                        case 1:
                            getList(1);
                            itemList.add(itemContent);
                            DataList1 item1 = new DataList1();
                            item1.setItemText(itemContent);
                            item1.save();
                            adapter.notifyItemInserted(itemList.size() - 1);
                            itemRecyclerView.scrollToPosition(itemList.size() - 1);
                            addItemEditText.setText("");
                            break;
                        case 2:
                            getList(2);
                            itemList.add(itemContent);
                            DataList2 item2 = new DataList2();
                            item2.setItemText(itemContent);
                            item2.save();
                            adapter.notifyItemInserted(itemList.size() - 1);
                            itemRecyclerView.scrollToPosition(itemList.size() - 1);
                            addItemEditText.setText("");
                            break;
                        case 3:
                            getList(3);
                            itemList.add(itemContent);
                            DataList3 item3 = new DataList3();
                            item3.setItemText(itemContent);
                            item3.save();
                            adapter.notifyItemInserted(itemList.size() - 1);
                            itemRecyclerView.scrollToPosition(itemList.size() - 1);
                            addItemEditText.setText("");
                            break;
                        case 4:
                            getList(4);
                            itemList.add(itemContent);
                            DataList4 item4 = new DataList4();
                            item4.setItemText(itemContent);
                            item4.save();
                            adapter.notifyItemInserted(itemList.size() - 1);
                            itemRecyclerView.scrollToPosition(itemList.size() - 1);
                            addItemEditText.setText("");
                            break;
                    }


                }
                break;
        }
    }

    public int getlistDataFlag(){
        int flag = pref.getInt("dataListFlag",1);
        return  flag;
    }
    //获取list数据
    public void getList(int flag) {
        switch (flag){
            case 1:
                List<DataList1> lists1 = LitePal.findAll(DataList1.class);
                for (int i = 0; i < lists1.size(); i++) {
                    itemList.add(lists1.get(i).getItemText());
                }
                break;
            case 2:
                List<DataList2> lists2= LitePal.findAll(DataList2.class);
                for (int i = 0; i < lists2.size(); i++) {
                    itemList.add(lists2.get(i).getItemText());
                }
                break;
            case 3:
                List<DataList3> lists3= LitePal.findAll(DataList3.class);
                for (int i = 0; i < lists3.size(); i++) {
                    itemList.add(lists3.get(i).getItemText());
                }
                break;
            case 4:
                List<DataList4> lists4= LitePal.findAll(DataList4.class);
                for (int i = 0; i < lists4.size(); i++) {
                    itemList.add(lists4.get(i).getItemText());
                }
                break;
        }

    }
}
