package com.example.bambino;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PlatosApadter extends RecyclerView.Adapter<PlatosApadter.ViewHolder> {

    public List<Plato> platoList;

    public PlatosApadter(List<Plato> platoList){
        this.platoList = platoList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from((parent.getContext())).inflate(R.layout.list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textPlato.setText(platoList.get(position).getNombre());
        holder.textPrecio.setText(platoList.get(position).getPrecio().toString());
    }

    @Override
    public int getItemCount() {
        return platoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        View mView;
        public TextView textPlato;
        public TextView textPrecio;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            mView = itemView;
            textPlato = mView.findViewById(R.id.textViewPlato);
            textPrecio = mView.findViewById(R.id.textViewPrecio);
        }
    }
}
