package sdei.trumpbeach.resort.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;

import sdei.trumpbeach.resort.R;

/**
 * Created by G-Expo on 11 Sept 2017.
 */

public class DialogHelper
{
    private static final DialogHelper ourInstance = new DialogHelper();

    public static DialogHelper getInstance()
    {
        return ourInstance;
    }

    private DialogHelper()
    {
    }

    public void reportAbuse(Context context, String title, final CallBackG<String> callBackG)
    {
        final CharSequence[] reportMessage = {"Spam", "Fake Account", "Inappropriate content", "Other"};

        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setItems(reportMessage, new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, final int item)
            {
                callBackG.callBack(reportMessage[item].toString());
            }
        });
        builder.show();
    }

    public void showInformation(Context context, String message, final CallBackG<String> callBackG)
    {
        showInformation(context, "Name", message, callBackG);
    }

    public void showInformation(Context context, String title, String message, final CallBackG<String> callBackG)
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setCancelable(false);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                callBackG.callBack("");
            }
        });
        builder.show();
    }

    public void showWithAction(Context context, String message, final CallBackG<String> callBackG)
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
        builder.setTitle("Name");
        builder.setMessage(message);
        builder.setCancelable(false);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                callBackG.callBack("");
            }
        });
        builder.setNegativeButton("Cancel", null);
        builder.show();
    }

    public void showDeleteMenu(Context context, final View anchor, String option, final CallBackG<Boolean> callBackG)
    {
        final PopupMenu popup = new PopupMenu(context, anchor);
        //Inflating the Popup using xml file
        popup.getMenuInflater()
                .inflate(R.menu.menu_delete, popup.getMenu());

        popup.getMenu().findItem(R.id.delete).setTitle(option);
        //registering popup with OnMenuItemClickListener
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener()
        {
            public boolean onMenuItemClick(MenuItem item)
            {
                switch (item.getItemId()) {
                    case R.id.cancel:
                        popup.dismiss();
                        break;

                    case R.id.delete:
                        callBackG.callBack(true);
                        break;

                }
                return true;
            }
        });

        popup.show(); //showing popup menu
    }

}
