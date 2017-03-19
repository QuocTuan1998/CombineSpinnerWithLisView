package com.example.quoctuan.combinespinnerwithlisview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.quoctuan.combinespinnerwithlisview.model.Catalog;
import com.example.quoctuan.combinespinnerwithlisview.model.Product;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spProduct;
    EditText txtCode,txtName;
    Button btnproduct;
    ListView lvProduct;
//    cặp đối tượng cho Spinner
    ArrayList<Catalog> arrSpinner=new ArrayList<Catalog>();
    ArrayAdapter<Catalog> adapterSpinner=null;
//    cặp đối tượng dùng cho listView
    ArrayList<Product> arrList=new ArrayList<Product>();
    ArrayAdapter<Product> adapterList=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
        fakeDataCatalog();
    }

    private void fakeDataCatalog() {
//        Tạo dữ liệu cho Spinner
        Catalog cat1=new Catalog("1","Samsung");
        Catalog cat2=new Catalog("1","Iphone");
        Catalog cat3=new Catalog("1","IPad");
        arrSpinner.add(cat1);
        arrSpinner.add(cat2);
        arrSpinner.add(cat3);
        adapterSpinner.notifyDataSetChanged();
    }

    private void addEvents() {
//        gán sự kiện cho Button
        btnproduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addProductForCatalog();
            }
        });
        spProduct.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Mỗi lần chọn là một lần cập nhật lại listView
                loadListProductByCatalog(arrSpinner.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
//    Thêm một sản phẩm cho danh mục được chọn
    private void addProductForCatalog() {
        Product p=new Product();
        p.setId(txtCode.getText()+"");
        p.setName(txtName.getText()+"");
        Catalog c= (Catalog) spProduct.getSelectedItem();
        c.addProduct(p);
//        mỗi lần thêm thì cập nhật lại ListView
        loadListProductByCatalog(c);
    }

    private void loadListProductByCatalog(Catalog c) {
//        Xóa danh sách cũ
        arrList.clear();
//        Lấy danh sách mới từ Catalog
        arrList.addAll(c.getListProduct());
//        Cập nhật lại ListView
        adapterList.notifyDataSetChanged();
    }

    private void addControls() {
        spProduct= (Spinner) findViewById(R.id.spProduct);
        txtCode= (EditText) findViewById(R.id.txtCode);
        txtName= (EditText) findViewById(R.id.txtName);
        btnproduct= (Button) findViewById(R.id.btnProduct);
        lvProduct= (ListView) findViewById(R.id.lvProduct);
//        Cấu hình cho Spinner
        adapterSpinner=new ArrayAdapter<Catalog>(MainActivity.this,android.R.layout.simple_spinner_item,arrSpinner);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spProduct.setAdapter(adapterSpinner);
//        Cấu hình cho ListView
        adapterList=new ArrayAdapter<Product>(MainActivity.this,android.R.layout.simple_list_item_1,arrList);
        lvProduct.setAdapter(adapterList);

    }
}
