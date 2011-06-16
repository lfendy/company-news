package com.example.companyblog;

import com.example.companyblog.model.PostCommand;

public class PostAction extends BlogAction {
    private String body;
    private String title;

    public String execute() {
        if ((this.title != null) && (this.body != null)) {
            prevayler().execute(new PostCommand(this.title, this.body));
            return "success";
        }
        return "input";
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
