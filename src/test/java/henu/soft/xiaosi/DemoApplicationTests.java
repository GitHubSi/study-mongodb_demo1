package henu.soft.xiaosi;

import henu.soft.xiaosi.pojo.Comment;
import henu.soft.xiaosi.service.CommentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    CommentService commentService;

    @Test
    void contextLoads() {
    }

    @Test
    void testFindAll(){
        List<Comment> commentList = commentService.findCommentList();
        System.out.println(commentList);
    }

    @Test
    void testSaveComment(){
        Comment comment=new Comment();
        //comment.setArticleid("100000");
        comment.setId("192");
        comment.setContent("我是迪丽热巴");
        comment.setCreatedatetime(LocalDateTime.now());
        comment.setUserid("1003");
        comment.setNickname("dlrb");
        comment.setState("1");
        comment.setLikenum(0);
        comment.setReplynum(0);
        commentService.saveComment(comment);
    }

    @Test
    void testFindCommentListByParentid(){
        Page<Comment> page = commentService.findCommentListByParentid("3", 1, 2);
        System.out.println(page.getTotalElements());
        System.out.println(page.getContent());
    }

    @Test
    void testUpdateCommentLikenum(){
        commentService.updateCommentLikenum("192");
    }


}
