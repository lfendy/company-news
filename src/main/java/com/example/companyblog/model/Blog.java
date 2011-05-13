/*    */ package com.example.companyblog.model;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.Collections;
/*    */ import java.util.LinkedList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class Blog
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 4765516104300565199L;
/* 13 */   private LinkedList<Article> articles = new LinkedList();
/*    */ 
/*    */   void postArticle(Article article)
/*    */   {
/* 20 */     this.articles.addFirst(article);
/*    */   }
/*    */ 
/*    */   public List<Article> getArticles() {
/* 24 */     return Collections.unmodifiableList(this.articles);
/*    */   }
/*    */ }

/* Location:           /users/flessa/Desktop/war/WEB-INF/classes/
 * Qualified Name:     com.example.companyblog.model.Blog
 * JD-Core Version:    0.6.0
 */