package hello.servlet.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // [status-line]
        response.setStatus(HttpServletResponse.SC_OK);

        // [response-header]
        response.setHeader("Content-Type", "text/plain;charset=utf-8");
//        response.setHeader("Content-Type", "text/plain");
        response.setHeader("Cache-Control", "no-cache, no-store, no-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("my-header", "hello");

        PrintWriter writer = response.getWriter();
        writer.write("안녕하세요");

        // [Header-편의 메서드]
//        content(response);
//        cookie(response);
        redirect(response);
    }

    private void content(HttpServletResponse response) {
        response.setHeader("Content-Type", "text/plain");
        response.setCharacterEncoding("utf-8");
//        response.setContentLength(2);

    }

    private void cookie(HttpServletResponse response) {
//        response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600); // 600초
        response.addCookie(cookie);
    }

    private void redirect(HttpServletResponse response) throws IOException {
        // Status Code 302
        // Location: /basic/hello-form.html
//        response.setStatus(HttpServletResponse.SC_FOUND);
//        response.setHeader("Location", "/basic/hello-form.html");
        response.sendRedirect("/basic/hello-form.html");
    }
}
