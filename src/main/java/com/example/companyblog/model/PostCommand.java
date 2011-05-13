/*    */ package com.example.companyblog.model;
/*    */ 
/*    */ import java.util.Date;
/*    */ import org.prevayler.Transaction;
/*    */ 
/*    */ public class PostCommand
/*    */   implements Transaction
/*    */ {
/*    */   private static final long serialVersionUID = -3637435757951084285L;
/*    */   private String title;
/*    */   private String body;
/*    */ 
/*    */   public PostCommand(String title, String body)
/*    */   {
/* 17 */     this.title = title;
/* 18 */     this.body = body;
/*    */   }
/*    */ 
/*    */   public void executeOn(Object prevalentSystem, Date executionTime) {
/* 22 */     Blog blog = (Blog)prevalentSystem;
/* 23 */     blog.postArticle(new Article(this.title, this.body, new Date()));
/*    */   }
/*    */ }

/* Location:           /users/flessa/Desktop/war/WEB-INF/classes/
 * Qualified Name:     com.example.companyblog.model.PostCommand
 * JD-Core Version:    0.6.0
 */