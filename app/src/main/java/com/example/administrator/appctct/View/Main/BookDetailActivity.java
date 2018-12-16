package com.example.administrator.appctct.View.Main;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.appctct.Entity.Book;
import com.example.administrator.appctct.Entity.BookDetail.BookComment;
import com.example.administrator.appctct.Entity.BookDetail.BookDetail;
import com.example.administrator.appctct.Entity.BookDetail.InformationBook;
import com.example.administrator.appctct.Entity.BookDetail.TitleBook;
import com.example.administrator.appctct.Fragment.FragmentBookDetail.FragmentInfomationBook;
import com.example.administrator.appctct.R;

import java.util.ArrayList;

public class BookDetailActivity extends AppCompatActivity {

    FragmentInfomationBook viewInformationBook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
        setID();
        setupView();
    }

    private void setID(){
        viewInformationBook = (FragmentInfomationBook) getSupportFragmentManager().findFragmentById(R.id.fragmentInformationBook);
    }
    private void setupView(){
        TitleBook titleBook = new TitleBook("https://upload.wikimedia.org/wikipedia/vi/thumb/f/f8/Toithayhoavangtrencoxanh.jpg/280px-Toithayhoavangtrencoxanh.jpg","Tôi thấy hoa vàng trên cỏ xanh", (float) 4.5);
        InformationBook informationBook = new InformationBook("Nguyễn Nhật Ánh","NXB Trẻ","TOP 100 BEST SELLER -Những câu chuyện nhỏ xảy ra ở một ngôi làng nhỏ: chuyện người, chuyện cóc, chuyện ma, chuyện công chúa và hoàng tử , rồi chuyện đói ăn, cháy nhà, lụt lội,... Bối cảnh là trường học, nhà trong xóm, bãi tha ma. Dẫn chuyện là cậu bé 15 tuổi tên Thiều. Thiều có chú ruột là chú Đàn, có bạn thân là cô bé Mận. Nhưng nhân vật đáng yêu nhất lại là Tường, em trai Thiều, một cậu bé học không giỏi. Thiều, Tường và những đứa trẻ sống trong cùng một làng, học cùng một trường, có biết bao chuyện chung. Chúng nô đùa, cãi cọ rồi yêu thương nhau, cùng lớn lên theo năm tháng, trải qua bao sự kiện biến cố của cuộc đời.","17/10/2018");
        BookComment bookComment1 = new BookComment("http://www.top-madagascar.com/assets/images/admin/user-admin.png","Nguyễn Ngọc Châu",(float) 4,"Sách hay lắm");
        BookComment bookComment2 = new BookComment("http://www.top-madagascar.com/assets/images/admin/user-admin.png","Dương Ánh Hiền",(float) 3,"Sách hay lắm luôn các bạn nên đọc");
        BookComment bookComment3 = new BookComment("http://www.top-madagascar.com/assets/images/admin/user-admin.png","Meo Meo",(float) 4,"Sách hay lắm luôn luôn á");
        BookComment bookComment4 = new BookComment("http://www.top-madagascar.com/assets/images/admin/user-admin.png","Tên Tớ Hay Không",(float) 2,"Sách hay lắm không thể tin được");
        ArrayList<BookComment> listComment = new ArrayList<>();
        listComment.add(bookComment1);
        listComment.add(bookComment2);
        listComment.add(bookComment3);
        listComment.add(bookComment4);
        ArrayList<Book> listBookTop = new ArrayList<>();
        listBookTop.add(new Book("Sách 1","4"));
        listBookTop.add(new Book("Sách 1","5"));
        listBookTop.add(new Book("Sách 1","3"));
        ArrayList<Book> listBookSame = new ArrayList<>();
        listBookSame.add(new Book("Sách 2","4"));
        listBookSame.add(new Book("Sách 2",  "3"));
        listBookSame.add(new Book("Sách 2","3"));
        ArrayList<Book> listBookRatio = new ArrayList<>();
        listBookRatio.add(new Book("Sách 3","4"));
        listBookRatio.add(new Book("Sách 3","5"));
        listBookRatio.add(new Book("Sách 3","3"));
        BookDetail bookDetail = new BookDetail(titleBook,informationBook,listComment,listBookTop,listBookSame,listBookRatio);
        viewInformationBook.setBookDetail(bookDetail);
    }
}
