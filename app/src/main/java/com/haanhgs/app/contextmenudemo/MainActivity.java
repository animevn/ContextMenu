package com.haanhgs.app.contextmenudemo;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

//
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tvArticle)
    TextView tvArticle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        registerForContextMenu(tvArticle);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo info) {
        super.onCreateContextMenu(menu, v, info);
        getMenuInflater().inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mniCopy:
                tvArticle.setTextColor(Color.RED);
                return true;
            case R.id.mniSelect:
                tvArticle.setAllCaps(true);
                return true;
            case R.id.mniDelete:
                tvArticle.setText("");
                return true;
        }
        return super.onContextItemSelected(item);
    }
}
