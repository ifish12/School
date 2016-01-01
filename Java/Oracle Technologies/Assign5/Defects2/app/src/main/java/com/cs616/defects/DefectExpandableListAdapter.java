package com.cs616.defects;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cs616.defects.model.Defect;
import com.cs616.defects.model.SeverityColor;
import com.cs616.defects.model.Status;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ian on 15-10-28.
 */
public class DefectExpandableListAdapter extends BaseExpandableListAdapter {

    private List<List<Defect>> groups;
    private Context context;

    private interface Predicate<T> {
        boolean f(T item);
    }

    private <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for(T element : list)
            if(predicate.f(element))
                result.add(element);
        return result;
    }

    /**
     * Create an adapter for defects, grouped by Status
     * @param context
     * @param defects
     */
    public DefectExpandableListAdapter(Context context, List<Defect> defects) {
        this.context = context;
        groups = new ArrayList<>();
        for(final Status status : Status.values())
            groups.add(filter(defects, new Predicate<Defect>() {
                @Override
                public boolean f(Defect item) {
                    return item.getStatus() == status;
                }
            }));
    }


    @Override
    public int getGroupCount() {
        return groups.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return groups.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groups.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return groups.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        View groupView;
        if(convertView != null)
            groupView = convertView;
        else {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            groupView = inflater.inflate(R.layout.list_group_defect, parent, false);
        }

        Status status = Status.values()[groupPosition];

        TextView statusTextView = (TextView) groupView.findViewById(R.id.statusTextView_List_Group);
        statusTextView.setText(status.toString());

        return groupView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        View rowView;
        if(convertView != null)
            rowView = convertView;
        else {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.list_row_defect, parent, false);
        }

        Defect defect = groups.get(groupPosition).get(childPosition);

        // set the background of the row to the severity color
        LinearLayout defectLinearLayout = (LinearLayout) rowView.findViewById(R.id.defectLinearLayout_List_Row);
        defectLinearLayout.setBackgroundColor(SeverityColor.get(defect.getSeverity()));

        // set the image to the default image
        ImageView userImageView = (ImageView) rowView.findViewById(R.id.userImageView_List_Row);
        userImageView.setImageResource(R.mipmap.ic_launcher);

        // set the summary
        TextView summaryTextView = (TextView) rowView.findViewById(R.id.summaryTextView_List_Row);
        summaryTextView.setText(defect.getSummary());

        return rowView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
