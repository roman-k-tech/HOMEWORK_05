package TASK01;

import java.io.File;
import java.io.FileFilter;

/**
 * Created by Роман on 26.10.2017.
 */
class MyFileFilter implements FileFilter
{
    private String[] arr;

    public MyFileFilter(String... arr) {
        super();
        this.arr = arr;
    }

    private boolean check(String ext)
    {
        for (String stringExt : arr) {
            if (stringExt.equals(ext)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean accept(File pathname)
    {
        int pointerIndex = pathname.getName().lastIndexOf(".");
        if (pointerIndex == -1) {
            return false;
        }
        String ext = pathname.getName().substring(pointerIndex + 1);
        return check(ext);
    }
}