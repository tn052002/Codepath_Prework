package trung.codepath.sampletodo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class EditItemActivity extends AppCompatActivity {
    String itemText;
    EditText etTodoItem;
    int itemPos;
    ArrayList<String> items;
    ItemsHelper itemsHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        itemsHelper = new ItemsHelper(getApplicationContext());

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
//            itemText = extras.getString("editItem");
            itemPos = extras.getInt("itemPos");
            items = extras.getStringArrayList("itemList");
        }

        etTodoItem = (EditText) findViewById(R.id.etTodoItem);
        etTodoItem.setText(items.get(itemPos));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onSaveItem(View view) {
        EditText etTodoItem = (EditText) findViewById(R.id.etTodoItem);
        String itemText = etTodoItem.getText().toString();
        if (itemText.trim().isEmpty()) {
            etTodoItem.setError("Item cannot be blank");
            etTodoItem.setText(items.get(itemPos));
        } else {
            items.set(itemPos, itemText);
            itemsHelper.writeItems(items);
            finish();
        }
    }
}
