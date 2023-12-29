package com.example.kiemtra.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kiemtra.R;
import com.example.kiemtra.model.SanPham;
import com.squareup.picasso.Picasso;

import java.util.List;

/*public class SanPhamAdapter extends ArrayAdapter<SanPham> {
    private Context context;
    private List<SanPham> tasks;

    public SanPhamAdapter( Context context, List<SanPham> tasks) {
        super(context, 0,tasks);
        this.context = context;
        this.tasks = tasks;
    }
    @Nullable
    @Override
    public SanPham getItem(int position) {
        return super.getItem(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        SanPham task= getItem(position);
        if(convertView==null)
        {
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.item_product,parent,false);
        }
        //anh xạ
        TextView tvTenSP= convertView.findViewById(R.id.tvTenSP);
        TextView tvGiaTien= convertView.findViewById(R.id.tvGiaTien);
        //ImageView Image=convertView.findViewById(R.id.imgSP);
        //lấy data
        tvTenSP.setText(task.getTensp());
        String giaTienString = String.valueOf(task.getGiatien());
        tvGiaTien.setText(giaTienString);
        //Image.setImageResource(task.getImage());
        return convertView;
    }
}*/
public class SanPhamAdapter extends RecyclerView.Adapter<SanPhamAdapter.ViewHolder> {
    private Context context;
    private List<SanPham> sanPhamList;

    public SanPhamAdapter(Context context, List<SanPham> sanPhamList) {
        this.context = context;
        this.sanPhamList = sanPhamList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SanPham sanPham = sanPhamList.get(position);
        holder.tvTenSP.setText(sanPham.getTensp());
        holder.tvGiaTien.setText(String.valueOf(sanPham.getGiatien()));
        Picasso.get().load(sanPham.getImage()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return sanPhamList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTenSP;
        TextView tvGiaTien;

        ImageView img;
        ViewHolder(View itemView) {
            super(itemView);
            tvTenSP = itemView.findViewById(R.id.tvTenSP);
            tvGiaTien = itemView.findViewById(R.id.tvGiaTien);
            img=itemView.findViewById(R.id.imgSP);
        }
    }
}