/*    */ package com.example.companyblog;
/*    */ 
/*    */ import com.example.companyblog.model.Article;
/*    */ import com.example.companyblog.model.Blog;
/*    */ import java.util.List;
/*    */ 
/*    */ public class ReadAction extends BlogAction
/*    */ {
/*    */   public List<Article> getArticles()
/*    */   {
/* 11 */     return blog().getArticles();
/*    */   }
/*    */ }

/* Location:           /users/flessa/Desktop/war/WEB-INF/classes/
 * Qualified Name:     com.example.companyblog.ReadAction
 * JD-Core Version:    0.6.0
 */