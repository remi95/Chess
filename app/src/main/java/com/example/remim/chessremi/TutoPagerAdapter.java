package com.example.remim.chessremi;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class TutoPagerAdapter extends PagerAdapter {

  private Context mContext;
  private LayoutInflater mLayoutInflater;
  private ArrayList<TutoPage> tutoPages;

  public TutoPagerAdapter(Context context, ArrayList<TutoPage> tutoPages) {
    this.mContext = context;
    this.mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    this.tutoPages = tutoPages;
  }

  @Override
  public Object instantiateItem(ViewGroup container, int position) {
    TutoPage tuto = tutoPages.get(position);
    View tutoView = mLayoutInflater.inflate(R.layout.item_tuto, container, false);

    TextView pieceName = tutoView.findViewById(R.id.piece_name);
    ImageView image = tutoView.findViewById(R.id.tuto_img);
    TextView description = tutoView.findViewById(R.id.tuto_description);
    TextView pageNumber = tutoView.findViewById(R.id.page_number);

    String currentPage = String.valueOf(position + 1);
    String totalPages = String.valueOf(this.getCount());
    String pagenumberText = currentPage + "/" + totalPages;

    pieceName.setText(tuto.getPiece());
    image.setImageResource(tuto.getImage());
    description.setText(tuto.getDescription());
    pageNumber.setText(pagenumberText);

    container.addView(tutoView);

    return tutoView;
  }

  @Override
  public int getCount() {
    return tutoPages.size();
  }

  @Override
  public void destroyItem(ViewGroup container, int position, Object object) {
    container.removeView((View) object);
  }

  @Override
  public boolean isViewFromObject(View view, Object object) {
    return view == ((View) object);
  }
}
