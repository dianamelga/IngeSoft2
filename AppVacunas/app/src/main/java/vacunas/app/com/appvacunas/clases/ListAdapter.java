package vacunas.app.com.appvacunas.clases;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
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
  private HashMap<String, List<VacunaHijo>> _listDataChild;

  public ListAdapter(Context context, List<String> listDataHeader,
                               HashMap<String, List<VacunaHijo>> listChildData) {
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

    final VacunaHijo vacunaHijo = (VacunaHijo) getChild(groupPosition, childPosition);

    if (convertView == null) {
      LayoutInflater infalInflater = (LayoutInflater) this._context
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      convertView = infalInflater.inflate(R.layout.list_item_vacunas, null);
    }

    //Nombre vacunaHijo
    TextView txtListChild = (TextView) convertView
      .findViewById(R.id.lblListItem);

    txtListChild.setText(vacunaHijo.getNombre_vac());

    //Dosis

    txtListChild = (TextView) convertView.findViewById(R.id.tv_dosis);
    txtListChild.setText("Dosis: " + String.valueOf(vacunaHijo.getNro_dosis()));

    //Fecha Programada

    txtListChild = (TextView) convertView.findViewById(R.id.tv_fecha);
    txtListChild.setText("Fecha Prog: " + vacunaHijo.getFecha_programada());

    //Fecha aplicacion
    txtListChild = (TextView) convertView.findViewById(R.id.tv_fechaApl);
    txtListChild.setText("Fecha Aplic: "+vacunaHijo.getFecha_aplicacion());

    //Edad
    txtListChild = (TextView) convertView.findViewById(R.id.tv_edad);
    txtListChild.setText("Edad: " + vacunaHijo.getEdad());

    //Lote
    txtListChild = (TextView) convertView.findViewById(R.id.tv_lote);
    txtListChild.setText("Lote: " + vacunaHijo.getLote());

    //Responsable
    txtListChild = (TextView) convertView.findViewById(R.id.tv_responsable);
    txtListChild.setText("Responsable: " + vacunaHijo.getResponsable());

    ImageView imgListChild = (ImageView) convertView.findViewById(R.id.iv_vacunas);

    Calculador calc = new Calculador();
    if(vacunaHijo.getAplicado() == 1) {
      imgListChild.setImageResource(R.drawable.check_ok);
    }
    else if (calc.vencido(vacunaHijo.getFecha_programada(), vacunaHijo.getMes_aplicacion())){

      imgListChild.setImageResource(R.drawable.no_check);

    }
    else {
      imgListChild.setImageResource(R.drawable.not_yet);
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
