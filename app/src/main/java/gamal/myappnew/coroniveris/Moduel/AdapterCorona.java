package gamal.myappnew.coroniveris.Moduel;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import gamal.myappnew.coroniveris.DeatlistActivity;
import gamal.myappnew.coroniveris.R;
import gamal.myappnew.coroniveris.Retrofit.InfoCoron;

public class AdapterCorona extends RecyclerView.Adapter<AdapterCorona.ViewHolder>  {
    Context context;
    List<InfoCoron> list;
    List<InfoCoron> searchlist;

    public AdapterCorona(Context context, List<InfoCoron> list) {
        this.context = context;
        this.list = list;
        searchlist=new ArrayList<>(list);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list_covid_country,parent,false));
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.tvtextcountry.setText(list.get(position).getCountry());
        holder.totalcassess.setText(list.get(position).getCases()+"");
        Glide.with(context).load(list.get(position).getFlag()).into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Common.infoCoron=list.get(position);
                context.startActivity(new Intent(context, DeatlistActivity.class));
            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView imageView;
        TextView tvtextcountry,totalcassess;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imagecountry);
            totalcassess=itemView.findViewById(R.id.tvToatalCases);
            tvtextcountry=itemView.findViewById(R.id.tvCountryname);
        }
    }


    public void filterList(ArrayList<InfoCoron> filteredList) {
        list = filteredList;
        notifyDataSetChanged();
    }
}
