package com.example.administrator.appctct.Adapter.AdapterBookDetail;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.appctct.Entity.Book;
import com.example.administrator.appctct.Entity.BookDetail.BookComment;
import com.example.administrator.appctct.Entity.BookDetail.BookDetail;
import com.example.administrator.appctct.Entity.BookDetail.InformationBook;
import com.example.administrator.appctct.Entity.BookDetail.TitleBook;
import com.example.administrator.appctct.Fragment.FragmentListBook.Fragment_line_viewcontroller;
import com.example.administrator.appctct.Fragment.FragmentListBook.clickLineController;
import com.example.administrator.appctct.R;

import java.util.ArrayList;

public class AdapterBookDetail extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private LayoutInflater inflater;
    private BookDetail bookDetail;
    private FragmentManager fragmentManager;

    public AdapterBookDetail(LayoutInflater inflater, BookDetail bookDetail,FragmentManager fragmentManager) {
        this.inflater = inflater;
        this.bookDetail = bookDetail;
        this.fragmentManager = fragmentManager;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        switch (i){
            case 0:
                view = inflater.inflate(R.layout.line_first_information_book,viewGroup,false);
                return new HolderTitleBook(view);
            case 1:
                view = inflater.inflate(R.layout.line_two_information_book,viewGroup,false);
                return new HolderInformationBook(view);
            case 2:
                view = inflater.inflate(R.layout.line_three_information_book,viewGroup,false);
                return new HolderBookComment(view);
                default:
                    view = inflater.inflate(R.layout.line_four_information_book,viewGroup,false);
                    return new HolderBookExtened(view);
        }
    }

    @Override
    public int getItemViewType(int position) {
        switch (position){
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
                default:
                    return 3;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        switch (viewHolder.getItemViewType()){
            case 0:
                HolderTitleBook holderTitleBook = (HolderTitleBook) viewHolder;
                holderTitleBook.bind(bookDetail.getTitleBook());
                break;
            case 1:
                HolderInformationBook holderInformationBook = (HolderInformationBook) viewHolder;
                holderInformationBook.bind(bookDetail.getInformationBook());
                break;
            case 2:
                HolderBookComment holderBookComment = (HolderBookComment) viewHolder;
                holderBookComment.bind(bookDetail.getListComment());
                break;
                default:
                    HolderBookExtened holderBookExtened = (HolderBookExtened) viewHolder;
                    holderBookExtened.bind(bookDetail.getListBookTop(),bookDetail.getListBookSame(),bookDetail.getListBookRatio());
                    break;
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    class HolderTitleBook extends RecyclerView.ViewHolder{
        ImageView imgAVTBook;
        TextView tvNameBook,tvRatioBook;
        RatingBar rbRatioBook;
        HolderTitleBook(@NonNull View itemView) {
            super(itemView);
            imgAVTBook = itemView.findViewById(R.id.imgAVTBook);
            tvNameBook = itemView.findViewById(R.id.tvNameBook);
            tvRatioBook = itemView.findViewById(R.id.tvRatioBook);
            rbRatioBook = itemView.findViewById(R.id.rbRatioBook);
        }
        void bind(TitleBook data){
            Glide.with(inflater.getContext())
                    .load(data.getImgBook())
                    .into(imgAVTBook);
            tvNameBook.setText(data.getNameBook());
            rbRatioBook.setRating(Float.valueOf(data.getRatioBook()));
            tvRatioBook.setText(String.valueOf("("+data.getRatioBook()+")"));
        }
    }

    class HolderInformationBook extends RecyclerView.ViewHolder{
        TextView tvNameAuthor,tvNameKind,tvInformationBook,tvDateuploadBook;

        HolderInformationBook(@NonNull View itemView) {
            super(itemView);
            tvNameAuthor = itemView.findViewById(R.id.tvNameAuthor);
            tvNameKind = itemView.findViewById(R.id.tvNameKind);
            tvInformationBook = itemView.findViewById(R.id.tvInfomationBook);
            tvDateuploadBook = itemView.findViewById(R.id.tvDateUpLoaddBook);
        }

        void bind(InformationBook data){
            tvNameAuthor.setText(data.getNameAuthor());
            tvNameKind.setText(data.getKind());
            tvInformationBook.setText(data.getInformation());
            tvDateuploadBook.setText(data.getDateupload());
        }
    }

    class HolderBookComment extends RecyclerView.ViewHolder implements View.OnClickListener{
        RecyclerView rcComment;
        TextView tvNoComment;
        TextView tvAddComment;
        AdapterComment apdater;
        HolderBookComment(@NonNull View itemView) {
            super(itemView);
            rcComment = itemView.findViewById(R.id.rcComment);
            tvNoComment = itemView.findViewById(R.id.tvNoComment);
            rcComment.setVisibility(View.GONE);
            tvAddComment = itemView.findViewById(R.id.tvAddComment);
            LinearLayoutManager manager = new LinearLayoutManager(inflater.getContext(),LinearLayoutManager.VERTICAL,false);
            rcComment.setLayoutManager(manager);
            apdater = new AdapterComment(inflater,new ArrayList<BookComment>());
            rcComment.setAdapter(apdater);
            tvAddComment.setOnClickListener(this);
        }
        void bind(ArrayList<BookComment> listComment){
            apdater.setListComment(listComment);
            rcComment.setVisibility(View.VISIBLE);
            tvNoComment.setVisibility(View.INVISIBLE);
        }

        @Override
        public void onClick(View v) {
            Log.d("AAAA","click comment");
        }
    }

    class HolderBookExtened extends RecyclerView.ViewHolder implements clickLineController {

        Fragment_line_viewcontroller viewSame,viewTop,viewRatio;

        HolderBookExtened(@NonNull View itemView) {
            super(itemView);
            viewSame = (Fragment_line_viewcontroller) fragmentManager.findFragmentById(R.id.fragmentTheSame);
            viewTop = (Fragment_line_viewcontroller) fragmentManager.findFragmentById(R.id.fragmentTheTop);
            viewRatio = (Fragment_line_viewcontroller) fragmentManager.findFragmentById(R.id.fragmentRatio);
            viewTop.setTitle(inflater.getContext().getResources().getString(R.string.booktop));
            viewSame.setTitle(inflater.getContext().getResources().getString(R.string.booksame));
            viewRatio.setTitle(inflater.getContext().getResources().getString(R.string.bookratio));
            viewRatio.setListenedClick(this);
            viewSame.setListenedClick(this);
            viewTop.setListenedClick(this );
        }

        void bind(ArrayList<Book> bookTop, ArrayList<Book> bookSame,ArrayList<Book> bookRatio) {
            viewTop.setListBook(bookTop);
            viewSame.setListBook(bookSame);
            viewRatio.setListBook(bookRatio);
        }

        @Override
        public void clickLinePosition(View view, int position) {
            switch (view.getId()){
                case R.id.fragmentTheSame:
                    Log.d("AAA","click 2");
                    break;
                case R.id.fragmentTheTop:
                    Log.d("AAA","click 1");
                    break;
                case R.id.fragmentRatio:
                    Log.d("AAA","click 3");
                    break;
            }
        }
    }
}
