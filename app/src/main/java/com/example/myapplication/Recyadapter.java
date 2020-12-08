package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.LENGTH_LONG;

public class Recyadapter extends RecyclerView.Adapter<View_Holder> {
    private List<View_Holder> items;
    public ArrayList<Data> listData;
    private Context context;
    private ArrayList<Data> mlistData;
    private DbHelper mDatabase;
    Recyadapter madapter;
    RecyclerView mRecycler;
    Intent i;
    recyclerviev recyclerviev;

    private static final String TAG = "Main";

    public Recyadapter(Context context, ArrayList<Data> listData) {
        Log.e("parthi", "listData---->" + listData.size());
        this.context = context;
        this.listData = listData;
        mDatabase = new DbHelper(context);
    }

    @NonNull
    @Override
    public View_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View list = layoutInflater.inflate(R.layout.recylayout, parent, false);
        View_Holder view_holder = new View_Holder(list);
        return view_holder;
    }

    @Override
    public void onBindViewHolder(@NonNull View_Holder holder, int position) {
        Log.e("parthi", "holder---->" + holder + "||" + position);
        final Data data = listData.get(position);
        holder.Fname.setText(data.getFname());
        holder.Lname.setText(data.getLname());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "onClick: " + data.getFname() + " position : " + position + " name ; " + data.getId());
            }
        });
        
        holder.Edit.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                i = new Intent(context, Registration.class);
                i.putExtra("ID", data.getId());
                i.putExtra("Fname", data.getFname());
                i.putExtra("Lname", data.getLname());
                i.putExtra("Email", data.getEmail());
                i.putExtra("Phone", data.getMobile());
                i.putExtra("Website", data.getWeb());
                i.addFlags(1);
                mDatabase.Update(data);
                context.startActivity(i);

            }
        });
        holder.Emailic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String to = data.Email;
                final Intent intent = new Intent(android.content.Intent.ACTION_SEND);
                intent.setType("`message/rfc822`");
                final PackageManager pm = context.getPackageManager();
                final List<ResolveInfo> matches = pm.queryIntentActivities(intent, 0);
                ResolveInfo best = null;
                for (final ResolveInfo info : matches)
                    if (info.activityInfo.packageName.endsWith(".gm") ||
                            info.activityInfo.name.toLowerCase().contains("gmail")) best = info;
                if (best != null)
                    intent.setClassName(best.activityInfo.packageName, best.activityInfo.name);
                intent.putExtra(intent.EXTRA_EMAIL, new String[]{to});
                context.startActivity(intent);

            }
        });
        holder.Call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("OnClick", "onClick: " + data.Mobile);
                String num = "tel:" + data.Mobile;
                final Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(num));
                context.startActivity(intent);

            }
        });
        holder.Sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num = "sms:" + data.Mobile;
                final Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(num));
                context.startActivity(intent);
            }
        });
        holder.Wp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num = data.Mobile;
                String url = "https://api.whatsapp.com/send?phone=+91" + num;
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                context.startActivity(i);

            }
        });
        holder.Webic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www." + data.Web;
                Log.e("web", "onClick: " + url);
                Intent i = new Intent(context, webView.class);
                i.putExtra("site", url);
                Log.e("web", "onClick: " + url);
                context.startActivity(i);
            }
        });
        holder.Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Id", "onClick: " + holder.getAdapterPosition()+"Email->"+data.getId());
                mDatabase.Delete(data.getId());
//                mRecycler.setAdapter(madapter);
                listData.remove(position);
//                madapter = new Recyadapter(context, listData);
//                mRecycler.setAdapter(madapter);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.e("parthi", "--->" + listData.size());
        return listData.size();
    }

}
