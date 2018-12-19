package com.example.administrator.appctct.Adapter.AdapterBookDetail;

import android.support.annotation.NonNull;
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
import com.example.administrator.appctct.Entity.BookDetail.BookExtened;
import com.example.administrator.appctct.Entity.BookDetail.InformationBook;
import com.example.administrator.appctct.Entity.BookDetail.TitleBook;
import com.example.administrator.appctct.Fragment.FragmentListBook.Fragment_line_viewcontroller;
import com.example.administrator.appctct.Fragment.FragmentListBook.clickLineController;
import com.example.administrator.appctct.R;

import java.util.ArrayList;

public class AdapterBookDetail extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private LayoutInflater inflater;
    private BookDetail bookDetail;
    private ArrayList<BookComment> listComment;
    private BookExtened bookExtened;
    private FragmentManager fragmentManager;
    private OnLoadMorebookDetail onLoadMore;
    private boolean isLoadingComment = false;
    private boolean isLoadingBookExtened = false;
    private ClickToSeeDocument listenedClickToSeeDocument;

    public void setListenedClickToSeeDocument(ClickToSeeDocument listenedClickToSeeDocument){
        this.listenedClickToSeeDocument = listenedClickToSeeDocument;
    }

    public AdapterBookDetail(RecyclerView recyclerView,LayoutInflater inflater,FragmentManager fragmentManager) {

        this.inflater = inflater;
        this.fragmentManager = fragmentManager;
        final LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (manager != null) {
                    int currentVisible = manager.getItemCount();
                    if (!isLoadingComment && currentVisible == 1) {
                        isLoadingComment = true;
                        onLoadMore.onLoadMoreComment();
                    }
                    if (!isLoadingBookExtened && currentVisible == 2) {
                        isLoadingBookExtened = true;
                        onLoadMore.onLoadMoreBookExtened();
                    }
                }
            }
        });
    }

    public void setOnLoadMore(OnLoadMorebookDetail onLoadMore){
        this.onLoadMore = onLoadMore;
    }

    public void setBookDetail(BookDetail bookDetail) {
        this.bookDetail = bookDetail;
        notifyDataSetChanged();
    }

    public void setListComment(ArrayList<BookComment> listComment){
        this.listComment = listComment;
        notifyItemChanged(2);
    }

    public void setBookExtened(BookExtened bookExtened){
        this.bookExtened = bookExtened;
        notifyItemChanged(3);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        switch (i) {
            case 0:
                view = inflater.inflate(R.layout.line_first_information_book, viewGroup, false);
                return new HolderTitleBook(view);
            case 1:
                view = inflater.inflate(R.layout.line_two_information_book, viewGroup, false);
                return new HolderInformationBook(view);
            case 2:
                view = inflater.inflate(R.layout.line_three_information_book, viewGroup, false);
                return new HolderBookComment(view);
            default:
                view = inflater.inflate(R.layout.line_four_information_book, viewGroup, false);
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
            case 3:
                return 3;
                default:
                    return -1;
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
                if (listComment != null) {
                    HolderBookComment holderBookComment = (HolderBookComment) viewHolder;
                    holderBookComment.bind(listComment);
                }
                break;
            case 3:
                if (bookExtened != null) {
                    HolderBookExtened holderBookExtened = (HolderBookExtened) viewHolder;
                    holderBookExtened.bind(bookExtened.getListBookRatio(), bookExtened.getListBookSame());
                    break;
                }
        }
    }

    @Override
    public int getItemCount() {
        if (bookExtened != null){
            return 4;
        }
        if (listComment != null ){
            return 3;
        }

        if (bookDetail != null) {
            return 2;
        }
        return  0;
    }


    class HolderTitleBook extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imgAVTBook;
        TextView tvNameBook,tvRatioBook,tvClickToSeeTheDocument;
        RatingBar rbRatioBook;
        HolderTitleBook(@NonNull View itemView) {
            super(itemView);
            imgAVTBook = itemView.findViewById(R.id.imgAVTBook);
            tvNameBook = itemView.findViewById(R.id.tvNameBook);
            tvRatioBook = itemView.findViewById(R.id.tvRatioBook);
            rbRatioBook = itemView.findViewById(R.id.rbRatioBook);
            tvClickToSeeTheDocument = itemView.findViewById(R.id.tvClickToSeeTheDocument);
            tvClickToSeeTheDocument.setOnClickListener(this);
        }
        void bind(TitleBook data){
            Glide.with(inflater.getContext())
                    .load(data.getImgBook())
                    .into(imgAVTBook);
            tvNameBook.setText(data.getNameBook());
            rbRatioBook.setRating(data.getRatioBook());
            tvRatioBook.setText(String.valueOf("("+data.getRatioBook()+")"));
        }

        @Override
        public void onClick(View v) {
            listenedClickToSeeDocument.click("");
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
            tvInformationBook.setText(data.getContent());
            tvDateuploadBook.setText(data.getDateupload());
        }
    }

    class HolderBookComment extends RecyclerView.ViewHolder implements View.OnClickListener{
        RecyclerView rcComment;
        TextView tvAddComment;
        AdapterComment apdater;
        HolderBookComment(@NonNull View itemView) {
            super(itemView);
            rcComment = itemView.findViewById(R.id.rcComment);
            tvAddComment = itemView.findViewById(R.id.tvAddComment);
            LinearLayoutManager manager = new LinearLayoutManager(inflater.getContext(),LinearLayoutManager.VERTICAL,false);
            rcComment.setLayoutManager(manager);
            apdater = new AdapterComment(inflater,new ArrayList<BookComment>());
            rcComment.setAdapter(apdater);
            tvAddComment.setOnClickListener(this);
        }

        void bind(ArrayList<BookComment> listComment){
            if (listComment.size() > 0) {
                apdater.setListComment(listComment);
            }
        }

        @Override
        public void onClick(View v) {
            Log.d("AAAA","click comment");
        }
    }

    class HolderBookExtened extends RecyclerView.ViewHolder implements clickLineController {

        Fragment_line_viewcontroller viewSame,viewTop;

        HolderBookExtened(@NonNull View itemView) {
            super(itemView);
            viewSame = (Fragment_line_viewcontroller) fragmentManager.findFragmentById(R.id.fragmentTheSame);
            viewTop = (Fragment_line_viewcontroller) fragmentManager.findFragmentById(R.id.fragmentTheTop);
            viewTop.setTitle(inflater.getContext().getResources().getString(R.string.booktop));
            viewSame.setTitle(inflater.getContext().getResources().getString(R.string.booksame));
            viewSame.setListenedClick(this);
            viewTop.setListenedClick(this);
            itemView.setVisibility(View.GONE);
        }

        void bind(ArrayList<Book> bookTop, ArrayList<Book> bookSame) {
            if (bookTop.size() > 0 || bookSame.size() > 0 ){
                itemView.setVisibility(View.VISIBLE);
            }
            viewTop.setListBook(bookTop);
            viewSame.setListBook(bookSame);
        }

        @Override
        public void clickLinePosition(String idBook) {
            Log.d("AAAA",idBook);
        }
    }
//
//    class HolderLoading extends RecyclerView.ViewHolder{
//        ProgressBar loading;
//        public HolderLoading(@NonNull View itemView) {
//            super(itemView);
//            loading = itemView.findViewById(R.id.pbLoading);
//        }
//    }
}
