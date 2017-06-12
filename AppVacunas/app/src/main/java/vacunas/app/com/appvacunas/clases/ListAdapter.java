package vacunas.app.com.appvacunas.clases;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import vacunas.app.com.appvacunas.Calculador;
import vacunas.app.com.appvacunas.R;

/**
 * Created by adriana on 9/4/2017.
 */

public class ListAdapter extends BaseExpandableListAdapter {
  private Context _context;
  private List<String> _listDataHeader; // header titles
  // child data in format of header title, child title
  private HashMap<String, List<Vacuna>> _listDataChild;

  public ListAdapter(Context context, List<String> listDataHeader,
                               HashMap<String, List<Vacuna>> listChildData) {
    this._context = context;
    this._listDataHeader = listDataHeader;
    this._listDataChild = listChildData;
  }

  @Override
  public Object getChild(int groupPosition, int childPosititon) {
    return this._listDataChild.get(this._listDataHeader.get(groupPosition))
      .get(childPosititon);
  }

  @Override
  public long getChildId(int groupPosition, int childPosition) {
    return childPosition;
  }

  @Override
  public View getChildView(int groupPosition, final int childPosition,
                           boolean isLastChild, View convertView, ViewGroup parent) {

    final Vacuna vacuna = (Vacuna) getChild(groupPosition, childPosition);

    if (convertView == null) {
      LayoutInflater infalInflater = (LayoutInflater) this._context
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      convertView = infalInflater.inflate(R.layout.list_item_vacunas, null);
    }

    //Nombre vacuna
    TextView txtListChild = (TextView) convertView
      .findViewById(R.id.lblListItem);

    txtListChild.setText(vacuna.getNombre_vac());

    //Dosis

    txtListChild = (TextView) convertView.findViewById(R.id.tv_dosis);
    txtListChild.setText("Dosis: " + String.valueOf(vacuna.getDosis()));

    //Fecha

    txtListChild = (TextView) convertView.findViewById(R.id.tv_fecha);
    txtListChild.setText("Fecha: " + vacuna.getFecha());

    //Edad
    txtListChild = (TextView) convertView.findViewById(R.id.tv_edad);
    txtListChild.setText("Edad: " + vacuna.getEdad());

    //Lote
    txtListChild = (TextView) convertView.findViewById(R.id.tv_lote);
    txtListChild.setText("Lote: " + vacuna.getLote());

    //Responsable
    txtListChild = (TextView) convertView.findViewById(R.id.tv_responsable);
    txtListChild.setText("Responsable: " + vacuna.getResponsable());

    ImageView imgListChild = (ImageView) convertView.findViewById(R.id.iv_vacunas);

    Calculador calc = new Calculador();
    if(vacuna.getAplicado() == 1) {
      imgListChild.setImageResource(R.drawable.check_ok);
    }
    else if (calc.vencido(vacuna.getFecha_apl(), vacuna.getMes_aplicacion())){

      imgListChild.setImageResource(R.drawable.no_check);

    }
    // imgListChild.setImageResource(R.drawable.no_check);}
    else if (calc.enTiempo(vacuna.getFecha_apl())) {
      imgListChild.setImageResource(R.drawable.no_yet_orange);
    }
    else {
      imgListChild.setImageResource(R.drawable.no_yet_check);
    }
    return convertView;
  }

  @Override
  public int getChildrenCount(int groupPosition) {
    return this._listDataChild.get(this._listDataHeader.get(groupPosition))
      .size();
  }

  @Override
  public Object getGroup(int groupPosition) {
    return this._listDataHeader.get(groupPosition);
  }

  @Override
  public int getGroupCount() {
    return this._listDataHeader.size();
  }

  @Override
  public long getGroupId(int groupPosition) {
    return groupPosition;
  }

  @Override
  public View getGroupView(int groupPosition, boolean isExpanded,
                           View convertView, ViewGroup parent) {
    String headerTitle = (String) getGroup(groupPosition);
    if (convertView == null) {
      LayoutInflater infalInflater = (LayoutInflater) this._context
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      convertView = infalInflater.inflate(R.layout.list_group, null);
    }

    TextView lblListHeader = (TextView) convertView
      .findViewById(R.id.lblListHeader);
    lblListHeader.setTypeface(null, Typeface.BOLD);
    lblListHeader.setText(headerTitle);

    return convertView;
  }

  @Override
  public boolean hasStableIds() {
    return false;
  }

  @Override
  public boolean isChildSelectable(int groupPosition, int childPosition) {
    return true;
  }
}
