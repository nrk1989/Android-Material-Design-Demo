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

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.graphics.Palette;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import material.example.raj.com.materialdesignexample.R;

public class PaletteFragment extends Fragment {

    View viewPalette;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_palette, container,
                false);
        viewPalette = (View) contentView.findViewById(R.id.viewPalette);

        Bitmap palettedBitmap = BitmapFactory.decodeResource(getResources(),
                R.drawable.bg_sample);

        Palette.generateAsync(palettedBitmap, new Palette.PaletteAsyncListener() {

            @Override
            public void onGenerated(Palette palette) {
                Palette.Swatch vibrant = palette.getVibrantSwatch();
                viewPalette.setBackgroundColor(palette
                        .getDarkVibrantColor(Color.parseColor("#ffffff")));
            }
        });

        return contentView;
    }

}
