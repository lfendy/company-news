/*    */ package com.example.companyblog.model;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.Date;
/*    */ 
/*    */ public class Article
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = -8984371782422340342L;
/*    */   private String title;
/*    */   private String body;
/*    */   private Date createDate;
/*    */ 
/*    */   public Article(String title, String body, Date createDate)
/*    */   {
/* 15 */     this.title = title;
/* 16 */     this.body = body;
/* 17 */     this.createDate = createDate;
/*    */   }
/*    */ 
/*    */   public String getTitle() {
/* 21 */     return this.title;
/*    */   }
/*    */ 
/*    */   public String getBody() {
/* 25 */     return this.body;
/*    */   }
/*    */ 
/*    */   public Date getCreateDate() {
/* 29 */     return this.createDate;
/*    */   }
/*    */ }

/* Location:           /users/flessa/Desktop/war/WEB-INF/classes/
 * Qualified Name:     com.example.companyblog.model.Article
 * JD-Core Version:    0.6.0
 */