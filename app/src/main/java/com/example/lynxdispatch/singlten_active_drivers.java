package com.example.lynxdispatch;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import androidx.core.app.ActivityCompat;
import de.hdodenhof.circleimageview.CircleImageView;

public class singlten_active_drivers extends BaseAdapter {

    private Context context;
    private List<String> name, name1, name2, name3;
    private TextView t1, t2, t3, t4;
    private ImageView phone, msg;
    private CircleImageView avatar;

    singlten_active_drivers(Context c, List<String> s1, List<String> s2, List<String> s3, List<String> s4) {
        name = s1;
        name1 = s2;
        name2 = s3;
        name3 = s4;
        context = c;
    }

    @Override
    public int getCount() {
        return name.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.singlten_active_drivers_layout, null, false);


        t1 = convertView.findViewById(R.id.driver_name_singlten);
        t2 = convertView.findViewById(R.id.driver_name1_singlten);
        t3 = convertView.findViewById(R.id.driver_name2_singlten);
        t4 = convertView.findViewById(R.id.driver_name3_singlten);
        msg = convertView.findViewById(R.id.driver_msg_singlten);
        phone = convertView.findViewById(R.id.driver_call_singlten);
        avatar = convertView.findViewById(R.id.driver_avatar_singlten);

        t1.setText(name.get(position));
        t2.setText(name1.get(position));
        t3.setText(name2.get(position));
        t4.setText(name3.get(position));


        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "call clicked", Toast.LENGTH_SHORT).show();
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse(String.valueOf(565464)));//change the number
                if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                context.startActivity(callIntent);
            }
        });

        msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "msg clicked", Toast.LENGTH_SHORT).show();
            }
        });


        return convertView;
    }
}
