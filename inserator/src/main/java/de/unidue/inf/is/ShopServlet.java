package de.unidue.inf.is;

import de.unidue.inf.is.domain.Adv;
import de.unidue.inf.is.entity.User;
import de.unidue.inf.is.stores.AdvStore;
import de.unidue.inf.is.stores.UserStore;
import de.unidue.inf.is.utils.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class ShopServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentUser = request.getParameter("currentUser");

        List<Adv> advList = null;
        try (AdvStore advStore = new AdvStore()) {
            advList =  advStore.selectAllAdv();
            advStore.complete();
        }

        request.setAttribute("advList", advList);
        request.setAttribute("currentUser", currentUser);

        request.getRequestDispatcher("/shop.ftl").forward(request, response);
    }



}
