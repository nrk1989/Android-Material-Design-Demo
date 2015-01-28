/**
 * SlideMenuAdapter.java
 *
 * An adapter for the slide menu.
 *
 * @category Contus
 * @package material.example.raj.com.materialdesignexample.adapter
 * @version 1.0
 * @author Contus Team <developers@contus.in>
 * @copyright Copyright (C) 2015 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0 
 */

package material.example.raj.com.materialdesignexample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import material.example.raj.com.materialdesignexample.R;

public class SlideMenuAdapter extends BaseAdapter {

    private Context mContext;
    private String[] menus;

    private ViewHolder mViewHolder;

    private class ViewHolder {
        private TextView txtSlideMenu;
    }

    public SlideMenuAdapter(Context mContext) {
        this.mContext = mContext;
        menus = mContext.getResources().getStringArray(R.array.slide_menus);
    }

    @Override
    public int getCount() {
        return menus.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        mViewHolder = new ViewHolder();
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_slide_menu, null);
            mViewHolder.txtSlideMenu = (TextView) convertView.findViewById(R.id.txtSlideMenu);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }
        mViewHolder.txtSlideMenu.setText(menus[position]);
        return convertView;
    }
}
