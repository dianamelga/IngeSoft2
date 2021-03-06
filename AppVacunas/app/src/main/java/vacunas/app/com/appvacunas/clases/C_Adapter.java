package vacunas.app.com.appvacunas.clases;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.widget.CursorAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import vacunas.app.com.appvacunas.R;
import vacunas.app.com.appvacunas.data.HijoContract.HijosEntry;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import org.w3c.dom.Text;

/**
 * Created by adriana on 9/4/2017.
 */

public class C_Adapter extends CursorAdapter{
  public static final String TAG = "C_Adapter";
  public C_Adapter(Context context, Cursor c) {
    super(context, c, 0);
  }

  @Override
  public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
    LayoutInflater inflater = LayoutInflater.from(context);
    return inflater.inflate(R.layout.list_item_hijos, viewGroup, false);
  }

  @Override
  public void bindView(View view, final Context context, Cursor cursor) {


    // Referencias UI.
    TextView nameText = (TextView) view.findViewById(R.id.tv_name);
     // TextView idHijoText = (TextView) view.findViewById(R.id.tv_idHijo);

    final ImageView avatarImage = (ImageView) view.findViewById(R.id.iv_avatar);

    // Get valores..
      Log.d(TAG,"get valores...");
    String name = cursor.getString(cursor.getColumnIndex(HijosEntry.NOMBRE))
      + " " + cursor.getString(cursor.getColumnIndex(HijosEntry.APELLIDO));
     // Integer idHijo = cursor.getInt(cursor.getColumnIndex(HijosEntry.ID));

    String avatarUri = ""; //No tenemos en la bd

    /*  Log.d("HijosActivity","set idx");
          int idx = cursor.getColumnIndex(HijosEntry.SEXO);
          String sexo = cursor.getString(idx);

      Log.d("HijosActivity",name+ " "+ sexo);
          if (sexo.equals('F')){

              avatarImage.setImageResource(R.drawable.girl);
          }else{

              avatarImage.setImageResource(R.drawable.boy);
          }*/
    // Setup.

    nameText.setText(name);
     // idHijoText.setText(String.valueOf(idHijo));



    Glide
      .with(context)
      .load(Uri.parse("file:///android_asset/" + avatarUri))
      .asBitmap()
      .error(R.drawable.ic_account_circle)
      .centerCrop()
      .into(new BitmapImageViewTarget(avatarImage) {
        @Override
        protected void setResource(Bitmap resource) {
          RoundedBitmapDrawable drawable
            = RoundedBitmapDrawableFactory.create(context.getResources(), resource);
          drawable.setCircular(true);
          avatarImage.setImageDrawable(drawable);
        }
      });

  }
}
