package com.example.helmi_mii.mobile_ova;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.imangazaliev.circlemenu.CircleMenu;
import com.imangazaliev.circlemenu.CircleMenuButton;

public class menu_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_2);
        CircleMenu circleMenu = (CircleMenu) findViewById(R.id.circleMenu);
        circleMenu.setOnItemClickListener(new CircleMenu.OnItemClickListener()
        {
            @Override
            public void onItemClick(CircleMenuButton menuButton)
            {
                switch (menuButton.getId())
                {
                    case R.id.profilPL:
                        showMessage("Profil"); //menampilkan pesan ketika tombol ditekan
                        Handler profilh = new Handler(); //handler untuk penahan / pemberi delay
                        profilh.postDelayed(new Runnable()
                        {
                            public void run(){
                                Intent ProfilIntent = new Intent(menu_2.this, UserAreaActivity.class); //intent untuk pindah ke layout user area
                                menu_2.this.startActivity(ProfilIntent);//memulai activity
                            }
                        },800);//lama delay untuk pindah ke layout 800ms = 0,8 detik
                        break; //berhenti
                    case R.id.searchPL:
                        showMessage("Cari");
                        break;
                    case R.id.homePL:
                        showMessage("Beranda");
                        break;
                    case R.id.messagePL:
                        showMessage("Pesan");
                        break;
                    case R.id.settingPL:
                        showMessage("Pengaturan");
                        break;
                }
            }
        });

        circleMenu.setStateUpdateListener(new CircleMenu.OnStateUpdateListener()
        {
            @Override
            public void onMenuExpanded()
            {
                Log.d("CircleMenuStatus", "Expanded");
            }

            @Override
            public void onMenuCollapsed()
            {
                Log.d("CircleMenuStatus", "Collapsed");
            }
        });
    }

    private void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}