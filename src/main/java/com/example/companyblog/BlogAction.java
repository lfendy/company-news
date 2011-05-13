/*    */ package com.example.companyblog;
/*    */ 
/*    */ import com.example.companyblog.model.Blog;
/*    */ import com.opensymphony.xwork2.ActionContext;
/*    */ import com.opensymphony.xwork2.ActionSupport;
/*    */ import java.util.Map;
/*    */ import org.prevayler.Prevayler;
/*    */ 
/*    */ public abstract class BlogAction extends ActionSupport
/*    */ {
/*    */   public Blog blog()
/*    */   {
/* 17 */     return (Blog)prevayler().prevalentSystem();
/*    */   }
/*    */ 
/*    */   public Prevayler prevayler() {
/* 21 */     Map application = ActionContext.getContext().getApplication();
/* 22 */     return (Prevayler)application.get("PREVAYLER");
/*    */   }
/*    */ }

/* Location:           /users/flessa/Desktop/war/WEB-INF/classes/
 * Qualified Name:     com.example.companyblog.BlogAction
 * JD-Core Version:    0.6.0
 */