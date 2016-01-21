package trung.codepath.sampletodo;

import android.content.Context;
import android.view.View;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by tnguyen on 1/20/16.
 */
public class ItemsHelper extends View {
    File fileDir;
    File todoFile;

    public ItemsHelper(Context context) {
        super(context);
        fileDir = context.getFilesDir();
        todoFile = new File(fileDir, "todo.txt");
    }

    public ArrayList<String> readItems() {
        ArrayList<String> items;

        try {
            items = new ArrayList<String>(FileUtils.readLines(todoFile));
        } catch (IOException e) {
            items = new ArrayList<String>();
        }

        return items;
    }

    public void writeItems(ArrayList<String> items) {
        try {
            FileUtils.writeLines(todoFile, items);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
