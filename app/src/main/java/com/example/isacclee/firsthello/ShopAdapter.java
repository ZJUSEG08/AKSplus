package com.example.isacclee.firsthello;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static com.example.isacclee.firsthello.R.drawable.ic_menu_gallery;

/**
 * Created by Isacclee on 7/14/17.
 */

public class ShopAdapter extends BaseAdapter {
    private List<GoodsStructure> datas = new ArrayList<GoodsStructure>();//新闻列表集合

    private Context context;
    private LayoutInflater layoutInflater;

    public ShopAdapter(Context context, List<GoodsStructure> datas) {
        this.datas = datas;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return datas.size(); //返回列表的长度
    }

    @Override
    public GoodsStructure getItem(int position) {
        return datas.get(position); //通过列表的位置 获得集合中的对象
    }

    @Override
    public long getItemId(int position) { // 获得集合的Item的位置
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.shops_item, null);//找到布局文件
            convertView.setTag(new ViewHolder(convertView));
        }
        initViews(getItem(position), (ViewHolder) convertView.getTag());
        return convertView;

    }

    private void initViews(GoodsStructure data, ViewHolder holder) {//初始化数据

        /**
         * 第一次初始话的时候通过 要请求的Url地址 为每个图片设置一个Tag标记,
         * 然后在设置图片的时候判断Tag标记如果是才把图片设置到ImageView上,
         * 这做的原因是为了防止ListView 中的图片错位...
         */
        holder.ivImg.setTag(data.getDescription());//设置Tag
        holder.ivImg.setImageResource(R.drawable.ic_menu_gallery);
        //设置新闻标题为集合中获得的标题
//        holder.tvTitle.setText(data.getNewsTitle());

        ////设置新闻发布时间为集合中获得的发布时间
        holder.tvTitle.setText(data.getGoodsName());
        holder.tvDate.setText(data.getDescription());
        holder.price.setText(data.getPrice().toString()+"元");


    }

    protected class ViewHolder {
        public ImageView ivImg;
        public TextView tvTitle;
        public TextView tvDate;
        public TextView price;
        public Button selectButton;

        public ViewHolder(View view) {
            ivImg = (ImageView) view.findViewById(R.id.iv_img);
            tvTitle = (TextView) view.findViewById(R.id.shop_title);
            tvDate = (TextView) view.findViewById(R.id.shop_date);
            price = (TextView) view.findViewById(R.id.textView10);
//            selectButton = (Button) view.findViewById(R.id.button10);
        }
    }


}
