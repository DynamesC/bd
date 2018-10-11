package com.example.zezhou.bd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ProductAdapter extends ArrayAdapter<Product> {
    private int resourceId;

    public ProductAdapter(Context context,         // context上下文
                        int textViewResourceId,  // 子项布局的id
                        List<Product> objects){    // 数据链表
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    // 重写getView
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 获取当前项的Fruit实例
        Product product = getItem(position);
        View view;
        ViewHolder viewHolder;

        if (convertView == null){
            // inflate出子项布局，实例化其中的图片控件和文本控件
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);

            viewHolder = new ViewHolder();
            // 通过id得到图片控件实例
            viewHolder.productImage = (ImageView) view.findViewById(R.id.product_image);
            // 通过id得到文本空间实例
            viewHolder.productName = (TextView) view.findViewById(R.id.product_name);
            // 缓存图片控件和文本控件的实例
            view.setTag(viewHolder);
        }else{
            view = convertView;
            // 取出缓存
            viewHolder = (ViewHolder) view.getTag();
        }

        // 直接使用缓存中的图片控件和文本控件的实例
        // 图片控件设置图片资源
        viewHolder.productImage.setImageResource(product.getImageId());
        // 文本控件设置文本内容
        viewHolder.productName.setText("Name: " + product.getName());
//        viewHolder.productCategory.setText("Category: " + product.getCategoryString());

        return view;
    }

    // 内部类
    class ViewHolder{
        ImageView productImage;
        TextView productName;
        TextView productCategory;
    }



}
