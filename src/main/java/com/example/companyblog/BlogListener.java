package com.example.companyblog;

import com.example.companyblog.model.Blog;
import org.prevayler.Prevayler;
import org.prevayler.PrevaylerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.IOException;

public class BlogListener implements ServletContextListener {
    Prevayler prevayler;

    public void contextInitialized(ServletContextEvent event) {
        System.out.println("Setting up Prevayler.");
        try {
            String dbPath = loadDbPath();
            this.prevayler = PrevaylerFactory.createPrevayler(new Blog(), dbPath);
            event.getServletContext().setAttribute("PREVAYLER", this.prevayler);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private String loadDbPath() {
        String dbPath = System.getProperty("prevayler.db.path");
        if (dbPath == null || dbPath.trim().length() == 0) {
            throw new RuntimeException("This application expects the system property 'prevayler.db.path' to be set.");
        }
        return dbPath;
    }

    public void contextDestroyed(ServletContextEvent event) {
        System.out.println("Tearing down Prevayler.");
        try {
            this.prevayler.takeSnapshot();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}