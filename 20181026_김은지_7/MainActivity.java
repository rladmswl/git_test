package com.example.baseadapterex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Student> mData = null;
    BaseAdapterEx mAdapter = null;
    ListView mListView = null;
    EditText mInput;
    //String mName, mNumber, mDepartment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_test);

        mInit();
    }

    public class Student {
        String mName = ""; //이름
        String mNumber = ""; //학번
        String mDepartment = ""; //학과
    }

    public class BaseAdapterEx extends BaseAdapter {
        Context mContext = null;
        ArrayList<Student> mData = null;
        LayoutInflater mLayoutInflater = null;

        public BaseAdapterEx(Context context, ArrayList<Student> data) {
            mContext = context;
            mData = data;
            mLayoutInflater = LayoutInflater.from(mContext);
        }

        @Override
        public int getCount() {
            return mData.size();
        }

        @Override
        public Object getItem(int position) {
            return mData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            /*View itemLayout = convertView;
            if ( itemLayout == null) {
                itemLayout = mLayoutInflater.inflate (R.layout.list_view_item_layout, null);
            }*/
            View itemLayout = mLayoutInflater.inflate(R.layout.list_view_item_layout, null);

            TextView nameTv = (TextView) itemLayout.findViewById(R.id.tv_name);
            TextView numberTv = (TextView) itemLayout.findViewById(R.id.tv_number);
            TextView departmentTv = (TextView) itemLayout.findViewById(R.id.tv_dept);

            nameTv.setText(mData.get(position).mName);
            numberTv.setText(mData.get(position).mNumber);
            departmentTv.setText(mData.get(position).mDepartment);

            return itemLayout;
        }

        public void add(int index, Student addData) {
            mData.add(index, addData);
            notifyDataSetChanged();
        }
        public void delete(int index) {
            mData.remove(index);
            notifyDataSetChanged();
        }
        public void clear() {
            mData.clear();
            notifyDataSetChanged();
        }
    }

    public void mInit() {
        mInitData();
        mInitAdapterView();
    }

    private void mInitData() {
        mData = new ArrayList<Student>();

        for (int i = 0; i < 100; i++) {
            Student student = new Student();

            student.mName = "슈퍼성근" + i;
            student.mNumber = "95000" + i;
            student.mDepartment = "컴퓨터 공학" + i;

            mData.add(student);
        }
    }

    private void mInitAdapterView() {
        mAdapter = new BaseAdapterEx(this, mData);

        mListView = (ListView) findViewById(R.id.listview);
        mListView.setAdapter(mAdapter);
    }

    public void mOnClick(View v) {
        switch(v.getId()) {
            case R.id.b_add:
                EditText nameEt = (EditText) findViewById(R.id.et_name);
                EditText numberEt = (EditText) findViewById(R.id.et_number);
                EditText departmentEt = (EditText) findViewById(R.id.et_dept);

                Student addData = new Student();

                addData.mName = nameEt.getText().toString();
                addData.mNumber = numberEt.getText().toString();
                addData.mDepartment = departmentEt.getText().toString();

                mAdapter.add(0, addData);

                break;

            case R.id.b_del:
               /* int pos = mListView.getCheckedItemPosition();
                if (pos != ListView.INVALID_POSITION) { //체크가 되어있다면
                    mAdapter.delete(pos);
                }*/
/*
                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        mAdapter.delete(position);
                    }
                });*/

/*
                int count;
                count = mAdapter.getCount();
*/
/*
                int pos;
                if(pos == mListView.getOnItemClickListener()) {
                    mAdapter.delete(pos);
                }
                */
                //밑에 두줄만 있으면 버튼클릭시 맨 위에거 삭제됨.
                mListView.getOnItemClickListener();
                mAdapter.delete(0);

                //mAdapter.delete(count);


/*
                int count, pos;
                count = mAdapter.getCount();

                if(count > 0) {
                    pos = mListView.getCheckedItemPosition();

                    if ( pos > -1 && pos < count) {
                        mData.remove(pos);
                        mListView.clearChoices();
                    }
                }*/
                break;

            case R.id.b_all_del:
                mAdapter.clear();
                break;
        }

    }
}
