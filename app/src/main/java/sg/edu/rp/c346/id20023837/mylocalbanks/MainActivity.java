package sg.edu.rp.c346.id20023837.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;
    boolean blDBS;
    boolean blOCBC;
    boolean blUOB;

    String wordClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.tvDBS);
        tvOCBC = findViewById(R.id.tvOCBC);
        tvUOB = findViewById(R.id.tvUOB);
        blDBS = true;
        blOCBC = true;
        blUOB = true;

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the bank");
        menu.add(0, 2, 2, "Toggle Favourite");

        if (v == tvDBS) {
            wordClicked = "DBS";
        } else if (v == tvOCBC) {
            wordClicked = "OCBC";
        } else if (v == tvUOB) {
            wordClicked = "UOB";
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked.equalsIgnoreCase("DBS")) {
            if (item.getItemId() == 0) {
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intentWeb);
                return true;
            } else if (item.getItemId() == 1) {
                Intent intentContact = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + 1 + 800 + 111 + 1111));
                startActivity(intentContact);
                return true;
            } else if (item.getItemId() == 2){
                if(blDBS){
                    tvDBS.setTextColor(Color.parseColor("#FF0000"));
                    blDBS = false;
                } else if (blDBS == false){
                    tvDBS.setTextColor(Color.parseColor("#808080"));
                    blDBS = true;
                }
            }

        } else if (wordClicked.equalsIgnoreCase("OCBC")) {
            if (item.getItemId() == 0) {
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intentWeb);
                return true;
            } else if (item.getItemId() == 1) {
                Intent intentContact = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + 1 + 800 + 363 + 3333));
                startActivity(intentContact);
                return true;

        } else if (item.getItemId() == 2){
            if(blOCBC){
                tvOCBC.setTextColor(Color.parseColor("#FF0000"));
                blOCBC = false;
            } else if (blOCBC == false){
                tvOCBC.setTextColor(Color.parseColor("#808080"));
                blOCBC = true;
            }
        }


    } else if (wordClicked.equalsIgnoreCase("UOB")) {
            if (item.getItemId() == 0) {
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intentWeb);
                return true;
            } else if (item.getItemId() == 1) {
                Intent intentContact = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + 1 + 800 + 222 + 2121));
                startActivity(intentContact);
                return true;
            } else if (item.getItemId() == 2){
                if(blUOB){
                    tvUOB.setTextColor(Color.parseColor("#FF0000"));
                    blUOB = false;
                } else if (blUOB == false){
                    tvUOB.setTextColor(Color.parseColor("#808080"));
                    blUOB = true;
                }
            }
        }
            return super.onContextItemSelected(item);
        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        String DBSel = getResources().getString(R.string.DBSel);
        String OCBCSel = getResources().getString(R.string.OCBCel);
        String UOBel = getResources().getString(R.string.UOBel);

        String DBSchi = getResources().getString(R.string.DBSchi);
        String OCBCchi = getResources().getString(R.string.OCBCchi);
        String UOBchi = getResources().getString(R.string.UOBchi);

        String error = "Error translation";

        if (id == R.id.EnglishSelection) {
            tvDBS.setText(DBSel);
            tvOCBC.setText(OCBCSel);
            tvUOB.setText(UOBel);
            return true;

        } else if (id == R.id.ChineseSelection) {
            tvDBS.setText(DBSchi);
            tvOCBC.setText(OCBCchi);
            tvUOB.setText(UOBchi);
            return true;

        } else {
            tvDBS.setText(error);
            tvOCBC.setText(error);
            tvUOB.setText(error);
        }

        return super.onOptionsItemSelected(item);
    }
}