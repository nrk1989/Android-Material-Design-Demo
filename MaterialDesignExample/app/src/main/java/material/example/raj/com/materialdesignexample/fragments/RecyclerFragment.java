/**
 * RecyclerFragment.java
 *
 * An fragment for recycler view demo.
 *
 * @category Contus
 * @package material.example.raj.com.materialdesignexample.fragments
 * @version 1.0
 * @author Contus Team <developers@contus.in>
 * @copyright Copyright (C) 2015 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0 
 */

package material.example.raj.com.materialdesignexample.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import material.example.raj.com.materialdesignexample.MyAdapter;
import material.example.raj.com.materialdesignexample.R;

public class RecyclerFragment extends Fragment{

    private RecyclerView mRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_recycler, container,
                false);
        mRecyclerView = (RecyclerView) contentView.findViewById(R.id.recylerView);
        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        MyAdapter listAdapter = new MyAdapter(new String[]{"Raj", "Kumar", "Mani"});
        mRecyclerView.setAdapter(listAdapter);

        return contentView;
    }

}
