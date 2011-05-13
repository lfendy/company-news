/*    */ package com.example.companyblog;
/*    */ 
/*    */ import com.example.companyblog.model.PostCommand;
/*    */ import org.prevayler.Prevayler;
/*    */ 
/*    */ public class PostAction extends BlogAction
/*    */ {
/*    */   private String body;
/*    */   private String title;
/*    */ 
/*    */   public String execute()
/*    */   {
/* 12 */     if ((this.title != null) && (this.body != null)) {
/* 13 */       prevayler().execute(new PostCommand(this.title, this.body));
/* 14 */       return "success";
/*    */     }
/* 16 */     return "input";
/*    */   }
/*    */ 
/*    */   public String getBody()
/*    */   {
/* 21 */     return this.body;
/*    */   }
/*    */ 
/*    */   public void setBody(String body) {
/* 25 */     this.body = body;
/*    */   }
/*    */ 
/*    */   public String getTitle() {
/* 29 */     return this.title;
/*    */   }
/*    */ 
/*    */   public void setTitle(String title) {
/* 33 */     this.title = title;
/*    */   }
/*    */ }

/* Location:           /users/flessa/Desktop/war/WEB-INF/classes/
 * Qualified Name:     com.example.companyblog.PostAction
 * JD-Core Version:    0.6.0
 */